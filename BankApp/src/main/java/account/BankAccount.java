/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

/**
 *
 * @author HemEv
 */
public class BankAccount extends Account{
    
    public BankAccount(String accountType, String IBAN, String AccountId, int password, String amount) {
        super(accountType, IBAN, AccountId, password, amount);
    }
    
}
