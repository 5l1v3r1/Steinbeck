/*
 * UAAuditScriptManager.java
 *
 * Created on November 23, 2005, 4:27 PM
 */

package steinbeck;

import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author  pilon
 */
public class UAAuditScriptManager extends javax.swing.JFrame {
    
    
    private Document document;
    
    private int mode;
    
    // private String selectedFileName;
            
    /** Creates new form UAAuditScriptManager */
    public UAAuditScriptManager() {
        initComponents();
        initializeConfigurationFile();
    }
    
    private void initializeConfigurationFile(){
        // check whether configuration file exists
        File configurationFile = new File("scripts.xml");
        if(!configurationFile.exists()){
            // if conf. file doesn't exist, create one
            try{
                BufferedWriter out = new BufferedWriter(new FileWriter("scripts.xml"));
                out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
                out.write("<scripts>");
                out.newLine();
                out.write("</scripts>");
                out.flush();
                out.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Could not produce scripts.xml in the current directory. Check permissions. \nMessage: " + e.getMessage(), "An Error Ocurred" ,JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        
        // parse scripts.xml into DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        document = null;
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File("scripts.xml"));
        }
        catch(Exception e){
                JOptionPane.showMessageDialog(this, "Could not parse scripts.xml. Check validity. \nMessage: " + e.getMessage(), "An Error Ocurred" ,JOptionPane.ERROR_MESSAGE);
                System.exit(0);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Script Configuration Window");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(70, 50));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 12));

        jPanel4.setPreferredSize(new java.awt.Dimension(250, 10));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton1.setText("Add");
        jButton1.setPreferredSize(new java.awt.Dimension(75, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel4.add(jButton1);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton4.setText("Close");
        jButton4.setPreferredSize(new java.awt.Dimension(75, 25));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.add(jButton4);

        jPanel3.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 12));

        jPanel5.setPreferredSize(new java.awt.Dimension(250, 100));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton2.setText("Remove");
        jButton2.setPreferredSize(new java.awt.Dimension(90, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.add(jButton2);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton3.setText("Select");
        jButton3.setPreferredSize(new java.awt.Dimension(90, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel5.add(jButton3);

        jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name", "Description", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(10, 30));
        getContentPane().add(jPanel6, java.awt.BorderLayout.NORTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-455)/2, 800, 455);
    }//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        formWindowClosing(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    protected void setMode(int mode){
        // mode = 1 is manage script mode: script adding, removing 
        // mode = 2 is setup audit mode: file selection
        this.mode = mode;

        if(mode == 1)
            jButton3.setVisible(false);
        else if(mode == 2)
            jButton3.setVisible(true);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        int rowIndex = jTable1.getSelectedRow();
        
        this.setVisible(false);
        UAGUIEntrance.gui.setupAudit.setVisible(true);
        
        if(rowIndex != -1)
            UAGUIEntrance.gui.setupAudit.setSelectedScript((String)dtm.getValueAt(rowIndex,0));
        else
            UAGUIEntrance.gui.setupAudit.setSelectedScript("");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        int rowIndex = jTable1.getSelectedRow();
        if(rowIndex >= 0)
            dtm.removeRow(rowIndex);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        // according to the mode, show SELECT button or not
        if(mode == 1)
            jButton3.setVisible(false);
        else
            jButton3.setVisible(true);
        
        // update table from DOM
        NodeList scriptElements = document.getElementsByTagName("script");
        // if there are script elements
        if(scriptElements != null){
            for(int i = 0; i < scriptElements.getLength(); i++){
                NodeList scriptChildElements = scriptElements.item(i).getChildNodes();
                if(scriptChildElements != null){
                    String fileName = "-", description = "no description", dateString = "-";
                    for(int j = 0; j < scriptChildElements.getLength(); j++){
                        Node scriptElement = scriptChildElements.item(j);
                        if(     scriptElement.getNodeType() == Node.ELEMENT_NODE &&
                                scriptElement.getChildNodes().getLength() == 1 &&
                                scriptElement.getFirstChild().getNodeType() == Node.TEXT_NODE
                          ){
                            if(scriptElement.getNodeName().compareTo("filename") == 0){
                                fileName = scriptElement.getFirstChild().getNodeValue();
                            }
                            else if(scriptElement.getNodeName().compareTo("description") == 0){
                                description = scriptElement.getFirstChild().getNodeValue();
                            }
                            else if(scriptElement.getNodeName().compareTo("date") == 0){
                                dateString = scriptElement.getFirstChild().getNodeValue();
                            }                            
                        }
                    }
                    addScriptToTable(fileName, description, dateString);
                }
           }        
        }
    }//GEN-LAST:event_formWindowOpened

    void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
    
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // update any changes to scripts.xml from the table (this is effectively the description part)
        updateConfigurationFile();
        
        if(mode == 2){
            DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
            int rowIndex = jTable1.getSelectedRow();
            // returns selected row's fileName, if selected of course
            this.setVisible(false);
            UAGUIEntrance.gui.setupAudit.setVisible(true);
            if(rowIndex != -1)
                UAGUIEntrance.gui.setupAudit.setSelectedScript((String)dtm.getValueAt(rowIndex,0));
            return;
        }
        
        this.setVisible(false);
        UAGUIEntrance.gui.setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    
    private void updateConfigurationFile(){
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        int rowCount = dtm.getRowCount();
        
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("scripts.xml"));
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            out.write("<scripts>");
            for(int i = 0; i < rowCount; i++){
                out.write("<script>");
                out.write("<filename>" + (String)dtm.getValueAt(i,0) + "</filename>");
                out.write("<description>" + (String)dtm.getValueAt(i,1) + "</description>");
                out.write("<date>" + (String)dtm.getValueAt(i,2) + "</date>");
                out.write("</script>");
            }
            out.write("</scripts>");
            out.flush();
            out.close();       
        }
        catch(Exception e){
               JOptionPane.showMessageDialog(this, "Can't update the configuration file (scripts.xml).", "An Error Ocurred" ,JOptionPane.ERROR_MESSAGE);
               System.exit(0);        
        }
    }
        
    private Vector getRow(int rowIndex){
        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        if(rowIndex < 0 || rowIndex > dtm.getRowCount())
            return null;
        return (Vector)dtm.getDataVector().elementAt(rowIndex);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File selectedFile = new UAGUIFileChooser().getFile();
        // first copy the file into the current directory
        if(selectedFile != null){
            try{
                // check if there is a script with the same name in scripts.xml    
                if(isThereADuplicateScript(selectedFile.getName())){
                    JOptionPane.showMessageDialog(this, "Can't add the script. There's already another script with the same name.", "An Error Ocurred" ,JOptionPane.ERROR_MESSAGE);
                    return;
                }
                copy(selectedFile, new File(selectedFile.getName()));
                addScriptToTable(selectedFile);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Can't copy the script file into the current directory\nMessage:" + e.getMessage(), "An Error Ocurred" ,JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void addScriptToTable(File selectedFile){
        String rawScript = selectedFile.getAbsolutePath();
        String fileName = selectedFile.getName();
               
        String description = "no description found";
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = df.format(date);

        // try to read file's second line
        try{
            BufferedReader in = new BufferedReader(new FileReader(rawScript));
            String aLine = in.readLine();
            aLine = in.readLine();
            if ((aLine != null) && (aLine.trim().startsWith("#") == true))
                description = aLine.trim().substring(1);
            in.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Can't add the script. Couldn't read the file.\nMessage: " + e.getMessage(), "An Error Ocurred" ,JOptionPane.ERROR_MESSAGE);
            return;
        }

        addScriptToTable(fileName, description, dateString);
    }
    
    private void addScriptToTable(String fileName, String description, String dateString){
        // add the newly added script to table
        Vector anAudit = new Vector();
        anAudit.add(fileName);
        anAudit.add(description);
        anAudit.add(dateString);

        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
        dtm.addRow(anAudit);        
    }
        
    private boolean isThereADuplicateScript(String fileName){
        NodeList scriptElements = document.getElementsByTagName("script");
        // if there are script elements
        if(scriptElements != null){
            for(int i = 0; i < scriptElements.getLength(); i++){
                NodeList scriptChildElements = scriptElements.item(i).getChildNodes();
                if(scriptChildElements != null){
                    for(int j = 0; j < scriptChildElements.getLength(); j++){
                        Node scriptElement = scriptChildElements.item(j);
                        if(     scriptElement.getNodeType() == Node.ELEMENT_NODE &&
                                scriptElement.getChildNodes().getLength() == 1 &&
                                scriptElement.getFirstChild().getNodeType() == Node.TEXT_NODE
                          ){
                            if(scriptElement.getNodeName().compareTo("filename") == 0){
                                // check duplication here
                                if(fileName.compareTo(scriptElement.getFirstChild().getNodeValue()) == 0)
                                    return true;
                                // System.out.println(scriptElement.getFirstChild().getNodeValue());
                            }
                            else if(scriptElement.getNodeName().compareTo("description") == 0){
                                // do nothing
                                // System.out.println(scriptElement.getFirstChild().getNodeValue());
                            }
                            else if(scriptElement.getNodeName().compareTo("date") == 0){
                                // do nothing
                                // System.out.println(scriptElement.getFirstChild().getNodeValue());
                            }                            
                        }
                    }
                }
           }        
        }
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
}
