import java.util.Scanner;

public class TD9Ex3 {
	
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int longueurTab1, longueurTab2, nbSaisi;
		System.out.println("Test d'égalité de deux tableaux");
		System.out.println();
		do {
			System.out.println("Saisir la taille du premier tableau (0-20) : ");
			longueurTab1 = saisie.nextInt();
		}
		while (longueurTab1 <= 0 || longueurTab1 > 20);
		int[] tableau1 = new int[longueurTab1];
		for (int i = 0; i < longueurTab1; i++) {
			do {
				System.out.println("Saisir l'élément " + (i+1) + " du tableau 1 : ");
				nbSaisi = saisie.nextInt();
			}
			while (nbSaisi < 0 || nbSaisi > 99);
			tableau1[i]= nbSaisi;
		}
		
		do {
			System.out.println("Saisir la taille du second tableau (0-20) : ");
			longueurTab2 = saisie.nextInt();
		}
		while (longueurTab2 <= 0 || longueurTab2 > 20);
		int[] tableau2 = new int[longueurTab2];
		for (int i = 0; i < longueurTab2; i++) {
			do {
				System.out.println("Saisir l'élément " + (i+1) + " du tableau 2 : ");
				nbSaisi = saisie.nextInt();
			}
			while (nbSaisi < 0 || nbSaisi > 99);
			tableau2[i]= nbSaisi;
		}
		System.out.println();
		System.out.println("Tableau 1 :");
		afficheTableau(tableau1);
		System.out.println();
		System.out.println("Tableau 2 :");
		afficheTableau(tableau2);
		
		if(longueurTab1 == longueurTab2) {
			if (estEgal(tableau1,tableau2) == true) {
				System.out.println();
				System.out.println("Tableaux égaux");
			}
			else {
				System.out.println();
				System.out.println("Tableaux inégaux");
			}
		}
		
		else {
			System.out.println();
			System.out.println("Tableaux de tailles différentes");
		}
		
		
		
		
		System.out.println("Programme terminé");
		saisie.close();
	}

	private static boolean estEgal(int[] tableau1, int[] tableau2) {
		for (int i=0; i<tableau1.length; i++) {
			if (tableau1[i] != tableau2[i]) {
				return false;
			}
		}
		return true;
	}

	private static void afficheTableau(int[] tableau) {
		int limite = tableau.length;
		System.out.print("| ");
		for (int i=0; i<limite; i++) {
			System.out.print(tableau[i] + " | ");
		}
		System.out.println();
	}
	

}
