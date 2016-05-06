/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import models.LEDWidgetRecord;
import models.ProgressWidgetRecord;
import models.TextWidgetRecord;
import org.json.JSONArray;

/**
 *
 * @author Brennan
 */
public class CurrentSavedConfigWidgets {

    // Fields
    //private ArrayList<WidgetRecord> listWidgetRecords;
    private Gson gson;

    // Constructor
    public CurrentSavedConfigWidgets() {

    }

    // Method loadConfigLEDWidgets() loads configuration from storage
    public void loadConfigLEDWidgets() {
        
        // read from file
        try {
            readLEDWidgetRecords();
        } catch (ClassNotFoundException e) {
            
        }    

    }
    
    // Method saveConfigLEDWidgets() saves configuration to storage
    public void saveConfigLEDWidgets(LEDWidgetRecord[] arrLEDWidgetRecords) {
        
        // Write to file
        writeLEDWidgetRecords(arrLEDWidgetRecords);
    }
    
    // Method loadConfigProgressWidgets() loads configuration from storage
    public void loadConfigProgressWidgets() {
        
        // read from file
        try {
            readProgressWidgetRecords();
        } catch (ClassNotFoundException e) {
            
        }    

    }
    
    // Method saveConfigProgressWidgets() saves configuration to storage
    public void saveConfigProgressWidgets(ProgressWidgetRecord[] arrProgressWidgetRecords) {
        
        // Write to file
        writeProgressWidgetRecords(arrProgressWidgetRecords);
    }

    
    // Method saveConfigTextWidgets() saves configuration to storage
    public void saveConfigTextWidgets(TextWidgetRecord[] arrTextWidgetRecords) {
        
        // Write to file
        writeTextWidgetRecords(arrTextWidgetRecords);
    }
    
    // Method loadConfigTextWidgets() loads configuration from storage
    public void loadConfigTextWidgets() {
        
        // read from file
        try {
            readTextWidgetRecords();
        } catch (ClassNotFoundException e) {
            
        }    

    }
    
    // Read the saved Widget records from file
    public ArrayList<LEDWidgetRecord> readLEDWidgetRecords() throws ClassNotFoundException {
        ObjectInputStream input;
        String fileName = "LEDWidgetRecordListFile" + ".srl";
        LEDWidgetRecord[] arrLEDWidgetRecords = null;
        ArrayList<LEDWidgetRecord> ledWidgetRecordList = null;

        File ledWidgetRecordListFile = new File(fileName);

        if (!ledWidgetRecordListFile.exists()) {
            try {
                ledWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {

        }

        try {
            //input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(),"")+File.separator+filename)));
            //Person myPersonObject = (Person) input.readObject();
            //Log.v("serialization","Person a="+myPersonObject.getA());
            FileInputStream fis = new FileInputStream(ledWidgetRecordListFile.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            String jsonArray = (String) ois.readObject();

            JSONArray jArray = new JSONArray(jsonArray);

            // New instance of Gson
            gson = new Gson();

            arrLEDWidgetRecords = new LEDWidgetRecord[jArray.length()];

            arrLEDWidgetRecords = gson.fromJson(jsonArray, LEDWidgetRecord[].class);

            ledWidgetRecordList = new ArrayList<LEDWidgetRecord>(Arrays.asList(arrLEDWidgetRecords));

            ois.close();
            fis.close();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ledWidgetRecordList;
    }

    // Write the current Widget Records to file
    public void writeLEDWidgetRecords(LEDWidgetRecord[] arrLEDWidgetRecords){
        //Person myPersonObject = new Person();
        //myPersonObject.setA(432);
        String fileName = "LEDWidgetRecordListFile" + ".srl";
        //ObjectOutput out = null;

        // New instance of Gson
        gson = new Gson();

        File ledWidgetRecordListFile = new File(fileName);

        ledWidgetRecordListFile.delete();

        if (!ledWidgetRecordListFile.exists()) {
            try {
                ledWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            ledWidgetRecordListFile.delete();
            try {
                ledWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {

            FileOutputStream fos = new FileOutputStream(ledWidgetRecordListFile.getAbsolutePath());
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(gson.toJson(arrLEDWidgetRecords));
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    // Read the saved Widget records from file
    public ArrayList<ProgressWidgetRecord> readProgressWidgetRecords() throws ClassNotFoundException {
        ObjectInputStream input;
        String fileName = "ProgressWidgetRecordListFile" + ".srl";
        ProgressWidgetRecord[] arrProgressWidgetRecords = null;
        ArrayList<ProgressWidgetRecord> progressWidgetRecordList = null;

        File progressWidgetRecordListFile = new File(fileName);

        if (!progressWidgetRecordListFile.exists()) {
            try {
                progressWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {

        }

        try {
            //input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(),"")+File.separator+filename)));
            //Person myPersonObject = (Person) input.readObject();
            //Log.v("serialization","Person a="+myPersonObject.getA());
            FileInputStream fis = new FileInputStream(progressWidgetRecordListFile.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            String jsonArray = (String) ois.readObject();

            JSONArray jArray = new JSONArray(jsonArray);

            // New instance of Gson
            gson = new Gson();

            arrProgressWidgetRecords = new ProgressWidgetRecord[jArray.length()];

            arrProgressWidgetRecords = gson.fromJson(jsonArray, ProgressWidgetRecord[].class);

            progressWidgetRecordList = new ArrayList<ProgressWidgetRecord>(Arrays.asList(arrProgressWidgetRecords));

            ois.close();
            fis.close();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return progressWidgetRecordList;
    }

    // Write the current Widget Records to file
    public void writeProgressWidgetRecords(ProgressWidgetRecord[] arrProgressWidgetRecords){
        //Person myPersonObject = new Person();
        //myPersonObject.setA(432);
        String fileName = "ProgressWidgetRecordListFile" + ".srl";
        //ObjectOutput out = null;

        // New instance of Gson
        gson = new Gson();

        File progressWidgetRecordListFile = new File(fileName);

        progressWidgetRecordListFile.delete();

        if (!progressWidgetRecordListFile.exists()) {
            try {
                progressWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            progressWidgetRecordListFile.delete();
            try {
                progressWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {

            FileOutputStream fos = new FileOutputStream(progressWidgetRecordListFile.getAbsolutePath());
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(gson.toJson(arrProgressWidgetRecords));
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    // Read the saved Widget records from file
    public ArrayList<TextWidgetRecord> readTextWidgetRecords() throws ClassNotFoundException {
        ObjectInputStream input;
        String fileName = "TextWidgetRecordListFile" + ".srl";
        TextWidgetRecord[] arrTextWidgetRecords = null;
        ArrayList<TextWidgetRecord> textWidgetRecordList = null;

        File textWidgetRecordListFile = new File(fileName);

        if (!textWidgetRecordListFile.exists()) {
            try {
                textWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {

        }

        try {
            //input = new ObjectInputStream(new FileInputStream(new File(new File(getFilesDir(),"")+File.separator+filename)));
            //Person myPersonObject = (Person) input.readObject();
            //Log.v("serialization","Person a="+myPersonObject.getA());
            FileInputStream fis = new FileInputStream(textWidgetRecordListFile.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            String jsonArray = (String) ois.readObject();

            JSONArray jArray = new JSONArray(jsonArray);

            // New instance of Gson
            gson = new Gson();

            arrTextWidgetRecords = new TextWidgetRecord[jArray.length()];

            arrTextWidgetRecords = gson.fromJson(jsonArray, TextWidgetRecord[].class);

            textWidgetRecordList = new ArrayList<TextWidgetRecord>(Arrays.asList(arrTextWidgetRecords));

            ois.close();
            fis.close();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textWidgetRecordList;
    }

    // Write the current Widget Records to file
    public void writeTextWidgetRecords(TextWidgetRecord[] arrTextWidgetRecords){
        //Person myPersonObject = new Person();
        //myPersonObject.setA(432);
        String fileName = "TextWidgetRecordListFile" + ".srl";
        //ObjectOutput out = null;

        // New instance of Gson
        gson = new Gson();

        File textWidgetRecordListFile = new File(fileName);

        textWidgetRecordListFile.delete();

        if (!textWidgetRecordListFile.exists()) {
            try {
                textWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            textWidgetRecordListFile.delete();
            try {
                textWidgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {

            FileOutputStream fos = new FileOutputStream(textWidgetRecordListFile.getAbsolutePath());
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(gson.toJson(arrTextWidgetRecords));
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
}
