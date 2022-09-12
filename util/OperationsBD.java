/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador
 */
public class OperationsBD {
    public static void registaOperations(String linha){
        LocalDate data = LocalDate.now();
        FileWriter fw = null;
        try {
            
            File file =new File("synchSQL.txt");
            if(!file.exists()){
                file.createNewFile();
            }   fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data+" : "+linha);bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(OperationsBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(OperationsBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void deleteFile(){
        FileWriter fw = null;
        File file = new File("synchSQL.txt");
        if (file.exists()) {
            file.delete();
        }
    }
    
    public static ArrayList<String> lerLinhasSQL(){
        ArrayList<String> tLinhas = new ArrayList<>();
        try {
            
            Scanner ler = new Scanner(new File("synchSQL.txt"));
            while(ler.hasNext()){
                tLinhas.add(ler.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationsBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tLinhas;
    } 
    public static ArrayList<String> lerLinhasSQLDate(LocalDate date){
        ArrayList<String> tLinhas = new ArrayList<>();
        try {
            
            Scanner ler = new Scanner(new File("synchSQL.txt"));
            while(ler.hasNext()){
                String [] linhas = ler.nextLine().split(" : ");
                String [] data = linhas[0].split("-");
                int ano = Integer.parseInt(data[0]);
                int mes = Integer.parseInt(data[1]);
                int dia = Integer.parseInt(data[2]);
                LocalDate dateSave = LocalDate.of(ano, mes, dia);
                if (dateSave.isBefore(date.plusDays(1))){
                    tLinhas.add(linhas[1]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationsBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tLinhas;
    } 
}
