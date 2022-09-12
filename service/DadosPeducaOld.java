/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Quitério
 */
public interface DadosPeducaOld {
    String[] tHost = new String[]{
        "localhost", // iHost = 0
    };
    String defaultBD = "";
    String user = "";
    String passwd = "";
    
    String workDirDocuments = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

//    String[] tHost = new String[]{
//        "localhost", // iHost = 0
//    };
//    String defaultBD = "";
//    String user = "";
//    String passwd = "";
//    
//    String workDirDocuments = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

//    String [] tHost = new String[]{
//                "localhost",        // iHost = 0
//                "192.168.11.19",    // iHost = 1 Rede IPG
//                "193.137.162.19"};  // iHost = 2 RedeExterna
//    String defaultBD = "";
//    String user = "";
//    String passwd = "";
    
//    String [] tHost = new String[]{
//                "localhost",        // iHost = 0
//                "192.168.23.32",    // iHost = 1 Rede IPG: bd.ipg.pt
//                "bd.ipg.pt"};       //"172.16.18.89" };//193.137.162.19"};  // iHost = 2 RedeExterna
//    String defaultBD = "";
//    String user = "";
//    String passwd = "";
//    String user = "";
//    String passwd = "";
}
