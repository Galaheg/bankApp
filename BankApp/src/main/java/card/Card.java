/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 *
 * @author HemEv
 */
public class Card {
   private String cardName;
   
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
   
    
    private String cardNum;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
    
    private int password;

		public int getPassword() {
			return password;
		}
	
		public void setPassword(int password) {
			this.password = password;
		}
	
	String cardType;

		public String getCardType() {
			return cardType;
		}
		
		
	public void setCardType(String AccountType) {
		
		this.cardType=AccountType;
	}

    public Card(String cardName, String cardNum, int password,String cardType) {
        this.cardName = cardName;
        this.cardNum = cardNum;
        this.password = password;
        this.cardType=cardType;
    }
        
        
}
