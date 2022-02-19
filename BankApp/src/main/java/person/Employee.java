/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

/**
 *
 * @author HemEv
 */
public class Employee extends Person{
    private String EmployeeNo;

    public Employee(String Name,String Surname,String TC, String password,String type,String employeeNo) {
        super(Name,Surname,TC, password,type);
        this.EmployeeNo=employeeNo;
    }

		public String getEmployeeNo() {
			return EmployeeNo;
		}
	
		public void setEmployeeNo(String employeeNo) {
			EmployeeNo = employeeNo;
		}
}
