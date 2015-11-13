package com.example.dogaerdem.taskv6;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Spinner spinner;
    private ListView lstView;
    private ArrayList<String> newList;
    private ArrayList<String> newList2;
    private ArrayList<String> newList3;
    private CustomAdapter customAdapter;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newList = new ArrayList<String>();

        newList.add("Item1");
        newList.add("Item2");
        newList.add("Item3");
        newList.add("Item4");

        lstView = (ListView) findViewById(R.id.listView);
        customAdapter = new CustomAdapter(this, newList);
        lstView.setAdapter(customAdapter);

        newList2 = new ArrayList<String>();

        newList2.add("NewItem1");
        newList2.add("NewItem2");
        newList2.add("NewItem3");
        newList2.add("NewItem4");

        newList3 = new ArrayList<String>();

        newList3.add("OldItem1");
        newList3.add("OldItem2");
        newList3.add("OldItem3");
        newList3.add("OldItem4");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.add("List1");
        spinnerAdapter.add("List2");
        spinnerAdapter.add("List3");
        spinnerAdapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItemText = spinner.getSelectedItem().toString();
                if(selectedItemText.equals("List1") ){
                    customAdapter.changeList(newList);
                    customAdapter.notifyDataSetChanged();
                }
                if(selectedItemText.equals("List2") ){
                    customAdapter.changeList(newList2);
                    customAdapter.notifyDataSetChanged();
                }
                if(selectedItemText.equals("List3") ){
                    customAdapter.changeList(newList3);
                    customAdapter.notifyDataSetChanged();
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


    }}