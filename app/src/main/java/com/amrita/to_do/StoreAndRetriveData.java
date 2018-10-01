package com.amrita.to_do;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static android.content.Context.MODE_PRIVATE;

public class StoreAndRetriveData {



    String filename = "ToDo";


    public void storeData(List<ListModel> majorList, Context context){

        ArrayList<ListModel> combinedList = new ArrayList<>(retreiveData(context));
        combinedList.addAll(majorList);
        try {
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            JSONArray jsonObject = null;

            try {
                jsonObject = makeJSON(combinedList);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            assert jsonObject != null;
            String storedata = jsonObject.toString();

            Log.d("Debug Amrita", storedata);
            fos.write(storedata.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<ListModel> retreiveData(Context context){
        ArrayList<ListModel> items = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            FileInputStream fis = context.openFileInput(filename);
            StringBuilder builder = new StringBuilder();
            String line;
            bufferedReader = new BufferedReader(new InputStreamReader(fis));
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }

            Gson gson = new Gson();
            JSONArray jsonArray = (JSONArray) new JSONTokener(builder.toString()).nextValue();
            Type listType = new TypeToken<List<ListModel>>(){}.getType();
            items = gson.fromJson(jsonArray.toString(), listType);


            Log.d("Debug Amrita", String.valueOf(items));
            fis.close();
            bufferedReader.close();
            return items;

//
//            for (int i = 0; i < jsonArray.length(); i++) {
////                ListModel listModel = new ListModel(jsonArray.getJSONObject(i));
//                items.add(jsonArray.getString(i));
//            }
//            Scanner scanner = new Scanner(fis);
//            scanner.useDelimiter("\\Z");
//            String content = scanner.next();
//            scanner.close();
//            Log.d("Debug Amrita", content);
//            return content;
        } catch (Exception e) {
            Log.d("Debug Amrita", "In catch of retrieve data");
            e.printStackTrace();
        }
        return items;
    }

    public JSONArray makeJSON(List<ListModel> listModel) throws JSONException {
        JSONObject obj;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < listModel.size(); i++) {
            ListModel listModel1 = listModel.get(i);
            obj = new JSONObject();
            try {
                obj.put("todo", listModel1.getName());
                obj.put("date", listModel1.getDate());
                obj.put("time", listModel1.getTime());
                obj.put("hasReminder", listModel1.getHasReminder());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(obj);
        }
        JSONObject finalObj = new JSONObject();
        finalObj.put("list", jsonArray);
        return jsonArray;
    }
}
