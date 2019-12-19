import java.util.Scanner;

public class TD5Ex3Q1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int nbTest, compteur = 2;
		boolean nbPremier = true;
		System.out.println("Entrez un entier à tester");
		nbTest = saisie.nextInt();
		do {
			if (nbTest % compteur == 0) {
				nbPremier = false;
			} else {
				nbPremier = true;
			}
			compteur++;
		} while ((compteur < nbTest) && nbPremier);

		if (nbPremier) {
			System.out.println("Nombre premier !");
		} else {
			System.out.println("Nombre non premier !");
		}
		saisie.close();
	}
	
}
