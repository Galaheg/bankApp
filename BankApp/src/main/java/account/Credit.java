/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

/**
 *
 * @author HemEv
 */
public class Credit {
    private double InterestRate;
	private double lateInterest;
	private long daysTime;
        String accountType;
        Double amount;
    public Credit(String accountType, Double amount) {
        this.amount=amount;
        this.accountType=accountType;
    }
	
		public double getInterestRate() {
			return InterestRate;
		}
		public void setInterestRate(double interestRate) {
			InterestRate = interestRate;
		}
		public double getLateInterest() {
			return lateInterest;
		}
		public void setLateInterest(double lateInterest) {
			this.lateInterest = lateInterest;
		}
		public long getDaysTime() {
			return daysTime;
		}
		public void setDaysTime(long daysTime) {
			this.daysTime = daysTime;
		}
}
