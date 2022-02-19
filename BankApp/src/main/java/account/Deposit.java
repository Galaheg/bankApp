package account;

/**
 *
 * @author HemEv
 */
public class Deposit extends Account {
    
    public Deposit(String accountType, String IBAN, String AccountId, int password, String amount) {
        super(accountType, IBAN, AccountId, password, amount);
    }
    
}
