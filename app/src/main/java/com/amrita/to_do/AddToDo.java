package com.amrita.to_do;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class AddToDo extends Fragment {
    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_to_do, container, false);
        TextView textview = (TextView) view.findViewById(R.id.textView2);
        Button button= (Button) view.findViewById(R.id.button);

        Log.d("Debug", "text view");
        return view;
    }

    }

