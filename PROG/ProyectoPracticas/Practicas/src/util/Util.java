package util;

import java.util.Scanner;

public class Util {
	public static int pedirNumeroEntero(Scanner sc, String mensaje) {
		String numero;
		boolean seguir = false;
		
		do {
			System.out.println(mensaje);
			numero = sc.nextLine();
			if(numero != null && numero.matches("\\d+")) {
				seguir = true;
			} else {
				System.out.println("Entrada inválida, pruebe otra vez");
			}
		} while(!seguir);
		
		return Integer.parseInt(numero);
	}
}
