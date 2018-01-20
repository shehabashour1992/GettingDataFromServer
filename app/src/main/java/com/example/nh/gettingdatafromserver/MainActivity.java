package com.example.nh.gettingdatafromserver;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView storesListView;
    private StoreAdapter adapter;
    private ArrayList<Store>storesList=new ArrayList<>();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storesListView= (ListView) findViewById(R.id.listView);
        adapter=new StoreAdapter(this,R.layout.store_row,storesList);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        storesListView.setAdapter(adapter);
        new MyAsyncTask().execute();


    }
    public class MyAsyncTask extends AsyncTask<Void,Void,JSONArray>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected JSONArray doInBackground(Void... params) {// gets data from server
            dataRetreival retreival=new dataRetreival();
            return retreival.getStoresJson("http://188.166.81.130/staging/public/stores.json");
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);
            progressBar.setVisibility(View.GONE);
            storesList=(new dataRetreival()).parseJson(jsonArray);

            //adapter.notifyDataSetChanged();
            adapter=new StoreAdapter(MainActivity.this,R.layout.store_row,storesList);
            storesListView.setAdapter(adapter);
        }
    }

}
