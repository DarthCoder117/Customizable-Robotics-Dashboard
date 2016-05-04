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
import models.ConnectionInfoRecord;
import models.WidgetRecord;
import org.json.JSONArray;

/**
 *
 * @author Brennan
 */
public class CurrentSavedConfig {

    // Fields
    private ArrayList<WidgetRecord> listWidgetRecords;
    private Gson gson;

    // Constructor
    public CurrentSavedConfig() {

    }

    // Method loadConfig() loads configuration from storage
    public void loadConfig() {
        
        // Call read() to load last saved widget config records
        try {
            readWidgetRecords();
        } catch (ClassNotFoundException e) {
            
        }    

    }
    
    // Method saveConfig() saves configuration to storage
    public void saveConfig(WidgetRecord[] arrWidgetRecords) {
        
        // Write to file
        writeWidgetRecords(arrWidgetRecords);
    }
    

    // Read the saved Widget records from file
    public ArrayList<WidgetRecord> readWidgetRecords() throws ClassNotFoundException {
        ObjectInputStream input;
        String fileName = "WidgetRecordListFile" + ".srl";
        WidgetRecord[] arrWidgetRecords = null;
        ArrayList<WidgetRecord> widgetRecordList = null;

        File contactRecordListFile = new File(fileName);

        if (!contactRecordListFile.exists()) {
            try {
                contactRecordListFile.createNewFile();
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
            FileInputStream fis = new FileInputStream(contactRecordListFile.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            String jsonArray = (String) ois.readObject();

            JSONArray jArray = new JSONArray(jsonArray);

            // New instance of Gson
            gson = new Gson();

            arrWidgetRecords = new WidgetRecord[jArray.length()];

            arrWidgetRecords = gson.fromJson(jsonArray, WidgetRecord[].class);

            widgetRecordList = new ArrayList<WidgetRecord>(Arrays.asList(arrWidgetRecords));

            ois.close();
            fis.close();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return widgetRecordList;
    }

    // Write the current Widget Records to file
    public void writeWidgetRecords(WidgetRecord[] arrWidgetRecords){
        //Person myPersonObject = new Person();
        //myPersonObject.setA(432);
        String fileName = "WidgetRecordListFile" + ".srl";
        //ObjectOutput out = null;

        // New instance of Gson
        gson = new Gson();

        File widgetRecordListFile = new File(fileName);

        widgetRecordListFile.delete();

        if (!widgetRecordListFile.exists()) {
            try {
                widgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            widgetRecordListFile.delete();
            try {
                widgetRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {

            FileOutputStream fos = new FileOutputStream(widgetRecordListFile.getAbsolutePath());
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(gson.toJson(arrWidgetRecords));
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Read Method for the user Connection info
    public ConnectionInfoRecord readConnectionInfo() throws ClassNotFoundException {
        ObjectInputStream input;
        String fileName = "ConnectionRecordListFile" + ".txt";
        //WidgetRecord[] arrWidgetRecords = null;
        //ArrayList<WidgetRecord> widgetRecordList = null;
        ConnectionInfoRecord connectionRecord = null;

        File connectionRecordListFile = new File(fileName);

        if (!connectionRecordListFile.exists()) {
            try {
                connectionRecordListFile.createNewFile();
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
            FileInputStream fis = new FileInputStream(connectionRecordListFile.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            String jsonArray = (String) ois.readObject();

            JSONArray jArray = new JSONArray(jsonArray);

            // New instance of Gson
            gson = new Gson();
            
            connectionRecord = gson.fromJson(jsonArray, ConnectionInfoRecord.class);

            //arrWidgetRecords = new WidgetRecord[jArray.length()];

            //arrWidgetRecords = gson.fromJson(jsonArray, WidgetRecord[].class);

            //widgetRecordList = new ArrayList<WidgetRecord>(Arrays.asList(arrWidgetRecords));

            ois.close();
            fis.close();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connectionRecord;
    }
    
    // Write the current Widget Records to file
    public void writeConnectionInfo(ConnectionInfoRecord connectionRecord){
        //Person myPersonObject = new Person();
        //myPersonObject.setA(432);
        String fileName = "ConnectionRecordListFile" + ".txt";
        //ObjectOutput out = null;

        // New instance of Gson
        gson = new Gson();

        File connectionRecordListFile = new File(fileName);

        connectionRecordListFile.delete();

        if (!connectionRecordListFile.exists()) {
            try {
                connectionRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            connectionRecordListFile.delete();
            try {
                connectionRecordListFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {

            FileOutputStream fos = new FileOutputStream(connectionRecordListFile.getAbsolutePath());
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(gson.toJson(connectionRecord));
            ois.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
