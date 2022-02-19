/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

/**
 *
 * @author HemEv
 */
public class Person {
        private String name;
	private String surname;
	private String TC;
	private String Id;
	private String password;

   
        
    public Person(String Name,String Surname,String TC, String password,String type) {
        this.TC = TC;
        this.password = password;
        this.name=Name;
        this.surname=Surname;
        this.type=type;
        
    }
        
	 public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        private String type;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getTC() {
			return TC;
		}
		public void setTC(String tC) {
			TC = tC;
		}
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
