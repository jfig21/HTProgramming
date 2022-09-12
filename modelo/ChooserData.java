/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class ChooserData {

     public ChooserData(String data) {
        Scanner scanner = new Scanner(data);
        Scanner dayScanner = new Scanner(scanner.next());
        dayScanner.useDelimiter("-");

        this.ano = dayScanner.nextInt();
        this.mes = dayScanner.nextInt();
        this.dia = dayScanner.nextInt();
    }
    
    public ChooserData(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }
    
     public ChooserData(JDateChooser d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dfDia = new SimpleDateFormat("dd");
        DateFormat dfMes = new SimpleDateFormat("MM");
        DateFormat dfAno = new SimpleDateFormat("yyyy");
        String ano = dfAno.format(d.getDate());
        String mes = dfMes.format(d.getDate());
        String dia = dfDia.format(d.getDate());
        this.ano = Integer.parseInt(ano);
        this.mes = Integer.parseInt(mes);
        this.dia = Integer.parseInt(dia);
    }
    
    private int ano;
    private int mes;
    private int dia;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "ChooserData{" + "ano=" + ano + ", mes=" + mes + ", dia=" + dia + '}';
    }
    
}
