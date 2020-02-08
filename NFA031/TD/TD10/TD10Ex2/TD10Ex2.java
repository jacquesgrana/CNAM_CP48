import java.util.Scanner;

public class TD10Ex2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		String intention = "";
		char reponse = ' ',reponseIntention = ' ';
		int nbFemme, nbIntention = 0;
		boolean tableauVide = true;
		int[][] tabIntention = new int[2][3];
		/*
		System.out.println(" longueur 1 : " + tabIntention.length);
		System.out.println();
		System.out.println(" longueur 2 : " + tabIntention[0].length);
		System.out.println();
		*/
		do {
			if (!tableauVide) {
				afficheTableau(tabIntention);
			}
			
			System.out.print("Quitter (Q)");
			if (tableauVide) {
				System.out.print(" - Saisir Tableau (S)");
			}
			else {
				System.out.println(" - Calculer nb Femmes (F) - Calculer Intentions (I)");
				System.out.print("Prédir résultat (P) - Calculer la répartition h/f (R)");
			}
			System.out.println();
			System.out.println();
			reponse = saisie.next().toUpperCase().charAt(0);
			
			if ((reponse == 'R') && (!tableauVide)){
				afficheRepartion(tabIntention);
			}
			
			if ((reponse == 'P') && (!tableauVide)){
				predirResultat(tabIntention);
			}
			
			
			if ((reponse == 'I') && (!tableauVide)) {
				System.out.println("Calcul de intention de Oui (O) - Non (N) - Abstention (A)");
				System.out.println();
				reponseIntention = saisirCaractere(saisie);
				switch (reponseIntention) {
				case 'O':
					nbIntention = calculeIntention(tabIntention,0);
					intention = "du Oui";
					break;
				case 'N':
					nbIntention = calculeIntention(tabIntention,1);
					intention = "du Non";
					break;
				case 'A':
					nbIntention = calculeIntention(tabIntention,2);
					intention = "de l'Abstention";
					break;
				}
				System.out.println("Nombre d'intention " + intention + " : " + nbIntention);
				System.out.println();
			}
			
			if ((reponse == 'F') && (!tableauVide)){
				nbFemme = calculNbParSexe(tabIntention,1);
				System.out.println("Nombre de Femmes : " + nbFemme);
				System.out.println();
			}
			
			if ((reponse == 'S') && (tableauVide)) {
				saisirTableau(tabIntention,saisie);
				tableauVide = false;
			}
			
		}
		while (reponse != 'Q');
		saisie.close();
		System.out.println("Programme Terminé");
	}

	private static void afficheRepartion(int[][] iTabIntention) {
		int nombreHomme = calculNbParSexe(iTabIntention,0);
		int nombreFemme = calculNbParSexe(iTabIntention,1);
		int nombreTotal = nombreHomme + nombreFemme;
		double pourCentHomme = (double)(nombreHomme*100/nombreTotal);
		double pourCentFemme = (double)(nombreFemme*100/nombreTotal);
		if (nombreHomme == nombreFemme) {
			System.out.println("Il y a autant de femmes que d'hommes");
			System.out.println();
		}
		else {
			System.out.println("Il y a un écart de " + (pourCentFemme - pourCentHomme) + "% entre les femmes et les hommes");
			System.out.println();	
		}
	}

	private static void predirResultat(int[][] iTabIntention) {
		int nombrePour = 0, nombreContre = 0, nombreTotal = 0;
		double pourCentPour, pourCentContre;
		nombrePour = calculeIntention(iTabIntention,0);
		nombreContre = calculeIntention(iTabIntention,1);
		nombreTotal = nombrePour + nombreContre;
		pourCentPour = (double)(nombrePour*100/nombreTotal);
		pourCentContre = (double)(nombreContre*100/nombreTotal);
		
		if (nombrePour == nombreContre) {
			System.out.println("Egalité !!");
			System.out.println();
		}
		else {
			if (nombrePour > nombreContre) {
				
				System.out.println("Le référedum sera approuvé à " + pourCentPour + "% pour / " + pourCentContre + "% contre");
				System.out.println();
			}
			else {
				System.out.println("Le référedum sera rejeté à " + pourCentContre + "% contre / " + pourCentPour + "% pour");
				System.out.println();
			}
		}
	}

	private static int calculeIntention(int[][] iTabIntention, int numeroIntention) {
		int nombreIntention = 0;
		for (int i=0; i<iTabIntention.length; i++) {
			nombreIntention = nombreIntention + iTabIntention[i][numeroIntention];
		}
		return nombreIntention;
	}

	private static char saisirCaractere(Scanner saisie) {
		char iReponse = saisie.next().toUpperCase().charAt(0);
		return iReponse;
	}

	private static int calculNbParSexe(int[][] iTabIntention, int sexe) {
		int iNbFemme = 0;
		for (int i=0; i<iTabIntention[0].length; i++) {
			iNbFemme = iNbFemme + iTabIntention[sexe][i];
		}
		return iNbFemme;
	}

	private static void afficheTableau(int[][] iTabIntention) {
		//System.out.println();
		System.out.println("          oui  non  abs");
		System.out.println("**************************");
		for (int i=0; i<iTabIntention.length; i++) {
			System.out.print("| ");
			if (i == 0) {
				System.out.print("Hommes | ");
			}
			else {
				System.out.print("Femmes | ");
			}
			for (int j=0; j<iTabIntention[0].length; j++) {
				System.out.print(iTabIntention[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println("**************************");
		System.out.println();
	}

	private static void saisirTableau(int[][] iTabIntention, Scanner saisie) {
		System.out.println("Saisie du tableau");
		System.out.println();
		for (int i=0; i<iTabIntention.length; i++) {
			for (int j=0; j<iTabIntention[0].length; j++) {
				System.out.println("Saisie de la ligne : " + i + " - case : " + j);
				System.out.println();
				iTabIntention[i][j] = saisie.nextInt();
			}
		}
		
	}

}
