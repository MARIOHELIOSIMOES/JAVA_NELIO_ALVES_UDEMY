package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PayPalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number= sc.nextInt();
		sc.nextLine();
		System.out.print("Date: ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		Contract contract = new Contract(number, date, totalValue);
		
		ContractService cs = new ContractService(new PayPalService());
		cs.processContract(contract, months);
		
		System.out.println("");
		System.out.println("Installments ");
		//for(Installment installment: cs.getContract().getInstallments()) {
		for(Installment installment: contract.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();
	}

}
