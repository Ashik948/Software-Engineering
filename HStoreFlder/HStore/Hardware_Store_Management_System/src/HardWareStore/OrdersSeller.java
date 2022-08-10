package HardWareStore;

import com.mysql.jdbc.Blob;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javaswingdev.Notification;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmud
 */
public class OrdersSeller extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    String imagepath;

    Blob blob;

    String orderCName, ORderPName;
    int orderprice, orderqty, value, orderdiscount, orderdelivery;
    int TotalCost, GetQuantity;

    DefaultTableModel dtm;

    String globalseller;

    static long start = System.currentTimeMillis();

    OrdersSeller(String string, int aInt) {

        initComponents();

        getContentPane().setBackground(new Color(240, 240, 240));
        dateChooser1.addEventDateChooser((SelectedAction action, SelectedDate date) -> {
            System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser1.hidePopup();
            }
        });

//        GetOrderID();
        GetComboCustomerName();

        ImageIcon iconn = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(iconn.getImage());

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        usershow.setText("Seller: " + string);

        globalseller = string;

        if (aInt == 20) {
            Logoutlevel.show();

        } else {
            Logoutlevel.hide();

        }
    }

    OrdersSeller(int i) {

        initComponents();

        getContentPane().setBackground(new Color(240, 240, 240));
        dateChooser1.addEventDateChooser((SelectedAction action, SelectedDate date) -> {
            System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser1.hidePopup();
            }
        });

//        GetOrderID();
        GetComboCustomerName();

        ImageIcon iconn = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(iconn.getImage());

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        if (i == 0) {
            Logoutlevel.hide();
            usershow.setText("User: Admin");

        } else {
            Logoutlevel.show();
            usershow.show();

        }
    }

    OrdersSeller(String seller) {
        initComponents();

        getContentPane().setBackground(new Color(240, 240, 240));
        dateChooser1.addEventDateChooser((SelectedAction action, SelectedDate date) -> {
            System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser1.hidePopup();
            }
        });

//        GetOrderID();
        GetComboCustomerName();

        ImageIcon iconn = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(iconn.getImage());

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        usershow.setText("Seller: " + seller);

        globalseller = seller;

//        if (seller.equalsIgnoreCase("admin")) {
//            
//            Logoutlevel.hide();
//            
//        } else {
//            Logoutlevel.show();
//            
//        }
    }

    /**
     * Creates new form Orders
     */
    public void deleteOrderReq() {

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("delete from showitems where Rid  =? ");

            prestm.setInt(1, value);
            prestm.executeUpdate();

            BillOrderId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Available product request"}));

            ComboRidName();

        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public OrdersSeller() {
        initComponents();

        getContentPane().setBackground(new Color(240, 240, 240));
        dateChooser1.addEventDateChooser((SelectedAction action, SelectedDate date) -> {
            System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                dateChooser1.hidePopup();
            }
        });
//        GetOrderID();
        GetComboCustomerName();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

    }

    String dateString3;

    private void ShowDate() {

        DateFormat dateFormat3 = new SimpleDateFormat("hh.mm aa");
        dateString3 = dateFormat3.format(new Date());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        Printbtn = new javax.swing.JButton();
        AddOrder = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        billPriceCombo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TotalAmtLabel1 = new javax.swing.JLabel();
        reqAVLQTY = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        BillPImage = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TotalAmount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillPrint = new javax.swing.JTextPane();
        jLabel24 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        BillPriceCombo = new javax.swing.JTextField();
        Addresstextview = new javax.swing.JTextField();
        Discountt = new javax.swing.JTextField();
        orderDelivery = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        ConFirmOrder = new javax.swing.JButton();
        txtDate1 = new javax.swing.JTextField();
        uqtyfield = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle33 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle11 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle12 = new rojerusan.RSMaterialButtonRectangle();
        usershow = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        Logoutlevel = new javax.swing.JLabel();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        CustomerCombo = new rojerusan.RSComboMetro();
        BillOrderId = new rojerusan.RSComboMetro();
        product_price = new javax.swing.JTextField();

        dateChooser1.setForeground(new java.awt.Color(51, 153, 255));
        dateChooser1.setTextRefernce(txtDate1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(14, 42, 71));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(Printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 580, -1, 30));

        AddOrder.setBackground(new java.awt.Color(22, 31, 39));
        AddOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        AddOrder.setForeground(new java.awt.Color(255, 255, 255));
        AddOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-icon.png"))); // NOI18N
        AddOrder.setText("Add Bill");
        AddOrder.setBorder(new javax.swing.border.MatteBorder(null));
        AddOrder.setBorderPainted(false);
        AddOrder.setHideActionText(true);
        AddOrder.setIconTextGap(3);
        AddOrder.setMargin(new java.awt.Insets(2, 4, 2, 4));
        AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrderActionPerformed(evt);
            }
        });
        jPanel2.add(AddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 100, 30));

        jLabel12.setBackground(new java.awt.Color(246, 45, 12));
        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Avail Quantity");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 160, 40));

        jLabel14.setBackground(new java.awt.Color(246, 45, 12));
        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("OrderId");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 90, 40));

        billPriceCombo.setEditable(false);
        billPriceCombo.setBackground(new java.awt.Color(31, 54, 77));
        billPriceCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        billPriceCombo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(billPriceCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 220, 30));

        jLabel19.setBackground(new java.awt.Color(246, 45, 12));
        jLabel19.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Product Name");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 40));

        TotalAmtLabel1.setBackground(new java.awt.Color(246, 45, 12));
        TotalAmtLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        TotalAmtLabel1.setForeground(new java.awt.Color(255, 255, 255));
        TotalAmtLabel1.setText("Receipt");
        jPanel2.add(TotalAmtLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, -1, -1));

        reqAVLQTY.setEditable(false);
        reqAVLQTY.setBackground(new java.awt.Color(31, 54, 77));
        reqAVLQTY.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        reqAVLQTY.setForeground(new java.awt.Color(255, 255, 255));
        reqAVLQTY.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(reqAVLQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 80, 30));

        jLabel22.setBackground(new java.awt.Color(246, 45, 12));
        jLabel22.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Product Image");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 150, 40));

        BillPImage.setBackground(new java.awt.Color(0, 204, 204));
        BillPImage.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        BillPImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BillPImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/output-onlinepngtools.png"))); // NOI18N
        BillPImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        BillPImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(BillPImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 180, 140));

        jLabel23.setBackground(new java.awt.Color(246, 45, 12));
        jLabel23.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Customer");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 40));

        TotalAmount.setEditable(false);
        TotalAmount.setBackground(new java.awt.Color(31, 54, 77));
        TotalAmount.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        TotalAmount.setForeground(new java.awt.Color(255, 255, 255));
        TotalAmount.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(TotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 200, 30));

        BillPrint.setEditable(false);
        BillPrint.setBackground(new java.awt.Color(240, 240, 240));
        BillPrint.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(BillPrint);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 470, 410));

        jLabel24.setBackground(new java.awt.Color(246, 45, 12));
        jLabel24.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Address");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 80, 40));

        jLabel20.setBackground(new java.awt.Color(246, 45, 12));
        jLabel20.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Product Price");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 40));

        BillPriceCombo.setEditable(false);
        BillPriceCombo.setBackground(new java.awt.Color(31, 54, 77));
        BillPriceCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        BillPriceCombo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(BillPriceCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, 30));

        Addresstextview.setEditable(false);
        Addresstextview.setBackground(new java.awt.Color(31, 54, 77));
        Addresstextview.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Addresstextview.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(Addresstextview, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 240, 30));

        Discountt.setEditable(false);
        Discountt.setBackground(new java.awt.Color(31, 54, 77));
        Discountt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Discountt.setForeground(new java.awt.Color(255, 255, 255));
        Discountt.setText(" DHS : Status");
        Discountt.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(Discountt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 180, 30));

        orderDelivery.setEditable(false);
        orderDelivery.setBackground(new java.awt.Color(31, 54, 77));
        orderDelivery.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        orderDelivery.setForeground(new java.awt.Color(255, 255, 255));
        orderDelivery.setText(" H.D: Status");
        orderDelivery.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(orderDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 180, 30));

        jLabel25.setBackground(new java.awt.Color(246, 45, 12));
        jLabel25.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Product Cost");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 130, 40));

        ConFirmOrder.setBackground(new java.awt.Color(22, 31, 39));
        ConFirmOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        ConFirmOrder.setForeground(new java.awt.Color(255, 255, 255));
        ConFirmOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-icon.png"))); // NOI18N
        ConFirmOrder.setText("Confirm Order");
        ConFirmOrder.setBorder(new javax.swing.border.MatteBorder(null));
        ConFirmOrder.setBorderPainted(false);
        ConFirmOrder.setHideActionText(true);
        ConFirmOrder.setIconTextGap(3);
        ConFirmOrder.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ConFirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConFirmOrderActionPerformed(evt);
            }
        });
        jPanel2.add(ConFirmOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 160, 30));

        txtDate1.setBackground(new java.awt.Color(31, 54, 77));
        txtDate1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        txtDate1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 150, 30));

        uqtyfield.setEditable(false);
        uqtyfield.setBackground(new java.awt.Color(31, 54, 77));
        uqtyfield.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        uqtyfield.setForeground(new java.awt.Color(255, 255, 255));
        uqtyfield.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(uqtyfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 70, 30));

        jLabel13.setBackground(new java.awt.Color(246, 45, 12));
        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Req. Quantity");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 40));

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

        rSMaterialButtonRectangle6.setText("Manage Order");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        rSMaterialButtonRectangle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle6ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 330, 40));

        rSMaterialButtonRectangle33.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle33.setFocusable(false);
        jPanel10.add(rSMaterialButtonRectangle33, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 370, 35));

        rSMaterialButtonRectangle11.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.add(rSMaterialButtonRectangle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 340, 15));

        rSMaterialButtonRectangle12.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.add(rSMaterialButtonRectangle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 360, 15));

        usershow.setBackground(new java.awt.Color(246, 45, 12));
        usershow.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        usershow.setForeground(new java.awt.Color(255, 255, 255));
        usershow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usershow.setText("Seller");
        jPanel10.add(usershow, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, -1, 40));

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
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 30, 30));

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
        jPanel10.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 30, 30));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 80));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 120, 20));

        Logoutlevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shutdownedited.png"))); // NOI18N
        Logoutlevel.setToolTipText("Log out");
        Logoutlevel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logoutlevel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutlevelMouseClicked(evt);
            }
        });
        jPanel2.add(Logoutlevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, -1, -1));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel2.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1120, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel2.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1120, 25));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 204, 102));
        rSMaterialButtonRectangle1.setText("NOW");
        rSMaterialButtonRectangle1.setFocusable(false);
        rSMaterialButtonRectangle1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 70, 35));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle2.setText("Date");
        rSMaterialButtonRectangle2.setContentAreaFilled(false);
        rSMaterialButtonRectangle2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        rSMaterialButtonRectangle2.setType(rojerusan.RSMaterialButtonRectangle.Type.RAISED);
        rSMaterialButtonRectangle2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        rSMaterialButtonRectangle2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 70, 35));

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Show Orders");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, -1, 30));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, -1, 30));

        CustomerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selec any customer" }));
        CustomerCombo.setColorArrow(new java.awt.Color(0, 204, 204));
        CustomerCombo.setColorBorde(new java.awt.Color(0, 204, 204));
        CustomerCombo.setColorFondo(new java.awt.Color(0, 204, 204));
        CustomerCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        CustomerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerComboActionPerformed(evt);
            }
        });
        jPanel2.add(CustomerCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 210, -1));

        BillOrderId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available product request" }));
        BillOrderId.setColorArrow(new java.awt.Color(0, 204, 204));
        BillOrderId.setColorBorde(new java.awt.Color(0, 204, 204));
        BillOrderId.setColorFondo(new java.awt.Color(0, 204, 204));
        BillOrderId.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        BillOrderId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillOrderIdActionPerformed(evt);
            }
        });
        jPanel2.add(BillOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, 210, -1));

        product_price.setBackground(new java.awt.Color(31, 54, 77));
        product_price.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        product_price.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(product_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GetComboCustomerName() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT distinct CName FROM showitems");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                CustomerCombo.addItem(resultset.getString("CName"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    private void PrintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintbtnActionPerformed

        ShowDate();

        MessageFormat header = new MessageFormat("Hardware Store Bill");
        MessageFormat footer = new MessageFormat(txtDate1.getText() + " " + dateString3 + " \t[ " + CustomerCombo.getSelectedItem().toString() + " \t" + Addresstextview.getText() + " ]" + " (HSMS)");

        try {
            BillPrint.print(header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_PrintbtnActionPerformed

    public void BillArea() {

        if (flag == 1) {

            if (i == 0) {

                BillPrint.setText(BillPrint.getText() + "\n\n  ID\tProduct\tQuentity\tPrice\tTotalCost\tDiscount\n"
                        + "\t" + "\n  " + value + "\t"
                        + billPriceCombo.getText() + "\t     "
                        + reqAVLQTY.getText() + "\t"
                        + BillPriceCombo.getText() + "\t"
                        + String.valueOf(TotalAmount) + "\t    "
                        + String.valueOf(orderdiscount) + "%\n\n");

                i++;

            } else {

                BillPrint.setText(BillPrint.getText() + "  " + value + "\t"
                        + billPriceCombo.getText() + "\t     "
                        + reqAVLQTY.getText() + "\t"
                        + BillPriceCombo.getText() + "\t"
                        + String.valueOf(TotalAmount) + "\t    "
                        + String.valueOf(orderdiscount) + "%\n\n");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Select an available order request", "Order ID", JOptionPane.WARNING_MESSAGE);
        }

    }

    int i = 0;


    private void AddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOrderActionPerformed

        if (flag == 1) {

            if (i == 0) {

                i++;

                BillPrint.setText(BillPrint.getText() + "\n\n  Seller: " + globalseller + "\n\n\n  ID\tProduct\t\tQuantity\tPrice\tTotalCost\n"
                        + "\t" + "\n  " + value + "\t"
                        + billPriceCombo.getText() + "\t     "
                        + reqAVLQTY.getText() + "\t"
                        + BillPriceCombo.getText() + "\t"
                        + TotalCost + " Tk\t    \n\n");

            } else {

                i++;

                BillPrint.setText(BillPrint.getText() + "  " + value + "\t"
                        + billPriceCombo.getText() + "\t     "
                        + reqAVLQTY.getText() + "\t"
                        + BillPriceCombo.getText() + "\t"
                        + TotalCost + " Tk\t    \n\n");
            }

        } else {

            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Select an available order request");
            panel.showNotification();

        }
    }//GEN-LAST:event_AddOrderActionPerformed

    int productid, oldQty;

    int SPQTN;

    private ImageIcon ResizePhoto(String ImagePath, byte[] Photo) {

        ImageIcon MyImage = null;

        if (ImagePath != null) {

            MyImage = new ImageIcon(ImagePath);

        } else {

            MyImage = new ImageIcon(Photo);
        }

        Image img = MyImage.getImage();

        Image newimg = img.getScaledInstance(BillPImage.getWidth(), BillPImage.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon image = new ImageIcon(newimg);

        return image;

    }

    public void GetOrderImage() {

        try {

            prestm = connection.prepareStatement("SELECT PImage from showitems where Rid='" + value + "'");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery();

            if (resultset.next()) {

                BillPImage.setIcon(ResizePhoto(null, resultset.getBytes("PImage")));

                blob = (Blob) resultset.getBlob("PImage");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

//    private void GetOrderID() {
//
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
//            prestm = connection.prepareStatement("SELECT distinct Rid FROM showitems");
//            resultset = prestm.executeQuery();
//
//            while (resultset.next()) {
//                String count = resultset.getString("Rid");
//
//                BillOrderId.addItem(count);
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, ex);
//        }
//    }
    int flag = 0, setorderdelivery;

    public void getPqty() {

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT PQuantity from products where PName='" + billPriceCombo.getText() + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                GetQuantity = resultset.getInt("PQuantity");
                uqtyfield.setText(String.valueOf(GetQuantity));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void UpdateQuantity() {

        try {

            int newqty = GetQuantity - orderqty;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            prestm = connection.prepareStatement("update products set PQuantity=? where PName=?");

            prestm.setInt(1, newqty);
            prestm.setString(2, billPriceCombo.getText());
            prestm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    private void ConFirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConFirmOrderActionPerformed

        ShowDate();

        if (BillOrderId.getSelectedIndex() == 0) {

            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Missing Information");
            panel.showNotification();

        } else if (i == 0) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Add bill first");
            panel.showNotification();

        } else {

            int showresult = JOptionPane.showConfirmDialog(this, "Do you want to confirm this order?" + "\nOrder ID: " + value, "Confirm order", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (showresult == JOptionPane.YES_NO_OPTION) {

                try {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("Insert into orders(Rid, CName, CAddress, PName, Quantity, PPrice, TotalAmount, Discount,PDelivery, Date, Time,PImage)values(?,?,?,?,?,?,?,?,?,?,?,?) ");

                    prestm.setInt(1, value);
                    prestm.setString(2, CustomerCombo.getSelectedItem().toString());
                    prestm.setString(3, Addresstextview.getText());

                    prestm.setString(4, billPriceCombo.getText());
                    prestm.setInt(5, Integer.valueOf(reqAVLQTY.getText()));

                    prestm.setInt(6, orderprice);
                    prestm.setInt(7, TotalCost);
                    prestm.setInt(8, orderdiscount);
                    prestm.setInt(9, setorderdelivery);

                    prestm.setString(10, txtDate1.getText());
                    prestm.setString(11, dateString3);
                    prestm.setBlob(12, blob);

                    int k = prestm.executeUpdate();

                    if (k == 1) {

                        UpdateQuantity();
                        getPqty();
                        deleteOrderReq();

                        Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Order confirmed");
                        panel.showNotification();
                    }
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }
        }
    }//GEN-LAST:event_ConFirmOrderActionPerformed


    private void rSMaterialButtonRectangle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle6ActionPerformed

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void LogoutlevelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutlevelMouseClicked
        new Login(11).setVisible(true);
        dispose();
    }//GEN-LAST:event_LogoutlevelMouseClicked


    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        dateChooser1.toDay();
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        i = 0;
        BillPrint.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new OrderTable(globalseller).setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed
    int value2;
    private void CustomerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerComboActionPerformed

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT CAddress FROM showitems where CName='" + CustomerCombo.getSelectedItem().toString() + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                Addresstextview.setText(resultset.getString("CAddress"));

                BillOrderId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Available product request"}));
                ComboRidName();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }//GEN-LAST:event_CustomerComboActionPerformed

    private void BillOrderIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillOrderIdActionPerformed

        value = Integer.valueOf(BillOrderId.getSelectedItem().toString());

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT CName,PName,PPrice,PQuantity,PDelivery,PImage,PDiscount,pay_amount from showitems where Rid='" + value + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                ORderPName = resultset.getString("PName");

                orderprice = resultset.getInt("PPrice");
                orderqty = resultset.getInt("PQuantity");

                orderdelivery = resultset.getInt("PDelivery");

                orderdiscount = resultset.getInt("PDiscount");

                product_price.setText(resultset.getString("pay_amount")+" Tk");

                billPriceCombo.setText(ORderPName);

                BillPriceCombo.setText(orderprice + " Tk");

                reqAVLQTY.setText(orderqty + "");

                if (orderdelivery == 0) {

                    setorderdelivery = orderdelivery;

                    this.orderDelivery.setText("Cash On Delivery");
                } else {

                    setorderdelivery = orderdelivery;
                    this.orderDelivery.setText("Home Delivery: " + orderdelivery + " Tk");
                }

                if (orderdiscount == 0) {

                    this.Discountt.setText("Discount: N/A");
                    TotalCost = (int) (orderprice * orderqty) + orderdelivery;

                } else {
                    this.Discountt.setText("Discount: " + orderdiscount + "%");
                    TotalCost = (int) (orderprice * orderqty) + orderdelivery * (100 - orderdiscount) / 100;

                }

                GetOrderImage();

                TotalAmount.setText(String.valueOf(orderprice * orderqty) + " Tk");
                if (BillOrderId.getSelectedIndex() == 0) {
                    flag = 0;
                } else {
                    flag = 1;
                }

            }

            getPqty();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_BillOrderIdActionPerformed

    private void ComboRidName() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT Rid FROM showitems where CName='" + CustomerCombo.getSelectedItem().toString() + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                BillOrderId.addItem(resultset.getString("Rid"));
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
            java.util.logging.Logger.getLogger(OrdersSeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new OrdersSeller().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddOrder;
    private javax.swing.JTextField Addresstextview;
    private rojerusan.RSComboMetro BillOrderId;
    private javax.swing.JLabel BillPImage;
    private javax.swing.JTextField BillPriceCombo;
    private javax.swing.JTextPane BillPrint;
    private javax.swing.JButton ConFirmOrder;
    private rojerusan.RSComboMetro CustomerCombo;
    private javax.swing.JTextField Discountt;
    private javax.swing.JLabel Logoutlevel;
    private javax.swing.JButton Printbtn;
    private javax.swing.JTextField TotalAmount;
    private javax.swing.JLabel TotalAmtLabel1;
    private javax.swing.JTextField billPriceCombo;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField orderDelivery;
    private javax.swing.JTextField product_price;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle12;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle33;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private javax.swing.JTextField reqAVLQTY;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JTextField uqtyfield;
    private javax.swing.JLabel usershow;
    // End of variables declaration//GEN-END:variables
}
