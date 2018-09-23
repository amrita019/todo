package com.amrita.to_do;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static android.content.Context.MODE_PRIVATE;

public class StoreAndRetriveData {



    String filename = "ToDo";


    public void storeData(List<ListModel> majorList, Context context){

        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            JSONArray jsonObject = null;

            try {
                jsonObject = makeJSON(majorList);
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

//    public List<ListModel> retreiveData(Context context){
//
//        try {
//            FileInputStream fis = context.openFileInput(filename);
//            Scanner scanner = new Scanner(fis);
//            scanner.useDelimiter("\\Z");
//            String content = scanner.next();
//            scanner.close();
//            Log.d("Debug Amrita", content);
//            return content;
//
//        } catch (Exception e) {
//            Log.d("Debug Amrita", "In catch of retrieve data");
//            e.printStackTrace();
//        }
//    }

    public JSONArray makeJSON(List<ListModel> listModel) throws JSONException {
        JSONObject obj;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < listModel.size(); i++) {
            ListModel listModel1 = listModel.get(i);
            obj = new JSONObject();
            try {
                obj.put("item", listModel1.getName());
                obj.put("date", listModel1.getName());
                obj.put("time", listModel1.getName());

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
