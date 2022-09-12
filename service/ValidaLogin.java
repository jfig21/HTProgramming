/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.lambdaworks.crypto.SCryptUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quitério
 */
public class ValidaLogin {
    public static String codifica(String originalPassword){
        String generatedSecuredPasswordHash = SCryptUtil.scrypt(originalPassword, 16, 16, 16);
        return generatedSecuredPasswordHash;
    }
    
    public static void utilCodifica(String originalPassword){
        String generatedSecuredPasswordHash = SCryptUtil.scrypt(originalPassword, 16, 16, 16);
        System.out.println("Pass: " +generatedSecuredPasswordHash);
    }
    
    public static boolean validaLogin(ConnectBD ligacao,String login, String pass){
        String sqlQuery = "select idAluno,passwd from alunos where login = ?";
        String passGuardada = "";
        boolean matched = false;
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1,login);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                 passGuardada = rs.getString("passwd");
            } 
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ValidaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!"".equals(passGuardada)){
            matched = SCryptUtil.check(pass, passGuardada);
        }
        return matched;
    }
    
}
