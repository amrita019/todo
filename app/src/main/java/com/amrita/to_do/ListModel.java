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

    public static ArrayList<ListModel> showList(){
        ArrayList<ListModel> data = new ArrayList<>();
        data2 = data;
        Log.d("Debug showList",String.valueOf(data2));
        return data2;
    }

    public static ArrayList<ListModel> addElement(String todoTitle){
        ArrayList<ListModel> data = new ArrayList<>();
        data = data2;
        data.add(new ListModel(todoTitle));
        data2 = data;
        Log.d("Debug addElement",String.valueOf(data2));
        return data2;
    }

    public static ArrayList<ListModel> deleteElement(int position){
        ArrayList<ListModel> data = new ArrayList<>();
        data = data2;
        data.remove(position);
        data2 = data;
        Log.d("Debug deleteElement", String.valueOf(data2));
        return data2;
    }

}
