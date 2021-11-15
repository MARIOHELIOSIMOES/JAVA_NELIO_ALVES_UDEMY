package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main (String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i = 1 ; i <= n; i++) {
			System.out.println("PRODUCT #"+ i+ " data: ");
			System.out.print("Commom, used or imported (c,u,i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(ch == 'u') {
				sc.nextLine();
				System.out.print("Manufacture data (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.nextLine());
				products.add(new UsedProduct(name, price, manufactureDate));
			}
			if(ch == 'i') {
				System.out.print("Customs Fee: ");
				Double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			}
			if(ch == 'c') {
				products.add(new Product(name, price));
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		for(Product p: products) {
			System.out.println(p.priceTag());
		}
		
		
		sc.close();
	}
}
