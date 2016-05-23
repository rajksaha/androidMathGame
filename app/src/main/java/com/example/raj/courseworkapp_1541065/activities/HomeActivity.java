package com.example.raj.courseworkapp_1541065.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
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

    private TextView name;
    private UserData userData;
    private String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        welcome = (TextView)findViewById(R.id.welcomeTextView) ;

        Typeface customText = Typeface.createFromAsset(getAssets(), "folia_mix.ttf");
        welcome.setTypeface(customText);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            Gson gson = new Gson();
            jsonString  =(String) b.get("userData");
            userData = gson.fromJson(jsonString, UserData.class);
            name = (TextView) findViewById(R.id.userName);

            name.setText(userData.getName().toString());
            name.setTypeface(customText);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()) {
            case R.id.play:

                intent = new Intent(HomeActivity.this, MathTypeActivity.class);
                intent.putExtra("userData", jsonString);
                startActivity(intent);
                return true;
            case R.id.leaderBoard:

                intent = new Intent(HomeActivity.this, LeaderBoardActivity.class);
                intent.putExtra("userData", jsonString);
                startActivity(intent);
                return true;
            case R.id.help:

                intent = new Intent(HomeActivity.this, HelpActivity.class);
                intent.putExtra("userData", jsonString);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
