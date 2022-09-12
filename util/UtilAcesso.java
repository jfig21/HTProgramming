/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Aluno;
import service.ConnectBD;

/**
 *
 * @author Quitério
 */
public class UtilAcesso {

    private static LocalDateTime inicio;
    private static LocalDateTime fim;
    
    
    public UtilAcesso() {
        this.registaInicio();
        UtilAcesso.fim = null;
        this.totalMinutos = 0;
    }
    
    private long totalMinutos;

    private void registaInicio() {
        UtilAcesso.inicio = LocalDateTime.now();
    }

    private void registaFim() {
        UtilAcesso.fim = LocalDateTime.now();
    }
    
    private void calculaTempo(){
        registaFim();
        Duration duration = Duration.between(inicio, fim);
        totalMinutos = Math.abs(duration.toMinutes());
    }

    public long getTotalMinutos() {
        calculaTempo();
        return totalMinutos;
    }
    
    public Date localDateTimeTODate(){
        //LocalDateTime dt = LocalDateTime.now();
        java.sql.Date data = java.sql.Date.valueOf(inicio.toLocalDate());
        return data;
    }
    
    
    
    public void registaAcesso(ConnectBD c, Aluno aluno){
        java.sql.Date data = localDateTimeTODate();
        long tempo = this.getTotalMinutos();
        String sqlQuery = "insert into acessos(idAluno,Numero,UltimoAcesso,TempoAcesso) "
                + "Values(?,?,?,?)";
                
        Connection con = c.makeCon();
        PreparedStatement pst;
        
        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, aluno.getIdAluno());
            pst.setString(2, aluno.getNumero());
            pst.setDate(3, data);
            pst.setLong(4, tempo);
            
            int result = pst.executeUpdate();
            
            pst.close();
//            con.close();
        } catch (SQLException ex) {
            System.out.println("Aqui...");
           Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    
    public void registaAtivo(ConnectBD c, Aluno aluno){
        String sqlQuery = "INSERT INTO ativos (Numero) "+
            "SELECT * FROM (SELECT ?) AS tmp "+
                "WHERE NOT EXISTS ( "+
                    "SELECT Numero FROM ativos WHERE Numero = '"+aluno.getNumero()+"' "+
                ") LIMIT 1";
        
        Connection con = c.makeCon();
        PreparedStatement pst;
        
        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
           
            pst.setString(1, aluno.getNumero());
                        
            int result = pst.executeUpdate();
            
            pst.close();
//            con.close();
        } catch (SQLException ex) {
           Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean testarAtivo(ConnectBD c, Aluno aluno){
        boolean ativo = false;
        String sqlQuery = "SELECT * FROM ativos WHERE Numero = ? Limit 1;";
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, aluno.getNumero());
            ResultSet result = pst.executeQuery();
            ativo = result.next();
            pst.close();
//            con.close(); // Em comentário porque depois necessito de apagar
        } catch (SQLException ex) {
           Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ativo;
    }
    
    public static ArrayList<Integer> getTabsBlock(ConnectBD c){
        ArrayList<Integer> tBlock = new ArrayList<>();
        String sqlQuery = "SELECT status FROM viewactivity";
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            ResultSet result = pst.executeQuery();
            while (result.next()){
                int valor = result.getInt("status");
                tBlock.add(valor);
            }
            pst.close();
//            con.close(); // Em comentário porque depois necessito de apagar
        } catch (SQLException ex) {
           Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tBlock;
    }
    public static void setTabsBlock(ConnectBD c, ArrayList<Integer> tb){
        
        String sqlQuery = "UPDATE viewactivity SET status = ? WHERE idAtvView = ?";
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            for (int i = 0; i < tb.size(); i++) {
                int status = tb.get(i).intValue();
                int tab = (i + 1);
                pst.setInt(1, status);
                pst.setInt(2, tab);
                pst.executeUpdate();
            }
            pst.close();
//            con.close(); // Em comentário porque depois necessito de apagar
        } catch (SQLException ex) {
           Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void apagaAtivo(ConnectBD c, Aluno aluno){
        String sqlQuery = "delete from ativos "+
                "where Numero = ? ";
        
        Connection con = c.makeCon();
        PreparedStatement pst;
        
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, aluno.getNumero());
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
           Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void NOVOregistaAcesso(ConnectBD c, Aluno aluno){
        java.sql.Date data = localDateTimeTODate();
        long tempo = this.getTotalMinutos();
        String sqlQuery = "insert into acessos(idAluno,Numero,UltimoAcesso,TempoAcesso) "
                + "Values(?,?,?,?)";
                
        Connection con = c.makeCon();
        PreparedStatement pst;
        
        try {

//            con.setAutoCommit(false);
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, aluno.getIdAluno());
            pst.setString(2, aluno.getNumero());
            pst.setDate(3, data);
            pst.setLong(4, tempo);
            
            int result = pst.executeUpdate();
//            con.commit();
            
            pst.close();
//            con.close();
        } catch (SQLException ex) {
            System.out.println("Se existir um erro testa rollback");
            Logger.getLogger(UtilAcesso.class.getName()).log(Level.SEVERE, null, ex);
            try {
                System.out.println("Entra depois de tempo ....");
                ConnectBD liga = new ConnectBD();

                pst = (PreparedStatement) con.prepareStatement(sqlQuery);
                pst.setInt(1, aluno.getIdAluno());
                pst.setString(2, aluno.getNumero());
                pst.setDate(3, data);
                pst.setLong(4, tempo);

                int result = pst.executeUpdate();
                System.out.println("Result: " + result);
//            con.commit();

                pst.close();

            } catch (SQLException se2) {
                System.out.println("Erro rollback");
            }//end try
        }
        
    }
     


}
