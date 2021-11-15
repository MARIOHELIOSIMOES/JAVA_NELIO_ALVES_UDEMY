package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String strPath = "C:\\Workspace\\JAVA_NELIO_ALVES_UDEMY\\Modulo17Files\\in.csv";
		List<Product> produtos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(strPath)))) {
			String line = br.readLine();

			while (line != null) {
				String[] values = line.split(",");
				if (values.length == 3) {
					String name = String.valueOf(values[0].trim());
					Double price = Double.parseDouble(values[1].trim());
					Integer quantity = Integer.parseInt(values[2].trim());
					Product product = new Product(name, price, quantity);
					produtos.add(product);
				}
				line = br.readLine();
			}
			System.out.println("Imprimindo produtos leitura: ");
			for (Product p : produtos) {
				System.out.println(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		strPath = "C:\\Workspace\\JAVA_NELIO_ALVES_UDEMY\\Modulo17Files\\out\\summary.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(strPath),false))) {
			System.out.println("Gravando summary");
			for (Product p : produtos) {
				bw.write(p.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// File(strPath))))
	}
}
