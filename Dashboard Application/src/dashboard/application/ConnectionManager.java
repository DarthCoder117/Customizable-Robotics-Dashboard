/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import edu.cwu.rrdtp.Connection;
import java.util.LinkedList;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author super
 */
public class ConnectionManager 
{
    private static final Connection rrdtpConnection = new Connection();
    private static final PauseTransition pollTask = new PauseTransition(Duration.millis(33.333333));
    
    private static final LinkedList<DataWidget> widgets = new LinkedList<>();
    
    public static Connection getConnection()
    {
        return rrdtpConnection;
    }
    
    public static void resetConnection()
    { 
        System.out.println("Starting new connection...");
        
        close();
        
        int port = DashboardSettings.getPort();

        if (DashboardSettings.getIsServer())
        {
            System.out.println("Mode: server");
            rrdtpConnection.startServer(port);
        }
        else
        {
            System.out.println("Mode: client");
            String ip = DashboardSettings.getIpAddress();
            System.out.println("IP Address: "+ip);
            
            rrdtpConnection.startClient(ip, port);
        }
        
        System.out.println("Port: "+port);
        
        //Reset background polling task
        //TODO: Add polling frequency option
        pollTask.setOnFinished((ActionEvent e) -> {
            
            for (DataWidget widget : widgets)
            {
                widget.update();
            }
            
            rrdtpConnection.poll();
            
            pollTask.playFromStart();
        });
        pollTask.play();
    }
    
    public static void connectDataWidget(DataWidget widget)
    {
        widgets.add(widget);
    }
    
    public static void close()
    {
        pollTask.stop();
        rrdtpConnection.close();
    }
}
