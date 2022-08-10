package HardWareStore;

import com.mysql.jdbc.Blob;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.prefs.Preferences;
import javaswingdev.Notification2;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mahmud
 */
public class ProductsList extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    String imagepath;

    String path;

    Blob blob;

    DefaultTableModel dtm;

    static long start = System.currentTimeMillis();

    /**
     * Creates new form Items
     */
    public ProductsList() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        GetComboItems();
        DisplayProduct();
        GetItemImage();

        ProductTable.setRowSelectionInterval(0, 0);

        AutoCompleteDecorator.decorate(CatagoryComboBox);
    }

    private void GetComboItems() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT DISTINCT PCategory FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                String count = resultset.getString("PCategory");

                CatagoryComboBox.addItem(count);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    // Display ---------------------------------------
    public void DisplayProduct() {

        try {

            int J_table;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select * from products");
            resultset = prestm.executeQuery();

            ResultSetMetaData rsmd = resultset.getMetaData();
            J_table = rsmd.getColumnCount();
            dtm = (DefaultTableModel) ProductTable.getModel();
            dtm.setRowCount(0);

            while (resultset.next()) {

                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(resultset.getString("PId"));
                    v.add(resultset.getString("PCategory"));
                    v.add(resultset.getString("Brand"));
                    v.add(resultset.getString("PName"));
                    v.add(resultset.getString("PPrice") + " Tk");
                    v.add(resultset.getString("PQuantity") + " items");
                    v.add(resultset.getString("Warranty"));
                    v.add(resultset.getString("Discount") + "%");
                    v.add(resultset.getString("HDCost") + " Tk");
                    v.add(resultset.getString("PDescription"));

                }
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void Search(String str) {

        dtm = (DefaultTableModel) ProductTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
        ProductTable.setRowSorter(trs);
//        trs.setRowFilter(RowFilter.regexFilter(str));
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CatagoryComboBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        PQuantity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PImage = new javax.swing.JLabel();
        PName = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        PPrice = new javax.swing.JTextField();
        Discount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        brand = new javax.swing.JTextField();
        warranty = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionpane = new javax.swing.JEditorPane();
        HomeDeliveryfield = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CIdTextField = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle33 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle12 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle13 = new rojerusan.RSMaterialButtonRectangle();
        minimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        hm6 = new rojerusan.RSMaterialButtonRectangle();
        hm2 = new rojerusan.RSMaterialButtonRectangle();
        hm5 = new rojerusan.RSMaterialButtonRectangle();
        jLabel1 = new javax.swing.JLabel();
        hm7 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProductTable = new rojerusan.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(14, 42, 71));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CatagoryComboBox.setBackground(new java.awt.Color(240, 240, 240));
        CatagoryComboBox.setEditable(true);
        CatagoryComboBox.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        CatagoryComboBox.setForeground(new java.awt.Color(53, 75, 97));
        CatagoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a category" }));
        jPanel1.add(CatagoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 230, 30));

        jLabel14.setBackground(new java.awt.Color(246, 45, 12));
        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Description");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 140, 40));

        PQuantity.setBackground(new java.awt.Color(31, 54, 77));
        PQuantity.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(PQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 230, 30));

        jLabel13.setBackground(new java.awt.Color(246, 45, 12));
        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Price");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 130, 40));

        jLabel12.setBackground(new java.awt.Color(246, 45, 12));
        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quantity");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, 40));

        jLabel16.setBackground(new java.awt.Color(246, 45, 12));
        jLabel16.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Products Info");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, -1, -1));

        jLabel18.setBackground(new java.awt.Color(246, 45, 12));
        jLabel18.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("H.D.Cost");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, 40));

        jLabel9.setBackground(new java.awt.Color(246, 45, 12));
        jLabel9.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Product Image");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, 140, 40));

        PImage.setBackground(new java.awt.Color(0, 204, 204));
        PImage.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        PImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/output-onlinepngtools.png"))); // NOI18N
        PImage.setToolTipText("Select a product image");
        PImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PImageMouseClicked(evt);
            }
        });
        jPanel1.add(PImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 230, 190));

        PName.setBackground(new java.awt.Color(31, 54, 77));
        PName.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(PName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 230, 30));

        jLabel19.setBackground(new java.awt.Color(246, 45, 12));
        jLabel19.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Product");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 40));

        PPrice.setBackground(new java.awt.Color(31, 54, 77));
        PPrice.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PPrice.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(PPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 230, 30));

        Discount.setBackground(new java.awt.Color(31, 54, 77));
        Discount.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Discount.setForeground(new java.awt.Color(255, 255, 255));
        Discount.setToolTipText("Discount for Home Shoppers.");
        jPanel1.add(Discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 110, 30));

        jLabel20.setBackground(new java.awt.Color(246, 45, 12));
        jLabel20.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DHS");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 40, 40));

        jLabel21.setBackground(new java.awt.Color(246, 45, 12));
        jLabel21.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Warranty");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 100, 40));

        jLabel22.setBackground(new java.awt.Color(246, 45, 12));
        jLabel22.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Brand");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 60, 40));

        brand.setBackground(new java.awt.Color(31, 54, 77));
        brand.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        brand.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 110, 30));

        warranty.setBackground(new java.awt.Color(31, 54, 77));
        warranty.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        warranty.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(warranty, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 130, 30));

        jPanel9.setBackground(new java.awt.Color(31, 54, 77));
        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 160, 250, 270));

        descriptionpane.setBackground(new java.awt.Color(31, 54, 77));
        descriptionpane.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        descriptionpane.setForeground(new java.awt.Color(31, 54, 77));
        descriptionpane.setOpaque(false);
        jScrollPane3.setViewportView(descriptionpane);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 260, 130));

        HomeDeliveryfield.setBackground(new java.awt.Color(31, 54, 77));
        HomeDeliveryfield.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        HomeDeliveryfield.setForeground(new java.awt.Color(255, 255, 255));
        HomeDeliveryfield.setToolTipText("Home Delivery.");
        HomeDeliveryfield.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(HomeDeliveryfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 130, 30));

        jLabel23.setBackground(new java.awt.Color(246, 45, 12));
        jLabel23.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Category");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 100, 40));

        jLabel25.setBackground(new java.awt.Color(246, 45, 12));
        jLabel25.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Search");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 40));

        CIdTextField.setBackground(new java.awt.Color(240, 240, 240));
        CIdTextField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CIdTextField.setForeground(new java.awt.Color(44, 62, 80));
        CIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CIdTextFieldKeyReleased(evt);
            }
        });
        jPanel1.add(CIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 230, 30));

        jPanel10.setBackground(new java.awt.Color(31, 54, 77));
        jPanel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel10MouseDragged(evt);
            }
        });
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSMaterialButtonRectangle6.setText("Manage Products");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 410, 40));

        rSMaterialButtonRectangle33.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle33.setFocusable(false);
        jPanel10.add(rSMaterialButtonRectangle33, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 450, 35));

        rSMaterialButtonRectangle12.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.add(rSMaterialButtonRectangle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 360, 15));

        rSMaterialButtonRectangle13.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.add(rSMaterialButtonRectangle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 360, 15));

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
        jPanel10.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 30, 30));

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
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 30, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 80));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 160, 20));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 1200, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 675, 1200, 25));

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
        jPanel1.add(hm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 90, 40));

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
        jPanel1.add(hm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 90, 40));

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
        jPanel1.add(hm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 90, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home2.png"))); // NOI18N
        jLabel1.setToolTipText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 100, -1, -1));

        hm7.setBackground(new java.awt.Color(0, 204, 204));
        hm7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm7.setText("Clear");
        hm7.setFocusable(false);
        hm7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        hm7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hm7ActionPerformed(evt);
            }
        });
        jPanel1.add(hm7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 90, 40));

        ProductTable.setForeground(new java.awt.Color(255, 153, 0));
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PId", "Category", "Brand", "Product", "Price", "Quantity", "Warranty", "Discount", "Delivery", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.setColorBackgoundHead(new java.awt.Color(31, 54, 77));
        ProductTable.setColorBordeFilas(new java.awt.Color(255, 153, 0));
        ProductTable.setColorBordeHead(new java.awt.Color(255, 153, 0));
        ProductTable.setColorFilasForeground1(new java.awt.Color(31, 54, 77));
        ProductTable.setColorFilasForeground2(new java.awt.Color(31, 54, 77));
        ProductTable.setColorSelBackgound(new java.awt.Color(0, 204, 204));
        ProductTable.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ProductTable.setFuenteFilas(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ProductTable.setFuenteFilasSelect(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ProductTable.setFuenteHead(new java.awt.Font("Trajan Pro", 1, 12)); // NOI18N
        ProductTable.setRowHeight(25);
        ProductTable.setShowGrid(false);
        ProductTable.getTableHeader().setReorderingAllowed(false);
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            ProductTable.getColumnModel().getColumn(0).setMaxWidth(50);
            ProductTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            ProductTable.getColumnModel().getColumn(2).setMaxWidth(100);
            ProductTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            ProductTable.getColumnModel().getColumn(3).setMaxWidth(200);
            ProductTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            ProductTable.getColumnModel().getColumn(5).setMaxWidth(100);
            ProductTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            ProductTable.getColumnModel().getColumn(7).setMaxWidth(100);
            ProductTable.getColumnModel().getColumn(8).setPreferredWidth(100);
            ProductTable.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 1180, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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


    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Preferences pref = Preferences.userRoot();

        String PathDefult = pref.get("DEFAULT_PATH", "");

        JFileChooser file = new JFileChooser();

        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png", "gif");

        file.addChoosableFileFilter(filter);

        file.setCurrentDirectory(new File(PathDefult));

        int result = file.showSaveDialog(file);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedfile = file.getSelectedFile();

            path = selectedfile.getAbsolutePath();

            file.setCurrentDirectory(selectedfile);

            pref.put("DEFAULT_PATH", selectedfile.getAbsolutePath());

            PImage.setIcon(ResizePhoto(path, null));

            imagepath = path;

        } else if (result == JFileChooser.CANCEL_OPTION) {

            // JOptionPane.showMessageDialog(this, "No File Selected");
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void PImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PImageMouseClicked

        Preferences pref = Preferences.userRoot();

        String PathDefult = pref.get("DEFAULT_PATH", "");

        JFileChooser file = new JFileChooser();

        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg", "png", "gif");

        file.addChoosableFileFilter(filter);

        file.setCurrentDirectory(new File(PathDefult));

        int result = file.showSaveDialog(file);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedfile = file.getSelectedFile();

            path = selectedfile.getAbsolutePath();

            file.setCurrentDirectory(selectedfile);

            pref.put("DEFAULT_PATH", selectedfile.getAbsolutePath());

            PImage.setIcon(ResizePhoto(path, null));

            imagepath = path;

        } else if (result == JFileChooser.CANCEL_OPTION) {

            // JOptionPane.showMessageDialog(this, "No File Selected");
        }
    }//GEN-LAST:event_PImageMouseClicked

    private void CIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CIdTextFieldKeyReleased
        Search(CIdTextField.getText().trim());
    }//GEN-LAST:event_CIdTextFieldKeyReleased

    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void hm6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm6ActionPerformed

        if (PName.getText().isEmpty()
                || PPrice.getText().isEmpty()
                || PQuantity.getText().isEmpty()
                || warranty.getText().isEmpty()
                || brand.getText().isEmpty()
                || Discount.getText().isEmpty()
                || HomeDeliveryfield.getText().isEmpty()
                || descriptionpane.getText().isEmpty()
                || CatagoryComboBox.getSelectedIndex() == 0) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_RIGHT, "Missing Information");
            panel.showNotification();

        } else if (imagepath == null) {

            Notification2 panel = new Notification2(this, Notification2.Type.INFO, Notification2.Location.TOP_RIGHT, "Select the Product Image");
            panel.showNotification();
        } else {

            try {

                connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("Insert into products(PName, PPrice,PQuantity,PCategory,Brand,Warranty,Discount,HDCost,PDescription,PImage)values(?,?,?,?,?,?,?,?,?,?) ");

                prestm.setString(1, PName.getText());
                prestm.setInt(2, Integer.valueOf(PPrice.getText()));
                prestm.setInt(3, Integer.valueOf(PQuantity.getText()));
                prestm.setString(4, CatagoryComboBox.getSelectedItem().toString());
                prestm.setString(5, brand.getText());
                prestm.setString(6, warranty.getText());
                prestm.setInt(7, Integer.valueOf(Discount.getText()));
                prestm.setInt(8, Integer.valueOf(HomeDeliveryfield.getText()));
                prestm.setString(9, descriptionpane.getText());

                InputStream img = new FileInputStream(imagepath);

                prestm.setBlob(10, img);

                int k = prestm.executeUpdate();

                if (k == 1) {

                    DisplayProduct();
                    CatagoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a category"}));
                    GetComboItems();

                    Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_RIGHT, "Product added");
                    panel.showNotification();
                }

            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(this, ex);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, ex);

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }

    }//GEN-LAST:event_hm6ActionPerformed

    private void hm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm2ActionPerformed

        if (PName.getText().isEmpty()
                || PPrice.getText().isEmpty()
                || PQuantity.getText().isEmpty()
                || warranty.getText().isEmpty()
                || Discount.getText().isEmpty()
                || HomeDeliveryfield.getText().isEmpty()
                || brand.getText().isEmpty()
                || descriptionpane.getText().isEmpty()
                || CatagoryComboBox.getSelectedIndex() == 0) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_RIGHT, "Missing Information");
            panel.showNotification();

        } else {

            try {
                DefaultTableModel update = (DefaultTableModel) ProductTable.getModel();
                int selectedindex = ProductTable.getSelectedRow();

                int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("update products set PName=?,PPrice=?, PQuantity=?, PCategory=?,Brand=?,Warranty=?,Discount=?,HDCost=?, PDescription=?,PImage=? where PId =? ");

                prestm.setString(1, PName.getText());
                prestm.setInt(2, Integer.valueOf(PPrice.getText()));
                prestm.setInt(3, Integer.valueOf(PQuantity.getText()));
                prestm.setString(4, CatagoryComboBox.getSelectedItem().toString());

                prestm.setString(5, brand.getText());
                prestm.setString(6, warranty.getText());

                prestm.setInt(7, Integer.valueOf(Discount.getText()));
                prestm.setInt(8, Integer.valueOf(HomeDeliveryfield.getText()));

                prestm.setString(9, descriptionpane.getText());

                prestm.setBlob(10, blob);

                prestm.setInt(11, id);

                prestm.executeUpdate();

                DisplayProduct();
                CatagoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a category"}));
                GetComboItems();

                Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_RIGHT, "Product info updated");
                panel.showNotification();

            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_hm2ActionPerformed

    private void hm5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm5ActionPerformed

        if (PName.getText().isEmpty()
                || PPrice.getText().isEmpty()
                || PQuantity.getText().isEmpty()
                || warranty.getText().isEmpty()
                || Discount.getText().isEmpty()
                || brand.getText().isEmpty()
                || descriptionpane.getText().isEmpty()
                || CatagoryComboBox.getSelectedIndex() == 0) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_RIGHT, "Missing Information");
            panel.showNotification();

        } else {

            try {

                DefaultTableModel update = (DefaultTableModel) ProductTable.getModel();

                int selectedindex = ProductTable.getSelectedRow();

                int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

                int showresult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record ? ", "Warring", JOptionPane.YES_NO_OPTION);

                if (showresult == JOptionPane.YES_NO_OPTION) {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("delete from products where PId =? ");

                    prestm.setInt(1, id);
                    int k = prestm.executeUpdate();

                    DisplayProduct();
                    CatagoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a category"}));
                    GetComboItems();

                }
            } catch (HeadlessException | NumberFormatException | SQLException ex) {
                // JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_hm5ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void hm7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hm7ActionPerformed

        PName.setText("");
        PPrice.setText("");
        PQuantity.setText("");
        Discount.setText("");
        HomeDeliveryfield.setText("");
        descriptionpane.setText("");
        warranty.setText("");
        brand.setText("");
        CatagoryComboBox.setSelectedItem("");

        PImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FrameIcon.png")));
    }//GEN-LAST:event_hm7ActionPerformed

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        try {

            DefaultTableModel update = (DefaultTableModel) ProductTable.getModel();

            int selectedindex = ProductTable.getSelectedRow();

            key = Integer.valueOf(update.getValueAt(selectedindex, 0).toString());
            CatagoryComboBox.setSelectedItem(update.getValueAt(selectedindex, 1).toString());

            brand.setText(update.getValueAt(selectedindex, 2).toString());
            PName.setText(update.getValueAt(selectedindex, 3).toString());
            PPrice.setText(update.getValueAt(selectedindex, 4).toString());
            PQuantity.setText(update.getValueAt(selectedindex, 5).toString());

            warranty.setText(update.getValueAt(selectedindex, 6).toString());
            Discount.setText(update.getValueAt(selectedindex, 7).toString());
            HomeDeliveryfield.setText(update.getValueAt(selectedindex, 8).toString());

            descriptionpane.setText(update.getValueAt(selectedindex, 9).toString());

            GetItemImage();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_ProductTableMouseClicked
    private int xm, ym;
    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
        xm = evt.getX();
        ym = evt.getY();
    }//GEN-LAST:event_jPanel10MousePressed

    private void jPanel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xm, y - ym);
    }//GEN-LAST:event_jPanel10MouseDragged

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

    public void GetItemImage() {

        try {

            String query = "select PImage from products where PId = " + key;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery(query);

            if (resultset.next()) {

                PImage.setIcon(ResizePhoto(null, resultset.getBytes("PImage")));
                blob = (Blob) resultset.getBlob("PImage");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    int key = 0;

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
            java.util.logging.Logger.getLogger(ProductsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CIdTextField;
    private javax.swing.JComboBox<String> CatagoryComboBox;
    private javax.swing.JTextField Discount;
    private javax.swing.JTextField HomeDeliveryfield;
    private javax.swing.JLabel PImage;
    private javax.swing.JTextField PName;
    private javax.swing.JTextField PPrice;
    private javax.swing.JTextField PQuantity;
    private rojerusan.RSTableMetro ProductTable;
    private javax.swing.JTextField brand;
    private javax.swing.JEditorPane descriptionpane;
    private rojerusan.RSMaterialButtonRectangle hm2;
    private rojerusan.RSMaterialButtonRectangle hm5;
    private rojerusan.RSMaterialButtonRectangle hm6;
    private rojerusan.RSMaterialButtonRectangle hm7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel minimize;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle12;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle13;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle33;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private javax.swing.JTextField warranty;
    // End of variables declaration//GEN-END:variables

}
