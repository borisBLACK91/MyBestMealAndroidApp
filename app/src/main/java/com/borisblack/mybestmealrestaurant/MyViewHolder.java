package com.borisblack.mybestmealrestaurant;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView itemName, itemCost;
    private ImageView itemPicture;

    public CardView myCardView;

    public MyViewHolder(@NonNull View itemView){
        super(itemView);
        itemName = itemView.findViewById(R.id.itemName);
        itemCost = itemView.findViewById(R.id.itemCost);
        itemPicture = itemView.findViewById(R.id.itemPicture);

        myCardView = itemView.findViewById(R.id.itemCardView);
        myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showItelDetails(view);
            }
        });
    }

    private void showItelDetails(View view) {
        //here we will describe each item of our menu
        int index = (int) view.getTag();
        String details = "";
        switch (index){

            case 0:
                details = "The French beef stake is one of our favourite meal." + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 1:
               details = "The Senegalese mix will bring you in an intense travel around west Africa." +
                        "This mix of different meals from Senegal is just a real please." + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 2:
                details = "If you love the french riviera you should absolutely taste this special meal!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 3:
                details = "Do you want to travel in Asia without leaving Paris? If yes, this one is for you." +
                        " Please Try this wonderful rice from Vietnam." + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 4:
                details = "L'italia bella, la cucina del mondo." +
                        " This special meal from Italy will be a special and exiting experience for you. Dont Wait , try it!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 5:
                details = "Do you want to try fat and tasty sandwich? Dont hesitate this Fat sandwich is made for you!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 6:
                details = "If you want to test all the french food, from the north of the country  to the south, this special meal " +
                        "is actually a good opportunity for you. Dont be shy, try it!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 7:
                details = "This wonderful drink from Cameroon, in the central Africa will bring you in an incredible sensation of pleasure." +
                        "Dont wait, try it and share it with friends!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 8:
                details = "The French saucisses, la belle vie, le barbecue, cest la France!. Try it and you will love it!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;
                break;

            case 9:
                details = "This drink is just amazing. The experience of a unique and special taste. Try it and you will love it!" + "\n" +
                        " You have the possibility to eat on place or take away!" + "\n" +
                        "We know you will love it!" ;

                break;

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Menu description");
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

    public void bind(MenuItem menuItem){
        itemName.setText(menuItem.getMealName());
        itemCost.setText(menuItem.getMealPrice());
        itemPicture.setImageResource(menuItem.getImageDrawable());
        //Picasso.with(itemPicture.getContext()).load(menuItem.getMealImageUrl()).centerCrop().fit().into(itemPicture);
    }

}
