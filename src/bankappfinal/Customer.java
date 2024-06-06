package bankappfinal;


import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bekom
 */
public class Customer implements Serializable{

    private final String firstName;
    private final String lastName;
    private final String ssn;
    private final Account account;

    Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.account = account;
    }
    
    @Override
    public String toString(){
      return "\nMüşteri Bilgisi\n"  +
              "İsim: " + getFirstName() + "\n" +
              "Soyadı: " + getLastName() + "\n" +
              "TC: " + getSsn() + "\n" +
              account;        
    }
    
    public String basicInfo(){
      return  " Hesap Numarası: "  + account.getAccountNumber() + " - İsim: " + getFirstName() + " " + getLastName();         
    }
    
    Account getAccount(){
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }
}
