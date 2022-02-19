/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import account.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import person.*;

/**
 *
 * @author HemEv
 */
public class DBWrite {
    
    DbHelper db = new DbHelper();
    Connection connect = null;
    PreparedStatement statement = null;
    Statement statement2 = null;
    ResultSet resultset;
    
    
    public void addTLAcc(Customer customer)
    {int randomNum = ThreadLocalRandom.current().nextInt(1000000, 99999000);
       String rand = String.valueOf(randomNum);
        try {
            connect = db.getConnection();
            String sql = "insert into accounts (TC,IBAN,AccountType,Amount) values(?,?,?,?)";
			statement = connect.prepareStatement(sql);
			statement.setString(1, customer.getTC());
			statement.setString(2, rand);
                        statement.setString(3, "TL");
                        statement.setString(4, "1000");
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
        } catch (Exception e) {
            System.out.println(e);
        }
        finally
        {
        try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}}
    }
     public void addAcc(Customer customer,String type)
   {
       
    
       int randomNum = ThreadLocalRandom.current().nextInt(1000000, 99999000);
       String rand = String.valueOf(randomNum);
      try {
          
			connect = db.getConnection();
                        statement2 = connect.createStatement();
                    resultset=statement2.executeQuery("select * from accounts");
                    if(customer==null)
                             return;
                     while (resultset.next()) {
				if(resultset.getString("TC").equals(customer.getTC())&&resultset.getString("AccountType").equals(type)){
                                     JOptionPane.showMessageDialog(null,"Already there is an accout","Account",JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                           }
                     
                     
			String sql = " insert into accounts (TC,IBAN,AccountType) values(?,?,?)";
			statement = connect.prepareStatement(sql);
			statement.setString(1, customer.getTC());
			statement.setString(2, rand);
                        statement.setString(3, type);
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Hata, hesap kurulamadı");
			db.showErrorMessage(e);
		} finally {
			try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
   }
     
     
     
    public void addCard(Customer customer,int Password,String cardName,String cardType)
     {   int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
     String num="520055665896"+String.valueOf(randomNum);
     
         try {
              connect = db.getConnection();
              statement = connect.prepareStatement("insert into cards (CardNum,CardPassword,TC,CardType,CardName) values(?,?,?,?,?)");
                        statement.setString(1, num);
			statement.setInt(2,Password);
                        statement.setString(3, customer.getTC());
                        statement.setString(4, cardType);
                        statement.setString(5, cardName);
			statement.executeUpdate();
                        
			System.out.println("BAĞLANTI OK");
         } 
          catch(Exception e){
                     System.out.println("writehata");
                     System.out.println(e);
                     }
         finally {
              try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         }
     }
     
      public void deleteCard(Customer customer,String cardNum,String Password)
     {   
         try {
             if(customer.getPassword().equals(Password))
             { connect = db.getConnection();
              statement = connect.prepareStatement("delete from cards where CardNum=? and TC=?");
                        statement.setString(1, cardNum);
			statement.setString(2,customer.getTC());
                        
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
             }
             else
                  JOptionPane.showMessageDialog(null,"Password is not correct","Card",JOptionPane.ERROR_MESSAGE);
         } 
          catch(Exception e){
                     System.out.println("writehata");
                     System.out.println(e);
                     }
         finally {
              try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         }
     }
      
      public Credit Credit(Double debt,Customer customer,String type){
          String a = customer.getTC();
         Double debt2=0.0;
         try {
             connect = db.getConnection();
             statement2 = connect.createStatement();
             resultset=statement2.executeQuery("select * from customer where TCKNO="+customer.getTC());
             while(resultset.next())
             {
                 debt2=Double.valueOf(resultset.getString("Debt"))+debt;
             }
             
             String upt = "update customer set Debt=? where TCKNO=?";
                 statement = connect.prepareStatement(upt);
		statement.setDouble(1, debt2);
                  statement.setString(2, customer.getTC());
		statement.executeUpdate();
                       customer.setDebt(debt2);
                if(type.equals("Housing"))
                {
                return new Housing(customer.getType(),debt2);
                }
                else if(type.equals("Student")){
                return new Student(customer.getType(),debt2);
                }
                else if(type.equals("Marriage"))
                {
                return new Marriage(customer.getType(),debt2);
                }
                else if(type.equals("Finance"))
                {
                return new PersonalFinance(customer.getType(),debt2);
                }
                return null;
         } 
          catch(Exception e){
                     System.out.println("writehata");
                     System.out.println(e);
                     }
         finally {
              try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         }
      return null;
      }
      
      
      public void transferMoney(String IBAN,String amount,Customer customer)
     {
         Boolean boolF=false;
         Boolean boolS=false;
         String trf="0";
         String gln="0";
         int i=0;
         try {
             connect = db.getConnection();
             statement2 = connect.createStatement();
             resultset=statement2.executeQuery("select * from accounts");
            
                     while (resultset.next()) {
				if(resultset.getString("IBAN").equals(IBAN)&&resultset.getString("AccountType").equals("TL")){
                                    // JOptionPane.showMessageDialog(null,"Already there is an accout","Account",JOptionPane.ERROR_MESSAGE);
                                    boolF=true;
                                    trf=resultset.getString("Amount");
                                    }
                                if(resultset.getString("TC").equals(customer.getTC())&&resultset.getString("AccountType").equals("TL"))
                                    {
                                        gln=resultset.getString("Amount");
                                        boolS=true;
                                        
                                    }
                     }
                   
                     if(boolF == false||boolS==false)
                         return;
                    double a =Double.parseDouble(trf);
                    a=a+Double.parseDouble(amount);
                    trf=Double.toString(a);
                    double b = Double.parseDouble(gln);
                    b=b-Double.parseDouble(amount);
                    gln=Double.toString(b);
                     String first = "update accounts set Amount=? where IBAN=?";
                     String second = "update accounts set Amount=? where TC=? and AccountType='TL'";
			statement = connect.prepareStatement(first);
			statement.setString(1, trf);
                        statement.setString(2, IBAN);
			statement.executeUpdate();
                        statement = connect.prepareStatement(second);
                        statement.setString(1, gln);
                        statement.setString(2, customer.getTC());
                        statement.executeUpdate();
			System.out.println("UPDATE OK");
                        System.out.println("Money Sent");
                    
         } catch (Exception e) {
         } finally {
             try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         }
     }
      
      
       public void payDebt(Double amount,Customer customer,Account acc){
          
          Double b,dd;
          String k;
          String trf="0";
         Double debt2=0.0;
         try {
             
             connect = db.getConnection();
             statement2 = connect.createStatement();
             resultset=statement2.executeQuery("select * from accounts");
            
                     while (resultset.next()) {
				
                                if(resultset.getString("TC").equals(customer.getTC())&&resultset.getString("AccountType").equals("TL"))
                                    {
                                        trf=resultset.getString("Amount");
                                      
                                    }
                     }
             dd=Double.valueOf(trf)-amount;
             trf=dd.toString();
             connect = db.getConnection();
            customer.setDebt(customer.getDebt()-amount);
           /* b= Double.valueOf(acc.getAmount())-amount;
            k=b.toString();*/
            
             
             String upt = "update customer set Debt=? where TCKNO=?";
             String upt2="update accounts set Amount=? where TC=? and AccountType='TL'";
                 statement = connect.prepareStatement(upt);
		statement.setDouble(1, customer.getDebt());
                  statement.setString(2, customer.getTC());
		statement.executeUpdate();
                statement = connect.prepareStatement(upt2);
		statement.setString(1,trf);
                  statement.setString(2, customer.getTC());
		statement.executeUpdate();
                       
                
                
         } 
          catch(Exception e){
                     System.out.println("writehata");
                     System.out.println(e);
                     }
         finally {
              try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         }
      }
       
       
       public void buyCurrency(Account acc,Customer customer,Double amount,Double currentCurrency)
       {
       Double b,dd;
          String k="0";
          String trf="0";
         
         try {
             
             connect = db.getConnection();
             statement2 = connect.createStatement();
             resultset=statement2.executeQuery("select * from accounts");
            
                     while (resultset.next()) {
				
                                if(resultset.getString("TC").equals(customer.getTC())&&resultset.getString("AccountType").equals("TL"))
                                    {
                                        trf=resultset.getString("Amount");
                                      
                                    }
                                 if(resultset.getString("TC").equals(customer.getTC())&&resultset.getString("AccountType").equals(acc.getAccountType()))
                                    {
                                        k=resultset.getString("Amount");
                                      
                                    }
                     }
             dd=Double.valueOf(trf)-amount;
             trf=dd.toString();
             connect = db.getConnection();
             amount=amount/currentCurrency+Double.valueOf(k);
              Double cr = (int)(Math.round(amount * 100))/100.0;
              
            acc.setAmount(cr.toString());
          
            
             
             String upt = "update accounts set Amount=? where TC=? and AccountType='TL'";
             String upt2="update accounts set Amount=? where TC=? and AccountType='"+acc.getAccountType()+"'";
                 statement = connect.prepareStatement(upt);
		statement.setString(1, trf);
                  statement.setString(2, customer.getTC());
		statement.executeUpdate();
                statement = connect.prepareStatement(upt2);
		statement.setString(1,acc.getAmount());
                  statement.setString(2, customer.getTC());
		statement.executeUpdate();
                       
                
                
         } 
          catch(Exception e){
                     System.out.println("writehata");
                     System.out.println(e);
                     }
         finally {
              try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
         }
       }
       
        public void deleteCustomer(String TCKNO)
    {
        try {
            connect = db.getConnection();
              statement = connect.prepareStatement("delete from customer where TCKNO=?");
                        statement.setString(1, TCKNO);
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
                        // JOptionPane.showMessageDialog(null,"Operation done","Delete Customer",JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally
        {
             try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
        
    }  
        
        public void createCustomer(Customer customer)
        {
            try {
                connect = db.getConnection();
                String sql = " insert into customer (Name,Surname,TCKNO,Password,Type,InterestRate,Job,IsMarried,Debt,Income) values(?,?,?,?,?,?,?,?,?,?)";
			statement = connect.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getSurname());
                        statement.setString(3, customer.getTC());
                        statement.setString(4, customer.getPassword());
                        statement.setString(5, customer.getType());
                        statement.setDouble(6, customer.getInterestRate());
                        statement.setString(7, customer.getJob());
                        statement.setString(8, customer.getIsMarried());
                        statement.setDouble(9, customer.getDebt());
                        statement.setDouble(10, customer.getIncome());
                        
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
            } catch (Exception e) {
                System.out.println(e);
            }
            finally{
            try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
            }
        }
        public void createEmployee(Officer officer)
        {
            try {
                connect = db.getConnection();
                String sql = " insert into employee (Name,Surname,EmployeeNo,TCKNO,Password,Type) values(?,?,?,?,?,?)";
			statement = connect.prepareStatement(sql);
			statement.setString(1, officer.getName());
			statement.setString(2, officer.getSurname());
                        statement.setString(3, officer.getEmployeeNo());
                        statement.setString(4, officer.getTC());
                        statement.setString(5, officer.getPassword());
                        statement.setString(6, officer.getType());
                        
                        
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
            } catch (Exception e) {
                System.out.println(e);
            }
            finally{
            try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
            }
        }
        public void deleteEmployee(String TCKNO)
    {
        try {
            connect = db.getConnection();
              statement = connect.prepareStatement("delete from employee where TCKNO=?");
                        statement.setString(1, TCKNO);
			statement.executeUpdate();
			System.out.println("BAĞLANTI OK");
                         JOptionPane.showMessageDialog(null,"Operation done","Delete Customer",JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally
        {
             try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
        
    }  
        
        public void Insurance(Customer customer)
        {int year=1;
            try {
                connect = db.getConnection();
                String sql = " insert into insurances (Type,Year,TC) values(?,?,?)";
			statement = connect.prepareStatement(sql);
			statement.setString(1, customer.getType());
			statement.setInt(2, year);
                        statement.setString(3, customer.getTC());
                        statement.executeUpdate();
                        
                       
			System.out.println("BAĞLANTI OK");
            } catch (Exception e) {
                System.out.println(e);
            }
            finally{
            try {
				statement.close();
				connect.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
            }
            
        }
}
