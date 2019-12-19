import java.util.Scanner;

public class TD9Ex5 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char choixSaisie;
		boolean isTab1Empty = true, isTab2Empty = true, isTab3Empty = true, quitter = false;
		int nombreElement = 4; // taille des tableaux
		int[] tab1 = new int[nombreElement];
		int[] tab2 = new int[nombreElement];
		int[] tab3 = new int[nombreElement*2];
		
		do {
			System.out.println();
			System.out.println("Menu Principal");
			System.out.println();
			
			if (isTab1Empty) {
				System.out.println("Tableau 1 vide");
				System.out.println();
			}
			else {
				afficherTableau(tab1);
			}
			
			if (isTab2Empty) {
				System.out.println("Tableau 2 vide");
				System.out.println();
			}
			else {
				afficherTableau(tab2);
			}
			
			if (isTab3Empty) {
				//System.out.println("Tableau de résultat vide");
				//System.out.println();
			}
			else {
				afficherTableau(tab3);
			}
			
			System.out.print("Quitter (Q) - Remplir Tableau 1 (R) - Remplir Tableau 2 (E)"); // ajouter vider tableau de resultat
			if (!isTab1Empty && !isTab2Empty && isTab3Empty) {
				System.out.print(" - Concaténer tableaux (C)");
			}
			if (!isTab3Empty) {
				System.out.print(" - Effacer le tableau de résultat (F)");
			}
			System.out.println();
			choixSaisie = saisie.next().charAt(0);
			
			
			if (choixSaisie == 'R') {
				System.out.println("Saisie du tableau 1");
				System.out.println();
				remplirTableau(tab1);
				isTab1Empty = false;
				isTab3Empty = true;
			}
			
			if (choixSaisie == 'E') {
				System.out.println("Saisie du tableau 2");
				System.out.println();
				remplirTableau(tab2);
				isTab2Empty = false;
				isTab3Empty = true;
			}
			
			if ((choixSaisie == 'C') && !isTab1Empty && !isTab2Empty && isTab3Empty) { 
				System.out.println("Concaténation des deux tableaux");
				System.out.println();
				tab3 = concatenerTab(tab1,tab2);
				isTab3Empty = false;
			}
			
			if ((choixSaisie == 'F') && !isTab1Empty && !isTab2Empty && !isTab3Empty) { 
				System.out.println("Effacement du tableau de résultat");
				System.out.println();
				isTab3Empty = true;
			}
			
			
			if (choixSaisie == 'Q') {
				quitter = true;
			}
		}
		while(!quitter);
		System.out.println("Programme terminé");
		saisie.close();
	}

	private static int saisirEntier() {
		int entier = 0;
		String chaine = "";
		Scanner saisie = new Scanner(System.in);
		do {
			System.out.println("Saisir un entier : ");
			System.out.println();
			chaine = saisie.next();
			//entier = saisie.nextInt();
		}
		while (!chaine.matches("[0-9]*")); // Integer. toString(654321)
		entier = Integer.parseInt(chaine);						// (!entier.matches("[A-Za-z]"))
		//saisie.close(); // <-- fait planter !!
		return entier;
	}

	private static void remplirTableau(int[] itab) {
		for (int i=0; i<itab.length; i++) {
			System.out.println("Elément n° " + (i+1) + " / " + itab.length);
			System.out.println();
			itab[i] = saisirEntier();
		}
		
	}

	private static void afficherTableau(int[] itabChar) {
		System.out.print("| ");
		for (int i=0; i<itabChar.length; i++) {
			System.out.print(itabChar[i] + " | ");
		}
		System.out.println();
		System.out.println();
	}
	
	private static int[] concatenerTab(int[] itab1, int[] itab2) {
		int[] itab3 = new int[itab1.length+itab2.length];
		for (int i=0; i<itab1.length; i++) {
			itab3[i] = itab1[i];
		}
		for (int i=0; i<itab2.length; i++) {
			itab3[itab1.length+i] = itab2[i];
		}
		return itab3;
	}
	
}
