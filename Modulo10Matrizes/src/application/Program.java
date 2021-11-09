package application;

import java.util.Scanner;

public class Program {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Set number of lines: ");
		int line = sc.nextInt();
		System.out.print("\nSet number of columns: ");
		int column = sc.nextInt();
		
		int[][] matriz = new int[line][column];
		
		System.out.println("Set the matriz:");
		for(int i = 0; i< line; i++) {
			for(int j = 0; j< column; j++) {
				
				matriz[i][j]= sc.nextInt();
			}
		}
		printMatriz(matriz);
		System.out.print("Find number: ");
		int number = sc.nextInt();
		printPosition(matriz, number);
		
		sc.close();
	}
	
	private static int[][] getMatriz(int line, int column ){
		Scanner sc = new Scanner(System.in);
		int matriz[][] = new int[line][column];
		System.out.println("Set the matriz:");
		for(int i = 0; i< line; i++) {
			for(int j = 0; j< column; j++) {
				
				matriz[i][j]= sc.nextInt();
			}
		}
		sc.close();
		
		return matriz;
	}
	private static void printMatriz(int[][]matriz) {
		System.out.println("Mostrando Matriz");
		
		for(int i = 0; i< matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%d ", matriz[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	
	private static void printPosition(int[][] matriz, int elemento) {
		for(int i = 0; i< matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]==elemento) {
					System.out.printf("%d - Found at position (%d,%d)\n",elemento, i, j);
					printLeft(matriz, i, j);
					printRight(matriz, i, j);
					printUp(matriz, i, j);
					printDown(matriz, i, j);
					
				}
			}
		}
	}
	private static void printLeft(int [][]matriz, int i, int j) {
		j-=1;
		if(j>=0) {
			System.out.printf("Left: %d\n",matriz[i][j]);
		}
	}
	private static void printRight(int [][]matriz, int i, int j) {
		j+=1;
		if(j<matriz[i].length) {
			System.out.printf("Right : %d\n",matriz[i][j]);
		}
	}
	private static void printUp(int [][]matriz, int i, int j) {
		i-=1;
		if(i>=0) {
			System.out.printf("Up: %d\n",matriz[i][j]);
		}
	}
	private static void printDown(int [][]matriz, int i, int j) {
		i+=1;
		if(i<matriz.length) {
			System.out.printf("Down : %d\n", matriz[i][j]);
		}
	}

}
