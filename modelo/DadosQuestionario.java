/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import service.ConnectBD;

/**
 *
 * @author Utilizador
 */
public class DadosQuestionario {

    private static ConnectBD ligacaoConn;
    private static Connection ligacao;
    private static ArrayList<Questionario> tQuestionario;

    public static ArrayList<Questionario> gettQuestionario(ConnectBD c) {
        lerQuestionario(c); // Ler BD Perguntas e Respostas e carregar tQuestionario  
        return tQuestionario;
    }

    public DadosQuestionario() {
    }

    public DadosQuestionario(ConnectBD c) {
        DadosQuestionario.ligacao = c.makeCon();
        tQuestionario = new ArrayList<>();
    }

    public static void gravaNovaPerguntaTema(ConnectBD c, String pergunta, String tema) {
        String sqlQuery = "insert into Pergunta(Pergunta,Tema) values(?,?)";
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, pergunta);
            pst.setString(2, tema);
            int result = pst.executeUpdate();
            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaNovaResposta(ConnectBD c, int idPergunta, String resposta, int valor) {
        String sqlQuery = "insert into Resposta(idPergunta, Resposta, Classificacao) values(?,?,?)";

        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, idPergunta);
            pst.setString(2, resposta);
            pst.setInt(3, valor);
            int result = pst.executeUpdate();
            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void removeResposta(ConnectBD c, int idPergunta) {
        String sqlQuery = "DELETE FROM Resposta WHERE idPergunta = ?";
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, idPergunta);

            int result = pst.executeUpdate();
            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaNovoTema(ConnectBD c, String tema) {
        String sqlQuery = "insert into Topics(Topic) values(?)";
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, tema);
            int result = pst.executeUpdate();
            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void lerQuestionario(ConnectBD c) {
        String sqlQuery1 = "select * from Pergunta";

        try {
            Connection con = c.makeCon();
            com.mysql.jdbc.ResultSet rs;
            PreparedStatement pst;

            pst = (PreparedStatement) con.prepareStatement(sqlQuery1);
            rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
            while (rs.next()) {
                String pergunta = rs.getString("Pergunta");
                int idPergunta = rs.getInt("idPergunta");
                String auxTema = rs.getString("Tema");
                tQuestionario.add(new Questionario(idPergunta, pergunta, auxTema));
            }

            // Ler Respostas para cada pergunta
            for (Questionario q : tQuestionario) {
                ArrayList<Resposta> r = new ArrayList<>();
                String sqlQuery2 = "select Resposta.Resposta, Resposta.Classificacao "
                        + "from Resposta "
                        + "where Resposta.idPergunta = " + q.getIdPergunta();
                pst = (PreparedStatement) con.prepareStatement(sqlQuery2);
                rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
                while (rs.next()) {
                    String resposta = rs.getString("Resposta");
                    int valor = rs.getInt("Classificacao");
                    r.add(new Resposta(resposta, valor));
                }
                q.setRespostas(r);
            }

            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void lerPerguntasPorTema(ConnectBD c, String tema) {
        String sqlQuery1 = "select * from Pergunta";

        try {
            if (tema != null) {
                sqlQuery1 = "select * from Pergunta "
                        + "where Pergunta.Tema = '" + tema + "'";
            }
//        String sqlQuery2 = "select Pergunta.Pergunta, Resposta.Resposta, Resposta.Classificacao " +
//                          "from Pergunta " +
//                          "INNER JOIN Resposta ON Pergunta.idPergunta = Resposta.idPergunta "+
//                          "where Pergunta.Tema = '"+tema+"'";

            Connection con = c.makeCon();

            com.mysql.jdbc.ResultSet rs;
            PreparedStatement pst;

            pst = (PreparedStatement) con.prepareStatement(sqlQuery1);
            rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
            while (rs.next()) {
                String pergunta = rs.getString("Pergunta");
                int idPergunta = rs.getInt("idPergunta");
                String auxTema = rs.getString("Tema");
                tQuestionario.add(new Questionario(idPergunta, pergunta, auxTema));
            }

            // Ler Respostas para cada pergunta
            for (Questionario q : tQuestionario) {
                ArrayList<Resposta> r = new ArrayList<>();
                String sqlQuery2 = "select Resposta.Resposta, Resposta.Classificacao "
                        + "from Resposta "
                        + "where Resposta.idPergunta = " + q.getIdPergunta();
                pst = (PreparedStatement) con.prepareStatement(sqlQuery2);
                rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
                while (rs.next()) {
                    String resposta = rs.getString("Resposta");
                    int valor = rs.getInt("Classificacao");
//                    System.out.println("Resposta " + resposta + " valor: " + valor);
                    r.add(new Resposta(resposta, valor));
                }
                q.setRespostas(r);
            }

            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<Questionario> lerPerguntasPorTemaArray(ConnectBD c, String tema) {
        ArrayList<Questionario> t = new ArrayList<>();
        try {
            
            String sqlQuery1 = "select * from Pergunta where Pergunta.Tema = '" + tema + "'";

//        String sqlQuery2 = "select Pergunta.Pergunta, Resposta.Resposta, Resposta.Classificacao " +
//                          "from Pergunta " +
//                          "INNER JOIN Resposta ON Pergunta.idPergunta = Resposta.idPergunta "+
//                          "where Pergunta.Tema = '"+tema+"'";
            Connection con = c.makeCon();

            com.mysql.jdbc.ResultSet rs;
            PreparedStatement pst;

            pst = (PreparedStatement) con.prepareStatement(sqlQuery1);
            rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
            while (rs.next()) {
                String pergunta = rs.getString("Pergunta");
                int idPergunta = rs.getInt("idPergunta");
                String auxTema = rs.getString("Tema");
                t.add(new Questionario(idPergunta, pergunta, auxTema));
            }

// Ler Respostas para cada pergunta
            for (Questionario q : t) {
                ArrayList<Resposta> r = new ArrayList<>();
                String sqlQuery2 = "select Resposta.Resposta, Resposta.Classificacao "
                        + "from Resposta "
                        + "where Resposta.idPergunta = " + q.getIdPergunta() 
                        + " order by idResposta";
                pst = (PreparedStatement) con.prepareStatement(sqlQuery2);
                rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
                while (rs.next()) {
                    String resposta = rs.getString("Resposta");
                    int valor = rs.getInt("Classificacao");
//                    System.out.println("Resposta " + resposta + " valor: " + valor);
                    r.add(new Resposta(resposta, valor));
                }
                q.setRespostas(r);
            }

            pst.close();
//            con.close();

            
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    public static void lerTemasToComboBox(ConnectBD c, JComboBox combo) {

        try {
            Connection con = c.makeCon();

            com.mysql.jdbc.ResultSet rs;
            PreparedStatement pst;

            pst = (PreparedStatement) con.prepareStatement("select distinct Topic from Topics order by idTopic");
            rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();
            combo.removeAllItems();
            combo.addItem("-- Choose the topic --");

            while (rs.next()) {
                String tema = rs.getString("Topic");
                combo.addItem(tema);
            }

//            rs.close();
//            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int getLastIDPergunta(ConnectBD c) {
        int id = -1;
        try {
            Connection con = c.makeCon();

            com.mysql.jdbc.ResultSet rs;
            PreparedStatement pst;

            pst = (PreparedStatement) con.prepareStatement("select max(idPergunta) from Pergunta");
            rs = (com.mysql.jdbc.ResultSet) pst.executeQuery();

            while (rs.next()) {
                id = rs.getInt("max(idPergunta)");
            }

//            rs.close();
//            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosQuestionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }

}
