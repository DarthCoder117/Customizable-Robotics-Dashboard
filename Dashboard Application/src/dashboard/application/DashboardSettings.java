/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Global settings class for convenient access to configuration values.
 */
public class DashboardSettings 
{
    private static BooleanProperty showMenu = new SimpleBooleanProperty(null, "show menu", true);
    
    public static void setShowMenu(boolean show)
    {
        showMenu.set(show);
    }
    
    public static boolean getShowMenu()
    {
        return showMenu.get();
    }
    
    public static BooleanProperty showMenuProperty()
    {
        return showMenu;
    }
    
    private static BooleanProperty enableFullscreen = new SimpleBooleanProperty(null, "fullscreen", false);
    
    public static void setFulscreenEnabled(boolean b)
    {
        enableFullscreen.set(b);
    }
    
    public static boolean getFullscreenEnabled()
    {
        return enableFullscreen.get();
    }
    
    public static BooleanProperty fullscreenEnabledProperty()
    {
        return enableFullscreen;
    }
    
    private static StringProperty ipAddress = new SimpleStringProperty(null, "ip address", "127.0.0.1");
    
    public static void setIpAddress(String ip)
    {
        //TODO: Validate ip address
        ipAddress.set(ip);
    }
    
    public static String getIpAddress()
    {
        return ipAddress.get();
    }
    
    public static StringProperty ipAddressProperty()
    {
        return ipAddress;
    }
    
    private static IntegerProperty port = new SimpleIntegerProperty(null, "port", 4309);
    
    public static void setPort(int portNum)
    {
        port.set(portNum);
    }
    
    public static int getPort()
    {
        return port.get();
    }
    
    public static IntegerProperty portProperty()
    {
        return port;
    }
    
    private static BooleanProperty isServer = new SimpleBooleanProperty(null, "is server", false);
    
    public static void setIsServer(boolean b)
    {
        isServer.set(b);
    }
    
    public static boolean getIsServer()
    {
        return isServer.get();
    }
    
    public static BooleanProperty isServerProperty()
    {
        return isServer;
    }
    
    ///Loads the settings from the default location (settings.xml)
    public static void loadSettings()
    {
        File file = new File("settings.xml");
        if (file.exists())
        {
            XMLDecoder d = null;
            try
            {
                d = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                
                //Connection
                ipAddress.set((String)d.readObject());
                port.set((Integer)d.readObject());
                isServer.set((Boolean)d.readObject());
                
                //Display
                enableFullscreen.set((Boolean)d.readObject());
                showMenu.set((Boolean)d.readObject());
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (ArrayIndexOutOfBoundsException ex)
            {
                //Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (d!=null)
            {
                d.close();
            }
        }
        else
        {
            System.out.println("No settings.xml file found... Using defaults.");
        }
    }
    
    ///Saves the settings to the default location (settings.xml)
    public static void saveSettings()
    {
        File file = new File("settings.xml");
        
        XMLEncoder e = null;
        try
        {
            e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
            
            //Connection
            e.writeObject(ipAddress.get());
            e.writeObject(port.get());
            e.writeObject(isServer.get());
            
            //Display
            e.writeObject(enableFullscreen.get());
            e.writeObject(showMenu.get());
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        if (e!=null)
        {
            e.flush();
            e.close();
        }
    }
}
