package com.example.raj.courseworkapp_1541065;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.raj.courseworkapp_1541065.data.UserData;
import com.example.raj.courseworkapp_1541065.data.UserScoreData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raj on 5/15/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final Integer DATABASE_VERSION = 2;

    private static final String DATABASE_NAME = "androidMathGame";

    private static final String USER_TABLE_NAME = "user";

    private static final String USER_SCORE_TABLE_NAME = "user_score";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USER = "CREATE TABLE " + USER_TABLE_NAME + "("
                + "userID" + " INTEGER PRIMARY KEY,"
                + "name" + " TEXT ,"
                + "username" + " TEXT ,"
                + "password" + " TEXT" + ")";

        String CREATE_USER_SCORE = "CREATE TABLE " + USER_SCORE_TABLE_NAME + "("
                + "userID" + " INTEGER,"
                + "levelNum" + " INTEGER ,"
                + "mathType" + " INTEGER ,"
                + "score" + " INTEGER" + ")";

        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_USER_SCORE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + USER_SCORE_TABLE_NAME);

        onCreate(db);

    }

    public Long addNewUser(UserData userData) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();

        contentValue.put("name", userData.getName());
        contentValue.put("username", userData.getUsername());
        contentValue.put("password", userData.getPassword());
        Long id = db.insert(USER_TABLE_NAME, null, contentValue);
        db.close();

        return id;
    }

    public void addUserScore(UserScoreData userScoreData) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();

        contentValue.put("userID", userScoreData.getUserID());
        contentValue.put("levelNum", userScoreData.getLevelNum());
        contentValue.put("mathType", userScoreData.getMathType());
        contentValue.put("score", userScoreData.getScore());
        db.insert(USER_SCORE_TABLE_NAME, null, contentValue);
        db.close();
    }


    public void updateUserScore(UserScoreData userScoreData) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();

        String where = "userID " + " = " + userScoreData.getUserID() + " AND  levelNum = " + userScoreData.getLevelNum() +  " AND  mathType = " + userScoreData.getMathType();
        contentValue.put("score", userScoreData.getScore());
        db.update(USER_SCORE_TABLE_NAME, contentValue, where, null);
    }

    public UserData getUserByUserName(String username, String password) {
        UserData userData = new UserData();

        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username = '" + username + "'" +
                " AND password = '" + password + "'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.moveToFirst()) {
            userData.setUserID(Integer.parseInt(cursor.getString(0)));
            userData.setName(cursor.getString(1));
            userData.setUsername(cursor.getString(2));
            userData.setPassword(cursor.getString(3));
        }
        return userData;
    }

    public List<UserScoreData> getAllUserScore(){
        List<UserScoreData> userScoreDataList = new ArrayList<UserScoreData>();

        String sql = "SELECT * FROM " + USER_SCORE_TABLE_NAME;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                UserScoreData userScoreData = new UserScoreData();
                userScoreData.setUserID(Integer.parseInt(cursor.getString(0)));
                userScoreData.setScore(Integer.parseInt(cursor.getString(3)));
                userScoreDataList.add(userScoreData);
            } while (cursor.moveToNext());

        }

        return  userScoreDataList;
    }

    public UserScoreData getUserScore(Integer userID, Integer mathType, Integer levelNum){

        UserScoreData userScoreData = new UserScoreData();
        String sql = "SELECT * FROM " + USER_SCORE_TABLE_NAME + " " +
                " WHERE userID = '" + userID + "'" +
                " AND levelNum = '" + levelNum + "'" +
                " AND mathType = '" + mathType + "'";;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            userScoreData.setUserID(Integer.parseInt(cursor.getString(0)));
            userScoreData.setScore(Integer.parseInt(cursor.getString(3)));
        }

        return  userScoreData;
    }
}
