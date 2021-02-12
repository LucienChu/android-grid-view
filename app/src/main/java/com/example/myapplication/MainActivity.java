package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.data.Model;
import com.example.myapplication.view.LabelListViewAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private GridView listView;
    private LabelListViewAdapter myAdapter;
    ArrayList<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.mmsListView);
        models = new ArrayList<>();
        models.add(new Model("Pothole paved surface", 1, false));
        models.add(new Model("Pothole non-paved surface", 1, false));
        models.add(new Model("Shoulder Drop-off", 1, false));
        models.add(new Model("Crack", 1, false));
        models.add(new Model("Debris", 1, false));
        models.add(new Model("Bridge Deck Spall", 1, false));
        models.add(new Model("Road Discontinuity", 1, false));
        models.add(new Model("Snow Accumulation", 1, false));
        models.add(new Model("Encroachment", 1, false));
        models.add(new Model("Signage Issue", 1, false));
        models.add(new Model("Pothole Paved or Non-Paved Shoulder", 0, false));

//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
//        models.add(new Model("ins", 1, false));
        myAdapter = new LabelListViewAdapter(this, R.id.mmsListView, models);
        listView.setAdapter(myAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(MainActivity.this, "position: " + position + " is clicked", Toast.LENGTH_LONG).show();
//            }
//        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        uncheck(0);
    }

    private void uncheck(int index) {
        models.get(index).setSelected(true);
        models.get(index).increment();
        this.myAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void clickMe(View view) {
        models.forEach(model -> {
            model.setSelected(false);
        });
        myAdapter.notifyDataSetChanged();
    }



}