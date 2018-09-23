package com.amrita.to_do;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

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

    public void retreiveData(Context context){

        try {
            FileInputStream fis = context.openFileInput(filename);
            Scanner scanner = new Scanner(fis);
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            Log.d("Debug Amrita", content);
        } catch (Exception e) {
            Log.d("Debug Amrita", "In catch of retrieve data");
            e.printStackTrace();
        }
    }
}
