package models;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount asbel = new BankAccount(100,200);
		BankAccount mark = new BankAccount(50,120);
		System.out.println("Account No: " + asbel.getAccountNumber() + " Savings: " + asbel.getSavingsBalance() + "  Checking: " + asbel.getCheckingBalance());
	
		asbel.withdraw("savings", 500);
		asbel.deposit("checking", 75);
		
		
		asbel.displayTotals();
		System.out.println(BankAccount.getNumberOfAccounts());

	}

}
