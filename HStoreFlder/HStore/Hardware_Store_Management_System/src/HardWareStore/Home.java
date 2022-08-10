package HardWareStore;

import javax.swing.ImageIcon;

/**
 *
 * @author Mahmud
 */
public class Home extends javax.swing.JFrame {
    
    String AdminName_For_Sale;

     static long start = System.currentTimeMillis();
    
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());
    }

    Home(String AdminName, int aInt) {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        AdminName_For_Sale = AdminName;
        
        usershow.setText("Admin: " + AdminName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aa1 = new javax.swing.JLabel();
        aa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle9 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle33 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle11 = new rojerusan.RSMaterialButtonRectangle();
        minimize = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rSMaterialButtonRectangle10 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        usershow = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(14, 42, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Orders");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 140, 30));

        jLabel5.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Products");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 160, -1));

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DashBoard");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 140, 40));

        aa1.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        aa1.setForeground(new java.awt.Color(255, 255, 255));
        aa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aa1.setText("Seller");
        aa1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(aa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 140, 40));

        aa.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        aa.setForeground(new java.awt.Color(255, 255, 255));
        aa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aa.setText("Admin");
        aa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(aa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 140, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/order (1).png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 140, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/received.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 140, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Usersicon.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 140, 80));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dashboard.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 140, 70));

        jPanel6.setBackground(new java.awt.Color(31, 54, 77));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 360, 10));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle3.setFocusCycleRoot(true);
        rSMaterialButtonCircle3.setFocusPainted(false);
        rSMaterialButtonCircle3.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 130, 450));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-69, 70, 80, 450));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle2.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 160, 160));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle3.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 160, 160));

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle5.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 160, 160));

        rSMaterialButtonRectangle6.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle6.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 160, 160));

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

        rSMaterialButtonRectangle7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 150, 15));

        rSMaterialButtonRectangle9.setText("Home");
        rSMaterialButtonRectangle9.setFont(new java.awt.Font("Trajan Pro", 1, 26)); // NOI18N
        rSMaterialButtonRectangle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle9ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 240, 40));

        rSMaterialButtonRectangle33.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle33.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 280, 35));

        rSMaterialButtonRectangle11.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 160, 15));

        minimize.setBackground(new java.awt.Color(55, 80, 100));
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/white_miniminuws.png"))); // NOI18N
        minimize.setToolTipText("Minimize");
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        jPanel7.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 30, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CloseWhite.png"))); // NOI18N
        jLabel3.setToolTipText("Close");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 30, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 80));

        rSMaterialButtonRectangle10.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle10ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 120, 60));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 590, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 590, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shutdownedited.png"))); // NOI18N
        jLabel2.setToolTipText("Log out");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        usershow.setBackground(new java.awt.Color(246, 45, 12));
        usershow.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        usershow.setForeground(new java.awt.Color(255, 255, 255));
        usershow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usershow.setText("Admin");
        jPanel1.add(usershow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(593, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        new UserList().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new ProductsList().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        new OrdersAdmin(AdminName_For_Sale).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        new DashBoard().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void rSMaterialButtonRectangle10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle10ActionPerformed

    private void rSMaterialButtonRectangle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle9ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked
 private int xm, ym;
    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        xm = evt.getX();
        ym = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
         int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xm, y - ym);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setExtendedState(CustomerList.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/miniminuwsedited.png")));
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/white_miniminuws.png")));

    }//GEN-LAST:event_minimizeMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
         jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/WhiteClose.png")));
    }//GEN-LAST:event_jLabel3MouseExited

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aa;
    private javax.swing.JLabel aa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel minimize;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle33;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private javax.swing.JLabel usershow;
    // End of variables declaration//GEN-END:variables
}
