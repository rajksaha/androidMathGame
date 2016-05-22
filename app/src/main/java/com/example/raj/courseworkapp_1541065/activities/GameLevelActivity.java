package com.example.raj.courseworkapp_1541065.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.raj.courseworkapp_1541065.ItemData;
import com.example.raj.courseworkapp_1541065.ItemListBaseAdapter;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserData;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by raj on 5/16/2016.
 */
public class GameLevelActivity extends AppCompatActivity {

    Integer mathType;
    private UserData userData;
    private String jsonString;
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            mathType =(Integer) b.get("mathType");
            Gson gson = new Gson();
            jsonString  =(String) b.get("userData");
            userData = gson.fromJson(jsonString, UserData.class);
            name = (TextView) findViewById(R.id.userName);

            name.setText(userData.getName().toString());
        }

        ArrayList<ItemData> item_details = GetSearchResults();
        final ListView lv1 = (ListView) findViewById(R.id.list_level);
        lv1.setAdapter(new ItemListBaseAdapter(this, item_details));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ItemData obj_itemDetails = (ItemData)o;

                Intent intent = new Intent(GameLevelActivity.this, MathGameActivity.class);
                intent.putExtra("mathType", mathType);
                intent.putExtra("levelNum", obj_itemDetails.getLevelNo());
                intent.putExtra("userData", jsonString);
                startActivity(intent);

            }
        });
    }

    private ArrayList<ItemData> GetSearchResults(){
        ArrayList<ItemData> results = new ArrayList<ItemData>();

        ItemData item_details = new ItemData();
        item_details.setLevelName("Level 1");
        item_details.setLevelNo(1);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Level 2");
        item_details.setLevelNo(2);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Level 3");
        item_details.setLevelNo(3);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Level 4");
        item_details.setLevelNo(4);
        results.add(item_details);

        item_details = new ItemData();
        item_details.setLevelName("Level 5");
        item_details.setLevelNo(5);
        results.add(item_details);

        return results;
    }
}
