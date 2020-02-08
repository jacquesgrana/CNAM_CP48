import java.util.Scanner;

public class TD13Ex3Q2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		String chaineAConvertir = "";
		int resultatConversion;
		
		System.out.println("Saisir un nombre en plusieurs chiffres à convertir (CDILMVX) : ");
		chaineAConvertir = saisirChaine(saisie, "[CDILMVX]*");
		System.out.println("Nombre en chiffres romains à convertir : " + chaineAConvertir);
		System.out.println();
		resultatConversion = calculConsersionChaine(chaineAConvertir);
		System.out.println("Résultat : " + resultatConversion);
		System.out.println();
		saisie.close();

	}
	
	
	private static int calculConsersionChaine(String chaine) {
		int resultat = 0;
		for (int i = chaine.length() -1; i>=0; i--) {
			
			// si i = chaine.length() -1
				// ajouter valeur caractere a resultat
			// sinon
				// si valeur(i) < valeur(i+1)
					// // soustraire valeur caractere a resultat
				// sinon ajouter valeur caractere a resultat
			
			if (i == chaine.length() -1) {
				resultat += calculConversion(chaine.charAt(i));
			}
			else {
				if (calculConversion(chaine.charAt(i)) < calculConversion(chaine.charAt(i+1))) {
					resultat -= calculConversion(chaine.charAt(i));
				}
				else {
					resultat += calculConversion(chaine.charAt(i));
				}
				
			}
		}
		return resultat;
	}


	private static int calculConversion(char chiffreRomain) {
		int resultat = 0;
		switch (chiffreRomain) {
		case 'C' :
			resultat = 100;
			break;
		case 'D' :
			resultat = 500;
			break;
		case 'I' :
			resultat = 1;
			break;
		case 'L' :
			resultat = 50;
			break;
		case 'M' :
			resultat = 1000;
			break;
		case 'V' :
			resultat = 5;
			break;
		case 'X' :
			resultat = 10;
			break;
		}
		return resultat;
	}


		// fonction qui renvoie une chaine mise en majuscule compris dans regEx
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

}
