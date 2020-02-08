import java.util.Scanner;

public class TD13Ex4Q1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		String chainePasCodee = "", chaineCodee = "", chaineDecodee = "";

		System.out.println("Saisir une chaîne à encoder :");
		System.out.println();
		chainePasCodee = saisie.nextLine().toLowerCase();
		System.out.println("Chaîne à coder :" + chainePasCodee);
		System.out.println();
		chaineCodee = encodeChaine(chainePasCodee,3);
		System.out.println("Résultat de l'encodage :" + chaineCodee);
		System.out.println();
		chaineDecodee = decodeChaine(chaineCodee,3);
		System.out.println("Résultat du décodage :" + chaineDecodee);
		System.out.println();
		
		saisie.close();
	}


	private static String decodeChaine(String chaineCodee, int decalage) {
		String resultatDecodage = "";
		int asciiValue, newAsciiValue;
		for (int i=0; i<chaineCodee.length(); i++) {
			asciiValue = (int) chaineCodee.charAt(i);
			if (asciiValue >= 97 && asciiValue <= 122) {
				newAsciiValue = asciiValue - decalage;
				if (newAsciiValue < 97) {
					newAsciiValue += 26;
				}
				resultatDecodage += (char) newAsciiValue;
			}
			else {
				resultatDecodage += chaineCodee.charAt(i);
			}
		}
		
		return resultatDecodage;
	}


	private static String encodeChaine(String chainePasCodee, int decalage) {
		String resultatEncodage = "";
		int asciiValue, newAsciiValue;
		for (int i=0; i<chainePasCodee.length(); i++) {
			asciiValue = (int) chainePasCodee.charAt(i);
			if (asciiValue >= 97 && asciiValue <= 122) {
				newAsciiValue = asciiValue + decalage;
				if (newAsciiValue > 122) {
					newAsciiValue -= 26;
				}
				resultatEncodage += (char) newAsciiValue;
			}
			else {
				resultatEncodage += chainePasCodee.charAt(i);
			}
		}
		
		return resultatEncodage;
	}


}
