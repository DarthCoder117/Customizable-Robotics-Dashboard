/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.application;

import java.util.LinkedList;

/**
 *
 * @author super
 */
public class EditorContext
{
    public interface IEditorContextListener
    {
       void onEditModeChanged(boolean editMode);
       
       void onSelectionChanged(DataWidget selected);
    }

    private static boolean editModeEnabled = false;
 
    public static void setEditMode(boolean enabled)
    {
        editModeEnabled = enabled;
        
        for (IEditorContextListener listener : editorContextListeners)
        {
            listener.onEditModeChanged(enabled);
        }
    }
    
    public static boolean isEditModeEnabled()
    {
        return editModeEnabled;
    }
    
    private static DataWidget selectedWidget = null;
    
    public static void setSelection(DataWidget widget)
    {
        selectedWidget = widget;
        
        for (IEditorContextListener listener : editorContextListeners)
        {
            listener.onSelectionChanged(selectedWidget);
        }
    }
    
    public static DataWidget getSelection()
    {
        return selectedWidget;
    }
    
    public static void addContextListener(IEditorContextListener listener)
    {
        editorContextListeners.add(listener);
    }
    
    public static void removeContextListener(IEditorContextListener listener)
    {
        editorContextListeners.remove(listener);
    }
    
    private static LinkedList<IEditorContextListener> editorContextListeners = new LinkedList<>();
}
