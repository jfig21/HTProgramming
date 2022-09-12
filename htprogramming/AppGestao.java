/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htprogramming;

import codecheck.CalcularResultados;
import com.mysql.jdbc.Connection;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import modelo.Aluno;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.AlunoExpert;
import modelo.Atividade;
import modelo.AtividadeConf;
import modelo.ChooserData;
import modelo.CustomRendererColor;
import modelo.CustomRendererColorDraw;
import modelo.DadosCoding;
import modelo.DadosGame;
import modelo.DadosPreAtv;
import modelo.LeagueGame;
import modelo.NumeroPerfil;
import modelo.SortByScore;
import service.ConnectBD;
import service.DadosPeduca;
import service.IOImagem;
import service.ImageRenderer;
import service.ValidaLogin;
import ui.BasicActivities;
import util.NewUtilBD;
import util.ResultSetTableModel;
import util.UtilAcesso;
import util.UtilBDConsulta;
import util.UtilConvertData;
import util.UtilFiles;

/**
 *
 * @author Utilizador
 */
public class AppGestao extends javax.swing.JFrame {

    class ThreadLerAlunos implements Runnable {

        public void run() {
            lerAlunosBD();
        }
    }

    class ThreadIniciaAtividades implements Runnable {

        public void run() {
            iniciaAtividades();
        }
    }

    class ThreadIniciaAtividadesConf implements Runnable {

        public void run() {
            iniciaAtividadesConf();
        }
    }

    class ThreadCarregaComboCurso implements Runnable {

        public void run() {
            carregaComboCurso();
        }
    }

    class ThreadIniciaQuestionarios implements Runnable {

        public void run() {
            iniciaQuestionarios();
        }
    }

    class ThreadIniciaParsonProblems implements Runnable {

        public void run() {
            iniciaParsonProblems();
        }
    }

    class ThreadIniciaPresencas implements Runnable {

        public void run() {
            // Para Presenças
//            modelo2 = UtilBDConsulta.verPresencasDataTotalAlunos(liga);
            String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
            modelo2 = UtilBDConsulta.verPresencasDataTotalAlunos(liga,datacorrente);
            jTableDataTotalAlunos.setModel(modelo2);
            jTableDataTotalAlunos.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableDataTotalAlunos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTableDataTotalAlunos.getColumnModel().getColumn(2).setMaxWidth(40);
            jTableDataTotalAlunos.getColumnModel().getColumn(4).setMaxWidth(40);
        }
    }

    /**
     * Creates new form AppGestao
     */
    public AppGestao() {
        initComponents();
//        anoletivo = LocalDate.now().getYear();
        anoletivo = 2021;
        jTextFieldDefCurrentYear.setText(""+anoletivo);
        try {
//            Image i = ImageIO.read(getClass().getResource("/icons/logoHelpPro.png"));
            Image i = ImageIO.read(getClass().getResource("/icons/logoCodingC.jpg"));
            this.setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(HTProgramming.class.getName()).log(Level.SEVERE, null, ex);
        }

//        liga = new ConnectBD();

    
        liga = new ConnectBD(true);
    
        con = (Connection) liga.makeConAuto();

//        lerAlunosBD();
//        ThreadLerAlunos la = new ThreadLerAlunos();
        new Thread(new ThreadLerAlunos()).start();
        new Thread(new ThreadIniciaAtividades()).start();
        new Thread(new ThreadIniciaAtividadesConf()).start();
        new Thread(new ThreadCarregaComboCurso()).start();
        new Thread(new ThreadIniciaQuestionarios()).start();
        new Thread(new ThreadIniciaParsonProblems()).start();
//        iniciaAtividades();
//        iniciaAtividadesConf();
//        carregaComboCurso();
//        iniciaQuestionarios();
//        iniciaParsonProblems();
        new Thread(new ThreadIniciaPresencas()).start();

        refreshActiveStudentsTable();
        // Definições Atividades Block ou UnBlock
        lerBDTabsBlocksToDisplay(liga);

        if (HTProgramming.getMainFrame() != null) {
            HTProgramming.getMainFrame().dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogVerAluno = new javax.swing.JDialog();
        jPanelVerAluno = new javax.swing.JPanel();
        jLabelAlunoFotoInf = new javax.swing.JLabel();
        jLabelAlunoNumeroInf = new javax.swing.JLabel();
        jLabelAlunoNomeInf = new javax.swing.JLabel();
        jLabelAlunoScoreInf = new javax.swing.JLabel();
        jButtonEditarAlunoInf = new javax.swing.JButton();
        jButtonMessageToSudent = new javax.swing.JButton();
        jPanelWorkDone = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtividadesAluno = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTablePreAtividadeAluno = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTablePreAtividadeAlunoLoop = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTableAtividadesAlunoArrays = new javax.swing.JTable();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTableAtividadesAlunoIF = new javax.swing.JTable();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTableAtividadesAlunoAdvanced = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabelTotalIf = new javax.swing.JLabel();
        jLabelTotalPreActivities = new javax.swing.JLabel();
        jLabelTotalBasic = new javax.swing.JLabel();
        jLabelTotalLoop = new javax.swing.JLabel();
        jLabelTotalArrays = new javax.swing.JLabel();
        jLabelTotalAdvanced = new javax.swing.JLabel();
        jButtonRefreshStudentScore = new javax.swing.JButton();
        jDialogAlunos = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAlunoNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAlunoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAlunoLocalidade = new javax.swing.JTextField();
        jLabelAlunoFoto = new javax.swing.JLabel();
        jComboBoxCurso = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jRadioButtonMasculino = new javax.swing.JRadioButton();
        jRadioButtonFeminino = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAlunoLogin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPasswordFieldAluno = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldAlunoEmail = new javax.swing.JTextField();
        jComboBoxUnidadeCurricular = new javax.swing.JComboBox<>();
        jButtonAlterarPasswd = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jTextFieldAnoletivo = new javax.swing.JTextField();
        jButtonAlunoGravar = new javax.swing.JButton();
        jButtonAlunoEliminar = new javax.swing.JButton();
        jDialogInsertResults = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInsertResults = new javax.swing.JTable();
        jDialogResultadosPorAtividade = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableResultadosPorAtividade = new javax.swing.JTable();
        jLabelDescricaoAtividade = new javax.swing.JLabel();
        jLabelIdAtividade = new javax.swing.JLabel();
        jButtonSaveResults = new javax.swing.JButton();
        jButtonReadFile = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        jDialogRegistarPresenca = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableRegistarPresenca = new javax.swing.JTable();
        jFileChooserSelectPDF = new javax.swing.JFileChooser();
        jDialogTestCodeKey = new javax.swing.JDialog();
        jPanelAreaCodeKey = new javax.swing.JPanel();
        jButtonAddCodeKey = new javax.swing.JButton();
        jButtonAtvDeleteRow = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableKeyCodeTest = new javax.swing.JTable();
        jButtonCodeKeyClose = new javax.swing.JButton();
        jDialogInsertOutput = new javax.swing.JDialog();
        jPanelAreaInsertOutput = new javax.swing.JPanel();
        jButtonAddOutput = new javax.swing.JButton();
        jButtonOutputDeleteRow = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableInsertOutput = new javax.swing.JTable();
        jButtonOutputClose = new javax.swing.JButton();
        jPanelActivity = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldidAtividade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jDateChooserDataAtividade = new com.toedter.calendar.JDateChooser();
        jButtonInserirAtividade = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldAtividadeDescricao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSelectPDF = new javax.swing.JTextField();
        jButtonSelectPDF = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAtividades = new javax.swing.JTable();
        jButtonInsertResults = new javax.swing.JButton();
        jDialogPresencasPorData = new javax.swing.JDialog();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTablePresencasPorData = new javax.swing.JTable();
        jDialogResultsStudentCharact = new javax.swing.JDialog();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTableStudentCharact = new javax.swing.JTable();
        jDialogMessageToStudent = new javax.swing.JDialog();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabelNomeAlunoMsg = new javax.swing.JLabel();
        jLabelNumeroAlunoMsg = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaMsgToAluno = new javax.swing.JTextArea();
        jButtonSendMsgAluno = new javax.swing.JButton();
        jDialogNewParsonProblems = new javax.swing.JDialog();
        jPanelParsonProblems = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextAreaProgramSolution = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextAreaShuffledProgram = new javax.swing.JTextArea();
        jButtonSaveParsonProblem = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldParsonDescricao = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButtonShuffle = new javax.swing.JButton();
        buttonGroupSexo = new javax.swing.ButtonGroup();
        buttonGroupTypeDraw = new javax.swing.ButtonGroup();
        jDialogSeason = new javax.swing.JDialog();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxSeason = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldNewSeason = new javax.swing.JTextField();
        jButtonAddSeason = new javax.swing.JButton();
        buttonGroupManualAutoResults = new javax.swing.ButtonGroup();
        jTabbedPanePrincipal = new javax.swing.JTabbedPane();
        jPanelPrincipalAlunos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTodosAlunosPrincipal = new javax.swing.JTable();
        jButtonNewStudent = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jComboBoxCursosInicial = new javax.swing.JComboBox<>();
        jButtonTopStudents = new javax.swing.JButton();
        jPanelDefinitions = new javax.swing.JPanel();
        jButtonUpdateScore = new javax.swing.JButton();
        jButtonInitializeScore = new javax.swing.JButton();
        jPanelBlockedTabs = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jButtonApplyBlockTabs = new javax.swing.JButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jPanelActiveStudents = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableActiveStudents = new javax.swing.JTable();
        jButtonRefreshTableActiveStudents = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldDefCurrentYear = new javax.swing.JTextField();
        jButtonDefCurrentYear = new javax.swing.JButton();
        jPanelIntroduActivities = new javax.swing.JPanel();
        jButtonAddNewActivity = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTableVerQuestionario = new javax.swing.JTable();
        jPanelNewActivity = new javax.swing.JPanel();
        jPanelConfActivity = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldActNumber = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextAreaTextActivity = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldNumberInputTest = new javax.swing.JTextField();
        jDateChooserDateActivity = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jButtonSaveActivity = new javax.swing.JButton();
        jButtonOutputSettings = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldnTest = new javax.swing.JTextField();
        jButtonCodeSettings = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jButtonSelectConfFile = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButtonAtvNewClear = new javax.swing.JButton();
        jScrollPaneActivityShow = new javax.swing.JScrollPane();
        jListActivities = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        jPanelPresences = new javax.swing.JPanel();
        jDateChooserRegistarPresenca = new com.toedter.calendar.JDateChooser();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableAlunoPresenca = new javax.swing.JTable();
        jButtonSavePresences = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabelTotalPresencas = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableDataTotalAlunos = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxCursoPresencas = new javax.swing.JComboBox<>();
        jButtonReadFilePresences = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSpinnerHourPresences = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        jPanelResultStudentPersonal = new javax.swing.JPanel();
        jButtonStudentCharact = new javax.swing.JButton();
        jPanelAreaParsonProblems = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTableViewParsonProblems = new javax.swing.JTable();
        jButtonNewParsonProblem = new javax.swing.JButton();
        jPanelExpert = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTableExpert = new javax.swing.JTable();
        jButtonRefreshExpert = new javax.swing.JButton();
        jButtonSaveCSVFile = new javax.swing.JButton();
        jPanelGamification = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jRadioButtonRandomDraw = new javax.swing.JRadioButton();
        jRadioButtonScoreDraw = new javax.swing.JRadioButton();
        jButtonDraw = new javax.swing.JButton();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTableDraw = new javax.swing.JTable();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTableStudentTODraw = new javax.swing.JTable();
        jButtonStepDraw = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabelNumberToDraw = new javax.swing.JLabel();
        jButtonSaveRound = new javax.swing.JButton();
        jLabelSeason = new javax.swing.JLabel();
        jButtonSeason = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jButtonInitialize = new javax.swing.JButton();
        jTextFieldRound = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jComboBoxDrawResult = new javax.swing.JComboBox<>();
        jButtonCheckResults = new javax.swing.JButton();
        jRadioButtonAutomaticResults = new javax.swing.JRadioButton();
        jRadioButtonManualResults = new javax.swing.JRadioButton();

        jDialogVerAluno.setTitle("Resumo Informação Aluno");
        jDialogVerAluno.setMinimumSize(new java.awt.Dimension(920, 750));
        jDialogVerAluno.setResizable(false);

        jPanelVerAluno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelVerAluno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAlunoFotoInf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlunoFotoInf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/anonimo1.jpg"))); // NOI18N
        jLabelAlunoFotoInf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelVerAluno.add(jLabelAlunoFotoInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, 116));

        jLabelAlunoNumeroInf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlunoNumeroInf.setText("Número");
        jPanelVerAluno.add(jLabelAlunoNumeroInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, -1));

        jLabelAlunoNomeInf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlunoNomeInf.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAlunoNomeInf.setText("<html> Nome Completo Nome Completo Nome Completo </html> ");
        jPanelVerAluno.add(jLabelAlunoNomeInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 49, 290, 80));

        jLabelAlunoScoreInf.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelAlunoScoreInf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlunoScoreInf.setText("9999");
        jLabelAlunoScoreInf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelVerAluno.add(jLabelAlunoScoreInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 93, 55));

        jButtonEditarAlunoInf.setText("Editar");
        jButtonEditarAlunoInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarAlunoInfActionPerformed(evt);
            }
        });
        jPanelVerAluno.add(jButtonEditarAlunoInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 90, 30));

        jButtonMessageToSudent.setText("Message to Student");
        jButtonMessageToSudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMessageToSudentActionPerformed(evt);
            }
        });

        jPanelWorkDone.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelWorkDone.setLayout(null);

        jTableAtividadesAluno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableAtividadesAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity", "Date", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAtividadesAluno.setName("jLabelTotalBasic"); // NOI18N
        jScrollPane1.setViewportView(jTableAtividadesAluno);

        jPanelWorkDone.add(jScrollPane1);
        jScrollPane1.setBounds(300, 40, 280, 189);

        jTablePreAtividadeAluno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePreAtividadeAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pré-Activity", "Date", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePreAtividadeAluno.setName("jLabelTotalPreActivities"); // NOI18N
        jScrollPane20.setViewportView(jTablePreAtividadeAluno);

        jPanelWorkDone.add(jScrollPane20);
        jScrollPane20.setBounds(20, 40, 270, 189);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Pré-Activities");
        jPanelWorkDone.add(jLabel31);
        jLabel31.setBounds(20, 10, 90, 30);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Basic Activities Concepts");
        jPanelWorkDone.add(jLabel32);
        jLabel32.setBounds(300, 10, 148, 20);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("if - switch Concepts");
        jPanelWorkDone.add(jLabel33);
        jLabel33.setBounds(590, 10, 119, 30);

        jTablePreAtividadeAlunoLoop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePreAtividadeAlunoLoop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pré-Activity", "Date", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePreAtividadeAlunoLoop.setName("jLabelTotalLoop"); // NOI18N
        jScrollPane21.setViewportView(jTablePreAtividadeAlunoLoop);

        jPanelWorkDone.add(jScrollPane21);
        jScrollPane21.setBounds(20, 290, 270, 189);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Loop Concepts");
        jPanelWorkDone.add(jLabel34);
        jLabel34.setBounds(20, 270, 93, 17);

        jTableAtividadesAlunoArrays.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableAtividadesAlunoArrays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity", "Date", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAtividadesAlunoArrays.setName("jLabelTotalArrays"); // NOI18N
        jScrollPane22.setViewportView(jTableAtividadesAlunoArrays);

        jPanelWorkDone.add(jScrollPane22);
        jScrollPane22.setBounds(300, 290, 280, 190);

        jTableAtividadesAlunoIF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableAtividadesAlunoIF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity", "Date", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAtividadesAlunoIF.setName("jLabelTotalIf"); // NOI18N
        jScrollPane23.setViewportView(jTableAtividadesAlunoIF);

        jPanelWorkDone.add(jScrollPane23);
        jScrollPane23.setBounds(590, 40, 270, 189);

        jTableAtividadesAlunoAdvanced.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableAtividadesAlunoAdvanced.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity", "Date", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAtividadesAlunoAdvanced.setName("jLabelTotalAdvanced"); // NOI18N
        jScrollPane24.setViewportView(jTableAtividadesAlunoAdvanced);

        jPanelWorkDone.add(jScrollPane24);
        jScrollPane24.setBounds(590, 290, 270, 190);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Arrays Concepts");
        jPanelWorkDone.add(jLabel35);
        jLabel35.setBounds(300, 270, 130, 17);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Advanced Concepts");
        jPanelWorkDone.add(jLabel36);
        jLabel36.setBounds(590, 270, 160, 17);

        jLabelTotalIf.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalIf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalIf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalIf.setText("0");
        jLabelTotalIf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalIf.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalIf.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalIf);
        jLabelTotalIf.setBounds(760, 240, 90, 17);

        jLabelTotalPreActivities.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPreActivities.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPreActivities.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalPreActivities.setText("0");
        jLabelTotalPreActivities.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalPreActivities.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalPreActivities.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalPreActivities);
        jLabelTotalPreActivities.setBounds(190, 240, 90, 21);

        jLabelTotalBasic.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalBasic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalBasic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalBasic.setText("0");
        jLabelTotalBasic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalBasic.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalBasic.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalBasic);
        jLabelTotalBasic.setBounds(480, 240, 90, 17);

        jLabelTotalLoop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalLoop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalLoop.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalLoop.setText("0");
        jLabelTotalLoop.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalLoop.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalLoop.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalLoop);
        jLabelTotalLoop.setBounds(190, 490, 90, 21);

        jLabelTotalArrays.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalArrays.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalArrays.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalArrays.setText("0");
        jLabelTotalArrays.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalArrays.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalArrays.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalArrays);
        jLabelTotalArrays.setBounds(480, 490, 90, 17);

        jLabelTotalAdvanced.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalAdvanced.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalAdvanced.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalAdvanced.setText("0");
        jLabelTotalAdvanced.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalAdvanced.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalAdvanced.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalAdvanced);
        jLabelTotalAdvanced.setBounds(760, 490, 90, 17);

        jButtonRefreshStudentScore.setText("Refresh Student Score");
        jButtonRefreshStudentScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshStudentScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogVerAlunoLayout = new javax.swing.GroupLayout(jDialogVerAluno.getContentPane());
        jDialogVerAluno.getContentPane().setLayout(jDialogVerAlunoLayout);
        jDialogVerAlunoLayout.setHorizontalGroup(
            jDialogVerAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVerAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogVerAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogVerAlunoLayout.createSequentialGroup()
                        .addComponent(jPanelWorkDone, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDialogVerAlunoLayout.createSequentialGroup()
                        .addComponent(jPanelVerAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDialogVerAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonMessageToSudent, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jButtonRefreshStudentScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))))
        );
        jDialogVerAlunoLayout.setVerticalGroup(
            jDialogVerAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVerAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogVerAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelVerAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogVerAlunoLayout.createSequentialGroup()
                        .addComponent(jButtonMessageToSudent)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRefreshStudentScore)
                        .addGap(2, 2, 2)))
                .addComponent(jPanelWorkDone, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogAlunos.setTitle("Informação do Aluno");
        jDialogAlunos.setMinimumSize(new java.awt.Dimension(600, 500));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel1.setText("Número:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(12, 16, 41, 14);
        jPanel4.add(jTextFieldAlunoNumero);
        jTextFieldAlunoNumero.setBounds(120, 13, 250, 20);

        jLabel2.setText("Nome:");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(12, 54, 31, 14);
        jPanel4.add(jTextFieldAlunoNome);
        jTextFieldAlunoNome.setBounds(120, 51, 250, 20);

        jLabel3.setText("Curso:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(12, 92, 32, 14);

        jLabel4.setText("Unidade Curricular:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(12, 130, 92, 14);

        jLabel5.setText("Data Nascimento:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(10, 164, 90, 20);

        jLabel6.setText("Localidade/Origem:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 200, 110, 14);
        jPanel4.add(jTextFieldAlunoLocalidade);
        jTextFieldAlunoLocalidade.setBounds(120, 200, 250, 20);

        jLabelAlunoFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/anonimo1.jpg"))); // NOI18N
        jLabelAlunoFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelAlunoFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAlunoFotoMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelAlunoFoto);
        jLabelAlunoFoto.setBounds(420, 10, 120, 150);

        jComboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCurso.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxCursoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel4.add(jComboBoxCurso);
        jComboBoxCurso.setBounds(120, 90, 250, 20);
        jPanel4.add(jDateChooser1);
        jDateChooser1.setBounds(120, 160, 250, 20);

        jLabel9.setText("Sexo:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(10, 230, 28, 14);

        buttonGroupSexo.add(jRadioButtonMasculino);
        jRadioButtonMasculino.setSelected(true);
        jRadioButtonMasculino.setText("Masculino");
        jPanel4.add(jRadioButtonMasculino);
        jRadioButtonMasculino.setBounds(120, 230, 71, 23);

        buttonGroupSexo.add(jRadioButtonFeminino);
        jRadioButtonFeminino.setText("Feminino");
        jPanel4.add(jRadioButtonFeminino);
        jRadioButtonFeminino.setBounds(220, 230, 67, 23);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Login:");

        jLabel11.setText("Password:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldAlunoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldAlunoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jPasswordFieldAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(10, 320, 530, 50);

        jLabel12.setText("EMail:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(10, 260, 28, 14);
        jPanel4.add(jTextFieldAlunoEmail);
        jTextFieldAlunoEmail.setBounds(120, 260, 250, 20);

        jComboBoxUnidadeCurricular.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBoxUnidadeCurricular);
        jComboBoxUnidadeCurricular.setBounds(120, 128, 250, 20);

        jButtonAlterarPasswd.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonAlterarPasswd.setText("Alterar Password");
        jButtonAlterarPasswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarPasswdActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonAlterarPasswd);
        jButtonAlterarPasswd.setBounds(430, 380, 110, 21);

        jLabel44.setText("Ano Letivo:");
        jPanel4.add(jLabel44);
        jLabel44.setBounds(10, 290, 80, 14);
        jPanel4.add(jTextFieldAnoletivo);
        jTextFieldAnoletivo.setBounds(120, 290, 250, 20);

        jButtonAlunoGravar.setText("Gravar");
        jButtonAlunoGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlunoGravarActionPerformed(evt);
            }
        });

        jButtonAlunoEliminar.setText("Eliminar");
        jButtonAlunoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlunoEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogAlunosLayout = new javax.swing.GroupLayout(jDialogAlunos.getContentPane());
        jDialogAlunos.getContentPane().setLayout(jDialogAlunosLayout);
        jDialogAlunosLayout.setHorizontalGroup(
            jDialogAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDialogAlunosLayout.createSequentialGroup()
                        .addGap(0, 355, Short.MAX_VALUE)
                        .addComponent(jButtonAlunoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAlunoGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDialogAlunosLayout.setVerticalGroup(
            jDialogAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlunoGravar)
                    .addComponent(jButtonAlunoEliminar))
                .addContainerGap())
        );

        jDialogInsertResults.setMinimumSize(new java.awt.Dimension(530, 490));
        jDialogInsertResults.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogInsertResultsWindowClosing(evt);
            }
        });

        jTableInsertResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableInsertResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInsertResultsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableInsertResults);

        javax.swing.GroupLayout jDialogInsertResultsLayout = new javax.swing.GroupLayout(jDialogInsertResults.getContentPane());
        jDialogInsertResults.getContentPane().setLayout(jDialogInsertResultsLayout);
        jDialogInsertResultsLayout.setHorizontalGroup(
            jDialogInsertResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInsertResultsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jDialogInsertResultsLayout.setVerticalGroup(
            jDialogInsertResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInsertResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jDialogResultadosPorAtividade.setMinimumSize(new java.awt.Dimension(300, 550));
        jDialogResultadosPorAtividade.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogResultadosPorAtividadeWindowClosing(evt);
            }
        });

        jTableResultadosPorAtividade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Resultado"
            }
        ));
        jScrollPane5.setViewportView(jTableResultadosPorAtividade);

        jLabelDescricaoAtividade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDescricaoAtividade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescricaoAtividade.setText("Descrição Atividade");

        jButtonSaveResults.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSaveResults.setText("Save Results");
        jButtonSaveResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveResultsActionPerformed(evt);
            }
        });

        jButtonReadFile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonReadFile.setText("Read File");
        jButtonReadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogResultadosPorAtividadeLayout = new javax.swing.GroupLayout(jDialogResultadosPorAtividade.getContentPane());
        jDialogResultadosPorAtividade.getContentPane().setLayout(jDialogResultadosPorAtividadeLayout);
        jDialogResultadosPorAtividadeLayout.setHorizontalGroup(
            jDialogResultadosPorAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultadosPorAtividadeLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jDialogResultadosPorAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jDialogResultadosPorAtividadeLayout.createSequentialGroup()
                        .addComponent(jButtonReadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSaveResults, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelIdAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jLabelDescricaoAtividade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogResultadosPorAtividadeLayout.setVerticalGroup(
            jDialogResultadosPorAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogResultadosPorAtividadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDescricaoAtividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogResultadosPorAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogResultadosPorAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveResults)
                    .addComponent(jButtonReadFile))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jDialogRegistarPresenca.setTitle("Register Presence");
        jDialogRegistarPresenca.setMinimumSize(new java.awt.Dimension(530, 490));

        jTableRegistarPresenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableRegistarPresenca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRegistarPresencaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableRegistarPresenca);

        javax.swing.GroupLayout jDialogRegistarPresencaLayout = new javax.swing.GroupLayout(jDialogRegistarPresenca.getContentPane());
        jDialogRegistarPresenca.getContentPane().setLayout(jDialogRegistarPresencaLayout);
        jDialogRegistarPresencaLayout.setHorizontalGroup(
            jDialogRegistarPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRegistarPresencaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jDialogRegistarPresencaLayout.setVerticalGroup(
            jDialogRegistarPresencaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogRegistarPresencaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jDialogTestCodeKey.setTitle("Test Code Key");
        jDialogTestCodeKey.setMinimumSize(new java.awt.Dimension(500, 360));

        jButtonAddCodeKey.setText("Add Code Test");
        jButtonAddCodeKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCodeKeyActionPerformed(evt);
            }
        });

        jButtonAtvDeleteRow.setText("Delete Row");
        jButtonAtvDeleteRow.setToolTipText("Delete Selected Row");
        jButtonAtvDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtvDeleteRowActionPerformed(evt);
            }
        });

        jTableKeyCodeTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Number", "Comment", "Key Code Word"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTableKeyCodeTest);

        jButtonCodeKeyClose.setText("Close");
        jButtonCodeKeyClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCodeKeyCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAreaCodeKeyLayout = new javax.swing.GroupLayout(jPanelAreaCodeKey);
        jPanelAreaCodeKey.setLayout(jPanelAreaCodeKeyLayout);
        jPanelAreaCodeKeyLayout.setHorizontalGroup(
            jPanelAreaCodeKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaCodeKeyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaCodeKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAreaCodeKeyLayout.createSequentialGroup()
                        .addComponent(jButtonAddCodeKey, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonAtvDeleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCodeKeyClose, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaCodeKeyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelAreaCodeKeyLayout.setVerticalGroup(
            jPanelAreaCodeKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaCodeKeyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanelAreaCodeKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCodeKey)
                    .addComponent(jButtonAtvDeleteRow)
                    .addComponent(jButtonCodeKeyClose))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jDialogTestCodeKeyLayout = new javax.swing.GroupLayout(jDialogTestCodeKey.getContentPane());
        jDialogTestCodeKey.getContentPane().setLayout(jDialogTestCodeKeyLayout);
        jDialogTestCodeKeyLayout.setHorizontalGroup(
            jDialogTestCodeKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTestCodeKeyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAreaCodeKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogTestCodeKeyLayout.setVerticalGroup(
            jDialogTestCodeKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTestCodeKeyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAreaCodeKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogInsertOutput.setTitle("Insert Output");
        jDialogInsertOutput.setMinimumSize(new java.awt.Dimension(500, 360));

        jButtonAddOutput.setText("Add New Output");
        jButtonAddOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOutputActionPerformed(evt);
            }
        });

        jButtonOutputDeleteRow.setText("Delete Row");
        jButtonOutputDeleteRow.setToolTipText("Delete Selected Row");
        jButtonOutputDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutputDeleteRowActionPerformed(evt);
            }
        });

        jTableInsertOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Number", "Input", "Output"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTableInsertOutput);

        jButtonOutputClose.setText("Close");
        jButtonOutputClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutputCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAreaInsertOutputLayout = new javax.swing.GroupLayout(jPanelAreaInsertOutput);
        jPanelAreaInsertOutput.setLayout(jPanelAreaInsertOutputLayout);
        jPanelAreaInsertOutputLayout.setHorizontalGroup(
            jPanelAreaInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaInsertOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButtonOutputDeleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButtonOutputClose, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelAreaInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAreaInsertOutputLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelAreaInsertOutputLayout.setVerticalGroup(
            jPanelAreaInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaInsertOutputLayout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanelAreaInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddOutput)
                    .addComponent(jButtonOutputDeleteRow)
                    .addComponent(jButtonOutputClose))
                .addGap(34, 34, 34))
            .addGroup(jPanelAreaInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAreaInsertOutputLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jDialogInsertOutputLayout = new javax.swing.GroupLayout(jDialogInsertOutput.getContentPane());
        jDialogInsertOutput.getContentPane().setLayout(jDialogInsertOutputLayout);
        jDialogInsertOutputLayout.setHorizontalGroup(
            jDialogInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInsertOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAreaInsertOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogInsertOutputLayout.setVerticalGroup(
            jDialogInsertOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogInsertOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAreaInsertOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Ativity Number:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        jTextFieldidAtividade.setEditable(false);
        jPanel2.add(jTextFieldidAtividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 20, 140, -1));

        jLabel15.setText("Activity Date:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 53, -1, -1));
        jPanel2.add(jDateChooserDataAtividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 50, 140, -1));

        jButtonInserirAtividade.setText("Inserir");
        jButtonInserirAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirAtividadeActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInserirAtividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 145, 137, -1));

        jLabel16.setText("Description:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, -1));
        jPanel2.add(jTextFieldAtividadeDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 80, 290, -1));

        jLabel8.setText("Wording Question:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel2.add(jTextFieldSelectPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 110, 140, -1));

        jButtonSelectPDF.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSelectPDF.setText("Select PDF");
        jButtonSelectPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectPDFActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSelectPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 137, -1));

        jTableAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAtividadesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableAtividades);

        jButtonInsertResults.setText("Insert Results");
        jButtonInsertResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActivityLayout = new javax.swing.GroupLayout(jPanelActivity);
        jPanelActivity.setLayout(jPanelActivityLayout);
        jPanelActivityLayout.setHorizontalGroup(
            jPanelActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActivityLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanelActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInsertResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanelActivityLayout.setVerticalGroup(
            jPanelActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActivityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonInsertResults)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDialogPresencasPorData.setTitle("Ver Presenças Por Data");
        jDialogPresencasPorData.setMinimumSize(new java.awt.Dimension(570, 450));

        jTablePresencasPorData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(jTablePresencasPorData);

        javax.swing.GroupLayout jDialogPresencasPorDataLayout = new javax.swing.GroupLayout(jDialogPresencasPorData.getContentPane());
        jDialogPresencasPorData.getContentPane().setLayout(jDialogPresencasPorDataLayout);
        jDialogPresencasPorDataLayout.setHorizontalGroup(
            jDialogPresencasPorDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogPresencasPorDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogPresencasPorDataLayout.setVerticalGroup(
            jDialogPresencasPorDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogPresencasPorDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jDialogResultsStudentCharact.setTitle("Students Characterization");
        jDialogResultsStudentCharact.setMinimumSize(new java.awt.Dimension(850, 400));

        jTableStudentCharact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(jTableStudentCharact);

        javax.swing.GroupLayout jDialogResultsStudentCharactLayout = new javax.swing.GroupLayout(jDialogResultsStudentCharact.getContentPane());
        jDialogResultsStudentCharact.getContentPane().setLayout(jDialogResultsStudentCharactLayout);
        jDialogResultsStudentCharactLayout.setHorizontalGroup(
            jDialogResultsStudentCharactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultsStudentCharactLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogResultsStudentCharactLayout.setVerticalGroup(
            jDialogResultsStudentCharactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogResultsStudentCharactLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDialogMessageToStudent.setMinimumSize(new java.awt.Dimension(490, 400));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Número: ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Nome:");

        jLabelNomeAlunoMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNomeAlunoMsg.setText("-- Nome do Aluno --");
        jLabelNomeAlunoMsg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelNomeAlunoMsg.setEnabled(false);

        jLabelNumeroAlunoMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumeroAlunoMsg.setText("-- Numero --");
        jLabelNumeroAlunoMsg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelNumeroAlunoMsg.setEnabled(false);

        jTextAreaMsgToAluno.setColumns(20);
        jTextAreaMsgToAluno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAreaMsgToAluno.setRows(5);
        jScrollPane8.setViewportView(jTextAreaMsgToAluno);

        jButtonSendMsgAluno.setText("Send Message");
        jButtonSendMsgAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendMsgAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogMessageToStudentLayout = new javax.swing.GroupLayout(jDialogMessageToStudent.getContentPane());
        jDialogMessageToStudent.getContentPane().setLayout(jDialogMessageToStudentLayout);
        jDialogMessageToStudentLayout.setHorizontalGroup(
            jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogMessageToStudentLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                        .addGroup(jDialogMessageToStudentLayout.createSequentialGroup()
                            .addGroup(jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25))
                            .addGap(28, 28, 28)
                            .addGroup(jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelNomeAlunoMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                .addComponent(jLabelNumeroAlunoMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jButtonSendMsgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jDialogMessageToStudentLayout.setVerticalGroup(
            jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogMessageToStudentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNumeroAlunoMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jDialogMessageToStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabelNomeAlunoMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonSendMsgAluno)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jDialogNewParsonProblems.setMinimumSize(new java.awt.Dimension(780, 550));

        jPanelParsonProblems.setLayout(null);

        jTextAreaProgramSolution.setColumns(20);
        jTextAreaProgramSolution.setRows(5);
        jScrollPane17.setViewportView(jTextAreaProgramSolution);

        jPanelParsonProblems.add(jScrollPane17);
        jScrollPane17.setBounds(17, 69, 352, 352);

        jTextAreaShuffledProgram.setColumns(20);
        jTextAreaShuffledProgram.setRows(5);
        jScrollPane18.setViewportView(jTextAreaShuffledProgram);

        jPanelParsonProblems.add(jScrollPane18);
        jScrollPane18.setBounds(387, 69, 352, 350);

        jButtonSaveParsonProblem.setText("Save Parson Problem");
        jButtonSaveParsonProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveParsonProblemActionPerformed(evt);
            }
        });
        jPanelParsonProblems.add(jButtonSaveParsonProblem);
        jButtonSaveParsonProblem.setBounds(593, 440, 140, 23);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("New Description:");
        jPanelParsonProblems.add(jLabel27);
        jLabel27.setBounds(17, 14, 103, 17);

        jTextFieldParsonDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelParsonProblems.add(jTextFieldParsonDescricao);
        jTextFieldParsonDescricao.setBounds(130, 11, 205, 23);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Program Solution");
        jPanelParsonProblems.add(jLabel28);
        jLabel28.setBounds(17, 46, 106, 17);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Shuffled program");
        jPanelParsonProblems.add(jLabel29);
        jLabel29.setBounds(387, 46, 106, 17);

        jButtonShuffle.setText("Shuffle");
        jButtonShuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShuffleActionPerformed(evt);
            }
        });
        jPanelParsonProblems.add(jButtonShuffle);
        jButtonShuffle.setBounds(649, 40, 90, 23);

        javax.swing.GroupLayout jDialogNewParsonProblemsLayout = new javax.swing.GroupLayout(jDialogNewParsonProblems.getContentPane());
        jDialogNewParsonProblems.getContentPane().setLayout(jDialogNewParsonProblemsLayout);
        jDialogNewParsonProblemsLayout.setHorizontalGroup(
            jDialogNewParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
            .addGroup(jDialogNewParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogNewParsonProblemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelParsonProblems, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jDialogNewParsonProblemsLayout.setVerticalGroup(
            jDialogNewParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
            .addGroup(jDialogNewParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogNewParsonProblemsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelParsonProblems, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialogSeason.setTitle("Select Season");
        jDialogSeason.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Season:");

        jComboBoxSeason.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Season --" }));
        jComboBoxSeason.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxSeasonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel41.setText("New Season:");

        jButtonAddSeason.setText("Add Season");
        jButtonAddSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSeasonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSeasonLayout = new javax.swing.GroupLayout(jDialogSeason.getContentPane());
        jDialogSeason.getContentPane().setLayout(jDialogSeasonLayout);
        jDialogSeasonLayout.setHorizontalGroup(
            jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSeasonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogSeasonLayout.createSequentialGroup()
                        .addGroup(jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel39))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNewSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jDialogSeasonLayout.setVerticalGroup(
            jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSeasonLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jComboBoxSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jDialogSeasonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextFieldNewSeason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAddSeason)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Help Programming");
        setMinimumSize(new java.awt.Dimension(800, 550));
        setResizable(false);

        jTabbedPanePrincipal.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPanePrincipal.setMinimumSize(new java.awt.Dimension(750, 500));
        jTabbedPanePrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPanePrincipalMouseClicked(evt);
            }
        });

        jPanelPrincipalAlunos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane4.setBorder(null);

        jTableTodosAlunosPrincipal.setAutoCreateRowSorter(true);
        jTableTodosAlunosPrincipal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTableTodosAlunosPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Foto", "Número", "Nome", "Perfil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTodosAlunosPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTodosAlunosPrincipalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTodosAlunosPrincipal);

        jButtonNewStudent.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonNewStudent.setText("New Student");
        jButtonNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewStudentActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Curso:");

        jComboBoxCursosInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxCursosInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Select Course --" }));
        jComboBoxCursosInicial.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxCursosInicialPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButtonTopStudents.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTopStudents.setText("Top");
        jButtonTopStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTopStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalAlunosLayout = new javax.swing.GroupLayout(jPanelPrincipalAlunos);
        jPanelPrincipalAlunos.setLayout(jPanelPrincipalAlunosLayout);
        jPanelPrincipalAlunosLayout.setHorizontalGroup(
            jPanelPrincipalAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
            .addGroup(jPanelPrincipalAlunosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonNewStudent))
            .addGroup(jPanelPrincipalAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jComboBoxCursosInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTopStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPrincipalAlunosLayout.setVerticalGroup(
            jPanelPrincipalAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBoxCursosInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTopStudents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNewStudent)
                .addGap(6, 6, 6))
        );

        jTabbedPanePrincipal.addTab("Students", new javax.swing.ImageIcon(getClass().getResource("/icons/student.png")), jPanelPrincipalAlunos); // NOI18N

        jButtonUpdateScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jButtonUpdateScore.setText("Update Score");
        jButtonUpdateScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateScoreActionPerformed(evt);
            }
        });

        jButtonInitializeScore.setText("Initialize Score");
        jButtonInitializeScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInitializeScoreActionPerformed(evt);
            }
        });

        jPanelBlockedTabs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Blocked tabs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jRadioButton1.setText("Tab1: User");
        jRadioButton1.setName("1"); // NOI18N

        jRadioButton2.setText("Tab2: Messages");
        jRadioButton2.setName("2"); // NOI18N

        jRadioButton3.setText("Tab3: Work Done");
        jRadioButton3.setName("3"); // NOI18N

        jRadioButton4.setText("Tab4: Activities");
        jRadioButton4.setName("4"); // NOI18N

        jRadioButton5.setText("Tab5: Coding to do");
        jRadioButton5.setName("5"); // NOI18N

        jRadioButton6.setText("Tab6: Student Programming");
        jRadioButton6.setName("6"); // NOI18N

        jRadioButton7.setText("Tab7: Punched Holes");
        jRadioButton7.setName("7"); // NOI18N

        jButtonApplyBlockTabs.setText("Apply");
        jButtonApplyBlockTabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApplyBlockTabsActionPerformed(evt);
            }
        });

        jRadioButton8.setText("Tab 8: Parson Problems");
        jRadioButton8.setName("8"); // NOI18N

        javax.swing.GroupLayout jPanelBlockedTabsLayout = new javax.swing.GroupLayout(jPanelBlockedTabs);
        jPanelBlockedTabs.setLayout(jPanelBlockedTabsLayout);
        jPanelBlockedTabsLayout.setHorizontalGroup(
            jPanelBlockedTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBlockedTabsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonApplyBlockTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanelBlockedTabsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBlockedTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBlockedTabsLayout.setVerticalGroup(
            jPanelBlockedTabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBlockedTabsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButtonApplyBlockTabs)
                .addContainerGap())
        );

        jPanelActiveStudents.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Active Students", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTableActiveStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTableActiveStudents);

        jButtonRefreshTableActiveStudents.setText("Refresh");
        jButtonRefreshTableActiveStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshTableActiveStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActiveStudentsLayout = new javax.swing.GroupLayout(jPanelActiveStudents);
        jPanelActiveStudents.setLayout(jPanelActiveStudentsLayout);
        jPanelActiveStudentsLayout.setHorizontalGroup(
            jPanelActiveStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActiveStudentsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelActiveStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActiveStudentsLayout.createSequentialGroup()
                        .addComponent(jButtonRefreshTableActiveStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanelActiveStudentsLayout.setVerticalGroup(
            jPanelActiveStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActiveStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButtonRefreshTableActiveStudents)
                .addContainerGap())
        );

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Current Year:");

        jTextFieldDefCurrentYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonDefCurrentYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDefCurrentYear.setText("Apply");
        jButtonDefCurrentYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefCurrentYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDefinitionsLayout = new javax.swing.GroupLayout(jPanelDefinitions);
        jPanelDefinitions.setLayout(jPanelDefinitionsLayout);
        jPanelDefinitionsLayout.setHorizontalGroup(
            jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDefinitionsLayout.createSequentialGroup()
                .addGroup(jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDefinitionsLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelBlockedTabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDefinitionsLayout.createSequentialGroup()
                                .addComponent(jButtonInitializeScore, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonUpdateScore, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanelActiveStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDefinitionsLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldDefCurrentYear, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDefCurrentYear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelDefinitionsLayout.setVerticalGroup(
            jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDefinitionsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextFieldDefCurrentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDefCurrentYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBlockedTabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelActiveStudents, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanelDefinitionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInitializeScore, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdateScore, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPanePrincipal.addTab("Definitions", new javax.swing.ImageIcon(getClass().getResource("/icons/config.png")), jPanelDefinitions); // NOI18N

        jButtonAddNewActivity.setText("Add New Activity");
        jButtonAddNewActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewActivityActionPerformed(evt);
            }
        });

        jScrollPane16.setViewportView(jTableVerQuestionario);

        javax.swing.GroupLayout jPanelIntroduActivitiesLayout = new javax.swing.GroupLayout(jPanelIntroduActivities);
        jPanelIntroduActivities.setLayout(jPanelIntroduActivitiesLayout);
        jPanelIntroduActivitiesLayout.setHorizontalGroup(
            jPanelIntroduActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntroduActivitiesLayout.createSequentialGroup()
                .addGroup(jPanelIntroduActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIntroduActivitiesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelIntroduActivitiesLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jButtonAddNewActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanelIntroduActivitiesLayout.setVerticalGroup(
            jPanelIntroduActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIntroduActivitiesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddNewActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPanePrincipal.addTab("Basic Concepts", new javax.swing.ImageIcon(getClass().getResource("/icons/setTasks.png")), jPanelIntroduActivities); // NOI18N

        jPanelConfActivity.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Activity Number:");

        jTextFieldActNumber.setToolTipText("<html>Sequence Number ### + <br> ## variation <br> Ex: 00201 </html>");

        jLabel17.setText("Wording Activity");

        jTextAreaTextActivity.setColumns(20);
        jTextAreaTextActivity.setRows(5);
        jScrollPane10.setViewportView(jTextAreaTextActivity);

        jLabel18.setText("Number Input Test:");

        jTextFieldNumberInputTest.setText("0");

        jLabel19.setText("Activity Date:");

        jButtonSaveActivity.setText("Save Activity");
        jButtonSaveActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActivityActionPerformed(evt);
            }
        });

        jButtonOutputSettings.setText("Output Settings");
        jButtonOutputSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutputSettingsActionPerformed(evt);
            }
        });

        jLabel21.setText("Number Code Test:");

        jTextFieldnTest.setText("0");

        jButtonCodeSettings.setText("Code Settings");
        jButtonCodeSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCodeSettingsActionPerformed(evt);
            }
        });

        jLabel22.setText("Read from Configured File:");

        jButtonSelectConfFile.setText("Select File");

        jTextField1.setEditable(false);

        jButtonAtvNewClear.setText("New / Clear");
        jButtonAtvNewClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtvNewClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConfActivityLayout = new javax.swing.GroupLayout(jPanelConfActivity);
        jPanelConfActivity.setLayout(jPanelConfActivityLayout);
        jPanelConfActivityLayout.setHorizontalGroup(
            jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfActivityLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserDateActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                        .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfActivityLayout.createSequentialGroup()
                                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNumberInputTest, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonAtvNewClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 183, Short.MAX_VALUE)
                        .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonOutputSettings, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addComponent(jButtonCodeSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonSaveActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSelectConfFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                        .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(39, 39, 39)
                            .addComponent(jTextFieldActNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 373, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanelConfActivityLayout.setVerticalGroup(
            jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserDateActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(11, 11, 11)
                .addComponent(jLabel17)
                .addGap(183, 183, 183)
                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldNumberInputTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOutputSettings))
                .addGap(18, 18, 18)
                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldnTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCodeSettings))
                .addGap(18, 18, 18)
                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jButtonSelectConfFile)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveActivity)
                    .addComponent(jButtonAtvNewClear))
                .addContainerGap())
            .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConfActivityLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelConfActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextFieldActNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(223, Short.MAX_VALUE)))
        );

        jListActivities.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListActivitiesMouseClicked(evt);
            }
        });
        jScrollPaneActivityShow.setViewportView(jListActivities);

        jLabel20.setText("Activities");

        javax.swing.GroupLayout jPanelNewActivityLayout = new javax.swing.GroupLayout(jPanelNewActivity);
        jPanelNewActivity.setLayout(jPanelNewActivityLayout);
        jPanelNewActivityLayout.setHorizontalGroup(
            jPanelNewActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewActivityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNewActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneActivityShow, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(jPanelConfActivity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanelNewActivityLayout.setVerticalGroup(
            jPanelNewActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewActivityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNewActivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelConfActivity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelNewActivityLayout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneActivityShow, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPanePrincipal.addTab("Coding Activity", new javax.swing.ImageIcon(getClass().getResource("/icons/taskDone2.png")), jPanelNewActivity); // NOI18N

        jDateChooserRegistarPresenca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableAlunoPresenca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Numero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAlunoPresenca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlunoPresencaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableAlunoPresenca);

        jButtonSavePresences.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSavePresences.setText("Save Presences");
        jButtonSavePresences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePresencesActionPerformed(evt);
            }
        });

        jLabel7.setText("Total:");

        jLabelTotalPresencas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPresencas.setText("0");
        jLabelTotalPresencas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalPresencas.setEnabled(false);

        jTableDataTotalAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Data", "Hour", "Course", "Total Students"
            }
        ));
        jTableDataTotalAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataTotalAlunosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableDataTotalAlunos);

        jLabel26.setText("Course:");

        jButtonReadFilePresences.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonReadFilePresences.setText("Read File");
        jButtonReadFilePresences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadFilePresencesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinnerHourPresences.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        jLabel30.setText("Hour:");

        javax.swing.GroupLayout jPanelPresencesLayout = new javax.swing.GroupLayout(jPanelPresences);
        jPanelPresences.setLayout(jPanelPresencesLayout);
        jPanelPresencesLayout.setHorizontalGroup(
            jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPresencesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPresencesLayout.createSequentialGroup()
                        .addComponent(jDateChooserRegistarPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerHourPresences, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCursoPresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelPresencesLayout.createSequentialGroup()
                        .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelPresencesLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTotalPresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonReadFilePresences, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9)
                            .addGroup(jPanelPresencesLayout.createSequentialGroup()
                                .addComponent(jButtonSavePresences)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanelPresencesLayout.setVerticalGroup(
            jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPresencesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserRegistarPresenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jComboBoxCursoPresencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerHourPresences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30)))
                .addGap(18, 18, 18)
                .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanelPresencesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalPresencas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButtonSavePresences)
                    .addComponent(jButtonReadFilePresences)
                    .addComponent(jButton1))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPanePrincipal.addTab("Presences", new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.png")), jPanelPresences); // NOI18N

        jButtonStudentCharact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonStudentCharact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stPersonal.png"))); // NOI18N
        jButtonStudentCharact.setText("Student Characterization");
        jButtonStudentCharact.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonStudentCharact.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonStudentCharact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStudentCharactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelResultStudentPersonalLayout = new javax.swing.GroupLayout(jPanelResultStudentPersonal);
        jPanelResultStudentPersonal.setLayout(jPanelResultStudentPersonalLayout);
        jPanelResultStudentPersonalLayout.setHorizontalGroup(
            jPanelResultStudentPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultStudentPersonalLayout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(jButtonStudentCharact)
                .addGap(189, 189, 189))
        );
        jPanelResultStudentPersonalLayout.setVerticalGroup(
            jPanelResultStudentPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultStudentPersonalLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButtonStudentCharact, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );

        jTabbedPanePrincipal.addTab("<html> Student <br> Characterization</html>", new javax.swing.ImageIcon(getClass().getResource("/icons/stPersonal.png")), jPanelResultStudentPersonal); // NOI18N

        jTableViewParsonProblems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableViewParsonProblems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableViewParsonProblemsMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(jTableViewParsonProblems);

        jButtonNewParsonProblem.setText("New Parson Problem");
        jButtonNewParsonProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewParsonProblemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAreaParsonProblemsLayout = new javax.swing.GroupLayout(jPanelAreaParsonProblems);
        jPanelAreaParsonProblems.setLayout(jPanelAreaParsonProblemsLayout);
        jPanelAreaParsonProblemsLayout.setHorizontalGroup(
            jPanelAreaParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaParsonProblemsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaParsonProblemsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNewParsonProblem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanelAreaParsonProblemsLayout.setVerticalGroup(
            jPanelAreaParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaParsonProblemsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jButtonNewParsonProblem)
                .addGap(85, 85, 85))
        );

        jTabbedPanePrincipal.addTab("Parson Problems", new javax.swing.ImageIcon(getClass().getResource("/icons/dragdrop.png")), jPanelAreaParsonProblems); // NOI18N

        jTableExpert.setAutoCreateRowSorter(true);
        jTableExpert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Presences", "SP", "PH", "IC", "PP", "Basic", "if/switch", "Loops", "Arrays", "Advanced", "Expected"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane25.setViewportView(jTableExpert);

        jButtonRefreshExpert.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonRefreshExpert.setText("Refresh");
        jButtonRefreshExpert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshExpertActionPerformed(evt);
            }
        });

        jButtonSaveCSVFile.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSaveCSVFile.setText("Save CSV File");
        jButtonSaveCSVFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCSVFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelExpertLayout = new javax.swing.GroupLayout(jPanelExpert);
        jPanelExpert.setLayout(jPanelExpertLayout);
        jPanelExpertLayout.setHorizontalGroup(
            jPanelExpertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExpertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelExpertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addGroup(jPanelExpertLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSaveCSVFile, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRefreshExpert, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelExpertLayout.setVerticalGroup(
            jPanelExpertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExpertLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelExpertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRefreshExpert)
                    .addComponent(jButtonSaveCSVFile))
                .addContainerGap())
        );

        jTabbedPanePrincipal.addTab("Expert System", new javax.swing.ImageIcon(getClass().getResource("/icons/AI.png")), jPanelExpert); // NOI18N

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoCLGrande.png"))); // NOI18N

        buttonGroupTypeDraw.add(jRadioButtonRandomDraw);
        jRadioButtonRandomDraw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonRandomDraw.setText("Random Draw");

        buttonGroupTypeDraw.add(jRadioButtonScoreDraw);
        jRadioButtonScoreDraw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonScoreDraw.setSelected(true);
        jRadioButtonScoreDraw.setText("Score Draw");

        jButtonDraw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDraw.setText("Draw");
        jButtonDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDrawActionPerformed(evt);
            }
        });

        jTableDraw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Game", "Student 1", "Result 1", "Student 2", "Result 2", "Coding"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane26.setViewportView(jTableDraw);

        jTableStudentTODraw.setAutoCreateRowSorter(true);
        jTableStudentTODraw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane27.setViewportView(jTableStudentTODraw);

        jButtonStepDraw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonStepDraw.setText("Step Draw");
        jButtonStepDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepDrawActionPerformed(evt);
            }
        });

        jLabel37.setText("Total Students:");

        jLabelNumberToDraw.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNumberToDraw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumberToDraw.setText("0");
        jLabelNumberToDraw.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelNumberToDraw.setOpaque(true);

        jButtonSaveRound.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSaveRound.setText("Save Round");
        jButtonSaveRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveRoundActionPerformed(evt);
            }
        });

        jLabelSeason.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSeason.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelSeason.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSeason.setText("Season");
        jLabelSeason.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelSeason.setOpaque(true);

        jButtonSeason.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSeason.setText("Choose Season");
        jButtonSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeasonActionPerformed(evt);
            }
        });

        jLabel40.setText("Round:");

        jButtonInitialize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonInitialize.setText("Initialize");
        jButtonInitialize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInitializeActionPerformed(evt);
            }
        });

        jTextFieldRound.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRound.setText("1");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Show Draw/Result:");

        jComboBoxDrawResult.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Choose Draw / Result --" }));
        jComboBoxDrawResult.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxDrawResultPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButtonCheckResults.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonCheckResults.setText("Check Results");
        jButtonCheckResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckResultsActionPerformed(evt);
            }
        });

        buttonGroupManualAutoResults.add(jRadioButtonAutomaticResults);
        jRadioButtonAutomaticResults.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButtonAutomaticResults.setSelected(true);
        jRadioButtonAutomaticResults.setText("Automatic");

        buttonGroupManualAutoResults.add(jRadioButtonManualResults);
        jRadioButtonManualResults.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButtonManualResults.setText("Manual");

        javax.swing.GroupLayout jPanelGamificationLayout = new javax.swing.GroupLayout(jPanelGamification);
        jPanelGamification.setLayout(jPanelGamificationLayout);
        jPanelGamificationLayout.setHorizontalGroup(
            jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGamificationLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGamificationLayout.createSequentialGroup()
                        .addComponent(jRadioButtonScoreDraw)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jRadioButtonRandomDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonStepDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSeason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSeason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInitialize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGamificationLayout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldRound)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGamificationLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNumberToDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addGroup(jPanelGamificationLayout.createSequentialGroup()
                        .addComponent(jButtonSaveRound, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCheckResults)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonAutomaticResults)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonManualResults)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelGamificationLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxDrawResult, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelGamificationLayout.setVerticalGroup(
            jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGamificationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSaveRound)
                        .addComponent(jButtonCheckResults)
                        .addComponent(jRadioButtonAutomaticResults)
                        .addComponent(jRadioButtonManualResults))
                    .addGroup(jPanelGamificationLayout.createSequentialGroup()
                        .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGamificationLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonSeason)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSeason)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(jTextFieldRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonInitialize)
                                .addGap(39, 39, 39)
                                .addComponent(jRadioButtonRandomDraw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonScoreDraw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDraw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonStepDraw))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGamificationLayout.createSequentialGroup()
                                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(jComboBoxDrawResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                    .addComponent(jScrollPane26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGamificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabelNumberToDraw))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanePrincipal.addTab("Gamification", new javax.swing.ImageIcon(getClass().getResource("/icons/logoChampions.png")), jPanelGamification); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jTabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jTabbedPanePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(934, 551));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciaExpert() {
        for (String key : alunosFotos.keySet()) {
            mExpert.put(key, new AlunoExpert(key));
        }

        for (String number : mExpert.keySet()) {
            ArrayList<NumeroPerfil> tIC = new ArrayList<>();
            ArrayList<NumeroPerfil> tPP = new ArrayList<>();
            ArrayList<NumeroPerfil> tBasic = new ArrayList<>();
            ArrayList<NumeroPerfil> tIfs = new ArrayList<>();
            ArrayList<NumeroPerfil> tLoops = new ArrayList<>();
            ArrayList<NumeroPerfil> tArrays = new ArrayList<>();
            ArrayList<NumeroPerfil> tAdv = new ArrayList<>();
            String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
            int presences = UtilBDConsulta.totalPresencasPorNumero(liga, number, datacorrente);
            // Utilizar se para adaptar ao total de aulas
            //presences = (presences * 20) / 45;
            DadosPreAtv dados = UtilBDConsulta.verificaCAPDados(liga, number, datacorrente);
            int sp = dados.getScore();
            dados = UtilBDConsulta.verificaTestSpatialDados(liga, number, datacorrente);
            int sv = dados.getScore();
            ArrayList<DadosPreAtv> t = UtilBDConsulta.verificaQuestionarioAluno(liga, number, datacorrente);
            for (DadosPreAtv d : t) {
                String nome = d.getNome();
                int id = Integer.parseInt(nome);
                int resultado = d.getScore();
                tIC.add(new NumeroPerfil(number, 90000 + id, resultado));
            }
            int ic = CalcularResultados.calculoTotalPerfil(tIC);
            t = UtilBDConsulta.verificaParsonProblemsDados(liga, number);
            for (DadosPreAtv d : t) {
                String nome = d.getNome();
                int id = Integer.parseInt(nome.substring(2, nome.length()));
                int resultado = d.getScore();
                tPP.add(new NumeroPerfil(number, 80000 + id, resultado));
            }
            int pp = CalcularResultados.calculoTotalPerfil(tPP);
            ArrayList<DadosCoding> tDados = UtilBDConsulta.getDadosCodingNewAtividades(liga, number, datacorrente);
            for (DadosCoding dc : tDados) {
                String descricao = dc.getDescricao();
                int resultado = dc.getResultado();
                int idatividade = Integer.parseInt(descricao.toString());
                if (descricao.charAt(2) == '3') { //jTableAtividadesAluno
                    tBasic.add(new NumeroPerfil(number, idatividade, resultado));
                } else if (descricao.charAt(2) == '4') { //jTableAtividadesAlunoIF
                    tIfs.add(new NumeroPerfil(number, idatividade, resultado));
                } else if (descricao.charAt(2) == '5') { //jTablePreAtividadeAlunoLoop
                    tLoops.add(new NumeroPerfil(number, idatividade, resultado));
                } else if (descricao.charAt(2) == '6') { //jTableAtividadesAlunoArrays
                    tArrays.add(new NumeroPerfil(number, idatividade, resultado));
                } else if (descricao.charAt(2) == '7') { // jTableAtividadesAlunoAdvanced
                    tAdv.add(new NumeroPerfil(number, idatividade, resultado));
                } else {                                 //Qualquer outro jTableAtividadesAluno
                    tBasic.add(new NumeroPerfil(number, idatividade, resultado));
                }
            }
            int basic = CalcularResultados.calculoTotalPerfil(tBasic);
            int ifs = CalcularResultados.calculoTotalPerfil(tIfs);
            int loop = CalcularResultados.calculoTotalPerfil(tLoops);
            int arrays = CalcularResultados.calculoTotalPerfil(tArrays);
            int adv = CalcularResultados.calculoTotalPerfil(tAdv);
            double expected = 0;
            mExpert.put(number, new AlunoExpert(number, presences, sp, sv, ic, pp, basic,
                    ifs, loop, arrays, adv, expected));
        }

        DefaultTableModel modelo = (DefaultTableModel) jTableExpert.getModel();
        modelo.setRowCount(0);
        for (Map.Entry<String, AlunoExpert> entry : mExpert.entrySet()) {
            AlunoExpert ae = entry.getValue();
            Object[] dados = {ae.getNumber(), ae.getPresences(), ae.getSp(), ae.getSv(),
                ae.getIc(), ae.getPp(), ae.getBasic(), ae.getIfs(), ae.getLoop(),
                ae.getArrays(), ae.getAdv(), ae.getExpected()};
            modelo.addRow(dados);
        }

    }

    private void refreshActiveStudentsTable() {
        jTableActiveStudents.setModel(UtilBDConsulta.verActiveStudents(liga));
    }

    private void iniciaLabelTotalAtividade(String numero) {
        tabelaTotal.put("jLabelTotalPreActivities", jLabelTotalPreActivities);
        tabelaTotal.put("jLabelTotalBasic", jLabelTotalBasic);
        tabelaTotal.put("jLabelTotalIf", jLabelTotalIf);
        tabelaTotal.put("jLabelTotalLoop", jLabelTotalLoop);
        tabelaTotal.put("jLabelTotalArrays", jLabelTotalArrays);
        tabelaTotal.put("jLabelTotalAdvanced", jLabelTotalAdvanced);
        refreshCalcularTotalParcial(numero);
    }

    private void refreshCalcularTotalParcial(String numero) {
        int total = calcularTotalParcialPreAtividades(jTablePreAtividadeAluno, numero);
        total += calcularTotalParcialAtividades(jTableAtividadesAluno, numero);
        total += calcularTotalParcialAtividades(jTableAtividadesAlunoIF, numero);
        total += calcularTotalParcialAtividades(jTablePreAtividadeAlunoLoop, numero);
        total += calcularTotalParcialAtividades(jTableAtividadesAlunoArrays, numero);
        total += calcularTotalParcialAtividades(jTableAtividadesAlunoAdvanced, numero);
        jLabelAlunoScoreInf.setText("" + total);
//        UtilBDConsulta.gravaPerfilTotalNumeroAluno(liga, numero, total);     
    }

    private int calcularTotalParcialPreAtividades(JTable table, String numero) {
        ArrayList<NumeroPerfil> t = new ArrayList<>();

        for (int linha = 0; linha < table.getRowCount(); linha++) {
            String nome = table.getValueAt(linha, 0).toString();
            int resultado = Integer.parseInt(table.getValueAt(linha, 2).toString());
            if (nome.equalsIgnoreCase("Punched Holes")) {
                t.add(new NumeroPerfil(numero, 99999, resultado));
            } else if (nome.equalsIgnoreCase("Student Programming")) {
                t.add(new NumeroPerfil(numero, 99998, resultado));
            } else if ((nome.equalsIgnoreCase("Presences"))) {
                t.add(new NumeroPerfil(numero, 99991, resultado));
            } else if (nome.length() > 1) {
                try {
                    if (nome.substring(0, 2).equals("PP")) {
                        int id = Integer.parseInt(nome.substring(2, nome.length()));
                        t.add(new NumeroPerfil(numero, 80000 + id, resultado));
                    } else if (nome.substring(0, 2).equals("IC")) { //Initial Concepts(IC): Names and Variables, Basic Concepts errors
                        int id = Integer.parseInt(nome.substring(2, nome.length()));
                        t.add(new NumeroPerfil(numero, 90000 + id, resultado));
                    }
                } catch (NumberFormatException e) {
                    // se erro na conversão para inteiro
                }
            } else {
                t.add(new NumeroPerfil(numero, 99990, resultado));
            }
        }

        int r = CalcularResultados.calculoTotalPerfil(t);
        tabelaTotal.get(table.getName()).setText("" + r);
        return r;
    }

    private int calcularTotalParcialAtividades(JTable table, String numero) {
        ArrayList<NumeroPerfil> t = new ArrayList<>();
        for (int linha = 0; linha < table.getRowCount(); linha++) {
//            String numero = alunoAtivo.getNumero();
            int idatividade = Integer.parseInt(table.getValueAt(linha, 0).toString());
            int resultado = Integer.parseInt(table.getValueAt(linha, 2).toString());
            t.add(new NumeroPerfil(numero, idatividade, resultado));
        }
        int r = CalcularResultados.calculoTotalPerfil(t);
        tabelaTotal.get(table.getName()).setText("" + r);
        return r;
    }

    private void iniciaParsonProblems() {
        jTableViewParsonProblems.setModel(UtilBDConsulta.verParsonProblems(liga));
    }

    private void lerAlunosBD() {

        model2 = UtilBDConsulta.verNomeNumeroFoto(liga, cursoAtivo, anoletivo);

        jTableTodosAlunosPrincipal.setModel(model2);
        jTableTodosAlunosPrincipal.setRowHeight(35);

        jTableTodosAlunosPrincipal.getColumnModel().getColumn(0).setMaxWidth(40);
        jTableTodosAlunosPrincipal.getColumnModel().getColumn(1).setMaxWidth(100);
//        jTableTodosAlunosPrincipal.getColumnModel().getColumn(2).setMaxWidth(200);
        jTableTodosAlunosPrincipal.getColumnModel().getColumn(3).setMaxWidth(80);
//        jTableTodosAlunosPrincipal.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        jTableTodosAlunosPrincipal.setTableHeader(null);

        carregaFotosMap(model2);
        jTableTodosAlunosPrincipal.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(alunosFotos));
        
    }

    private void atualizarPerfilAlunos() {
        ArrayList<NumeroPerfil> t = UtilBDConsulta.atualizarNewPerfil(liga);
        for (NumeroPerfil a : t) {
            // Calcular novo valor perfil
            ArrayList<NumeroPerfil> tr = UtilBDConsulta.atualizarPerfilAtvResultados(liga, a.getNumero());
            int r = CalcularResultados.calculoTotalPerfil(tr);
            UtilBDConsulta.gravaTotalPerfilNumeroAluno(liga, a.getNumero(), r);
        }
    }

    private void lerAlunosAtividadesBDNOVA(JTable table) {

//        con = (Connection) liga.makeCon();
//        ResultSetTableModel modelo = UtilBDConsulta.verNomeNumeroFotoSemPerfil(liga);
        table.setModel(model2);
        table.setRowHeight(35);

//        table.getColumnModel().getColumn(0).setPreferredWidth(50);
//        table.getColumnModel().getColumn(1).setPreferredWidth(50);
//        table.getColumnModel().getColumn(2).setPreferredWidth(120);
//        jTableInsertResults.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.setTableHeader(null);

        carregaFotosMap(model2);
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(alunosFotos));

    }

    private void carregaFotosMap(ResultSetTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String numero = modelo.getValueAt(i, 1).toString();
            BufferedImage bf = IOImagem.getImageByNumero(liga, numero);
            alunosFotos.put(numero, bf);
        }

    }

    private void lerAtividadesBD(String numero) {
//        ResultSetTableModel modelo = UtilBDConsulta.verAtividades(liga, numero);
        iniciaPreAtividadesAluno(numero);
//       iniciaAtividadesAluno(numero) ;
        iniciaAtividadesCoding(numero);
    }

    public void iniciaAtividadesAluno(String numero) {
        ResultSetTableModel modelo = UtilBDConsulta.verNewAtividades(liga, numero);
        jTableAtividadesAluno.setModel(modelo);
        jTableAtividadesAluno.setDefaultRenderer(Object.class, new CustomRendererColor());
    }

    public void iniciaPreAtividadesAluno(String numero) {
        DefaultTableModel modelo = (DefaultTableModel) jTablePreAtividadeAluno.getModel();
        modelo.setRowCount(0);
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        int total = UtilBDConsulta.totalPresencasPorNumero(liga, numero, datacorrente);
        total = (total * 20) / 45;
        if (total >= 0) {
            LocalDate hoje = LocalDate.now();
            Object[] data = {"Presences", hoje, total};
            modelo.addRow(data);
        }
        if (UtilBDConsulta.verificaCAP(liga, numero)) {
            DadosPreAtv dados = UtilBDConsulta.verificaCAPDados(liga, numero);
            Object[] data = {dados.getNome(), dados.getData(), dados.getScore()};
            modelo.addRow(data);
        }
        if (UtilBDConsulta.verificaTestSpatial(liga, numero)) {
            DadosPreAtv dados = UtilBDConsulta.verificaTestSpatialDados(liga, numero);
            Object[] data = {dados.getNome(), dados.getData(), dados.getScore()};
            modelo.addRow(data);
        }
        iniciaQuestionariosAluno(numero);
        iniciaParsonProblemsAtividadesAluno(numero);
    }

    public void iniciaAtividadesCoding(String numero) {

        ArrayList<DadosCoding> tDados = UtilBDConsulta.getDadosCodingNewAtividades(liga, numero);
        DefaultTableModel modelo3 = (DefaultTableModel) jTableAtividadesAluno.getModel();
        DefaultTableModel modelo4 = (DefaultTableModel) jTableAtividadesAlunoIF.getModel();
        DefaultTableModel modelo5 = (DefaultTableModel) jTablePreAtividadeAlunoLoop.getModel();
        DefaultTableModel modelo6 = (DefaultTableModel) jTableAtividadesAlunoArrays.getModel();
        DefaultTableModel modelo7 = (DefaultTableModel) jTableAtividadesAlunoAdvanced.getModel();
        modelo3.setRowCount(0);
        modelo4.setRowCount(0);
        modelo5.setRowCount(0);
        modelo6.setRowCount(0);
        modelo7.setRowCount(0);

        for (DadosCoding dc : tDados) {
            String descricao = dc.getDescricao();
            LocalDate data = dc.getData();
            int resultado = dc.getResultado();
            Object[] dados = {descricao, data, resultado};
            if (descricao.charAt(2) == '3') { //jTableAtividadesAluno
                modelo3.addRow(dados);
            } else if (descricao.charAt(2) == '4') { //jTableAtividadesAlunoIF
                modelo4.addRow(dados);
            } else if (descricao.charAt(2) == '5') { //jTablePreAtividadeAlunoLoop
                modelo5.addRow(dados);
            } else if (descricao.charAt(2) == '6') { //jTableAtividadesAlunoArrays
                modelo6.addRow(dados);
            } else if (descricao.charAt(2) == '7') { // jTableAtividadesAlunoAdvanced
                modelo7.addRow(dados);
            } else {                                        //Qualquer outro jTableAtividadesAluno
                modelo3.addRow(dados);
            }
        }

    }

    public void iniciaQuestionariosAluno(String numero) {
        DefaultTableModel modelo = (DefaultTableModel) jTablePreAtividadeAluno.getModel();

        ArrayList<DadosPreAtv> t = UtilBDConsulta.verificaQuestionarioAluno(liga, numero);
        if (t.size() > 0) {
            for (DadosPreAtv dados : t) {
                Object[] data = {"IC" + dados.getNome(), dados.getData(), dados.getScore()};
                modelo.addRow(data);
            }
        }
    }

    public void iniciaParsonProblemsAtividadesAluno(String numero) {
        DefaultTableModel modelo = (DefaultTableModel) jTablePreAtividadeAluno.getModel();

        ArrayList<DadosPreAtv> t = UtilBDConsulta.verificaParsonProblemsDados(liga, numero);
        if (t.size() > 0) {
            for (DadosPreAtv dados : t) {
                Object[] data = {dados.getNome(), dados.getData(), dados.getScore()};
                modelo.addRow(data);
            }
        }
    }


    private void jTableTodosAlunosPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTodosAlunosPrincipalMouseClicked
        if (evt.getClickCount() == 2) { // Editar Aluno

            int linha = jTableTodosAlunosPrincipal.getSelectedRow();
            if (linha >= 0) {
                String nome = jTableTodosAlunosPrincipal.getValueAt(linha, 2).toString();
                int pos = nome.indexOf(" ");
                int upos = nome.lastIndexOf(" ", nome.length() - 1);
                pos = (pos > 0) ? pos : nome.length();
                upos = (upos > 0) ? upos : nome.length();
                String primeiroNome = nome.substring(0, pos);
                String ultimoNome = nome.substring(upos, nome.length());
                String numero = jTableTodosAlunosPrincipal.getValueAt(linha, 1).toString();
                String score = jTableTodosAlunosPrincipal.getValueAt(linha, 3).toString();
                // Atualizar cabecalho
                jLabelAlunoNumeroInf.setText(numero);
                jLabelAlunoNomeInf.setText(primeiroNome + ultimoNome);
                jLabelAlunoScoreInf.setText(score);
                // Atualizar foto
                BufferedImage img = IOImagem.getImageByNumero(liga, numero);
                if (img != null) {
                    ImageIcon foto = new javax.swing.ImageIcon(img);
                    jLabelAlunoFotoInf.setIcon(foto);
                }

                lerAtividadesBD(numero);
                iniciaLabelTotalAtividade(numero);
                jDialogVerAluno.repaint();

            }

            jDialogVerAluno.setVisible(true);
        }
    }//GEN-LAST:event_jTableTodosAlunosPrincipalMouseClicked

    private int escolheIndexJComboBox(javax.swing.JComboBox box, String item) {
        int index = 0;
        ComboBoxModel modelo = box.getModel();
        for (int i = 0; i < modelo.getSize(); i++) {
            if (item.equals(modelo.getElementAt(i).toString())) {
                return i;
            }
        }
        return index;
    }

    private void jButtonEditarAlunoInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarAlunoInfActionPerformed
        String numero = jLabelAlunoNumeroInf.getText();
        String nome = jLabelAlunoNomeInf.getText();
        Aluno aluno = UtilBDConsulta.verDadosAluno(liga, numero);
        jTextFieldAlunoNumero.setText(numero);
        jTextFieldAlunoNome.setText(aluno.getNome());
        jTextFieldAlunoLocalidade.setText(aluno.getLocalidade());
//        jTextFieldUnidadeCurricular.setText(aluno.getUnidadeCurricular());
        jComboBoxCurso.setSelectedIndex(escolheIndexJComboBox(jComboBoxCurso, aluno.getCurso()));
        String curso = jComboBoxCurso.getSelectedItem().toString();
        carregaComboUnidades(curso);
        jComboBoxUnidadeCurricular.setSelectedIndex(escolheIndexJComboBox(jComboBoxUnidadeCurricular, aluno.getUnidadeCurricular()));
        Date date = java.sql.Date.valueOf(aluno.getDataNascimento());
        jDateChooser1.setDate(date);
        if (aluno.getSexo() == 1) {
            jRadioButtonMasculino.setSelected(true);
        } else {
            jRadioButtonFeminino.setSelected(true);
        }
        BufferedImage bi = aluno.getFoto();
        if (bi != null) {
            ImageIcon foto = new javax.swing.ImageIcon(bi);
            jLabelAlunoFoto.setIcon(foto);
        }
        novo = 0;
        jTextFieldAnoletivo.setText(""+anoletivo);
        jDialogAlunos.setVisible(true);
    }//GEN-LAST:event_jButtonEditarAlunoInfActionPerformed

    private void jLabelAlunoFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAlunoFotoMouseClicked
        String foto = "anonimo1.jpg";
        String numero = jTextFieldAlunoNumero.getText();
        JFileChooser chooser = new JFileChooser();
//        chooser.setCurrentDirectory(new File("./src/Fotos"));
        chooser.setCurrentDirectory(new File(DadosPeduca.workDirDocuments));
        int returnVal = chooser.showOpenDialog(null);
//        fileFoto = null;
        fileFoto = new File("./src/Fotos/anonimo1.jpg");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileFoto = chooser.getSelectedFile();
//            foto = fileFoto.getName();
            IOImagem.imageWrite(liga, fileFoto, numero);
            jLabelAlunoFoto.setIcon(new javax.swing.ImageIcon(fileFoto.getPath()));
        } else {
            jLabelAlunoFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/" + foto)));
        }
        this.repaint();
    }//GEN-LAST:event_jLabelAlunoFotoMouseClicked

    private void jButtonAlunoGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlunoGravarActionPerformed
        Icon icon = jLabelAlunoFoto.getIcon();
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        ImageIcon foto = new javax.swing.ImageIcon(bi);
        String numero = jTextFieldAlunoNumero.getText();
        String nome = jTextFieldAlunoNome.getText();
        String localidade = jTextFieldAlunoLocalidade.getText();
        String curso = jComboBoxCurso.getSelectedItem().toString();
        String unidadeCurricular = jComboBoxUnidadeCurricular.getSelectedItem().toString();
        ChooserData data = new ChooserData(jDateChooser1);
        LocalDate dataNascimento = LocalDate.of(data.getAno(), data.getMes(), data.getDia());
        byte sexo = (byte) (jRadioButtonMasculino.isSelected() ? 1 : 0);
        String email = jTextFieldAlunoEmail.getText();
        int ano;
        if ("".equals(jTextFieldAnoletivo.getText().trim())) ano = anoletivo;
        else ano = Integer.parseInt(jTextFieldAnoletivo.getText().trim());
        if (novo == 1) {
            String login = jTextFieldAlunoLogin.getText();
            char[] temp_pwd = jPasswordFieldAluno.getPassword();
            String pwd = ValidaLogin.codifica(String.copyValueOf(temp_pwd));
            int perfil = 0;  // Atenção verificar
            Aluno aluno = new Aluno(numero, nome, curso, unidadeCurricular, dataNascimento,
                    localidade, sexo, email, login, pwd, perfil,anoletivo);
            UtilBDConsulta.gravarDadosAlunoNovo(liga, aluno);
//            java.awt.event.MouseEvent evtx = null;
//            jLabelAlunoFotoMouseClicked(evtx); // Para atualizar FOTO
            novo = 0;
        } else {
            Aluno aluno = new Aluno(numero, nome, curso, unidadeCurricular, dataNascimento, localidade, sexo, bi, ano);
            UtilBDConsulta.gravarDadosAlunoAlterar(liga, aluno);
        }

        jDialogAlunos.setVisible(false);
        lerAlunosBD();
    }//GEN-LAST:event_jButtonAlunoGravarActionPerformed

    private void limparDadosAluno() {
        jTextFieldAlunoNumero.setText("");
        jTextFieldAlunoNome.setText("");
        jTextFieldAlunoLocalidade.setText("");
        jComboBoxUnidadeCurricular.setSelectedIndex(0);
        jComboBoxCurso.setSelectedIndex(0);
        byte sexo = 1;
        // Iniciar jDateChooser
        LocalDate dataNascimento = LocalDate.of(1999, 1, 1);
        Date date = java.sql.Date.valueOf(dataNascimento);
        jDateChooser1.setDate(date);
        // Fim iniciar jDateChooser
        jTextFieldAlunoEmail.setText("");
        jTextFieldAlunoLogin.setText("");
        jPasswordFieldAluno.setText("");
        // Iniciar com Foto anonimo1.jpg
        jLabelAlunoFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/anonimo1.jpg")));
        Icon icon = jLabelAlunoFoto.getIcon();
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        ImageIcon foto = new javax.swing.ImageIcon(bi);
    }

    private void jButtonNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewStudentActionPerformed
        limparDadosAluno();
        novo = 1;
        carregaComboCurso();
        jDialogAlunos.setVisible(true);
    }//GEN-LAST:event_jButtonNewStudentActionPerformed

    private void jComboBoxCursoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxCursoPopupMenuWillBecomeInvisible
        String curso = jComboBoxCurso.getSelectedItem().toString();
        carregaComboUnidades(curso);
    }//GEN-LAST:event_jComboBoxCursoPopupMenuWillBecomeInvisible

    private void iniciaAtividades() {
        ResultSetTableModel modelo = UtilBDConsulta.verAtividades(liga);
        jTableAtividades.setModel(modelo);
        jTextFieldidAtividade.setText("" + UtilBDConsulta.getMaxIdAtividades(liga));
        // Iniciar jDateChooser
        LocalDate dataNascimento = LocalDate.now();
        Date date = java.sql.Date.valueOf(dataNascimento);
        jDateChooser1.setDate(date);
        // Fim iniciar jDateChooser
        jTextFieldAtividadeDescricao.setText("");
        fileSelectPDF = null;
    }

    private void iniciaAtividadesConf() {
        ResultSetTableModel tmodel = NewUtilBD.verNumberAtividades(liga);
        DefaultListModel modelo = new DefaultListModel();

        for (int linha = 0; linha < tmodel.getRowCount(); linha++) {
            modelo.add(linha, tmodel.getValueAt(linha, 0).toString());
        }
        jListActivities.setModel(modelo);
    }

    private void iniciaQuestionarios() {
        ResultSetTableModel mod2 = UtilBDConsulta.verTodosQuestionarios(liga);
        jTableVerQuestionario.setModel(mod2);
    }

    private void jButtonInserirAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirAtividadeActionPerformed
        int id = Integer.parseInt(jTextFieldidAtividade.getText());
        ChooserData data = new ChooserData(jDateChooserDataAtividade);
        LocalDate dataAtividade = LocalDate.of(data.getAno(), data.getMes(), data.getDia());
        String descricao = jTextFieldAtividadeDescricao.getText();
        File file = fileSelectPDF;
        Atividade atividade = new Atividade(id, dataAtividade, descricao, file);
        UtilBDConsulta.inserirAtividade(liga, atividade);
        iniciaAtividades();
    }//GEN-LAST:event_jButtonInserirAtividadeActionPerformed

    private void inseriAtividaderNumeroResultado(int linha, int resultado) {
        DefaultTableModel modelo = (DefaultTableModel) jTableResultadosPorAtividade.getModel();
        Object[] value = new Object[2];
        value[0] = jTableInsertResults.getValueAt(linha, 1);
        value[1] = resultado;
        modelo.addRow(value);
    }

    private void jButtonInsertResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertResultsActionPerformed
        if (jTableAtividades.getSelectedRow() >= 0) {
            lerAlunosAtividadesBDNOVA(jTableInsertResults);
            jDialogInsertResults.setVisible(true);

            Point location = jDialogInsertResults.getLocation();
            int dx = location.x + jDialogInsertResults.getWidth() + 50;
            int dy = location.y;

            jDialogResultadosPorAtividade.setLocation(dx, dy);
            jDialogResultadosPorAtividade.setVisible(true);

            atividadeCorrente = jTableAtividades.getValueAt(jTableAtividades.getSelectedRow(), 1).toString();
            jLabelDescricaoAtividade.setText(atividadeCorrente);
            idAtividadeCorrente = jTableAtividades.getValueAt(jTableAtividades.getSelectedRow(), 0).toString();
            jLabelIdAtividade.setText("" + idAtividadeCorrente);
            jLabelIdAtividade.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(jDialogInsertResults, "Select Activity");
        }
    }//GEN-LAST:event_jButtonInsertResultsActionPerformed

    private void jTableInsertResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInsertResultsMouseClicked
        if (evt.getClickCount() == 2) { // Introduzir resultado atividade
            int resultado = 0;
            int linha = jTableInsertResults.getSelectedRow();
            if (linha >= 0) {
                String numero = jTableInsertResults.getValueAt(linha, 1).toString();
                String nome = jTableInsertResults.getValueAt(linha, 2).toString();
                String inputValue = JOptionPane.showInputDialog(jDialogInsertResults, "Activity Result: ",
                        numero + " - " + nome, 3);
                if ((inputValue != null) && (!inputValue.equals(""))) {
                    resultado = Integer.parseInt(inputValue);
                    inseriAtividaderNumeroResultado(linha, resultado);
                }
            }
        }
    }//GEN-LAST:event_jTableInsertResultsMouseClicked

    private void jButtonSaveResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveResultsActionPerformed
        for (int linha = 0; linha < jTableResultadosPorAtividade.getRowCount(); linha++) {
            String numero = jTableResultadosPorAtividade.getValueAt(linha, 0).toString();
            int valor = Integer.parseInt(jTableResultadosPorAtividade.getValueAt(linha, 1).toString());
            String id = jLabelIdAtividade.getText();
            UtilBDConsulta.gravaResultadoAtividadeAluno(liga, numero, id, valor);
            UtilBDConsulta.gravaPerfilNumeroAluno(liga, numero, valor);
        }
    }//GEN-LAST:event_jButtonSaveResultsActionPerformed

    private void lerFicheiro(String ficheiro) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(ficheiro));
        DefaultTableModel modelo = (DefaultTableModel) jTableResultadosPorAtividade.getModel();
        modelo.setRowCount(0);
        Object[] value = new Object[2];

        while (fileScanner.hasNext()) {
            String numero = fileScanner.next();
            int valor = fileScanner.nextInt();
            value[0] = numero;
            value[1] = valor;
            modelo.addRow(value);
        }
    }

    private void jButtonReadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadFileActionPerformed
        jFileChooser1.setCurrentDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
        jFileChooser1.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".txt");
                }
            }

            @Override
            public String getDescription() {
                return "TXT Documents (*.txt)";
            }
        });
//        jFileChooser1.showDialog(this, "Open");

        int result = jFileChooser1.showOpenDialog(null);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                File file = jFileChooser1.getSelectedFile();
                String nomeFicheiro = file.getAbsolutePath();
                try {
                    lerFicheiro(nomeFicheiro);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AppGestao.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case JFileChooser.CANCEL_OPTION:

                break;
            case JFileChooser.ERROR_OPTION:

                break;
        }

    }//GEN-LAST:event_jButtonReadFileActionPerformed

    private void jDialogResultadosPorAtividadeWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogResultadosPorAtividadeWindowClosing
        jDialogInsertResults.setVisible(false);
    }//GEN-LAST:event_jDialogResultadosPorAtividadeWindowClosing

    private void jDialogInsertResultsWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogInsertResultsWindowClosing
        jDialogResultadosPorAtividade.setVisible(false);
    }//GEN-LAST:event_jDialogInsertResultsWindowClosing

    private void jButtonUpdateScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateScoreActionPerformed
        atualizarPerfilAlunos();
        lerAlunosBD();
        jTableTodosAlunosPrincipal.repaint();
    }//GEN-LAST:event_jButtonUpdateScoreActionPerformed

    private void jButtonInitializeScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInitializeScoreActionPerformed

        int resposta = JOptionPane.showConfirmDialog(this,
                "Initialize Score for All Students ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.NO_OPTION) {

        } else if (resposta == JOptionPane.YES_OPTION) {
            UtilBDConsulta.iniciarPerfil(liga);
            lerAlunosBD(); // Refresh depois de iniciar perfil
        } else if (resposta == JOptionPane.CLOSED_OPTION) {

        }


    }//GEN-LAST:event_jButtonInitializeScoreActionPerformed

    private void jTabbedPanePrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPanePrincipalMouseClicked
        if (jTabbedPanePrincipal.getSelectedIndex() == 4) { // Registo de Presenças
            Instant instant = Instant.now();
            LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            int hour = ldt.getHour();
            jSpinnerHourPresences.setValue(hour);
            // Iniciar jDateChooser
            LocalDate hoje = LocalDate.now();
            Date date = java.sql.Date.valueOf(hoje);
            jDateChooser1.setDate(date);
            // Fim iniciar jDateChooser

            jTableRegistarPresenca.setModel(jTableTodosAlunosPrincipal.getModel());
            jTableRegistarPresenca.getColumnModel().getColumn(0).setMinWidth(0);
            jTableRegistarPresenca.getColumnModel().getColumn(0).setMaxWidth(0);
            jTableRegistarPresenca.getColumnModel().getColumn(3).setMinWidth(0);
            jTableRegistarPresenca.getColumnModel().getColumn(3).setMaxWidth(0);
//            lerAlunosAtividadesBDNOVA(jTableRegistarPresenca); //Com Foto demora muito tempo
            DefaultTableModel modelo = (DefaultTableModel) jTableAlunoPresenca.getModel();
            if (!(jDialogRegistarPresenca.isVisible())) {
                modelo.setRowCount(0);
            }
//            ResultSetTableModel modelo2 = UtilBDConsulta.verPresencasDataTotalAlunos(liga);
//            jTableDataTotalAlunos.setModel(modelo2);
            jDialogRegistarPresenca.setVisible(true);
        }
        if (jTabbedPanePrincipal.getSelectedIndex() == 8) {  // Champions League
//            int ano = LocalDate.now().getYear();
//            jLabelSeason.setText(""+ano);
            ArrayList<String> verOldDrawResult = UtilBDConsulta.getDrawResult(liga);
            List<String> ls = verOldDrawResult; 
            jComboBoxDrawResult.setModel(new DefaultComboBoxModel<>(ls.toArray(new String[0])));
            
            
            DefaultTableModel modelo = (DefaultTableModel) jTableStudentTODraw.getModel();
            modelo.setRowCount(0);
            for (int i = 0; i < jTableTodosAlunosPrincipal.getRowCount(); i++) {
                String number = jTableTodosAlunosPrincipal.getValueAt(i, 1).toString();
                int score = Integer.parseInt(jTableTodosAlunosPrincipal.getValueAt(i, 3).toString());
                if (score > 0) {
                    Object[] data = {number, score};
                    modelo.addRow(data);
                }
            }
            jLabelNumberToDraw.setText("" + jTableStudentTODraw.getRowCount());
            
        }
    }//GEN-LAST:event_jTabbedPanePrincipalMouseClicked

    private void inserirPresencaNumeroData(int linha, LocalDate data, String numero) {
        DefaultTableModel modelo = (DefaultTableModel) jTableAlunoPresenca.getModel();
        Object[] value = new Object[2];
        value[0] = data;
        value[1] = numero;
        modelo.addRow(value);
    }

    private boolean existeRegistoPresencaAluno(String numero) {
        boolean existe = false;
        for (int i = 0; i < jTableAlunoPresenca.getRowCount(); i++) {
            String num = jTableAlunoPresenca.getValueAt(i, 1).toString();
            if (numero.equals(num)) {
                return true;
            }
        }
        return existe;
    }

    private boolean existeDataRegistoPresenca(LocalDate data) {
        boolean existe = false;
        for (int i = 0; i < jTableDataTotalAlunos.getRowCount(); i++) {
            String d = jTableDataTotalAlunos.getValueAt(i, 1).toString();
            ChooserData dd = new ChooserData(d);
            LocalDate dataTabela = LocalDate.of(dd.getAno(), dd.getMes(), dd.getDia());
            if (data.equals(dataTabela)) {
                return true;
            }
        }
        return existe;
    }


    private void jTableRegistarPresencaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRegistarPresencaMouseClicked

        if (jDateChooserRegistarPresenca.getDate() == null) {
            JOptionPane.showMessageDialog(jDialogRegistarPresenca, "Select Date");
        } else if (evt.getClickCount() == 2) {
            ChooserData data = new ChooserData(jDateChooserRegistarPresenca);
            LocalDate dataPresenca = LocalDate.of(data.getAno(), data.getMes(), data.getDia());

//            if (!(existeDataRegistoPresenca(dataPresenca))) {
            if (jComboBoxCursoPresencas.getSelectedIndex() > 0) {
                int linha = jTableRegistarPresenca.getSelectedRow();
                if (linha >= 0) {
                    String numero = jTableRegistarPresenca.getValueAt(linha, 1).toString();
                    if (!(existeRegistoPresencaAluno(numero))) {
                        inserirPresencaNumeroData(linha, dataPresenca, numero);
                        jLabelTotalPresencas.setText("" + jTableAlunoPresenca.getRowCount());
                    } else {
                        JOptionPane.showMessageDialog(jDialogRegistarPresenca, "Student Already Registered");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(jDialogRegistarPresenca, "Need Select Course");
            }
        }
    }//GEN-LAST:event_jTableRegistarPresencaMouseClicked

    private void jTableAlunoPresencaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlunoPresencaMouseClicked
        if (evt.getClickCount() == 2) {
            DefaultTableModel modelo = (DefaultTableModel) jTableAlunoPresenca.getModel();
            int linha = jTableAlunoPresenca.getSelectedRow();
            if (linha >= 0) {
                modelo.removeRow(linha);
            }
        }
        jLabelTotalPresencas.setText("" + jTableAlunoPresenca.getRowCount());
    }//GEN-LAST:event_jTableAlunoPresencaMouseClicked


    private void jButtonSavePresencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePresencesActionPerformed
//        LocalDateTime agora = LocalDateTime.now();
//        int hora = agora.getHour();
        int hora = Integer.parseInt(jSpinnerHourPresences.getValue().toString());
        String curso = jComboBoxCursoPresencas.getSelectedItem().toString();
        for (int linha = 0; linha < jTableAlunoPresenca.getRowCount(); linha++) {
            String numero = jTableAlunoPresenca.getValueAt(linha, 1).toString();
            ChooserData data = new ChooserData(jDateChooserRegistarPresenca);
            LocalDate dataPresenca = LocalDate.of(data.getAno(), data.getMes(), data.getDia());
            UtilBDConsulta.gravaPresencasDataNumero(liga, dataPresenca, numero, curso, hora);
//            UtilBDConsulta.gravaPerfilNumeroAluno(liga, numero, 1);
        }

        // Inicializar Presenças 
        LocalDate hoje = LocalDate.now();
        Date date = java.sql.Date.valueOf(hoje);
        jDateChooser1.setDate(date);
        // Fim iniciar jDateChooser
        DefaultTableModel modelo = (DefaultTableModel) jTableAlunoPresenca.getModel();
        modelo.setRowCount(0);

        ResultSetTableModel modTotalAlunos = UtilBDConsulta.verPresencasDataTotalAlunos(liga);
        jTableDataTotalAlunos.setModel(modTotalAlunos);

        jTableDataTotalAlunos.getColumnModel().getColumn(0).setMaxWidth(40);
        jTableDataTotalAlunos.getColumnModel().getColumn(1).setMaxWidth(80);
        jTableDataTotalAlunos.getColumnModel().getColumn(2).setMaxWidth(40);
        jTableDataTotalAlunos.getColumnModel().getColumn(4).setMaxWidth(40);
        jTableDataTotalAlunos.invalidate();

        jLabelTotalPresencas.setText("" + jTableAlunoPresenca.getRowCount());
        JOptionPane.showMessageDialog(jDialogRegistarPresenca, "Presences Saved");
    }//GEN-LAST:event_jButtonSavePresencesActionPerformed

    private void jButtonSelectPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectPDFActionPerformed
        jFileChooserSelectPDF.setCurrentDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
        // Definir local para PDF Ativity
//        jFileChooserSelectPDF.setCurrentDirectory(new File(System.getProperty("user.home")));
        jFileChooserSelectPDF.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooserSelectPDF.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        jFileChooserSelectPDF.setAcceptAllFileFilterUsed(true);

        int result = jFileChooserSelectPDF.showOpenDialog(null);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                fileSelectPDF = jFileChooserSelectPDF.getSelectedFile();
                String nomeFicheiro = fileSelectPDF.getAbsolutePath();
                String soNomeFile = fileSelectPDF.getName();
                jTextFieldSelectPDF.setText(soNomeFile);
                break;
            case JFileChooser.CANCEL_OPTION:

                break;
            case JFileChooser.ERROR_OPTION:

                break;
        }

    }//GEN-LAST:event_jButtonSelectPDFActionPerformed

    private void jTableAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMouseClicked
        if (evt.getClickCount() == 2) {
            int linha = jTableAtividades.getSelectedRow();
            if (linha >= 0) {
                int id = Integer.parseInt(jTableAtividades.getValueAt(linha, 0).toString());
                String des = jTableAtividades.getValueAt(linha, 1).toString();
                int resposta = JOptionPane.showConfirmDialog(this,
                        "Open PDF Ativity ? " + des, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resposta == JOptionPane.NO_OPTION) {

                } else if (resposta == JOptionPane.YES_OPTION) {

                    File file = UtilBDConsulta.getFileAtividadeByID(liga, id);
                    if (file != null) {
                        if (Desktop.isDesktopSupported()) {
                            try {
                                File myFile = new File(file.getAbsolutePath());
                                Desktop.getDesktop().open(myFile);
                            } catch (IOException ex) {
                                // no application registered for PDFs
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "There is no associated Activity", "Information", 2);
                    }

                } else if (resposta == JOptionPane.CLOSED_OPTION) {

                }
            }
        }
    }//GEN-LAST:event_jTableAtividadesMouseClicked

    private void jButtonAlterarPasswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarPasswdActionPerformed
        String numero = jTextFieldAlunoNumero.getText();
        String login = jTextFieldAlunoLogin.getText();
        char[] temp_pwd = jPasswordFieldAluno.getPassword();
        String pwd = ValidaLogin.codifica(String.copyValueOf(temp_pwd));
        UtilBDConsulta.alunoNumeroChangePassword(liga, numero, pwd);
    }//GEN-LAST:event_jButtonAlterarPasswdActionPerformed

    private void jButtonAlunoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlunoEliminarActionPerformed
        String numero = jTextFieldAlunoNumero.getText();
        int resposta = JOptionPane.showConfirmDialog(this,
                "Tem a certeza que deseja Eliminar o aluno: " + numero,
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.NO_OPTION) {

        } else if (resposta == JOptionPane.YES_OPTION) {
            // Não esta feito UtilBDConsulta. deleteAluno()
            UtilBDConsulta.deleteAluno(con, numero);
        } else if (resposta == JOptionPane.CLOSED_OPTION) {

        }

    }//GEN-LAST:event_jButtonAlunoEliminarActionPerformed

    private void jButtonSaveActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActivityActionPerformed
        boolean erro = true;
        String numberAct = jTextFieldActNumber.getText().trim();

        String dataStr = "Data INC!";
        DateFormat df = new SimpleDateFormat("dd-MM-yyy");
        Date data = jDateChooserDateActivity.getDate();

        String textActivity = jTextAreaTextActivity.getText();

        String numberInputTest = jTextFieldNumberInputTest.getText();
        int intNumberInputTest = 0;

        String nTest = jTextFieldnTest.getText();
        int intnTest = 0;

        ArrayList<String> listOutput = readOutputTable(jTableInsertOutput);
        ArrayList<String> listKeyCode = readCodeTable(jTableKeyCodeTest);

        while (erro) {
            if ((numberAct == null) || (numberAct.equals(""))) {
                JOptionPane.showMessageDialog(jPanelConfActivity, "Missing Activity Number!");
                erro = true;
                jTextFieldActNumber.requestFocusInWindow();
                break;
            } else {
                erro = false;
            }
            if (data != null) {
                dataStr = df.format(data);
                erro = false;
            } else {
                JOptionPane.showMessageDialog(jPanelConfActivity, "Missing Date!");
                erro = true;
                jDateChooserDateActivity.requestFocusInWindow();
                break;
            }
            if ((textActivity == null) || (textActivity.equals(""))) {
                JOptionPane.showMessageDialog(jPanelConfActivity, "Missing Wording Activity!");
                erro = true;
                jTextAreaTextActivity.requestFocusInWindow();
                break;
            } else {
                erro = false;
            }

            try {
                intNumberInputTest = Integer.parseInt(numberInputTest.trim());
                erro = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(jPanelConfActivity, "Missing Number Input Test!");
                erro = true;
                jTextFieldNumberInputTest.requestFocusInWindow();
                break;
            }
            try {
                intnTest = Integer.parseInt(nTest.trim());
                erro = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(jPanelConfActivity, "Missing Number Code Test!");
                erro = true;
                jTextFieldnTest.requestFocusInWindow();
                break;
            }

        }

        if (!erro) {
            // Criar ficheiro conf Opcional

            // Gravar na base de dados
            int idAtv = NewUtilBD.getIDAtividade(liga, numberAct);
            AtividadeConf atividade = new AtividadeConf(idAtv, numberAct, UtilConvertData.convertToLocalDate(data), textActivity,
                    intNumberInputTest, listOutput, intnTest, listKeyCode);
            if (idAtv > 0) {
                int resposta = JOptionPane.showConfirmDialog(this,
                        "Modify Activity ?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resposta == JOptionPane.NO_OPTION) {

                } else if (resposta == JOptionPane.YES_OPTION) {
                    NewUtilBD.updateAtividade(liga, atividade);
                } else if (resposta == JOptionPane.CLOSED_OPTION) {

                }
            } else {
                NewUtilBD.inserirAtividade(liga, atividade);
                iniciaAtividadesConf();
            }
            limpaAtividade();
        }

    }//GEN-LAST:event_jButtonSaveActivityActionPerformed

    private ArrayList<String> separaPorMarca(String texto, String marca) {
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

    private AtividadeConf carregaAtividade(ResultSetTableModel modelo) {
        String numberAct = modelo.getValueAt(0, 1).toString();
        String datas = modelo.getValueAt(0, 2).toString();
        LocalDate data = UtilConvertData.convertStringToLocalDate(datas);
        String textActivity = modelo.getValueAt(0, 3).toString();
        int nInput = Integer.parseInt(modelo.getValueAt(0, 4).toString());
        ArrayList<String> output = new ArrayList();
        output = separaPorMarca(modelo.getValueAt(0, 5).toString(), "<#>");
        int nTest = Integer.parseInt(modelo.getValueAt(0, 6).toString());
        ArrayList<String> codeKey = new ArrayList();
        codeKey = separaPorMarca(modelo.getValueAt(0, 7).toString(), "<#>");

        AtividadeConf atividade = new AtividadeConf(numberAct, data,
                textActivity, nInput, output, nTest, codeKey);

        return atividade;
    }

    private void mostraAtividade(String numero) {
        ResultSetTableModel modelo = NewUtilBD.verAtividadesNumber(liga, numero);
        AtividadeConf atividade = carregaAtividade(modelo);

        jTextFieldActNumber.setText(numero);
        Date date = java.sql.Date.valueOf(atividade.getDataAtividade());
        jDateChooserDateActivity.setDate(date);

        jTextAreaTextActivity.setText(atividade.getEnunciado());
        jTextFieldNumberInputTest.setText("" + atividade.getnInput());

        DefaultTableModel modtabela = (DefaultTableModel) jTableInsertOutput.getModel();
        modtabela.setRowCount(0);
        ArrayList<String> lista = atividade.getOutput();
        String in = "";
        String out = "";
        for (int linha = 0; linha < lista.size(); linha++) {
            int fim = lista.get(linha).indexOf("<i>", 0);
            if (fim >= 0) {
                in = lista.get(linha).substring(0, fim);
                out = lista.get(linha).substring(fim + 3);
            }
            Object[] datarow = {linha, in, out};
            modtabela.addRow(datarow);
        }

        jTextFieldnTest.setText("" + atividade.getnTest());
        DefaultTableModel modtabela2 = (DefaultTableModel) jTableKeyCodeTest.getModel();
        modtabela2.setRowCount(0);
        String comment = "";
        String key = "";
        ArrayList<String> listaKeys = atividade.getCommentKey();
        for (int linha = 0; linha < listaKeys.size(); linha++) {
            int fim = listaKeys.get(linha).indexOf("<c>", 0);
            if (fim >= 0) {
                comment = listaKeys.get(linha).substring(0, fim);
                key = listaKeys.get(linha).substring(fim + 3);
            }
            Object[] datarow = {linha, comment, key};
            modtabela2.addRow(datarow);
        }
    }

    private void limpaAtividade() {
        jTextFieldActNumber.setText("");
        Date date = java.sql.Date.valueOf(LocalDate.now());
        jDateChooserDateActivity.setDate(date);
        jTextAreaTextActivity.setText("");
        jTextFieldNumberInputTest.setText("0");
        DefaultTableModel modtabela1 = (DefaultTableModel) jTableInsertOutput.getModel();
        modtabela1.setRowCount(0);
        jTextFieldnTest.setText("0");
        DefaultTableModel modtabela2 = (DefaultTableModel) jTableKeyCodeTest.getModel();
        modtabela2.setRowCount(0);
    }

    private void jListActivitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListActivitiesMouseClicked
        limpaAtividade();
        String numberAtv = jListActivities.getSelectedValue();
        mostraAtividade(numberAtv);
    }//GEN-LAST:event_jListActivitiesMouseClicked

    private void jButtonOutputSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutputSettingsActionPerformed
        TableColumnModel tcm = jTableInsertOutput.getColumnModel();
        tcm.getColumn(0).setPreferredWidth("Test Number".length() + 1);

        int nLinhas = Integer.parseInt(jTextFieldNumberInputTest.getText().trim());
        DefaultTableModel modelo = (DefaultTableModel) jTableInsertOutput.getModel();
        int linhasTabela = modelo.getRowCount();
        int total = Math.max(nLinhas, linhasTabela) - Math.min(nLinhas, linhasTabela);
        if (total > 0) {
            for (int linha = linhasTabela; linha < nLinhas; linha++) {
                Object[] dataRow = {linha, ""};
                modelo.addRow(dataRow);
            }
        }

        jDialogInsertOutput.setVisible(true);
    }//GEN-LAST:event_jButtonOutputSettingsActionPerformed

    private void jButtonCodeSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCodeSettingsActionPerformed
        TableColumnModel tcm = jTableKeyCodeTest.getColumnModel();
        tcm.getColumn(0).setPreferredWidth("Test Number".length() + 1);

        int nLinhas = Integer.parseInt(jTextFieldnTest.getText().trim());
        DefaultTableModel modelo = (DefaultTableModel) jTableKeyCodeTest.getModel();
        int linhasTabela = modelo.getRowCount();
        int total = Math.max(nLinhas, linhasTabela) - Math.min(nLinhas, linhasTabela);
        if (total > 0) {
            for (int linha = linhasTabela; linha < nLinhas; linha++) {
                Object[] dataRow = {linha, "", ""};
                modelo.addRow(dataRow);
            }
        }

        jDialogTestCodeKey.setVisible(true);
    }//GEN-LAST:event_jButtonCodeSettingsActionPerformed

    private void jButtonAddOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOutputActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableInsertOutput.getModel();
        Object[] dataRow = {modelo.getRowCount(), "", ""};
        modelo.addRow(dataRow);
        //Refresh test number
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i, i, 0);
        }
    }//GEN-LAST:event_jButtonAddOutputActionPerformed

    private void jButtonOutputDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutputDeleteRowActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableInsertOutput.getModel();
        int linha = jTableInsertOutput.getSelectedRow();
        if (linha >= 0) {
            modelo.removeRow(linha);
        } else {
            JOptionPane.showMessageDialog(jDialogInsertOutput, "No ROW Select!");
        }
        //Refresh test number
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i, i, 0);
        }
    }//GEN-LAST:event_jButtonOutputDeleteRowActionPerformed

    private void jButtonAddCodeKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCodeKeyActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableKeyCodeTest.getModel();
        Object[] dataRow = {modelo.getRowCount(), "", ""};
        modelo.addRow(dataRow);
        //Refresh test number
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i, i, 0);
        }
    }//GEN-LAST:event_jButtonAddCodeKeyActionPerformed

    private void jButtonAtvDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtvDeleteRowActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableKeyCodeTest.getModel();
        int linha = jTableKeyCodeTest.getSelectedRow();
        if (linha >= 0) {
            modelo.removeRow(linha);
        } else {
            JOptionPane.showMessageDialog(jDialogTestCodeKey, "No ROW Select!");
        }
        //Refresh test number
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(i, i, 0);
        }
    }//GEN-LAST:event_jButtonAtvDeleteRowActionPerformed

    private ArrayList<String> readOutputTable(JTable table) {
        int totalLinhas = table.getRowCount();

        ArrayList<String> tOutput = new ArrayList<>();
        for (int linha = 0; linha < totalLinhas; linha++) {
            tOutput.add(table.getValueAt(linha, 1).toString() + "<i>"
                    + table.getValueAt(linha, 2).toString() + "<#>");
        }
        return tOutput;
    }

    private ArrayList<String> readCodeTable(JTable table) {
        int totalLinhas = table.getRowCount();

        ArrayList<String> tOutput = new ArrayList<>();
        for (int linha = 0; linha < totalLinhas; linha++) {
            tOutput.add(table.getValueAt(linha, 1).toString() + "<c>"
                    + table.getValueAt(linha, 2).toString() + "<#>");
        }
        return tOutput;
    }

    private void jButtonCodeKeyCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCodeKeyCloseActionPerformed
        int totalLinhas = jTableKeyCodeTest.getRowCount();
        jTextFieldnTest.setText("" + totalLinhas);

        jDialogTestCodeKey.setVisible(false);
    }//GEN-LAST:event_jButtonCodeKeyCloseActionPerformed

    private void jButtonOutputCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutputCloseActionPerformed
        int totalLinhas = jTableInsertOutput.getRowCount();
        jTextFieldNumberInputTest.setText("" + totalLinhas);

        jDialogInsertOutput.setVisible(false);
    }//GEN-LAST:event_jButtonOutputCloseActionPerformed

    private void jButtonAtvNewClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtvNewClearActionPerformed
        limpaAtividade();
        jTextFieldActNumber.requestFocusInWindow();
    }//GEN-LAST:event_jButtonAtvNewClearActionPerformed

    private void jTableDataTotalAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataTotalAlunosMouseClicked
        // Mostra tabela com presenças do dia
        int linha = jTableDataTotalAlunos.getSelectedRow();
        if (evt.getClickCount() == 2) {
            if (linha >= 0) {
                String data = jTableDataTotalAlunos.getValueAt(linha, 1).toString();
                int hora = Integer.parseInt(jTableDataTotalAlunos.getValueAt(linha, 2).toString());
                String curso = jTableDataTotalAlunos.getValueAt(linha, 3).toString();
                jTablePresencasPorData.setModel(UtilBDConsulta.verPresencasPorDataHoraCurso(liga, data, hora, curso));
                jDialogPresencasPorData.setLocationRelativeTo(jPanelPresences);
                jDialogPresencasPorData.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTableDataTotalAlunosMouseClicked

    private void jButtonStudentCharactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStudentCharactActionPerformed
        jTableStudentCharact.setModel(UtilBDConsulta.verStudentCharacterization(liga));
        jDialogResultsStudentCharact.setLocationRelativeTo(this);
        jDialogResultsStudentCharact.setVisible(true);
    }//GEN-LAST:event_jButtonStudentCharactActionPerformed

    private void jButtonAddNewActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewActivityActionPerformed
        this.add(new BasicActivities(liga));
    }//GEN-LAST:event_jButtonAddNewActivityActionPerformed

    private void jComboBoxCursosInicialPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxCursosInicialPopupMenuWillBecomeInvisible
        // Carregar só os alunos do curso selecionado
        cursoAtivo = jComboBoxCursosInicial.getSelectedItem().toString();
        for (int i = 0; i < jComboBoxCursoPresencas.getItemCount(); i++) {  // Para seleccionar curso nas presenças
            if (cursoAtivo.equals(jComboBoxCursoPresencas.getItemAt(i))) {
                jComboBoxCursoPresencas.setSelectedIndex(i);
                break;
            }
        }
        lerAlunosBD();
    }//GEN-LAST:event_jComboBoxCursosInicialPopupMenuWillBecomeInvisible

    private void jButtonMessageToSudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMessageToSudentActionPerformed
        jLabelNumeroAlunoMsg.setText(jLabelAlunoNumeroInf.getText());
        jLabelNomeAlunoMsg.setText(jLabelAlunoNomeInf.getText());
        jDialogMessageToStudent.setLocationRelativeTo(jDialogVerAluno);
        jDialogMessageToStudent.setVisible(true);
    }//GEN-LAST:event_jButtonMessageToSudentActionPerformed

    private void jButtonSendMsgAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendMsgAlunoActionPerformed
        String texto = jTextAreaMsgToAluno.getText();
        String numero = jLabelNumeroAlunoMsg.getText().trim();
        UtilBDConsulta.gravaSugestaoToAluno(liga, numero, texto);
        jDialogMessageToStudent.setVisible(false);
        jTextAreaMsgToAluno.setText("");
    }//GEN-LAST:event_jButtonSendMsgAlunoActionPerformed

    private void jButtonApplyBlockTabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApplyBlockTabsActionPerformed
        lerDisplayTabsBlocksToBD(con);
    }//GEN-LAST:event_jButtonApplyBlockTabsActionPerformed

    private void jButtonShuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShuffleActionPerformed
        String programSolution = jTextAreaProgramSolution.getText();
        String[] texto = programSolution.split("\n");
        List<String> list = new ArrayList();
        for (int i = 0; i < texto.length; i++) {
            list.add(texto[i]);
        }
        Collections.shuffle(list);
        jTextAreaShuffledProgram.setText("");
        for (String s : list) {
            jTextAreaShuffledProgram.append(s + "\n");
        }
    }//GEN-LAST:event_jButtonShuffleActionPerformed

    private void jButtonSaveParsonProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveParsonProblemActionPerformed
        String descricao = jTextFieldParsonDescricao.getText();
        String enunciado = jTextAreaShuffledProgram.getText();
        String solucao = jTextAreaProgramSolution.getText();
        if (!descricao.equals("")) {
            UtilBDConsulta.gravaParsonProblems(liga, descricao, enunciado, solucao);
            JOptionPane.showMessageDialog(jPanelParsonProblems, "Parson Problem Saved");
            jTextAreaProgramSolution.setText("");
            jTextAreaShuffledProgram.setText("");
        } else {
            JOptionPane.showMessageDialog(jPanelParsonProblems, "You must insert Description name!");
        }
    }//GEN-LAST:event_jButtonSaveParsonProblemActionPerformed

    private void jButtonNewParsonProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewParsonProblemActionPerformed
        jDialogNewParsonProblems.setLocationRelativeTo(this);
        jDialogNewParsonProblems.setVisible(true);
    }//GEN-LAST:event_jButtonNewParsonProblemActionPerformed

    private void jTableViewParsonProblemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableViewParsonProblemsMouseClicked
        int clique = evt.getClickCount();
        if (clique == 2) {
            int linha = jTableViewParsonProblems.getSelectedRow();
            if (linha >= 0) {
                String descricao = jTableViewParsonProblems.getValueAt(linha, 0).toString();
                String solucao = jTableViewParsonProblems.getValueAt(linha, 2).toString();
                jTextFieldParsonDescricao.setText(descricao);
                jTextAreaProgramSolution.setText(solucao);
                jDialogNewParsonProblems.setLocationRelativeTo(this);
                jDialogNewParsonProblems.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTableViewParsonProblemsMouseClicked

    private void jButtonRefreshTableActiveStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshTableActiveStudentsActionPerformed
        refreshActiveStudentsTable();
    }//GEN-LAST:event_jButtonRefreshTableActiveStudentsActionPerformed

    private void jButtonRefreshStudentScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshStudentScoreActionPerformed
        String numero = jLabelAlunoNumeroInf.getText();
        iniciaLabelTotalAtividade(numero);
        int total = Integer.parseInt(jLabelAlunoScoreInf.getText());
        UtilBDConsulta.gravaPerfilTotalNumeroAluno(liga, numero, total);
        JOptionPane.showMessageDialog(jDialogVerAluno, "Score Updated");
    }//GEN-LAST:event_jButtonRefreshStudentScoreActionPerformed

    private void jButtonReadFilePresencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadFilePresencesActionPerformed
        if (jComboBoxCursoPresencas.getSelectedIndex() > 0) {
            String pathFile = "";
            JFileChooser jFileChooserPresences = new JFileChooser();
            jFileChooser1.setCurrentDirectory(new File(DadosPeduca.workDirDocuments));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files (*.txt)", "*.txt", "txt");
            jFileChooserPresences.setFileFilter(filter);
            jFileChooserPresences.showDialog(this, "Abrir");
            if (jFileChooserPresences.getApproveButtonText().equals("Abrir")) {
                File file = jFileChooserPresences.getSelectedFile();
                if (file != null) {
                    pathFile = file.getAbsolutePath();
                }
            }

            try {
                String numero = "";
                String fileText[] = new Scanner(new File(pathFile)).useDelimiter("\\Z").next().split("\\r?\\n");
                for (int i = 1; i < fileText.length; i++) {
                    StringTokenizer tokenizer = new StringTokenizer(fileText[i]);
                    int j = 0;
                    while (tokenizer.hasMoreTokens()) {
                        if (j == 2) {
                            numero = tokenizer.nextToken();
                        } else if (j == 4) {
                            if (tokenizer.nextToken().equals("Estive")) {
                                ChooserData data = new ChooserData(jDateChooserRegistarPresenca);
                                LocalDate dataPresenca = LocalDate.of(data.getAno(), data.getMes(), data.getDia());
                                inserirPresencaNumeroData(i, dataPresenca, numero);

                            }
                        } else {
                            tokenizer.nextToken();
                        }
                        j++;

                    }
                }
                jLabelTotalPresencas.setText("" + jTableAlunoPresenca.getRowCount());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(jDialogRegistarPresenca, "Need Select Course");
        }
    }//GEN-LAST:event_jButtonReadFilePresencesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableAlunoPresenca.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonTopStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTopStudentsActionPerformed
        boolean ascending = false;
        int columnIndexToSort = 3;

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTableTodosAlunosPrincipal.getModel());
        jTableTodosAlunosPrincipal.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        if (ascending) {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        } else {
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
        }

        sorter.setSortKeys(sortKeys);
        sorter.sort();

    }//GEN-LAST:event_jButtonTopStudentsActionPerformed

    private void jButtonRefreshExpertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshExpertActionPerformed
        iniciaExpert();
    }//GEN-LAST:event_jButtonRefreshExpertActionPerformed


    private void jButtonDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDrawActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableDraw.getModel();
        modelo.setRowCount(0);
        int n = 0, nJogos = 0;
        int totalActivities = jListActivities.getModel().getSize();
        int totalAlunos = jTableStudentTODraw.getRowCount();
        
        if (totalAlunos >= 2) {
            if (jRadioButtonScoreDraw.isSelected()) {
                List<DadosGame> list = new ArrayList();
                for (int row = 0; row < jTableStudentTODraw.getRowCount(); row++) {
                    String number = jTableStudentTODraw.getValueAt(row, 0).toString();
                    int score = Integer.parseInt(jTableStudentTODraw.getValueAt(row, 1).toString());
                    DadosGame game = new DadosGame(number, score);
                    list.add(game);
                    Collections.shuffle(list);
                    Collections.sort(list, new SortByScore());
                }
                int tamanho = list.size();
                nJogos = tamanho / 2;
                boolean par = ((nJogos * 2) == tamanho);
                int i = 0;
                while (i < tamanho-1) {
                    n++;
                    DadosGame dg1 = list.get(i);
                    i++;
                    DadosGame dg2 = list.get(i);
                    i++;
                    Random r = new Random();  // Para gerar actividade aleatória
                    int low = 0;                // Podia se tb com shuffle list ...
                    int high = totalActivities;
                    int activityResult = r.nextInt(high - low) + low;
                    String numberAct = jListActivities.getModel().getElementAt(activityResult);
                    Object[] dados = {"Game" + n, dg1.getNumber(), 0, dg2.getNumber(), 0, numberAct};
                    modelo.addRow(dados);
                }
                if (!par) {
                    n++;
                    DadosGame dg1 = list.get(i);
                    Object[] dados = {"Game" + n, dg1.getNumber(), 0, "FREE", 0, ""};
                    modelo.addRow(dados);
                }

            } else {
                List<DadosGame> list = new ArrayList();
                for (int row = 0; row < jTableStudentTODraw.getRowCount(); row++) {
                    String number = jTableStudentTODraw.getValueAt(row, 0).toString();
                    int score = Integer.parseInt(jTableStudentTODraw.getValueAt(row, 1).toString());
                    DadosGame game = new DadosGame(number, score);
                    list.add(game);
                    Collections.shuffle(list);
                }
                int tamanho = list.size();
                nJogos = tamanho / 2;
                boolean par = ((nJogos * 2) == tamanho);
                int i = 0;
                while (i < tamanho-1) {
                    n++;
                    DadosGame dg1 = list.get(i);
                    i++;
                    DadosGame dg2 = list.get(i);
                    i++;
                    Random r = new Random();
                    int low = 0;
                    int high = totalActivities;
                    int activityResult = r.nextInt(high - low) + low;
                    String numberAct = jListActivities.getModel().getElementAt(activityResult);
                    Object[] dados = {"Game" + n, dg1.getNumber(), 0, dg2.getNumber(), 0, numberAct};
                    modelo.addRow(dados);
                }
                if (!par) {
                    DadosGame dg1 = list.get(i);
                    Object[] dados = {"Game" + n, dg1.getNumber(), "", "FREE to Next Round", "", ""};
                    modelo.addRow(dados);
                }
            }
        } else {
            JOptionPane.showMessageDialog(jPanelGamification, "NO students for the draw!");
        }
    }//GEN-LAST:event_jButtonDrawActionPerformed

    private void jButtonStepDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepDrawActionPerformed
        JOptionPane.showMessageDialog(jPanelGamification, "Not Implemented yet!");
    }//GEN-LAST:event_jButtonStepDrawActionPerformed

    
    private void jButtonSaveRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveRoundActionPerformed
        int linhas = jTableDraw.getRowCount();
        String season = jLabelSeason.getText();
        int round = Integer.parseInt(jTextFieldRound.getText().trim());
        
        if (linhas>0){
            for (int i=0;i<linhas;i++){
                String equipa1 = jTableDraw.getValueAt(i, 1).toString();
                int result1 = Integer.parseInt(jTableDraw.getValueAt(i, 2).toString());
                String equipa2 = jTableDraw.getValueAt(i, 3).toString();
                int result2 = Integer.parseInt(jTableDraw.getValueAt(i, 4).toString());
                String activity = jTableDraw.getValueAt(i, 5).toString();
                UtilBDConsulta.gravaLeagueGame(liga, season, round, equipa1, result1, equipa2, result2, activity);
            }
            JOptionPane.showMessageDialog(jPanelGamification, "Round Saved");
        }
    }//GEN-LAST:event_jButtonSaveRoundActionPerformed

    private void jButtonSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeasonActionPerformed
        ArrayList<String> tSeason = UtilBDConsulta.getSeason(liga);
        jComboBoxSeason.removeAllItems();
        jComboBoxSeason.addItem("-- Select Season --");
        for (String s : tSeason){
            jComboBoxSeason.addItem(s);
        }
        jTextFieldNewSeason.setText("");
        
        jDialogSeason.setLocationRelativeTo(jPanelGamification);
        jDialogSeason.setVisible(true);
    }//GEN-LAST:event_jButtonSeasonActionPerformed

    private void jButtonAddSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSeasonActionPerformed
        String newSeason = jTextFieldNewSeason.getText();
        if (!newSeason.equals("")){
            jLabelSeason.setText(newSeason);
        }
        jDialogSeason.setVisible(false);
    }//GEN-LAST:event_jButtonAddSeasonActionPerformed

    private void jComboBoxSeasonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxSeasonPopupMenuWillBecomeInvisible
        if (jComboBoxSeason.getSelectedIndex()!=0){
            jLabelSeason.setText(jComboBoxSeason.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboBoxSeasonPopupMenuWillBecomeInvisible

    private void jButtonInitializeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInitializeActionPerformed
        
        // Ler students
/*        DefaultTableModel modelo = (DefaultTableModel) jTableStudentTODraw.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < jTableTodosAlunosPrincipal.getRowCount(); i++) {
            String number = jTableTodosAlunosPrincipal.getValueAt(i, 1).toString();
            int score = Integer.parseInt(jTableTodosAlunosPrincipal.getValueAt(i, 3).toString());
            if (score > 0) {
                Object[] data = {number, score};
                modelo.addRow(data);
            }
        }
        jLabelNumberToDraw.setText("" + jTableStudentTODraw.getRowCount());
  */      
        LeagueGame lastgame = UtilBDConsulta.getLastRecordLeague(liga);
        int lastround = 0;
        String lastseason = "";
        if (lastgame != null) {
            lastround = lastgame.getRound();
            lastseason = lastgame.getSeason();
            jLabelSeason.setText(lastseason);
            jTextFieldRound.setText("" + (lastround+1));

            ArrayList<String> tWinners = UtilBDConsulta.getWinnersToNextRound(liga, lastseason, lastround);
            DefaultTableModel modelo = (DefaultTableModel) jTableStudentTODraw.getModel();
            if (tWinners.size() > 0) {
                int row = 0;
                while (row < jTableStudentTODraw.getRowCount()) {
                    String number = jTableStudentTODraw.getValueAt(row, 0).toString();
//                int score = Integer.parseInt(jTableStudentTODraw.getValueAt(row, 1).toString().trim());
                    if (tWinners.indexOf(number) >= 0) {
                        row++;
                    } else {
                        modelo.removeRow(row);
                    }
                }
                
            } else {    // Colocar todos os Alunos
                modelo.setRowCount(0);
                for (int i = 0; i < jTableTodosAlunosPrincipal.getRowCount(); i++) {
                    String number = jTableTodosAlunosPrincipal.getValueAt(i, 1).toString();
                    int score = Integer.parseInt(jTableTodosAlunosPrincipal.getValueAt(i, 3).toString());
                    if (score > 0) {
                        Object[] data = {number, score};
                        modelo.addRow(data);
                    }
                }
                
            }
        }
        jLabelNumberToDraw.setText("" + jTableStudentTODraw.getRowCount());
        JOptionPane.showMessageDialog(jPanelGamification, "Winners Initialized");
    }//GEN-LAST:event_jButtonInitializeActionPerformed

    private void jButtonSaveCSVFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCSVFileActionPerformed
        ArrayList<AlunoExpert> dados = new ArrayList();
        int linhas = jTableExpert.getRowCount();
        if (linhas > 0) {
            for (int linha = 0; linha < linhas; linha++) {
                String number = jTableExpert.getValueAt(linha, 0).toString();
                int presences = Integer.parseInt(jTableExpert.getValueAt(linha, 1).toString());
                int sp = Integer.parseInt(jTableExpert.getValueAt(linha, 2).toString());
                int ph = Integer.parseInt(jTableExpert.getValueAt(linha, 3).toString());
                int ic = Integer.parseInt(jTableExpert.getValueAt(linha, 4).toString());
                int pp = Integer.parseInt(jTableExpert.getValueAt(linha, 5).toString());
                int basic = Integer.parseInt(jTableExpert.getValueAt(linha, 6).toString());
                int ifs = Integer.parseInt(jTableExpert.getValueAt(linha, 7).toString());
                int loop = Integer.parseInt(jTableExpert.getValueAt(linha, 8).toString());
                int arrays = Integer.parseInt(jTableExpert.getValueAt(linha, 9).toString());
                int advanced = Integer.parseInt(jTableExpert.getValueAt(linha, 10).toString());
                double expected = Double.parseDouble(jTableExpert.getValueAt(linha, 11).toString());
                AlunoExpert ae = new AlunoExpert(number, presences, sp, ph, ic, pp, basic, ifs, loop, arrays, advanced, expected);
                dados.add(ae);
            }
            UtilFiles.createFileCSV("FicheiroCSV.csv", dados);
            UtilFiles.readFileCSV("FicheiroCSV.csv");
        } else {
            JOptionPane.showMessageDialog(jPanelExpert, "Table Empty...");
        }
    }//GEN-LAST:event_jButtonSaveCSVFileActionPerformed

    private void jComboBoxDrawResultPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxDrawResultPopupMenuWillBecomeInvisible
        // Visualizar um sorteio e resultados já efetuados
        DefaultTableModel modelo = (DefaultTableModel) jTableDraw.getModel();
        modelo.setRowCount(0);

        String existDraw = jComboBoxDrawResult.getSelectedItem().toString();
        int index = jComboBoxDrawResult.getSelectedIndex();
        if (index > 0) {   // Ler BD e apresentar draw
            String[] dados = existDraw.split(";");
            String data = dados[0].trim();
            String season = dados[1].trim();
            int round = Integer.parseInt(dados[2].trim());
            jTextFieldRound.setText("" + round);
            jLabelSeason.setText(season);
            ArrayList<LeagueGame> tExistLeague = UtilBDConsulta.getExistDraw(liga, data, season, round);
            for (LeagueGame lg : tExistLeague) {
                Object[] dadoslg = {"Game" + lg.getIdGame(), lg.getEquipa1(), lg.getResult1(),
                    lg.getEquipa2(), lg.getResult2(), lg.getActivity()};
                modelo.addRow(dadoslg);
            }

        } else {        // Limpar Tabela de sorteio
            jTextFieldRound.setText("1");
            jLabelSeason.setText("Season");
        }


    }//GEN-LAST:event_jComboBoxDrawResultPopupMenuWillBecomeInvisible

    private void jButtonCheckResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckResultsActionPerformed
        // Ler Resultados dos alunos LeagueGame
        if (jRadioButtonAutomaticResults.isSelected()) { // Automatico verifica se Aluno tem a atividade resolvida
            int linhas = jTableDraw.getRowCount();
            String season = jLabelSeason.getText();
            int round = Integer.parseInt(jTextFieldRound.getText().trim());
            if (linhas > 0) {
                for (int i = 0; i < linhas; i++) {
                    String equipa1 = jTableDraw.getValueAt(i, 1).toString();
                    String equipa2 = jTableDraw.getValueAt(i, 3).toString();
                    String activity = jTableDraw.getValueAt(i, 5).toString();
                    int result1 = UtilBDConsulta.getResultDraw(liga, equipa1, activity);
                    int result2 = UtilBDConsulta.getResultDraw(liga, equipa2, activity);
                    jTableDraw.setValueAt(result1, i, 2);
                    jTableDraw.setValueAt(result2, i, 4);
                    String winner = "";
                    if (result1 > result2) {
                        winner = equipa1;
                    } else if (result2 > result1) {
                        winner = equipa2;
                    }
                    if (!winner.isEmpty()) {
                        UtilBDConsulta.gravaWinnersRound(liga, season, round, winner);
                    }

                    //jTableDraw.setDefaultRenderer(Object.class, new CustomRendererColorDraw());
                }
                
            }
        } else {    // Manual verifica resultado inserido na tabela
            int linhas = jTableDraw.getRowCount();
            String season = jLabelSeason.getText();
            int round = Integer.parseInt(jTextFieldRound.getText().trim());
            if (linhas > 0) {
                for (int i = 0; i < linhas; i++) {
                    String equipa1 = jTableDraw.getValueAt(i, 1).toString();
                    String equipa2 = jTableDraw.getValueAt(i, 3).toString();
                    String activity = jTableDraw.getValueAt(i, 5).toString();
                    int result1 = Integer.parseInt(jTableDraw.getValueAt(i, 2).toString().trim());
                    int result2 = Integer.parseInt(jTableDraw.getValueAt(i, 4).toString().trim());
                    String winner = "";
                    if (result1 > result2) {
                        winner = equipa1;
                    } else if (result2 > result1) {
                        winner = equipa2;
                    }
                    if (!winner.isEmpty()) {
                        UtilBDConsulta.gravaWinnersRound(liga, season, round, winner);
                    }

                    //jTableDraw.setDefaultRenderer(Object.class, new CustomRendererColorDraw());
                }
            }
        }
        JOptionPane.showMessageDialog(jPanelGamification, "Updated results");
    }//GEN-LAST:event_jButtonCheckResultsActionPerformed

    private void jButtonDefCurrentYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefCurrentYearActionPerformed
        anoletivo = Integer.parseInt(jTextFieldDefCurrentYear.getText().trim());
    }//GEN-LAST:event_jButtonDefCurrentYearActionPerformed

    private void lerBDTabsBlocksToDisplay(ConnectBD c) {
        ArrayList<Integer> tb = UtilAcesso.getTabsBlock(c);
        ArrayList<JRadioButton> tRadio = new ArrayList<>();
        tRadio.add(jRadioButton1);
        tRadio.add(jRadioButton2);
        tRadio.add(jRadioButton3);
        tRadio.add(jRadioButton4);
        tRadio.add(jRadioButton5);
        tRadio.add(jRadioButton6);
        tRadio.add(jRadioButton7);
        tRadio.add(jRadioButton8);
        for (int i = 0; i < tb.size(); i++) {
            if (tb.get(i) == 0) {
                tRadio.get(i).setSelected(true);
            } else {
                tRadio.get(i).setSelected(false);
            }
        }

    }

    private void lerDisplayTabsBlocksToBD(Connection ligacao) {
        ArrayList<Integer> tb = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tb.add(1);
        }
        ArrayList<JRadioButton> tRadio = new ArrayList<JRadioButton>();
        tRadio.add(jRadioButton1);
        tRadio.add(jRadioButton2);
        tRadio.add(jRadioButton3);
        tRadio.add(jRadioButton4);
        tRadio.add(jRadioButton5);
        tRadio.add(jRadioButton6);
        tRadio.add(jRadioButton7);
        for (int i = 0; i < tRadio.size(); i++) {
            JRadioButton jr = tRadio.get(i);
            if (jr.isSelected()) { // Está Block
                tb.set(i, 0);
            } else {
                tb.set(i, 1);
            }
        }
        UtilAcesso.setTabsBlock(liga, tb);
    }

    private void carregaComboCurso() {
        ArrayList<String> t = UtilBDConsulta.getCursos(liga);
        jComboBoxCursosInicial.removeAllItems();
        jComboBoxCursosInicial.addItem("-- Select Course --");
        jComboBoxCursoPresencas.removeAllItems();
        jComboBoxCursoPresencas.addItem("-- Select Course --");
        jComboBoxCurso.removeAllItems();
        jComboBoxCurso.addItem("-- Select Course --");
        for (String c : t) {
            jComboBoxCurso.addItem(c);
            jComboBoxCursosInicial.addItem(c);
            jComboBoxCursoPresencas.addItem(c);
        }
    }

    private void carregaComboUnidades(String curso) {
        ArrayList<String> t = UtilBDConsulta.getUnidades(liga, curso);
        jComboBoxUnidadeCurricular.removeAllItems();
        jComboBoxUnidadeCurricular.addItem("-- Escolha o Curso --");
        for (String c : t) {
            jComboBoxUnidadeCurricular.addItem(c);
        }
    }

    private int numeroRandom(int min, int max) {
        Random random = new Random();
        int numero = random.nextInt(max + 1 - min) + min;
        return numero;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppGestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppGestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppGestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppGestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppGestao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupManualAutoResults;
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.ButtonGroup buttonGroupTypeDraw;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddCodeKey;
    private javax.swing.JButton jButtonAddNewActivity;
    private javax.swing.JButton jButtonAddOutput;
    private javax.swing.JButton jButtonAddSeason;
    private javax.swing.JButton jButtonAlterarPasswd;
    private javax.swing.JButton jButtonAlunoEliminar;
    private javax.swing.JButton jButtonAlunoGravar;
    private javax.swing.JButton jButtonApplyBlockTabs;
    private javax.swing.JButton jButtonAtvDeleteRow;
    private javax.swing.JButton jButtonAtvNewClear;
    private javax.swing.JButton jButtonCheckResults;
    private javax.swing.JButton jButtonCodeKeyClose;
    private javax.swing.JButton jButtonCodeSettings;
    private javax.swing.JButton jButtonDefCurrentYear;
    private javax.swing.JButton jButtonDraw;
    private javax.swing.JButton jButtonEditarAlunoInf;
    private javax.swing.JButton jButtonInitialize;
    private javax.swing.JButton jButtonInitializeScore;
    private javax.swing.JButton jButtonInserirAtividade;
    private javax.swing.JButton jButtonInsertResults;
    private javax.swing.JButton jButtonMessageToSudent;
    private javax.swing.JButton jButtonNewParsonProblem;
    private javax.swing.JButton jButtonNewStudent;
    private javax.swing.JButton jButtonOutputClose;
    private javax.swing.JButton jButtonOutputDeleteRow;
    private javax.swing.JButton jButtonOutputSettings;
    private javax.swing.JButton jButtonReadFile;
    private javax.swing.JButton jButtonReadFilePresences;
    private javax.swing.JButton jButtonRefreshExpert;
    private javax.swing.JButton jButtonRefreshStudentScore;
    private javax.swing.JButton jButtonRefreshTableActiveStudents;
    private javax.swing.JButton jButtonSaveActivity;
    private javax.swing.JButton jButtonSaveCSVFile;
    private javax.swing.JButton jButtonSaveParsonProblem;
    private javax.swing.JButton jButtonSavePresences;
    private javax.swing.JButton jButtonSaveResults;
    private javax.swing.JButton jButtonSaveRound;
    private javax.swing.JButton jButtonSeason;
    private javax.swing.JButton jButtonSelectConfFile;
    private javax.swing.JButton jButtonSelectPDF;
    private javax.swing.JButton jButtonSendMsgAluno;
    private javax.swing.JButton jButtonShuffle;
    private javax.swing.JButton jButtonStepDraw;
    private javax.swing.JButton jButtonStudentCharact;
    private javax.swing.JButton jButtonTopStudents;
    private javax.swing.JButton jButtonUpdateScore;
    private javax.swing.JComboBox<String> jComboBoxCurso;
    private javax.swing.JComboBox<String> jComboBoxCursoPresencas;
    private javax.swing.JComboBox<String> jComboBoxCursosInicial;
    private javax.swing.JComboBox<String> jComboBoxDrawResult;
    private javax.swing.JComboBox<String> jComboBoxSeason;
    private javax.swing.JComboBox<String> jComboBoxUnidadeCurricular;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserDataAtividade;
    private com.toedter.calendar.JDateChooser jDateChooserDateActivity;
    private com.toedter.calendar.JDateChooser jDateChooserRegistarPresenca;
    private javax.swing.JDialog jDialogAlunos;
    private javax.swing.JDialog jDialogInsertOutput;
    private javax.swing.JDialog jDialogInsertResults;
    private javax.swing.JDialog jDialogMessageToStudent;
    private javax.swing.JDialog jDialogNewParsonProblems;
    private javax.swing.JDialog jDialogPresencasPorData;
    private javax.swing.JDialog jDialogRegistarPresenca;
    private javax.swing.JDialog jDialogResultadosPorAtividade;
    private javax.swing.JDialog jDialogResultsStudentCharact;
    private javax.swing.JDialog jDialogSeason;
    private javax.swing.JDialog jDialogTestCodeKey;
    private javax.swing.JDialog jDialogVerAluno;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooserSelectPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAlunoFoto;
    private javax.swing.JLabel jLabelAlunoFotoInf;
    private javax.swing.JLabel jLabelAlunoNomeInf;
    private javax.swing.JLabel jLabelAlunoNumeroInf;
    private javax.swing.JLabel jLabelAlunoScoreInf;
    private javax.swing.JLabel jLabelDescricaoAtividade;
    private javax.swing.JLabel jLabelIdAtividade;
    private javax.swing.JLabel jLabelNomeAlunoMsg;
    private javax.swing.JLabel jLabelNumberToDraw;
    private javax.swing.JLabel jLabelNumeroAlunoMsg;
    private javax.swing.JLabel jLabelSeason;
    private javax.swing.JLabel jLabelTotalAdvanced;
    private javax.swing.JLabel jLabelTotalArrays;
    private javax.swing.JLabel jLabelTotalBasic;
    private javax.swing.JLabel jLabelTotalIf;
    private javax.swing.JLabel jLabelTotalLoop;
    private javax.swing.JLabel jLabelTotalPreActivities;
    private javax.swing.JLabel jLabelTotalPresencas;
    private javax.swing.JList<String> jListActivities;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelActiveStudents;
    private javax.swing.JPanel jPanelActivity;
    private javax.swing.JPanel jPanelAreaCodeKey;
    private javax.swing.JPanel jPanelAreaInsertOutput;
    private javax.swing.JPanel jPanelAreaParsonProblems;
    private javax.swing.JPanel jPanelBlockedTabs;
    private javax.swing.JPanel jPanelConfActivity;
    private javax.swing.JPanel jPanelDefinitions;
    private javax.swing.JPanel jPanelExpert;
    private javax.swing.JPanel jPanelGamification;
    private javax.swing.JPanel jPanelIntroduActivities;
    private javax.swing.JPanel jPanelNewActivity;
    private javax.swing.JPanel jPanelParsonProblems;
    private javax.swing.JPanel jPanelPresences;
    private javax.swing.JPanel jPanelPrincipalAlunos;
    private javax.swing.JPanel jPanelResultStudentPersonal;
    private javax.swing.JPanel jPanelVerAluno;
    private javax.swing.JPanel jPanelWorkDone;
    private javax.swing.JPasswordField jPasswordFieldAluno;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButtonAutomaticResults;
    private javax.swing.JRadioButton jRadioButtonFeminino;
    private javax.swing.JRadioButton jRadioButtonManualResults;
    private javax.swing.JRadioButton jRadioButtonMasculino;
    private javax.swing.JRadioButton jRadioButtonRandomDraw;
    private javax.swing.JRadioButton jRadioButtonScoreDraw;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneActivityShow;
    private javax.swing.JSpinner jSpinnerHourPresences;
    private javax.swing.JTabbedPane jTabbedPanePrincipal;
    private javax.swing.JTable jTableActiveStudents;
    private javax.swing.JTable jTableAlunoPresenca;
    private javax.swing.JTable jTableAtividades;
    private javax.swing.JTable jTableAtividadesAluno;
    private javax.swing.JTable jTableAtividadesAlunoAdvanced;
    private javax.swing.JTable jTableAtividadesAlunoArrays;
    private javax.swing.JTable jTableAtividadesAlunoIF;
    private javax.swing.JTable jTableDataTotalAlunos;
    private javax.swing.JTable jTableDraw;
    private javax.swing.JTable jTableExpert;
    private javax.swing.JTable jTableInsertOutput;
    private javax.swing.JTable jTableInsertResults;
    private javax.swing.JTable jTableKeyCodeTest;
    private javax.swing.JTable jTablePreAtividadeAluno;
    private javax.swing.JTable jTablePreAtividadeAlunoLoop;
    private javax.swing.JTable jTablePresencasPorData;
    private javax.swing.JTable jTableRegistarPresenca;
    private javax.swing.JTable jTableResultadosPorAtividade;
    private javax.swing.JTable jTableStudentCharact;
    private javax.swing.JTable jTableStudentTODraw;
    private javax.swing.JTable jTableTodosAlunosPrincipal;
    private javax.swing.JTable jTableVerQuestionario;
    private javax.swing.JTable jTableViewParsonProblems;
    private javax.swing.JTextArea jTextAreaMsgToAluno;
    private javax.swing.JTextArea jTextAreaProgramSolution;
    private javax.swing.JTextArea jTextAreaShuffledProgram;
    private javax.swing.JTextArea jTextAreaTextActivity;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldActNumber;
    private javax.swing.JTextField jTextFieldAlunoEmail;
    private javax.swing.JTextField jTextFieldAlunoLocalidade;
    private javax.swing.JTextField jTextFieldAlunoLogin;
    private javax.swing.JTextField jTextFieldAlunoNome;
    private javax.swing.JTextField jTextFieldAlunoNumero;
    private javax.swing.JTextField jTextFieldAnoletivo;
    private javax.swing.JTextField jTextFieldAtividadeDescricao;
    private javax.swing.JTextField jTextFieldDefCurrentYear;
    private javax.swing.JTextField jTextFieldNewSeason;
    private javax.swing.JTextField jTextFieldNumberInputTest;
    private javax.swing.JTextField jTextFieldParsonDescricao;
    private javax.swing.JTextField jTextFieldRound;
    private javax.swing.JTextField jTextFieldSelectPDF;
    private javax.swing.JTextField jTextFieldidAtividade;
    private javax.swing.JTextField jTextFieldnTest;
    // End of variables declaration//GEN-END:variables

    ConnectBD liga = null;
    Connection con = null;

    Map<String, BufferedImage> alunosFotos = new TreeMap<>();
    File fileFoto = null;
    File fileSelectPDF = null;
    int novo = 0;
    String atividadeCorrente = "";
    String idAtividadeCorrente = "";
//    String cursoAtivo = "-- Select Course --";
    String cursoAtivo = "Engenharia Informática";
    ResultSetTableModel model2 = null;
    ResultSetTableModel modelo2 = null;

    Map<String, JLabel> tabelaTotal = new HashMap<>();
    Map<String, AlunoExpert> mExpert = new TreeMap<>();
    
    int anoletivo = 0;
}
