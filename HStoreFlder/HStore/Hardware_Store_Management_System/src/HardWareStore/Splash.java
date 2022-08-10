package HardWareStore;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author RAVEN
 */
public class Splash extends javax.swing.JFrame {

    static long start;

    /**
     * Creates new form Main
     */
    public Splash() {
        
        start = System.currentTimeMillis();
        initComponents();

        

        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/hardware.png"));
        this.setIconImage(icon.getImage());

        ProgressBar.setBackground(new Color(102, 255, 102));
        ProgressBar.setForeground(new Color(0, 204, 204));

        ProgressBar.setStringPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        percent_loading = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ProgressBar = new progressbar.ProgressBarCustom();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 42, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Loading...");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 30));

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HSMS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 600, 30));

        percent_loading.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        percent_loading.setForeground(new java.awt.Color(255, 255, 255));
        percent_loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percent_loading.setText("0%");
        jPanel1.add(percent_loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 50, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hardwareEdited.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 610, -1));

        ProgressBar.setValue(40);
        jPanel1.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 300, 630, 10));

        jLabel18.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Hardware Store Management System");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 610, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
//        UIManager.put("control", new Color(44, 62, 80));
//        UIManager.put("text", new Color(255, 255, 255));
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Splash mySplash = new Splash();

        mySplash.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {

                percent_loading.setText(String.valueOf(i) + "%");
                Thread.sleep(10);

                mySplash.ProgressBar.setValue(i);

            }
            
            System.out.println((float)(System.currentTimeMillis() - start)/1000 + " s");

        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Thread.sleep(200);
        new Login().setVisible(true);
        mySplash.dispose();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private progressbar.ProgressBarCustom ProgressBar;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel percent_loading;
    // End of variables declaration//GEN-END:variables
}
