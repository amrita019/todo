package com.amrita.to_do;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class AddToDo extends Fragment {

    ArrayList<ListModel> listModel;
    public Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_to_do, container, false);
        TextView textview = (TextView) view.findViewById(R.id.textView2);
        final EditText editText = (EditText) view.findViewById(R.id.editText);
        Button addToDoButton= (Button) view.findViewById(R.id.button);

        addToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(editText.getText().toString() != null) {
                    String toDoTitle = editText.getText().toString();
                    listModel = ListModel.addElement(toDoTitle,"date", "time", context);
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                    ((Activity) getActivity()).overridePendingTransition(0,0);

                }
                else{
                    Toast.makeText(null, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });



        return view;
    }

    }

