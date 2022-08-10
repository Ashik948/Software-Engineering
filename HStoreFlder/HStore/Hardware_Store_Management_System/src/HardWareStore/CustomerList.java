package HardWareStore;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javaswingdev.Notification;
import javax.swing.JTable;

/**
 *
 * @author Mahmud
 */
public class CustomerList extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm, prestm2;
    ResultSet resultset, resultset2;

    DefaultTableModel dtm;

    static long start = System.currentTimeMillis();

    /**
     * Creates new form CustomerList
     */
    public CustomerList() {

        initComponents();

        NewDisplayCustomer();
        getContentPane().setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());
        try {
            rSTableMetro1.setRowSelectionInterval(0, 0);
        } catch (Exception ez) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CPhoneTextField = new javax.swing.JTextField();
        CPasswordTextField = new javax.swing.JTextField();
        CNameTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        addresstxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        CIdTextField = new javax.swing.JTextField();
        OrderAmount = new javax.swing.JLabel();
        DashBoardSellersName3 = new javax.swing.JLabel();
        DashBoardSellersName1 = new javax.swing.JLabel();
        OrderNumber = new javax.swing.JLabel();
        hm4 = new rojerusan.RSMaterialButtonRectangle();
        CEmailTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        hm2 = new rojerusan.RSMaterialButtonRectangle();
        d11 = new rojerusan.RSMaterialButtonRectangle();
        hm3 = new rojerusan.RSMaterialButtonRectangle();
        d12 = new rojerusan.RSMaterialButtonRectangle();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle33 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle9 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        rSMaterialButtonRectangle10 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        hm5 = new rojerusan.RSMaterialButtonRectangle();
        hm6 = new rojerusan.RSMaterialButtonRectangle();
        Printbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(14, 42, 71));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(246, 45, 12));
        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Name");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Customer List");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 196, -1));

        jLabel14.setBackground(new java.awt.Color(246, 45, 12));
        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 113, 30));

        CPhoneTextField.setBackground(new java.awt.Color(31, 54, 77));
        CPhoneTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CPhoneTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(CPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 210, 30));

        CPasswordTextField.setBackground(new java.awt.Color(31, 54, 77));
        CPasswordTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CPasswordTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(CPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 210, 30));

        CNameTextField.setBackground(new java.awt.Color(31, 54, 77));
        CNameTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(CNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 210, 30));

        jLabel15.setBackground(new java.awt.Color(246, 45, 12));
        jLabel15.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Password");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        jLabel16.setBackground(new java.awt.Color(246, 45, 12));
        jLabel16.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Phone");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 113, 30));

        addresstxt.setBackground(new java.awt.Color(31, 54, 77));
        addresstxt.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        addresstxt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(addresstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 210, 30));

        jLabel19.setBackground(new java.awt.Color(246, 45, 12));
        jLabel19.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Search");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, 30));

        CIdTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CIdTextField.setForeground(new java.awt.Color(44, 62, 80));
        CIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CIdTextFieldKeyReleased(evt);
            }
        });
        jPanel3.add(CIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 210, 30));

        OrderAmount.setBackground(new java.awt.Color(51, 51, 51));
        OrderAmount.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderAmount.setForeground(new java.awt.Color(255, 255, 255));
        OrderAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderAmount.setText("?");
        jPanel3.add(OrderAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 120, 30));

        DashBoardSellersName3.setBackground(new java.awt.Color(51, 51, 51));
        DashBoardSellersName3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        DashBoardSellersName3.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName3.setText("Order Amount");
        jPanel3.add(DashBoardSellersName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 610, 140, -1));

        DashBoardSellersName1.setBackground(new java.awt.Color(51, 51, 51));
        DashBoardSellersName1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        DashBoardSellersName1.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName1.setText("Order Number");
        jPanel3.add(DashBoardSellersName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 120, -1));

        OrderNumber.setBackground(new java.awt.Color(51, 51, 51));
        OrderNumber.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderNumber.setForeground(new java.awt.Color(255, 255, 255));
        OrderNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderNumber.setText("?");
        jPanel3.add(OrderNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, 120, 30));

        hm4.setBackground(new java.awt.Color(0, 153, 153));
        hm4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm4.setForeground(new java.awt.Color(44, 62, 80));
        hm4.setFocusable(false);
        jPanel3.add(hm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 600, 180, 40));

        CEmailTextField1.setBackground(new java.awt.Color(31, 54, 77));
        CEmailTextField1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CEmailTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(CEmailTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 210, 30));

        jLabel20.setBackground(new java.awt.Color(246, 45, 12));
        jLabel20.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Email");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 113, 30));

        rSTableMetro1.setForeground(new java.awt.Color(255, 153, 0));
        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CId", "CName", "CPassword", "RePass", "CPhone", "CAdress", "CEmail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(31, 54, 77));
        rSTableMetro1.setColorBordeFilas(new java.awt.Color(255, 153, 0));
        rSTableMetro1.setColorBordeHead(new java.awt.Color(255, 153, 0));
        rSTableMetro1.setColorFilasForeground1(new java.awt.Color(31, 54, 77));
        rSTableMetro1.setColorFilasForeground2(new java.awt.Color(31, 54, 77));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(0, 204, 204));
        rSTableMetro1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rSTableMetro1.setFuenteFilas(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rSTableMetro1.setFuenteFilasSelect(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        rSTableMetro1.setFuenteHead(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        rSTableMetro1.setRowHeight(30);
        rSTableMetro1.setShowGrid(false);
        rSTableMetro1.getTableHeader().setReorderingAllowed(false);
        rSTableMetro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rSTableMetro1);
        if (rSTableMetro1.getColumnModel().getColumnCount() > 0) {
            rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
            rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
            rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(200);
            rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 750, 360));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home2.png"))); // NOI18N
        jLabel1.setToolTipText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, -1, -1));

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
        jPanel3.add(hm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 90, 40));

        d11.setBackground(new java.awt.Color(31, 54, 77));
        d11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d11.setFocusable(false);
        jPanel3.add(d11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 160, 80));

        hm3.setBackground(new java.awt.Color(0, 153, 153));
        hm3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm3.setForeground(new java.awt.Color(44, 62, 80));
        hm3.setFocusable(false);
        jPanel3.add(hm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, 180, 40));

        d12.setBackground(new java.awt.Color(31, 54, 77));
        d12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d12.setFocusable(false);
        jPanel3.add(d12, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 160, 80));

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

        rSMaterialButtonRectangle6.setText("Manage Customers");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        jPanel7.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 380, 40));

        rSMaterialButtonRectangle33.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle33.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle33, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 420, 35));

        rSMaterialButtonRectangle9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 320, 15));

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
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, 30, 30));

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
        jPanel7.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 30, 30));

        rSMaterialButtonRectangle10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 320, 15));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 80));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel3.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 655, 1130, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel3.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 1130, 25));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 150, 20));

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
        jPanel3.add(hm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 90, 40));

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
        jPanel3.add(hm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 90, 40));

        Printbtn.setBackground(new java.awt.Color(255, 255, 255));
        Printbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Printbtn.setForeground(new java.awt.Color(44, 62, 80));
        Printbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Printer-icon.png"))); // NOI18N
        Printbtn.setText("Print");
        Printbtn.setMargin(new java.awt.Insets(2, 4, 2, 4));
        Printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintbtnActionPerformed(evt);
            }
        });
        jPanel3.add(Printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 610, -1, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Search(String str) {

        dtm = (DefaultTableModel) rSTableMetro1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
        rSTableMetro1.setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));

//        if (str.trim().length() == 0) {
//            trs.setRowFilter(null);
//        } else {
//            trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
//        }
    }

    public void NewDisplayCustomer() {

        try {

            int J_table;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select CId,CName,CPassword,RePass,CPhone,CAddress,CEmail from customer");
            resultset = prestm.executeQuery();

            ResultSetMetaData rsmd = resultset.getMetaData();
            J_table = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) rSTableMetro1.getModel();
            dtm.setRowCount(0);

            while (resultset.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(resultset.getString("CId"));
                    v.add(resultset.getString("CName"));
                    v.add(resultset.getString("CPassword"));
                    v.add(resultset.getString("RePass"));
                    v.add(resultset.getString("CPhone"));
                    v.add(resultset.getString("CAddress"));
                    v.add(resultset.getString("CEmail"));
                }
                dtm.addRow(v);
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, ex);

        }
    }


    private void CIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CIdTextFieldKeyReleased
        Search(CIdTextField.getText().trim());
    }//GEN-LAST:event_CIdTextFieldKeyReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSTableMetro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro1MouseClicked
        try {

            DefaultTableModel update = (DefaultTableModel) rSTableMetro1.getModel();
            int selectedindex = rSTableMetro1.getSelectedRow();

            CNameTextField.setText(update.getValueAt(selectedindex, 1).toString());
            CPasswordTextField.setText(update.getValueAt(selectedindex, 2).toString());
            CPhoneTextField.setText(update.getValueAt(selectedindex, 4).toString());
            addresstxt.setText(update.getValueAt(selectedindex, 5).toString());
            CEmailTextField1.setText(update.getValueAt(selectedindex, 6).toString());

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT COUNT(*) FROM orders where CName='" + update.getValueAt(selectedindex, 1).toString() + "'");
            prestm2 = connection.prepareStatement("SELECT SUM(TotalAmount) FROM orders where CName='" + update.getValueAt(selectedindex, 1).toString() + "'");
            resultset = prestm.executeQuery();
            resultset2 = prestm2.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("COUNT(*)");

                OrderNumber.setText(String.valueOf(count));

            }

            while (resultset2.next()) {
                int count = resultset2.getInt("Sum(TotalAmount)");

                OrderAmount.setText(String.valueOf(count) + " Tk");

            }

        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_rSTableMetro1MouseClicked

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void hm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm5ActionPerformed

        if (CNameTextField.getText().isEmpty()
                || CPasswordTextField.getText().isEmpty()
                || CPhoneTextField.getText().isEmpty()
                || addresstxt.getText().isEmpty()
                || CEmailTextField1.getText().isEmpty()) {

            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_LEFT, "Missing Information");
            panel.showNotification();

        } else {

            try {

                DefaultTableModel update = (DefaultTableModel) rSTableMetro1.getModel();

                int selectedindex = rSTableMetro1.getSelectedRow();

                int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                int showresult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record ? ", "Warring", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (showresult == JOptionPane.YES_NO_OPTION) {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("delete from customer where CId =? ");

                    prestm.setInt(1, id);
                    int k = prestm.executeUpdate();

                    NewDisplayCustomer();
                }
            } catch (HeadlessException | NumberFormatException | SQLException ex) {

            }
        }
    }//GEN-LAST:event_hm5ActionPerformed

    private void hm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm2ActionPerformed

        if (CNameTextField.getText().isEmpty()
                || CPasswordTextField.getText().isEmpty()
                || CPhoneTextField.getText().isEmpty()
                || addresstxt.getText().isEmpty()
                || CEmailTextField1.getText().isEmpty()) {

            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_LEFT, "Missing Information");
            panel.showNotification();

        } else {

            try {
                DefaultTableModel update = (DefaultTableModel) rSTableMetro1.getModel();
                int selectedindex = rSTableMetro1.getSelectedRow();

                int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("update customer set CName=?, CPassword=?,RePass=?, CPhone=?, CAddress=?, CEmail=? where CId=? ");

                prestm.setString(1, CNameTextField.getText());
                prestm.setString(2, CPasswordTextField.getText());
                prestm.setString(3, CPasswordTextField.getText());
                prestm.setString(4, CPhoneTextField.getText());
                prestm.setString(5, addresstxt.getText());
                prestm.setString(6, CEmailTextField1.getText());

                prestm.setInt(7, id);

                prestm.executeUpdate();

                Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_LEFT, "Customer updated");
                panel.showNotification();

                NewDisplayCustomer();

            } catch (HeadlessException | NumberFormatException | SQLException ex) {

                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_LEFT, "Duplicate entry (" + CPasswordTextField.getText() + ")");
                panel.showNotification();

            }
        }
    }//GEN-LAST:event_hm2ActionPerformed

    private void hm6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm6ActionPerformed

        if (CNameTextField.getText().isEmpty()
                || CPasswordTextField.getText().isEmpty()
                || CPhoneTextField.getText().isEmpty()
                || addresstxt.getText().isEmpty()
                || CEmailTextField1.getText().isEmpty()) {

            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_LEFT, "Missing Information");
            panel.showNotification();

        } else {

            try {

                connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("Insert into customer(CName, CPassword,RePass, CPhone, CAddress,CEmail)values(?,?,?,?,?,?) ");

                prestm.setString(1, CNameTextField.getText());
                prestm.setString(2, CPasswordTextField.getText());
                prestm.setString(3, CPasswordTextField.getText());
                prestm.setString(4, CPhoneTextField.getText());
                prestm.setString(5, addresstxt.getText());
                prestm.setString(6, CEmailTextField1.getText());

                int k = prestm.executeUpdate();

                if (k == 1) {

                    Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_LEFT, "Customer Added");
                    panel.showNotification();

                    NewDisplayCustomer();
                }

            } catch (HeadlessException | SQLException ex) {

                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_LEFT, "Duplicate entry (" + CPasswordTextField.getText() + ")");
                panel.showNotification();
            }

        }
    }//GEN-LAST:event_hm6ActionPerformed
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Close.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/WhiteClose.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setExtendedState(CustomerList.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/miniminuwsedited.png")));
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/white_miniminuws.png")));

    }//GEN-LAST:event_minimizeMouseExited

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed

        MessageFormat header = new MessageFormat("Customers List");
        MessageFormat footer = new MessageFormat("(HSMS)");

        try {
            rSTableMetro1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_PrintbtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new CustomerList().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CEmailTextField1;
    private javax.swing.JTextField CIdTextField;
    private javax.swing.JTextField CNameTextField;
    private javax.swing.JTextField CPasswordTextField;
    private javax.swing.JTextField CPhoneTextField;
    private javax.swing.JLabel DashBoardSellersName1;
    private javax.swing.JLabel DashBoardSellersName3;
    private javax.swing.JLabel OrderAmount;
    private javax.swing.JLabel OrderNumber;
    private javax.swing.JButton Printbtn;
    private javax.swing.JTextField addresstxt;
    private rojerusan.RSMaterialButtonRectangle d11;
    private rojerusan.RSMaterialButtonRectangle d12;
    private rojerusan.RSMaterialButtonRectangle hm2;
    private rojerusan.RSMaterialButtonRectangle hm3;
    private rojerusan.RSMaterialButtonRectangle hm4;
    private rojerusan.RSMaterialButtonRectangle hm5;
    private rojerusan.RSMaterialButtonRectangle hm6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimize;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle33;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private rojerusan.RSTableMetro rSTableMetro1;
    // End of variables declaration//GEN-END:variables
}
