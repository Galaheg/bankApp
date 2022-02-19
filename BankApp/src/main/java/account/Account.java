/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

/**
 *
 * @author HemEv
 */
public class Account {
    private String accountType;
	private String IBAN;
	private String	AccountId;
	private int password;
        private String amount;

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getAmount() {
        return amount;
    }
	

    public Account(String accountType, String IBAN, String AccountId, int password, String amount) {
        this.accountType = accountType;
        this.IBAN = IBAN;
        this.AccountId = AccountId;
        this.password = password;
        this.amount = amount;
    }

   
        
        
	
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getIBAN() {
			return IBAN;
		}
		public void setIBAN(String iBAN) {
			IBAN = iBAN;
		}
		public String getAccountId() {
			return AccountId;
		}
		public void setAccountId(String accountId) {
			AccountId = accountId;
		}
		public int getPassword() {
			return password;
		}
		public void setPassword(int password) {
			this.password = password;
		}
}
