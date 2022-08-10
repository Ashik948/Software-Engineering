package HardWareStore;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javaswingdev.Notification2;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mahmud
 */
public class UserList extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    int flag = 1;

    DefaultTableModel dtm;

    static long start = System.currentTimeMillis();

    /**
     * Creates new form Sellers
     */
    public UserList() {
        initComponents();

        DisplayUsers();
        DisplayAdmin();

        try {
            sellertable.setRowSelectionInterval(0, 0);
            Admintable.setRowSelectionInterval(0, 0);
        } catch (Exception ez) {

        }

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        jToggleButton1.setText("Admin is selected");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        UserPhoneTextField = new javax.swing.JTextField();
        UserPasswordTextField = new javax.swing.JTextField();
        UserNameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        UserEmailTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CIdTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Admintable = new rojerusan.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sellertable = new rojerusan.RSTableMetro();
        hm6 = new rojerusan.RSMaterialButtonRectangle();
        hm5 = new rojerusan.RSMaterialButtonRectangle();
        hm2 = new rojerusan.RSMaterialButtonRectangle();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle33 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle9 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle10 = new rojerusan.RSMaterialButtonRectangle();
        minimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(14, 42, 71));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(246, 45, 12));
        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 40));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sellers");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 196, 40));

        jLabel14.setBackground(new java.awt.Color(246, 45, 12));
        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 113, 40));

        UserPhoneTextField.setBackground(new java.awt.Color(31, 54, 77));
        UserPhoneTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        UserPhoneTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(UserPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 210, 30));

        UserPasswordTextField.setBackground(new java.awt.Color(31, 54, 77));
        UserPasswordTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        UserPasswordTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(UserPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 210, 30));

        UserNameTextField.setBackground(new java.awt.Color(31, 54, 77));
        UserNameTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        UserNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 210, 30));

        jLabel12.setBackground(new java.awt.Color(246, 45, 12));
        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Password");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 40));

        jLabel15.setBackground(new java.awt.Color(246, 45, 12));
        jLabel15.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Phone");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 113, 40));

        UserEmailTextField.setBackground(new java.awt.Color(31, 54, 77));
        UserEmailTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        UserEmailTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(UserEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 210, 30));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Admin");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 196, 40));

        jLabel19.setBackground(new java.awt.Color(246, 45, 12));
        jLabel19.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Search");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 40));

        CIdTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CIdTextField.setForeground(new java.awt.Color(44, 62, 80));
        CIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CIdTextFieldKeyReleased(evt);
            }
        });
        jPanel5.add(CIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 210, 30));

        Admintable.setForeground(new java.awt.Color(255, 153, 0));
        Admintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "UId", "UName", "UPassword", "UPhone", "UEmail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Admintable.setColorBackgoundHead(new java.awt.Color(31, 54, 77));
        Admintable.setColorBordeFilas(new java.awt.Color(255, 153, 0));
        Admintable.setColorBordeHead(new java.awt.Color(255, 153, 0));
        Admintable.setColorFilasForeground1(new java.awt.Color(31, 54, 77));
        Admintable.setColorFilasForeground2(new java.awt.Color(31, 54, 77));
        Admintable.setColorSelBackgound(new java.awt.Color(0, 204, 204));
        Admintable.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Admintable.setFuenteFilas(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Admintable.setFuenteFilasSelect(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Admintable.setFuenteHead(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        Admintable.setRowHeight(25);
        Admintable.setShowGrid(false);
        Admintable.getTableHeader().setReorderingAllowed(false);
        Admintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdmintableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Admintable);
        if (Admintable.getColumnModel().getColumnCount() > 0) {
            Admintable.getColumnModel().getColumn(0).setPreferredWidth(50);
            Admintable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 570, 160));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home2.png"))); // NOI18N
        jLabel1.setToolTipText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 100, -1, -1));

        sellertable.setForeground(new java.awt.Color(255, 153, 0));
        sellertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SId", "SName", "SPassword", "SPhone", "SEmail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sellertable.setColorBackgoundHead(new java.awt.Color(31, 54, 77));
        sellertable.setColorBordeFilas(new java.awt.Color(255, 153, 0));
        sellertable.setColorBordeHead(new java.awt.Color(255, 153, 0));
        sellertable.setColorFilasForeground1(new java.awt.Color(31, 54, 77));
        sellertable.setColorFilasForeground2(new java.awt.Color(31, 54, 77));
        sellertable.setColorSelBackgound(new java.awt.Color(0, 204, 204));
        sellertable.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        sellertable.setFuenteFilas(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        sellertable.setFuenteFilasSelect(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        sellertable.setFuenteHead(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        sellertable.setRowHeight(24);
        sellertable.setShowGrid(false);
        sellertable.getTableHeader().setReorderingAllowed(false);
        sellertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellertableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(sellertable);
        if (sellertable.getColumnModel().getColumnCount() > 0) {
            sellertable.getColumnModel().getColumn(0).setPreferredWidth(50);
            sellertable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 570, 180));

        hm6.setBackground(new java.awt.Color(255, 153, 0));
        hm6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm6.setText("Add");
        hm6.setFocusable(false);
        hm6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        hm6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hm6ActionPerformed(evt);
            }
        });
        jPanel5.add(hm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 90, 40));

        hm5.setBackground(new java.awt.Color(255, 102, 102));
        hm5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm5.setText("Delete");
        hm5.setFocusable(false);
        hm5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        hm5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hm5ActionPerformed(evt);
            }
        });
        jPanel5.add(hm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 90, 40));

        hm2.setBackground(new java.awt.Color(0, 204, 102));
        hm2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm2.setText("Edit");
        hm2.setFocusable(false);
        hm2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        hm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hm2ActionPerformed(evt);
            }
        });
        jPanel5.add(hm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 90, 40));

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 153));
        jToggleButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 153, 153));
        jToggleButton1.setText("AdminSeller");
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

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

        rSMaterialButtonRectangle6.setText("Manage Admin/Sellers");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        jPanel7.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 460, 40));

        rSMaterialButtonRectangle33.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle33.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle33, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 500, 35));

        rSMaterialButtonRectangle9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 200, 15));

        rSMaterialButtonRectangle10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 15));

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
        jPanel7.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 30, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/CloseWhite.png"))); // NOI18N
        jLabel2.setToolTipText("Close");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 30, 30));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 80));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel5.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 595, 960, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel5.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 960, 25));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 190, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Search(String str) {

        if (flag == 1) {

            dtm = (DefaultTableModel) Admintable.getModel();
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
            Admintable.setRowSorter(trs);

            trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));

        } else if (flag == 0) {

            dtm = (DefaultTableModel) sellertable.getModel();
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
            sellertable.setRowSorter(trs);

            trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));

        }
    }

    // Display ---------------------------------------
    public void DisplayUsers() {

        try {

            int J_table;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select * from sellers");
            resultset = prestm.executeQuery();

            ResultSetMetaData rsmd = resultset.getMetaData();
            J_table = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) sellertable.getModel();
            dtm.setRowCount(0);

            while (resultset.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(resultset.getString("Sid"));
                    v.add(resultset.getString("SName"));
                    v.add(resultset.getString("SPassword"));
                    v.add(resultset.getString("SPhone"));
                    v.add(resultset.getString("SEmail"));
                }
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    // Display ---------------------------------------
    public void DisplayAdmin() {

        try {

            int J_table;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select * from admin");
            resultset = prestm.executeQuery();

            ResultSetMetaData rsmd = resultset.getMetaData();
            J_table = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) Admintable.getModel();
            dtm.setRowCount(0);

            while (resultset.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(resultset.getString("Uid"));
                    v.add(resultset.getString("UName"));
                    v.add(resultset.getString("UPassword"));
                    v.add(resultset.getString("UPhone"));
                    v.add(resultset.getString("UEmail"));
                }
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }


    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            jToggleButton1.setText("Seller is selected");
            flag = 0;

        } else {
            jToggleButton1.setText("Admin is selected");
            flag = 1;

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void CIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CIdTextFieldKeyReleased
        Search(CIdTextField.getText().trim());
    }//GEN-LAST:event_CIdTextFieldKeyReleased

    private void AdmintableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdmintableMouseClicked
        try {

            DefaultTableModel update = (DefaultTableModel) Admintable.getModel();
            int selectedindex = Admintable.getSelectedRow();

            UserNameTextField.setText(update.getValueAt(selectedindex, 1).toString());
            UserPasswordTextField.setText(update.getValueAt(selectedindex, 2).toString());
            UserPhoneTextField.setText(update.getValueAt(selectedindex, 3).toString());
            UserEmailTextField.setText(update.getValueAt(selectedindex, 4).toString());

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_AdmintableMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void sellertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellertableMouseClicked
        try {

            DefaultTableModel update = (DefaultTableModel) sellertable.getModel();
            int selectedindex = sellertable.getSelectedRow();

            UserNameTextField.setText(update.getValueAt(selectedindex, 1).toString());
            UserPasswordTextField.setText(update.getValueAt(selectedindex, 2).toString());
            UserPhoneTextField.setText(update.getValueAt(selectedindex, 3).toString());
            UserEmailTextField.setText(update.getValueAt(selectedindex, 4).toString());

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_sellertableMouseClicked

    private void hm6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm6ActionPerformed

        if (flag == 0) {

            if (UserNameTextField.getText().isEmpty()
                    || UserPasswordTextField.getText().isEmpty()
                    || UserPhoneTextField.getText().isEmpty()
                    || UserEmailTextField.getText().isEmpty()) {

                Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
                panel.showNotification();

            } else {

                try {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("Insert into sellers(SName, SPassword, SPhone, SEmail)values(?,?,?,?) ");

                    prestm.setString(1, UserNameTextField.getText());
                    prestm.setString(2, UserPasswordTextField.getText());
                    prestm.setString(3, UserPhoneTextField.getText());
                    prestm.setString(4, UserEmailTextField.getText());

                    int k = prestm.executeUpdate();

                    if (k == 1) {

                        DisplayUsers();

                        Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_LEFT, "Seller added");
                        panel.showNotification();
                    }

                } catch (HeadlessException ex) {

                    JOptionPane.showMessageDialog(this, ex);

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(this, "Duplicate entry");
                }
            }

        } else if (flag == 1) {

            // ********************************
            if (UserNameTextField.getText().isEmpty()
                    || UserPasswordTextField.getText().isEmpty()
                    || UserPhoneTextField.getText().isEmpty()
                    || UserEmailTextField.getText().isEmpty()) {

                Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
                panel.showNotification();

            } else {

                try {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("Insert into admin(UName, UPassword, UPhone, UEmail)values(?,?,?,?) ");

                    prestm.setString(1, UserNameTextField.getText());
                    prestm.setString(2, UserPasswordTextField.getText());
                    prestm.setString(3, UserPhoneTextField.getText());
                    prestm.setString(4, UserEmailTextField.getText());

                    int k = prestm.executeUpdate();

                    if (k == 1) {

                        DisplayAdmin();

                        Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_LEFT, "Admin added");
                        panel.showNotification();
                    }

                } catch (HeadlessException ex) {

                    JOptionPane.showMessageDialog(this, ex);

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(this, "Duplicate entry");
                }
            }
        }
    }//GEN-LAST:event_hm6ActionPerformed

    private void hm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm2ActionPerformed
        if (flag == 0) {

            if (UserNameTextField.getText().isEmpty()
                    || UserPasswordTextField.getText().isEmpty()
                    || UserPhoneTextField.getText().isEmpty()
                    || UserEmailTextField.getText().isEmpty()) {

                Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
                panel.showNotification();

            } else {

                try {
                    DefaultTableModel update = (DefaultTableModel) sellertable.getModel();
                    int selectedindex = sellertable.getSelectedRow();

                    int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("update sellers set SName=?, SPassword=?, SPhone=?, SEmail=? where Sid=? ");

                    prestm.setString(1, UserNameTextField.getText());
                    prestm.setString(2, UserPasswordTextField.getText());
                    prestm.setString(3, UserPhoneTextField.getText());
                    prestm.setString(4, UserEmailTextField.getText());

                    prestm.setInt(5, id);

                    prestm.executeUpdate();

                    DisplayUsers();

                    Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_LEFT, "Seller info updated");
                    panel.showNotification();

                } catch (HeadlessException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }

            }

        } else if (flag == 1) {

            // *****************************
            if (UserNameTextField.getText().isEmpty()
                    || UserPasswordTextField.getText().isEmpty()
                    || UserPhoneTextField.getText().isEmpty()
                    || UserEmailTextField.getText().isEmpty()) {

                Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
                panel.showNotification();

            } else {

                try {
                    DefaultTableModel update = (DefaultTableModel) Admintable.getModel();
                    int selectedindex = Admintable.getSelectedRow();

                    int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("update admin set UName=?, UPassword=?, UPhone=?, UEmail=? where Uid=? ");

                    prestm.setString(1, UserNameTextField.getText());
                    prestm.setString(2, UserPasswordTextField.getText());
                    prestm.setString(3, UserPhoneTextField.getText());
                    prestm.setString(4, UserEmailTextField.getText());

                    prestm.setInt(5, id);

                    prestm.executeUpdate();

                    DisplayAdmin();

                    Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_LEFT, "Admin info updated");
                    panel.showNotification();

                } catch (HeadlessException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }

            }

        }


    }//GEN-LAST:event_hm2ActionPerformed

    private void hm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm5ActionPerformed

        if (flag == 0) {
            if (UserNameTextField.getText().isEmpty()
                    || UserPasswordTextField.getText().isEmpty()) {

                Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
                panel.showNotification();

            } else {

                try {

                    DefaultTableModel update = (DefaultTableModel) sellertable.getModel();

                    int selectedindex = sellertable.getSelectedRow();

                    int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                    int showresult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record ? ", "Warring", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (showresult == JOptionPane.YES_NO_OPTION) {

                        connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                        prestm = connection.prepareStatement("delete from sellers where Sid =? ");

                        prestm.setInt(1, id);
                        int k = prestm.executeUpdate();

                        DisplayUsers();

                    }
                } catch (HeadlessException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
        } else if (flag == 1) {
            // *****************************

            if (UserNameTextField.getText().isEmpty()
                    || UserPasswordTextField.getText().isEmpty()) {

                Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
                panel.showNotification();

            } else {

                try {

                    DefaultTableModel update = (DefaultTableModel) Admintable.getModel();

                    int selectedindex = Admintable.getSelectedRow();

                    int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                    int showresult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record ? ", "Warring", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (showresult == JOptionPane.YES_NO_OPTION) {

                        connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                        prestm = connection.prepareStatement("delete from admin where Uid =? ");

                        prestm.setInt(1, id);
                        int k = prestm.executeUpdate();

                        DisplayAdmin();

                    }
                } catch (HeadlessException | NumberFormatException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
        }
    }//GEN-LAST:event_hm5ActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/WhiteClose.png")));
    }//GEN-LAST:event_jLabel2MouseExited

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
            new UserList().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro Admintable;
    private javax.swing.JTextField CIdTextField;
    private javax.swing.JTextField UserEmailTextField;
    private javax.swing.JTextField UserNameTextField;
    private javax.swing.JTextField UserPasswordTextField;
    private javax.swing.JTextField UserPhoneTextField;
    private rojerusan.RSMaterialButtonRectangle hm2;
    private rojerusan.RSMaterialButtonRectangle hm5;
    private rojerusan.RSMaterialButtonRectangle hm6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel minimize;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle33;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private rojerusan.RSTableMetro sellertable;
    // End of variables declaration//GEN-END:variables
}
