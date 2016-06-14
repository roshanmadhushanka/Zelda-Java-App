/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import DAO.ProductDAO;
import DAO.TransactionDAO;
import DTO.ProductDTO;
import DTO.TransactionDTO;
import System.Report;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ItemTransaction extends javax.swing.JFrame {
    private static ItemTransaction form;
    private ArrayList<TransactionDTO> transactions;
    DefaultTableModel model;
    /**
     * Creates new form ItemTransaction
     */
    
    private ItemTransaction() {
        initComponents();
        transactions = new ArrayList<>();
        model = (DefaultTableModel) tblTransactions.getModel();
    }
    
    public static ItemTransaction getForm(){
        if(form == null){
            form = new ItemTransaction();
            form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        form.updateTable();
        return form;
    }

    private void clearTable(){
        //Remove all the itmes from the table
        int size = model.getRowCount();
        for(int i=0; i<size; i++){
            model.removeRow(0);
        }
        transactions.clear();
    }
    
    public void updateTable(){
        clearTable();
        transactions = new TransactionDAO().getAllTransactions();
        double total = 0;
        for(int i=0; i<transactions.size(); i++){
            TransactionDTO transactionDTO = transactions.get(i);
            ProductDTO product = new ProductDAO().getProductById(transactionDTO.getProductId());
            total += product.getPrice();
            model.insertRow(model.getRowCount(), new Object[] {transactionDTO.getItemId(), transactionDTO.getProductId(), transactionDTO.getDateString(), product.getName(), product.getPrice()});
        }
        lblTotal.setText("Rs : " + String.valueOf(total));
    }
    
    public void updateTable(Date dateFrom, Date dateTo){
        clearTable();
        transactions = new TransactionDAO().getAllTransactions();
        double total = 0;
        for(int i=0; i<transactions.size(); i++){
            TransactionDTO transactionDTO = transactions.get(i);
            if(transactionDTO.getDate().after(dateFrom) && transactionDTO.getDate().before(dateTo)){
                ProductDTO product = new ProductDAO().getProductById(transactionDTO.getProductId());
                total += product.getPrice();
                model.insertRow(model.getRowCount(), new Object[] {transactionDTO.getItemId(), transactionDTO.getProductId(), transactionDTO.getDateString(), product.getName(), product.getPrice()});
            }
        }
        lblTotal.setText("Rs : " + String.valueOf(total));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransactions = new javax.swing.JTable();
        dteFrom = new com.toedter.calendar.JCalendar();
        dteTo = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chkApplyDateFilter = new javax.swing.JCheckBox();
        btnPrintReport = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Item Transactions");

        tblTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Product ID", "Date", "Name", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblTransactions);

        dteFrom.setEnabled(false);
        dteFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dteFromMouseClicked(evt);
            }
        });
        dteFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dteFromPropertyChange(evt);
            }
        });
        dteFrom.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                dteFromVetoableChange(evt);
            }
        });

        dteTo.setEnabled(false);
        dteTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dteToMouseClicked(evt);
            }
        });
        dteTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dteToPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("From :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("To :");

        chkApplyDateFilter.setText("Apply date filter");
        chkApplyDateFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkApplyDateFilterActionPerformed(evt);
            }
        });

        btnPrintReport.setText("Print Report");
        btnPrintReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintReportActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setText("total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dteTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPrintReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkApplyDateFilter)
                                            .addComponent(lblTotal))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dteTo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addGap(14, 14, 14)
                        .addComponent(chkApplyDateFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrintReport)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkApplyDateFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkApplyDateFilterActionPerformed
        if(chkApplyDateFilter.isSelected()){
            dteTo.setEnabled(true);
            dteFrom.setEnabled(true);
            updateTable(dteFrom.getDate(), dteTo.getDate());
        }else{
            dteTo.setEnabled(false);
            dteFrom.setEnabled(false);
            updateTable();
        }
    }//GEN-LAST:event_chkApplyDateFilterActionPerformed

    private void dteFromMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dteFromMouseClicked
        
    }//GEN-LAST:event_dteFromMouseClicked

    private void dteToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dteToMouseClicked
        
    }//GEN-LAST:event_dteToMouseClicked

    private void dteFromVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_dteFromVetoableChange
        
    }//GEN-LAST:event_dteFromVetoableChange

    private void dteFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dteFromPropertyChange
        if(chkApplyDateFilter.isSelected()){
            updateTable(dteFrom.getDate(), dteTo.getDate());
        }
        
    }//GEN-LAST:event_dteFromPropertyChange

    private void dteToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dteToPropertyChange
        if(chkApplyDateFilter.isSelected()){
            updateTable(dteFrom.getDate(), dteTo.getDate());
        }
    }//GEN-LAST:event_dteToPropertyChange

    private void btnPrintReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReportActionPerformed
        Report report = new Report(tblTransactions, "Transaction.pdf");
        report.setFileTitle("Item Transaction report");
        report.print();
    }//GEN-LAST:event_btnPrintReportActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ItemTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintReport;
    private javax.swing.JCheckBox chkApplyDateFilter;
    private com.toedter.calendar.JCalendar dteFrom;
    private com.toedter.calendar.JCalendar dteTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblTransactions;
    // End of variables declaration//GEN-END:variables
}