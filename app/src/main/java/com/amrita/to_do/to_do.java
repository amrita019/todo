package com.amrita.to_do;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class to_do extends AppCompatActivity {

    FloatingActionButton mtdfab;

    ArrayList<ListModel> listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        mtdfab = (FloatingActionButton) findViewById(R.id.makeToDoFloatingActionButton);
       final EditText editText= (EditText)findViewById(R.id.userToDoEditText);


        mtdfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editText.getText().toString() != null)
                {
                    String toDoTitle = editText.getText().toString();
                    listModel = ListModel.addElement(toDoTitle);
                    Intent i = new Intent(to_do.this,MainActivity.class);
                    startActivity(i);


                }
                else
                    {
                    Toast.makeText(null, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
