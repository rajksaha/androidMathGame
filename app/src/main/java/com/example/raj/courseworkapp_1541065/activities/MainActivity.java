package com.example.raj.courseworkapp_1541065.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raj.courseworkapp_1541065.DBHandler;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserData;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private TextView username, password;
    private Button login, register;
    DBHandler db;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        db = new DBHandler(context);

        username = (TextView) findViewById(R.id.editText);
        password = (TextView) findViewById(R.id.editText2);
        login = (Button) findViewById(R.id.button);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && password.getText() != null) {

                    UserData userData = db.getUserByUserName(username.getText().toString(), password.getText().toString());

                    if (null != userData && null != userData.getUserID() && userData.getUserID() > 0) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        Gson gson = new Gson();
                        String str = gson.toJson(userData);
                        intent.putExtra("userData", str);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(context, "Please Fill-Up the Form", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}

