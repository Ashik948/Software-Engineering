package HardWareStore;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaswingdev.Notification2;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mahmud
 */
public class Login extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    JTextField jf1 = new JTextField();
    JTextField jf2 = new JTextField();

    static long start = System.currentTimeMillis();

    /**
     * Creates new form Login
     */
    public Login() {

        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        UserLoginComboBox.setSelectedIndex(0);

        jf1.setBackground(new java.awt.Color(53, 75, 97));
        jf2.setBackground(new java.awt.Color(53, 75, 97));

        jf1.setForeground(new java.awt.Color(255, 255, 255));
        jf2.setForeground(new java.awt.Color(255, 255, 255));

    }

    Login(int i) {

        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        jf1.setBackground(new java.awt.Color(53, 75, 97));
        jf2.setBackground(new java.awt.Color(53, 75, 97));

        jf1.setForeground(new java.awt.Color(255, 255, 255));
        jf2.setForeground(new java.awt.Color(255, 255, 255));

        switch (i) {
            case 11 ->
                UserLoginComboBox.setSelectedIndex(2);
            default ->
                UserLoginComboBox.setSelectedIndex(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        LoginBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        PasswordLogin = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        createannew = new javax.swing.JLabel();
        createannew1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle36 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle11 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle13 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        UserLoginComboBox = new rojerusan.RSComboMetro();

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 0));
        jButton1.setText("Sign in");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(14, 42, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(246, 45, 12));
        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 140, 40));

        jLabel5.setBackground(new java.awt.Color(246, 45, 12));
        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, 40));

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CloseWhite.png"))); // NOI18N
        jLabel1.setToolTipText("Close");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 30, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 40, 140, 370));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle3.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 40, 150, 370));

        LoginBtn.setBackground(new java.awt.Color(0, 153, 153));
        LoginBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Loginedited.png"))); // NOI18N
        LoginBtn.setText("Log in");
        LoginBtn.setBorderPainted(false);
        LoginBtn.setFocusCycleRoot(true);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, 30));

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
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 25, 30));

        PasswordLogin.setBackground(new java.awt.Color(31, 54, 77));
        PasswordLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PasswordLogin.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordLoginActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 160, 30));

        username.setBackground(new java.awt.Color(31, 54, 77));
        username.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 160, 30));

        createannew.setBackground(new java.awt.Color(22, 31, 39));
        createannew.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        createannew.setForeground(new java.awt.Color(0, 204, 204));
        createannew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createannew.setText("Create new");
        createannew.setToolTipText("Click");
        createannew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        createannew.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 89, 115), new java.awt.Color(63, 89, 115), null));
        createannew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createannew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createannew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createannew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createannewMouseClicked(evt);
            }
        });
        jPanel1.add(createannew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, 30));

        createannew1.setBackground(new java.awt.Color(22, 31, 39));
        createannew1.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        createannew1.setForeground(new java.awt.Color(0, 204, 204));
        createannew1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createannew1.setText("Forgotten password?");
        createannew1.setToolTipText("Click");
        createannew1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        createannew1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 89, 115), new java.awt.Color(63, 89, 115), null));
        createannew1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createannew1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createannew1MouseClicked(evt);
            }
        });
        jPanel1.add(createannew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 180, 30));

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/LoginIconEdited.png"))); // NOI18N
        jLabel3.setIconTextGap(10);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 90, 50));

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

        rSMaterialButtonRectangle6.setText("Login");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 150, 40));

        rSMaterialButtonRectangle36.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle36.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 190, 35));

        rSMaterialButtonRectangle11.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle11ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 210, 15));

        rSMaterialButtonRectangle13.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle13ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 15));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 60));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 650, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, 650, 25));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 50, 20));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/copyright.png"))); // NOI18N
        jLabel6.setText("Copyright March 2022");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, 30));

        UserLoginComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Customer", "Admin", "Seller" }));
        UserLoginComboBox.setColorArrow(new java.awt.Color(0, 204, 204));
        UserLoginComboBox.setColorBorde(new java.awt.Color(0, 204, 204));
        UserLoginComboBox.setColorFondo(new java.awt.Color(0, 204, 204));
        UserLoginComboBox.setFont(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        UserLoginComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLoginComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(UserLoginComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked
    private int xm, ym;
    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close.png")));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/WhiteClose.png")));
    }//GEN-LAST:event_jLabel1MouseExited

    public void ForLogin() {

        switch (UserLoginComboBox.getSelectedIndex()) {
            case 0 -> {

                if (PasswordLogin.getText().isEmpty() || username.getText().isEmpty()) {

                    Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Name and password required ");
                    panel.showNotification();

                } else {
                    try {
                        String Query = "select * from customer where CName = '" + username.getText()
                                + "' and CPassword = '" + PasswordLogin.getText() + "'";

                        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                        prestm = connection.prepareStatement(Query);

                        resultset = prestm.executeQuery();

                        if (resultset.next()) {

                            new SearchModify(resultset.getString(2), 10).setVisible(true);
                            this.dispose();
                        } else {

                            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Incorrect credentials");
                            panel.showNotification();
                        }

                    } catch (SQLException ex) {

                    }
                }
            }
            case 1 -> {

                //************** Admin Login **********************
                
                if (PasswordLogin.getText().isEmpty() || username.getText().isEmpty()) {

                    Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Name and password required ");
                    panel.showNotification();

//
                } else {
                    try {
                        String Query = "select * from admin where UName = '" + username.getText()
                                + "' and UPassword = '" + PasswordLogin.getText() + "'";

                        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                        prestm = connection.prepareStatement(Query);

                        resultset = prestm.executeQuery();

                        if (resultset.next()) {

                            new Home(resultset.getString(2), resultset.getInt(1)).setVisible(true);
                            this.dispose();
                        } else {

                            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Incorrect credentials");
                            panel.showNotification();

                        }

                    } catch (SQLException ex) {

                    }
                }

            }
            case 2 -> {

                if (PasswordLogin.getText().isEmpty() || username.getText().isEmpty()) {

                    Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Name and password required ");
                    panel.showNotification();

                } else {
                    try {
                        String Query = "select * from sellers where SName = '" + username.getText()
                                + "' and SPassword = '" + PasswordLogin.getText() + "'";

                        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                        prestm = connection.prepareStatement(Query);

                        resultset = prestm.executeQuery();

                        if (resultset.next()) {

                            new OrdersSeller(resultset.getString(2), 20).setVisible(true);
                            this.dispose();
                        } else {

                            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Incorrect credentials");
                            panel.showNotification();
                        }

                    } catch (SQLException ex) {

                    }
                }
            }
            default -> {
            }
        }
    }

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed

        ForLogin();
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eye2.png")));

        PasswordLogin.setEchoChar((char) 0);


    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/blind2.png")));

        PasswordLogin.setEchoChar('*');
    }//GEN-LAST:event_jLabel7MouseExited

    private void PasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordLoginActionPerformed
        ForLogin();
    }//GEN-LAST:event_PasswordLoginActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        PasswordLogin.requestFocus();
    }//GEN-LAST:event_usernameActionPerformed

    private void createannewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createannewMouseClicked

        new SignUp().setVisible(true);
        dispose();
    }//GEN-LAST:event_createannewMouseClicked

    private void createannew1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createannew1MouseClicked

        Object[] textbox = {
            "Custname: ", jf1,
            "CEmail: ", jf2
        };
        JOptionPane.showMessageDialog(this, textbox, "Forgotten password", JOptionPane.INFORMATION_MESSAGE);
        if (jf1.getText().isEmpty() || jf2.getText().isEmpty()) {

        } else {

            try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("SELECT CName,CPassword FROM customer WHERE CName=? and CEmail=? ");

                prestm.setString(1, jf1.getText().trim());
                prestm.setString(2, jf2.getText().trim());

                resultset = prestm.executeQuery();
                if (resultset.next() == true) {

                    String Credentials = "Custname is: " + resultset.getString("CName") + "\n\nPassword is: " + resultset.getString("CPassword");
                    JOptionPane jo = new JOptionPane(Credentials);
                    jo.setMessageType(JOptionPane.INFORMATION_MESSAGE);

                    JDialog dialog = jo.createDialog(Credentials);
                    dialog = jo.createDialog(null, "Forgot account");
                    dialog.setVisible(true);

                    jf1.setText(null);
                    jf2.setText(null);

                } else {
                    JOptionPane.showMessageDialog(this, "Custname & Email are incorrect", "Forgot account", JOptionPane.WARNING_MESSAGE);
                }

            } catch (HeadlessException | NumberFormatException | SQLException ex) {

            }
        }
    }//GEN-LAST:event_createannew1MouseClicked

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        xm = evt.getX();
        ym = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xm, y - ym);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void rSMaterialButtonRectangle11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle11ActionPerformed

    private void rSMaterialButtonRectangle13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle13ActionPerformed

    private void UserLoginComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLoginComboBoxActionPerformed

        switch (UserLoginComboBox.getSelectedIndex()) {
            case 0 -> {
                createannew.show();
                createannew1.show();
                username.setText("");
                PasswordLogin.setText("");

            }
            case 1 -> {
                username.setText("");
                PasswordLogin.setText("");
                createannew.hide();
                createannew1.hide();

            }
            case 2 -> {
                username.setText("");
                PasswordLogin.setText("");
                createannew.hide();
                createannew1.hide();
            }
            default -> {
                createannew.hide();
                createannew1.hide();
            }
        }
    }//GEN-LAST:event_UserLoginComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField PasswordLogin;
    private rojerusan.RSComboMetro UserLoginComboBox;
    private javax.swing.JLabel createannew;
    private javax.swing.JLabel createannew1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle13;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle36;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
