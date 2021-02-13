package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.data.LabelModel;
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
    ArrayList<LabelModel> labelModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.mmsListView);
        labelModels = new ArrayList<>();
        labelModels.add(new LabelModel("Pothole paved surface", 1, false));
        labelModels.add(new LabelModel("Pothole non-paved surface", 1, false));
        labelModels.add(new LabelModel("Shoulder Drop-off", 1, false));
        labelModels.add(new LabelModel("Crack", 1, false));
        labelModels.add(new LabelModel("Debris", 1, false));
        labelModels.add(new LabelModel("Bridge Deck Spall", 1, false));
        labelModels.add(new LabelModel("Road Discontinuity", 1, false));
        labelModels.add(new LabelModel("Snow Accumulation", 1, false));
        labelModels.add(new LabelModel("Encroachment", 1, false));
        labelModels.add(new LabelModel("Signage Issue", 1, false));
        labelModels.add(new LabelModel("Pothole Paved or Non-Paved Shoulder", 0, false));

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
        myAdapter = new LabelListViewAdapter(this, R.id.mmsListView, labelModels);
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
        labelModels.get(index).setSelected(true);
        labelModels.get(index).increment();
        this.myAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void clickMe(View view) {
        labelModels.forEach(labelModel -> {
            labelModel.setSelected(false);
        });
        myAdapter.notifyDataSetChanged();
    }



}