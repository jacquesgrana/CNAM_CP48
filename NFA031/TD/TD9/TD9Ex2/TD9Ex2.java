import java.util.Scanner;

public class TD9Ex2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int nombreSaisi, resultat = 0;
		char reponse;
		System.out.println("Saisissez un entier : ");
		nombreSaisi = saisie.nextInt();
		do {
			System.out.println("Calculer le carré (C) ou le cube (U) de " + nombreSaisi);
			reponse = saisie.next().charAt(0);
		}
		while (reponse != 'C' && reponse != 'U');
		
		if (reponse == 'C') {
			resultat = calculCarre(nombreSaisi);
		}
		
		if (reponse == 'U') {
			resultat = calculCube(nombreSaisi);
		}
		
		System.out.println("Résultat : " + resultat);
		
		System.out.println("Programme terminé");
		saisie.close();
	}

	private static int calculCube(int nombreSaisi) {
		return nombreSaisi * nombreSaisi * nombreSaisi;
	}

	private static int calculCarre(int nombreSaisi) {
		return nombreSaisi * nombreSaisi;
	}

}
