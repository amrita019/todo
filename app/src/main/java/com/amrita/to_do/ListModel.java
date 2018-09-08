package com.amrita.to_do;

import android.util.Log;

import java.util.ArrayList;

public class ListModel {

    private String todo;


    public ListModel(String name) {
        todo = name;
    }

    public String getName() {
        return todo;
    }

    public static ArrayList<ListModel> createList(){
        ArrayList<ListModel> data = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            data.add(new ListModel("Person"+ i));
        }

        return data;
    }
}
