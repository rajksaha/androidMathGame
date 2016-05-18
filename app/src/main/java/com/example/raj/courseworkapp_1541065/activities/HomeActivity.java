package com.example.raj.courseworkapp_1541065.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserData;
import com.google.gson.Gson;

/**
 * Created by raj on 5/14/2016.
 */
public class HomeActivity extends MainActivity {

    private Button play;
    private Button leaderBoard;
    private Button help;
    private TextView name;
    private UserData userData;
    private String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            Gson gson = new Gson();
            jsonString  =(String) b.get("userData");
            userData = gson.fromJson(jsonString, UserData.class);
            play = (Button) findViewById(R.id.playButton);
            name = (TextView) findViewById(R.id.name);

            name.setText(userData.getName().toString());
        }


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MathTypeActivity.class);
                startActivity(intent);
            }
        });

        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MathTypeActivity.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MathTypeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.play:

                Intent intent = new Intent(HomeActivity.this, MathGameActivity.class);
                intent.putExtra("userData", jsonString);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
