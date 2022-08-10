package HardWareStore;

import com.mysql.jdbc.Blob;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaswingdev.Notification;
import javaswingdev.Notification2;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author Mahmud
 */
public class SearchModify extends javax.swing.JFrame {

    String imagepath;

    int rate_value, GetQuantity, PPrice, UPprice;

    String orderCName, ORderPName, pay_amount_var;
    int orderprice, orderqty, value, orderdelivery;

    Connection connection;
    PreparedStatement prestm;
    ResultSet resultset;

    String PDescription, warranty, PName, PCategory;
    String product_category;

    int discount, HDC, Homediscount = 0;

    int flag = 0, MHDC = 0, i = 0;

    Blob blob;

    String GolbalCutomer, CustomerAdress, GetAmount;

    static long start = System.currentTimeMillis();

    /**
     * Creates new form NewJFrame
     */
    public SearchModify() {
        initComponents();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        GetCustomerAddress();
        GetProductCategory();
        ComboProductName();
        GetOrderID();

        others.setSelected(true);

        int OR = OrderIDComboView.getItemCount();

        if (OR == 1) {
            OrderIDComboView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"No order avaiable"}));
        }
//        AutoCompleteDecorator.decorate(ProductNameCombo);
    }

    SearchModify(String string, int aInt) {

        initComponents();

        System.out.println("CID " + aInt);

        ImageIcon iconn = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(iconn.getImage());

        GetProductCategory();
        ComboProductName();

        others.setSelected(true);

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        if (aInt == 10) {
            userlogout.show();
            Homelevel.hide();
            usershow.setText("Customer: " + string);

        } else {
            userlogout.hide();
            Homelevel.show();

        }

        change = 1;

        GolbalCutomer = string;

        GetOrderID();
        GetCustomerAddress();

        int OR = OrderIDComboView.getItemCount();

        if (OR == 1) {
            OrderIDComboView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"No order avaiable"}));
        }

    }

    int change;

    SearchModify(int i) {

        initComponents();

        System.out.println("AID " + i);

        ImageIcon iconn = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(iconn.getImage());

        GetProductCategory();
        ComboProductName();

        others.setSelected(true);

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        if (i == 0) {
            userlogout.hide();
            Homelevel.show();
            usershow.setText("User: Admin");

            change = 0;

        } else {
            userlogout.show();
            Homelevel.hide();
            usershow.show();

        }

        GetOrderID();
        GetCustomerAddress();

        int OR = OrderIDComboView.getItemCount();

        if (OR == 1) {
            OrderIDComboView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"No order avaiable"}));
        }
    }

    private void ComboProductName() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT PName FROM products order by PName");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                ProductNameCombo.addItem(resultset.getString("PName"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void GetOrderImage() {

        try {

            prestm = connection.prepareStatement("SELECT PImage from showitems where Rid='" + value + "'");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery();

            if (resultset.next()) {

                OrderPImage.setIcon(ResizePhoto(null, resultset.getBytes("PImage")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void GetItemImage() {

        try {

            prestm = connection.prepareStatement("SELECT PImage from products where PName='" + ProductNameCombo.getSelectedItem() + "'");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery();

            if (resultset.next()) {

                PImage.setIcon(ResizePhoto(null, resultset.getBytes("PImage")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void AnotherGetItemImage() throws FileNotFoundException {

        try {

            prestm = connection.prepareStatement("SELECT PImage from products where PName='" + ProductNameCombo.getSelectedItem() + "'");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

            resultset = prestm.executeQuery();

            if (resultset.next()) {

                blob = (Blob) resultset.getBlob("PImage");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

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

    // --------------------------------------------------------
    private void GetCustomerAddress() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT CAddress FROM customer where CName ='" + GolbalCutomer + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                CustomerAdress = resultset.getString("CAddress");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    // --------------------------------------------------------
    private void GetProductCategory() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT distinct PCategory FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                product_category = resultset.getString("PCategory");
                productcategorycombo.addItem(product_category);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    // --------------------------------------------------------
    private void GetComboProductName() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT PName FROM products where PCategory ='" + productcategorycombo.getSelectedItem() + "' Order by PName");

            resultset = prestm.executeQuery();

            while (resultset.next()) {
                String count = resultset.getString("PName");

                ProductNameCombo.addItem(count);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    // --------------------------------------------------------
    // --------------------------------------------------------
    private void GetOrderID() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT Rid FROM showitems where CName='" + GolbalCutomer + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                OrderIDComboView.addItem(resultset.getString("Rid"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        CustomerPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ratingbtn1 = new javax.swing.JToggleButton();
        ratingbtn2 = new javax.swing.JToggleButton();
        ratingbtn3 = new javax.swing.JToggleButton();
        ratingbtn4 = new javax.swing.JToggleButton();
        ratingbtn5 = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        SpinnerQtySPlabel = new javax.swing.JSpinner();
        deliverylabel = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        PDescriptionlabel = new javax.swing.JEditorPane();
        jLabel16 = new javax.swing.JLabel();
        others = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        AddToOrder = new javax.swing.JButton();
        ViewBTN = new javax.swing.JButton();
        AVLebel = new javax.swing.JLabel();
        discountlabel = new javax.swing.JLabel();
        warrantylabel = new javax.swing.JLabel();
        PriceCombolabel = new javax.swing.JLabel();
        Categorylabel = new javax.swing.JLabel();
        PNamelabel = new javax.swing.JLabel();
        PImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        OrderPNamelabel = new javax.swing.JLabel();
        CashOrHome = new javax.swing.JLabel();
        OrderPricelabel = new javax.swing.JLabel();
        OrderQty = new javax.swing.JLabel();
        OrderPImage = new javax.swing.JLabel();
        OrderIDLAbel = new javax.swing.JLabel();
        orderCustomer = new javax.swing.JLabel();
        ViewBTN1 = new javax.swing.JButton();
        OrderIDComboView = new rojerusan.RSComboMetro();
        ViewBTN2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phonetxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PasswordLogin = new javax.swing.JPasswordField();
        pay_btn_ = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        ProductNameCombo = new rojerusan.RSComboMetro();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        productcategorycombo = new rojerusan.RSComboMetro();
        Homelevel = new javax.swing.JLabel();
        userlogout = new javax.swing.JLabel();
        usershow = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle9 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle10 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle36 = new rojerusan.RSMaterialButtonRectangle();
        minimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        CustomerPanel.setBackground(new java.awt.Color(14, 42, 71));
        CustomerPanel.setForeground(new java.awt.Color(51, 51, 51));
        CustomerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(246, 45, 12));
        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Choose");
        CustomerPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 40));

        jLabel8.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rating");
        CustomerPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 80, 40));

        ratingbtn1.setBackground(new java.awt.Color(255, 255, 255));
        ratingbtn1.setForeground(new java.awt.Color(255, 255, 255));
        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png"))); // NOI18N
        ratingbtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ratingbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratingbtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratingbtn1MouseExited(evt);
            }
        });
        CustomerPanel.add(ratingbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 580, 30, 30));

        ratingbtn2.setBackground(new java.awt.Color(255, 255, 255));
        ratingbtn2.setForeground(new java.awt.Color(255, 255, 255));
        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png"))); // NOI18N
        ratingbtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ratingbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratingbtn2MouseEntered(evt);
            }
        });
        CustomerPanel.add(ratingbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 30, 30));

        ratingbtn3.setBackground(new java.awt.Color(255, 255, 255));
        ratingbtn3.setForeground(new java.awt.Color(255, 255, 255));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png"))); // NOI18N
        ratingbtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ratingbtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratingbtn3MouseEntered(evt);
            }
        });
        CustomerPanel.add(ratingbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 30, 30));

        ratingbtn4.setBackground(new java.awt.Color(255, 255, 255));
        ratingbtn4.setForeground(new java.awt.Color(255, 255, 255));
        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png"))); // NOI18N
        ratingbtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ratingbtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratingbtn4MouseEntered(evt);
            }
        });
        CustomerPanel.add(ratingbtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, 30, 30));

        ratingbtn5.setBackground(new java.awt.Color(255, 255, 255));
        ratingbtn5.setForeground(new java.awt.Color(255, 255, 255));
        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png"))); // NOI18N
        ratingbtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ratingbtn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratingbtn5MouseEntered(evt);
            }
        });
        CustomerPanel.add(ratingbtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, 30, 30));

        jLabel13.setBackground(new java.awt.Color(246, 45, 12));
        jLabel13.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Details");
        CustomerPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, 40));

        SpinnerQtySPlabel.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        SpinnerQtySPlabel.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        SpinnerQtySPlabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SpinnerQtySPlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SpinnerQtySPlabel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinnerQtySPlabelStateChanged(evt);
            }
        });
        CustomerPanel.add(SpinnerQtySPlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 110, 30));

        buttonGroup1.add(deliverylabel);
        deliverylabel.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        deliverylabel.setForeground(new java.awt.Color(0, 204, 204));
        deliverylabel.setText("Home Delivery");
        deliverylabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deliverylabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverylabelActionPerformed(evt);
            }
        });
        CustomerPanel.add(deliverylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        PDescriptionlabel.setEditable(false);
        PDescriptionlabel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        PDescriptionlabel.setForeground(new java.awt.Color(51, 51, 51));
        PDescriptionlabel.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(PDescriptionlabel);

        CustomerPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 290, 150));

        jLabel16.setBackground(new java.awt.Color(246, 45, 12));
        jLabel16.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity");
        CustomerPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 40));

        buttonGroup1.add(others);
        others.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        others.setForeground(new java.awt.Color(0, 204, 204));
        others.setText("Cash On Delivery");
        others.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        others.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersActionPerformed(evt);
            }
        });
        CustomerPanel.add(others, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(53, 75, 97));
        jTabbedPane1.setForeground(new java.awt.Color(53, 75, 97));
        jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(31, 54, 77));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddToOrder.setBackground(new java.awt.Color(255, 153, 0));
        AddToOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        AddToOrder.setForeground(new java.awt.Color(51, 51, 51));
        AddToOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/check_mark.png"))); // NOI18N
        AddToOrder.setText("Confirm Order");
        AddToOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToOrderActionPerformed(evt);
            }
        });
        jPanel2.add(AddToOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        ViewBTN.setBackground(new java.awt.Color(0, 153, 51));
        ViewBTN.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ViewBTN.setForeground(new java.awt.Color(51, 51, 51));
        ViewBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/remove-from-cart.png"))); // NOI18N
        ViewBTN.setText("View");
        ViewBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewBTN.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ViewBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBTNActionPerformed(evt);
            }
        });
        jPanel2.add(ViewBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        AVLebel.setBackground(new java.awt.Color(246, 45, 12));
        AVLebel.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        AVLebel.setForeground(java.awt.Color.white);
        AVLebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AVLebel.setText("Status");
        jPanel2.add(AVLebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 280, 30));

        discountlabel.setBackground(new java.awt.Color(246, 45, 12));
        discountlabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        discountlabel.setForeground(new java.awt.Color(255, 255, 255));
        discountlabel.setText("Discount:");
        discountlabel.setToolTipText("Discount only available for home delivery");
        jPanel2.add(discountlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 30));

        warrantylabel.setBackground(new java.awt.Color(246, 45, 12));
        warrantylabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        warrantylabel.setForeground(new java.awt.Color(255, 255, 255));
        warrantylabel.setText("Warranty:");
        jPanel2.add(warrantylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 30));

        PriceCombolabel.setBackground(new java.awt.Color(246, 45, 12));
        PriceCombolabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        PriceCombolabel.setForeground(new java.awt.Color(255, 255, 255));
        PriceCombolabel.setText("Price:");
        jPanel2.add(PriceCombolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 30));

        Categorylabel.setBackground(new java.awt.Color(246, 45, 12));
        Categorylabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        Categorylabel.setForeground(new java.awt.Color(255, 255, 255));
        Categorylabel.setText("Category:");
        jPanel2.add(Categorylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));

        PNamelabel.setBackground(new java.awt.Color(246, 45, 12));
        PNamelabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        PNamelabel.setForeground(new java.awt.Color(255, 255, 255));
        PNamelabel.setText("Product Name");
        jPanel2.add(PNamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 30));

        PImage.setBackground(new java.awt.Color(0, 204, 204));
        PImage.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        PImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/output-onlinepngtools.png"))); // NOI18N
        PImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(PImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 255, 190));

        jTabbedPane1.addTab("Add to cart", jPanel2);

        jPanel5.setBackground(new java.awt.Color(31, 54, 77));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderPNamelabel.setBackground(new java.awt.Color(246, 45, 12));
        OrderPNamelabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderPNamelabel.setForeground(new java.awt.Color(255, 255, 255));
        OrderPNamelabel.setText("Product Name");
        jPanel5.add(OrderPNamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 30));

        CashOrHome.setBackground(new java.awt.Color(246, 45, 12));
        CashOrHome.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CashOrHome.setForeground(new java.awt.Color(255, 255, 255));
        CashOrHome.setText("Delivery status:");
        jPanel5.add(CashOrHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        OrderPricelabel.setBackground(new java.awt.Color(246, 45, 12));
        OrderPricelabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderPricelabel.setForeground(new java.awt.Color(255, 255, 255));
        OrderPricelabel.setText("Price:");
        jPanel5.add(OrderPricelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        OrderQty.setBackground(new java.awt.Color(246, 45, 12));
        OrderQty.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderQty.setForeground(new java.awt.Color(255, 255, 255));
        OrderQty.setText("Quantity: ");
        jPanel5.add(OrderQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 30));

        OrderPImage.setBackground(new java.awt.Color(0, 204, 204));
        OrderPImage.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        OrderPImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderPImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/received.png"))); // NOI18N
        OrderPImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        OrderPImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.add(OrderPImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 255, 190));

        OrderIDLAbel.setBackground(new java.awt.Color(246, 45, 12));
        OrderIDLAbel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderIDLAbel.setForeground(new java.awt.Color(255, 255, 255));
        OrderIDLAbel.setText("Order ID:");
        jPanel5.add(OrderIDLAbel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 30));

        orderCustomer.setBackground(new java.awt.Color(246, 45, 12));
        orderCustomer.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        orderCustomer.setForeground(new java.awt.Color(255, 255, 255));
        orderCustomer.setText("Customer:");
        jPanel5.add(orderCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 30));

        ViewBTN1.setBackground(new java.awt.Color(255, 255, 255));
        ViewBTN1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ViewBTN1.setForeground(new java.awt.Color(44, 62, 80));
        ViewBTN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel-icon.png"))); // NOI18N
        ViewBTN1.setText("Cancel");
        ViewBTN1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewBTN1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ViewBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBTN1ActionPerformed(evt);
            }
        });
        jPanel5.add(ViewBTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 475, -1, -1));

        OrderIDComboView.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select an Order ID" }));
        OrderIDComboView.setColorArrow(new java.awt.Color(0, 204, 204));
        OrderIDComboView.setColorBorde(new java.awt.Color(0, 204, 204));
        OrderIDComboView.setColorFondo(new java.awt.Color(0, 204, 204));
        OrderIDComboView.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        OrderIDComboView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderIDComboViewActionPerformed(evt);
            }
        });
        jPanel5.add(OrderIDComboView, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 170, 30));

        ViewBTN2.setBackground(new java.awt.Color(0, 153, 153));
        ViewBTN2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ViewBTN2.setForeground(new java.awt.Color(51, 51, 51));
        ViewBTN2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back-iconedited.png"))); // NOI18N
        ViewBTN2.setText("Back");
        ViewBTN2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewBTN2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ViewBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBTN2ActionPerformed(evt);
            }
        });
        jPanel5.add(ViewBTN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, -1, -1));

        jTabbedPane1.addTab("View cart", jPanel5);

        jPanel1.setBackground(new java.awt.Color(31, 54, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(jToggleButton1);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BKash.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 90, 50));

        buttonGroup2.add(jToggleButton2);
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nagad.png"))); // NOI18N
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 20, 90, 50));

        buttonGroup2.add(jToggleButton3);
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roket.png"))); // NOI18N
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 80, 50));

        jLabel10.setBackground(new java.awt.Color(246, 45, 12));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Amount");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 50));

        amount.setEditable(false);
        amount.setBackground(new java.awt.Color(31, 54, 77));
        amount.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });
        jPanel1.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 150, 30));

        jLabel9.setBackground(new java.awt.Color(246, 45, 12));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Phone");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 50));

        phonetxt.setEditable(false);
        phonetxt.setBackground(new java.awt.Color(31, 54, 77));
        phonetxt.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        phonetxt.setForeground(new java.awt.Color(255, 255, 255));
        phonetxt.setText("01405095166");
        phonetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetxtActionPerformed(evt);
            }
        });
        jPanel1.add(phonetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 150, 30));

        jLabel4.setBackground(new java.awt.Color(246, 45, 12));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 50));

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
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 25, 30));

        PasswordLogin.setBackground(new java.awt.Color(31, 54, 77));
        PasswordLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        PasswordLogin.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordLoginActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 150, 30));

        pay_btn_.setBackground(new java.awt.Color(0, 153, 153));
        pay_btn_.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        pay_btn_.setForeground(new java.awt.Color(255, 255, 255));
        pay_btn_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/money.png"))); // NOI18N
        pay_btn_.setText("Pay");
        pay_btn_.setBorderPainted(false);
        pay_btn_.setFocusCycleRoot(true);
        pay_btn_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_btn_ActionPerformed(evt);
            }
        });
        jPanel1.add(pay_btn_, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, 30));

        jTabbedPane1.addTab("Payment", jPanel1);

        CustomerPanel.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 280, 540));

        jLabel14.setBackground(new java.awt.Color(246, 45, 12));
        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Category");
        CustomerPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 40));

        ProductNameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a product" }));
        ProductNameCombo.setColorArrow(new java.awt.Color(0, 204, 204));
        ProductNameCombo.setColorBorde(new java.awt.Color(0, 204, 204));
        ProductNameCombo.setColorFondo(new java.awt.Color(0, 204, 204));
        ProductNameCombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ProductNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameComboActionPerformed(evt);
            }
        });
        CustomerPanel.add(ProductNameCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 290, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setFocusable(false);
        CustomerPanel.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-67, 80, 80, 580));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle3.setFocusCycleRoot(true);
        rSMaterialButtonCircle3.setFocusPainted(false);
        rSMaterialButtonCircle3.setFocusable(false);
        CustomerPanel.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 80, -1, 580));

        productcategorycombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select any category" }));
        productcategorycombo.setColorArrow(new java.awt.Color(0, 204, 204));
        productcategorycombo.setColorBorde(new java.awt.Color(0, 204, 204));
        productcategorycombo.setColorFondo(new java.awt.Color(0, 204, 204));
        productcategorycombo.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        productcategorycombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productcategorycomboActionPerformed(evt);
            }
        });
        CustomerPanel.add(productcategorycombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 170, -1));

        Homelevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home2.png"))); // NOI18N
        Homelevel.setToolTipText("Home");
        Homelevel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Homelevel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomelevelMouseClicked(evt);
            }
        });
        CustomerPanel.add(Homelevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, -1, -1));

        userlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shutdownedited.png"))); // NOI18N
        userlogout.setToolTipText("Log out");
        userlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userlogoutMouseClicked(evt);
            }
        });
        CustomerPanel.add(userlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, -1, -1));

        usershow.setBackground(new java.awt.Color(246, 45, 12));
        usershow.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        usershow.setForeground(new java.awt.Color(255, 255, 255));
        usershow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usershow.setText("Customer");
        CustomerPanel.add(usershow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, 25));

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

        rSMaterialButtonRectangle6.setText("Search Product");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        jPanel7.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 350, 40));

        rSMaterialButtonRectangle9.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle9ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 270, 15));

        rSMaterialButtonRectangle10.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle10ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 270, 15));

        rSMaterialButtonRectangle36.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle36.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle36, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 390, 35));

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
        jPanel7.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 30, 30));

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
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 30, 30));

        CustomerPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 80));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        CustomerPanel.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 140, 20));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        CustomerPanel.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 990, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        CustomerPanel.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 655, 990, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CustomerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CustomerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ratingbtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingbtn1MouseEntered

        rate_value = 1;

        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));


    }//GEN-LAST:event_ratingbtn1MouseEntered

    private void ratingbtn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingbtn2MouseEntered
        rate_value = 2;

        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));

        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));

    }//GEN-LAST:event_ratingbtn2MouseEntered

    private void ratingbtn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingbtn3MouseEntered
        rate_value = 3;

        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));

        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));

    }//GEN-LAST:event_ratingbtn3MouseEntered

    private void ratingbtn4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingbtn4MouseEntered
        rate_value = 4;

        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));

        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));

    }//GEN-LAST:event_ratingbtn4MouseEntered

    private void ratingbtn5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingbtn5MouseEntered
        rate_value = 5;

        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));
        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star.png")));

    }//GEN-LAST:event_ratingbtn5MouseEntered

    private void AddToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToOrderActionPerformed

        if (PName == null || PPrice == 0
                || SpinnerQtySPlabel == null
                || PCategory == null || PDescription == null
                || warranty == null) {

            Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_LEFT, "Select a product");
            panel.showNotification();

        } else if ((int) SpinnerQtySPlabel.getValue() >= GetQuantity) {

            Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_LEFT, "Out of stock");
            panel.showNotification();

        } else {

            int showresult = JOptionPane.showConfirmDialog(this, "Do you want purchase this product? ", "Confirming", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (showresult == JOptionPane.YES_NO_OPTION) {

                amount.setText(UPprice + " Taka");
                amount.setEditable(false);

                jTabbedPane1.setSelectedIndex(2);

                Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_LEFT, "Please pay " + PPrice + " Taka" + " for " + PName + "");
                panel.showNotification();

            }
        }
    }//GEN-LAST:event_AddToOrderActionPerformed

    private void SpinnerQtySPlabelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerQtySPlabelStateChanged

        UPprice = (int) SpinnerQtySPlabel.getValue() * PPrice;

        PriceCombolabel.setText("Price: " + UPprice + " Tk");
        int DisPrice = UPprice * (100 - discount) / 100;

        this.discountlabel.setText("Discount: " + discount + "% (Price: " + DisPrice + " Tk)");

    }//GEN-LAST:event_SpinnerQtySPlabelStateChanged

    private void deliverylabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverylabelActionPerformed
        if (deliverylabel.isSelected()) {
            MHDC = HDC;

            Homediscount = discount;

            if (flag == 1) {

                Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_LEFT, "Extra cost: " + MHDC + " Tk");
                panel.showNotification();
            }
        }
    }//GEN-LAST:event_deliverylabelActionPerformed

    private void othersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersActionPerformed
        if (others.isSelected()) {
            MHDC = 0;

            Homediscount = 0;
        }
    }//GEN-LAST:event_othersActionPerformed

    private void ViewBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBTNActionPerformed

        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_ViewBTNActionPerformed

    private void ViewBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBTN1ActionPerformed
        if (OrderIDComboView.getSelectedIndex() == 0) {

            Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_LEFT, "Select a Order ID");
            panel.showNotification();

        } else {

            try {

                int showresult = JOptionPane.showConfirmDialog(this, "Do you want to cancel this order?" + "\nOrder ID: " + OrderIDComboView.getSelectedItem(), "Canceling", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (showresult == JOptionPane.YES_NO_OPTION) {

                    connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                    prestm = connection.prepareStatement("delete from showitems where Rid  =? ");

                    prestm.setInt(1, value);
                    prestm.executeUpdate();

                    Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_LEFT, "Order cancled");
                    panel.showNotification();

                    OrderIDComboView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a Order id"}));
                    GetOrderID();
                }
            } catch (HeadlessException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_ViewBTN1ActionPerformed


    private void ratingbtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratingbtn1MouseExited

        rate_value = 1;

        ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
        ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
    }//GEN-LAST:event_ratingbtn1MouseExited

    private void OrderIDComboViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderIDComboViewActionPerformed
        value = Integer.valueOf(OrderIDComboView.getSelectedItem().toString());

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT CName,PName,PPrice,PQuantity,PDelivery,PImage from showitems where Rid='" + value + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                orderCName = resultset.getString("CName");
                ORderPName = resultset.getString("PName");

                orderprice = resultset.getInt("PPrice");
                orderqty = resultset.getInt("PQuantity");

                orderdelivery = resultset.getInt("PDelivery");

                if (orderdelivery > 0) {
                    CashOrHome.setText("Home Delivery");
                } else if (orderdelivery == 0) {
                    CashOrHome.setText("Cash On Delivery");
                }

                orderCustomer.setText("Customer: " + orderCName);
                OrderPNamelabel.setText("PName: " + ORderPName);

                OrderPricelabel.setText("Price: " + orderprice + " Tk");

                OrderQty.setText("No. of item: (" + orderqty + ")");

                GetOrderImage();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_OrderIDComboViewActionPerformed

    private void ProductNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameComboActionPerformed
        try {

            rate_value = 1;

            ratingbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
            ratingbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
            ratingbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
            ratingbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));
            ratingbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/star2.png")));

            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT PPrice,PName,PCategory,PQuantity,warranty,discount,HDCost,PQuantity,PDescription,PImage from products where PName='" + ProductNameCombo.getSelectedItem() + "'");
            resultset = prestm.executeQuery();

            while (resultset.next()) {

                PPrice = resultset.getInt("PPrice");
                PCategory = resultset.getString("PCategory");

                PName = resultset.getString("PName");
                GetQuantity = resultset.getInt("PQuantity");

                warranty = resultset.getString("Warranty");
                discount = resultset.getInt("Discount");

                HDC = resultset.getInt("HDCost");

                PDescription = resultset.getString("PDescription");

                PriceCombolabel.setText("Price: " + PPrice + " Tk");
                Categorylabel.setText("Category: " + PCategory);

                this.PNamelabel.setText("Name: " + PName);

                this.warrantylabel.setText("Warranty: " + warranty);

                if (discount == 0) {

                    this.discountlabel.setText("Discount: N/A");
                } else {

                    int DisPrice = PPrice * (100 - discount) / 100;

                    this.discountlabel.setText("Discount: " + discount + "% (Price: " + DisPrice + " Tk)");

                }

                this.PDescriptionlabel.setText(PDescription);

                int PQuantity = resultset.getInt("PQuantity");

                if (PQuantity > 0) {

                    AVLebel.setText("Available in Stock");
                    AddToOrder.setEnabled(true);

                } else {
                    AVLebel.setText("Out of Stock");
                    AddToOrder.setEnabled(false);
                }

                GetItemImage();
                AnotherGetItemImage();

                others.setSelected(true);

                deliverylabel.setToolTipText("Cost: " + HDC + " Tk");

                flag = 1;
            }

            UPprice = PPrice;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } catch (FileNotFoundException ex) {

        }
    }//GEN-LAST:event_ProductNameComboActionPerformed

    private void productcategorycomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productcategorycomboActionPerformed
        if (productcategorycombo.getSelectedIndex() == 0) {
            ProductNameCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a product"}));

            ComboProductName();

        } else {

            ProductNameCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a product"}));

            GetComboProductName();

        }
    }//GEN-LAST:event_productcategorycomboActionPerformed

    private void HomelevelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomelevelMouseClicked
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_HomelevelMouseClicked

    private void userlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userlogoutMouseClicked
        new Login(10).setVisible(true);
        dispose();
    }//GEN-LAST:event_userlogoutMouseClicked

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void rSMaterialButtonRectangle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle9ActionPerformed

    private void rSMaterialButtonRectangle10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle10ActionPerformed
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

    private void ViewBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBTN2ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_ViewBTN2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {

            Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Bkash Clicked");
            panel.showNotification();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (jToggleButton2.isSelected()) {

            Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Nagad Clicked");
            panel.showNotification();
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if (jToggleButton3.isSelected()) {

            Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Rocket Clicked");
            panel.showNotification();
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void phonetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetxtActionPerformed

    private void PasswordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordLoginActionPerformed

    }//GEN-LAST:event_PasswordLoginActionPerformed

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eye2.png")));

        PasswordLogin.setEchoChar((char) 0);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/blind2.png")));

        PasswordLogin.setEchoChar('*');
    }//GEN-LAST:event_jLabel7MouseExited

    private void pay_btn_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_btn_ActionPerformed
        if (PasswordLogin.getText().isEmpty()
                || phonetxt.getText().isEmpty()
                || amount.getText().isEmpty()) {

            Notification2 panel = new Notification2(this, Notification2.Type.WARNING, Notification2.Location.TOP_LEFT, "Missing Information");
            panel.showNotification();

        } else {
            
              int showresult = JOptionPane.showConfirmDialog(this, "Do you want pay bill & purchase this product? ", "Confirming", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (showresult == JOptionPane.YES_NO_OPTION) {

            try {

                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
                prestm = connection.prepareStatement("Insert into payment (CName, pay_amount)values(?,?) ");

                prestm.setString(1, GolbalCutomer);
                prestm.setString(2, amount.getText().trim());

                int k = prestm.executeUpdate();

                if (k == 1) {

                    jTabbedPane1.setSelectedIndex(0);

                    i++;

                    Notification2 panel = new Notification2(this, Notification2.Type.SUCCESS, Notification2.Location.TOP_LEFT, "Pay Successful");
                    panel.showNotification();

                    //*****************************
                    
                      try {

                        String Query = "Insert into showitems (PName, PPrice, PQuantity, PCategory, PDescription,PWarranty,PDiscount,PDelivery,Rating,CName,CAddress,PImage,pay_amount)values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";

                        connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");

                        prestm = connection.prepareStatement(Query);

                        prestm.setString(1, PName);
                        prestm.setInt(2, PPrice);
                        prestm.setInt(3, (int) SpinnerQtySPlabel.getValue());

                        prestm.setString(4, PCategory);
                        prestm.setString(5, PDescription);
                        prestm.setString(6, warranty);

                        prestm.setInt(7, Homediscount);
                        prestm.setInt(8, MHDC);
                        prestm.setInt(9, rate_value);

                        prestm.setString(10, GolbalCutomer);
                        prestm.setString(11, CustomerAdress);

                        prestm.setBlob(12, blob);

                        prestm.setString(13, String.valueOf(UPprice));

                        int kk = prestm.executeUpdate();

                        if (kk == 1) {
                            
                            Notification panel2 = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_LEFT, "Product Purchased");
                            panel2.showNotification();

                            OrderIDComboView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select a Order id"}));
                            GetOrderID();
                        }

                        if (rate_value == 5) {

                            Notification panel3 = new Notification(this, Notification.Type.INFO, Notification.Location.TOP_LEFT, "Thank you so much for your 5-star review!");
                            panel3.showNotification();
                        }
                    } catch (HeadlessException | SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
            }
        }
    }//GEN-LAST:event_pay_btn_ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_jTabbedPane1MouseClicked

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
            java.util.logging.Logger.getLogger(SearchModify.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SearchModify().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AVLebel;
    private javax.swing.JButton AddToOrder;
    private javax.swing.JLabel CashOrHome;
    private javax.swing.JLabel Categorylabel;
    private javax.swing.JPanel CustomerPanel;
    private javax.swing.JLabel Homelevel;
    private rojerusan.RSComboMetro OrderIDComboView;
    private javax.swing.JLabel OrderIDLAbel;
    private javax.swing.JLabel OrderPImage;
    private javax.swing.JLabel OrderPNamelabel;
    private javax.swing.JLabel OrderPricelabel;
    private javax.swing.JLabel OrderQty;
    private javax.swing.JEditorPane PDescriptionlabel;
    private javax.swing.JLabel PImage;
    private javax.swing.JLabel PNamelabel;
    private javax.swing.JPasswordField PasswordLogin;
    private javax.swing.JLabel PriceCombolabel;
    private rojerusan.RSComboMetro ProductNameCombo;
    private javax.swing.JSpinner SpinnerQtySPlabel;
    private javax.swing.JButton ViewBTN;
    private javax.swing.JButton ViewBTN1;
    private javax.swing.JButton ViewBTN2;
    private javax.swing.JTextField amount;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox deliverylabel;
    private javax.swing.JLabel discountlabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel orderCustomer;
    private javax.swing.JCheckBox others;
    private javax.swing.JButton pay_btn_;
    private javax.swing.JTextField phonetxt;
    private rojerusan.RSComboMetro productcategorycombo;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle36;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private javax.swing.JToggleButton ratingbtn1;
    private javax.swing.JToggleButton ratingbtn2;
    private javax.swing.JToggleButton ratingbtn3;
    private javax.swing.JToggleButton ratingbtn4;
    private javax.swing.JToggleButton ratingbtn5;
    private javax.swing.JLabel userlogout;
    private javax.swing.JLabel usershow;
    private javax.swing.JLabel warrantylabel;
    // End of variables declaration//GEN-END:variables
}
