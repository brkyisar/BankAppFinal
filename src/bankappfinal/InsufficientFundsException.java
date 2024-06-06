package bankappfinal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bekom
 */
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("İşlemi tamamlamak için yeterli paranız yok.");
    }
    
}
