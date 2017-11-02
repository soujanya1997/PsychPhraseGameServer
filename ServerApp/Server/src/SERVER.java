
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import sun.net.util.IPAddressUtil;


public class SERVER extends javax.swing.JFrame {

    Sound clip ;
    int type = 0 ;
    @SuppressWarnings("restrictions")
    public SERVER() {
        
        initComponents();
        
        this.serverIP.setText("Host IP");
        serverIP.setDocument(new JTextFieldLimit(15));
        
        clip = new Sound("harrypotter.wav") ;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        serverIP = new javax.swing.JTextField();
        disney = new javax.swing.JButton();
        science = new javax.swing.JButton();
        general = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        startGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SERVER");
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setSize(new java.awt.Dimension(1024, 700));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.gif"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 340, 310);

        jLabel3.setFont(new java.awt.Font("Waree", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 0, 149));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 360, 320, 90);

        serverIP.setFont(new java.awt.Font("Noto Sans CJK TC Black", 1, 36)); // NOI18N
        serverIP.setForeground(new java.awt.Color(0, 120, 21));
        serverIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        serverIP.setText("HOST IP");
        serverIP.setToolTipText("Enter IP");
        getContentPane().add(serverIP);
        serverIP.setBounds(30, 450, 320, 70);

        disney.setFont(new java.awt.Font("Waree", 1, 30)); // NOI18N
        disney.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DISNEY.png"))); // NOI18N
        disney.setText("DISNEY");
        disney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disneyActionPerformed(evt);
            }
        });
        getContentPane().add(disney);
        disney.setBounds(680, 380, 300, 90);

        science.setFont(new java.awt.Font("Waree", 1, 30)); // NOI18N
        science.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chemistry.png"))); // NOI18N
        science.setText("SCIENCE");
        science.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scienceActionPerformed(evt);
            }
        });
        getContentPane().add(science);
        science.setBounds(680, 270, 300, 90);

        general.setFont(new java.awt.Font("Waree", 1, 30)); // NOI18N
        general.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gk.png"))); // NOI18N
        general.setText("GENERAL");
        general.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalActionPerformed(evt);
            }
        });
        getContentPane().add(general);
        general.setBounds(680, 490, 300, 90);

        jLabel4.setFont(new java.awt.Font("Waree", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SELECT  TOPIC");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(680, 200, 300, 50);

        close.setFont(new java.awt.Font("Waree", 1, 25)); // NOI18N
        close.setForeground(new java.awt.Color(228, 35, 35));
        close.setText("CLOSE");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(860, 20, 150, 57);

        startGame.setFont(new java.awt.Font("Waree", 1, 30)); // NOI18N
        startGame.setForeground(new java.awt.Color(212, 2, 36));
        startGame.setText("START");
        startGame.setEnabled(false);
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });
        getContentPane().add(startGame);
        startGame.setBounds(110, 560, 170, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/psych1.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1024, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void scienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scienceActionPerformed
        new Sound("abc.wav");
        this.startGame.setEnabled(true);
        this.science.setForeground(Color.BLUE);
        this.general.setForeground(Color.BLACK);
        this.disney.setForeground(Color.BLACK);
        type = 1 ;
    }//GEN-LAST:event_scienceActionPerformed

    private void generalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalActionPerformed
        new Sound("abc.wav");
        this.startGame.setEnabled(true);
        this.science.setForeground(Color.BLACK);
        this.general.setForeground(Color.BLUE);
        this.disney.setForeground(Color.BLACK);
        type = 3 ;
    }//GEN-LAST:event_generalActionPerformed

    private void disneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disneyActionPerformed
        new Sound("abc.wav");
        this.startGame.setEnabled(true);
        this.science.setForeground(Color.BLACK);
        this.general.setForeground(Color.BLACK);
        this.disney.setForeground(Color.BLUE);
        type = 2 ;
    }//GEN-LAST:event_disneyActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        new Sound("abc.wav");
        try {
            ServerClass sc = new ServerClass() ;
            sc.sendEnd() ;
            System.exit(0);
        } catch (Exception e) {}
        
    }//GEN-LAST:event_closeActionPerformed

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
        new Sound("abc.wav");
        try {
            String ip = serverIP.getText() ;
            boolean isIp=IPAddressUtil.isIPv4LiteralAddress(ip);
            System.out.println(isIp);
            if(isIp || ip.equals("localhost"))
            {
                ServerClass sc = new ServerClass() ;
                sc.mainMethod(ip,type) ;
                jLabel3.setText("Server Ready");
                this.startGame.setEnabled(false);
                this.serverIP.setEditable(false);
            }
            else{
                JOptionPane.showMessageDialog(this, "Enter valid IP");
                this.serverIP.setText(null);
                System.out.println("done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_startGameActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SERVER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton disney;
    private javax.swing.JButton general;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton science;
    private javax.swing.JTextField serverIP;
    private javax.swing.JButton startGame;
    // End of variables declaration//GEN-END:variables
}
