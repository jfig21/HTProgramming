/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import service.DadosPeduca;

/**
 *
 * @author Utilizador
 */
public class CodeInspection {

    public static void lerValores(ArrayList<String> t) {
        String pattern = "-?\\d+(\\.\\d+)?";
        for (String s : t) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);
            while (m.find()) {
                System.out.println("aqui: " + m.group());
            }
        }
    }

    public static ArrayList<String> lerValoresAList(ArrayList<String> t) {
        ArrayList<String> o = new ArrayList<>();
        String pattern = "-?\\d+(\\.\\d+)?";
        for (String s : t) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);
            while (m.find()) {
                o.add(m.group());
            }
        }
        return o;
    }

    public static ArrayList<String> lerValoresString(String s) {
        ArrayList<String> o = new ArrayList<>();
        String pattern = "-?\\d+(\\.\\d+)?";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        while (m.find()) {
            o.add(m.group());
        }
        return o;
    }

    public static ArrayList<String> pesquisaCod(String cod, String filenametxt) {
        ArrayList<String> linhas = new ArrayList<>();
        String content;
        String codinicio = "<" + cod + ">";
        String codfim = "</" + cod + ">";
        int startPosition = 0;
        int startPositionOld = -1;
        int endPosition;
//        String workingDir = System.getProperty("user.dir") + "\\IFB";
        String workingDir = DadosPeduca.workDirDocuments + "\\CodingHTProgramming";
        try {

            content = new String(Files.readAllBytes(Paths.get(workingDir + "\\" + filenametxt + ".txt")));
            int fim = content.indexOf("<FIM>");
            while (startPosition < fim) {
                startPosition = content.indexOf(codinicio, startPosition) + codinicio.length();
                if (startPositionOld >= startPosition) {
                    break;
                }
                endPosition = content.indexOf(codfim, startPosition);
                if ((startPosition == -1) || (endPosition == -1)) {
                    break;
                }
                String subS = content.substring(startPosition, endPosition);
                linhas.add(subS);
                startPositionOld = startPosition;
                startPosition = endPosition + codfim.length() + 2;
            }
        } catch (IOException ex) {
            // Nome do ficheiro não existe !!!
            Logger.getLogger(CodeInspection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }

    public static int checkInstallGcc(){
        int exitvalue = 1;
        try {
            Process p = Runtime.getRuntime().exec("cmd /C gcc -v");
            p.waitFor();
            exitvalue = p.exitValue();
        } catch (InterruptedException ex) {
            Logger.getLogger(CodeInspection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodeInspection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exitvalue;
    }
    
    public static void CompileCprog(String filename, String workingDir) {

//        String workingDir = System.getProperty("user.dir") + "\\IFB";
        File dir = new File(workingDir);
        String fileError = workingDir + "\\error.txt";
        File file = new File(fileError);
        file.delete();
        try {
            String exeName = filename.substring(0, filename.length() - 2);
            Process p = Runtime.getRuntime().exec("cmd /C gcc -Wall " + filename + " -o " + exeName + " 2>error.txt", null, dir);

            p.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(CodeInspection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // write message to process
    public static void writeToProc(OutputStream out, String msg) throws IOException {
        // <change>
        // Using UTF-8 encoding since all chars in C are byte sized
        byte[] buff = msg.getBytes("UTF-8");
        out.write(buff);
        out.flush();
        System.out.println("done writing: " + new String(buff));
    }

    // read stdin of process
    public static void readFromProc(InputStream in) throws IOException {
        byte[] buff = new byte[256];
        int read = in.read();
        int index = 0;
        while (read != -1) {
            buff[index] = (byte) read;
            read = in.read();
            ++index;
        }
        String str = new String(buff, 0, index);

        System.out.println("Output Aluno: " + str);
    }

    public static String readFromAlunoProc(InputStream in) throws IOException {
//        byte[] buff = new byte[256];
        byte[] buff = new byte[1025];
        int read = in.read();
        int index = 0;
        while (read != -1) {
            buff[index] = (byte) read;
            read = in.read();
            ++index;
        }
        String str = new String(buff, 0, index);

        return str;
    }

    public static String readFileAsString(String fileName) throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    
    public static int searchKeys(String filePath, String searchQuery) throws IOException {
//        searchQuery = searchQuery.trim();
        BufferedReader br = null;
        int trueFind = 0;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchQuery)) {
                    trueFind++;
                    return trueFind;
                }
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.err.println("Exception while closing bufferedreader " + e.toString());
            }
        }

        return trueFind;
    }

    
    public static void parseOutput(String workDir,String infile, String outfile) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(workDir+infile)));
            String line;
            while ((line = br.readLine()) != null) {
                // Transformar tudo em minusculas
//                System.out.println("line: "+line);
                line = line.toLowerCase();
                line = line.replaceAll("\r\n","99x"); 
                System.out.println(line);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.err.println("Exception while closing bufferedreader " + e.toString());
            }
        }

    }

}
