package com.amrita.to_do;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class ListModel {

    private String todo;
    private String date;
    private String time;
    public Context context;


    public static ArrayList<ListModel> majorList = new ArrayList<>();

    public static StoreAndRetriveData storeAndRetriveData = new StoreAndRetriveData();

    public ListModel(String name, String date, String time) {
        todo = name;
        this.date = date;
        this.time = time;
    }


    public String getName() {
        return todo;
    }

    public static ArrayList<ListModel> showList(){
        ArrayList<ListModel> data = new ArrayList<>();
        majorList = data;
        Log.d("Debug showList",String.valueOf(majorList));
        return majorList;
    }

    public static ArrayList<ListModel> addElement(String todoTitle, String date, String time, Context context){

        ArrayList<ListModel> data = new ArrayList<>();
        data = majorList;
        data.add(new ListModel(todoTitle, date, time));
        majorList = data;
        storeAndRetriveData.storeData(majorList, context);
        Log.d("Debug addElement",String.valueOf(majorList));
        return majorList;
    }

    public static ArrayList<ListModel> deleteElement(int position){
        ArrayList<ListModel> data = new ArrayList<>();
        data = majorList;
        data.remove(position);
        majorList = data;
        Log.d("Debug deleteElement", String.valueOf(majorList));
        return majorList;
    }

}
