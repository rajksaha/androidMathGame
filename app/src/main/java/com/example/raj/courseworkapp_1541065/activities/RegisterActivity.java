package com.example.raj.courseworkapp_1541065.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raj.courseworkapp_1541065.DBHandler;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.data.UserData;

/**
 * Created by raj on 5/14/2016.
 */
public class RegisterActivity extends AppCompatActivity {

    private TextView name, username, password;
    private Button register;
    DBHandler db;
    SQLiteDatabase sqlDB;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = RegisterActivity.this;
        name = (TextView) findViewById(R.id.userName);
        username = (TextView) findViewById(R.id.userName);
        password = (TextView) findViewById(R.id.password);

        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText() != null && username.getText() != null && password.getText() != null) {
                    db = new DBHandler(context);
                    UserData userData = new UserData();
                    userData.setName(name.getText().toString());
                    userData.setUsername(username.getText().toString());
                    userData.setPassword(password.getText().toString());
                    db.addNewUser(userData);
                    Toast.makeText(context, "User Added Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "Please Fill-Up the Form", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
