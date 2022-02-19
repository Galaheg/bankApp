/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import account.*;
import card.*;
import insurance.*;
import java.util.ArrayList;

/**
 *
 * @author HemEv
 */
public class Customer extends Person{
    private String CustomerNo;
	ArrayList<Card>cards = new ArrayList<Card>();
	ArrayList<Account>accounts = new ArrayList<Account>();
	ArrayList<Insurance>insurances = new ArrayList<Insurance>();
        ArrayList<Credit>credits = new ArrayList<Credit>();
        
        private Double interestRate;
        private String job;
        private Double income;
         private Double debt;

         
         public Customer(String Name,String Surname,String TC, String password,String type,Double interestRate,String job,Double Income,String IsMaried,Double debt) {
        super(Name,Surname,TC, password,type);
        this.interestRate=interestRate;
        this.job=job;
        this.income=Income;
        this.debt=debt;
        this.isMarried=IsMaried;
        this.type=type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
         private String type;
    public ArrayList<Credit> getCredits() {
        return credits;
    }

    public void setCredits(ArrayList<Credit> credits) {
        this.credits = credits;
    }
      public void addCredits(Credit credits) {
        this.credits.add(credits);
    }
	//getters & setters


    public void setDebt(Double debt) {
        this.debt = debt;
    }
         private String isMarried;

    public Double getInterestRate() {
        return interestRate;
    }

    public String getJob() {
        return job;
    }

    public Double getIncome() {
        return income;
    }

    public Double getDebt() {
        return debt;
    }

    public String getIsMarried() {
        return isMarried;
    }
   
	
    public String getCustomerNo() {
        return CustomerNo;
    }
	
    public void setCustomerNo(String customerNo) {
	CustomerNo = customerNo;
		}

    public ArrayList<Card> getCards() {
        return cards;
    }
    public void addCard(Card card)
    {
    this.cards.add(card);
    }
    public void removeCard(Card card)
    {
        this.cards.remove(card);
    }
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccounts(Account account) {
        accounts.add(account);
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }
    public void addInsurances(Insurance insurance)
    {
    this.insurances.add(insurance);
    }
    
                
}
