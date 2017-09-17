package com.test.rolodexapp;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private static final String TAG = "ROLODEX";
    private List<FeedItem> feedItemList = new ArrayList<FeedItem>();
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        /* Initialize recycler view */
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));

        parseData();
        adapter = new MyRecyclerViewAdapter(MainActivity.this, feedItemList);
        mRecyclerView.setAdapter(adapter);

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("CardData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void parseData()
    {
        try {
            JSONArray m_jArry = new JSONArray(loadJSONFromAsset());
            feedItemList = new ArrayList<FeedItem>();

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject item = m_jArry.optJSONObject(i);
                String lastName = item.getString("lastName");
                String firstName = item.getString("firstName");
                String email = item.optString("email");
                String company = item.optString("company");
                String startDate = item.optString("startDate");
                String bio = item.optString("bio");
                String avatar = item.optString("avatar");

                FeedItem feedItem = new FeedItem();
                feedItem.setLastName(lastName);
                feedItem.setFirstName(firstName);
                feedItem.setEmail(email);
                feedItem.setCompany(company);
                feedItem.setStartDate(startDate);
                feedItem.setBio(bio);
                feedItem.setAvatar(avatar);
                feedItemList.add(feedItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

