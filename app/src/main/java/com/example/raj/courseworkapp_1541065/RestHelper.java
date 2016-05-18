  package com.example.raj.courseworkapp_1541065;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.provider.SyncStateContract;
import android.util.Log;


import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 5/14/2016.
 */
public class RestHelper extends AsyncTask<JSONObject,Void,String>{
    @Override
    protected String doInBackground(JSONObject... jsonObjects) {
        return null;
    }

    /*final static String urlString = "http://192.168.1.155:8080/cafe/rest";


    @Override
    protected HttpResponse doInBackground(JSONObject... jsonObjects) {




        JSONObject jsonData = jsonObjects[0];

        String endPoint = jsonData.optString("endPoint");

        String[] postParam = new String[]{"KEY"}; //KEY
        String[] postValue = new String[]{"VALUE"}; //VALUE

        this.prepareData(postParam, postValue, jsonData, endPoint);

        try{

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlString + endPoint);

        String requestBody;
        Uri.Builder builder = new Uri.Builder();
        int intParam = 0;

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(postParam.length);
        for(String param : postParam){
            nameValuePairs.add(new BasicNameValuePair(param, postValue[intParam]));
            intParam++;
        }
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        ResponseHandler<String> responseHandler=new BasicResponseHandler();
        Log.d("TAG", responseHandler.toString());
        return httpclient.execute(httppost);

    }catch(Exception ex){
        ex.printStackTrace();
        Log.d("TAG", "err: " + ex.toString());
    }


        return null;
    }



    private Map<String, String> prepareData(String[] postParam, String[] postValue, JSONObject jsonData, String endPoint){

        Map<String, String> param = new HashMap<>();

        if(endPoint.equals("/application/checkAuthentication")){
            postParam = new String[]{"username", "password"};
            postValue = new String[]{jsonData.optString("username"), jsonData.optString("password")};
        }
        return param;
    }*/
}
