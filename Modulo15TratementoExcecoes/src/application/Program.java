package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithDrawException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withDrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, initialBalance, withDrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double withDraw = sc.nextDouble();
			acc.withDraw(withDraw);
			System.out.println("New Balance: "+acc.getBalance());
			
		}catch (WithDrawException e) {
			System.out.println("Withdraw error: "+ e.getMessage()); 
		}finally {
			sc.close();	
		}
		
	}

}
