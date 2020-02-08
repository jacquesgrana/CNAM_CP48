import java.util.Scanner;

public class TD11Ex3 {

	private static int NB_ELEMENT = 6;

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		boolean isChaine1Vide = true, isChaine2Vide = true;
		String chaine1 = "", chaine2 = "";
		do {
			if (!isChaine1Vide) {
				System.out.println("Chaine 1 : " + chaine1);
				System.out.println();
			}
			if (!isChaine2Vide) {
				System.out.println("Chaine 2 : " + chaine2);
				System.out.println();
			}
			System.out.print("Saisir Chaine 1 (U) / ");
			System.out.print("Saisir Chaine 2 (D) / ");
			if ((!isChaine2Vide) && (!isChaine1Vide)) {
				System.out.print("Comparer les chaines (C) / ");
			}

			System.out.print("Quitter (Q)");
			System.out.println();
			System.out.println();
			reponse = saisirCaractere(saisie,"[CDQU]*");

			if ((reponse == 'C') && (!isChaine2Vide) && (!isChaine1Vide)) {
				if (isChaineEgales(chaine1,chaine2)) {
					System.out.println("Les chaines sont égales");
					System.out.println();
				}
				else {
					System.out.println("Les chaines sont différentes");
					System.out.println();
				}
			}

			if ((reponse == 'U') ) {
				System.out.println("Saisir la chaine 1 :");
				System.out.println();
				chaine1 = saisirChaine(saisie);
				isChaine1Vide = false;
			}

			if ((reponse == 'D') ) {
				System.out.println("Saisir la chaine 2 :");
				System.out.println();
				chaine2 = saisirChaine(saisie);
				isChaine2Vide = false;
			}

		}
		while (reponse != 'Q');
		System.out.println("Programme terminé");
		saisie.close();
	}

	private static boolean isChaineEgales(String iChaine1, String iChaine2) {
		//boolean isEqual = false;
		for (int i=0; i<iChaine1.length(); i++) {
			if (iChaine1.toUpperCase().charAt(i) != iChaine2.toUpperCase().charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static String saisirChaine(Scanner iSaisie) {
		String chaineSaisie = "";
		boolean isLongueurOk = false, isCaractereOk = false;
		do {
			chaineSaisie = iSaisie.next();
			isCaractereOk = chaineSaisie.matches("[A-Za-z]*");
			isLongueurOk = chaineSaisie.length() == NB_ELEMENT;
			if (!isCaractereOk) {
				System.out.println("Saisir uniquement des caractères");
			}
			if (!isLongueurOk) {
				System.out.println("Longueur incorrecte, il faut saisir " + NB_ELEMENT + " caractères");
			}
		}
		while ((!isLongueurOk) || (!isCaractereOk));
		return chaineSaisie;
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
