package com.borisblack.mybestmealrestaurant;

public class MenuItem {

    //class attributes
    private String mealName;
    private String mealPrice;
    private int imageDrawable;


    public MenuItem(String mealName, String mealPrice, int imageDrawable) {
        this.mealName = mealName;
        this.mealPrice = mealPrice;
        this.imageDrawable = imageDrawable;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}
