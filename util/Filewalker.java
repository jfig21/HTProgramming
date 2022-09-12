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

import java.io.File;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import service.ConnectBD;

public class Filewalker {

    private JTree tree;
    private Object[] table;
    
    public void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;
        
        for ( File f : list) {
            if (f.isFile()) {
//                walk(f.getAbsolutePath());
                if (f.getName().regionMatches(0, "conf", 0, 3)) {
                    String number = f.getName().substring(4, f.getName().length()-4);
                    String parte1 = number.substring(0, 3);
                    String parte2 = number.substring(3, 5);
                    String atv = "Ex"+number;
                    
                    System.out.println(""+atv+ "\t"+parte1+"\t"+parte2);
                }
            }
            
        }
    }

    public JTree getAtividades(String path){
 
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Activities");
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode exercise = null;
        
        createNodes(top, path);
        tree = new JTree(top);
        
        return tree;
    }
    
   
    private void createNodes(DefaultMutableTreeNode top, String path) {
        
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode exercise = null;
        
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;
        
        for ( File f : list) {
            if (f.isFile()) {
//                walk(f.getAbsolutePath());
                if (f.getName().regionMatches(0, "conf", 0, 3)) {
                    String number = f.getName().substring(4, f.getName().length()-4);
                    String parte1 = number.substring(0, 3);
                    String parte2 = number.substring(3, 5);
                    String atv = "Ex"+number;
                    category = new DefaultMutableTreeNode(atv);
                    top.add(category);

                }
            }
            
        }
        
      
    }
    
  
//    public static void main(String[] args) {
//        Filewalker fw = new Filewalker();
//        fw.walk("C:\\_Projeto\\HTProgramming\\IFB" );
//    }

}
