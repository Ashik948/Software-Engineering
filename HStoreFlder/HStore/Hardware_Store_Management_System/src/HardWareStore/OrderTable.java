package HardWareStore;

import com.mysql.jdbc.ResultSetMetaData;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mahmud
 */
public class OrderTable extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    DefaultTableModel dtm;
    int GlobalID;
    
    String seller;

    static long start = System.currentTimeMillis();

    /**
     * Creates new form OrderTable
     */
    public OrderTable() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        try {
            OrderlistTable.setRowSelectionInterval(0, 0);
        } catch (Exception ez) {

        }
        DisplayOrders();
    }

    OrderTable(String globalseller) {
        
         initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        try {
            OrderlistTable.setRowSelectionInterval(0, 0);
        } catch (Exception ez) {

        }
        DisplayOrders();
        seller = globalseller;
    }

    // Display ---------------------------------------
    public void DisplayOrders() {

        try {

            int J_table;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select * from orders");
            resultset = prestm.executeQuery();

            ResultSetMetaData rsmd = (ResultSetMetaData) resultset.getMetaData();
            J_table = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) OrderlistTable.getModel();
            dtm.setRowCount(0);

            while (resultset.next()) {

                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(resultset.getInt("Rid"));
                    v.add(resultset.getString("CName"));
                    v.add(resultset.getString("CAddress"));
                    v.add(resultset.getString("PName"));
                    v.add(resultset.getString("Quantity") + " items");
                    v.add(resultset.getString("PPrice") + " Tk");
                    v.add(resultset.getString("TotalAmount") + " Tk");
                    v.add(resultset.getString("Discount") + "%");
                    v.add(resultset.getString("PDelivery") + " Tk");
                    v.add(resultset.getString("Date"));
                    v.add(resultset.getString("Time"));

                }
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void Search(String str) {

        dtm = (DefaultTableModel) OrderlistTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
        OrderlistTable.setRowSorter(trs);

        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));

        AnotherGetItemImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShoeTablePanel = new javax.swing.JPanel();
        OrderDelete = new javax.swing.JButton();
        PName = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        PImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle35 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle13 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle16 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        OrderlistTable = new rojerusan.RSTableMetro();
        rSMaterialButtonRectangle36 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle37 = new rojerusan.RSMaterialButtonRectangle();
        Printbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        ShoeTablePanel.setBackground(new java.awt.Color(14, 42, 71));
        ShoeTablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderDelete.setBackground(new java.awt.Color(0, 153, 153));
        OrderDelete.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderDelete.setForeground(new java.awt.Color(51, 51, 51));
        OrderDelete.setText("Delete an Order");
        OrderDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderDeleteActionPerformed(evt);
            }
        });
        ShoeTablePanel.add(OrderDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, 30));

        PName.setEditable(false);
        PName.setBackground(new java.awt.Color(53, 75, 97));
        PName.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PName.setForeground(new java.awt.Color(53, 75, 97));
        PName.setDisabledTextColor(new java.awt.Color(44, 62, 80));
        ShoeTablePanel.add(PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 10, 30));

        jLabel26.setBackground(new java.awt.Color(246, 45, 12));
        jLabel26.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Search");
        ShoeTablePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, 40));

        jPanel9.setBackground(new java.awt.Color(31, 54, 77));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PImage.setBackground(new java.awt.Color(0, 204, 204));
        PImage.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        PImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/output-onlinepngtools.png"))); // NOI18N
        PImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel9.add(PImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 180));

        jLabel9.setBackground(new java.awt.Color(246, 45, 12));
        jLabel9.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Product Image");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 230, 40));

        ShoeTablePanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 250, 240));

        search.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(44, 62, 80));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        ShoeTablePanel.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 360, 30));

        jPanel11.setBackground(new java.awt.Color(31, 54, 77));
        jPanel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel11MouseDragged(evt);
            }
        });
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel11MousePressed(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSMaterialButtonRectangle7.setText("Search Orders");
        rSMaterialButtonRectangle7.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });
        jPanel11.add(rSMaterialButtonRectangle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 320, 40));

        rSMaterialButtonRectangle35.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle35.setFocusable(false);
        jPanel11.add(rSMaterialButtonRectangle35, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 380, 35));

        rSMaterialButtonRectangle13.setBackground(new java.awt.Color(0, 204, 204));
        jPanel11.add(rSMaterialButtonRectangle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 340, 15));

        rSMaterialButtonRectangle16.setBackground(new java.awt.Color(0, 204, 204));
        jPanel11.add(rSMaterialButtonRectangle16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 350, 15));

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
        jPanel11.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 30, 30));

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
        jPanel11.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 30, 30));

        ShoeTablePanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 80));

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle5ActionPerformed(evt);
            }
        });
        ShoeTablePanel.add(rSMaterialButtonRectangle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 120, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-arrow.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        ShoeTablePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, -1, -1));

        OrderlistTable.setForeground(new java.awt.Color(255, 153, 0));
        OrderlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RId", "CName", "CAddress", "Product", "Quantity", "Price", "TotalAmt", "Discount", "Delivery", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderlistTable.setColorBackgoundHead(new java.awt.Color(31, 54, 77));
        OrderlistTable.setColorBordeFilas(new java.awt.Color(255, 153, 0));
        OrderlistTable.setColorBordeHead(new java.awt.Color(255, 153, 0));
        OrderlistTable.setColorFilasForeground1(new java.awt.Color(31, 54, 77));
        OrderlistTable.setColorFilasForeground2(new java.awt.Color(31, 54, 77));
        OrderlistTable.setColorSelBackgound(new java.awt.Color(0, 204, 204));
        OrderlistTable.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        OrderlistTable.setFuenteFilas(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        OrderlistTable.setFuenteFilasSelect(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        OrderlistTable.setFuenteHead(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        OrderlistTable.setRowHeight(25);
        OrderlistTable.setShowGrid(false);
        OrderlistTable.getTableHeader().setReorderingAllowed(false);
        OrderlistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderlistTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(OrderlistTable);
        if (OrderlistTable.getColumnModel().getColumnCount() > 0) {
            OrderlistTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            OrderlistTable.getColumnModel().getColumn(0).setMaxWidth(50);
            OrderlistTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            OrderlistTable.getColumnModel().getColumn(1).setMaxWidth(200);
            OrderlistTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            OrderlistTable.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        ShoeTablePanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1090, 230));

        rSMaterialButtonRectangle36.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle36.setFocusable(false);
        ShoeTablePanel.add(rSMaterialButtonRectangle36, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 625, 1120, 20));

        rSMaterialButtonRectangle37.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle37.setFocusable(false);
        ShoeTablePanel.add(rSMaterialButtonRectangle37, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 620, 1120, 25));

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
        ShoeTablePanel.add(Printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1114, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ShoeTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ShoeTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OrderDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderDeleteActionPerformed

        DefaultTableModel update = (DefaultTableModel) OrderlistTable.getModel();

        int selectedindex = OrderlistTable.getSelectedRow();

        int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

        if (selectedindex < 0) {

            JOptionPane.showMessageDialog(this, "Missing Information");

        } else {

            try {

                int showresult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record ? ", "Warring", JOptionPane.YES_NO_OPTION);

                if (showresult == JOptionPane.YES_NO_OPTION) {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("delete from orders where Rid =? ");

                    prestm.setInt(1, id);
                    int k = prestm.executeUpdate();

                    DisplayOrders();
                }
            } catch (HeadlessException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_OrderDeleteActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void rSMaterialButtonRectangle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle5ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        new OrdersAdmin(seller).setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void OrderlistTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderlistTableMouseClicked
        try {
            DefaultTableModel update = (DefaultTableModel) OrderlistTable.getModel();

            int selectedindex = OrderlistTable.getSelectedRow();

            GlobalID = (int) update.getValueAt(selectedindex, 0);
            PName.setText(update.getValueAt(selectedindex, 3).toString());

            GetItemImage();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_OrderlistTableMouseClicked
    private int xm, ym;
    private void jPanel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MousePressed
        xm = evt.getX();
        ym = evt.getY();
    }//GEN-LAST:event_jPanel11MousePressed

    private void jPanel11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xm, y - ym);
    }//GEN-LAST:event_jPanel11MouseDragged

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

        MessageFormat header = new MessageFormat("Customers Orders");
        MessageFormat footer = new MessageFormat("(HSMS)");

        try {
            OrderlistTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_PrintbtnActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        Search(search.getText().trim());
    }//GEN-LAST:event_searchKeyReleased

    private ImageIcon ResizePhoto(String ImagePath, byte[] Photo) {

        ImageIcon MyImage = null;

        if (ImagePath != null) {

            MyImage = new ImageIcon(ImagePath);

        } else {

            MyImage = new ImageIcon(Photo);
        }

        Image img = MyImage.getImage();

        Image newimg = img.getScaledInstance(PImage.getWidth(), PImage.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon image = new ImageIcon(newimg);

        return image;

    }

    public void GetItemImage() {

        try {

            prestm = connection.prepareStatement("select PImage from orders where Rid=" + GlobalID);

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery();

            if (resultset.next()) {

                PImage.setIcon(ResizePhoto(null, resultset.getBytes("PImage")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void AnotherGetItemImage() {

        try {

            prestm = connection.prepareStatement("select PImage from orders where CName='" + search.getText().trim() + "'");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery();

            if (resultset.next()) {

                PImage.setIcon(ResizePhoto(null, resultset.getBytes("PImage")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(OrderTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new OrderTable().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OrderDelete;
    private rojerusan.RSTableMetro OrderlistTable;
    private javax.swing.JLabel PImage;
    private javax.swing.JTextField PName;
    private javax.swing.JButton Printbtn;
    private javax.swing.JPanel ShoeTablePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel minimize;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle13;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle16;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle35;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle36;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle37;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
