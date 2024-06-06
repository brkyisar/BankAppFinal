package bankappfinal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bekom
 */
public class InvalidAmountException extends Exception {

    public InvalidAmountException() {
        super("İşlem için geçersiz tutar.");
    }
    
}
