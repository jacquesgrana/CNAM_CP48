import java.util.Scanner;

public class TD13Ex3 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char caractereAConvertir = ' ';
		int resultatConversion;
		
		System.out.println("Saisir un nombre en chiffre à convertir (CDILMVX) : ");
		caractereAConvertir = saisirCaractere(saisie, "[CDILMVX]*");
		System.out.println("Nombre en chiffres romains à convertir : " + caractereAConvertir);
		System.out.println();
		resultatConversion = calculConversion(caractereAConvertir);
		System.out.println("Résultat : " + resultatConversion);
		saisie.close();

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


		// fonction qui renvoie un caractère mis en majuscule compris dans regEx
		private static char saisirCaractere(Scanner iSaisie, String regEx) {
			boolean saisiePasOk;
			String chaine = "";
			char caractere;
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


