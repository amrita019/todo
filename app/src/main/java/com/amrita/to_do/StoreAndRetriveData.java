package com.amrita.to_do;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class StoreAndRetriveData {



    String filename = "ToDo";


    public void storeData(String data, Context context){

        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void retreiveData(){

        Log.d("Debug Amrita", "Retreive Data called");


    }
}
