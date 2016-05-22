package com.example.raj.courseworkapp_1541065.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.raj.courseworkapp_1541065.DBHandler;
import com.example.raj.courseworkapp_1541065.ItemData;
import com.example.raj.courseworkapp_1541065.ItemListBaseAdapter;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserScoreData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj on 5/18/2016.
 */
public class LeaderBoardActivity extends HomeActivity
{
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);


        context = getApplicationContext();
        db = new DBHandler(context);

        List<UserScoreData> userScoreDataList = db.getAllUserScore();
        ArrayList<ItemData> item_details = GetSearchResults(userScoreDataList);
        final ListView lv1 = (ListView) findViewById(R.id.list_leader);
        lv1.setAdapter(new ItemListBaseAdapter(this, item_details));
    }

    private ArrayList<ItemData> GetSearchResults(List<UserScoreData> userScoreList){

        this.filterOut(userScoreList);
        ArrayList<ItemData> results = new ArrayList<ItemData>();

        ItemData item_details = new ItemData();
        item_details.setLevelName("Addition");
        item_details.setLevelNo(1);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Subtraction");
        item_details.setLevelNo(2);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Multiply");
        item_details.setLevelNo(3);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Divide");
        item_details.setLevelNo(4);
        results.add(item_details);


        return results;
    }

    private void filterOut (List<UserScoreData> userScoreList){
        //TODO : Remove duplicate userID
        //TODO : Add them to Score

    }
}
