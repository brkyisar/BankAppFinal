package bankappfinal;





import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Carl
 */
public class AddAccountMenu extends javax.swing.JDialog {

    private Bank bank;
    private Customer customer;

    /**
     * Creates new form AddAccountMenu
     */
    public AddAccountMenu(java.awt.Frame parent, boolean modal, Bank bank) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.bank = bank;
        customer = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        ssnLabel = new javax.swing.JLabel();
        ssnField = new javax.swing.JTextField();
        depositLabel = new javax.swing.JLabel();
        depositField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Account Menu");
        getContentPane().setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        firstNameLabel.setText("İsim:");
        getContentPane().add(firstNameLabel);
        getContentPane().add(firstNameField);

        lastNameLabel.setText("Soyisim:");
        getContentPane().add(lastNameLabel);
        getContentPane().add(lastNameField);

        ssnLabel.setText("TCKN:");
        getContentPane().add(ssnLabel);
        getContentPane().add(ssnField);

        depositLabel.setText("İlk yatırım:");
        getContentPane().add(depositLabel);
        getContentPane().add(depositField);

        typeLabel.setText("Hesap türü:");
        getContentPane().add(typeLabel);

        typeField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vadesiz", "Vadeli" }));
        getContentPane().add(typeField);

        okButton.setText("Onayla");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okButton);

        cancelButton.setText("İptal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        StringBuilder warnings = new StringBuilder();
        String firstName = "", lastName = "", ssn = "", depositString = "";
        double amount = 0;
        //Verify first name field
        if (firstNameField.getText().isEmpty()) {
            warnings.append("İsim boş olamaz.\n");
        } else {
            firstName = firstNameField.getText();
        }
        //Verify last name field
        if (lastNameField.getText().isEmpty()) {
            warnings.append("Soyadı boş olamaz.\n");
        } else {
            lastName = lastNameField.getText();
        }
        if (!ssnField.getText().matches("^[0-9]{11}$")) {
            warnings.append("TCKN 11 haneden oluşmalıdır\n");
        } else {
            ssn = ssnField.getText().replace("-", "");
        }
        //Verify initial deposit
        if (depositField.getText().isEmpty()) {
            warnings.append("İlk yatırım girilmelidr.");
        } else {
            try {
                amount = Bank.round(Double.parseDouble(depositField.getText()), 2);
            } catch (NumberFormatException ex) {
                warnings.append("İlk yatırım sayı olmalıdır");
            }
        }
        if (warnings.length() > 0) {
            JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
        } else {
            AccountType accountType = AccountType.Undefined;
            if (typeField.getSelectedItem().toString() == "Vadesiz") {
                if (amount >= 100) {
                    accountType = AccountType.Vadesiz;
                } else {
                    warnings.append("İlk yatırım en az 100TL olmalıdır.");
                }
            } else if (typeField.getSelectedItem().toString() == "Vadeli") {
                if (amount >= 50) {
                    accountType = AccountType.Vadeli;
                } else {
                    warnings.append("İlk yatırım en az 50TL olmalıdır.");
                }
            }
            if (accountType != AccountType.Undefined) {
                int accountId = bank.openAccount(firstName, lastName, ssn, accountType, amount);
                customer = bank.getCustomer(accountId);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, warnings.toString(), "Input Warnings", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField depositField;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField ssnField;
    private javax.swing.JLabel ssnLabel;
    private javax.swing.JComboBox typeField;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    Customer getCustomer() {
        return customer;
    }
}
