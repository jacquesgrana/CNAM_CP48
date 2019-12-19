import java.util.Scanner;

public class TD9Ex4Q3 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char choixSaisie;
		boolean isTab1Empty = true, isTab2Empty = true, quitter = false;
		int nombreElement = 4; // taille des tableaux
		char[] tab1Char = new char[nombreElement];
		char[] tab2Char = new char[nombreElement];
		
		do {
			System.out.println();
			System.out.println("Menu Principal");
			System.out.println();
			
			if (isTab1Empty) {
				System.out.println("Tableau 1 vide");
				System.out.println();
			}
			else {
				afficheTableau(tab1Char);
			}
			
			if (isTab2Empty) {
				System.out.println("Tableau 2 vide");
				System.out.println();
			}
			else {
				afficheTableau(tab2Char);
			}
			
			System.out.print("Quitter (Q) - Remplir Tableau 1 (R) - Remplir Tableau 2 (E)");
			if (!isTab1Empty && !isTab2Empty) {
				System.out.print(" - Tester tableaux (T)");
			}
			System.out.println();
			choixSaisie = saisie.next().charAt(0);
			
			
			if (choixSaisie == 'R') {
				System.out.println("Saisie du tableau 1");
				System.out.println();
				remplirTableau(tab1Char);
				isTab1Empty = false;	
			}
			
			if (choixSaisie == 'E') {
				System.out.println("Saisie du tableau 2");
				System.out.println();
				remplirTableau(tab2Char);
				isTab2Empty = false;	
			}
			
			if ((choixSaisie == 'T') && !isTab1Empty && !isTab2Empty) { // si les tableaux ne sont pas vides
				System.out.println("Comparaison des deux tableaux");
				System.out.println();
				boolean isTabEqual = compareDeuxTableau(tab1Char,tab2Char);
				if (isTabEqual) {
					System.out.println("Au moins un élément en commun");
					System.out.println();
				}
				else {
					System.out.println("Pas d'élément(s) en commun");
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
	
	private static boolean compareDeuxTableau(char[] itab1Char, char[] itab2Char) { // faux si aucun caractere en commun
		boolean iresultat = false;
		for (int i=0; i<itab1Char.length; i++) { 
			for (int j=0; j<itab2Char.length; j++) {
				if (itab1Char[i] == itab2Char[j]) {
					iresultat = true;
					return iresultat;    // sortie de la boucle dès qu'un caractere est en commun
				}
			}
		}
		return iresultat;
	}
}
