/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AtividadeConf;
import service.ConnectBD;

/**
 *
 * @author Utilizador
 */
public class NewUtilBD {

    public static int getIDAtividade(ConnectBD c, String numero) {
        int id = 0;
        String sqlQuery = "select idatividade from newatividades where numeroAtv = ?";

        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static void updateAtividade(ConnectBD c, AtividadeConf atividade) {
        String sqlQuery = "update newatividades "
                + "SET data = ?, texto = ?, nInput = ?, output = ?, nTest = ?, commentCodeKey = ? "
                + "WHERE numeroAtv = ?";

        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setDate(1, java.sql.Date.valueOf(atividade.getDataAtividade()));
            pst.setString(2, atividade.getEnunciado());
            pst.setInt(3, atividade.getnInput());
            String auxs = "";
            for (String s : atividade.getOutput()) {
                auxs += s;
            }
            pst.setString(4, auxs);
            pst.setInt(5, atividade.getnTest());
            auxs = "";
            for (String s : atividade.getCommentKey()) {
                auxs += s;
            }
            pst.setString(6, auxs);
            pst.setString(7, atividade.getNumeroAtv());

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewUtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void inserirAtividade(ConnectBD c, AtividadeConf atividade) {
        String sqlQuery = "insert into newatividades(numeroAtv,data,texto,nInput,output,nTest,commentCodeKey) "
                + "values(?,?,?,?,?,?,?)";

        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, atividade.getNumeroAtv());
            pst.setDate(2, java.sql.Date.valueOf(atividade.getDataAtividade()));
            pst.setString(3, atividade.getEnunciado());
            pst.setInt(4, atividade.getnInput());
            String auxs = "";
            for (String s : atividade.getOutput()) {
//                auxs += s + "\n";
                auxs += s;
            }
            pst.setString(5, auxs);
            pst.setInt(6, atividade.getnTest());
            auxs = "";
            for (String s : atividade.getCommentKey()) {
//                auxs += s + "\n";
                auxs += s;
            }
            pst.setString(7, auxs);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(NewUtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResultSetTableModel verAtividades(ConnectBD ligacao) {
        // Ler Atividades
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT newatividades.idatividade, newatividades.numeroAtv, newatividades.data FROM newatividades "
                + "order by idatividade";
        Connection con = ligacao.makeCon();

        try {
            tmodel = new ResultSetTableModel(ligacao.getDriver(), ligacao.getUrl(), ligacao.getUser(), ligacao.getPasswd(), sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ligacao.closeConnection();
        return tmodel;
    }

    public static ResultSetTableModel verAtividadesNumber(ConnectBD ligacao, String number) {
        // Ler Atividades
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT * FROM newatividades WHERE numeroAtv = " + number;

        Connection con = ligacao.makeCon();

        try {
            tmodel = new ResultSetTableModel(ligacao.getDriver(), ligacao.getUrl(), ligacao.getUser(), ligacao.getPasswd(), sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ligacao.closeConnection();
        return tmodel;
    }

    public static ResultSetTableModel verNumberAtividades(ConnectBD ligacao) {
        // Ler Atividades
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT numeroAtv FROM newatividades WHERE NOT numeroAtv Like '9%' ORDER BY numeroAtv";
        Connection con = ligacao.makeCon();

        try {
            tmodel = new ResultSetTableModel(ligacao.getDriver(), ligacao.getUrl(), ligacao.getUser(), ligacao.getPasswd(), sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ligacao.closeConnection();
        return tmodel;
    }
    public static ResultSetTableModel verNumberAtividadesAluno(ConnectBD ligacao) {
        // Ler Atividades do aluno
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT numeroAtv,data FROM newatividades WHERE NOT numeroAtv Like '9%' order by numeroAtv";
        Connection con = ligacao.makeCon();

        try {
            tmodel = new ResultSetTableModel(ligacao.getDriver(), ligacao.getUrl(), ligacao.getUser(), ligacao.getPasswd(), sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ligacao.closeConnection();
        return tmodel;
    }
    public static ResultSetTableModel verNumberAtividadesAluno(ConnectBD ligacao, String data) {
        // Ler Atividades do aluno por data
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT numeroAtv,data FROM newatividades "
                + "WHERE NOT numeroAtv Like '9%' "
                + "AND data >= '"+data+"' " 
                + "order by numeroAtv";
        Connection con = ligacao.makeCon();

        try {
            tmodel = new ResultSetTableModel(ligacao.getDriver(), ligacao.getUrl(), ligacao.getUser(), ligacao.getPasswd(), sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        ligacao.closeConnection();
        return tmodel;
    }
    
    public static int getnTestCodeKeysAtividade(ConnectBD c, String numero) {
        int nTest = 0;
        String sqlQuery = "select nTest from newatividades where numeroAtv = ?";

        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                nTest = rs.getInt(1);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nTest;
    }
    
     public static String getCodeKeysAtividade(ConnectBD c, String numero) {
        String codeKeys = "";
        String sqlQuery = "select commentCodeKeys from newatividades where numeroAtv = ?";

        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                codeKeys = rs.getString(1);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codeKeys;
    }
     public static String getResolucaoAtividade(ConnectBD c, String numero) {
        String resolucao = "";
        String sqlQuery = "select resolucao from atividadesresultados where idatividade = ?";
        int idAtividade = NewUtilBD.getIDAtividade(c, numero);
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, idAtividade);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                resolucao = rs.getString(1);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resolucao;
    }
}
