package application;

import java.util.Locale;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import entities.Hospede;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("How many rooms will be rented?: ");
		int n = Integer.parseInt(sc.nextLine());
		Hospede[] rooms = new Hospede[10];
		
		for (int i = 0; i< n; i++) {
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Quarto: ");
			int quarto = Integer.parseInt(sc.nextLine());
			
			Hospede h = new Hospede(nome, email);
			rooms[quarto] = h;
		}
		
		System.out.println("Busy rooms");
		for(int i = 0; i< rooms.length; i++) {
			if(rooms[i]!=null) {
				System.out.println(
									"Quarto ("+i+"): "
									+rooms[i].toString());
			}
		}
		
		sc.close();
	}

}
