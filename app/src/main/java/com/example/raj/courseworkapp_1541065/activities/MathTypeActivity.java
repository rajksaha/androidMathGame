package com.example.raj.courseworkapp_1541065.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.raj.courseworkapp_1541065.DBHandler;
import com.example.raj.courseworkapp_1541065.ItemData;
import com.example.raj.courseworkapp_1541065.ItemListBaseAdapter;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserData;
import com.example.raj.courseworkapp_1541065.data.UserScoreData;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by raj on 5/16/2016.
 */
public class MathTypeActivity extends HomeActivity {

    private TextView name;
    private UserData userData;
    private String jsonString;

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_type);

        context = getApplicationContext();
        db = new DBHandler(context);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            Gson gson = new Gson();
            jsonString  =(String) b.get("userData");
            userData = gson.fromJson(jsonString, UserData.class);
            name = (TextView) findViewById(R.id.userName);

            name.setText(userData.getName().toString());
        }

        ArrayList<ItemData> item_details = GetSearchResults();
        final ListView lv1 = (ListView) findViewById(R.id.list_math_type);
        lv1.setAdapter(new ItemListBaseAdapter(this, item_details,false));


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ItemData obj_itemDetails = (ItemData)o;

                Intent intent = new Intent(MathTypeActivity.this, GameLevelActivity.class);
                intent.putExtra("mathType", obj_itemDetails.getLevelNo());
                intent.putExtra("userData", jsonString);
                startActivity(intent);

            }
        });
    }

    private ArrayList<ItemData> GetSearchResults(){
        ArrayList<ItemData> results = new ArrayList<ItemData>();

        ItemData item_details = new ItemData();
        item_details.setLevelName("Addition");
        item_details.setLevelNo(1);
        results.add(item_details);

        UserScoreData userScoreData = db.getUserScore(userData.getUserID(),2,1);

        if(userScoreData != null){
            item_details = new ItemData();
            item_details.setLevelName("Subtraction");
            item_details.setLevelNo(2);
            results.add(item_details);
        }

        userScoreData = db.getUserScore(userData.getUserID(),3,1);

        if(userScoreData != null){

            item_details = new ItemData();
            item_details.setLevelName("Multiply");
            item_details.setLevelNo(3);
            results.add(item_details);
        }


        userScoreData = db.getUserScore(userData.getUserID(),4,1);

        if(userScoreData != null){
            item_details = new ItemData();
            item_details.setLevelName("Divide");
            item_details.setLevelNo(4);
            results.add(item_details);

        }


        return results;
    }
}
