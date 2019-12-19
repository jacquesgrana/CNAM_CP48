import java.util.Scanner;

public class TD5Ex3Q2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int compteurDeBoucle = 3, compteurDeNombrePremier = 1, nbMax = 100;
		System.out.println("Entrez le nombre de nombres premiers à trouver");
		nbMax = saisie.nextInt();	
		while (compteurDeNombrePremier <= nbMax) {		
			if(checkIsPremier(compteurDeBoucle)) {
				System.out.println("N° : " + compteurDeNombrePremier + " qui est premier : " + compteurDeBoucle);
				compteurDeNombrePremier ++;
			}	
			compteurDeBoucle ++;
		}
		saisie.close();
	}
	
	public static boolean checkIsPremier (int nbToTest) {
		boolean isPremier = true;
		int compteur = 2;	
		do {
			if (nbToTest % compteur == 0) {
				isPremier = false;
			} else {
				isPremier = true;
			}
			compteur++;
		} while ((compteur < nbToTest) && isPremier); // on sort de la boucle des que nbToTest est divisible par compteur ou des que compteur est = à nbToTest
		return isPremier;
	}

}
