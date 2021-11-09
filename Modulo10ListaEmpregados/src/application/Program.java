package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employes will be registered? :");
		int n = Integer.parseInt(sc.nextLine());
		
		List<Employee> employList = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			boolean idInvalido = true;
			int id =-1;
			do {
				System.out.print("Id: ");
				int ids = Integer.parseInt(sc.nextLine());
				if(!employList.stream().anyMatch(it -> it.getId()==ids)) {
					idInvalido = false;
					id = ids;
				}
			}while(idInvalido);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salaray = Double.parseDouble(sc.nextLine());
			Employee e = new Employee(id, name, salaray);
			employList.add(e);
		}
		System.out.println("\nEmployes");
		for(Employee e: employList) {
			System.out.println(e);
		}
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int id = Integer.parseInt(sc.nextLine());
		Employee busca = employList.stream().filter(it->it.getId()==id).findFirst().orElse(null);
		if(busca==null) {
			System.out.println("this id does not exist");
		}else {
			System.out.print("Enter the percentege: ");
			double ammount = sc.nextDouble();
			employList.get(employList.indexOf(busca)).uptadeSalary(ammount);
		}
		System.out.println("\nEmployes");
		for(Employee e: employList) {
			System.out.println(e);
		}
		
		
		
		sc.close();
		
		
	}

}
