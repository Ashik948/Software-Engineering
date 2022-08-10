package HardWareStore;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javaswingdev.Notification2;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahmud
 */
public class SignUp extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    static long start = System.currentTimeMillis();

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());
    }

    private int xm, ym;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        PasswordLogin = new javax.swing.JPasswordField();
        nametxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        phonetxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addresstxt = new javax.swing.JTextField();
        emailtxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        RePasswordLogin = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle36 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle11 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle13 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(14, 42, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(246, 45, 12));
        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 100, 40));

        jLabel5.setBackground(new java.awt.Color(246, 45, 12));
        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CustName");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 40));

        LoginBtn.setBackground(new java.awt.Color(0, 153, 153));
        LoginBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-iconedited.png"))); // NOI18N
        LoginBtn.setText("Create");
        LoginBtn.setBorderPainted(false);
        LoginBtn.setFocusCycleRoot(true);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, 30));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/blind2.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 25, 30));

        PasswordLogin.setBackground(new java.awt.Color(31, 54, 77));
        PasswordLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PasswordLogin.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordLoginActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 150, 30));

        nametxt.setBackground(new java.awt.Color(31, 54, 77));
        nametxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        nametxt.setForeground(new java.awt.Color(255, 255, 255));
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        jPanel1.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, 30));

        jLabel8.setBackground(new java.awt.Color(246, 45, 12));
        jLabel8.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 90, 40));

        phonetxt.setBackground(new java.awt.Color(31, 54, 77));
        phonetxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        phonetxt.setForeground(new java.awt.Color(255, 255, 255));
        phonetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetxtActionPerformed(evt);
            }
        });
        jPanel1.add(phonetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 170, 30));

        jLabel9.setBackground(new java.awt.Color(246, 45, 12));
        jLabel9.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 80, 40));

        addresstxt.setBackground(new java.awt.Color(31, 54, 77));
        addresstxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        addresstxt.setForeground(new java.awt.Color(255, 255, 255));
        addresstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresstxtActionPerformed(evt);
            }
        });
        jPanel1.add(addresstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 170, 30));

        emailtxt.setBackground(new java.awt.Color(31, 54, 77));
        emailtxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        emailtxt.setForeground(new java.awt.Color(255, 255, 255));
        emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxtActionPerformed(evt);
            }
        });
        jPanel1.add(emailtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 170, 30));

        jLabel10.setBackground(new java.awt.Color(246, 45, 12));
        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 110, 40));

        RePasswordLogin.setBackground(new java.awt.Color(31, 54, 77));
        RePasswordLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        RePasswordLogin.setForeground(new java.awt.Color(255, 255, 255));
        RePasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RePasswordLoginActionPerformed(evt);
            }
        });
        jPanel1.add(RePasswordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 150, 30));

        jLabel11.setBackground(new java.awt.Color(246, 45, 12));
        jLabel11.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Re pass");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 100, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-arrow.png"))); // NOI18N
        jLabel1.setToolTipText("back to login");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 30, 30));

        jPanel7.setBackground(new java.awt.Color(31, 54, 77));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel7MouseDragged(evt);
            }
        });
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSMaterialButtonRectangle6.setText("Sign up");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 170, 40));

        rSMaterialButtonRectangle36.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle36.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle36, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 210, 35));

        rSMaterialButtonRectangle11.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle11ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 200, 15));

        rSMaterialButtonRectangle13.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle13ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 15));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle3.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 50, 150, 360));

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LoginIconEdited.png"))); // NOI18N
        jLabel15.setIconTextGap(10);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 90, 50));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 650, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, 650, 25));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/copyright.png"))); // NOI18N
        jLabel6.setText("Copyright March 2022");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 30));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 50, 20));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 50, 140, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        if (nametxt.getText().isEmpty()
                || PasswordLogin.getText().isEmpty()
                || RePasswordLogin.getText().isEmpty()
                || phonetxt.getText().isEmpty()
                || addresstxt.getText().isEmpty()
                || emailtxt.getText().isEmpty()) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
            panel.showNotification();

        } else if (!PasswordLogin.getText().equals(RePasswordLogin.getText())) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Password does't match");
            panel.showNotification();

        } else if (nametxt.getText().length() <= 3) {
            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Too Short Username");
            panel.showNotification();

        } else if (PasswordLogin.getText().length() < 8 && RePasswordLogin.getText().length() < 8) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Too Short Password");
            panel.showNotification();

        } else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", emailtxt.getText()))) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Invalid email");
            panel.showNotification();

        } else {

            try {

                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("Insert into customer(CName, CPassword,RePass, CPhone, CAddress,CEmail)values(?,?,?,?,?,?) ");

                prestm.setString(1, nametxt.getText());
                prestm.setString(2, PasswordLogin.getText());
                prestm.setInt(3, Integer.valueOf(RePasswordLogin.getText()));
                prestm.setString(4, phonetxt.getText());
                prestm.setString(5, addresstxt.getText());
                prestm.setString(6, emailtxt.getText());

                int k = prestm.executeUpdate();

                if (k == 1) {

                    Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_LEFT, "Customer Added");
                    panel.showNotification();

                    new Login().setVisible(true);
                    dispose();
                }

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, ex);

            }
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void PasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordLoginActionPerformed

    }//GEN-LAST:event_PasswordLoginActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        PasswordLogin.requestFocus();
    }//GEN-LAST:event_nametxtActionPerformed

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/blind2.png")));

        PasswordLogin.setEchoChar('*');
        RePasswordLogin.setEchoChar('*');
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eye2.png")));

        PasswordLogin.setEchoChar((char) 0);
        RePasswordLogin.setEchoChar((char) 0);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void phonetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetxtActionPerformed

    private void addresstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addresstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addresstxtActionPerformed

    private void emailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxtActionPerformed

    private void RePasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RePasswordLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RePasswordLoginActionPerformed

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void rSMaterialButtonRectangle11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle11ActionPerformed

    private void rSMaterialButtonRectangle13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle13ActionPerformed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xm, y - ym);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        xm = evt.getX();
        ym = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            System.out.println((float) (System.currentTimeMillis() - start) / 1000 + " s");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SignUp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordLogin;
    private javax.swing.JPasswordField RePasswordLogin;
    private javax.swing.JTextField addresstxt;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField phonetxt;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle13;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle36;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    // End of variables declaration//GEN-END:variables
}
