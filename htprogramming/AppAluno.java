/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htprogramming;

import codecheck.CalcularResultados;
import codecheck.CodeInspection;
import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import modelo.Aluno;
import modelo.AtividadeConf;
import modelo.ChooserData;
import modelo.CustomRendererColor;
import modelo.DadosCAP;
import modelo.DadosPreAtv;
import modelo.DadosQuestionario;
import modelo.DadosVEspacial;
import modelo.NumeroPerfil;
import modelo.Questionario;
import modelo.Resposta;
import service.ConnectBD;
import service.DadosPeduca;
import service.IOImagem;
import service.ValidaLogin;
import ui.AtividadeVEspacial;
import ui.CaraterizacaoAluno;
import util.CursorToolkit;
import util.NewUtilBD;
import util.ResultSetTableModel;
import util.UtilAcesso;
import util.UtilBDConsulta;
import util.UtilConvertData;
import dnd.ListTransferHandler;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.TransferHandler;
import modelo.DadosCoding;

/**
 *
 * @author Utilizador
 */
public class AppAluno extends javax.swing.JFrame {

    public AppAluno() {
//        HTProgramming mainWindowInstance = new HTProgramming();
        initComponents();
//        anoletivo = LocalDate.now().getYear();
        anoletivo = 2021;
        try {
//            Image i = ImageIO.read(getClass().getResource("/icons/logoHelpPro.png"));
            Image i = ImageIO.read(getClass().getResource("/icons/logoCodingC.jpg"));
            this.setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(HTProgramming.class.getName()).log(Level.SEVERE, null, ex);
        }
        lockChangePass(false);
        lockTabbedPane(false);
        //liga = new ConnectBD(); // Alterado para local = true e remoto = false !jRadioButtonDBRemote.isSelected()
        liga = new ConnectBD(!jRadioButtonDBRemote.isSelected());

//        con = (Connection) liga.makeConAuto();
        pathToDocuments = DadosPeduca.workDirDocuments; //FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
        criaPastaCoding();
        jPanelParsonProblemsArea.setVisible(false);
        if (HTProgramming.getMainFrame() != null) {
            HTProgramming.getMainFrame().dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogChangePassword = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();
        jButtonNewPassConfirmation = new javax.swing.JButton();
        buttonGroupGenero = new javax.swing.ButtonGroup();
        jDialogCoding = new javax.swing.JDialog();
        jScrollPaneCoding = new javax.swing.JScrollPane();
        jTextAreaCode = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabelSelectedActivity = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButtonVerify = new javax.swing.JButton();
        jButtonResetCode = new javax.swing.JButton();
        jLabelIDAtividade = new javax.swing.JLabel();
        jButtonSaveCode = new javax.swing.JButton();
        jDialogCodeError = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCodeError = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jDialogVerifyResult = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaVerifyResult = new javax.swing.JTextArea();
        jDialogCodeResult = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCodeResult = new javax.swing.JTable();
        jDialogNewCoding = new javax.swing.JDialog();
        jScrollPaneAtv = new javax.swing.JScrollPane();
        jTreeAtv = new javax.swing.JTree();
        jDialogViewCodeC = new javax.swing.JDialog();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextAreaViewCode = new javax.swing.JTextArea();
        jDialogViewResult = new javax.swing.JDialog();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextAreaQuestResults = new javax.swing.JTextArea();
        jDialogViewCodingResult = new javax.swing.JDialog();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextAreaViewCodingResult = new javax.swing.JTextArea();
        jDialogViewResultParsonProblem = new javax.swing.JDialog();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextAreaResultParsonProblems = new javax.swing.JTextArea();
        buttonGroupDBRemote = new javax.swing.ButtonGroup();
        jTabbedPaneAlunoPrincipal = new javax.swing.JTabbedPane();
        jPanelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUtilizador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabelMensagens = new javax.swing.JLabel();
        jRadioButtonDBRemote = new javax.swing.JRadioButton();
        jRadioButtonDBLocal = new javax.swing.JRadioButton();
        jPanelUser = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAlunoNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAlunoNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAlunoLocalidade = new javax.swing.JTextField();
        jLabelAlunoFoto = new javax.swing.JLabel();
        jDateChooserDataNascimento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jRadioButtonMasculino = new javax.swing.JRadioButton();
        jRadioButtonFeminino = new javax.swing.JRadioButton();
        jPanelLoginPassword = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAlunoLogin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPasswordFieldAluno = new javax.swing.JPasswordField();
        jButtonValidationChangePass = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldAlunoEmail = new javax.swing.JTextField();
        jButtonChangePassword = new javax.swing.JButton();
        jTextFieldAlunoCurso = new javax.swing.JTextField();
        jTextFieldAlunoDisciplina = new javax.swing.JTextField();
        jButtonSaveChangedInf = new javax.swing.JButton();
        jPanelMessages = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableMessagesAluno = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jPanelWorkDone = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtividadesAluno = new javax.swing.JTable();
        jLabelTotalPerfil = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTablePreAtividadeAluno = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTablePreAtividadeAlunoLoop = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTableAtividadesAlunoArrays = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTableAtividadesAlunoIF = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTableAtividadesAlunoAdvanced = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabelTotalIf = new javax.swing.JLabel();
        jLabelTotalPreActivities = new javax.swing.JLabel();
        jLabelTotalBasic = new javax.swing.JLabel();
        jLabelTotalLoop = new javax.swing.JLabel();
        jLabelTotalArrays = new javax.swing.JLabel();
        jLabelTotalAdvanced = new javax.swing.JLabel();
        jPanelActivities = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jComboBoxTopics = new javax.swing.JComboBox<>();
        jPanelAreaPergunta = new javax.swing.JPanel();
        jScrollPaneAreaQuestion = new javax.swing.JScrollPane();
        jTextAreaQuestion = new javax.swing.JTextArea();
        jPanelAreaResposta = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jButtonStartActivity = new javax.swing.JButton();
        jButtonNextQuestion = new javax.swing.JButton();
        jPanelCodingToDo = new javax.swing.JPanel();
        jPanelAreaSubmitC = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldCFile = new javax.swing.JTextField();
        jButtonSelectCFile = new javax.swing.JButton();
        jButtonViewCode = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableResultTest = new javax.swing.JTable();
        jButtonVerifyResult = new javax.swing.JButton();
        jPanelAreaAtividade = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabelActivitySelected = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaEnunciado = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAtividades = new javax.swing.JTable();
        jLabelAtvScore = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanelCAP = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButtonIniciarCAP = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanelVEspacial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonStarTest = new javax.swing.JButton();
        jPanelParsonProblems = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButtonStartPProblems = new javax.swing.JButton();
        jPanelParsonProblemsArea = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButtonPPValidate = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jComboBoxParsonProblems = new javax.swing.JComboBox<>();
        jPanelLogout = new javax.swing.JPanel();
        jButtonLogout = new javax.swing.JButton();

        jDialogChangePassword.setTitle("Change Password");
        jDialogChangePassword.setMinimumSize(new java.awt.Dimension(400, 120));
        jDialogChangePassword.setModal(true);
        jDialogChangePassword.setResizable(false);

        jLabel13.setText("New Passord:");

        jButtonNewPassConfirmation.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonNewPassConfirmation.setText("Confirmation");
        jButtonNewPassConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPassConfirmationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogChangePasswordLayout = new javax.swing.GroupLayout(jDialogChangePassword.getContentPane());
        jDialogChangePassword.getContentPane().setLayout(jDialogChangePasswordLayout);
        jDialogChangePasswordLayout.setHorizontalGroup(
            jDialogChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogChangePasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonNewPassConfirmation, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogChangePasswordLayout.setVerticalGroup(
            jDialogChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogChangePasswordLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDialogChangePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jPasswordFieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNewPassConfirmation))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jDialogCoding.setTitle("Coding");
        jDialogCoding.setMinimumSize(new java.awt.Dimension(700, 520));

        jTextAreaCode.setColumns(20);
        jTextAreaCode.setRows(5);
        jScrollPaneCoding.setViewportView(jTextAreaCode);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Coding");

        jLabelSelectedActivity.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSelectedActivity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSelectedActivity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelSelectedActivity.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Selected Activity:");

        jButtonVerify.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonVerify.setText("Verify");
        jButtonVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerifyActionPerformed(evt);
            }
        });

        jButtonResetCode.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonResetCode.setText("Reset Code");
        jButtonResetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetCodeActionPerformed(evt);
            }
        });

        jLabelIDAtividade.setEnabled(false);

        jButtonSaveCode.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSaveCode.setText("Save Code");
        jButtonSaveCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogCodingLayout = new javax.swing.GroupLayout(jDialogCoding.getContentPane());
        jDialogCoding.getContentPane().setLayout(jDialogCodingLayout);
        jDialogCodingLayout.setHorizontalGroup(
            jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCodingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCodingLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSelectedActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabelIDAtividade)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogCodingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSaveCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonResetCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogCodingLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneCoding, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jDialogCodingLayout.setVerticalGroup(
            jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCodingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSelectedActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14))
                    .addComponent(jLabelIDAtividade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addGroup(jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerify)
                    .addComponent(jButtonResetCode)
                    .addComponent(jButtonSaveCode))
                .addContainerGap())
            .addGroup(jDialogCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogCodingLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jScrollPaneCoding, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        jDialogCodeError.setMinimumSize(new java.awt.Dimension(600, 400));

        jTextAreaCodeError.setColumns(20);
        jTextAreaCodeError.setRows(5);
        jScrollPane2.setViewportView(jTextAreaCodeError);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Code Errors");

        javax.swing.GroupLayout jDialogCodeErrorLayout = new javax.swing.GroupLayout(jDialogCodeError.getContentPane());
        jDialogCodeError.getContentPane().setLayout(jDialogCodeErrorLayout);
        jDialogCodeErrorLayout.setHorizontalGroup(
            jDialogCodeErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCodeErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jDialogCodeErrorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogCodeErrorLayout.setVerticalGroup(
            jDialogCodeErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCodeErrorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jDialogVerifyResult.setTitle("Verify Result");
        jDialogVerifyResult.setMinimumSize(new java.awt.Dimension(400, 300));

        jTextAreaVerifyResult.setColumns(20);
        jTextAreaVerifyResult.setRows(5);
        jScrollPane4.setViewportView(jTextAreaVerifyResult);

        javax.swing.GroupLayout jDialogVerifyResultLayout = new javax.swing.GroupLayout(jDialogVerifyResult.getContentPane());
        jDialogVerifyResult.getContentPane().setLayout(jDialogVerifyResultLayout);
        jDialogVerifyResultLayout.setHorizontalGroup(
            jDialogVerifyResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVerifyResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogVerifyResultLayout.setVerticalGroup(
            jDialogVerifyResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogVerifyResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogCodeResult.setMinimumSize(new java.awt.Dimension(630, 400));

        jTableCodeResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expected", "Result", "Validation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableCodeResult);

        javax.swing.GroupLayout jDialogCodeResultLayout = new javax.swing.GroupLayout(jDialogCodeResult.getContentPane());
        jDialogCodeResult.getContentPane().setLayout(jDialogCodeResultLayout);
        jDialogCodeResultLayout.setHorizontalGroup(
            jDialogCodeResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCodeResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogCodeResultLayout.setVerticalGroup(
            jDialogCodeResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogCodeResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jDialogNewCoding.setTitle("Test Activity Code");
        jDialogNewCoding.setMinimumSize(new java.awt.Dimension(720, 600));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTreeAtv.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPaneAtv.setViewportView(jTreeAtv);

        javax.swing.GroupLayout jDialogNewCodingLayout = new javax.swing.GroupLayout(jDialogNewCoding.getContentPane());
        jDialogNewCoding.getContentPane().setLayout(jDialogNewCodingLayout);
        jDialogNewCodingLayout.setHorizontalGroup(
            jDialogNewCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNewCodingLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jScrollPaneAtv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jDialogNewCodingLayout.setVerticalGroup(
            jDialogNewCodingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNewCodingLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jScrollPaneAtv, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(185, 185, 185))
        );

        jDialogViewCodeC.setTitle("View Code");
        jDialogViewCodeC.setMinimumSize(new java.awt.Dimension(650, 480));

        jTextAreaViewCode.setColumns(20);
        jTextAreaViewCode.setRows(5);
        jTextAreaViewCode.setEnabled(false);
        jScrollPane10.setViewportView(jTextAreaViewCode);

        javax.swing.GroupLayout jDialogViewCodeCLayout = new javax.swing.GroupLayout(jDialogViewCodeC.getContentPane());
        jDialogViewCodeC.getContentPane().setLayout(jDialogViewCodeCLayout);
        jDialogViewCodeCLayout.setHorizontalGroup(
            jDialogViewCodeCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewCodeCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogViewCodeCLayout.setVerticalGroup(
            jDialogViewCodeCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewCodeCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogViewResult.setTitle("Questionnaire results");
        jDialogViewResult.setMinimumSize(new java.awt.Dimension(460, 380));
        jDialogViewResult.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogViewResultWindowClosing(evt);
            }
        });

        jTextAreaQuestResults.setEditable(false);
        jTextAreaQuestResults.setColumns(20);
        jTextAreaQuestResults.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAreaQuestResults.setRows(5);
        jScrollPane11.setViewportView(jTextAreaQuestResults);

        javax.swing.GroupLayout jDialogViewResultLayout = new javax.swing.GroupLayout(jDialogViewResult.getContentPane());
        jDialogViewResult.getContentPane().setLayout(jDialogViewResultLayout);
        jDialogViewResultLayout.setHorizontalGroup(
            jDialogViewResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogViewResultLayout.setVerticalGroup(
            jDialogViewResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogViewCodingResult.setTitle("View Coding Results");
        jDialogViewCodingResult.setMinimumSize(new java.awt.Dimension(650, 330));

        jTextAreaViewCodingResult.setEditable(false);
        jTextAreaViewCodingResult.setColumns(20);
        jTextAreaViewCodingResult.setRows(5);
        jScrollPane13.setViewportView(jTextAreaViewCodingResult);

        javax.swing.GroupLayout jDialogViewCodingResultLayout = new javax.swing.GroupLayout(jDialogViewCodingResult.getContentPane());
        jDialogViewCodingResult.getContentPane().setLayout(jDialogViewCodingResultLayout);
        jDialogViewCodingResultLayout.setHorizontalGroup(
            jDialogViewCodingResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewCodingResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogViewCodingResultLayout.setVerticalGroup(
            jDialogViewCodingResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewCodingResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDialogViewResultParsonProblem.setTitle("Your Solution");
        jDialogViewResultParsonProblem.setMinimumSize(new java.awt.Dimension(510, 410));
        jDialogViewResultParsonProblem.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogViewResultParsonProblemWindowClosing(evt);
            }
        });

        jScrollPane16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextAreaResultParsonProblems.setEditable(false);
        jTextAreaResultParsonProblems.setColumns(20);
        jTextAreaResultParsonProblems.setRows(5);
        jScrollPane16.setViewportView(jTextAreaResultParsonProblems);

        javax.swing.GroupLayout jDialogViewResultParsonProblemLayout = new javax.swing.GroupLayout(jDialogViewResultParsonProblem.getContentPane());
        jDialogViewResultParsonProblem.getContentPane().setLayout(jDialogViewResultParsonProblemLayout);
        jDialogViewResultParsonProblemLayout.setHorizontalGroup(
            jDialogViewResultParsonProblemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewResultParsonProblemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogViewResultParsonProblemLayout.setVerticalGroup(
            jDialogViewResultParsonProblemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogViewResultParsonProblemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help Programming");
        setMinimumSize(new java.awt.Dimension(900, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPaneAlunoPrincipal.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPaneAlunoPrincipal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneAlunoPrincipalStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Utilizador:");

        jTextFieldUtilizador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PassWord:");

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(42, 55, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jTextFieldUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 50, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jLabelMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addComponent(jButtonLogin)
                    .addGap(0, 138, Short.MAX_VALUE)))
        );

        buttonGroupDBRemote.add(jRadioButtonDBRemote);
        jRadioButtonDBRemote.setSelected(true);
        jRadioButtonDBRemote.setText("DataBase Remote");

        buttonGroupDBRemote.add(jRadioButtonDBLocal);
        jRadioButtonDBLocal.setText("DataBase LOCAL");

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDBRemote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButtonDBLocal))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(404, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDBRemote)
                    .addComponent(jRadioButtonDBLocal))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jTabbedPaneAlunoPrincipal.addTab("Login", new javax.swing.ImageIcon(getClass().getResource("/icons/login.png")), jPanelLogin); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel3.setText("Number:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 16, 47, 16);

        jTextFieldAlunoNumero.setEditable(false);
        jPanel4.add(jTextFieldAlunoNumero);
        jTextFieldAlunoNumero.setBounds(120, 13, 250, 22);

        jLabel4.setText("Name:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 54, 35, 16);

        jTextFieldAlunoNome.setEditable(false);
        jPanel4.add(jTextFieldAlunoNome);
        jTextFieldAlunoNome.setBounds(120, 51, 250, 22);

        jLabel5.setText("Course:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(10, 92, 50, 16);

        jLabel6.setText("Subject:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 130, 42, 16);

        jLabel7.setText("Birth Date:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(10, 162, 90, 20);

        jLabel8.setText("Nationality / Town:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 200, 110, 16);
        jPanel4.add(jTextFieldAlunoLocalidade);
        jTextFieldAlunoLocalidade.setBounds(120, 200, 250, 22);

        jLabelAlunoFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAlunoFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/anonimo1.jpg"))); // NOI18N
        jLabelAlunoFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelAlunoFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAlunoFotoMouseClicked(evt);
            }
        });
        jPanel4.add(jLabelAlunoFoto);
        jLabelAlunoFoto.setBounds(420, 10, 120, 150);
        jPanel4.add(jDateChooserDataNascimento);
        jDateChooserDataNascimento.setBounds(120, 162, 250, 22);

        jLabel9.setText("Gender:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(10, 230, 50, 16);

        buttonGroupGenero.add(jRadioButtonMasculino);
        jRadioButtonMasculino.setSelected(true);
        jRadioButtonMasculino.setText("Male");
        jPanel4.add(jRadioButtonMasculino);
        jRadioButtonMasculino.setBounds(120, 230, 49, 20);

        buttonGroupGenero.add(jRadioButtonFeminino);
        jRadioButtonFeminino.setText("Female");
        jPanel4.add(jRadioButtonFeminino);
        jRadioButtonFeminino.setBounds(220, 230, 61, 20);

        jPanelLoginPassword.setBackground(new java.awt.Color(153, 204, 255));
        jPanelLoginPassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Login:");

        jLabel11.setText("Current Password:");

        jButtonValidationChangePass.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonValidationChangePass.setText("Validation");
        jButtonValidationChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidationChangePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginPasswordLayout = new javax.swing.GroupLayout(jPanelLoginPassword);
        jPanelLoginPassword.setLayout(jPanelLoginPasswordLayout);
        jPanelLoginPasswordLayout.setHorizontalGroup(
            jPanelLoginPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginPasswordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLoginPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonValidationChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLoginPasswordLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAlunoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelLoginPasswordLayout.setVerticalGroup(
            jPanelLoginPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginPasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldAlunoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jPasswordFieldAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonValidationChangePass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanelLoginPassword);
        jPanelLoginPassword.setBounds(10, 330, 530, 70);

        jLabel12.setText("EMail:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(10, 260, 32, 16);
        jPanel4.add(jTextFieldAlunoEmail);
        jTextFieldAlunoEmail.setBounds(120, 260, 250, 22);

        jButtonChangePassword.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonChangePassword.setText("Change Password");
        jButtonChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangePasswordActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonChangePassword);
        jButtonChangePassword.setBounds(420, 300, 120, 19);

        jTextFieldAlunoCurso.setEditable(false);
        jPanel4.add(jTextFieldAlunoCurso);
        jTextFieldAlunoCurso.setBounds(120, 90, 250, 20);

        jTextFieldAlunoDisciplina.setEditable(false);
        jPanel4.add(jTextFieldAlunoDisciplina);
        jTextFieldAlunoDisciplina.setBounds(120, 126, 250, 22);

        jButtonSaveChangedInf.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonSaveChangedInf.setText("Save Changed Information");
        jButtonSaveChangedInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChangedInfActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSaveChangedInf);
        jButtonSaveChangedInf.setBounds(215, 300, 152, 19);

        javax.swing.GroupLayout jPanelUserLayout = new javax.swing.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneAlunoPrincipal.addTab("User", new javax.swing.ImageIcon(getClass().getResource("/icons/settings.png")), jPanelUser); // NOI18N

        jTableMessagesAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Sugestion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMessagesAluno.setToolTipText("Double click for detail");
        jTableMessagesAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMessagesAlunoMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(jTableMessagesAluno);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("Comments/suggestions for improvement of the activities");

        javax.swing.GroupLayout jPanelMessagesLayout = new javax.swing.GroupLayout(jPanelMessages);
        jPanelMessages.setLayout(jPanelMessagesLayout);
        jPanelMessagesLayout.setHorizontalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessagesLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanelMessagesLayout.setVerticalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessagesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jTabbedPaneAlunoPrincipal.addTab("Messages", new javax.swing.ImageIcon(getClass().getResource("/icons/comment.png")), jPanelMessages); // NOI18N

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
        jScrollPane1.setBounds(300, 60, 280, 189);

        jLabelTotalPerfil.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPerfil.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTotalPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPerfil.setText("0");
        jLabelTotalPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalPerfil.setOpaque(true);
        jPanelWorkDone.add(jLabelTotalPerfil);
        jLabelTotalPerfil.setBounds(800, 10, 100, 38);

        jTablePreAtividadeAluno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePreAtividadeAluno.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePreAtividadeAluno.setName("jLabelTotalPreActivities"); // NOI18N
        jScrollPane8.setViewportView(jTablePreAtividadeAluno);

        jPanelWorkDone.add(jScrollPane8);
        jScrollPane8.setBounds(20, 60, 270, 189);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Pré-Activities");
        jPanelWorkDone.add(jLabel31);
        jLabel31.setBounds(20, 30, 90, 30);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Basic Activities Concepts");
        jPanelWorkDone.add(jLabel32);
        jLabel32.setBounds(300, 30, 148, 20);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("if - switch Concepts");
        jPanelWorkDone.add(jLabel33);
        jLabel33.setBounds(590, 30, 119, 30);

        jTablePreAtividadeAlunoLoop.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTablePreAtividadeAlunoLoop.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePreAtividadeAlunoLoop.setName("jLabelTotalLoop"); // NOI18N
        jScrollPane17.setViewportView(jTablePreAtividadeAlunoLoop);

        jPanelWorkDone.add(jScrollPane17);
        jScrollPane17.setBounds(20, 330, 270, 189);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Loop Concepts");
        jPanelWorkDone.add(jLabel34);
        jLabel34.setBounds(20, 310, 93, 17);

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
        jScrollPane18.setViewportView(jTableAtividadesAlunoArrays);

        jPanelWorkDone.add(jScrollPane18);
        jScrollPane18.setBounds(300, 330, 280, 190);

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
        jScrollPane19.setViewportView(jTableAtividadesAlunoIF);

        jPanelWorkDone.add(jScrollPane19);
        jScrollPane19.setBounds(590, 60, 270, 189);

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
        jScrollPane20.setViewportView(jTableAtividadesAlunoAdvanced);

        jPanelWorkDone.add(jScrollPane20);
        jScrollPane20.setBounds(590, 330, 270, 190);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Arrays Concepts");
        jPanelWorkDone.add(jLabel35);
        jLabel35.setBounds(300, 310, 130, 17);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Advanced Concepts");
        jPanelWorkDone.add(jLabel36);
        jLabel36.setBounds(590, 310, 160, 17);

        jLabelTotalIf.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalIf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalIf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalIf.setText("0");
        jLabelTotalIf.setToolTipText("Double Click to Refresh");
        jLabelTotalIf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalIf.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalIf.setOpaque(true);
        jLabelTotalIf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTotalIfMouseClicked(evt);
            }
        });
        jPanelWorkDone.add(jLabelTotalIf);
        jLabelTotalIf.setBounds(760, 260, 90, 21);

        jLabelTotalPreActivities.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalPreActivities.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalPreActivities.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalPreActivities.setText("0");
        jLabelTotalPreActivities.setToolTipText("Double Click to Refresh");
        jLabelTotalPreActivities.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalPreActivities.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalPreActivities.setOpaque(true);
        jLabelTotalPreActivities.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTotalPreActivitiesMouseClicked(evt);
            }
        });
        jPanelWorkDone.add(jLabelTotalPreActivities);
        jLabelTotalPreActivities.setBounds(190, 260, 90, 21);

        jLabelTotalBasic.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalBasic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalBasic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalBasic.setText("0");
        jLabelTotalBasic.setToolTipText("Double Click to Refresh");
        jLabelTotalBasic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalBasic.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalBasic.setOpaque(true);
        jLabelTotalBasic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTotalBasicMouseClicked(evt);
            }
        });
        jPanelWorkDone.add(jLabelTotalBasic);
        jLabelTotalBasic.setBounds(480, 260, 90, 21);

        jLabelTotalLoop.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalLoop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalLoop.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalLoop.setText("0");
        jLabelTotalLoop.setToolTipText("Double Click to Refresh");
        jLabelTotalLoop.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalLoop.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalLoop.setOpaque(true);
        jLabelTotalLoop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTotalLoopMouseClicked(evt);
            }
        });
        jPanelWorkDone.add(jLabelTotalLoop);
        jLabelTotalLoop.setBounds(190, 530, 90, 21);

        jLabelTotalArrays.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalArrays.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalArrays.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalArrays.setText("0");
        jLabelTotalArrays.setToolTipText("Double Click to Refresh");
        jLabelTotalArrays.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalArrays.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalArrays.setOpaque(true);
        jLabelTotalArrays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTotalArraysMouseClicked(evt);
            }
        });
        jPanelWorkDone.add(jLabelTotalArrays);
        jLabelTotalArrays.setBounds(480, 530, 90, 21);

        jLabelTotalAdvanced.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTotalAdvanced.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotalAdvanced.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalAdvanced.setText("0");
        jLabelTotalAdvanced.setToolTipText("Double Click to Refresh");
        jLabelTotalAdvanced.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelTotalAdvanced.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabelTotalAdvanced.setOpaque(true);
        jLabelTotalAdvanced.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTotalAdvancedMouseClicked(evt);
            }
        });
        jPanelWorkDone.add(jLabelTotalAdvanced);
        jLabelTotalAdvanced.setBounds(760, 530, 90, 21);

        jTabbedPaneAlunoPrincipal.addTab("Work Done", new javax.swing.ImageIcon(getClass().getResource("/icons/taskDone2.png")), jPanelWorkDone); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Topic:");

        jComboBoxTopics.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxTopics.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTopics.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxTopicsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jPanelAreaPergunta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaQuestion.setEditable(false);
        jTextAreaQuestion.setColumns(20);
        jTextAreaQuestion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextAreaQuestion.setRows(5);
        jScrollPaneAreaQuestion.setViewportView(jTextAreaQuestion);

        jRadioButton1.setText("Inicio resposta");

        jRadioButton2.setText("Inicio resposta");

        jRadioButton4.setText("Inicio resposta");

        jRadioButton3.setText("Inicio resposta");

        jRadioButton8.setText("Inicio resposta");

        jRadioButton7.setText("Inicio resposta");

        jRadioButton6.setText("Inicio resposta");

        jRadioButton5.setText("Inicio resposta");

        jRadioButton12.setText("Inicio resposta");

        jRadioButton9.setText("Inicio resposta");

        jRadioButton10.setText("Inicio resposta");

        jRadioButton11.setText("Inicio resposta");

        javax.swing.GroupLayout jPanelAreaRespostaLayout = new javax.swing.GroupLayout(jPanelAreaResposta);
        jPanelAreaResposta.setLayout(jPanelAreaRespostaLayout);
        jPanelAreaRespostaLayout.setHorizontalGroup(
            jPanelAreaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaRespostaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jRadioButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jRadioButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jRadioButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAreaRespostaLayout.setVerticalGroup(
            jPanelAreaRespostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaRespostaLayout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton12)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelAreaPerguntaLayout = new javax.swing.GroupLayout(jPanelAreaPergunta);
        jPanelAreaPergunta.setLayout(jPanelAreaPerguntaLayout);
        jPanelAreaPerguntaLayout.setHorizontalGroup(
            jPanelAreaPerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaPerguntaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelAreaPerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAreaPerguntaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanelAreaResposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneAreaQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanelAreaPerguntaLayout.setVerticalGroup(
            jPanelAreaPerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaPerguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneAreaQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAreaResposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonStartActivity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonStartActivity.setText("Start");
        jButtonStartActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActivityActionPerformed(evt);
            }
        });

        jButtonNextQuestion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonNextQuestion.setText("Next");
        jButtonNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextQuestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActivitiesLayout = new javax.swing.GroupLayout(jPanelActivities);
        jPanelActivities.setLayout(jPanelActivitiesLayout);
        jPanelActivitiesLayout.setHorizontalGroup(
            jPanelActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActivitiesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanelActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTopics, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonStartActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActivitiesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelAreaPergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanelActivitiesLayout.setVerticalGroup(
            jPanelActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActivitiesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelActivitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxTopics, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jButtonStartActivity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAreaPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jButtonNextQuestion)
                .addContainerGap())
        );

        jTabbedPaneAlunoPrincipal.addTab("Basic Concepts", new javax.swing.ImageIcon(getClass().getResource("/icons/taskToDo.jpg")), jPanelActivities); // NOI18N

        jPanelAreaSubmitC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("C File to Submit:");

        jButtonSelectCFile.setText("Select C File");
        jButtonSelectCFile.setEnabled(false);
        jButtonSelectCFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectCFileActionPerformed(evt);
            }
        });

        jButtonViewCode.setText("View File");
        jButtonViewCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAreaSubmitCLayout = new javax.swing.GroupLayout(jPanelAreaSubmitC);
        jPanelAreaSubmitC.setLayout(jPanelAreaSubmitCLayout);
        jPanelAreaSubmitCLayout.setHorizontalGroup(
            jPanelAreaSubmitCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaSubmitCLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldCFile)
                .addGap(18, 18, 18)
                .addComponent(jButtonSelectCFile)
                .addGap(18, 18, 18)
                .addComponent(jButtonViewCode, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelAreaSubmitCLayout.setVerticalGroup(
            jPanelAreaSubmitCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAreaSubmitCLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAreaSubmitCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldCFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelectCFile)
                    .addComponent(jButtonViewCode))
                .addGap(27, 27, 27))
        );

        jTableResultTest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test Number", "Description", "Output File", "Output Expected", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableResultTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultTestMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableResultTest);

        jButtonVerifyResult.setText("Verify New Result");
        jButtonVerifyResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerifyResultActionPerformed(evt);
            }
        });

        jPanelAreaAtividade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelAreaAtividade.setMinimumSize(new java.awt.Dimension(232, 144));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Activity Select:");

        jLabelActivitySelected.setBackground(new java.awt.Color(255, 255, 255));
        jLabelActivitySelected.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelActivitySelected.setEnabled(false);
        jLabelActivitySelected.setOpaque(true);

        jTextAreaEnunciado.setEditable(false);
        jTextAreaEnunciado.setColumns(20);
        jTextAreaEnunciado.setRows(5);
        jScrollPane7.setViewportView(jTextAreaEnunciado);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActivitySelected, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelActivitySelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jTableAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        javax.swing.GroupLayout jPanelAreaAtividadeLayout = new javax.swing.GroupLayout(jPanelAreaAtividade);
        jPanelAreaAtividade.setLayout(jPanelAreaAtividadeLayout);
        jPanelAreaAtividadeLayout.setHorizontalGroup(
            jPanelAreaAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaAtividadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAreaAtividadeLayout.setVerticalGroup(
            jPanelAreaAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAreaAtividadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAreaAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelAtvScore.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAtvScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAtvScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAtvScore.setText("0");
        jLabelAtvScore.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Score:");

        javax.swing.GroupLayout jPanelCodingToDoLayout = new javax.swing.GroupLayout(jPanelCodingToDo);
        jPanelCodingToDo.setLayout(jPanelCodingToDoLayout);
        jPanelCodingToDoLayout.setHorizontalGroup(
            jPanelCodingToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCodingToDoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCodingToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAreaSubmitC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAreaAtividade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCodingToDoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabelAtvScore, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVerifyResult)))
                .addContainerGap())
        );
        jPanelCodingToDoLayout.setVerticalGroup(
            jPanelCodingToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCodingToDoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanelAreaAtividade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelAreaSubmitC, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCodingToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22)
                    .addComponent(jLabelAtvScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVerifyResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPaneAlunoPrincipal.addTab("Coding", new javax.swing.ImageIcon(getClass().getResource("/icons/c.png")), jPanelCodingToDo); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel21.setText("Questionário Caraterização");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel23.setText(" do Aluno em Introdução à Programação");

        jButtonIniciarCAP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonIniciarCAP.setText("Iniciar");
        jButtonIniciarCAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarCAPActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextPane1.setText("Com este questionário pretende-se caracterizar o aluno de programação, saber as suas motivações e conhecimentos na área da programação.  ");
        jScrollPane9.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanelCAPLayout = new javax.swing.GroupLayout(jPanelCAP);
        jPanelCAP.setLayout(jPanelCAPLayout);
        jPanelCAPLayout.setHorizontalGroup(
            jPanelCAPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCAPLayout.createSequentialGroup()
                .addGroup(jPanelCAPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCAPLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel23))
                    .addGroup(jPanelCAPLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCAPLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel21))
                    .addGroup(jPanelCAPLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButtonIniciarCAP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanelCAPLayout.setVerticalGroup(
            jPanelCAPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCAPLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonIniciarCAP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPaneAlunoPrincipal.addTab("<html>Student<br>Programming</html>", new javax.swing.ImageIcon(getClass().getResource("/icons/imgCAP.png")), jPanelCAP); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel17.setText("Cognitive Ability Test");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel18.setText("Programming Skills");

        jButtonStarTest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonStarTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/system-run-3.png"))); // NOI18N
        jButtonStarTest.setText("Start");
        jButtonStarTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonStarTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonStarTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStarTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(jButtonStarTest, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jLabel18))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel17)))
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(jButtonStarTest, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel17)
                    .addGap(33, 33, 33)
                    .addComponent(jLabel18)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelVEspacialLayout = new javax.swing.GroupLayout(jPanelVEspacial);
        jPanelVEspacial.setLayout(jPanelVEspacialLayout);
        jPanelVEspacialLayout.setHorizontalGroup(
            jPanelVEspacialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVEspacialLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanelVEspacialLayout.setVerticalGroup(
            jPanelVEspacialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVEspacialLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPaneAlunoPrincipal.addTab("<html>Programming<br>Skills</html>", new javax.swing.ImageIcon(getClass().getResource("/icons/vEspacial.png")), jPanelVEspacial); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setText("Parson Problems");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("You must put the instructions in the correct order.");

        jButtonStartPProblems.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonStartPProblems.setText("Start");
        jButtonStartPProblems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartPProblemsActionPerformed(evt);
            }
        });

        jPanelParsonProblemsArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane14.setViewportView(jList1);

        jList2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane15.setViewportView(jList2);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Drag from Here");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Construct your solution");

        jButtonPPValidate.setText("Validate Solution");
        jButtonPPValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPPValidateActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Select Problem:");

        jComboBoxParsonProblems.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxParsonProblems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxParsonProblems.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxParsonProblemsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanelParsonProblemsAreaLayout = new javax.swing.GroupLayout(jPanelParsonProblemsArea);
        jPanelParsonProblemsArea.setLayout(jPanelParsonProblemsAreaLayout);
        jPanelParsonProblemsAreaLayout.setHorizontalGroup(
            jPanelParsonProblemsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParsonProblemsAreaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelParsonProblemsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParsonProblemsAreaLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelParsonProblemsAreaLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(63, 63, 63)
                        .addComponent(jComboBoxParsonProblems, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParsonProblemsAreaLayout.createSequentialGroup()
                .addGroup(jPanelParsonProblemsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParsonProblemsAreaLayout.createSequentialGroup()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParsonProblemsAreaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPPValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelParsonProblemsAreaLayout.setVerticalGroup(
            jPanelParsonProblemsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParsonProblemsAreaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelParsonProblemsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxParsonProblems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelParsonProblemsAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelParsonProblemsAreaLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15))
                    .addGroup(jPanelParsonProblemsAreaLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPPValidate)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelParsonProblemsLayout = new javax.swing.GroupLayout(jPanelParsonProblems);
        jPanelParsonProblems.setLayout(jPanelParsonProblemsLayout);
        jPanelParsonProblemsLayout.setHorizontalGroup(
            jPanelParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParsonProblemsLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanelParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonStartPProblems, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanelParsonProblemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelParsonProblemsArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelParsonProblemsLayout.setVerticalGroup(
            jPanelParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParsonProblemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParsonProblemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelParsonProblemsLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27))
                    .addComponent(jButtonStartPProblems, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelParsonProblemsArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneAlunoPrincipal.addTab("Parson Problems", new javax.swing.ImageIcon(getClass().getResource("/icons/dragdrop.png")), jPanelParsonProblems); // NOI18N

        jButtonLogout.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoutGrande.png"))); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLogoutLayout = new javax.swing.GroupLayout(jPanelLogout);
        jPanelLogout.setLayout(jPanelLogoutLayout);
        jPanelLogoutLayout.setHorizontalGroup(
            jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoutLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        jPanelLogoutLayout.setVerticalGroup(
            jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoutLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jTabbedPaneAlunoPrincipal.addTab("Logout", new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png")), jPanelLogout); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneAlunoPrincipal))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneAlunoPrincipal)
        );

        setSize(new java.awt.Dimension(1077, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciaLabelTotalAtividade() {
        tabelaTotal.put("jLabelTotalPreActivities", jLabelTotalPreActivities);
        tabelaTotal.put("jLabelTotalBasic", jLabelTotalBasic);
        tabelaTotal.put("jLabelTotalIf", jLabelTotalIf);
        tabelaTotal.put("jLabelTotalLoop", jLabelTotalLoop);
        tabelaTotal.put("jLabelTotalArrays", jLabelTotalArrays);
        tabelaTotal.put("jLabelTotalAdvanced", jLabelTotalAdvanced);
        refreshCalcularTotalParcial();
    }

    private void refreshCalcularTotalParcial() {
        int totalPerfil = calcularTotalParcialPreAtividades(jTablePreAtividadeAluno);
        totalPerfil += calcularTotalParcialAtividades(jTableAtividadesAluno);
        totalPerfil += calcularTotalParcialAtividades(jTableAtividadesAlunoIF);
        totalPerfil += calcularTotalParcialAtividades(jTablePreAtividadeAlunoLoop);
        totalPerfil += calcularTotalParcialAtividades(jTableAtividadesAlunoArrays);
        totalPerfil += calcularTotalParcialAtividades(jTableAtividadesAlunoAdvanced);
        jLabelTotalPerfil.setText("" + totalPerfil);
        alunoAtivo.setPerfil(totalPerfil);
    }
    private void refreshCalcularTotalParcial(String label) {
        int total = alunoAtivo.getPerfil() - Integer.parseInt(tabelaTotal.get(label).getText());
        if (total <0) total = 0;
        int totalPerfil = 0;
        if (label.equals("jLabelTotalPreActivities")) totalPerfil = calcularTotalParcialPreAtividades(jTablePreAtividadeAluno);
        else if (label.equals("jLabelTotalBasic")) totalPerfil = calcularTotalParcialAtividades(jTableAtividadesAluno);
        else if (label.equals("jLabelTotalIf")) totalPerfil = calcularTotalParcialAtividades(jTableAtividadesAlunoIF);
        else if (label.equals("jLabelTotalLoop")) totalPerfil = calcularTotalParcialAtividades(jTablePreAtividadeAlunoLoop);
        else if (label.equals("jLabelTotalArrays")) totalPerfil = calcularTotalParcialAtividades(jTableAtividadesAlunoArrays);
        else if (label.equals("jLabelTotalAdvanced")) totalPerfil = calcularTotalParcialAtividades(jTableAtividadesAlunoAdvanced);
        tabelaTotal.get(label).setText(""+totalPerfil);
        totalPerfil += total;
        jLabelTotalPerfil.setText("" + totalPerfil);
        alunoAtivo.setPerfil(totalPerfil);
    }

    private int calcularTotalParcialPreAtividades(JTable table) {
        ArrayList<NumeroPerfil> t = new ArrayList<>();

        for (int linha = 0; linha < table.getRowCount(); linha++) {
            String nome = table.getValueAt(linha, 0).toString();
            int resultado = Integer.parseInt(table.getValueAt(linha, 2).toString());
            if (nome.equalsIgnoreCase("Punched Holes")) {
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99999, resultado));
            } else if (nome.equalsIgnoreCase("Student Programming")) {
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99998, resultado));
            } else if ((nome.equalsIgnoreCase("Presences"))){
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99991, resultado));
            } else if (nome.length() > 1) {
                try {
                    if (nome.substring(0, 2).equals("PP")) {
                        int id = Integer.parseInt(nome.substring(2, nome.length()));
                        t.add(new NumeroPerfil(alunoAtivo.getNumero(), 80000 + id, resultado));
                    } else if (nome.substring(0, 2).equals("IC")) { //Initial Concepts(IC): Names and Variables, Basic Concepts errors
                        int id = Integer.parseInt(nome.substring(2, nome.length()));
                        t.add(new NumeroPerfil(alunoAtivo.getNumero(), 90000 + id, resultado));
                    }
                } catch (NumberFormatException e) {
                    // Se erro na conversão para inteiro
                }
            } else {
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99990, resultado));
            }
        }

        int r = CalcularResultados.calculoTotalPerfil(t);
        tabelaTotal.get(table.getName()).setText("" + r);
        return r;
    }

    private int calcularTotalParcialAtividades(JTable table) {
        ArrayList<NumeroPerfil> t = new ArrayList<>();
        for (int linha = 0; linha < table.getRowCount(); linha++) {
            String numero = alunoAtivo.getNumero();
            int idatividade = Integer.parseInt(table.getValueAt(linha, 0).toString());
            int resultado = Integer.parseInt(table.getValueAt(linha, 2).toString());
            t.add(new NumeroPerfil(numero, idatividade, resultado));
        }
        int r = CalcularResultados.calculoTotalPerfil(t);
        tabelaTotal.get(table.getName()).setText("" + r);
        return r;
    }

    private void criaPastaCoding() {
        File dir = new File(pathToDocuments + "\\CodingHTProgramming");
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        workdirCodeFile = dir.getPath();
    }

    private void carregaQuestionario() {
        DadosQuestionario dQuestions = new DadosQuestionario(liga);
        tQ = dQuestions.gettQuestionario(liga);
        DadosQuestionario.lerTemasToComboBox(liga, jComboBoxTopics);
        esconderJRadioRespostas();
    }

    private void iniciaMessages() {
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        ResultSetTableModel modelo = UtilBDConsulta.verMessages(liga, alunoAtivo.getNumero(), datacorrente);
        jTableMessagesAluno.setModel(modelo);
        jTableMessagesAluno.getColumnModel().getColumn(0).setMaxWidth(80);
//        jTableMessagesAluno.getColumnModel().getColumn(1).setMaxWidth(100);
        jTableMessagesAluno.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    private void lockChangePass(boolean flag) {
        jTextFieldAlunoLogin.setEditable(false);
        jPasswordFieldAluno.setEditable(flag);
        jPanelLoginPassword.setOpaque(flag);
        jButtonValidationChangePass.setEnabled(flag);
        jPanelLoginPassword.repaint();
    }

    private void lockTabbedPane(boolean flag) {
        jTabbedPaneAlunoPrincipal.setEnabledAt(1, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(2, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(3, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(4, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(5, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(6, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(7, flag);
        jTabbedPaneAlunoPrincipal.setEnabledAt(8, flag);
    }

    private void lockTabbedPaneConfig() {
        ArrayList<Integer> tb = UtilAcesso.getTabsBlock(liga);
        jTabbedPaneAlunoPrincipal.setEnabledAt(1, (tb.get(0) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(2, (tb.get(1) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(3, (tb.get(2) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(4, (tb.get(3) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(5, (tb.get(4) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(6, (tb.get(5) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(7, (tb.get(6) == 1));
        jTabbedPaneAlunoPrincipal.setEnabledAt(8, (tb.get(7) == 1));
    }

    private void iniciaSessao() {
//        ua = new UtilAcesso();
        ua.registaAtivo(liga, alunoAtivo);
        jTextFieldAlunoNumero.setText(alunoAtivo.getNumero());
        jTabbedPaneAlunoPrincipal.setSelectedIndex(1);
        jTextFieldAlunoNome.setText(alunoAtivo.getNome());
        jTextFieldAlunoCurso.setText(alunoAtivo.getCurso());
        jTextFieldAlunoDisciplina.setText(alunoAtivo.getUnidadeCurricular());
        jTextFieldAlunoEmail.setText(alunoAtivo.getEmail());
        jTextFieldAlunoLocalidade.setText(alunoAtivo.getLocalidade());
        if (alunoAtivo.getSexo() == 1) {
            jRadioButtonMasculino.setSelected(true);
        } else {
            jRadioButtonFeminino.setSelected(true);
        }
        Date date = java.sql.Date.valueOf(alunoAtivo.getDataNascimento());
        jDateChooserDataNascimento.setDate(date);
        // Atualizar foto
        BufferedImage img = IOImagem.getImageByNumero(liga, alunoAtivo.getNumero());
        if (img != null) {
            ImageIcon foto = new javax.swing.ImageIcon(img);
            jLabelAlunoFoto.setIcon(foto);
        }
    }

    private void iniciaAtividades() {
//        ResultSetTableModel modelo = UtilBDConsulta.verAtividades(liga);
//        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        ResultSetTableModel modelo = NewUtilBD.verNumberAtividadesAluno(liga);
        jTableAtividades.setModel(modelo);
    }

    public void iniciaPreAtividadesAluno() {
        DefaultTableModel modelo = (DefaultTableModel) jTablePreAtividadeAluno.getModel();
        modelo.setRowCount(0);
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        int total = UtilBDConsulta.totalPresencasPorNumero(liga, alunoAtivo.getNumero(),datacorrente);
        total = (total * 20) / 45;
        if (total >= 0) {
            LocalDate hoje = LocalDate.now();
            Object[] data = {"Presences", hoje, total};
            modelo.addRow(data);
        }
        if (UtilBDConsulta.verificaCAP(liga, alunoAtivo.getNumero(),datacorrente)) {
            DadosPreAtv dados = UtilBDConsulta.verificaCAPDados(liga, alunoAtivo.getNumero(), datacorrente);
            Object[] data = {dados.getNome(), dados.getData(), dados.getScore()};
            modelo.addRow(data);
        }
        if (UtilBDConsulta.verificaTestSpatial(liga, alunoAtivo.getNumero(),datacorrente)) {
            DadosPreAtv dados = UtilBDConsulta.verificaTestSpatialDados(liga, alunoAtivo.getNumero(),datacorrente);
            Object[] data = {dados.getNome(), dados.getData(), dados.getScore()};
            modelo.addRow(data);
        }
        iniciaQuestionariosAluno();
        iniciaParsonProblemsAtividadesAluno();
    }

    public void iniciaQuestionariosAluno() {
        DefaultTableModel modelo = (DefaultTableModel) jTablePreAtividadeAluno.getModel();
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        ArrayList<DadosPreAtv> t = UtilBDConsulta.verificaQuestionarioAluno(liga, alunoAtivo.getNumero(), datacorrente);
        if (t.size() > 0) {
            for (DadosPreAtv dados : t) {
                Object[] data = {"IC" + dados.getNome(), dados.getData(), dados.getScore()};
                modelo.addRow(data);
            }
        }
    }

    public void iniciaParsonProblemsAtividadesAluno() {
        DefaultTableModel modelo = (DefaultTableModel) jTablePreAtividadeAluno.getModel();
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        ArrayList<DadosPreAtv> t = UtilBDConsulta.verificaParsonProblemsDados(liga, alunoAtivo.getNumero(), datacorrente);
        if (t.size() > 0) {
            for (DadosPreAtv dados : t) {
                Object[] data = {dados.getNome(), dados.getData(), dados.getScore()};
                modelo.addRow(data);
            }
        }
    }

    public void iniciaAtividadesAluno() {
//        ResultSetTableModel modelo = UtilBDConsulta.verAtividades(liga, alunoAtivo.getNumero());
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        ResultSetTableModel modelo = UtilBDConsulta.verNewAtividades(liga, alunoAtivo.getNumero(),datacorrente);
        jTableAtividadesAluno.setModel(modelo);
        jTableAtividadesAluno.setDefaultRenderer(Object.class, new CustomRendererColor());

        ArrayList<NumeroPerfil> tr = atualizarPerfilComTabela();
        int r = CalcularResultados.calculoTotalPerfil(tr);
//        UtilBDConsulta.gravaTotalPerfilNumeroAluno(liga, alunoAtivo.getNumero(), r); // Talvez: Fazer ao terminar
        //int perfil = UtilBDConsulta.getPerfilAluno(con, alunoAtivo.getNumero());
        jLabelTotalPerfil.setText("" + r);

    }

    public void iniciaAtividadesCoding() {
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        ArrayList<DadosCoding> tDados = UtilBDConsulta.getDadosCodingNewAtividades(liga, alunoAtivo.getNumero(),datacorrente );
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

    public void iniciaAtividadesCoding(DadosCoding dc) {
        DefaultTableModel modelo3 = (DefaultTableModel) jTableAtividadesAluno.getModel();
        DefaultTableModel modelo4 = (DefaultTableModel) jTableAtividadesAlunoIF.getModel();
        DefaultTableModel modelo5 = (DefaultTableModel) jTablePreAtividadeAlunoLoop.getModel();
        DefaultTableModel modelo6 = (DefaultTableModel) jTableAtividadesAlunoArrays.getModel();
        DefaultTableModel modelo7 = (DefaultTableModel) jTableAtividadesAlunoAdvanced.getModel();
        
        String descricao = dc.getDescricao();
        LocalDate data = dc.getData();
        int resultado = dc.getResultado();
        Object[] dados = {descricao, data, resultado};
        if (descricao.charAt(2) == '3') { //jTableAtividadesAluno
            modelo3.addRow(dados);
            refreshCalcularTotalParcial("jLabelTotalBasic");
        } else if (descricao.charAt(2) == '4') { //jTableAtividadesAlunoIF
            modelo4.addRow(dados);
            refreshCalcularTotalParcial("jLabelTotalIf");
        } else if (descricao.charAt(2) == '5') { //jTablePreAtividadeAlunoLoop
            modelo5.addRow(dados);
            refreshCalcularTotalParcial("jLabelTotalLoop");
        } else if (descricao.charAt(2) == '6') { //jTableAtividadesAlunoArrays
            modelo6.addRow(dados);
            refreshCalcularTotalParcial("jLabelTotalArrays");
        } else if (descricao.charAt(2) == '7') { // jTableAtividadesAlunoAdvanced
            modelo7.addRow(dados);
            refreshCalcularTotalParcial("jLabelTotalAdvanced");
        } else {                                        //Qualquer outro jTableAtividadesAluno
            modelo3.addRow(dados);
            refreshCalcularTotalParcial("jLabelTotalBasic");
        }

    }

    private ArrayList<NumeroPerfil> atualizarPerfilComTabela() {
        ArrayList<NumeroPerfil> t = new ArrayList<>();
        for (int linha = 0; linha < jTableAtividadesAluno.getRowCount(); linha++) {
            String numero = alunoAtivo.getNumero();
            int idatividade = Integer.parseInt(jTableAtividadesAluno.getValueAt(linha, 0).toString());
            int resultado = Integer.parseInt(jTableAtividadesAluno.getValueAt(linha, 2).toString());
            t.add(new NumeroPerfil(numero, idatividade, resultado));
        }
        // Visualização Espacial idatividade int 99999 / CAP 99998
        for (int linha = 0; linha < jTablePreAtividadeAluno.getRowCount(); linha++) {
            String nome = jTablePreAtividadeAluno.getValueAt(linha, 0).toString();
            int resultado = Integer.parseInt(jTablePreAtividadeAluno.getValueAt(linha, 2).toString());
            if (nome.equalsIgnoreCase("Punched Holes")) {
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99999, resultado));
            } else if (nome.equalsIgnoreCase("Student Programming")) {
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99998, resultado));
            } else if (nome.length() > 1) {
                if (nome.substring(0, 2).equals("PP")) { // Parson Problems
                    int id = Integer.parseInt(nome.substring(2, nome.length()));
                    t.add(new NumeroPerfil(alunoAtivo.getNumero(), 80000 + id, resultado));
                } else if (nome.substring(0, 2).equals("IC")) { //Initial Concepts(IC): Names and Variables, Basic Concepts errors
                    int id = Integer.parseInt(nome.substring(2, nome.length()));
                    t.add(new NumeroPerfil(alunoAtivo.getNumero(), 90000 + id, resultado));
                }
            } else {
                t.add(new NumeroPerfil(alunoAtivo.getNumero(), 99990, resultado));
            }
        }

        return t;
    }

    private void refreshIniciaTabelaAtividades(JTable table, String nome, int resultado) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        LocalDate hoje = LocalDate.now();
        Object[] data = {nome, hoje, resultado};
        modelo.addRow(data);
    }

    private void iniciaAtividadesMem() {    // Ler atividades coding
        tabelaAtividades = UtilBDConsulta.lerTodasAtividades(liga);
        tabelaAtividadesPP = UtilBDConsulta.lerTodasAtividadesPP(liga);
    }


    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        jButtonLogin.setEnabled(false);
        String login = jTextFieldUtilizador.getText();
        char[] temp_pwd = jPasswordField1.getPassword();
        String pwd = String.copyValueOf(temp_pwd);

        if (ValidaLogin.validaLogin(liga, login, pwd)) {
            alunoAtivo = UtilBDConsulta.getAlunoLogin(liga, login);
            // testar se está ativo
            ua = new UtilAcesso();
            if (ua.testarAtivo(liga, alunoAtivo)) {
                JOptionPane.showMessageDialog(null, "You have logging Active", "UnSuccess",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                lockTabbedPaneConfig();
                CursorToolkit.startWaitCursor(jPanelLogin.getRootPane());
                iniciaSessao();
                iniciaMessages();
                calculaPresencaAluno();  // Coloca na Tabela PreAtividades o valor de presencas
                iniciaPreAtividadesAluno();
//                iniciaAtividadesAluno();
                iniciaAtividadesCoding();
                iniciaAtividades();
                iniciaAtividadesMem();
                carregaQuestionario();
                iniciaLabelTotalAtividade();
                testGcc = CodeInspection.checkInstallGcc(); // Teste se gcc instalado
                if (testGcc != 0){
                    JOptionPane.showMessageDialog(rootPane, "To use Coding it is necessary to install a gcc compiler");
                    jTabbedPaneAlunoPrincipal.setEnabledAt(5, false);
                }
                CursorToolkit.stopWaitCursor(jPanelLogin.getRootPane());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login failed!", "Failed!!",
                    JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void calculaPresencaAluno(){
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        int total = UtilBDConsulta.totalPresencasPorNumero(liga, alunoAtivo.getNumero(), datacorrente);
        total = (total * 20) / 45;
        refreshIniciaTabelaAtividades(jTablePreAtividadeAluno, "Presences", total);
    }
    
    private void jLabelAlunoFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAlunoFotoMouseClicked
//        String foto = "anonimo1.jpg";
//        String numero = jTextFieldAlunoNumero.getText();
//        JFileChooser chooser = new JFileChooser();
//        chooser.setCurrentDirectory(new File("./src/Fotos"));
//        int returnVal = chooser.showOpenDialog(null);
//        fileFoto = null;
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            fileFoto = chooser.getSelectedFile();
//            foto = fileFoto.getName();
//            IOImagem.imageWrite(con, fileFoto, numero);
//        }
//        jLabelAlunoFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/" + foto)));
//        this.repaint();
    }//GEN-LAST:event_jLabelAlunoFotoMouseClicked

    private void jButtonChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangePasswordActionPerformed
        lockChangePass(true);
        jTextFieldAlunoLogin.setText(alunoAtivo.getNumero());
    }//GEN-LAST:event_jButtonChangePasswordActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         if (alunoAtivo != null) {
            iniciaLabelTotalAtividade();
            UtilBDConsulta.gravaTotalPerfilNumeroAluno(liga, alunoAtivo.getNumero(), alunoAtivo.getPerfil());
            ua.registaAcesso(liga, alunoAtivo);
            ua.apagaAtivo(liga, alunoAtivo);
        }        
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButtonValidationChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidationChangePassActionPerformed
        String login = jTextFieldAlunoLogin.getText();
        char[] temp_pwd = jPasswordFieldAluno.getPassword();
        String pwd = String.copyValueOf(temp_pwd);

        if (ValidaLogin.validaLogin(liga, login, pwd)) {
            jDialogChangePassword.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Current Password INCORRECT!", "Failed!!",
                    JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButtonValidationChangePassActionPerformed

    private void jButtonNewPassConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPassConfirmationActionPerformed
        char[] new_pwd = jPasswordFieldNewPassword.getPassword();
        String newpwd = ValidaLogin.codifica(String.copyValueOf(new_pwd));
        UtilBDConsulta.alunoChangePassword(liga, alunoAtivo, newpwd);
        jDialogChangePassword.setVisible(false);
        jPasswordFieldAluno.setText("");
        jTextFieldAlunoLogin.setText("");
        lockChangePass(false);
    }//GEN-LAST:event_jButtonNewPassConfirmationActionPerformed

    private void jButtonSaveChangedInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChangedInfActionPerformed
        byte sexo = (byte) (jRadioButtonMasculino.isSelected() ? 1 : 0);
        String email = jTextFieldAlunoEmail.getText();
        String localidade = jTextFieldAlunoLocalidade.getText();
        ChooserData data = new ChooserData(jDateChooserDataNascimento);
        LocalDate dataNascimento = LocalDate.of(data.getAno(), data.getMes(), data.getDia());
        alunoAtivo.setEmail(email);
        alunoAtivo.setSexo(sexo);
        alunoAtivo.setLocalidade(localidade);
        alunoAtivo.setDataNascimento(dataNascimento);
        UtilBDConsulta.alunoAtualizaSeusDados(liga, alunoAtivo);
        JOptionPane.showMessageDialog(null, "Information Saved!", "Update Information",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonSaveChangedInfActionPerformed

    private void iniciaCoding(int idAtividade, String nome) {
        String enunciado = UtilBDConsulta.getDadosdAtividades(liga, idAtividade);
        String filenametxt = nome + "txt";
        String filenamec = nome + "c";
        String content;
//        ArrayList<String> question = CodeInspection.pesquisaCod("Question",nome);
        ArrayList<String> program = CodeInspection.pesquisaCod("Program", nome);
//        ArrayList<String> input = CodeInspection.pesquisaCod("Input",nome);
//        ArrayList<String> output = CodeInspection.pesquisaCod("Output",nome);

        jTextAreaCode.setText("");
        for (String s : program) {
            jTextAreaCode.append(s);
        }
    }

    private void killProcess() {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("taskkill /IM acrord32.exe");
        } catch (IOException ex) {
            Logger.getLogger(AppAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        int id = Integer.parseInt(modelo.getValueAt(0, 0).toString());
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

        AtividadeConf atividade = new AtividadeConf(id, numberAct, data,
                textActivity, nInput, output, nTest, codeKey);

        return atividade;
    }

    private void mostraAtividadeAluno(String numero) {
//        ResultSetTableModel modelo = NewUtilBD.verAtividadesNumber(liga, numero);
//        atividadeConfActive = carregaAtividade(modelo);
        atividadeConfActive = tabelaAtividades.get(numero);
//        Date date = java.sql.Date.valueOf(atividade.getDataAtividade());
//        jDateChooserDateActivity.setDate(date);
        jTextAreaEnunciado.setText(atividadeConfActive.getEnunciado());
    }

    private void jTableAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMouseClicked
        String workingDir = workdirCodeFile;
        int linha = jTableAtividades.getSelectedRow();
        if (evt.getClickCount() == 2) {
            jLabelActivitySelected.setText("");
            jTextAreaEnunciado.setText("");
            jTextFieldCFile.setText("");
            jLabelAtvScore.setText("");
            DefaultTableModel modelo = (DefaultTableModel) jTableResultTest.getModel();
            modelo.setRowCount(0);
            atvActive = jTableAtividades.getValueAt(linha, 0).toString();

            jLabelActivitySelected.setText(atvActive);
            mostraAtividadeAluno(atvActive);
            if (jLabelActivitySelected.getText().isEmpty()) {
                jButtonSelectCFile.setEnabled(false);
            } else {
                jButtonSelectCFile.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jTableAtividadesMouseClicked

    private void jButtonVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerifyActionPerformed
        String code = jTextAreaCode.getText();
        String nome = jLabelSelectedActivity.getText();
        int n = 0; // Conta acertos
        int total = 0;
        // Cria ficheiro ExNumero.c
//        String workingDir = System.getProperty("user.dir") + "\\IFB";
        String workingDir = workdirCodeFile;
        String pathfilename = workingDir + "\\" + nome + ".c";
        String filename = nome + ".c";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathfilename))) {
//            for (String linhas : program) {
            bw.write(code);
            bw.close();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CursorToolkit.startWaitCursor(jDialogCoding.getRootPane());
        CodeInspection.CompileCprog(filename, workingDir);

        try {
            File file = new File(workingDir + "\\error.txt");
//            System.out.print("Caminho: "+file.getAbsolutePath());
//            System.out.println("Error.txt exist: "+file.exists()+ " tamanho: "+file.length());
            File filex = new File(workingDir + "\\" + nome);
//             System.out.print("Caminho: "+filex.getAbsolutePath());
//            System.out.println(nome + " File exist: "+filex.exists()+ " tamanho: "+filex.length());
            if (file.length() == 0) {
//            if (filex.exists()) {
                // 1. run C program
//                Process proc = Runtime.getRuntime().exec("C:\\_EstudosInvestigacao\\ExTestePeduca\\IFB\\Ex003");
                Process proc = Runtime.getRuntime().exec(workingDir + "\\" + nome);
                InputStream in = proc.getInputStream();
                String result = CodeInspection.readFromAlunoProc(in);
                ArrayList<String> output = CodeInspection.pesquisaCod("Output", nome);
                ArrayList<String> outputResult = CodeInspection.lerValoresString(result);
                ArrayList<String> outputFinal = CodeInspection.lerValoresAList(output);
                total = outputFinal.size();
//                System.out.println("Result: "+result);
//                System.out.println("outputResult: "+outputResult.toString());
//                System.out.println("outputFinal: "+outputFinal.toString());

                if ((outputFinal.size() > 0) && (outputResult.size() > 0)) {
                    for (int i = 0; i < outputFinal.size(); i++) {
                        if (i < outputResult.size()) {
                            int index = outputFinal.get(i).indexOf(outputResult.get(i));
                            if (index >= 0) {
                                n++;
                            }
                        } else {
                            break;
                        }
                    }
                }
//                System.out.println("Total: " + outputFinal.size() + " Total Acertos: " + n);
//                System.out.println("OutPut Final ---");
//                System.out.println(""+outputFinal.toString());
//                System.out.println("OutPut Result ---");
//                System.out.println(""+outputResult.toString());
                colocaResultsTable(outputResult, outputFinal);
                jDialogCodeResult.setLocationRelativeTo(this);
                jDialogCoding.setAlwaysOnTop(false);
                jDialogCodeResult.setVisible(true);
                // Janela com resultados ********
//                jTextAreaVerifyResult.setText("");
//                jTextAreaVerifyResult.append("Total: " + outputFinal.size() + " Total Acertos: " + n + "\n");
//                jTextAreaVerifyResult.append("OutPut Final --------\n");
//                jTextAreaVerifyResult.append("" + outputFinal.toString() + "\n");
//                jTextAreaVerifyResult.append("OutPut Result -------\n");
//                jTextAreaVerifyResult.append("" + outputResult.toString() + "\n");
//                jDialogVerifyResult.setVisible(true);

                // FIM Janela com resultados ********
            } else {
//                JOptionPane.showMessageDialog(rootPane, "Code error ...", "Code Error", 2);
//                System.out.println("Codigo com erros ...");
                if (file.exists()) {
                    String content = new String(Files.readAllBytes(Paths.get(workingDir + "\\error.txt")));
                    jTextAreaCodeError.setText(content);
                    jDialogCodeError.setVisible(true);
                }
            }
            CursorToolkit.stopWaitCursor(jDialogCoding.getRootPane());
        } catch (Exception e) {
            System.out.println("Erro execute...");
            e.printStackTrace();
        }
        // Calcular resultado em função de acertos    
        int idAtividade = Integer.parseInt(jLabelIDAtividade.getText());
        LocalDate dataAtividade = LocalDate.now();
        int resultadoAtividade = CalcularResultados.calculoSimples(total, n, 200);
        UtilBDConsulta.gravarAtividadeCodeResultadoAluno(liga, idAtividade, dataAtividade, code, resultadoAtividade, alunoAtivo);

//        this.iniciaAtividadesAluno();
        DadosCoding dc = new DadosCoding(jLabelActivitySelected.getText(), resultadoAtividade);
        iniciaAtividadesCoding(dc);
//        refreshCalcularTotalParcial();
    }//GEN-LAST:event_jButtonVerifyActionPerformed

    private void colocaResultsTable(ArrayList<String> outputResult, ArrayList<String> outputFinal) {
        DefaultTableModel modelo = (DefaultTableModel) jTableCodeResult.getModel();
        modelo.setRowCount(0);
        int posLinha = 0;
        for (String linha : outputFinal) {
            Object[] rowData = {linha, "", ""};
            modelo.addRow(rowData);
            posLinha++;
        }
        int novaLinha = 0;
        for (String linha : outputResult) {
            Object[] rowData = {"", linha, ""};
            if (novaLinha < posLinha) {
                jTableCodeResult.setValueAt(linha, novaLinha, 1);
            } else {
                modelo.addRow(rowData);
            }
            novaLinha++;
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String c1 = jTableCodeResult.getValueAt(i, 0).toString();
            String c2 = jTableCodeResult.getValueAt(i, 1).toString();
            if (c1.equals(c2)) {
                jTableCodeResult.setValueAt("1", i, 2);
            } else {
                jTableCodeResult.setValueAt("0", i, 2);
            }
        }
    }

    private void jButtonResetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetCodeActionPerformed
        String nomeAtividade = jLabelSelectedActivity.getText();
        int id = Integer.parseInt(jLabelIDAtividade.getText());
        iniciaCoding(id, nomeAtividade);
    }//GEN-LAST:event_jButtonResetCodeActionPerformed

    private void jButtonSaveCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCodeActionPerformed
        String code = jTextAreaCode.getText();
        String nome = jLabelSelectedActivity.getText();
        int idAtividade = Integer.parseInt(jLabelIDAtividade.getText());
        LocalDate dataAtividade = LocalDate.now();

        UtilBDConsulta.gravarAtividadeCodeAluno(liga, idAtividade, dataAtividade, code, alunoAtivo);
        JOptionPane.showMessageDialog(rootPane, "Code Saved", "Information", 1);
    }//GEN-LAST:event_jButtonSaveCodeActionPerformed

    private void jTabbedPaneAlunoPrincipalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneAlunoPrincipalStateChanged
        selectedIndexAtividade = jTabbedPaneAlunoPrincipal.getSelectedIndex(); // Não estou a utilizar
        if (selectedIndexAtividade == 4) {
            if (necessitaAtualizarPre) {
                iniciaPreAtividadesAluno();
                necessitaAtualizarPre = false;
            }
            if (necessitaAtualizarAtv) {
                // iniciaAtividadesAluno()
                iniciaAtividadesCoding();
                necessitaAtualizarAtv = false;

            }
        }
    }//GEN-LAST:event_jTabbedPaneAlunoPrincipalStateChanged

    private void jButtonStarTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStarTestActionPerformed
        // Verificar se ja fez teste
//        if (UtilBDConsulta.verificaTestSpatial(liga, alunoAtivo.getNumero())) {
//            JOptionPane.showMessageDialog(jPanelVEspacial, "Test Done", "Cognitive Test", JOptionPane.INFORMATION_MESSAGE);
//        } else {
            this.add(new AtividadeVEspacial());
            DadosVEspacial dados = new DadosVEspacial(con, liga, alunoAtivo);
            necessitaAtualizarPre = true;
//        }
    }//GEN-LAST:event_jButtonStarTestActionPerformed

    private void jButtonSelectCFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectCFileActionPerformed
        jButtonVerifyResult.setEnabled(true);
        JFileChooser jFileChooser1 = new JFileChooser();
//        jFileChooser1.setCurrentDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
        jFileChooser1.setCurrentDirectory(new File(workdirCodeFile));
//        jFileChooser1.addChoosableFileFilter(new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                if (f.isDirectory()) {
//                    return true;
//                } else {
//                    return f.getName().toLowerCase().endsWith(".c");
//                }
//            }
//
//            @Override
//            public String getDescription() {
//                return "C Files (*.c)";
//            }
//        });

        FileNameExtensionFilter filter = new FileNameExtensionFilter("C Files (*.c)", "*.c", "c");
        jFileChooser1.setFileFilter(filter);

        jFileChooser1.showDialog(this, "Abrir");

        if (jFileChooser1.getApproveButtonText().equals("Abrir")) {
            File file = jFileChooser1.getSelectedFile();
            if (file != null) {
                codeFile = file.getName();
                pathCodeFile = file.getAbsolutePath();
                workdirCodeFile = file.getParent();
                jTextFieldCFile.setText(codeFile);
            }
        }
    }//GEN-LAST:event_jButtonSelectCFileActionPerformed

    private void criaFileTemp(String file, String inf) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.print(inf);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppAluno.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro! Cria File Temp....");
        } finally {
            writer.close();
        }
    }

    private String stringP1P2(String texto, String marca, int p) {
        String in = "";
        String out = "";
        int fim = texto.indexOf(marca, 0);
        if (fim >= 0) {
            in = texto.substring(0, fim);
            out = texto.substring(fim + 3);
        }
        return (p == 1 ? in : out);

    }

    private void jButtonVerifyResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerifyResultActionPerformed
        jButtonVerifyResult.setEnabled(false);
        int nCorrect = 0;
        int score = 0;
        String number = atividadeConfActive.getNumeroAtv();
        int input = atividadeConfActive.getnInput();

        DefaultTableModel modelo = (DefaultTableModel) jTableResultTest.getModel();
        modelo.setRowCount(0);

        String workingDir = workdirCodeFile;
        File dir = new File(workingDir);

        String pathfilename = pathCodeFile; //        String pathfilename = workingDir + "\\" + codeFile;
        String filename = codeFile;

        CursorToolkit.startWaitCursor(jPanelCodingToDo.getRootPane());
        CodeInspection.CompileCprog(filename, workingDir);

        try {
            File file = new File(workingDir + "\\error.txt");
            String nomeExe = codeFile.substring(0, codeFile.length() - 2);
            File filex = new File(workingDir + "\\" + codeFile);

            if (file.length() == 0) {
                // Test Compilation Sucess
                Object[] data = {0, "Compilation Error", "", "", "Sucess"};
                modelo.addRow(data);
                if (input > 0) {
                    for (int nv = 0; nv < input; nv++) {

                        String inputFile = workingDir + "\\in.txt";
                        String in = stringP1P2(atividadeConfActive.getOutput().get(nv), "<i>", 1);

                        criaFileTemp(inputFile, in);

                        String outputFile = workingDir + "\\out.txt";
                        String resultFile = workingDir + "\\res.txt";
                        String out = stringP1P2(atividadeConfActive.getOutput().get(nv), "<i>", 2);

                        criaFileTemp(resultFile, out);

                        String command = "cmd /C " + nomeExe + " < " + inputFile + " > " + outputFile;
                        Process p = Runtime.getRuntime().exec(command, null, dir);
                        p.waitFor();

                        // Melhorar comparação 
                        String data2 = new Scanner(new File(outputFile)).useDelimiter("\\Z").next();
                        String data3 = new Scanner(new File(resultFile)).useDelimiter("\\Z").next();
                        
//                        System.out.println("data2: "+data2);
//                        System.out.println("data3: "+data3);
//                        System.out.println("Equals: "+data2.equals(data3));
//                        if (CompareFiles.compareFiles(outputFile, resultFile)) {
                        if (data2.trim().equals(data3.trim())) {
                            data[0] = nv;
                            data[1] = "Test Input";
                            data[2] = data2;
                            data[3] = data3;
                            data[4] = "Correct";
                            modelo.addRow(data);
                            nCorrect++;
                        } else {
                            data[0] = nv;
                            data[1] = "Test Input";
                            data[2] = data2;
                            data[3] = data3;
                            data[4] = "Fail";
                            modelo.addRow(data);
                        }
                        File file1 = new File(outputFile);
                        file1.delete();
                        File file2 = new File(resultFile);
                        file2.delete();
                    }
                } else {
                    Process p = Runtime.getRuntime().exec("cmd /C " + nomeExe + " > out" + number + ".txt", null, dir);
                }

            } else {
                Object[] data = {0, "Compilation Error", "", "", "Fail"};
                modelo.addRow(data);
            }
            CursorToolkit.stopWaitCursor(jPanelCodingToDo.getRootPane());
        } catch (Exception e) {
            System.out.println("Error Compilation ...");
            e.printStackTrace();
        }
        score = (20 / input) * nCorrect;
        jLabelAtvScore.setText("" + score);
        String codigo = "";
        try {
            codigo = CodeInspection.readFileAsString(pathfilename);
        } catch (Exception ex) {
            Logger.getLogger(AppAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        compareCodeKeys(pathfilename, modelo);
        UtilBDConsulta.gravaResultadoNewAtividadeAluno(liga, alunoAtivo.getNumero(), atividadeConfActive.getIdAtividade(), score, codigo);
        // Atualizar
//        iniciaAtividadesAluno();
        DadosCoding dc = new DadosCoding(jLabelActivitySelected.getText(), score);
        iniciaAtividadesCoding(dc);

//        refreshCalcularTotalParcial();
        if (score < 14) {
            UtilBDConsulta.gravaSugestaoQuestionarioAluno(liga, jLabelActivitySelected.getText(), alunoAtivo.getNumero(), score);
            iniciaMessages();
        }

        JOptionPane.showMessageDialog(jPanelCodingToDo, "Result Saved");
        necessitaAtualizarAtv = true;
    }//GEN-LAST:event_jButtonVerifyResultActionPerformed

    private void compareCodeKeys(String pathfile, DefaultTableModel modelo) {
        if (atividadeConfActive.getnTest() > 0) {
            ArrayList<String> codeKeys = atividadeConfActive.getCommentKey();
            String coding = NewUtilBD.getResolucaoAtividade(liga, atividadeConfActive.getNumeroAtv());
            Object[] data = new Object[5];
            int test = 0;
            for (String s : codeKeys) {
                try {
                    String comment = stringP1P2(s, "<c>", 1);
                    String key = stringP1P2(s, "<c>", 2);
                    if (CodeInspection.searchKeys(pathfile, key) > 0) {
                        data[0] = test;
                        data[1] = comment;
                        data[2] = "";
                        data[3] = "";
                        data[4] = "Check";
                    } else {
                        data[0] = test;
                        data[1] = comment;
                        data[2] = "";
                        data[3] = "";
                        data[4] = "Fail";
                    }
                    modelo.addRow(data);
                } catch (IOException ex) {
                    Logger.getLogger(AppAluno.class.getName()).log(Level.SEVERE, null, ex);
                }
                test++;
            }
        }
    }

    private void jButtonIniciarCAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarCAPActionPerformed
        // Verificar se ja fez teste
        String datacorrente = LocalDate.of(anoletivo, Month.SEPTEMBER, 1).toString();
        if (UtilBDConsulta.verificaCAP(liga, alunoAtivo.getNumero(), datacorrente)) {
            JOptionPane.showMessageDialog(jPanelCAP, "Test Done", "Caraterização Aluno Programação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.add(new CaraterizacaoAluno());
            DadosCAP dados = new DadosCAP(liga, alunoAtivo.getNumero());
            necessitaAtualizarPre = true;
        }
    }//GEN-LAST:event_jButtonIniciarCAPActionPerformed

    private void jButtonViewCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewCodeActionPerformed
        try {
            String fileCode = jTextFieldCFile.getText();
//            String workingDir = System.getProperty("user.dir") + "\\CodingHTProgramming";
            String workingDir = workdirCodeFile;
            File dir = new File(workingDir);
            String pathfilename = workingDir + "\\" + fileCode;

            String fileText = new Scanner(new File(pathfilename)).useDelimiter("\\Z").next();
            jTextAreaViewCode.setText(fileText);
            jDialogViewCodeC.setVisible(true);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonViewCodeActionPerformed


    private void jButtonStartActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActivityActionPerformed
        esconderJRadioRespostas();
        jButtonNextQuestion.setEnabled(true);
        int indexCombo = jComboBoxTopics.getSelectedIndex();
        indexResposta = 0;
        totalQuestionario = 0;
        jButtonNextQuestion.setText("Next");
        if (indexCombo > 0) {
            String topic = jComboBoxTopics.getSelectedItem().toString();
            jTextAreaQuestResults.setText("Topic : " + topic + "\n\n");
            // Ler Respostas para cada pergunta do tema
            tPorTema = DadosQuestionario.lerPerguntasPorTemaArray(liga, topic);
            escrevePerguntas(tPorTema, indexResposta);
        } else {
            JOptionPane.showMessageDialog(jPanelActivities, "Select Topic");
        }
    }//GEN-LAST:event_jButtonStartActivityActionPerformed

    private void jButtonNextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextQuestionActionPerformed
        calcularResultadoQuestionario();
        if (jButtonNextQuestion.getText().equals("Next")) {
            indexResposta++;
            escrevePerguntas(tPorTema, indexResposta);
        } else {
            // END
            jButtonNextQuestion.setEnabled(false);
            jDialogViewResult.setLocationRelativeTo(jPanelAreaPergunta);
            jDialogViewResult.setVisible(true);
            gravaQuestionario();
            jTextAreaQuestResults.append("\nTOTAL RESULT: " + totalQuestionario);
            indexResposta = 0;
            jButtonNextQuestion.setText("Next");
            esconderJRadioRespostas();
        }

    }//GEN-LAST:event_jButtonNextQuestionActionPerformed

    private void jComboBoxTopicsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxTopicsPopupMenuWillBecomeInvisible
        indexResposta = 0;
        jButtonNextQuestion.setText("Next");
        jTextAreaQuestion.setText("");
        esconderJRadioRespostas();
    }//GEN-LAST:event_jComboBoxTopicsPopupMenuWillBecomeInvisible

    private void limparQuestionario() {
        jComboBoxTopics.setSelectedIndex(0);
        jTextAreaQuestion.setText("");
        jButtonNextQuestion.setText("Next");
        esconderJRadioRespostas();
        totalQuestionario = 0;
    }

    private void gravaQuestionario() {
        if (totalQuestionario < 0) {
            totalQuestionario = 0;
        } else if (totalQuestionario > 20) {
            totalQuestionario = 20;
        }
        UtilBDConsulta.gravaResultadoQuestionarioAluno(liga, questionAtivo.getTema(), alunoAtivo.getNumero(), respostasQuestion, totalQuestionario);
        if (totalQuestionario < 14) {
            UtilBDConsulta.gravaSugestaoQuestionarioAluno(liga, questionAtivo.getTema(), alunoAtivo.getNumero(), totalQuestionario);
            iniciaMessages();
        }
        // Atualizar work done e perfil
//        iniciaAtividadesAluno();
//        int idTopic = UtilBDConsulta.getIdTopic(liga, questionAtivo.getTema());
        StringBuilder initials = new StringBuilder();
        initials.append("IC");
        initials.append(questionAtivo.getTema().replaceAll("[^0-9]", ""));
        refreshIniciaTabelaAtividades(jTablePreAtividadeAluno, initials.toString(), totalQuestionario);
        refreshCalcularTotalParcial("jLabelTotalPreActivities");
    }

    private void jDialogViewResultWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogViewResultWindowClosing
        JOptionPane.showMessageDialog(jDialogVerifyResult, "Questionaire Saved");
        limparQuestionario();
    }//GEN-LAST:event_jDialogViewResultWindowClosing

    private void jTableMessagesAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMessagesAlunoMouseClicked
        if (evt.getClickCount() == 2) {
            int linha = jTableMessagesAluno.getSelectedRow();
            if (linha >= 0) {
                String texto = jTableMessagesAluno.getValueAt(linha, 1).toString();
                JOptionPane.showMessageDialog(jPanelMessages, texto, "Comments/Suggestion", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTableMessagesAlunoMouseClicked

    private void jTableResultTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultTestMouseClicked
        // Para ver/analisar tabela de resultados numa janela
        int cliques = evt.getClickCount();
        if (cliques == 2) {
            int linha = jTableResultTest.getSelectedRow();
            if (linha >= 0) {
                String description = jTableResultTest.getValueAt(linha, 1).toString();
                String outputFile = jTableResultTest.getValueAt(linha, 2).toString();
                String outputExpected = jTableResultTest.getValueAt(linha, 3).toString();
                String result = jTableResultTest.getValueAt(linha, 4).toString();

                jTextAreaViewCodingResult.setText("--- Description ---\n");
                jTextAreaViewCodingResult.append(description + "\n");
                jTextAreaViewCodingResult.append("--- Output ---\n" + outputFile + "\n");
                jTextAreaViewCodingResult.append("--- Output Expected ---\n" + outputExpected + "\n");
                jTextAreaViewCodingResult.append("--- Result ---\n" + result + "\n");
                jTextAreaViewCodingResult.append("--- END ---\n");

                jDialogViewCodingResult.setLocationRelativeTo(jPanelAreaAtividade);
                jDialogViewCodingResult.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTableResultTestMouseClicked

    private void jButtonStartPProblemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartPProblemsActionPerformed
        jPanelParsonProblemsArea.setVisible(true);
        UtilBDConsulta.readParsonToComboBox(liga, jComboBoxParsonProblems);
    }//GEN-LAST:event_jButtonStartPProblemsActionPerformed

    private void jComboBoxParsonProblemsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxParsonProblemsPopupMenuWillBecomeInvisible
        jButtonPPValidate.setEnabled(true);
        if (jComboBoxParsonProblems.getSelectedIndex() > 0) {
            String problem = jComboBoxParsonProblems.getSelectedItem().toString();
            iniciaParsonProblems(problem);
        } else {
            DefaultListModel list1Model = new DefaultListModel();
            DefaultListModel list2Model = new DefaultListModel();
            jList1.setModel(list1Model);
            jList2.setModel(list2Model);
        }
    }//GEN-LAST:event_jComboBoxParsonProblemsPopupMenuWillBecomeInvisible

    private void jButtonPPValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPPValidateActionPerformed
        if (testGcc == 0) {     // Se estiver ativo compilador de c gcc instalado
            validateRunParsonProblems();
        } else {
            jButtonPPValidate.setEnabled(false);
            String descricao = jComboBoxParsonProblems.getSelectedItem().toString();
            if (!descricao.equals("-- Choose Parson Problem --")) {
                String[] textosolucao = UtilBDConsulta.readParsonSolucao(liga, descricao);
                String[] textoaluno = new String[100];
                String[] textoResultado = new String[100];
                int nLinhas = textosolucao.length;
                double total = 0;
                double parcial = 20.0 / nLinhas;
                int totalLinhasSolucao = jList2.getModel().getSize();
                for (int i = 0; i < totalLinhasSolucao; i++) {
                    textoaluno[i] = String.valueOf(jList2.getModel().getElementAt(i));
                }
                for (int i = 0; i < totalLinhasSolucao; i++) {
                    if ((textoaluno[i].trim()).equals(textosolucao[i].trim())) {
                        textoResultado[i] = textoaluno[i];
                        total = total + parcial;
                    } else {
                        textoResultado[i] = textoaluno[i] + "// INCORRECT";
                    }
                }
                int resultado = (int) Math.round(total);

                String texto = "";
                for (int i = 0; i < totalLinhasSolucao; i++) {
                    texto = texto.concat(textoResultado[i] + "\n");
                }
                jTextAreaResultParsonProblems.setText(texto);
                jTextAreaResultParsonProblems.append("--- RESULTADO: " + resultado + " ---\n");
                jDialogViewResultParsonProblem.setLocationRelativeTo(jPanelParsonProblemsArea);
                jDialogViewResultParsonProblem.setVisible(true);
                // Gravar atividade e resultado
                UtilBDConsulta.gravaResultadoParsonProblem(liga, alunoAtivo.getNumero(), descricao, texto, resultado);
                refreshIniciaTabelaAtividades(jTablePreAtividadeAluno, descricao, resultado);
                refreshCalcularTotalParcial("jLabelTotalPreActivities");
                if (resultado < 14) {
                    UtilBDConsulta.gravaSugestaoQuestionarioAluno(liga, descricao, alunoAtivo.getNumero(), resultado);
                    iniciaMessages();
                }

            }
        }

    }//GEN-LAST:event_jButtonPPValidateActionPerformed

    private void validateRunParsonProblems(){
        // Validar Parson Problems com Run
        jButtonPPValidate.setEnabled(false);
        int score = 0;
        String descricao = jComboBoxParsonProblems.getSelectedItem().toString();
        if (!descricao.equals("-- Choose Parson Problem --")) {
            codeFile = descricao + ".c";
//            String[] textosolucao = UtilBDConsulta.readParsonSolucao(liga, descricao);
            String[] textoaluno = new String[100];
          
            int totalLinhasSolucao = jList2.getModel().getSize();
            String texto = "";
            for (int i = 0; i < totalLinhasSolucao; i++) {
                textoaluno[i] = String.valueOf(jList2.getModel().getElementAt(i));
                texto = texto.concat(textoaluno[i] + "\n");
            }

            atividadePPConfActive = tabelaAtividadesPP.get(descricao);
            
            String number = atividadePPConfActive.getNumeroAtv();
            int input = atividadePPConfActive.getnInput();

            String workingDir = workdirCodeFile;
            File dir = new File(workingDir);
            String pathfilename = workingDir + "\\" + codeFile;
            String filename = codeFile;

            criaFileTemp(pathfilename, texto);

            CursorToolkit.startWaitCursor(jPanelParsonProblemsArea.getRootPane());
            CodeInspection.CompileCprog(filename, workingDir);

            try {
                File file = new File(workingDir + "\\error.txt");
                String nomeExe = codeFile.substring(0, codeFile.length() - 2);
                File filex = new File(workingDir + "\\" + codeFile);

                if (file.length() == 0) {
                    // Test Compilation Sucess

                    if (input > 0) {
                        for (int nv = 0; nv < input; nv++) {

                            String inputFile = workingDir + "\\in.txt";
                            String in = stringP1P2(atividadePPConfActive.getOutput().get(nv), "<i>", 1);

                            criaFileTemp(inputFile, in);

                            String outputFile = workingDir + "\\out.txt";
                            String resultFile = workingDir + "\\res.txt";
                            String out = stringP1P2(atividadePPConfActive.getOutput().get(nv), "<i>", 2);

                            criaFileTemp(resultFile, out);

                            String command = "cmd /C " + nomeExe + " < " + inputFile + " > " + outputFile;
                            Process p = Runtime.getRuntime().exec(command, null, dir);
                            p.waitFor();

                            // Melhorar comparação 
                            String data2 = new Scanner(new File(outputFile)).useDelimiter("\\Z").next();
                            String data3 = new Scanner(new File(resultFile)).useDelimiter("\\Z").next();

                            if (data2.trim().equals(data3.trim())) {
                                // Success
                                score = 20;
                            } else {
                                // Fail
                                score = 0;
                            }
                            File file1 = new File(outputFile);
                            file1.delete();
                            File file2 = new File(resultFile);
                            file2.delete();
                        }
                    } else {
                        Process p = Runtime.getRuntime().exec("cmd /C " + nomeExe + " > out" + number + ".txt", null, dir);
                    }

                } else {
//                    System.out.println("Compilation Error");
                      score = 0;
                }
                CursorToolkit.stopWaitCursor(jPanelParsonProblemsArea.getRootPane());
            } catch (Exception e) {
                System.out.println("Error Compilation ...");
                e.printStackTrace();
            }

            // Gravar atividade e resultado
            UtilBDConsulta.gravaResultadoParsonProblem(liga, alunoAtivo.getNumero(), descricao, texto, score);
            refreshIniciaTabelaAtividades(jTablePreAtividadeAluno, descricao, score);
            refreshCalcularTotalParcial("jLabelTotalPreActivities");

        }

        JOptionPane.showMessageDialog(jPanelParsonProblemsArea, "Result: "+score);

    }

    
    private void jDialogViewResultParsonProblemWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogViewResultParsonProblemWindowClosing
        DefaultListModel list1Model = new DefaultListModel();
        DefaultListModel list2Model = new DefaultListModel();
        jList1.setModel(list1Model);
        jList2.setModel(list2Model);
        jComboBoxParsonProblems.setSelectedIndex(0);
    }//GEN-LAST:event_jDialogViewResultParsonProblemWindowClosing

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        if (alunoAtivo != null) {
            iniciaLabelTotalAtividade();
            UtilBDConsulta.gravaTotalPerfilNumeroAluno(liga, alunoAtivo.getNumero(), alunoAtivo.getPerfil());
            ua.registaAcesso(liga, alunoAtivo);
            ua.apagaAtivo(liga, alunoAtivo);
        }        
        System.exit(0);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jLabelTotalLoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalLoopMouseClicked
        if (evt.getClickCount()==2){    // refresh calculo
            refreshCalcularTotalParcial("jLabelTotalLoop");
        }
    }//GEN-LAST:event_jLabelTotalLoopMouseClicked

    private void jLabelTotalPreActivitiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalPreActivitiesMouseClicked
        if (evt.getClickCount()==2){    // refresh calculo
            refreshCalcularTotalParcial("jLabelTotalPreActivities");
        }
    }//GEN-LAST:event_jLabelTotalPreActivitiesMouseClicked

    private void jLabelTotalBasicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalBasicMouseClicked
        if (evt.getClickCount()==2){    // refresh calculo
            refreshCalcularTotalParcial("jLabelTotalBasic");
        }
    }//GEN-LAST:event_jLabelTotalBasicMouseClicked

    private void jLabelTotalIfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalIfMouseClicked
        if (evt.getClickCount()==2){    // refresh calculo
            refreshCalcularTotalParcial("jLabelTotalIf");
        }
    }//GEN-LAST:event_jLabelTotalIfMouseClicked

    private void jLabelTotalArraysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalArraysMouseClicked
        if (evt.getClickCount()==2){    // refresh calculo
            refreshCalcularTotalParcial("jLabelTotalArrays");
        }
    }//GEN-LAST:event_jLabelTotalArraysMouseClicked

    private void jLabelTotalAdvancedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTotalAdvancedMouseClicked
        if (evt.getClickCount()==2){    // refresh calculo
            refreshCalcularTotalParcial("jLabelTotalAdvanced");
        }
    }//GEN-LAST:event_jLabelTotalAdvancedMouseClicked

    private void setMappings(JList list) {
        ActionMap map = list.getActionMap();
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),
                TransferHandler.getCutAction());
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
                TransferHandler.getCopyAction());
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
                TransferHandler.getPasteAction());

    }

    private DefaultListModel baralharParsonProblems(JList list){
        ListModel<String> model = jList1.getModel();    
        List lista = new ArrayList(model.getSize());
            for (int i = 0; i < model.getSize(); i++) {
                lista.add(model.getElementAt(i));
            }
            Collections.shuffle(lista);
            DefaultListModel model2 = new DefaultListModel();
            for(Object s : lista){
                model2.addElement(s);
            }
            return model2;
    }
    
    private void iniciaParsonProblems(String problem) {

        lh = new ListTransferHandler();

        DefaultListModel list1Model = UtilBDConsulta.readListToJListText(liga, problem);
        
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);      
        jList1.setModel(list1Model);
        list1Model = baralharParsonProblems(jList1);
        jList1.setModel(list1Model);
        
        jList1.setDragEnabled(true);
        jList1.setTransferHandler(lh);
        jList1.setDropMode(DropMode.INSERT);     
        setMappings(jList1);

        DefaultListModel list2Model = new DefaultListModel();

        jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList2.setDragEnabled(true);

        jList2.setModel(list2Model);
        jList2.setTransferHandler(lh);
        jList2.setDropMode(DropMode.INSERT);
        setMappings(jList2);

    }

    private void escrevePerguntas(ArrayList<Questionario> t, int np) {
        if (np < t.size()) {
            Questionario q = t.get(np);
            questionAtivo = new Questionario(q);
            jTextAreaQuestion.setText(q.getPergunta());
            jTextAreaQuestResults.append("QUESTION: " + q.getPergunta() + "\n\n" + "YOUR ANSWERS\n\n");
            ArrayList<Resposta> resposta = q.getRespostas();
            escreveRespostas(resposta, jPanelAreaResposta);
            if (np == t.size() - 1) {
                jButtonNextQuestion.setText("END");
            }
        }
    }

    private void escreveRespostas(ArrayList<Resposta> resposta, JPanel panel) {
        JRadioButton[] tRadio = {null, jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4, jRadioButton5, jRadioButton6,
            jRadioButton7, jRadioButton8, jRadioButton9, jRadioButton10, jRadioButton11, jRadioButton12};
        esconderJRadioRespostas();
        int nr = 1;
        for (Resposta r : resposta) {
//                JRadioButton jRadio = new javax.swing.JRadioButton();
//                jRadio.setBackground(new java.awt.Color(255, 255, 255));
            tRadio[nr].setText(r.getDescricao());
            tRadio[nr].setName("" + r.getValor());
            tRadio[nr].setVisible(true);

            // Acao click Radio para ler valor
//            final int ind = nr;
//            tRadio[nr].addMouseListener(new java.awt.event.MouseAdapter() {
//                public void mouseClicked(java.awt.event.MouseEvent evt) {
//                    int valor = Integer.parseInt(tRadio[ind].getName().trim());
//
//                }
//            });
            nr++;
        }
        jPanelAreaResposta.repaint();

    }

    private void calcularResultadoQuestionario() {
        JRadioButton[] tRadio = {null, jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4, jRadioButton5, jRadioButton6,
            jRadioButton7, jRadioButton8, jRadioButton9, jRadioButton10, jRadioButton11, jRadioButton12};

        for (int i = 1; i <= 12; i++) {
            if (tRadio[i].isSelected()) {
                int valor = Integer.parseInt(tRadio[i].getName().trim());
                totalQuestionario += valor;
                jTextAreaQuestResults.append("" + tRadio[i].getText());
                respostasQuestion += "" + tRadio[i].getText();
                if (valor > 0) {
                    jTextAreaQuestResults.append("\t:\t Correct\n");
                    respostasQuestion += "\t:\t Correct\n";
                } else {
                    jTextAreaQuestResults.append("\t:\t INCORRECT\n");
                    respostasQuestion += "\t:\t INCORRECT\n";
                }
            }
        }
        jTextAreaQuestResults.append("----------------------------------------------------------------\n");
    }

    private void esconderJRadioRespostas() {
        JRadioButton[] tRadio = {null, jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4, jRadioButton5, jRadioButton6,
            jRadioButton7, jRadioButton8, jRadioButton9, jRadioButton10, jRadioButton11, jRadioButton12};
        for (int i = 1; i <= 12; i++) {
            tRadio[i].setSelected(false);
        }
        for (int i = 1; i <= 12; i++) {
            tRadio[i].setVisible(false);
        }
        jPanelAreaResposta.repaint();
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
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppAluno().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDBRemote;
    private javax.swing.ButtonGroup buttonGroupGenero;
    private javax.swing.JButton jButtonChangePassword;
    private javax.swing.JButton jButtonIniciarCAP;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonNewPassConfirmation;
    private javax.swing.JButton jButtonNextQuestion;
    private javax.swing.JButton jButtonPPValidate;
    private javax.swing.JButton jButtonResetCode;
    private javax.swing.JButton jButtonSaveChangedInf;
    private javax.swing.JButton jButtonSaveCode;
    private javax.swing.JButton jButtonSelectCFile;
    private javax.swing.JButton jButtonStarTest;
    private javax.swing.JButton jButtonStartActivity;
    private javax.swing.JButton jButtonStartPProblems;
    private javax.swing.JButton jButtonValidationChangePass;
    private javax.swing.JButton jButtonVerify;
    private javax.swing.JButton jButtonVerifyResult;
    private javax.swing.JButton jButtonViewCode;
    private javax.swing.JComboBox<String> jComboBoxParsonProblems;
    private javax.swing.JComboBox<String> jComboBoxTopics;
    private com.toedter.calendar.JDateChooser jDateChooserDataNascimento;
    private javax.swing.JDialog jDialogChangePassword;
    private javax.swing.JDialog jDialogCodeError;
    private javax.swing.JDialog jDialogCodeResult;
    private javax.swing.JDialog jDialogCoding;
    private javax.swing.JDialog jDialogNewCoding;
    private javax.swing.JDialog jDialogVerifyResult;
    private javax.swing.JDialog jDialogViewCodeC;
    private javax.swing.JDialog jDialogViewCodingResult;
    private javax.swing.JDialog jDialogViewResult;
    private javax.swing.JDialog jDialogViewResultParsonProblem;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelActivitySelected;
    private javax.swing.JLabel jLabelAlunoFoto;
    private javax.swing.JLabel jLabelAtvScore;
    private javax.swing.JLabel jLabelIDAtividade;
    private javax.swing.JLabel jLabelMensagens;
    private javax.swing.JLabel jLabelSelectedActivity;
    private javax.swing.JLabel jLabelTotalAdvanced;
    private javax.swing.JLabel jLabelTotalArrays;
    private javax.swing.JLabel jLabelTotalBasic;
    private javax.swing.JLabel jLabelTotalIf;
    private javax.swing.JLabel jLabelTotalLoop;
    private javax.swing.JLabel jLabelTotalPerfil;
    private javax.swing.JLabel jLabelTotalPreActivities;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelActivities;
    private javax.swing.JPanel jPanelAreaAtividade;
    private javax.swing.JPanel jPanelAreaPergunta;
    private javax.swing.JPanel jPanelAreaResposta;
    private javax.swing.JPanel jPanelAreaSubmitC;
    private javax.swing.JPanel jPanelCAP;
    private javax.swing.JPanel jPanelCodingToDo;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelLoginPassword;
    private javax.swing.JPanel jPanelLogout;
    private javax.swing.JPanel jPanelMessages;
    private javax.swing.JPanel jPanelParsonProblems;
    private javax.swing.JPanel jPanelParsonProblemsArea;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JPanel jPanelVEspacial;
    private javax.swing.JPanel jPanelWorkDone;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordFieldAluno;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButtonDBLocal;
    private javax.swing.JRadioButton jRadioButtonDBRemote;
    private javax.swing.JRadioButton jRadioButtonFeminino;
    private javax.swing.JRadioButton jRadioButtonMasculino;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneAreaQuestion;
    private javax.swing.JScrollPane jScrollPaneAtv;
    private javax.swing.JScrollPane jScrollPaneCoding;
    private javax.swing.JTabbedPane jTabbedPaneAlunoPrincipal;
    private javax.swing.JTable jTableAtividades;
    private javax.swing.JTable jTableAtividadesAluno;
    private javax.swing.JTable jTableAtividadesAlunoAdvanced;
    private javax.swing.JTable jTableAtividadesAlunoArrays;
    private javax.swing.JTable jTableAtividadesAlunoIF;
    private javax.swing.JTable jTableCodeResult;
    private javax.swing.JTable jTableMessagesAluno;
    private javax.swing.JTable jTablePreAtividadeAluno;
    private javax.swing.JTable jTablePreAtividadeAlunoLoop;
    private javax.swing.JTable jTableResultTest;
    private javax.swing.JTextArea jTextAreaCode;
    private javax.swing.JTextArea jTextAreaCodeError;
    private javax.swing.JTextArea jTextAreaEnunciado;
    private javax.swing.JTextArea jTextAreaQuestResults;
    private javax.swing.JTextArea jTextAreaQuestion;
    private javax.swing.JTextArea jTextAreaResultParsonProblems;
    private javax.swing.JTextArea jTextAreaVerifyResult;
    private javax.swing.JTextArea jTextAreaViewCode;
    private javax.swing.JTextArea jTextAreaViewCodingResult;
    private javax.swing.JTextField jTextFieldAlunoCurso;
    private javax.swing.JTextField jTextFieldAlunoDisciplina;
    private javax.swing.JTextField jTextFieldAlunoEmail;
    private javax.swing.JTextField jTextFieldAlunoLocalidade;
    private javax.swing.JTextField jTextFieldAlunoLogin;
    private javax.swing.JTextField jTextFieldAlunoNome;
    private javax.swing.JTextField jTextFieldAlunoNumero;
    private javax.swing.JTextField jTextFieldCFile;
    private javax.swing.JTextField jTextFieldUtilizador;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTree jTreeAtv;
    // End of variables declaration//GEN-END:variables

    ConnectBD liga = null;
    Connection con = null; // Não está utilizado
    int anoletivo = 0;
    Aluno alunoAtivo = null;
    UtilAcesso ua = null;
    File fileFoto = null;

    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;
    JTree tree;
    int testGcc = 0; // verifica a instalação gcc: 0->não instalado
    int selectedIndexAtividade = 0;
    String codeFile = "";
    String pathCodeFile = "";
    String workdirCodeFile = "";
    String pathToDocuments = "";
    String atvActive = "";
    String confActive = "";
    AtividadeConf atividadeConfActive = null;
    AtividadeConf atividadePPConfActive = null;
    boolean necessitaAtualizarAtv = false;
    boolean necessitaAtualizarPre = false;

    Map<String, AtividadeConf> tabelaAtividades = new HashMap<>();
    Map<String, AtividadeConf> tabelaAtividadesPP = new HashMap<>();

    private static boolean testAppAluno = false;

    public static boolean getTestAppAluno() {
        return testAppAluno;
    }

    public static void setTestAppAluno(boolean test) {
        testAppAluno = test;
    }

    ArrayList<Questionario> tQ = new ArrayList<>();
    int indexResposta = 0;
    ArrayList<Questionario> tPorTema = new ArrayList<>();
    int totalQuestionario = 0;
    Questionario questionAtivo = null;
    String respostasQuestion = "";

    ListTransferHandler lh;
    Map<String, JLabel> tabelaTotal = new HashMap<>();
}
