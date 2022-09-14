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
public interface DadosPeduca {
//    Acesso remoto Amen.pt
    String [] tHost = new String[]{
                "xxx.xxx.net"
        };
    String defaultBD = "";
    String user = "";
    String passwd = "";
    
    String workDirDocuments = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
//
 // Acesso local / IPG   
//    String [] tHost = new String[]{
//                "localhost",        // iHost = 0
//                "192.168.23.32",    // iHost = 1 Rede IPG: bd.ipg.pt
//                "bd.ipg.pt"};//"172.16.18.89" };//193.137.162.19"};  // iHost = 2 RedeExterna
//    String defaultBD = "";
//    String user = "";
//    String passwd = "";
  // Fim acesso local
}
