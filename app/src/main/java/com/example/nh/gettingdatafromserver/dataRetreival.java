package com.example.nh.gettingdatafromserver;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class dataRetreival {
    public JSONArray getStoresJson(String urlStr)
    {JSONArray dataArray=null;
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            if (connection.getResponseCode()==200){
                InputStream is =new BufferedInputStream(connection.getInputStream());
                BufferedReader reader=new BufferedReader(new InputStreamReader(is));

                StringBuilder stringBuilder=new StringBuilder();
                String line=null;
                while((line = reader.readLine())!=null){
                    stringBuilder.append(line);
                }
                is.close();
                connection.disconnect();

                String dataStr=stringBuilder.toString();
                Log.e("data",dataStr);
                 dataArray=new JSONArray(dataStr);
            }
        } catch (MalformedURLException e) {
            Log.i("url exception","not valid url");
        } catch (IOException e) {
            Log.i("connection error","cant connect to this url");
        } catch (JSONException e) {
            Log.i("jsonarray error","cant convert to json array");
        }
        return dataArray;
    }

    public ArrayList<Store>parseJson(JSONArray jsonArray)// change json array object to array list
    {
        ArrayList<Store> allStores=new ArrayList<>();
        JSONObject jsonObject=new JSONObject();
        for (int i = 0; i <jsonArray.length() ; i++) {
            try {
                jsonObject=jsonArray.getJSONObject(i);
                Store store=new Store();
                store.setStoreID(jsonObject.getInt("StoreID"));
               store.setStoreName(jsonObject.getString("StoreName"));
                store.setStoreDescription(jsonObject.getString("StoreDescription"));
                store.setStoreLogo(jsonObject.getString("StoreLogo"));
                allStores.add(store);
            } catch (JSONException e) {
                e.printStackTrace();
            }
                    }
        Log.i("size", allStores.size()+"");
        return allStores;
    }
}
