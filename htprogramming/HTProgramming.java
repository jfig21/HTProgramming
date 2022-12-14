/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htprogramming;


//import com.lambdaworks.crypto.SCryptUtil;
import com.lambdaworks.crypto.SCryptUtil;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.DadosAdmin;



/**
 *
 * @author Utilizador
 */
public class HTProgramming extends javax.swing.JFrame {

    private static JFrame mainWindow = null; 
    
    /**
     * Creates new form HTProgramming
     */
    public HTProgramming() {
        initComponents();
        
        try {
//            Image i = ImageIO.read(getClass().getResource("/icons/logoHelpPro.png"));
//            Image i = ImageIO.read(getClass().getResource("/icons/logoIcon.png"));
            Image i = ImageIO.read(getClass().getResource("/icons/logoCodingC.jpg"));
            this.setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(HTProgramming.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static JFrame getMainFrame(){
        return mainWindow;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAdminLogin = new javax.swing.JDialog();
        jPanelAdminLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAdmin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldAdmin = new javax.swing.JPasswordField();
        jButtonLoginAdmin = new javax.swing.JButton();
        jButtonStudent = new javax.swing.JButton();
        jButtonAdmin = new javax.swing.JButton();

        jDialogAdminLogin.setLocationByPlatform(true);
        jDialogAdminLogin.setMinimumSize(new java.awt.Dimension(490, 240));
        jDialogAdminLogin.setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Admin");

        jTextFieldAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PassWord:");

        jPasswordFieldAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonLoginAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLoginAdmin.setText("Login");
        jButtonLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminLoginLayout = new javax.swing.GroupLayout(jPanelAdminLogin);
        jPanelAdminLogin.setLayout(jPanelAdminLoginLayout);
        jPanelAdminLoginLayout.setHorizontalGroup(
            jPanelAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLoginLayout.createSequentialGroup()
                .addGap(42, 60, Short.MAX_VALUE)
                .addGroup(jPanelAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jTextFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLoginLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPasswordFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonLoginAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jPanelAdminLoginLayout.setVerticalGroup(
            jPanelAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLoginLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanelAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLoginLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButtonLoginAdmin))
        );

        javax.swing.GroupLayout jDialogAdminLoginLayout = new javax.swing.GroupLayout(jDialogAdminLogin.getContentPane());
        jDialogAdminLogin.getContentPane().setLayout(jDialogAdminLoginLayout);
        jDialogAdminLoginLayout.setHorizontalGroup(
            jDialogAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAdminLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogAdminLoginLayout.setVerticalGroup(
            jDialogAdminLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAdminLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HTProgramming");

        jButtonStudent.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users200.png"))); // NOI18N
        jButtonStudent.setText("Student");
        jButtonStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStudentActionPerformed(evt);
            }
        });

        jButtonAdmin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adminUser107.png"))); // NOI18N
        jButtonAdmin.setText("Admin");
        jButtonAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButtonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStudentActionPerformed
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
        jButtonAdmin.setEnabled(false);
        jButtonStudent.setEnabled(false);
//        this.setVisible(false);
    }//GEN-LAST:event_jButtonStudentActionPerformed
 
    private String codifica(String originalPassword){
        String generatedSecuredPasswordHash = SCryptUtil.scrypt(originalPassword, 16, 16, 16);
        return generatedSecuredPasswordHash;
    }
    
    private void jButtonLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginAdminActionPerformed

        String login = jTextFieldAdmin.getText();
        char[] temp_pwd = jPasswordFieldAdmin.getPassword();
        String pwd = String.copyValueOf(temp_pwd);

        if (validaLogin(login, pwd)) {
            JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
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
            jDialogAdminLogin.setVisible(false);
            jButtonAdmin.setEnabled(false);
            jButtonStudent.setEnabled(false);
//            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Login failed!", "Failed!!",
                JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonLoginAdminActionPerformed

    private void jButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdminActionPerformed
        jDialogAdminLogin.setVisible(true);
    }//GEN-LAST:event_jButtonAdminActionPerformed

    
    
    private boolean validaLogin(String login, String pass){
        String passGuardada = DadosAdmin.passAdmin;
        boolean matched = false;
        
        if (!"".equals(passGuardada)){
            matched = SCryptUtil.check(pass, passGuardada);
        }
        return matched;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HTProgramming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HTProgramming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HTProgramming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HTProgramming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow =  new HTProgramming();
                mainWindow.setVisible(true);
//                new HTProgramming().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdmin;
    private javax.swing.JButton jButtonLoginAdmin;
    private javax.swing.JButton jButtonStudent;
    private javax.swing.JDialog jDialogAdminLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelAdminLogin;
    private javax.swing.JPasswordField jPasswordFieldAdmin;
    private javax.swing.JTextField jTextFieldAdmin;
    // End of variables declaration//GEN-END:variables
}
