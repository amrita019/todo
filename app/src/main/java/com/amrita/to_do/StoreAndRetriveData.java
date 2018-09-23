package com.amrita.to_do;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static android.content.Context.MODE_PRIVATE;

public class StoreAndRetriveData {


    public Context context;

    String filename = "ToDo";


    public void storeData(String data){


        try{
            File m = new File("media");
            ContextWrapper cw = new ContextWrapper(context);
            File mediaDir = cw.getDir(String.valueOf(m), Context.MODE_PRIVATE);
            if(!mediaDir.exists()){
                mediaDir.createNewFile();
                mediaDir.mkdir();
            }
            File f = new File(filename);
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
//            FileOutputStream fileOutputStream = cw.openFileOutput(filename, MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            Log.d("Debug","File saved");
        }
        catch(FileNotFoundException e){
            Toast.makeText(context, "File Not Found", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Log.d("Debug",  "Aa gayi re exception" + String.valueOf(e) );
        }

    }

    public void retreiveData(){


    }
}
