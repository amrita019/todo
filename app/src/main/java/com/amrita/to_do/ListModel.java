package com.amrita.to_do;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class ListModel {

    private String todo;
    public Context context;

    public static ArrayList<ListModel> data2 = new ArrayList<>();

    public static StoreAndRetriveData storeAndRetriveData = new StoreAndRetriveData();

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

    public static ArrayList<ListModel> addElement(String todoTitle, Context context){

        ArrayList<ListModel> data = new ArrayList<>();
        data = data2;
        data.add(new ListModel(todoTitle));
        storeAndRetriveData.storeData(String.valueOf(data), context);
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
