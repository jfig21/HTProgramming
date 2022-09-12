/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;

/**
 *
 * @author Utilizador
 */
public class TestOperationBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        OperationsBD.deleteFile();
//        OperationsBD.registaOperations("linha1");
//        OperationsBD.registaOperations("linha2");
//        OperationsBD.registaOperations("linha3");
//        OperationsBD.registaOperations("linha4");
        for (String s: OperationsBD.lerLinhasSQLDate(LocalDate.now())){
            System.out.println(""+s);
        }
    }
    
}
