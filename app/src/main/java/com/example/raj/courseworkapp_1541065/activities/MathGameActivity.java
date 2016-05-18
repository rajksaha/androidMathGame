package com.example.raj.courseworkapp_1541065.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raj.courseworkapp_1541065.DBHandler;
import com.example.raj.courseworkapp_1541065.MathGameData;
import com.example.raj.courseworkapp_1541065.QuestionMaker;
import com.example.raj.courseworkapp_1541065.R;
import com.example.raj.courseworkapp_1541065.activities.HomeActivity;
import com.example.raj.courseworkapp_1541065.data.UserData;
import com.example.raj.courseworkapp_1541065.data.UserScoreData;
import com.google.gson.Gson;

/**
 * Created by raj on 5/14/2016.
 */
public class MathGameActivity extends HomeActivity {


    Integer questionAsked = 1;

    TextView question;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    ImageView imageView;
    ImageView correct;
    ImageView wrong;

    private UserData userData;
    private String jsonString;

    Integer perLevelScore = 0;

    DBHandler db;


    Integer level = 1;
    Integer mathType = 2;

    MathGameData mathGameData;
    Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);


        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        context = getApplicationContext();
        db = new DBHandler(context);
        if(b!=null)
        {
            Gson gson = new Gson();
            mathType =(Integer) b.get("mathType");
            level =(Integer) b.get("levelNum");
            jsonString  =(String) b.get("userData");
            userData = gson.fromJson(jsonString, UserData.class);
        }

        question = (TextView) findViewById(R.id.question);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);
        imageView = (ImageView) findViewById(R.id.imageView);
        correct = (ImageView) findViewById(R.id.correct);
        wrong = (ImageView) findViewById(R.id.wrong);



        correct.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);
        myHandler = new Handler();
        //imageView.setImageResource(R.drawable.math);



        this.askQuestion(level,mathType,questionAsked);


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Integer.parseInt(option1.getText().toString()),mathGameData.getResult());
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Integer.parseInt(option2.getText().toString()),mathGameData.getResult());
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Integer.parseInt(option3.getText().toString()),mathGameData.getResult());
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(Integer.parseInt(option4.getText().toString()),mathGameData.getResult());
            }
        });
    }

    private void askQuestion(Integer level, Integer mathType, Integer questionAsked){

        QuestionMaker questionMaker = new QuestionMaker();
        if(questionAsked % 5 == 0){
            this.saveLevelScore();
            this.level += level;
            level = this.level;
        }
        mathGameData = questionMaker.makeQuestion(level,mathType);

        question.setText(mathGameData.getDisplayString());
        option1.setText(mathGameData.getOption1().toString());
        option2.setText(mathGameData.getOption2().toString());
        option3.setText(mathGameData.getOption3().toString());
        option4.setText(mathGameData.getOption4().toString());
    }

    private void saveLevelScore() {

        try {

            UserScoreData dBUserScoreData = db.getUserScore(userData.getUserID(),mathType,level);

            if(dBUserScoreData != null){
                if(dBUserScoreData.getScore() < perLevelScore){
                    dBUserScoreData.setScore(perLevelScore);
                    db.updateUserScore(dBUserScoreData);
                }
            }else{
                UserScoreData userScoreData = new UserScoreData();
                userScoreData.setUserID(userData.getUserID());
                userScoreData.setLevelNum(level);
                userScoreData.setMathType(mathType);
                userScoreData.setScore(perLevelScore);
                db.addUserScore(userScoreData);
            }


            perLevelScore = 0;
        }catch (Exception e){

        }

    }

    private void checkAnswer(Integer given, Integer answer) {

        try {
            correct.setVisibility(View.INVISIBLE);
            wrong.setVisibility(View.INVISIBLE);

            if(given.equals(answer)){
                perLevelScore +=5;
                correct.setVisibility(View.VISIBLE);
            }else{
                perLevelScore -=3;
                wrong.setVisibility(View.VISIBLE);
            }

            /*Thread.sleep(1000);
            correct.setVisibility(View.INVISIBLE);
            wrong.setVisibility(View.INVISIBLE);
            question.setVisibility(View.VISIBLE);
            imageView.setImageResource(R.drawable.math);*/
            questionAsked +=1;
            this.askQuestion(this.level,this.mathType,questionAsked);

        }catch (Exception e){

        }

    }
}
