package com.amrita.to_do;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ListModel> item;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            RecyclerView rvToDo = (RecyclerView) findViewById(R.id.recyclerView);
            item = ListModel.createList();
            ListAdapter adapter = new ListAdapter(item);
            rvToDo.setAdapter(adapter);
            rvToDo.setLayoutManager(new LinearLayoutManager(this));
        }

        catch (Exception e){
            Log.d("Debug", "In Catch");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d("Debug","FAB Clicked");
                AddToDo fragment =new AddToDo();
                FragmentTransaction f =getSupportFragmentManager().beginTransaction();

                f.replace(R.id.newfrag,new AddToDo());
                f.commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
