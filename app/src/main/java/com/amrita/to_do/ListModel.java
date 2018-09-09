package com.amrita.to_do;

import android.util.Log;

import java.util.ArrayList;

public class ListModel {

    private String todo;
    public static ArrayList<ListModel> data2 = new ArrayList<>();

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
        data2 = data;
        return data2;
    }

    public static ArrayList<ListModel> deleteElement(int position){
        ArrayList<ListModel> data3 = new ArrayList<>();
        data3 = data2;
        data3.remove(position);
        data2 = data3;
        Log.d("Debug", String.valueOf(data2));
        return data2;
    }

}
