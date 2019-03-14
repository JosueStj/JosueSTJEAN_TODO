package com.example.josuestjean_todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    ArrayList<String> todoItems;
    ArrayAdapter<String> aTotoAdapter;
    ListView lvItems;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        lvItems = (ListView) findViewById(R.id.lvItems);
        lvItems.setAdapter(aTotoAdapter);
        etEditText = (EditText) findViewById(R.id.etEditText);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick
                    (AdapterView<?> parent, View view, int position, long id) {
                todoItems.remove(position);
                aTotoAdapter.notifyDataSetChanged();
                return true;
            }
        });


    };

    private void populateArrayItems() {
        todoItems = new ArrayList<String>();
        todoItems.add("item 1");
        todoItems.add("item 2");
        todoItems.add("item 3");
        aTotoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,todoItems);
    }
    public void readItems(){
        File filesDir = getFilesDir();
        File file = new File(getFilesDir()"todo.txt");
        try{
            todoItems = new ArrayList<String>(FileUtils.readlines(file));
        }

    }

    public void onAddItem(View view) {
        aTotoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");

    }
}
