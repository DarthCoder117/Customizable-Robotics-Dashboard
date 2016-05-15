/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Global settings class for convenient access to configuration values.
 */
public class DashboardSettings 
{
    private static final Properties properties = new Properties();
    
    public static void setShowMenu(boolean show)
    {
        properties.setProperty("show-menu", String.valueOf(show));
    }
    
    public static boolean getShowMenu()
    {
        return Boolean.parseBoolean(properties.getProperty("show-menu", "true"));
    }
    
    public static void setFullscreen(boolean fullscreen)
    {
        properties.setProperty("fullscreen", String.valueOf(fullscreen));
    }
    
    public static boolean getFullscreen()
    {
        return Boolean.parseBoolean(properties.getProperty("fullscreen", "false"));
    }
    
    public static void setIpAddress(String ip)
    {
        //TODO: Validate ip address
        
        properties.setProperty("ip-address", ip);
    }
    
    public static String getIpAddress()
    {
        return properties.getProperty("ip-address", "127.0.0.1");
    }
    
    public static void setPort(int port)
    {
        properties.setProperty("port", String.valueOf(port));
    }
    
    public static int getPort()
    {
        return Integer.parseInt(properties.getProperty("port", "4309"));
    }
    
    public static void setIsServer(boolean isServer)
    {
        properties.setProperty("is-server", String.valueOf(isServer));
    }
    
    public static boolean getIsServer()
    {
        return Boolean.parseBoolean(properties.getProperty("is-server", "false"));
    }
    
    ///Loads the settings from the default location (settings.xml)
    public static void loadSettings()
    {
        File file = new File("settings.xml");
        try 
        {
            FileInputStream inputStream = new FileInputStream(file);
            properties.loadFromXML(inputStream);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ///Saves the settings to the default location (settings.xml)
    public static void saveSettings()
    {
        File file = new File("settings.xml");
        try 
        {
            FileOutputStream outputStream = new FileOutputStream(file);
            properties.storeToXML(outputStream, null);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DashboardSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
