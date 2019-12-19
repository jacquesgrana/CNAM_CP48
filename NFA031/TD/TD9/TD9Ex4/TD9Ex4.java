import java.util.Scanner;

public class TD9Ex4 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char choixSaisie, caractere = ' ';
		boolean isTabEmpty = true, isCharEmpty = true, quitter = false;
		int nombreElement = 10; // taille du tableau
		char[] tabChar = new char[nombreElement];
		
		
		do {
			System.out.println();
			System.out.println("Menu Principal");
			System.out.println();
			
			if (isTabEmpty) {
				System.out.println("Tableau vide");
				System.out.println();
			}
			else {
				afficheTableau(tabChar);
			}
			
			if (isCharEmpty) {
				System.out.println("Pas de caractere choisi");
				System.out.println();
			}
			else {
				System.out.println("Caractere choisi : " + caractere);
				System.out.println();
			}
			
			System.out.println("Quitter (Q) - Saisir caractère (S) - Remplir Tableau (R)");
			if (!isCharEmpty && !isTabEmpty) {
				System.out.println("Comparer caractère (C) - Compter caractère (P)");
			}
			
			choixSaisie = saisie.next().charAt(0);
			
			if (choixSaisie == 'S') {
				System.out.println("Saisie du caractère à tester");
				System.out.println();
				caractere = saisirCaractere();
				isCharEmpty = false;
			}
			
			if (choixSaisie == 'R') {
				System.out.println("Saisie du tableau");
				System.out.println();
				remplirTableau(tabChar);
				isTabEmpty = false;	
			}
			
			if ((choixSaisie == 'C') && !isCharEmpty && !isTabEmpty) { // si le tableau n'est pas vide et un caractere a été  choisi
				System.out.println("Comparaison de '" + caractere + "' avec le tableau");
				System.out.println();
				String resultatToPrint = compareTableau(tabChar,caractere);
				System.out.println(resultatToPrint);
				System.out.println();
			}
			
			if ((choixSaisie == 'P') && !isCharEmpty && !isTabEmpty) { // si le tableau n'est pas vide et un caractere a été choisi
				System.out.println("Comptage de '" + caractere + "' avec le tableau");
				System.out.println();
				int nbCaractere = compterCaractereTableau(tabChar,caractere);
				
				if(nbCaractere == 0) {
					System.out.println("il n'y a pas de '" + caractere + "' dans le tableau");
					System.out.println();
				}
				else {
					System.out.println("il y a " + nbCaractere + " fois '" + caractere + "' dans le tableau");
					System.out.println();
				}
			}
			
			if (choixSaisie == 'Q') {
				quitter = true;
			}
		}
		while(!quitter);
		System.out.println("Programme terminé");
		saisie.close();
	}

	private static char saisirCaractere() {
		char icaractere;
		String chaine = "";
		Scanner saisie = new Scanner(System.in);
		do {
			System.out.println("Saisir un caractère : ");
			System.out.println();
			chaine = saisie.next().charAt(0)+"";
		}
		while (!chaine.matches("[A-Za-z]"));
		icaractere = chaine.charAt(0);
		//saisie.close(); // <-- fait planter !!
		return icaractere;
	}

	private static void remplirTableau(char[] itabChar) {
		for (int i=0; i<itabChar.length; i++) {
			System.out.println("Caractère n° " + (i+1) + " / " + itabChar.length);
			System.out.println();
			itabChar[i] = saisirCaractere();
		}
		
	}

	private static void afficheTableau(char[] itabChar) {
		System.out.print("| ");
		for (int i=0; i<itabChar.length; i++) {
			System.out.print(itabChar[i] + " | ");
		}
		System.out.println();
		System.out.println();
	}
	
	private static String compareTableau(char[] itabChar, char icaractere) {
		String iresultat = "caractère non présent";
		for (int i=0; i<itabChar.length; i++) { 
			if (itabChar[i] == icaractere) {
				iresultat = "caractère présent";
				return iresultat;
			}
		}
		return iresultat;
	}
	
	private static int compterCaractereTableau(char[] itabChar, char icaractere) {
		int compteur=0;
		for (int i=0; i<itabChar.length; i++) { 
			if (itabChar[i] == icaractere) {
				compteur++;
			}
		}
		return compteur;
	}
}
