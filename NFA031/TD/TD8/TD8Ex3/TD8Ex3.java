import java.util.Scanner;

public class TD8Ex3 {

	public static void main(String[] args) {

		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		boolean quitter = false, imageVide = true;
		int nombreColonne = 20, nombreLigne = 20, niveauGris, nombrePixelBlanc = 0; // largeur = nombreColonne - hauteur = nombreLigne
		double ratioPixelBlanc;
		int[][] tabImage = new int[nombreLigne][nombreColonne];

		do {
			System.out.println();
			System.out.println("Menu Principal : ");

			if (!imageVide) {
				afficherImage(tabImage, nombreLigne, nombreColonne);
			} else {
				System.out.println();
				System.out.println("Image vide, veuillez la remplir");
			}

			System.out.println();
			
			if (imageVide) {
				System.out.print("Remplir (R)");
			}
			else {
				System.out.print("Pixel blanc (B) - Eclaircir (E) ");
			}
			
			System.out.println(" - Quitter (Q)");
			reponse = saisie.next().charAt(0);

			if ((reponse == 'R')&&(imageVide)) {
				System.out.println();
				System.out.println("Remplissage de l'image");
				
				do {
					System.out.println();
					System.out.println("Saisir la largeur de l'image, (1-20)");
					nombreColonne = saisie.nextInt();	
				}
				while ((nombreColonne>20)||(nombreColonne<1));
				
				do {
					System.out.println();
					System.out.println("Saisir la hauteur de l'image, (1-20)");
					nombreLigne = saisie.nextInt();	
				}
				while ((nombreLigne>20)||(nombreLigne<1));
				
				System.out.println();
				System.out.println("Saisie des ng d'une image de largeur " + nombreColonne + " et de hauteur " + nombreLigne);
				for (int i=0;i<nombreLigne;i++) {
					System.out.println();
					System.out.println("Ligne : " + i);
					for (int j=0;j<nombreColonne;j++) {
						//System.out.println();
						System.out.println("Colonne : " + j);
						
						do {
							System.out.println();
							System.out.println("Saisir une valeur (0-255)");
							niveauGris = saisie.nextInt();	
						}
						while ((niveauGris>255)||(niveauGris<0));
						tabImage[i][j] = niveauGris;
					}
					//System.out.println();
				}
				imageVide = false;
				
			}

			if ((reponse == 'B')&&(!imageVide)) {
				nombrePixelBlanc = 0;
				System.out.println();
				System.out.println("Calculs sur les pixels blancs");
				
				for (int i=0;i<nombreLigne;i++) {	
					for (int j=0;j<nombreColonne;j++) {
						if (tabImage[i][j] == 255) {
							nombrePixelBlanc++;
							//System.out.print("*");
						}	
					}
					//System.out.println();
				}
				
				ratioPixelBlanc = (double) nombrePixelBlanc / (nombreLigne*nombreColonne);
				ratioPixelBlanc =  ratioPixelBlanc * 100;
				
				System.out.println();
				System.out.println("Nombre de pixel blanc : " + nombrePixelBlanc + " sur " + nombreLigne*nombreColonne + " pixels ,soit " + (int) ratioPixelBlanc + " %");
			}
			
			
			if ((reponse == 'E')&&(!imageVide)) {
				System.out.println();
				System.out.println("Eclaircissement de l'image");
				
				for (int i=0;i<nombreLigne;i++) {	
					for (int j=0;j<nombreColonne;j++) {
						tabImage[i][j] = tabImage[i][j] + 30;
						if (tabImage[i][j] > 255) {
							tabImage[i][j] = 255;
							//System.out.print("*");
						}	
					}
					//System.out.println();
				}
				
			}
			
			if (reponse == 'Q') {
				quitter = true;
			}
			
		} while (!quitter);
		saisie.close();
		System.out.println();
		System.out.println("Programme Terminé");
	}

	private static void afficherImage(int[][] tabImage, int nombreLigne, int nombreColonne) {
		System.out.println();
		for (int i = nombreLigne - 1; i >= 0; i--) {
			for (int j = 0; j < nombreColonne; j++) {

				System.out.print(tabImage[i][j] + " | ");
			}
			System.out.println();
		}

	}

}
