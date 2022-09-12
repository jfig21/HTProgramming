/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Utilizador
 */
import javax.swing.*;

/**
 * Basic CursorToolkit that still allows mouseclicks
 */
public class CursorToolkit implements Cursors {

   
    public static void startWaitCursor(JComponent component) {

        RootPaneContainer root
                = (RootPaneContainer) component.getTopLevelAncestor();
        root.getGlassPane().setCursor(WAIT_CURSOR);
        root.getGlassPane().setVisible(true);
    }

    /**
     * Sets cursor for specified component to normal cursor
     */
    public static void stopWaitCursor(JComponent component) {

        RootPaneContainer root
                = (RootPaneContainer) component.getTopLevelAncestor();
        root.getGlassPane().setCursor(DEFAULT_CURSOR);
        root.getGlassPane().setVisible(false);
    }

}
