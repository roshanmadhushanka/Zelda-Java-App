/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import DAO.ItemDAO;
import DAO.ProductDAO;
import DTO.ItemDTO;
import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import zeldacon.Internet;
import zeldacon.PERIOD;
import zeldacon.SerialConnection;

/**
 *
 * @author User
 */
public class Monitor extends javax.swing.JFrame {
    private static Monitor form;
    
    ItemChecker itemChecker;  //Item status checking class
    DefaultTableModel model;  //Table structure
    Hashtable<Integer, ItemDTO> itemList;
   
    private void clearTable(){
        int size = model.getRowCount();
        for(int i=0; i<size; i++){
            model.removeRow(0);
        }
        itemList.clear();
    }
    
    public void addItemToTable(ItemDTO itemDTO){
        if(!itemList.containsKey(itemDTO.getId())){
            String status;
            switch (itemDTO.getStatus()) {
                case "P":
                    status = "Paid";
                    break;
                case "U":
                    status = "Not paid";
                    break;
                default:
                    status = "Error";
                    break;
            }
            
            model.insertRow(model.getRowCount(), new Object[] {itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), status});
            itemList.put(itemDTO.getId(), itemDTO);
        }
        
    }
    
    private Monitor() {
        itemChecker = new ItemChecker();
        
        initComponents();
        
        //Initialize table model
        model = (DefaultTableModel) tblItem.getModel();
        
        //Item list
        itemList = new Hashtable<>();
        
        tblItem.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component object = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
                String status = (String) tblItem.getModel().getValueAt(row, 3);
                
                switch (status) {
                    case "P":
                        setBackground(Color.GREEN);
                        break;
                    case "U":
                        status = "Not paid";
                        break;
                    default:
                        status = "Error";
                        break;
                }
                return object;
            }
        
        });
    }
    
    public static Monitor getForm(){
        if(form == null){
            form = new Monitor();
            form.setDefaultCloseOperation(EXIT_ON_CLOSE);
            form.setExtendedState(form.getExtendedState() | MAXIMIZED_BOTH);
            ProductDAO.update();
        }
        return form;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        pnlStat = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnProductList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mnuAddItem = new javax.swing.JMenuItem();
        mnuItemTransaction = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuAddProduct = new javax.swing.JMenuItem();
        mnuProductDetails = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel1.setText("Zelda Shooping Mate");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnStart.setText("Start");
        btnStart.setName("btnStart"); // NOI18N
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStatLayout = new javax.swing.GroupLayout(pnlStat);
        pnlStat.setLayout(pnlStatLayout);
        pnlStatLayout.setHorizontalGroup(
            pnlStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlStatLayout.setVerticalGroup(
            pnlStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnProductList.setText("Product List");
        btnProductList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProductList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnStart)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductList)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnStart.getAccessibleContext().setAccessibleName("btnStart");

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblItem);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Zelda Inc. 2016");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jMenu3.setText("Item");

        mnuAddItem.setText("Add Item");
        mnuAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddItemActionPerformed(evt);
            }
        });
        jMenu3.add(mnuAddItem);

        mnuItemTransaction.setText("Item Transaction");
        mnuItemTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemTransactionActionPerformed(evt);
            }
        });
        jMenu3.add(mnuItemTransaction);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Product");

        mnuAddProduct.setText("Add Product");
        mnuAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddProductActionPerformed(evt);
            }
        });
        jMenu4.add(mnuAddProduct);

        mnuProductDetails.setText("Product Details");
        mnuProductDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProductDetailsActionPerformed(evt);
            }
        });
        jMenu4.add(mnuProductDetails);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        new SerialConnection((String data) -> {
            //Read data from arduino interfacr (item ID)
            txtID.setText(data);
            try{
                //Initialize data access object
                ItemDAO itemDAO = new ItemDAO();
                
                //Get item by ID into a data transfer object
                ItemDTO itemDTO = itemDAO.getItemById(data);
                
                //Add item to the table
                addItemToTable(itemDTO);
                
                //Check item status
                switch (itemDTO.getStatus()) {
                    case "U":
                        //Not paid item
                        pnlStat.setBackground(Color.red);
                        new Sound().playSound("");
                        break;
                    case "P":
                        //Paid item
                        pnlStat.setBackground(Color.green);
                        break;
                    default:
                        pnlStat.setBackground(Color.yellow);
                        break;
                }
            } catch(Exception e){
                //System error
                e.printStackTrace();
                pnlStat.setBackground(Color.yellow);
            }
        }, PERIOD.FOREVER).listen();
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnProductListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductListActionPerformed
        ProductList.getForm().setVisible(true);
    }//GEN-LAST:event_btnProductListActionPerformed

    private void mnuAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddItemActionPerformed
        if(Internet.checkStatus()){
            AddItem.getForm().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No Internet Connection", "Connection error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_mnuAddItemActionPerformed

    private void mnuAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddProductActionPerformed
        AddProduct.getForm().setVisible(true);
    }//GEN-LAST:event_mnuAddProductActionPerformed

    private void mnuProductDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProductDetailsActionPerformed
        ProductList.getForm().setVisible(true);
    }//GEN-LAST:event_mnuProductDetailsActionPerformed

    private void mnuItemTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemTransactionActionPerformed
         ItemTransaction.getForm().setVisible(true);
    }//GEN-LAST:event_mnuItemTransactionActionPerformed

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
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Monitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnProductList;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuAddItem;
    private javax.swing.JMenuItem mnuAddProduct;
    private javax.swing.JMenuItem mnuItemTransaction;
    private javax.swing.JMenuItem mnuProductDetails;
    private javax.swing.JPanel pnlStat;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
