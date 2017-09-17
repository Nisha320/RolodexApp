package com.test.rolodexapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<FeedListRowHolder> {

    private List<FeedItem> feedItemList;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public FeedListRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        FeedListRowHolder mh = new FeedListRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(FeedListRowHolder feedListRowHolder, int i) {
        FeedItem feedItem = feedItemList.get(i);
        feedListRowHolder.lastname.setText(feedItem.getLastName());
        feedListRowHolder.firstname.setText(feedItem.getFirstName());
        feedListRowHolder.bio.setText(feedItem.getBio());
        feedListRowHolder.company.setText(feedItem.getCompany());
        feedListRowHolder.email.setText(feedItem.getEmail());
        feedListRowHolder.startdate.setText(feedItem.getStartDate());


        Picasso.with(mContext)
                .load(feedItem.getAvatar())
                .placeholder(R.mipmap.placeholder)
                .fit().centerCrop()
                .into(feedListRowHolder.thumbnail);
    }



    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}