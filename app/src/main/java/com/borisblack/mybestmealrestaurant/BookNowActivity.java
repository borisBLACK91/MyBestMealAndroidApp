package com.borisblack.mybestmealrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookNowActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner numberOfPeople;
    private String[] numbers = {"how many people", "1", "2", "3", "4", "5", "6","7", "8", "9",
            "10", "11", "12", "13", "14", "15", "16", "17", "18"};
    private String choiceSelected = "";
    private EditText dateOfMeal, bookerName, bookerPhoneNumber, reasonForBooking;
    private RadioButton withChildrenYes, withChildrenNo, morning, midday, night;
    private Button submitBooking;
    final Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        }
    };

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        dateOfMeal.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        numberOfPeople = findViewById(R.id.numberOfPeople);
        numberOfPeople.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, numbers);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfPeople.setAdapter(arrayAdapter);

        dateOfMeal = findViewById(R.id.dateOfTheMeal);
        dateOfMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(view.getContext(), date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        submitBooking = findViewById(R.id.submitBookingButton);
        submitBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitBookingToRestaurant();
            }
        });
        bookerName = findViewById(R.id.bookerNameEditText);
        bookerPhoneNumber = findViewById(R.id.bookerPhoneNumberEditText);
        withChildrenYes = findViewById(R.id.yes);
        withChildrenNo = findViewById(R.id.no);
        morning = findViewById(R.id.morning);
        midday = findViewById(R.id.midday);
        night = findViewById(R.id.night);
        reasonForBooking = findViewById(R.id.reasonOfTheMeal);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        choiceSelected = numbers[pos]; //i is the position
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void submitBookingToRestaurant(){
        //this method should normally send an html POST method to a web server with booking details!
        if(bookingDetailsAreFine()) {
            showBookingAcceptedMessageToUser();
        }
    }

    private boolean bookingDetailsAreFine() {
        //here we should check that the user correctly entered the requested booking details!

        if(bookerName==null || bookerName.getText().toString().length()<4){
            Toast.makeText(this, R.string.booker_name_is_invalid, Toast.LENGTH_SHORT).show();
            return false;
        }
        if(bookerPhoneNumber == null || bookerPhoneNumber.getText().toString().length()<8){
            Toast.makeText(this, "booker phone number is invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(reasonForBooking == null || reasonForBooking.getText().toString().length()<8){
            Toast.makeText(this, "reason for booking is invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(choiceSelected.length()==0 || choiceSelected.equals("how many people")){
            Toast.makeText(this, "the number of people is invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(dateOfMeal==null || dateOfMeal.getText().toString().length()!=10){
            //we should normally check also if the date itself is valid, meaning a date in the future!!
            Toast.makeText(this, "the date is invalid!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(withChildrenYes == null && withChildrenNo ==null) {
            Toast.makeText(this, "specify if there will be children!", Toast.LENGTH_SHORT).show();
            return false;
        }
        int checked = 0;
        if(withChildrenYes!=null && withChildrenYes.isChecked()){
            checked = 1;
        }else{
            if(withChildrenNo!=null && withChildrenNo.isChecked()){
                checked = 1;
            }
        }
        if(checked == 0){ //meaning no choice selected!
            Toast.makeText(this, "specify if there will be children!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(withChildrenYes == null && withChildrenNo ==null) {
            Toast.makeText(this, "specify if there will be children!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(morning == null && midday ==null && night==null) {
            Toast.makeText(this, "specify the period of the day!", Toast.LENGTH_SHORT).show();
            return false;
        }
        int periodChecked = 0;
        if(morning!=null && morning.isChecked()){
            periodChecked = 1;
        }else{
            if(midday!=null && midday.isChecked()){
                periodChecked = 1;
            }else{
                if(night!=null && night.isChecked()){
                    periodChecked = 1;
                }
            }
        }
        if(periodChecked == 0){ //meaning no choice selected!
            Toast.makeText(this, "specify the period of the day!", Toast.LENGTH_SHORT).show();
            return false;
        }
        //if the programm reachs this zone it means that the booking details were correctly filled!
        //in a full project with server side, here we should create the post request with all details entered by the application user
        return true;
    }

    private void showBookingAcceptedMessageToUser() {

        String details = "You booking has been correctly saved in our server, we are waiting for you. \nThank you and see you soon!" ;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Booking confirmation");
        builder.setMessage(details);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    //we will not add any action here
            }
        });
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.dialogAnimation_slide_up_down;
        dialog.show();
    }
}