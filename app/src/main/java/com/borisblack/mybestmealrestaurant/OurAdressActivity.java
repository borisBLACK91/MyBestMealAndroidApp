package com.borisblack.mybestmealrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OurAdressActivity extends AppCompatActivity {

    private Button sendMessage;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_adress);

        message = findViewById(R.id.messageText);

        sendMessage = findViewById(R.id.sendMessage);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessageToRestaurant();
            }
        });
    }

    private void sendMessageToRestaurant() {
        if(message!=null && message.getText().toString().length()>5){
            String details = "We correctly received your message.\nThank you very much and see you soon!" ;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Message reception");
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
            message.setText("");
        }
    }
}