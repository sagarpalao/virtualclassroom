/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualclassroom;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author SAGAR
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    String userid="";
    String ipxcc="";
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtuserid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cblogintype = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        txtIPC = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login...");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel2.setText("User ID");

        txtuserid.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtuserid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuseridActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel4.setText("Login As");

        cblogintype.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        cblogintype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Participant", "Presenter" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel5.setText("IP to connect");

        btnlogin.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btnlogin.setText("Login");
        btnlogin.setToolTipText("Click to Login to a session...");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btncancel.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        txtIPC.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtIPC.setToolTipText("<html>Enter IP Address of server machine...<br>eg. ((192.168.68.1)|(179.168.35.2))");

        txtpass.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/virtualclassroom/Loginformimage.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 90)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Login...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtpass)
                                .addComponent(cblogintype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIPC)
                                .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cblogintype, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtIPC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
   if(txtIPC.getText().equals("") || txtuserid.getText().equals("") || txtpass.getText().equals("")){
       JOptionPane.showMessageDialog(this,"Insufficient Data to Login...");
   }
   else{
    String ip = txtIPC.getText();
    ipxcc=ip;
    
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://"+ipxcc+":3306/vctuser";
    String ltp = (String)cblogintype.getSelectedItem();
    //  Database credentials
    userid=txtuserid.getText();
    String USER = "root";
    String PASS = "";
    Connection conn = null;
    PreparedStatement stmt = null;
    if(ltp.equals("Participant"))
    {
    try{
        //STEP 2: Register JDBC driver

   
        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        //STEP 4: Execute a query
            stmt = conn.prepareStatement("SELECT * FROM vct_partc WHERE user_id=? ;");
            String stw = txtuserid.getText();
        stmt.setString(1,stw);
        System.out.println("hi");
        String strx="";
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
        strx=rs.getString("passwd");
        }  
        String usi=txtpass.getText();
        if(strx.equals(usi))
        {
            JOptionPane.showMessageDialog(null,stw+"\nWelcome to Virtual Classroom...");
            this.dispose();
            ProfessorSelectionForm pcv = new ProfessorSelectionForm(userid,ipxcc);
            pcv.setVisible(true);
            pcv.setLocationRelativeTo(null);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid User ID or Password\nOR\nIncorrect Login type");
        }
        //STEP 5: Extract data from result set
        rs.close();


    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        JOptionPane.showMessageDialog(null,"Incorrect IP address format\nOR\nInvalid IP address");
    }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        //finally block used to close resources
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){
        }// do nothing
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    }//end try
    }
    else if(ltp.equals("Presenter"))
    {
        try{
        //STEP 2: Register JDBC driver


        Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        //STEP 4: Execute a query
            stmt = conn.prepareStatement("SELECT * FROM vct_pres WHERE user_id=? ");
            String stw = txtuserid.getText();
        stmt.setString(1,stw);
        //System.out.println();
        String strx="";
        ResultSet rs = stmt.executeQuery();
        while(rs.next())
        {
        strx=rs.getString("paswd");
        }  
        String usi=txtpass.getText();
        if(strx.equals(usi))
        {
            JOptionPane.showMessageDialog(null,stw+"\nWelcome to Virtual Classroom...");
            this.dispose();
            PresenterView pcv = new PresenterView(userid,ipxcc);
            pcv.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid User ID or Password\nOR\nIncorrect Login type");
        }
        //STEP 5: Extract data from result set
        rs.close();


    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
        JOptionPane.showMessageDialog(null,"Incorrect IP address format\nOR\nInvalid IP address");
    }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        //finally block used to close resources
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){
        }// do nothing
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    }//end try
    }
   }
    }//GEN-LAST:event_btnloginActionPerformed

    private void txtuseridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuseridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuseridActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginForm().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnlogin;
    private javax.swing.JComboBox cblogintype;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtIPC;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuserid;
    // End of variables declaration//GEN-END:variables
}
