package com.test.rolodexapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedListRowHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView lastname;
    protected TextView firstname;
    protected TextView bio;
    protected TextView company;
    protected TextView email;
    protected TextView startdate;


    public FeedListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.imageView);
        this.firstname = (TextView) view.findViewById(R.id.firstname);
        this.lastname= (TextView) view.findViewById(R.id.lastname);
        this.bio= (TextView) view.findViewById(R.id.bio);
        this.company= (TextView) view.findViewById(R.id.company);
        this.email= (TextView) view.findViewById(R.id.email);
        this.startdate= (TextView) view.findViewById(R.id.startdate);
    }

}