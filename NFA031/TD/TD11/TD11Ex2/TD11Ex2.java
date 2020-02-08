import java.util.Scanner;

public class TD11Ex2 {
	
	public static int NB_ELEMENT = 6;

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		boolean isTableauVide = true, isChaineVide = true;
		char[] tableau = new char[NB_ELEMENT];
		String chaine = "";
		
		do {
			if (!isTableauVide) {
				afficheTableau(tableau);
			}
			if (!isChaineVide) {
				System.out.println("Chaine : " + chaine);
				System.out.println();
			}
			
			System.out.print("Quitter (Q)");
			if (isTableauVide) {
				System.out.print(" / Saisir tableau (T)");
			} 
			if (isChaineVide) {
				System.out.print(" / Saisir chaine (C)");
			}
			if ((!isChaineVide) && (!isTableauVide)) {
				System.out.print(" / Tester égalite (E)");
			}
			System.out.println();
			System.out.println();
			reponse = saisirCaractere(saisie,"[CEQT]*");
			
			if ((reponse == 'E') && (!isTableauVide) && (!isChaineVide)) {
				if (isEqualTableauChaine(tableau,chaine)) {
					System.out.println("Le tableau et la chaine sont identiques !!");
					System.out.println();
				}
				else {
					System.out.println("Le tableau et la chaine sont différents !!");
					System.out.println();
				}
			}
			
			if ((reponse == 'C') && (isChaineVide)) {
				System.out.println("Saisir une chaine de " + NB_ELEMENT + " caractères");
				boolean isLongueurOk = false;
				do {
					chaine = saisirChaine(saisie,"[A-Za-z]*");
					isLongueurOk = chaine.length() == NB_ELEMENT;
					if (!isLongueurOk) {
						System.out.println("Saisie incorrecte ! Il faut dix caractères !");
					}
				}
				while (!isLongueurOk);
				
				isChaineVide = false;
			}
			
			if ((reponse == 'T') && (isTableauVide)) {
				saisirTableau(tableau,saisie);
				isTableauVide = false;
			}
			
		}
		while (reponse != 'Q');
		System.out.println("Programme terminé");
		saisie.close();
	}

	private static boolean isEqualTableauChaine(char[] iTableau, String iChaine) {
		for (int i=0; i<NB_ELEMENT; i++) {
			if (iChaine.charAt(i) != iTableau[i]) {
				return false;
			}
		}
		return true;
	}

	private static String saisirChaine(Scanner iSaisie, String regEx) {
		boolean saisiePasOk;
		String chaine = "";
		do {
			chaine = iSaisie.next().toUpperCase();
			saisiePasOk = !chaine.matches(regEx);
			if (saisiePasOk) {
				System.out.println("Saisie incorrecte !");
			}
		}
		while (saisiePasOk);
		return chaine;
	}

	private static void saisirTableau(char[] iTableau, Scanner saisie) {
		for (int i=0; i<iTableau.length;i++) {
			System.out.println("Saisir élément n°" + (i+1) + " : ");
			iTableau[i] = saisirCaractere(saisie,"[A-Za-z]*");
		}
		
	}

	private static void afficheTableau(char[] iTableau) {
		for (int i=0; i<NB_ELEMENT; i++) {
			System.out.print("+---");
		}
		System.out.println("+");
		//System.out.println("+---+---+---+---+---+---+---+---+---+---+");
		System.out.print("| ");
		for (int i=0; i<iTableau.length;i++) {
			System.out.print(iTableau[i] + " | ");
		}
		System.out.println();
		for (int i=0; i<NB_ELEMENT; i++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}

	// fonction qui renvoie un caractère mis en majuscule compris dans regEx
		private static char saisirCaractere(Scanner iSaisie, String regEx) {
			char caractere;
			boolean saisiePasOk;
			String chaine = "";
			do {
				chaine = iSaisie.next().toUpperCase();
				saisiePasOk = !chaine.matches(regEx);
				if (saisiePasOk) {
					System.out.println("Saisie incorrecte !");
				}
			}
			while (saisiePasOk);
			caractere = chaine.charAt(0);
			return caractere;
		}

}
