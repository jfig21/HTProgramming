/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AlunoExpert;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Utilizador
 */
public class UtilFiles {

    public static void createFileCSV(String namefilecsv, ArrayList<AlunoExpert> dados) {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(namefilecsv));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Presences", "SP", "PH", "IC", "PP", "Basic", "If", "Loop", "Array", "Advanced"));) {
            for (AlunoExpert ae : dados) {
                csvPrinter.printRecord(ae.getPresences(),ae.getSp(),ae.getSv(),ae.getIc(),ae.getPp(),ae.getBasic(),
                        ae.getIfs(),ae.getLoop(),ae.getArrays(),ae.getAdv());
            }

            csvPrinter.flush();
        } catch (IOException ex) {
            Logger.getLogger(UtilFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void readFileCSV(String namefilecsv) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(namefilecsv));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("Presences", "SP", "PH", "IC", "PP", "Basic", "If", "Loop", "Array", "Advanced")
                        .withIgnoreHeaderCase()
                        .withTrim());) {
            
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by the names assigned to each column
             /*     String presences = csvRecord.get("Presences");
                String sp = csvRecord.get("SP");
                String ph = csvRecord.get("PH");
                String ic = csvRecord.get("IC");
                String pp = csvRecord.get("PP");
                String basic = csvRecord.get("Basic");
                String ifs = csvRecord.get("If");
                String loop = csvRecord.get("Loop");
                String arrays = csvRecord.get("Array");
                String advanced = csvRecord.get("Advanced");

              System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Presences : " + presences);
                System.out.println("SP : " + sp);
                System.out.println("PH : " + ph);
                System.out.println("IC : " + ic);
                System.out.println("PP : " + pp);
                System.out.println("Basic : " + basic);
                System.out.println("IF : " + ifs);
                System.out.println("Loop : " + loop);
                System.out.println("Array : " + arrays);
                System.out.println("Advanced : " + advanced);
  
                System.out.println("---------------\n\n");*/
            }
        } catch (IOException ex) {
            Logger.getLogger(UtilFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
