
public class SavingsAccount {
	private static float annualInterestRate;	
	private float savingsBalance;	
	private float monthlyInterest;
	
	public SavingsAccount(float savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest() {
		this.monthlyInterest = (savingsBalance * annualInterestRate) / 12;
		System.out.println("The next month interest is: $ " + this.monthlyInterest);
	}
	
	public static void modifyInterestRate(float interestRate) {
		annualInterestRate = interestRate;
	}
	
}
