/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualclassroom;

import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author ASUS
 */
public class ProfessorSelectionForm extends javax.swing.JFrame {

    /**
     * Creates new form ProfessorSelectionForm
     */
    String userid="";
    String ipxcc="";
    public ProfessorSelectionForm(String userid,String ipxcc){
      initComponents();
        this.userid=userid;
        this.ipxcc=ipxcc;
        setLocationRelativeTo(null);
    }
    public ProfessorSelectionForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        profList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sessions...");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        profList.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        profList.setToolTipText("List of active sessions");
        profList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(profList);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        jLabel1.setText("Sessions...");

        jList1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jList1.setToolTipText("List of inactive sessions");
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setText("Active...");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setText("Inactive...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   String DB_URL = "jdbc:mysql://"+ipxcc+":3306/vctuser";
   //String ltp = (String)jcbaccfor.getSelectedItem();
   String sessionname="",topicname="",subtopic="";
   //accfor,age,phno,usid,paswd,cnfpaswd,branch,profession,specialist;
   //  Database credentials
  
  // topicname=txttopic.getText();
  // subtopic=txtsubtopic.getText();
   FileInputStream fis=null;   
   String USER = "root";
   String PASS = "";
   Connection conn = null;
   PreparedStatement stmt = null;
   DefaultListModel dmod1 = new DefaultListModel();
   DefaultListModel dmod2 = new DefaultListModel();
            try{
               //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);
               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");
        stmt=conn.prepareStatement("SELECT distinct session_name FROM session_tbl WHERE activated=1");
        ResultSet rs = stmt.executeQuery();
        int cntx=0;
        while(rs.next())
        {
            sessionname=rs.getString("session_name");
            dmod1.addElement(sessionname);
            cntx++;
        }
        profList.setModel(dmod1);
        
        stmt=conn.prepareStatement("SELECT distinct session_name FROM session_tbl WHERE activated=0");
        rs = stmt.executeQuery();
        int cnty=0;
        while(rs.next())
        {
            sessionname=rs.getString("session_name");
            dmod2.addElement(sessionname);
            cnty++;
        }
        jList1.setModel(dmod2);
            }catch(SQLException se){
               //Handle errors for JDBC
               se.printStackTrace();
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
    }//GEN-LAST:event_formWindowOpened

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        WindowEvent e=new WindowEvent(this,1);
        this.formWindowOpened(e);
    }//GEN-LAST:event_formMouseEntered

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            try {
            // TODO add your handling code here:
                   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
             String DB_URL = "jdbc:mysql://"+ipxcc+":3306/vctuser";
             String USER = "root";
             String PASS = "";
               Connection conn = null;
               PreparedStatement stmt = null;
              Class.forName(JDBC_DRIVER);
               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");  
            String sessname=jList1.getSelectedValue().toString();
            System.out.println("Print: "+sessname+"\n");
              stmt = conn.prepareStatement("INSERT INTO loggedin_tbl(user_id,iplogin,Attend_Time,sessname) VALUES(?,?,?,?)");
            stmt.setString(1, userid);
            stmt.setString(2, ipxcc);
            stmt.setString(4, sessname);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Calendar cal = Calendar.getInstance();
	   String str=dateFormat.format(cal.getTime());
            stmt.setString(3,str);
            stmt.executeUpdate();
            this.dispose();
            ParticipantView pcvw = new  ParticipantView(userid, ipxcc, sessname);
            pcvw.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorSelectionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorSelectionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void profListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profListMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            try {
            // TODO add your handling code here:
                   String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
             String DB_URL = "jdbc:mysql://"+ipxcc+":3306/vctuser";
             String USER = "root";
             String PASS = "";
               Connection conn = null;
               PreparedStatement stmt = null;
              Class.forName(JDBC_DRIVER);
               //STEP 3: Open a connection
               System.out.println("Connecting to a selected database...");
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               System.out.println("Connected database successfully...");  
            String sessname=profList.getSelectedValue().toString();
            System.out.println("Print: "+sessname+"\n"); 
            stmt = conn.prepareStatement("INSERT INTO loggedin_tbl(user_id,iplogin,Attend_Time,sessname) VALUES(?,?,?,?)");
            stmt.setString(1, userid);
            stmt.setString(2, ipxcc);
            stmt.setString(4, sessname);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Calendar cal = Calendar.getInstance();
	   String str=dateFormat.format(cal.getTime());
            stmt.setString(3,str);
            stmt.executeUpdate();
            this.dispose();
            ParticipantView pcvw = new  ParticipantView(userid, ipxcc, sessname);
            pcvw.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorSelectionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorSelectionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_profListMouseClicked

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
            java.util.logging.Logger.getLogger(ProfessorSelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorSelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorSelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorSelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProfessorSelectionForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList profList;
    // End of variables declaration//GEN-END:variables
}
