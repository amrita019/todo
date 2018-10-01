package com.amrita.to_do;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class ListModel {

    private String todo;
    private String date;
    private String time;
    private boolean hasReminder;
    public Context context;


    public static ArrayList<ListModel> majorList = new ArrayList<>();

    public static StoreAndRetriveData storeAndRetriveData = new StoreAndRetriveData();

    public ListModel(String name, String date, String time, boolean hasReminder) {
        todo = name;
        this.date = date;
        this.time = time;
        this.hasReminder = hasReminder;
    }


    public String getName() {
        return todo;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public boolean getHasReminder() { return  hasReminder; }



    public static ArrayList<ListModel> showList(){
        ArrayList<ListModel> data = new ArrayList<>();
        majorList = data;
        Log.d("Debug showList",String.valueOf(majorList));
        return majorList;
    }

    public static ArrayList<ListModel> addElement(String todoTitle, String date, String time, boolean hasReminder, Context context){

        ArrayList<ListModel> data = new ArrayList<>();
        data = majorList;
        data.add(new ListModel(todoTitle, date, time, hasReminder));
        majorList = data;
        storeAndRetriveData.storeData(majorList, context);
        Log.d("Debug addElement",String.valueOf(majorList));
        return majorList;
    }

    public static ArrayList<ListModel> deleteElement(int position){

        try{
            ArrayList<ListModel> data = new ArrayList<>();
            data = majorList;
            data.remove(position);
            majorList = data;
            Log.d("Debug deleteElement", String.valueOf(majorList));
            return majorList;
        }
        catch(Exception e){
            Log.d("Debug Amrita", String.valueOf(e));
        }

         return majorList;

    }

}
