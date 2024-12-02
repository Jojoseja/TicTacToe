package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Resources {
	static Scanner sc = new Scanner(System.in);

	static void menu() {
		boolean menuB = true;
		do {
			System.out.println("Selecciona una opción");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				menuB = false;
				System.out.println("Bye");
				break;
			default:
				System.out.println("Nada");
			}
		} while (menuB);
	}

	public static void main(String[] args) {
	}
}
