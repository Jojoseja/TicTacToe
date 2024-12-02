package tictactoe;

import java.util.Scanner;
import java.util.Arrays;
//Si una vez iniciado el juego se introduce: 1X, 2O, 3X, 50, el número {4} deja de estar disponible

public class Main {

	static Scanner sc = new Scanner(System.in);

	// Metodo para iniciar un menu
	static void menuOpciones() {
		boolean menuAbierto = true;
		do {
			System.out.println("Opcion 1 tictactoe, opcion 2 cerrar");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				tictactoe();
				break;
			case 2:
				menuAbierto = false;

			}
		} while (menuAbierto);
	}

	// Metodo para mostrar por pantalla el estado actual de la partida
	static void showScreen(String[][] gamelist) {

		System.out.println("| " + gamelist[0][0] + " | " + gamelist[0][1] + " | " + gamelist[0][2] + " |");
		System.out.println("------------");
		System.out.println("| " + gamelist[1][0] + " | " + gamelist[1][1] + " | " + gamelist[1][2] + " |");
		System.out.println("------------");
		System.out.println("| " + gamelist[2][0] + " | " + gamelist[2][1] + " | " + gamelist[2][2] + " |");

	}

	// Metodo para generar un tablero "Vacio"
	static String[][] createGame() {

		String[][] a = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		return a;

	}

	// Metodo para comprobar que el numero que se escoja no haya sido escogido
	// previamente
	static boolean checkValid(int input, String[][] gameStatus) {
		boolean result = true;
		switch (input) {
		case 1:
			if (gameStatus[0][0] == "X" || gameStatus[0][0] == "O") {
				result = false;
			}
			break;
		case 2:
			if (gameStatus[0][1] == "X" || gameStatus[0][1] == "O") {
				result = false;
			}
			break;
		case 3:
			if (gameStatus[0][2] == "X" || gameStatus[0][2] == "O") {
				result = false;
			}
			break;
		case 4:
			if (gameStatus[1][0] == "X" || gameStatus[1][0] == "O") {
				result = false;
			}
			break;
		case 5:
			if (gameStatus[1][1] == "X" || gameStatus[1][1] == "O") {
				result = false;
			}
			break;
		case 6:
			if (gameStatus[1][2] == "X" || gameStatus[1][2] == "O") {
				result = false;
			}
			break;
		case 7:
			if (gameStatus[2][0] == "X" || gameStatus[2][0] == "O") {
				result = false;
			}
			break;
		case 8:
			if (gameStatus[2][1] == "X" || gameStatus[2][1] == "O") {
				result = false;
			}
			break;
		case 9:
			if (gameStatus[2][2] == "X" || gameStatus[2][2] == "O") {
				result = false;
			}
			break;
		default:
			System.out.println("Numero incorrecto");
			result = false;
		}
		return result;
	}

	// Metodo que devuelve el valor de un numero en caso de que DICHO NUMERO este
	// disponible
	static int validInput(String[][] gameStatus) {
		boolean validNumber = false;
		int input;
		do {
			System.out.println("Escribe un numero");
			input = sc.nextInt();
			validNumber = checkValid(input, gameStatus);

		} while (!validNumber);
		return input;
	}

	// Metodo para comprobar si alguien ha ganado en HORIZONTAL
	static boolean checkLane(String[][] gameStatus) {
		boolean result = false;
		String[] valid1 = { "X", "X", "X" };
		String[] valid2 = { "O", "O", "O" };
		String[][] gameSta1 = gameStatus;
		for (String[] i : gameSta1) {
			if (Arrays.equals(i, valid1) || Arrays.equals(i, valid2)) {
				result = true;
			}
		}
		return result;
	}

	// Metodo para comprobar si alguien ha ganado en DIAGONAL
	static boolean checkDia(String[][] gameStatus) {
		boolean winner = false;
		String[] valid1 = { "X", "X", "X" };
		String[] valid2 = { "O", "O", "O" };

		String[] dia1 = new String[3];
		dia1[0] = gameStatus[0][0];
		dia1[1] = gameStatus[1][1];
		dia1[2] = gameStatus[2][2];

		String[] dia2 = new String[3];
		dia2[0] = gameStatus[0][2];
		dia2[1] = gameStatus[1][1];
		dia2[2] = gameStatus[2][0];
		if (Arrays.equals(dia1, valid1) || Arrays.equals(dia2, valid1) || Arrays.equals(dia1, valid2)
				|| Arrays.equals(dia2, valid2)) {
			winner = true;
		}
		return winner;
	}

	// Metodo para invertir el Array, de forma que los VERTICALES pasan a ser
	// HORIZONTALES
	static String[][] invArray(String[][] gameStatus) {
		String[][] invertedArray = new String[3][3];
		for (int i = 0; i < gameStatus.length; i++) {
			for (int j = 0; j < gameStatus.length; j++) {
				invertedArray[i][j] = gameStatus[j][i];
			}
		}
		return invertedArray;
	}

	// Metodo para comprobar si alguien ha ganado en HORIZONTAL, VERTICAL o en
	// DIAGONAL
	static boolean checkWin(String[][] gameStatus) {
		boolean winner = false;
		String[][] invArray = invArray(gameStatus);
		if (checkLane(gameStatus) || checkLane(invArray) || checkDia(gameStatus)) {
			winner = true;
			;
		}
		return winner;
	}

	// Metodo para el juego como tal
	static void tictactoe() {
		String[][] gameStatus = createGame();
		showScreen(gameStatus);
		boolean turnX = true;
		boolean gameOver = false;
		String turnInput;
		int turn = 0;
		boolean game = true;
		do {
			if (turnX) {
				System.out.println("Turno Jugador X");
				turnInput = "X";
				turnX = false;
			} else {
				System.out.println("Turno Jugador O");
				turnInput = "O";
				turnX = true;
			}
			int input = validInput(gameStatus);
			switch (input) {
			case 1:
				gameStatus[0][0] = turnInput;
				break;
			case 2:
				gameStatus[0][1] = turnInput;
				break;
			case 3:
				gameStatus[0][2] = turnInput;
				break;
			case 4:
				gameStatus[1][0] = turnInput;
				break;
			case 5:
				gameStatus[1][1] = turnInput;
				break;
			case 6:
				gameStatus[1][2] = turnInput;
				break;
			case 7:
				gameStatus[2][0] = turnInput;
				break;
			case 8:
				gameStatus[2][1] = turnInput;
				break;
			case 9:
				gameStatus[2][2] = turnInput;
				break;
			default:
				break;

			}
			showScreen(gameStatus);
			turn += 1;
			if (checkWin(gameStatus)) {
				System.out.println("Hay ganador!");
				gameOver = true;
			} else if (turn >= 9) {
				System.out.println("Empate!");
				gameOver = true;
			}
		} while (!gameOver);
	}

	public static void main(String[] args) {
		menuOpciones();

	}

}
