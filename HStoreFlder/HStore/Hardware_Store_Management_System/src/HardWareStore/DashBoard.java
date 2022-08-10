package HardWareStore;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahmud
 */
public class DashBoard extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement prestm, prestm2;
    ResultSet resultset, resultset2;
    
     static long start = System.currentTimeMillis();

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
        CountCustomer();
        CountProducts();
        CountBDT();
        Max();
        Min();
        Avg();
        AvgRating();
        LastMaxOrder();
        CountCategory();
        Countaddtocart();

        CountCashOn();
        CountHomeDelivery();
//        Color();

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

    }
//
//    public void Color() {
//
//        Thread hilo = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//
//                for (;;) {
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//
//                    }
//
//                    int r, g, b;
//                    r = (int) (Math.random() * 255);
//                    g = (int) (Math.random() * 255);
//                    b = (int) (Math.random() * 255);
//
//                    Color c = new Color(r, g, b);
//
//                    d3.setBackground(c);
//                    d1.setBackground(c);
//                    d2.setBackground(c);
//                    d4.setBackground(c);
//
//                    d5.setBackground(c);
//                    d6.setBackground(c);
//                    d7.setBackground(c);
//
//                    d8.setBackground(c);
//                    d9.setBackground(c);
//                }
//            }
//        });
//        hilo.start();
//    }

    public void CountCustomer() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT COUNT(*) FROM customer");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("COUNT(*)");

                CUstomerNameD.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void CountProducts() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT COUNT(PName) FROM products");
            resultset = prestm.executeQuery();
            prestm2 = connection.prepareStatement("SELECT COUNT(Rid) FROM orders");
            resultset2 = prestm2.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("COUNT(PName)");

                DashBoardProduct.setText(String.valueOf(count));

            }

            while (resultset2.next()) {
                int cou2t = resultset2.getInt("COUNT(Rid)");
                OrderRid.setText(String.valueOf(cou2t));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void Countaddtocart() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT COUNT(Rid) FROM showitems");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("COUNT(Rid)");

                addtocardrid.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void CountCashOn() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select COUNT(PDelivery) from orders where PDelivery = 0 ");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("COUNT(PDelivery)");

                cash.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void CountHomeDelivery() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("select COUNT(PDelivery) from orders where PDelivery != 0");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("COUNT(PDelivery)");

                homed.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void CountBDT() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT Sum(PPrice) FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("Sum(PPrice)");

                DashBoardSellersFinance.setText("Total: " + String.valueOf(count) + " Tk");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void CountCategory() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT count(distinct PCategory) FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("count(distinct PCategory)");

                OrderAmount.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void Avg() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT avg(PPrice) FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("avg(PPrice)");

                AverageSell.setText("Average: " + String.valueOf(count) + " Tk");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void AvgRating() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT avg(Rating) FROM showitems");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("avg(Rating)");

                ratinglabel.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void Min() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT min(PPrice) FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("min(PPrice)");

                MinimumRate.setText("Minimum: " + String.valueOf(count) + " Tk");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void Max() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT max(PPrice) FROM products");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("max(PPrice)");

                MaximumRate.setText("Maximum: " + String.valueOf(count) + " Tk");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    public void LastMaxOrder() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/invsysdb", "root", "");
            prestm = connection.prepareStatement("SELECT max(Rid) FROM orders");
            resultset = prestm.executeQuery();

            while (resultset.next()) {
                int count = resultset.getInt("max(Rid)");

                OrderAmount1.setText(String.valueOf(count));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        OrderAmount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle6 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle33 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        DashBoardSellersName1 = new javax.swing.JLabel();
        DashBoardProduct = new javax.swing.JLabel();
        DashBoardSellersName2 = new javax.swing.JLabel();
        CUstomerNameD = new javax.swing.JLabel();
        AverageSell = new javax.swing.JLabel();
        MaximumRate = new javax.swing.JLabel();
        MinimumRate = new javax.swing.JLabel();
        DashBoardSellersFinance = new javax.swing.JLabel();
        DashBoardSellersName5 = new javax.swing.JLabel();
        OrderRid = new javax.swing.JLabel();
        DashBoardSellersName9 = new javax.swing.JLabel();
        rSMaterialButtonRectangle21 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle22 = new rojerusan.RSMaterialButtonRectangle();
        totalsell = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle20 = new rojerusan.RSMaterialButtonRectangle();
        jLabel14 = new javax.swing.JLabel();
        OrderAmount1 = new javax.swing.JLabel();
        DashBoardSellersName8 = new javax.swing.JLabel();
        ratinglabel = new javax.swing.JLabel();
        title = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle31 = new rojerusan.RSMaterialButtonRectangle();
        change = new rojerusan.RSMaterialButtonCircle();
        hm = new rojerusan.RSMaterialButtonRectangle();
        d3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle5 = new rojerusan.RSMaterialButtonRectangle();
        addtocardrid = new javax.swing.JLabel();
        DashBoardSellersName4 = new javax.swing.JLabel();
        cash = new javax.swing.JLabel();
        DashBoardSellersName6 = new javax.swing.JLabel();
        homed = new javax.swing.JLabel();
        DashBoardSellersName7 = new javax.swing.JLabel();
        rSMaterialButtonRectangle29 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle30 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle32 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle34 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        change1 = new rojerusan.RSMaterialButtonCircle();
        hm1 = new rojerusan.RSMaterialButtonRectangle();
        d10 = new rojerusan.RSMaterialButtonRectangle();
        hm2 = new rojerusan.RSMaterialButtonRectangle();
        change2 = new rojerusan.RSMaterialButtonCircle();
        d11 = new rojerusan.RSMaterialButtonRectangle();
        change3 = new rojerusan.RSMaterialButtonCircle();
        hm3 = new rojerusan.RSMaterialButtonRectangle();
        d12 = new rojerusan.RSMaterialButtonRectangle();
        change4 = new rojerusan.RSMaterialButtonCircle();
        hm4 = new rojerusan.RSMaterialButtonRectangle();
        d13 = new rojerusan.RSMaterialButtonRectangle();
        change5 = new rojerusan.RSMaterialButtonCircle();
        hm8 = new rojerusan.RSMaterialButtonRectangle();
        d14 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        hm9 = new rojerusan.RSMaterialButtonRectangle();
        change9 = new rojerusan.RSMaterialButtonCircle();
        d18 = new rojerusan.RSMaterialButtonRectangle();
        hm10 = new rojerusan.RSMaterialButtonRectangle();
        change10 = new rojerusan.RSMaterialButtonCircle();
        d19 = new rojerusan.RSMaterialButtonRectangle();
        change11 = new rojerusan.RSMaterialButtonCircle();
        hm11 = new rojerusan.RSMaterialButtonRectangle();
        d20 = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(14, 42, 71));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderAmount.setBackground(new java.awt.Color(51, 51, 51));
        OrderAmount.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderAmount.setForeground(new java.awt.Color(255, 255, 255));
        OrderAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderAmount.setText("?");
        jPanel1.add(OrderAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 40, 40));

        jLabel12.setBackground(new java.awt.Color(95, 132, 206));
        jLabel12.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("# Category");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 120, 30));

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

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 310, 15));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 280, 15));

        rSMaterialButtonRectangle6.setText(" DashBoard ");
        rSMaterialButtonRectangle6.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        jPanel7.add(rSMaterialButtonRectangle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 25, 240, 40));

        rSMaterialButtonRectangle33.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle33.setFocusable(false);
        jPanel7.add(rSMaterialButtonRectangle33, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 280, 35));

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
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 30, 30));

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
        jPanel7.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 30, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 80));

        DashBoardSellersName1.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName1.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName1.setText("# Customer");
        jPanel1.add(DashBoardSellersName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 140, 30));

        DashBoardProduct.setBackground(new java.awt.Color(51, 51, 51));
        DashBoardProduct.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        DashBoardProduct.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardProduct.setText("?");
        jPanel1.add(DashBoardProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 40, 40));

        DashBoardSellersName2.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName2.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName2.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName2.setText("Prod  in Stock");
        jPanel1.add(DashBoardSellersName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 140, 30));

        CUstomerNameD.setBackground(new java.awt.Color(51, 51, 51));
        CUstomerNameD.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        CUstomerNameD.setForeground(new java.awt.Color(255, 255, 255));
        CUstomerNameD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CUstomerNameD.setText("?");
        jPanel1.add(CUstomerNameD, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 40, 40));

        AverageSell.setBackground(new java.awt.Color(51, 51, 51));
        AverageSell.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        AverageSell.setForeground(new java.awt.Color(255, 255, 255));
        AverageSell.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AverageSell.setText("DashBoard");
        AverageSell.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        AverageSell.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(AverageSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 170, 20));

        MaximumRate.setBackground(new java.awt.Color(51, 51, 51));
        MaximumRate.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        MaximumRate.setForeground(new java.awt.Color(255, 255, 255));
        MaximumRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MaximumRate.setText("DashBoard");
        MaximumRate.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        MaximumRate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(MaximumRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 170, 20));

        MinimumRate.setBackground(new java.awt.Color(51, 51, 51));
        MinimumRate.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        MinimumRate.setForeground(new java.awt.Color(255, 255, 255));
        MinimumRate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinimumRate.setText("DashBoard");
        MinimumRate.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        MinimumRate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(MinimumRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 170, 20));

        DashBoardSellersFinance.setBackground(new java.awt.Color(51, 51, 51));
        DashBoardSellersFinance.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        DashBoardSellersFinance.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersFinance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersFinance.setText("DashBoard");
        DashBoardSellersFinance.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        DashBoardSellersFinance.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(DashBoardSellersFinance, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 170, 20));

        DashBoardSellersName5.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName5.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName5.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName5.setText("# Orders");
        jPanel1.add(DashBoardSellersName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 140, 30));

        OrderRid.setBackground(new java.awt.Color(51, 51, 51));
        OrderRid.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderRid.setForeground(new java.awt.Color(255, 255, 255));
        OrderRid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderRid.setText("?");
        jPanel1.add(OrderRid, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 40, 40));

        DashBoardSellersName9.setBackground(new java.awt.Color(14, 42, 71));
        DashBoardSellersName9.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        DashBoardSellersName9.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName9.setText("Amount in BDT");
        DashBoardSellersName9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));
        DashBoardSellersName9.setOpaque(true);
        jPanel1.add(DashBoardSellersName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 150, 30));

        rSMaterialButtonRectangle21.setBackground(new java.awt.Color(14, 42, 71));
        rSMaterialButtonRectangle21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle21.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle21, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 190, 40));

        rSMaterialButtonRectangle22.setBackground(new java.awt.Color(14, 42, 71));
        rSMaterialButtonRectangle22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle22.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle22, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 190, 40));

        totalsell.setBackground(new java.awt.Color(14, 42, 71));
        totalsell.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        totalsell.setFocusable(false);
        jPanel1.add(totalsell, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 190, 40));

        rSMaterialButtonRectangle20.setBackground(new java.awt.Color(14, 42, 71));
        rSMaterialButtonRectangle20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle20.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 190, 40));

        jLabel14.setBackground(new java.awt.Color(95, 132, 206));
        jLabel14.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Last Order");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 140, 30));

        OrderAmount1.setBackground(new java.awt.Color(51, 51, 51));
        OrderAmount1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        OrderAmount1.setForeground(new java.awt.Color(255, 255, 255));
        OrderAmount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderAmount1.setText("?");
        jPanel1.add(OrderAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 40, 40));

        DashBoardSellersName8.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName8.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName8.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName8.setText("Avg Rating");
        jPanel1.add(DashBoardSellersName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 140, 30));

        ratinglabel.setBackground(new java.awt.Color(51, 51, 51));
        ratinglabel.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        ratinglabel.setForeground(new java.awt.Color(255, 255, 255));
        ratinglabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratinglabel.setText("?");
        ratinglabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(ratinglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 40, 40));

        title.setBackground(new java.awt.Color(12, 120, 197));
        title.setText("Product Price");
        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 170, 40));

        rSMaterialButtonRectangle31.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle31.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle31, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 205, 210, 40));

        change.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 60, 60));

        hm.setBackground(new java.awt.Color(0, 197, 202));
        hm.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm.setForeground(new java.awt.Color(44, 62, 80));
        hm.setFocusable(false);
        jPanel1.add(hm, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 160, 40));

        d3.setBackground(new java.awt.Color(31, 54, 77));
        d3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d3.setFocusable(false);
        jPanel1.add(d3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 80));

        rSMaterialButtonRectangle5.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle5.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 230, 370));

        addtocardrid.setBackground(new java.awt.Color(51, 51, 51));
        addtocardrid.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        addtocardrid.setForeground(new java.awt.Color(255, 255, 255));
        addtocardrid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addtocardrid.setText("?");
        jPanel1.add(addtocardrid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 40, 40));

        DashBoardSellersName4.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName4.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName4.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName4.setText("# Req ID");
        jPanel1.add(DashBoardSellersName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 140, 30));

        cash.setBackground(new java.awt.Color(51, 51, 51));
        cash.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cash.setText("?");
        jPanel1.add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 40, 40));

        DashBoardSellersName6.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName6.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName6.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName6.setText("# C.O.D");
        jPanel1.add(DashBoardSellersName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 140, 30));

        homed.setBackground(new java.awt.Color(51, 51, 51));
        homed.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        homed.setForeground(new java.awt.Color(255, 255, 255));
        homed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homed.setText("?");
        jPanel1.add(homed, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 40, 40));

        DashBoardSellersName7.setBackground(new java.awt.Color(95, 132, 206));
        DashBoardSellersName7.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        DashBoardSellersName7.setForeground(new java.awt.Color(255, 255, 255));
        DashBoardSellersName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DashBoardSellersName7.setText("# Home.D");
        jPanel1.add(DashBoardSellersName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 140, 30));

        rSMaterialButtonRectangle29.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle29.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle29, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 173, 240, 100));

        rSMaterialButtonRectangle30.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle30.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle30, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 515, 230, 45));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle2.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-75, 80, 80, 510));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle3.setFocusCycleRoot(true);
        rSMaterialButtonCircle3.setFocusPainted(false);
        rSMaterialButtonCircle3.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(899, 80, 120, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Home2.png"))); // NOI18N
        jLabel1.setToolTipText("Home");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

        rSMaterialButtonRectangle32.setBackground(new java.awt.Color(31, 54, 77));
        rSMaterialButtonRectangle32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle32.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 910, 20));

        rSMaterialButtonRectangle34.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonRectangle34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rSMaterialButtonRectangle34.setFocusable(false);
        jPanel1.add(rSMaterialButtonRectangle34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 595, 910, 25));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(0, 153, 153));
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 100, 30));

        change1.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 60, 60));

        hm1.setBackground(new java.awt.Color(0, 197, 202));
        hm1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm1.setForeground(new java.awt.Color(44, 62, 80));
        hm1.setFocusable(false);
        jPanel1.add(hm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 160, 40));

        d10.setBackground(new java.awt.Color(31, 54, 77));
        d10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d10.setFocusable(false);
        jPanel1.add(d10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 120, 80));

        hm2.setBackground(new java.awt.Color(0, 197, 202));
        hm2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm2.setForeground(new java.awt.Color(44, 62, 80));
        hm2.setFocusable(false);
        jPanel1.add(hm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 160, 40));

        change2.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 60, 60));

        d11.setBackground(new java.awt.Color(31, 54, 77));
        d11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d11.setFocusable(false);
        jPanel1.add(d11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, 80));

        change3.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 60, 60));

        hm3.setBackground(new java.awt.Color(0, 197, 202));
        hm3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm3.setForeground(new java.awt.Color(44, 62, 80));
        hm3.setFocusable(false);
        jPanel1.add(hm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 160, 40));

        d12.setBackground(new java.awt.Color(31, 54, 77));
        d12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d12.setFocusable(false);
        jPanel1.add(d12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 120, 80));

        change4.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 60, 60));

        hm4.setBackground(new java.awt.Color(0, 197, 202));
        hm4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm4.setForeground(new java.awt.Color(44, 62, 80));
        hm4.setFocusable(false);
        jPanel1.add(hm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 160, 40));

        d13.setBackground(new java.awt.Color(31, 54, 77));
        d13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d13.setFocusable(false);
        jPanel1.add(d13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 120, 80));

        change5.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 60, 60));

        hm8.setBackground(new java.awt.Color(0, 197, 202));
        hm8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm8.setForeground(new java.awt.Color(44, 62, 80));
        hm8.setFocusable(false);
        jPanel1.add(hm8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 180, 40));

        d14.setBackground(new java.awt.Color(31, 54, 77));
        d14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d14.setFocusable(false);
        jPanel1.add(d14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 120, 80));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(0, 204, 204));
        rSMaterialButtonCircle4.setFocusable(false);
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 80, 80, 540));

        hm9.setBackground(new java.awt.Color(0, 197, 202));
        hm9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm9.setForeground(new java.awt.Color(44, 62, 80));
        hm9.setFocusable(false);
        jPanel1.add(hm9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 160, 40));

        change9.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 60, 60));

        d18.setBackground(new java.awt.Color(31, 54, 77));
        d18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d18.setFocusable(false);
        jPanel1.add(d18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 120, 80));

        hm10.setBackground(new java.awt.Color(0, 197, 202));
        hm10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm10.setForeground(new java.awt.Color(44, 62, 80));
        hm10.setFocusable(false);
        jPanel1.add(hm10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 160, 40));

        change10.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 60, 60));

        d19.setBackground(new java.awt.Color(31, 54, 77));
        d19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d19.setFocusable(false);
        jPanel1.add(d19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 120, 80));

        change11.setBackground(new java.awt.Color(12, 120, 197));
        jPanel1.add(change11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 60, 60));

        hm11.setBackground(new java.awt.Color(0, 197, 202));
        hm11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        hm11.setForeground(new java.awt.Color(44, 62, 80));
        hm11.setFocusable(false);
        jPanel1.add(hm11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 160, 40));

        d20.setBackground(new java.awt.Color(31, 54, 77));
        d20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        d20.setFocusable(false);
        jPanel1.add(d20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 120, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed
 private int xm, ym;
    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
       int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xm, y - ym);
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
        xm = evt.getX();
        ym = evt.getY();
    }//GEN-LAST:event_jPanel7MousePressed

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new DashBoard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AverageSell;
    private javax.swing.JLabel CUstomerNameD;
    private javax.swing.JLabel DashBoardProduct;
    private javax.swing.JLabel DashBoardSellersFinance;
    private javax.swing.JLabel DashBoardSellersName1;
    private javax.swing.JLabel DashBoardSellersName2;
    private javax.swing.JLabel DashBoardSellersName4;
    private javax.swing.JLabel DashBoardSellersName5;
    private javax.swing.JLabel DashBoardSellersName6;
    private javax.swing.JLabel DashBoardSellersName7;
    private javax.swing.JLabel DashBoardSellersName8;
    private javax.swing.JLabel DashBoardSellersName9;
    private javax.swing.JLabel MaximumRate;
    private javax.swing.JLabel MinimumRate;
    private javax.swing.JLabel OrderAmount;
    private javax.swing.JLabel OrderAmount1;
    private javax.swing.JLabel OrderRid;
    private javax.swing.JLabel addtocardrid;
    private javax.swing.JLabel cash;
    private rojerusan.RSMaterialButtonCircle change;
    private rojerusan.RSMaterialButtonCircle change1;
    private rojerusan.RSMaterialButtonCircle change10;
    private rojerusan.RSMaterialButtonCircle change11;
    private rojerusan.RSMaterialButtonCircle change2;
    private rojerusan.RSMaterialButtonCircle change3;
    private rojerusan.RSMaterialButtonCircle change4;
    private rojerusan.RSMaterialButtonCircle change5;
    private rojerusan.RSMaterialButtonCircle change9;
    private rojerusan.RSMaterialButtonRectangle d10;
    private rojerusan.RSMaterialButtonRectangle d11;
    private rojerusan.RSMaterialButtonRectangle d12;
    private rojerusan.RSMaterialButtonRectangle d13;
    private rojerusan.RSMaterialButtonRectangle d14;
    private rojerusan.RSMaterialButtonRectangle d18;
    private rojerusan.RSMaterialButtonRectangle d19;
    private rojerusan.RSMaterialButtonRectangle d20;
    private rojerusan.RSMaterialButtonRectangle d3;
    private rojerusan.RSMaterialButtonRectangle hm;
    private rojerusan.RSMaterialButtonRectangle hm1;
    private rojerusan.RSMaterialButtonRectangle hm10;
    private rojerusan.RSMaterialButtonRectangle hm11;
    private rojerusan.RSMaterialButtonRectangle hm2;
    private rojerusan.RSMaterialButtonRectangle hm3;
    private rojerusan.RSMaterialButtonRectangle hm4;
    private rojerusan.RSMaterialButtonRectangle hm8;
    private rojerusan.RSMaterialButtonRectangle hm9;
    private javax.swing.JLabel homed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel minimize;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle20;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle21;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle22;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle29;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle30;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle31;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle32;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle33;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle34;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle5;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle6;
    private javax.swing.JLabel ratinglabel;
    private rojerusan.RSMaterialButtonRectangle title;
    private rojerusan.RSMaterialButtonRectangle totalsell;
    // End of variables declaration//GEN-END:variables
}
