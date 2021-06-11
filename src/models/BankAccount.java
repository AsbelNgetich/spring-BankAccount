package models;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts;
	private static double totalBalance;
	
	
	public BankAccount(double checkingBalance, double savingsBalance) {
		super();
		this.accountNumber = this.randomAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		BankAccount.numberOfAccounts++;
		BankAccount.setTotalBalance(BankAccount.totalBalance + this.checkingBalance + this.savingsBalance);
	}
	
	

	//Getters and setters
	
	//Get account number
	public String getAccountNumber() {
		return accountNumber;
	}
	
	
	//get number of accounts created
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}



	//set account number
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	//get checking account balance
	public double getCheckingBalance() {
		return checkingBalance;
	}

	//set checking account balance
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	//get savings account balance
	public double getSavingsBalance() {
		return savingsBalance;
	}

	//set savings account balance
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	
	public static double getTotalBalance() {
		return totalBalance;
	}


	public static void setTotalBalance(double totalBalance) {
		BankAccount.totalBalance = totalBalance;
	}



	//random account number generator
	public String randomAccountNumber() {
		long accountNumber;
		accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			
		return Long.toString(accountNumber);
	}
	
	//deposit method
	public void deposit(String accountType, double amount) {
		
		if(accountType.equals("checking")) {	
			this.setCheckingBalance(this.getCheckingBalance() + amount);
			BankAccount.setTotalBalance(BankAccount.getTotalBalance() + amount);	
		} else if(accountType.equals("savings")) {
			this.setSavingsBalance(this.getSavingsBalance() + amount);
			BankAccount.setTotalBalance(BankAccount.getTotalBalance() + amount);
		}
		
	}
	
	//withdraw method
	public void withdraw(String accountType, double amount) {
		if(accountType.equals("checking")) {
			
			if(this.getCheckingBalance() < amount) {
				System.out.println("Insufficient funds! Sorry.");
			}else {
				
				this.setCheckingBalance(this.getCheckingBalance() - amount);
				BankAccount.setTotalBalance(BankAccount.getTotalBalance() - amount);
			}
				
		} else if(accountType.equals("savings")) {
			
			if(this.getSavingsBalance() < amount) {
				System.out.println("Insufficient funds! Sorry.");
			}else {
				
				this.setSavingsBalance(this.getSavingsBalance() - amount);
				BankAccount.setTotalBalance(BankAccount.getTotalBalance() - amount);
			}
				
		}
			
	}
	
	//display totals
	public void displayTotals() {
		System.out.println("Checking account balance: " + this.getCheckingBalance() + " Savings account balance: " + this.getSavingsBalance());
	}
		

}
