import java.util.Scanner;

public class TD8Ex2 {

	public static void main(String[] args) {
		
		Scanner saisie = new Scanner (System.in);
		int tauxOccupation, reponseJour, reponsePlage;
		char reponse = ' ';
		boolean quitter = false;
		String [] tabPlageH = {"08-09","09-10","10-11","11-12","14-15","15-16","16-17","17-18","18-19","19-20"}; //,"19-20"
		String [] tabNomJour = {"Lundi   ","Mardi   ","Mercredi","Jeudi   ","Vendredi"};
		boolean[][] occupee ={
				{false,true,true,true,false,true,true,false,true,false},
				{false,true,true,true,false,true,true,false,true,false},
				{false,false,true,true,false,false,true,false,true,false},
				{true,true,false,true,false,true,true,false,true,true},
				{false,true,false,true,false,true,true,false,false,false}
				};

		do {
			
			System.out.println();
			System.out.println("Menu Principal : ");
			System.out.println();
			
			afficherTableau(occupee,tabPlageH,tabNomJour);
			
			System.out.println();
			System.out.println("Taux d'Occupation (T) - Réserver (R) - Quitter (Q)");
			reponse = saisie.next().charAt(0);
			
			if (reponse == 'R') {
				do {
					System.out.println();
					System.out.println("Saisir le numéro du jour (lundi:1 - ... - vendredi:5)");
					reponseJour = saisie.nextInt();	
				}
				while ((reponseJour>5)||(reponseJour<1));
				do {
					System.out.println();
					System.out.println("Saisir le numéro de la plage horaire (08-09:1 - ... - 19-20:10)");
					reponsePlage = saisie.nextInt();	
				}
				while ((reponsePlage>10)||(reponsePlage<1));
				
				if (!occupee[reponseJour-1][reponsePlage-1]) {
					occupee[reponseJour-1][reponsePlage-1] = true;
					System.out.println();
					System.out.println("Mise à jour du planning");
				}
				else {
					System.out.println();
					System.out.println("Déja occupée, veuillez recommencer");
				}
				
			}
			
			if (reponse == 'T') {
				tauxOccupation = calculTauxOccup(occupee);
				System.out.println();
				System.out.println("Taux d'occupation : " + tauxOccupation + " %");
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

	private static int calculTauxOccup(boolean[][] occupee) { // calcule et retourne le taux d'occupation en pourcent
		int sommeOccup = 0;
		double tauxDouble;
		for (int i=0;i<5;i++) {	
			for (int j=0;j<10;j++) {
				if (occupee[i][j]) {
					sommeOccup++;
					//System.out.print("*");
				}
			}
			//ystem.out.println();
		}
		tauxDouble = (double) sommeOccup / 50;
		tauxDouble =  tauxDouble * 100;
		return (int)tauxDouble;
	}

	private static void afficherTableau(boolean[][] occupee, String[] tabPlageH, String[] tabNomJour) { // affiche l'occupation
		System.out.print("Plages horaires : |"); // faire boucle - ,"19-20|"
		
		for (int i=0;i<10;i++) {
			System.out.print(tabPlageH[i] + "|");
		}
		System.out.println();
		for (int i=0;i<5;i++) {
			
			System.out.print(tabNomJour[i]+"        : |");
			for (int j=0;j<10;j++) {
				if (occupee[i][j]) {
					System.out.print(" OQP |");
				}
				else {
					System.out.print(" LIB |");
				}
				//System.out.print(tabPlageH[i] + "|");
			}
			System.out.println();
		}
		
		
		
	}

}
