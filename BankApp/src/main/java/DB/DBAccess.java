/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import UI.CustomerUI;
import account.*;
import card.Card;
import insurance.CorporateInsurance;
import insurance.IndividualInsurance;
import insurance.Insurance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import person.*;

/**
 *
 * @author HemEv
 */
public class DBAccess {
      DbHelper db = new DbHelper();
		Connection connect = null;
		Statement statement = null;
		ResultSet resultset;
    
   public Employee employee(String no,String pw)
    {
        Employee employee=null;
        int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
     String num="121131"+String.valueOf(randomNum);
        try {
            connect = db.getConnection();
                    statement = connect.createStatement();
                    resultset=statement.executeQuery("select * from employee");
                     while (resultset.next()) {
				if(resultset.getString("EmployeeNo").equals(no)&&resultset.getString("Password").equals(pw)){
                                    if(resultset.getString("Type").equals("Manager")){
                          employee = new Manager(resultset.getString("Name"), resultset.getString("Surname"), resultset.getString("TCKNO"), resultset.getString("Password"),resultset.getString("Type"),num);
                                    }
                                    else if(resultset.getString("Type").equals("Officer"))
                                    {
                                         employee = new Officer(resultset.getString("Name"), resultset.getString("Surname"), resultset.getString("TCKNO"), resultset.getString("Password"),resultset.getString("Type"),num);
                                    }
                            if(employee!=null)
                           return employee;
                        }}
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
        return null;
    }
    public Customer getData(String TCKNO,String Password)
    {
      
                Customer customer = null;
                
                try {
                    connect = db.getConnection();
                    statement = connect.createStatement();
                    resultset=statement.executeQuery("select * from customer");
                   
                    while (resultset.next()) {
				if(resultset.getString("TCKNO").equals(TCKNO)&&resultset.getString("Password").equals(Password)){
                          customer = new Customer(resultset.getString("Name"), resultset.getString("Surname"), resultset.getString("TCKNO"), resultset.getString("Password"),resultset.getString("Type"),resultset.getDouble("InterestRate"),resultset.getString("Job"),resultset.getDouble("Income"),resultset.getString("IsMarried"),resultset.getDouble("Debt"));
                            
                           return customer;
                        }}
                    if (customer==null)
                    { 
                    return null;}
            
        } catch (Exception e) {
                    System.out.println("hata");
                   
        } finally {
                    try {
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
        return null;
    }
    
    public Account account(String tc,String type)
    {
        Account account = null;
    try {
                    connect = db.getConnection();
                    statement = connect.createStatement();
                    resultset=statement.executeQuery("select * from accounts");
                   
                    while (resultset.next()) {
				if(resultset.getString("TC").equals(tc)&&resultset.getString("AccountType").equals(type)){
                                   if(type.equals("Dolar")){
                                   account = new Dolar(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                    
                                   }
                                   else if(type.equals("TL"))
                                   {
                                        account = new BankAccount(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                   
                                   }
                                   else if(type.equals("Euro"))
                                   {
                                        account = new Euro(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                   
                                   }
                                  
                                   else if(type.equals("Pound"))
                                   {
                                        account = new Pound(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                    
                                   }
                                   else if(type.equals("Gold"))
                                   {
                                        account = new Gold(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                    
                                   }
                                   else if(type.equals("Fund"))
                                           
                                   {
                                        account = new Fund(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                   
                                   }
                                   else if(type.equals("Saving"))
                                   {
                                        account = new Saving(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                   
                                   }
                                   else if(type.equals("Deposit"))
                                   {
                                        account = new Deposit(resultset.getString("AccountType"), resultset.getString("IBAN"), resultset.getString("AccountId"),1, resultset.getString("Amount"));
                                    
                                   }
                               return account;
                        }}
                    if (account==null)
                   return null;
            
        } catch (Exception e) {
                    System.out.println("hata");
                   
        } finally {
                    try {
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
        return null;
    }
    
   private  ArrayList<Card> cards = new ArrayList<>();
   public ArrayList<Card> cardInfo(Customer customer)
   {
      
       String a = "select * from cards where tc="+customer.getTC();
       try {
           connect = db.getConnection();
                    statement = connect.createStatement();
                    resultset=statement.executeQuery(a);
                   cards.clear();
                    while (resultset.next()) {
                       cards.add(new Card(resultset.getString("CardName"),resultset.getString("CardNum"),resultset.getInt("CardPassword"),resultset.getString("CardType")));
                        }
                       
                    
                    if (cards==null)
                    { System.out.println("nulleror");
                    return null;}
                    else
                        return cards;
       } catch (Exception e) {
           System.out.println("hatacard");
       } finally {
       }
       return null;  
   }
  private Insurance insurance ;
    
  public  Insurance insuranceInfo(Customer customer)
    {String a = "select * from insurances where tc="+customer.getTC();
        try {
             connect = db.getConnection();
                    statement = connect.createStatement();
                    resultset=statement.executeQuery(a);
                    while (resultset.next()) {
                       if(customer.getType().equals("Individual"))
                       insurance=new IndividualInsurance(resultset.getString("Type"),resultset.getInt("Year"));
                       else if(customer.getType().equals("Corporate"))
                      insurance=new CorporateInsurance(resultset.getString("Type"),resultset.getInt("Year"));

                        }
                    return insurance;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        }
        return null;
    }
   
}
