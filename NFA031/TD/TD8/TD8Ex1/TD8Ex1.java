import java.util.Scanner;

public class TD8Ex1 {

	public static void main(String[] args) {
		
		String [] tabNomVendeur = {"André      ","Ingemar    ","Jean-Jérôme","Cindy      ","Joey       "};
		String [] tabNomVoiture = {"Twingo","Clio","Mégane","Vel Satis"};
		int [] tabPrix = {5000,7500,12000,16000};
		int [][] tableauVente = new int [4][5];
		boolean quitter = false;
		boolean tableauVide = true;
		char reponse = ' ';
		Scanner saisie = new Scanner (System.in);
		do {
			System.out.println("Menu Principal : ");
			System.out.println();
			
			if(!tableauVide) {
				afficherTableau(tableauVente,tabNomVendeur,tabNomVoiture);
			}
			else {
				System.out.println("Tableau vide, veuillez le remplir");
				System.out.println();
			}
			
			//System.out.println();
			System.out.print("Remplir tableau (R) - ");
			if(!tableauVide) {
				System.out.print("Ventes par exemplaire (V) - ");
				System.out.print("Chiffre d'affaire par vendeur (C) - ");
			}
			
			System.out.print("Quitter (Q)");
			reponse = saisie.next().charAt(0);
			
			
			
			
			if (reponse =='R') {
				remplirTableau(tableauVente,tabNomVendeur,tabNomVoiture);
				tableauVide=false;
			}
			
			if ((reponse =='V') && (tableauVide == false)) {
				calculVente(tableauVente,tabNomVoiture);
				
			}
			
			if ((reponse =='C') && (tableauVide == false)) {
				calculChiffreAffaire(tableauVente,tabNomVendeur,tabPrix);
				
			}
		
			
			if (reponse == 'Q') {
				quitter = true;
			}
		}
		while (!quitter);
		saisie.close();
		System.out.println();
		System.out.println("Fin du programme");
	}

	
	
	private static void calculChiffreAffaire(int[][] vente, String[] nomVendeur, int[] prix) {
		System.out.println();
		System.out.println("Calcul du chiffre d'affaire par vendeur : ");
		System.out.println();
		for (int j=0; j<vente[0].length; j++) {
			int somme = 0;
			for (int i=0; i<vente.length; i++) {
				somme += vente[i][j]*prix[i];	
			}
			System.out.println("Chiffre d'affaire de " + nomVendeur[j] + " : " + somme);
		}
		System.out.println();
	}



	private static void calculVente(int[][] vente, String[] nomVoiture) {
		System.out.println();
		System.out.println("Calcul du nombre de ventes par modèle : ");
		System.out.println();
		for (int i=0; i<vente.length; i++) {
			int sommeVente = 0;
			for (int j=0; j<vente[0].length; j++) {
				sommeVente += vente[i][j];
			}
			System.out.println("Nombre de vente de " + nomVoiture[i] + " : " + sommeVente);	
		}
		System.out.println();
	}



	private static void remplirTableau(int [][] vente, String [] nomVendeur, String [] nomVoiture) {
		int reponse;
		Scanner saisie = new Scanner (System.in);
		System.out.println();
		System.out.println("Remplissage du tableau des ventes : ");
		System.out.println();
		for (int j=0; j<vente[0].length; j++) {
			
			for (int i=0; i<vente.length; i++) {
				System.out.println("Saisir le nombre de vente de " + nomVoiture[i] + " par " + nomVendeur[j] + " : ");
				reponse = saisie.nextInt();
				vente[i][j] = reponse;
				//System.out.print("i,j " + i + "," + j + "  ");	
			}
			System.out.println();
		}
		//saisie.close();
	}
	
	private static void afficherTableau(int [][] vente, String [] nomVendeur, String [] nomVoiture) {
		System.out.println("Affichage du tableau des ventes : ");
		System.out.println();
		for (int j=0; j<vente[0].length; j++) {
			System.out.print(nomVendeur[j] + " : ");
			for (int i=0; i<vente.length; i++) {
				System.out.print(" : " + vente[i][j] + " : ");
					
			}
			System.out.println();
		}
		System.out.println();
	}


}
