package com.example.raj.courseworkapp_1541065.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.raj.courseworkapp_1541065.ItemData;
import com.example.raj.courseworkapp_1541065.ItemListBaseAdapter;
import com.example.raj.courseworkapp_1541065.R;

import java.util.ArrayList;

/**
 * Created by raj on 5/16/2016.
 */
public class MathTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_type);

        ArrayList<ItemData> item_details = GetSearchResults();
        final ListView lv1 = (ListView) findViewById(R.id.list_math_type);
        lv1.setAdapter(new ItemListBaseAdapter(this, item_details));


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                ItemData obj_itemDetails = (ItemData)o;

                Intent intent = new Intent(MathTypeActivity.this, GameLevelActivity.class);
                intent.putExtra("mathType", obj_itemDetails.getLevelNo());
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
}
