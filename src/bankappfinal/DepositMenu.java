package bankappfinal;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author bekom
 */
public class DepositMenu extends javax.swing.JDialog {

    private final Customer customer;
    private Bank bank;

    /**
     * Creates new form DepositMenu
     */
    public DepositMenu(java.awt.Frame parent, boolean modal,Bank bank, Customer customer) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.customer = customer;
        this.bank = bank;
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        amountLabel = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        depositButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Para Yükleme");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        amountLabel.setText("Yatırım Miktarı:");
        getContentPane().add(amountLabel);

        amountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFieldActionPerformed(evt);
            }
        });
        getContentPane().add(amountField);

        depositButton.setText("Onayla");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });
        getContentPane().add(depositButton);

        cancelButton.setText("İptal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        if(amountField.getText().isEmpty()){
            warnings.append("Yükleme miktarı girilmedi.");
        }
        else{
            double amount = 0;
            try{
                amount = Bank.round(Double.parseDouble(amountField.getText()),2);
                int result = JOptionPane.showConfirmDialog(this,"Bu hesaba " + String.format("%.2f", amount) + "TL yatırmak istediğinize emin misiniz?\nFaizden kazanılan: " +String.format("%.2f", (bank.checkInterest(customer.getAccount().getBalance(),0*amount))) + "TL");
                if(result == JOptionPane.OK_OPTION){
                    try {
                        bank.deposit(customer.getAccount().getAccountNumber(),amount);
                        this.dispose();
                    } catch (InvalidAmountException ex) {
                        warnings.append("Yatırılan tutar hatalıdır.");
                    }
                
                }
            }
            catch(NumberFormatException ex){
                warnings.append("Yatırım sadece sayılardan oluşmalıdır.\n");
            }
        }
        
        if(warnings.length() > 0){
            JOptionPane.showMessageDialog(this, warnings.toString(),"Yükleme hatası.",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_depositButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton depositButton;
    // End of variables declaration//GEN-END:variables
}
