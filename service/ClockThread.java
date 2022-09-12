/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Quitério
 */
public class ClockThread extends Thread {

    public ClockThread(int time, JLabel label) {
        this.time = time;
        this.label = label;
    }
    
    private int time;
    private JLabel label;

    public void run() {
        try {
            while (time >= 0) {
                ClockThread.sleep(1000);
                int minutos = time / 60;
                int segundos = time % 60;
                if (time <= 15){
                    label.setForeground(Color.red);
                }
                label.setText(String.format("%02d:%02d", minutos,segundos));
                time--;
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ClockThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
