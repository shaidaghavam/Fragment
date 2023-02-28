package com.example.fragment.model;

import android.widget.ImageView;

public class DataModel {


    private String title;

    public DataModel(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String title) {
        this.title = title;
        return title;

    }
    private ImageView imageView;
    public DataModel(ImageView imageView){this.imageView=imageView;}
    public ImageView getImageView(){return imageView;}

    public ImageView setTitle(ImageView imageView){
        this.imageView=imageView;
        return imageView;


    }
}
