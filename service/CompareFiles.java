/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Utilizador
 */
public class CompareFiles {

    public static boolean compareFiles(String path1, String path2) {
        boolean isTwoEqual = false;
        try {
            File file1 = new File(path1);
            File file2 = new File(path2);
            isTwoEqual = FileUtils.contentEquals(file1, file2);
        } catch (IOException ex) {
            System.out.println("Ficheiro nao encontrado");
            Logger.getLogger(CompareFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isTwoEqual;
    }

   
}
