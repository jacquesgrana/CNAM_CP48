import java.util.Scanner;

public class TD13Ex1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		String chaineSaisie = "";
		Integer entier = 0;
		//Character caractere;
		boolean isStringOk = true;
		System.out.println("Saisir un chaîne de caractères :");
		System.out.println();
		chaineSaisie = saisie.next();
		for (int i=0; i<chaineSaisie.length(); i++) {
			//caractere = ;
			if (Character.isDigit(chaineSaisie.charAt(i))) {
				isStringOk = isStringOk && true;
				entier = entier + (int )(Character.getNumericValue(chaineSaisie.charAt(chaineSaisie.length() - i - 1)) * Math.pow(10, i));
				// calculer entier selon rang
			}
			else {
				isStringOk = isStringOk && false;
			}
		}
		// si isStringOk
			// afficher l'entier
			// sinon afficher erreur
		if (isStringOk) {
			System.out.println("Conversion de " + chaineSaisie + " : " + entier);
			System.out.println();
		}
		else {
			System.out.println("Conversion impossible !");
			System.out.println();
		}
		
		saisie.close();
	}

}
