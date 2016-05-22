package com.example.raj.courseworkapp_1541065.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.raj.courseworkapp_1541065.DBHandler;
import com.example.raj.courseworkapp_1541065.ItemData;
import com.example.raj.courseworkapp_1541065.ItemListBaseAdapter;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserData;
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


        ArrayList<ItemData> item_details = getAllUserData();
        final ListView lv1 = (ListView) findViewById(R.id.list_leader);
        lv1.setAdapter(new ItemListBaseAdapter(this, item_details, true));
    }



    private ArrayList<ItemData> getAllUserData (){

        ArrayList<ItemData> itemList = new ArrayList<ItemData>();
        List<UserData> userList = db.getAllUser();
        for(UserData user : userList){

            ItemData data = db.getUserScore(user.getUserID());
            if(data!= null){
                data.setLevelName(user.getName());
            }
            itemList.add(data);
        }

        return itemList;


    }
}
