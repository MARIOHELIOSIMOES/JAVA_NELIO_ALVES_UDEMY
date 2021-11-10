package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = new GregorianCalendar().getInstance();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client(name, email, birthDate);
		
		
		System.out.println("Enter Order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		
		Order order = new Order(cal.getTime(), status, client);
		
		
		System.out.print("How many items to this order? ");
		int qtde = sc.nextInt();
		for(int i = 1; i <= qtde; i++) {
			System.out.println("Enter "+i+" Item Data:");
			sc.nextLine();
			System.out.print("Product name:");
			String pname = sc.nextLine();
			System.out.print("Product Price:");
			Double pprice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer pqtde = sc.nextInt();
			Product product = new Product(pname, pprice);
			OrderItem orderItem = new OrderItem(product, pqtde);
			order.addItem(orderItem);
		}
		System.out.println("");
		System.out.println(order);
		
		
		sc.close();

	}

}
