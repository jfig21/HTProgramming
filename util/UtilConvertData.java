/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Utilizador
 */
public class UtilConvertData {

    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    
    public static java.util.Date convertLocalDateToUtilDate(LocalDate localDate){
        return java.sql.Date.valueOf(localDate);
    }
    
    public static LocalDate convertStringToLocalDate(String data){
        int ano = Integer.parseInt(data.substring(0, 4));
        int mes = Integer.parseInt(data.substring(5, 7));
        int dia = Integer.parseInt(data.substring(8, 10));
        return LocalDate.of(ano, mes, dia);
    }
}
