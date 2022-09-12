/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import modelo.Aluno;
import modelo.Atividade;
import modelo.AtividadeConf;
import modelo.DadosCoding;
import modelo.DadosPreAtv;
import modelo.LeagueGame;
import modelo.NumeroPerfil;
import service.ConnectBD;
import service.DadosPeduca;
import service.IOImagem;

/**
 *
 * @author JFig
 */
public class UtilBDConsulta {

    public static String[] readParsonSolucao(ConnectBD c, String descricao){
        String sqlQuery = "select solucao from parsonproblems where descricao = ?";
        String text = "";
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, descricao);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                text = rs.getString(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] linhas = text.split("\n");
        
        return linhas;
    }
    
    public static DefaultListModel readListToJListText(ConnectBD c, String descricao){
        DefaultListModel listModel = new DefaultListModel();
  
        String sqlQuery = "select enunciado from parsonproblems where descricao = ?";
        String text = "";
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, descricao);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                text = rs.getString(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] linhas = text.split("\n");
        for (String s : linhas){
            listModel.addElement(s);
        }
        return listModel;
    }
    
    
    public static void readParsonToComboBox(ConnectBD c, JComboBox combo){
       
        String sqlQuery = "select descricao from parsonproblems";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            combo.removeAllItems();
            combo.addItem("-- Choose Parson Problem --");
            while (rs.next()) {
                String descricao = rs.getString("descricao");
                combo.addItem(descricao);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static ResultSetTableModel verTudo(ConnectBD ligacao) {
        ResultSetTableModel tmodel = null;
//        String sqlQuery = "{ call getAllTableAlunos() }";
        String sqlQuery = "select * from alunos";
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

        public static ResultSetTableModel verActiveStudents(ConnectBD ligacao) {
        ResultSetTableModel tmodel = null;
//        String sqlQuery = "{ call getAllTableAlunos() }";
        String sqlQuery = "select Numero from ativos";
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
    
    public static ResultSetTableModel verAtividades(ConnectBD ligacao) {
        // Ler Atividades
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT atividades.idatividade, atividades.atividade, atividades.data FROM atividades "
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
    public static ResultSetTableModel verTodosQuestionarios(ConnectBD ligacao) {
        // Ler Atividades
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT idPergunta, Tema, Pergunta FROM pergunta order by idPergunta";
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
    public static ResultSetTableModel verStudentCharacterization(ConnectBD ligacao) {
        // Ler Atividades
        ResultSetTableModel tmodel = null;
        String sqlQuery = "{ call getStudentCharacterization() } ";
//        String sqlQuery = "SELECT Numero, Data, NRepete, CursoAnterior, OpcaoEntrada, MediaCandidatura,"
//                + "ComputadorPessoal, LigacaoInternet, NivelInformaticaGeral, NivelProgramacao,"
//                + "LinguagensUtilizadas, Resultado FROM caraterizacaoaluno "
//                + "order by Numero";
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

    public static ResultSetTableModel verAtividades(ConnectBD ligacao, String numero) {
        // Ler tudo da Tabela Actividades e colocar em JTable
        ResultSetTableModel tmodel = null;
//        String sqlQuery = "SELECT atividades.atividade, atividades.data, atividadesresultados.resultado "
//                + "FROM atividades "
//                + "INNER JOIN atividadesresultados ON atividades.idatividade = atividadesresultados.idatividade "
//                + "WHERE atividadesresultados.numero =" + numero;
        String sqlQuery = "SELECT atividades.atividade, atividadesresultados.data, atividadesresultados.resultado "
                + "FROM atividades "
                + "INNER JOIN atividadesresultados ON atividades.idatividade = atividadesresultados.idatividade "
                + "WHERE atividadesresultados.numero =" + numero;

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

    public static ResultSetTableModel verNewAtividades(ConnectBD ligacao, String numero) {
        // Ler tudo da Tabela Actividades e colocar em JTable
        ResultSetTableModel tmodel = null;

        String sqlQuery = "SELECT newatividades.numeroAtv, atividadesresultados.data, atividadesresultados.resultado "
                + "FROM newatividades "
                + "INNER JOIN atividadesresultados ON newatividades.idatividade = atividadesresultados.idatividade "
                + "WHERE atividadesresultados.numero = " + numero 
                + " AND NOT newatividades.numeroAtv LIKE '9%'";  // Esta linha para não aparecer PreAtv
//  Retirei esta ultima parte para não aparecer Questionarios nesta tabela 
//                + " UNION ALL SELECT idTopic, data, resultado FROM resultadosquestionarios "
//                + "where resultadosquestionarios.numero = " + numero ;
//        String sqlQuery = "{ call getAllActivitiesByNumber('"+numero+"') }";
        
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
    public static ResultSetTableModel verNewAtividades(ConnectBD ligacao, String numero, String data) {
        // Ler tudo da Tabela Actividades e colocar em JTable
        ResultSetTableModel tmodel = null;

        String sqlQuery = "SELECT newatividades.numeroAtv, atividadesresultados.data, atividadesresultados.resultado "
                + "FROM newatividades "
                + "INNER JOIN atividadesresultados ON newatividades.idatividade = atividadesresultados.idatividade "
                + "WHERE atividadesresultados.numero = " + numero 
                + " AND atividadesresultados.data >= '"+data+"'"
                + " AND NOT newatividades.numeroAtv LIKE '9%'";  // Esta linha para não aparecer PreAtv
//  Retirei esta ultima parte para não aparecer Questionarios nesta tabela 
//                + " UNION ALL SELECT idTopic, data, resultado FROM resultadosquestionarios "
//                + "where resultadosquestionarios.numero = " + numero ;
//        String sqlQuery = "{ call getAllActivitiesByNumber('"+numero+"') }";
        
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
    public static ArrayList<DadosCoding> getDadosCodingNewAtividades(ConnectBD ligacao, String numero) {
       ArrayList<DadosCoding> tDados = new ArrayList();

        String sqlQuery = "SELECT newatividades.numeroAtv, atividadesresultados.data, atividadesresultados.resultado "
                + "FROM newatividades "
                + "INNER JOIN atividadesresultados ON newatividades.idatividade = atividadesresultados.idatividade "
                + "WHERE atividadesresultados.numero = " + numero 
                + " AND NOT newatividades.numeroAtv LIKE '9%'"; // Esta linha para não aparecer PreAtv
//  Retirei esta ultima parte para não aparecer Questionarios nesta tabela 
//                + " UNION ALL SELECT idTopic, data, resultado FROM resultadosquestionarios "
//                + "where resultadosquestionarios.numero = " + numero ;
//        String sqlQuery = "{ call getAllActivitiesByNumber('"+numero+"') }";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();

            while (rs.next()) {
                String numberAct = rs.getString("numeroAtv");
                Date date = rs.getDate("data");
                LocalDate datalocal = date.toLocalDate();
                int resultado = rs.getInt("resultado");
                tDados.add(new DadosCoding(numberAct,datalocal,resultado));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tDados;
    }
    public static ArrayList<DadosCoding> getDadosCodingNewAtividades(ConnectBD ligacao, String numero, String data) {
       ArrayList<DadosCoding> tDados = new ArrayList();

        String sqlQuery = "SELECT newatividades.numeroAtv, atividadesresultados.data, atividadesresultados.resultado "
                + "FROM newatividades "
                + "INNER JOIN atividadesresultados ON newatividades.idatividade = atividadesresultados.idatividade "
                + "WHERE atividadesresultados.numero = " + numero 
                + " AND atividadesresultados.data >= '"+data+"'"
                + " AND NOT newatividades.numeroAtv LIKE '9%'"; // Esta linha para não aparecer PreAtv
//  Retirei esta ultima parte para não aparecer Questionarios nesta tabela 
//                + " UNION ALL SELECT idTopic, data, resultado FROM resultadosquestionarios "
//                + "where resultadosquestionarios.numero = " + numero ;
//        String sqlQuery = "{ call getAllActivitiesByNumber('"+numero+"') }";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();

            while (rs.next()) {
                String numberAct = rs.getString("numeroAtv");
                Date date = rs.getDate("data");
                LocalDate datalocal = date.toLocalDate();
                int resultado = rs.getInt("resultado");
                tDados.add(new DadosCoding(numberAct,datalocal,resultado));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tDados;
    }
    
    public static ResultSetTableModel verParsonProblems(ConnectBD ligacao) {
        // Ler tudo da Tabela Actividades e colocar em JTable
        ResultSetTableModel tmodel = null;

        String sqlQuery = "SELECT descricao, data, solucao FROM parsonproblems ";
                
//        String sqlQuery = "{ call getAllActivitiesByNumber('"+numero+"') }";
        
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
    
    public static ResultSetTableModel verMessages(ConnectBD ligacao, String numero) {
        // Ler tudo da Tabela Actividades e colocar em JTable
        ResultSetTableModel tmodel = null;

        String sqlQuery = "SELECT data, sugestao FROM sugestoes WHERE numero = " + numero;
                
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
    public static ResultSetTableModel verMessages(ConnectBD ligacao, String numero, String data) {
        // Ler tudo da Tabela Actividades e colocar em JTable
        ResultSetTableModel tmodel = null;

        String sqlQuery = "SELECT data, sugestao FROM sugestoes WHERE numero = " + numero
                + " AND data >= '"+data+"'";
                
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

    private static ArrayList<String> separaPorMarca(String texto, String marca) {
        ArrayList<String> lista = new ArrayList();
        int inicio = 0;
        int fim = texto.indexOf(marca, inicio);
        String aux = "";
        while (fim >= 0) {
            aux = texto.substring(inicio, fim);
            lista.add(aux.trim());
            inicio = fim + marca.length();
            fim = texto.indexOf(marca, inicio);
        }
        return lista;
    }

    public static Map<String, AtividadeConf> lerTodasAtividades(ConnectBD ligacao) {
        AtividadeConf atv = new AtividadeConf();
        Map<String, AtividadeConf> tabela = new HashMap<>();
        Connection con = ligacao.makeCon();

        String sqlQuery = "SELECT * FROM newatividades WHERE NOT numeroAtv LIKE '9%' ORDER BY numeroAtv";
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idatividade");
                String numberAct = rs.getString("numeroAtv");
                Date date = rs.getDate("data");
                LocalDate datalocal = date.toLocalDate();
                String textActivity = rs.getString("texto");
                int nInput = rs.getInt("nInput");

                ArrayList<String> output = new ArrayList();
                String outputtext = rs.getString("output");
                output = separaPorMarca(outputtext, "<#>");
                int nTest = rs.getInt("nTest");
                ArrayList<String> codeKey = new ArrayList();
                String textCodeKey = rs.getString("commentCodeKey");
                codeKey = separaPorMarca(textCodeKey, "<#>");

                AtividadeConf atividade = new AtividadeConf(id, numberAct, datalocal,
                        textActivity, nInput, output, nTest, codeKey);
                
                tabela.put(numberAct, atividade);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tabela;
    }

    
    public static Map<String, AtividadeConf> lerTodasAtividadesPP(ConnectBD ligacao) {
        AtividadeConf atv = new AtividadeConf();
        Map<String, AtividadeConf> tabela = new HashMap<>();
        Connection con = ligacao.makeCon();

        String sqlQuery = "SELECT * FROM parsonproblems";
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idParson");
                String numberAct = rs.getString("descricao");
                Date date = rs.getDate("data");
                LocalDate datalocal = date.toLocalDate();
                String textActivity = rs.getString("enunciado");
                int nInput = 1;

                ArrayList<String> output = new ArrayList();
                String outputtext = rs.getString("output");
                output = separaPorMarca(outputtext, "<#>");

                AtividadeConf atividadePP = new AtividadeConf(id, numberAct, datalocal,
                        textActivity, nInput, output, 0, null);
                
                tabela.put(numberAct, atividadePP);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tabela;
    }
    
    public static ResultSetTableModel verNomeNumeroFoto(ConnectBD ligacao, String curso,int ano) {
        // Ler Alunos Numero, Nome Foto
        ResultSetTableModel tmodel = null;
//        String sqlQuery = "SELECT alunos.Foto, alunos.numero, alunos.nome, perfil.valor FROM alunos,perfil order by nome";
//        String sqlQuery = "SELECT alunos.Foto, alunos.numero, alunos.nome, alunos.perfil FROM alunos "
//                +"WHERE alunos.numero NOT LIKE '#%' order by nome";
        String sqlQuery = "SELECT alunos.Foto, alunos.numero, alunos.nome, alunos.perfil FROM alunos "
                +"WHERE alunos.numero AND alunos.Anoletivo >= "+ano+" NOT LIKE '#%' order by nome";
        
//        String sqlQuery = "{ call getAllStudents() }";
        if (!curso.equals("-- Select Course --")){
            sqlQuery = "SELECT alunos.Foto, alunos.numero, alunos.nome, alunos.perfil FROM alunos" 
                + " WHERE alunos.curso = '"+curso+"' AND alunos.Anoletivo >= "+ano+" AND alunos.numero NOT LIKE '#%' order by nome";
//                sqlQuery = "{ call getAllStudentsCourse('"+curso+"') }";
        }

//        Connection con = ligacao.makeCon();

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

    public static ResultSetTableModel verNomeNumeroFotoSemPerfil(ConnectBD ligacao) {
        // Ler Alunos Numero, Nome Foto
        ResultSetTableModel tmodel = null;
//        String sqlQuery = "SELECT mdl_user.picture, mdl_user.id, mdl_user.username  FROM mdl_user";
//        String sqlQuery = "SELECT alunos.Foto, alunos.numero, alunos.nome, perfil.valor FROM alunos,perfil order by nome";
        String sqlQuery = "SELECT alunos.Foto, alunos.numero, alunos.nome FROM alunos order by nome";

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

    public static ResultSetTableModel verNomeNumero(ConnectBD ligacao) {
        // Ler Alunos Numero e Nome
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT alunos.nome, alunos.numero FROM alunos order by nome";
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

    public static int getIDFromAluno(ConnectBD c, String numero) {
        int id = 0;
        String sqlQuery = "select idAluno from alunos where numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
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

    public static File getFileAtividadeByID(ConnectBD c, int id) {
        String sqlQuery = "select atividades.File from atividades where idatividade = ? and LENGTH(atividades.File)>0";
        File file = new File("tmp.pdf");

//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            FileOutputStream output = new FileOutputStream(file);
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, id);
            rs = (ResultSet) pst.executeQuery();
            if (!rs.next()) {
                file = null;
            } else {
//                while (rs.next()) {
                InputStream input = rs.getBinaryStream("File");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
//                }
            }
            rs.close();
            output.close();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return file;
    }

    public static String getDadosdAtividades(ConnectBD c, int id) {
        String sqlQuery = "select dados from atividades where idAtividade = ?";
        String dados = "";
        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, id);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                dados = rs.getString(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dados;
    }

    public static int getMaxIdAtividades(ConnectBD c) {
        int id = 0;
        String sqlQuery = "select max(idatividade) from atividades";

        //        Connection con = ligacao;
        //ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        id++;
        return id;
    }

    public static Aluno verDadosAluno(ConnectBD ligacao, String numero) {
        Aluno aluno = new Aluno();
        String sqlQuery = "SELECT * FROM alunos where Numero = ?";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        ImageIcon image = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                aluno.setIdAluno(rs.getInt("idaluno"));
                aluno.setNumero(rs.getString("Numero"));
                aluno.setNome(rs.getString("Nome"));
                aluno.setCurso(rs.getString("Curso"));
                aluno.setLocalidade(rs.getString("OrigemLocalidade"));
                aluno.setUnidadeCurricular(rs.getString("UnidadeCurricular"));
                aluno.setSexo(rs.getByte("sexo"));
//                LocalDate date = rs.getDate("dataNascimento").toLocalDate();
                Date date = rs.getDate("dataNascimento");
                aluno.setPerfil(rs.getInt("perfil"));

                aluno.setDataNascimento(date.toLocalDate());

                if (rs.getBinaryStream("foto") != null) {
                    BufferedImage img = IOImagem.getImageByNumero(ligacao, numero);
//                    BufferedImage img = ImageIO.read(rs.getBinaryStream("foto"));
//                    image = new javax.swing.ImageIcon(img);
                    aluno.setFoto(img);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aluno;
    }

    public static Aluno getAlunoLogin(ConnectBD ligacao, String login) {
        Aluno aluno = new Aluno();
        String sqlQuery = "SELECT * FROM alunos where login = ?";

        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        ImageIcon image = null;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, login);
            rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                aluno.setIdAluno(rs.getInt("idaluno"));
                String numero = rs.getString("Numero");
                aluno.setNumero(numero);
                aluno.setNome(rs.getString("Nome"));
                aluno.setCurso(rs.getString("Curso"));
                aluno.setLocalidade(rs.getString("OrigemLocalidade"));
                aluno.setUnidadeCurricular(rs.getString("UnidadeCurricular"));
                aluno.setSexo(rs.getByte("sexo"));
                Date date = rs.getDate("dataNascimento");
                aluno.setDataNascimento(date.toLocalDate());
                aluno.setEmail(rs.getString("email"));
                aluno.setLogin(rs.getString("login"));
                aluno.setPasswd("");
                aluno.setPerfil(rs.getInt("perfil"));

                if (rs.getBinaryStream("foto") != null) {
                    BufferedImage img = IOImagem.getImageByNumero(ligacao, numero);
//                    BufferedImage img = ImageIO.read(rs.getBinaryStream("foto"));
//                    image = new javax.swing.ImageIcon(img);
                    aluno.setFoto(img);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aluno;
    }

    public static void gravarDadosAlunoAlterar(ConnectBD c, Aluno aluno) {// novo = 1, alterar = 0
        String sqlQuery = "update alunos "
                + "set  Numero=?, Nome=?, Curso=?, UnidadeCurricular=?, DataNascimento=?, "
                + "Sexo=?, OrigemLocalidade=?, email=?, Anoletivo=? "
                + "where Numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        ImageIcon image = null;

        try {
//            con.setAutoCommit(false);
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setString(1, aluno.getNumero());
            pst.setString(2, aluno.getNome());
            pst.setString(3, aluno.getCurso());
            pst.setString(4, aluno.getUnidadeCurricular());
            pst.setDate(5, java.sql.Date.valueOf(aluno.getDataNascimento()));
            pst.setByte(6, aluno.getSexo());
            pst.setString(7, aluno.getLocalidade());
            pst.setString(8, aluno.getEmail());
            pst.setInt(9, aluno.getAnoletivo());
            pst.setString(10, aluno.getNumero());

            int result = pst.executeUpdate();
            if (result == 0) {
                System.out.println("Login Incorreto");
            }
//            con.commit();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravarDadosAlunoNovo(ConnectBD c, Aluno aluno) {
        String sqlQuery = "insert into alunos(Nome,Curso,UnidadeCurricular,"
                + "Numero,DataNascimento,Sexo,OrigemLocalidade,email,login,passwd,perfil,anoletivo) "
                + "select * from (select ? as Nome,? as Curso,? as UnidadeCurricular,? as Numero,"
                + "? as DataNascimento,? as Sexo,? as OrigemLocalidade,? as email,? as login,? as passwd,? as perfil, ? as anoletivo) as tmp "
                + "where not exists ("
                + "select login from alunos where login =?) "
                + "limit 1";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        ImageIcon image = null;

        try {
//            con.setAutoCommit(false);
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getCurso());
            pst.setString(3, aluno.getUnidadeCurricular());
            pst.setString(4, aluno.getNumero());
            pst.setDate(5, java.sql.Date.valueOf(aluno.getDataNascimento()));
            pst.setByte(6, aluno.getSexo());
            pst.setString(7, aluno.getLocalidade());
            pst.setString(8, aluno.getEmail());
            pst.setString(9, aluno.getLogin());
            pst.setString(10, aluno.getPasswd());
            pst.setInt(11, aluno.getPerfil());
            pst.setInt(12, aluno.getAnoletivo());
            pst.setString(13, aluno.getLogin());
            int result = pst.executeUpdate();
//            if (result==0){
//                System.out.println("Login Incorreto");
//            } 
//            con.commit();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void alunoAtualizarDadosAluno(ConnectBD c, Aluno aluno) {
        String sqlQuery = "update alunos "
                + "set Nome=?, DataNascimento=?, Sexo=?, OrigemLocalidade=?, email=? "
                + "where Numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setString(1, aluno.getNome());
            pst.setDate(2, java.sql.Date.valueOf(aluno.getDataNascimento()));
            pst.setByte(3, aluno.getSexo());
            pst.setString(4, aluno.getLocalidade());
            pst.setString(5, aluno.getEmail());
            pst.setString(6, aluno.getNumero());

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deleteAluno(Connection ligacao, String numero) {
        // Colocar Inativo Arranjar Marca #numero

        String sqlQuery = "update alunos "
                + "set Numero = ? "
                + "where Numero = ?";

        //        Connection con = ligacao;
        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, "#"+numero);
            pst.setString(2, numero);
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void alunoAtualizaSeusDados(ConnectBD c, Aluno aluno) {
        String sqlQuery = "update alunos "
                + "set DataNascimento=?, Sexo=?, OrigemLocalidade=?, email=? "
                + "where Numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setDate(1, java.sql.Date.valueOf(aluno.getDataNascimento()));
            pst.setByte(2, aluno.getSexo());
            pst.setString(3, aluno.getLocalidade());
            pst.setString(4, aluno.getEmail());
            pst.setString(5, aluno.getNumero());
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void alunoChangePassword(ConnectBD c, Aluno aluno, String pw) {
        String sqlQuery = "update alunos "
                + "set passwd = ? "
                + "where Numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, pw);
            pst.setString(2, aluno.getNumero());
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void alunoNumeroChangePassword(ConnectBD c, String numero, String pw) {
        String sqlQuery = "update alunos "
                + "set passwd = ? "
                + "where Numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;

        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, pw);
            pst.setString(2, numero);
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String lerFicheiro(String nomeFile) {
        String output = "";
        String workingDir = DadosPeduca.workDirDocuments + "\\CodingHTProgramming";
        try {
            output = new String(Files.readAllBytes(Paths.get(workingDir + "\\" + nomeFile + ".txt")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public static void inserirAtividade(ConnectBD c, Atividade atividade) {
        String sqlQuery = "insert into atividades(idatividade,data,atividade,File,dados) "
                + "values(?,?,?,?,?)";
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, atividade.getIdatividade());
            pst.setDate(2, java.sql.Date.valueOf(atividade.getDataAtividade()));
            pst.setString(3, atividade.getDescricao());
            File file = atividade.getFile();
            FileInputStream input = new FileInputStream(file);
            pst.setBinaryStream(4, (InputStream) input, (int) file.length());
            String dados = lerFicheiro(atividade.getDescricao());
            pst.setString(5, dados);
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravarAtividadeCodeResultadoAluno(ConnectBD c, int idAtividade, LocalDate data, String code, int resultado, Aluno aluno) {
        String sqlQuery = "insert into atividadesresultados(idatividade,idAluno,numero,resultado,data,resolucao) "
                + "values(?,?,?,?,?,?)";
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        int idAluno = UtilBDConsulta.getIDFromAluno(c, aluno.getNumero());
        //        Connection con = ligacao;

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, idAtividade);
            pst.setInt(2, idAluno);
            pst.setString(3, aluno.getNumero());
            pst.setInt(4, resultado);
            pst.setDate(5, java.sql.Date.valueOf(data));
            pst.setString(6, code);

            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravarPreAtividadeResultadoNumeroAluno(ConnectBD c, String numeroAluno, String numeroAtv, int resultado, String resposta) {
        String sqlQuery = "insert into atividadesresultados(idatividade,idAluno,numero,resultado,data,resolucao) "
                + "values(?,?,?,?,?,?)";
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        int idAluno = UtilBDConsulta.getIDFromAluno(c, numeroAluno);
        int idAtividade = NewUtilBD.getIDAtividade(c, numeroAtv);
        //        Connection con = ligacao;

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, idAtividade);
            pst.setInt(2, idAluno);
            pst.setString(3, numeroAluno);
            pst.setInt(4, resultado);
            LocalDate data = LocalDate.now();
            pst.setDate(5, java.sql.Date.valueOf(data));
            pst.setString(6, resposta);

            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravarAtividadeCodeAluno(ConnectBD c, int idAtividade, LocalDate data, String code, Aluno aluno) {
        String sqlQuery = "insert into atividadesresultados(idatividade,idAluno,numero,resultado,data,resolucao) "
                + "values(?,?,?,?,?,?)";
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        int idAluno = UtilBDConsulta.getIDFromAluno(c, aluno.getNumero());
        //        Connection con = ligacao;

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, idAtividade);
            pst.setInt(2, idAluno);
            pst.setString(3, aluno.getNumero());
            pst.setInt(4, 0);
            pst.setDate(5, java.sql.Date.valueOf(data));
            pst.setString(6, code);

            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int getPerfilAluno(ConnectBD c, String numero) {
        String sqlQuery = "select alunos.perfil from alunos "
                + "where alunos.numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int perfil = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                perfil = rs.getInt(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return perfil;
    }

    public static boolean verificaTestSpatial(ConnectBD c, String numero) {
        String sqlQuery = "select numero from testevespacial "
                + "where numero = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int existe = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (existe != 0);
    }
    public static boolean verificaTestSpatial(ConnectBD c, String numero, String data) {
        String sqlQuery = "select numero from testevespacial "
                + "where numero = ? AND data >= ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int existe = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, data);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (existe != 0);
    }

    public static boolean verificaCAP(ConnectBD c, String numero) {
        String sqlQuery = "select numero from caraterizacaoaluno "
                + "where numero = ?";

        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int existe = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (existe != 0);
    }
   
    public static boolean verificaCAP(ConnectBD c, String numero, String data) {
        String sqlQuery = "select numero from caraterizacaoaluno "
                + "where numero = ? AND data >= ?";

        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int existe = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, data);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (existe != 0);
    }

    public static ArrayList<DadosPreAtv> verificaParsonProblemsDados(ConnectBD c, String numero) {
        ArrayList<DadosPreAtv> temp = new ArrayList();
        String sqlQuery = "select descricao, data, resultado from resultadosparsonproblems "
                + "where numero = ?";
        
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                DadosPreAtv aux = new DadosPreAtv();
                aux.setNome(rs.getString("descricao"));
                Date date = rs.getDate("data");
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt("resultado"));
                temp.add(aux);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
    public static ArrayList<DadosPreAtv> verificaParsonProblemsDados(ConnectBD c, String numero, String data) {
        ArrayList<DadosPreAtv> temp = new ArrayList();
        String sqlQuery = "select descricao, data, resultado from resultadosparsonproblems "
                + "where numero = ? AND data >= ?";
        
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, data);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                DadosPreAtv aux = new DadosPreAtv();
                aux.setNome(rs.getString("descricao"));
                Date date = rs.getDate("data");
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt("resultado"));
                temp.add(aux);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
    public static ArrayList<DadosPreAtv> verificaQuestionarioAluno(ConnectBD c, String numero) {
        ArrayList<DadosPreAtv> temp = new ArrayList();
        String sqlQuery = "select idTopic, data, resultado from resultadosquestionarios "
                + "where numero = ?";
        
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                DadosPreAtv aux = new DadosPreAtv();
                aux.setNome(rs.getString("idTopic"));
                Date date = rs.getDate("data");
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt("resultado"));
                temp.add(aux);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
    public static ArrayList<DadosPreAtv> verificaQuestionarioAluno(ConnectBD c, String numero, String data) {
        ArrayList<DadosPreAtv> temp = new ArrayList();
        String sqlQuery = "select idTopic, data, resultado from resultadosquestionarios "
                + "where numero = ? AND data >= ?";
        
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, data);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                DadosPreAtv aux = new DadosPreAtv();
                aux.setNome(rs.getString("idTopic"));
                Date date = rs.getDate("data");
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt("resultado"));
                temp.add(aux);
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
    
    public static DadosPreAtv verificaTestSpatialDados(ConnectBD c, String numero) {

        String sqlQuery = "select Data, RCorretas from testevespacial "
                + "where numero = ?";
        DadosPreAtv aux = new DadosPreAtv();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                aux.setNome("Punched Holes");
                Date date = rs.getDate(1);
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt(2));
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }
    public static DadosPreAtv verificaTestSpatialDados(ConnectBD c, String numero, String data) {

        String sqlQuery = "select Data, RCorretas from testevespacial "
                + "where numero = ? AND Data >= ?";
        DadosPreAtv aux = new DadosPreAtv();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, data);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                aux.setNome("Punched Holes");
                Date date = rs.getDate(1);
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt(2));
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

    public static DadosPreAtv verificaCAPDados(ConnectBD c, String numero) {

        String sqlQuery = "select Data, Resultado from caraterizacaoaluno "
                + "where numero = ?";
        DadosPreAtv aux = new DadosPreAtv();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                aux.setNome("Student Programming");
                Date date = rs.getDate(1);
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt(2));
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }
    public static DadosPreAtv verificaCAPDados(ConnectBD c, String numero, String data) {

        String sqlQuery = "select Data, Resultado from caraterizacaoaluno "
                + "where numero = ? AND data >= ?";
        DadosPreAtv aux = new DadosPreAtv();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        int score = 0;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, data);
            rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                aux.setNome("Student Programming");
                Date date = rs.getDate(1);
                aux.setData(date.toLocalDate());
                aux.setScore(rs.getInt(2));
            }

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

    public static ArrayList<NumeroPerfil> atualizarPerfilMedia(ConnectBD c) {
        String sqlQuery = "SELECT numero,SUM(sub) as perfil "
                + "FROM (SELECT numero, idatividade, avg(resultado) as sub "
                + "FROM atividadesresultados "
                + "group by numero, idatividade) as tmp "
                + "group by numero";

        ArrayList<NumeroPerfil> t = new ArrayList();
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                t.add(new NumeroPerfil(rs.getString(1), rs.getInt(2)));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public static ArrayList<NumeroPerfil> atualizarPerfil(ConnectBD c) {
        String sqlQuery = "SELECT numero, perfil FROM atividades";
        ArrayList<NumeroPerfil> t = new ArrayList();
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                t.add(new NumeroPerfil(rs.getString(1), rs.getInt(3)));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public static ArrayList<NumeroPerfil> atualizarNewPerfil(ConnectBD c) {
        String sqlQuery = "SELECT numero, perfil FROM alunos";
        ArrayList<NumeroPerfil> t = new ArrayList();
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                t.add(new NumeroPerfil(rs.getString(1), rs.getInt(2)));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public static ArrayList<NumeroPerfil> atualizarPerfilAtvResultados(ConnectBD c, String numero) {
//        String sqlQuery = "SELECT numero, idatividade, resultado FROM atividadesresultados "
//                + "where numero = ? order by idatividade";
       String sqlQuery = "SELECT numero, idatividade, resultado FROM atividadesresultados where numero = ? " +
       "UNION ALL SELECT numero, idTopic, resultado FROM resultadosquestionarios where numero = ? ";
        ArrayList<NumeroPerfil> t = new ArrayList();
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString(2, numero);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                t.add(new NumeroPerfil(rs.getString("numero"), rs.getInt("idatividade"), rs.getInt("resultado")));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

    public static void iniciarPerfil(ConnectBD c) {
        String sqlQuery = "UPDATE alunos SET perfil = 0";
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            int result = pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gravaTotalPerfilNumeroAluno(ConnectBD c, String numero, int valorPerfil) {
        String sqlQuery = "update alunos set alunos.perfil = ? where alunos.numero = ?";

        Connection con = c.makeCon();

        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setInt(1, valorPerfil);
            pst.setString(2, numero);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaPerfilAluno(ConnectBD c, Aluno aluno, int valorPerfil) {
//         ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        int perfil = getPerfilAluno(c, aluno.getNumero());
        valorPerfil += perfil;

        String sqlQuery = "update alunos set alunos.perfil = ? where alunos.numero = ?";

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, valorPerfil);
            pst.setString(2, aluno.getNumero());
            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaPerfilNumeroAluno(ConnectBD c, String numero, int valorPerfil) {
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        int perfil = getPerfilAluno(c, numero);
        perfil += valorPerfil;

        String sqlQuery = "update alunos set alunos.perfil = ? where alunos.numero = ?";

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, perfil);
            pst.setString(2, numero);
            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void gravaPerfilTotalNumeroAluno(ConnectBD c, String numero, int valorPerfil) {
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        String sqlQuery = "update alunos set alunos.perfil = ? where alunos.numero = ?";

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setInt(1, valorPerfil);
            pst.setString(2, numero);
            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaResultadoAtividadeAluno(ConnectBD c, String numero, String idatv, int resultado) {
//         ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        String sqlQuery = "INSERT INTO atividadesresultados "
                + "SET idatividade = ?, "
                + "idAluno = (Select idAluno from alunos where numero = ?), "
                + "numero = ?, resultado = ?";

//        Connection con = ligacao;
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            int id = Integer.parseInt(idatv);
            pst.setInt(1, id);
            pst.setString(2, numero);
            pst.setString(3, numero);
            pst.setInt(4, resultado);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaResultadoNewAtividadeAluno(ConnectBD c, String numero, int idatv, int resultado, String codigo) {
//         ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        String sqlQuery = "INSERT INTO atividadesresultados "
                + "SET idatividade = ?, "
                + "idAluno = (Select idAluno from alunos where numero = ?), "
                + "numero = ?, resultado = ?, data = ?, resolucao = ?";

//        Connection con = ligacao;
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
//            int id = Integer.parseInt(idatv);
            pst.setInt(1, idatv);
            pst.setString(2, numero);
            pst.setString(3, numero);
            pst.setInt(4, resultado);
            LocalDate agora = LocalDate.now();
            pst.setDate(5, java.sql.Date.valueOf(agora));
            pst.setString(6, codigo);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void gravaResultadoParsonProblem(ConnectBD c, String numero, String descricao,
            String texto, int resultado) {
        Connection con = c.makeCon();

        String sqlQuery = "INSERT INTO resultadosparsonproblems "
                + "SET numero = ?, data = ?, descricao = ?, textoaluno = ?, resultado = ?";

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            LocalDate agora = LocalDate.now();
            pst.setDate(2, java.sql.Date.valueOf(agora));
            pst.setString(3, descricao);
            pst.setString(4, texto);
            pst.setInt(5, resultado);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void gravaParsonProblems(ConnectBD c, String descricao, String enunciado, String solucao) {
        Connection con = c.makeCon();

        String sqlQuery = "INSERT INTO parsonproblems "
                + "SET descricao = ?, data = ?,  enunciado = ?, solucao = ?";

        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, descricao);
            LocalDate agora = LocalDate.now();
            pst.setDate(2, java.sql.Date.valueOf(agora));
            pst.setString(3, enunciado);
            pst.setString(4, solucao);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static int getIdTopic(ConnectBD c, String topic){
        int id = 0;
        String sqlQuery = "select idTopic from topics "
                + "where topic = ?";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, topic);
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
    
    public static void gravaResultadoQuestionarioAluno(ConnectBD c, String topic, String numero, String respostas, int resultado) {
        Connection con = c.makeCon();
        int idTopic = getIdTopic(c,topic);
        String sqlQuery = "INSERT INTO resultadosquestionarios "
                + "SET idTopic = ?, "
                + "numero = ?, respostas = ?, data = ?, resultado = ?";

//        Connection con = ligacao;
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
//            int id = Integer.parseInt(idatv);
            pst.setInt(1, idTopic);
            pst.setString(2, numero);
            pst.setString(3, respostas);
            LocalDate agora = LocalDate.now();
            pst.setDate(4, java.sql.Date.valueOf(agora));
            pst.setInt(5, resultado);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void gravaSugestaoQuestionarioAluno(ConnectBD c, String topic, String numero, int resultado) {
        Connection con = c.makeCon();
        int idTopic = getIdTopic(c,topic);
        String sqlQuery = "INSERT INTO sugestoes "
                + "SET numero = ?, data = ?, sugestao = ?";

        String texto = "Mensagem de ALERTA gerada pelo Topic: ";
        texto = texto.concat(topic+"\t com Resultado: "+resultado+"/20 \n");
        texto = texto.concat("Deve procurar mais questionários/exercícios \n com o mesmo tema para CONSOLIDAR os conceitos sobre o Tema");
        
//        Connection con = ligacao;
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
//            int id = Integer.parseInt(idatv);
            pst.setString(1, numero);
            LocalDate agora = LocalDate.now();
            pst.setDate(2, java.sql.Date.valueOf(agora));
            pst.setString(3, texto);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void gravaSugestaoToAluno(ConnectBD c, String numero, String texto) {
        Connection con = c.makeCon();
       
        String sqlQuery = "INSERT INTO sugestoes "
                + "SET numero = ?, data = ?, sugestao = ?";

        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
//            int id = Integer.parseInt(idatv);
            pst.setString(1, numero);
            LocalDate agora = LocalDate.now();
            pst.setDate(2, java.sql.Date.valueOf(agora));
            pst.setString(3, texto);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaPresencasDataNumero(ConnectBD c, LocalDate data, String numero, String curso, int hora) {
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();

        String sqlQuery = "INSERT INTO registapresenca "
                + "SET data = ?, numero = ?, curso = ?, hora = ?";

        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setDate(1, java.sql.Date.valueOf(data));
            pst.setString(2, numero);
            pst.setString(3, curso);
            pst.setInt(4, hora);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static int totalPresencasPorNumero(ConnectBD c, String numero, String data) {
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        int totalPresencas = 0;
//        String sqlQuery = "SELECT Count(*) as Total FROM registapresenca WHERE numero = ?";
        String sqlQuery = "SELECT Count(*) as Total FROM registapresenca WHERE numero = ? and data >= ?";
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            pst.setString (2, data);
            ResultSet rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                totalPresencas = rs.getInt(1);
            }         
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPresencas;
    }
    
    
//    public static void gravaRespostasVEspacial(Connection c , Aluno aluno, String respostas, int acertos) {
    public static void gravaRespostasVEspacial(Aluno aluno, String respostas, int acertos) {
        String sqlQuery = "insert into testevespacial(Numero,Respostas,RCorretas,Data) "
                + "Values(?,?,?,?)";

        //        Connection con = ligacao;
        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setString(1, aluno.getNumero());
            pst.setString(2, respostas);
            pst.setInt(3, acertos);
            LocalDate agora = LocalDate.now();
            pst.setDate(4, java.sql.Date.valueOf(agora));

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaRespostasSeguirDar(ConnectBD c, Aluno aluno, String teste, String texto, int resultado) {
        String sqlQuery = "insert into seguirdar(Numero,Data,Teste,Texto,Resultado) "
                + "Values(?,?,?,?,?)";

        //        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setString(1, aluno.getNumero());
            LocalDate agora = LocalDate.now();
            pst.setDate(2, java.sql.Date.valueOf(agora));
            pst.setString(3, teste);
            pst.setString(4, texto);
            pst.setInt(5, resultado);

            int result = pst.executeUpdate();

//            pst.close();
//            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaRespostasCaraterizaAluno(ConnectBD c, String numeroaluno, int nRepete, String cursoAnterior, int opEntrada,
            double mediaCandidatura, int pc, int internet, int nivelInformatica, int nivelProgramacao, String linguagens, int resultado) {
        String sqlQuery = "insert into caraterizacaoaluno(Numero,Data,nrepete, cursoAnterior,OpcaoEntrada,"
                + "mediaCandidatura, computadorpessoal, ligacaointernet, nivelInformaticageral, nivelProgramacao,"
                + " linguagensutilizadas, Resultado) "
                + "Values(?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection con = c.makeCon();
        PreparedStatement pst;

        try {

            pst = (PreparedStatement) con.prepareStatement(sqlQuery);

            pst.setString(1, numeroaluno);
            LocalDate agora = LocalDate.now();
            pst.setDate(2, java.sql.Date.valueOf(agora));
            pst.setInt(3, opEntrada);
            pst.setString(4, cursoAnterior);
            pst.setInt(5, opEntrada);
            pst.setDouble(6, mediaCandidatura);
            pst.setInt(7, pc);
            pst.setInt(8, internet);
            pst.setInt(9, nivelInformatica);
            pst.setInt(10, nivelProgramacao);
            pst.setString(11, linguagens);
            pst.setInt(12, resultado);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<String> getCursos(ConnectBD c) {
        String sqlQuery = "SELECT DISTINCT Curso FROM cursounidade";
        ArrayList<String> tCursos = new ArrayList();
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                tCursos.add(rs.getString("Curso"));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tCursos;
    }

    public static ArrayList<String> getUnidades(ConnectBD c, String curso) {
        String sqlQuery = "SELECT DISTINCT unidadecurricular FROM cursounidade where curso = ?";
        ArrayList<String> tUnidades = new ArrayList();
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, curso);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                tUnidades.add(rs.getString("UnidadeCurricular"));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tUnidades;
    }

    public static int lerNumeroPresencasRegistadas(ConnectBD c) {
        int total = 0;

        String sqlQuery = "SELECT COUNT(DISTINCT data) as total FROM registapresenca ";

//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }

    public static int lerNumeroPresencasNumeroAluno(ConnectBD c, String numero) {
        int total = 0;

        String sqlQuery = "SELECT COUNT(numero) as total FROM registapresenca where registapresenca.numero = ?";

//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            pst.setString(1, numero);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;
    }

    public static ResultSetTableModel verPresencasDataTotalAlunos(ConnectBD ligacao) {
        // Ler Data e Total de Presenças
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT @rank := @rank +1 AS rank, data, hora, curso, COUNT(numero) AS Total FROM registapresenca "
                + "CROSS JOIN (SELECT @rank := 0) AS rank GROUP BY data, hora, curso";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
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
    public static ResultSetTableModel verPresencasDataTotalAlunos(ConnectBD ligacao, String data) {
        // Ler Data e Total de Presenças
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT @rank := @rank +1 AS rank, data, hora, curso, COUNT(numero) AS Total FROM registapresenca "
                + "CROSS JOIN (SELECT @rank := 0) AS rank where data > '"+data+"' GROUP BY data, hora, curso";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
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

    public static ResultSetTableModel verPresencasPorData(ConnectBD ligacao, String data) {
        // Ler Data e Total de Presenças
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT data, numero, hora, curso FROM registapresenca WHERE data = '" + data + "'";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
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
    public static ResultSetTableModel verPresencasPorDataHoraCurso(ConnectBD ligacao, String data, int hora, String curso) {
        // Ler Data e Total de Presenças
        ResultSetTableModel tmodel = null;
        String sqlQuery = "SELECT data, numero, hora, curso FROM registapresenca WHERE data = '" + data + "'"
                        + " AND hora = "+hora+" AND curso = '"+curso+"'";
        Connection con = ligacao.makeCon();
        ResultSet rs;
        PreparedStatement pst;
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
    
// Gravar round from season

//    public static void gravaLeagueGame(ConnectBD c, String season, int round, String equipa1, int result1, 
//                                                        String equipa2, int result2, String activity) {
//         String sqlQuery1 = "SELECT idGame FROM leaguegame WHERE season = ? AND round = ? AND equipa1 = ?"; 
//         
//         String sqlQuery2 = "INSERT INTO leaguegame "
//                + "SET season = ?, data = ?, round = ?, equipa1 = ?, result1 = ?, equipa2 = ?, result2 = ?, activity = ?";
//
//        String sqlQuery3 = "UPDATE leaguegame "
//                + "SET result1 = ?, result2 = ? "
//                + "where idGame = ?";
//        
//        ResultSet rs;
//        PreparedStatement pst;
//        Connection con = c.makeCon();
//        int idGame = 0;
//        try {
//            pst = (PreparedStatement) con.prepareStatement(sqlQuery1);
//            pst.setString(1, season);
//            pst.setInt(2, round);
//            pst.setString(3,equipa1);
//            rs = (ResultSet) pst.executeQuery();
//            while (rs.next()) {
//                idGame = rs.getInt("idGame");
//            }
//            pst.close();
////            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//       
//        if (idGame == 0) { // Não existe INSERT
//            try {
//                pst = (PreparedStatement) con.prepareStatement(sqlQuery2);
//                pst.setString(1, season);
//                LocalDate agora = LocalDate.now();
//                pst.setDate(2, java.sql.Date.valueOf(agora));
//                pst.setInt(3, round);
//                pst.setString(4, equipa1);
//                pst.setInt(5, result1);
//                pst.setString(6, equipa2);
//                pst.setInt(7, result2);
//                pst.setString(8, activity);
//
//                int result = pst.executeUpdate();
//
//                pst.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {            //Existe fazer UPDATE
//            try {
//                pst = (PreparedStatement) con.prepareStatement(sqlQuery3);
//                pst.setInt(1, result1);
//                pst.setInt(2, result2);
//                pst.setInt(3, idGame);
//
//                int result = pst.executeUpdate();
//
//                pst.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    public static void gravaLeagueGame(ConnectBD c, String season, int round, String equipa1, int result1, 
                                                        String equipa2, int result2, String activity) {
        /*
    INSERT INTO leaguegame
SET idGame = (select idGame from leaguegame where season = '2021' AND round = 1 AND equipa1 = '1704460'),
 season = '2021', data = '2021-01-15', round = 1, equipa1 = '1704460', result1 = 20, equipa2 = '1701058', result2 = 20, activity = '00301'
ON DUPLICATE KEY UPDATE season = '2021', data = '2021-01-15', round = 1, equipa1 = '1704460', result1 = 20, equipa2 = '1701058', result2 = 20, activity = '00301'
        
   INSERT INTO leaguegame SET data = '2021-02-18', season = '2021', round = 5, equipa1 = '1700005', result1 = 99, equipa2 = '1701058', result2 = 20, activity = '00301' ON DUPLICATE KEY UPDATE result1 = 99, result2 = 20
    */     
        
        String sqlQuery = "INSERT INTO leaguegame " +
            "SET data = ?, season = ?, round = ?, equipa1 = ?, result1 = ?, equipa2 = ?, result2 = ?, activity = ?" +
            " ON DUPLICATE KEY UPDATE result1 = ?, result2 = ?";
        
        ResultSet rs;
        PreparedStatement pst;
        Connection con = c.makeCon();

        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
           
            LocalDate agora = LocalDate.now();
            pst.setDate(1, java.sql.Date.valueOf(agora));
            pst.setString(2, season);
            pst.setInt(3, round);
            pst.setString(4, equipa1);
            pst.setInt(5, result1);
            pst.setString(6, equipa2);
            pst.setInt(7, result2);
            pst.setString(8, activity);
            pst.setInt(9, result1);
            pst.setInt(10, result2);

            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public static ArrayList<String> getSeason(ConnectBD c) {
        String sqlQuery = "SELECT DISTINCT season FROM leaguegame";
        ArrayList<String> tSeason = new ArrayList();
//        Connection con = ligacao;
//        ConnectBD c = new ConnectBD();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                tSeason.add(rs.getString("season"));
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tSeason;
    }

    //AQUI SELECT EXISTS( SELECT 1 FROM leaguegame WHERE season ='2021' AND round = 2 LIMIT 1)
    
    public static LeagueGame getLastRecordLeague(ConnectBD c) {
        String sqlQuery = "select * from leaguegame ORDER BY idGame DESC LIMIT 1";
        LeagueGame lastgame = null;
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int idGame = rs.getInt("idGame");
                String season = rs.getString("season");
                Date date = rs.getDate("data");
                LocalDate data = date.toLocalDate();
                int round = rs.getInt("round");
                String equipa1 = rs.getString("equipa1");
                int result1 = rs.getInt("result1");
                String equipa2 = rs.getString("equipa2");
                int result2 = rs.getInt("result2");
                String activity = rs.getString("activity");
                lastgame = new LeagueGame(idGame, season, data, round, equipa1, result1, equipa2, result2, activity);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lastgame;
    }

    public static ArrayList<String> getDrawResult(ConnectBD c) {
        String sqlQuery = "SELECT data, season, round FROM leaguegame Group by data, season, round";
        ArrayList<String> comboDraw = new ArrayList();

        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        comboDraw.add("-- Choose Draw / Result --");
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                Date date = rs.getDate("data");
                LocalDate data = date.toLocalDate();
                String season = rs.getString("season");
                int round = rs.getInt("round");
                comboDraw.add(data +"; "+season+"; "+round);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboDraw;
    }
    
    // SELECT * FROM leaguegame where data = '2021-01-15' AND season = '2021' AND round = 1

public static ArrayList<LeagueGame> getExistDraw(ConnectBD c, String data, String season, int round) {
        String sqlQuery = "SELECT * FROM leaguegame where data = '"+data+"' "
                + "AND season = '"+season+"' AND round = "+round;
        ArrayList<LeagueGame> tExistLeague = new ArrayList();
        LeagueGame existRound;
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int idGame = rs.getInt("idGame");
                String seasonExist = rs.getString("season");
                Date date = rs.getDate("data");
                LocalDate dataExist = date.toLocalDate();
                int roundExist = rs.getInt("round");
                String equipa1 = rs.getString("equipa1");
                int result1 = rs.getInt("result1");
                String equipa2 = rs.getString("equipa2");
                int result2 = rs.getInt("result2");
                String activity = rs.getString("activity");
                existRound = new LeagueGame(idGame, seasonExist, dataExist, roundExist, equipa1, result1, equipa2, result2, activity);
                tExistLeague.add(existRound);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tExistLeague;
    }
    
public static int getResultDraw(ConnectBD c, String numeroAluno, String numeroAtv) {
        String sqlQuery = "SELECT numero, resultado FROM `atividadesresultados` WHERE " +
        "idatividade = (select idatividade from newatividades where numeroAtv = '"+numeroAtv+"') AND " +
        "numero = '"+numeroAluno+"' ORDER BY id DESC LIMIT 1";
        ArrayList<LeagueGame> tExistLeague = new ArrayList();
        int result = 0;
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("resultado");
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
public static void gravaWinnersRound(ConnectBD c, String season, int round, String equipa) {
        Connection con = c.makeCon();
        String sqlQuery = "INSERT INTO winnersround "
                + "SET data = ?, season = ?, round = ?, equipa = ?";

        PreparedStatement pst;

        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            LocalDate agora = LocalDate.now();
            pst.setDate(1, java.sql.Date.valueOf(agora));
            pst.setString(2, season);
            pst.setInt(3, round);
            pst.setString(4, equipa);
            int result = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static ArrayList<String> getWinnersToNextRound(ConnectBD c, String season, int round) {
        String sqlQuery = "SELECT equipa FROM winnersround where season = '"+season+"' and round = "+round;
        ArrayList<String> tWinners = new ArrayList();
        Connection con = c.makeCon();
        ResultSet rs;
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) con.prepareStatement(sqlQuery);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String winner = rs.getString("equipa");
                tWinners.add(winner);
            }
            pst.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UtilBDConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tWinners;
    }

}
