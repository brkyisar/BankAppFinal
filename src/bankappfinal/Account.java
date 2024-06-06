package bankappfinal;


import java.io.Serializable;


public abstract class Account implements Serializable{
    
    private double balance = 0;
    private int accountNumber;
        
    Account(int accountId) {
        accountNumber = accountId;
    }
    
    public abstract AccountType getAccountType();
    
   
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   
    public int getAccountNumber() {
        return accountNumber;
    }
    
           
    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Override
    public String toString(){
        return "Hesap Türü: " + getAccountType() + " Hesap\n" +
               "Hesap Numarası:" + this.getAccountNumber() + "\n"+
                "Bakiye: " + this.getBalance() + "\n";
                
    }
}
