/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author HemEv
 */
public class Manager extends Employee implements emp{
    int randomNum = 5;
  
    public Manager(String Name,String Surname,String TC, String password,String type,String employeeNo) {
        super(Name,Surname,TC, password,type,employeeNo);
    }

    @Override
    public int point() {
       return randomNum;
    }
    
}
