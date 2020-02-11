// NFA031 - Java - DM "Mastermind" - Décembre 2019 - Auditeur : Jacques Granarolo

import java.util.Scanner;

public class Mastermind {

	static final int NOMBRECASE = 4, NOMBRETOUR = 12; 

	public enum Couleur {
		ROUGE ("Rouge  ",0),
		JAUNE ("Jaune  ",1),
		VERT ("Vert   ",2),
		BLEU ("Bleu   ",3),
		ORANGE ("Orange ",4),
		BLANC ("Blanc  ",5),
		VIOLET ("Violet ",6),
		FUCHSIA ("Fuchsia",7);

		private String nom = "";
		private Integer id = 0;

		Couleur(String nom, Integer id){
			this.nom = nom;
			this.id = id;
		}

		public int getColorId(){
			return id;
		}

		public String toString(){
			return nom;
		}

		public static Couleur getById(int id) {
			Couleur couleurToReturn = BLEU;
			for(Couleur couleur : values()) {
				if(couleur.id.equals(id)) {
					couleurToReturn = couleur;
				}
			}
			return couleurToReturn;
		}
	}

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in); 	// obligé de l'utiliser en variable du main, sinon, cela pose problème
		char reponse = ' '; 									
		boolean quitter = false, gagne = false, perdu = false; 					
		int dernierTour = 0; 									
		Couleur[][] combiJouees = new Couleur[NOMBRETOUR][NOMBRECASE];
		Couleur[] combiATrouver = new Couleur[NOMBRECASE];

		do {
			effacerConsole(2);
			System.out.println("**************");
			System.out.println("* Mastermind *");
			System.out.println("**************");
			System.out.println();
			System.out.println("Jouer (J) - Quitter (Q)");
			reponse = saisirCaractere(saisie, "[JQ]*");
			
			if (reponse == 'J') {
				effacerConsole(10);
				System.out.println("**************************");
				System.out.println("* Lancement de la partie *");
				System.out.println("**************************");
				effacerConsole(3);
				calculeCombiATrouver(combiATrouver);

				// décommenter pour afficher la solution avant de jouer
				/*
				System.out.println();
				System.out.println("Combinaison à trouver :");
				System.out.println("+---------+---------+---------+---------+");
				afficheCombi(combiATrouver);
				System.out.println();
				System.out.println("+---------+---------+---------+---------+");
				System.out.println();
				*/

				for (int numeroTour=1; (numeroTour <= (NOMBRETOUR + 1)) && !gagne; numeroTour++) {
					// NB : j'ai vu, sur internet, que l'on pouvait mettre une expression booléenne dans les conditions d'une boucle for 
					// ce qui permet de ne plus rentrer dans la boucle si gagne=true

					// si on a passé le 12e tour sans gagner, alors la partie est perdue
					if (numeroTour == NOMBRETOUR + 1) {
						perdu = true;
						dernierTour = NOMBRETOUR;
					}
					
					// sinon, on joue
					else {							
						System.out.println("Tour n° " + numeroTour + " sur " + NOMBRETOUR);
						System.out.println();
						if (numeroTour > 1) {
							afficheLesCombis(combiJouees, numeroTour, combiATrouver);
						}
						saisirCombi(numeroTour,combiJouees,saisie);
						
						// si on a 4 couleurs bien placées, alors la partie est gagnée
						if (calcNbCoulPlacees(combiJouees,numeroTour - 1,combiATrouver) == NOMBRECASE) { 
							gagne = true;
							dernierTour = numeroTour;
						}
						effacerConsole(16);
					}
				}
				if (gagne || perdu) {
					afficheFinPartie(gagne, perdu, dernierTour, combiJouees, combiATrouver, saisie);
					gagne = false;
					perdu = false;
				}
			}
			if (reponse == 'Q') {
				quitter = true;
			}
		}
		while(!quitter);
		saisie.close();
		System.out.println();
		System.out.println("Programme terminé");
	}

	// fonction qui affiche les combinaisons déjà jouées
	private static void afficheLesCombis(Couleur[][] iCombiJouees, int iNumeroTour, Couleur[] iCombiATrouver) {
		System.out.println("Tour(s) prédédent(s)");
		System.out.println("------+---------+---------+---------+---------+");
		for (int compteurLigne = 1; compteurLigne <= iNumeroTour - 1; compteurLigne++) {
			System.out.print("n° ");
			if (compteurLigne < 10) { // ajoute un espace pour aligner l'affichage
				System.out.print(" ");
			}
			System.out.print(compteurLigne + " ");
			afficheCombi(iCombiJouees,compteurLigne-1);
			afficheResultat(iCombiJouees,compteurLigne-1,iCombiATrouver);
			System.out.println();
		}
		System.out.println("------+---------+---------+---------+---------+");
		System.out.println("[" + (char)248 + "] : pour chaque couleur bien placée");	
		System.out.println("[o] : pour chaque couleur présente mais mal placée");
		System.out.println("[ ] : si rien, alors aucune couleur n'est présente");
	}

	// fonction qui affiche sur la même ligne 'ø' pour chaque couleur bien placée, puis 'o' pour chaque couleur présente mais mal placée
	private static void afficheResultat(Couleur[][] iCombiJouees, int iNumeroLigne, Couleur[] iCombiATrouver) {
		int nbCoulPlacees = calcNbCoulPlacees(iCombiJouees,iNumeroLigne,iCombiATrouver);
		int nbCoulPresentes = calcNbCoulPresentes(iCombiJouees,iNumeroLigne,iCombiATrouver);
		if (nbCoulPlacees > 0) { 
			for (int i=1; i<= nbCoulPlacees; i++) {
				System.out.print((char)248 + " ");
			}
		}
		if (nbCoulPresentes > 0) {
			for (int i=1; i<= nbCoulPresentes; i++) {
				System.out.print("o ");
			}
		}
	}


	// fonction qui affiche les noms des couleurs d'une combinaison sur la même ligne (surcharge)
	private static void afficheCombi(Couleur[] iCombi) {
		System.out.print("| ");
		for (int numeroCase=0; numeroCase < NOMBRECASE; numeroCase++) { // iCombi.length
			Couleur couleur = iCombi[numeroCase];
			System.out.print(couleur.toString() + " | ");
		}
	}

	// fonction qui affiche les noms des couleurs d'une combinaison sur la même ligne
	private static void afficheCombi(Couleur[][] iCombiJouees, int iCompteurLigne) {
		System.out.print("| ");
		for (int numeroCase = 0; numeroCase < NOMBRECASE; numeroCase ++) { 	
			Couleur couleur = iCombiJouees[iCompteurLigne][numeroCase];
			System.out.print(couleur.toString() + " | ");
		}
	}

	// fonction qui affiche la fin de partie en deux écrans successifs
	private static void afficheFinPartie(boolean iGagne, boolean iPerdu, int iDernierTour, Couleur[][] iCombiJouees, Couleur[] iCombiATrouver, Scanner iSaisie) {
		char reponse = ' ';
		effacerConsole(16);
		System.out.println("*****************");
		System.out.println("* Fin de Partie *");
		System.out.println("*****************");
		if (iGagne) {
			System.out.println();
			System.out.println("Bravo, vous avez gagné en " + iDernierTour + " tour(s) !!");
		}
		if (iPerdu) {
			System.out.println();
			System.out.println("Vous avez perdu !!");
		}
		System.out.println();
		System.out.println("Continuer (C)");
		do {
			reponse = saisirCaractere(iSaisie, "[C]*");
		}
		while (reponse != 'C');
		effacerConsole(9);
		System.out.println("***************************");
		System.out.println("* Historique de la partie *");
		System.out.println("***************************");
		System.out.println();
		System.out.println("Combinaison à trouver :");
		System.out.println("+---------+---------+---------+---------+");
		afficheCombi(iCombiATrouver);
		System.out.println();
		System.out.println("+---------+---------+---------+---------+");
		System.out.println();
		afficheLesCombis(iCombiJouees, iDernierTour + 1, iCombiATrouver);
		System.out.println();
		System.out.println("Retour menu principal (R)");
		do {
			reponse = saisirCaractere(iSaisie, "[R]*");
		}
		while (reponse != 'R');
		effacerConsole(16);
	}

	// fonction qui ajoute 'nbLigne' sauts de lignes vides à la console
	// NB : je n'ai pas trouvé de manière "propre" pour "effacer" la console
	private static void effacerConsole(int nbLigne) { 
		for(int i = 0; i < nbLigne; i++)
		{
			System.out.println();
		}

	}

	// fonction qui calcule au hasard la combinaison à trouver et la stocke dans iCombiATrouver
	private static void calculeCombiATrouver(Couleur[] iCombiATrouver) { 
		int nombreHasard;
		Couleur couleurHasard;
		for (int i=0; i<NOMBRECASE; i++) {					
			do {
				do {
					// renvoie un entier compris entre 0 et 8, le cas 8 étant improbable
					nombreHasard = (int)(Math.random() * 8);
				}
				while (nombreHasard == 8); 								
				couleurHasard = Couleur.getById(nombreHasard);
			}
			while (isCouleurPresente(iCombiATrouver,couleurHasard,i));
			iCombiATrouver[i] = Couleur.getById(nombreHasard);
		}

	}


	// fonction qui renvoie vrai si la couleur iCouleurHasard est déjà présente dans la combinaison à trouver
	private static boolean isCouleurPresente(Couleur[] iCombiATrouver, Couleur iCouleurHasard, int iNumeroCouleur) { 
		for(int i=0; i<=iNumeroCouleur; i++) {
			if (iCouleurHasard == iCombiATrouver[i]) {
				return true;
			}
		}
		return false;
	}

	// fonction qui calcule et renvoie le nombre de couleurs présentes mais mal placées
	private static int calcNbCoulPresentes(Couleur[][] iCombiJouees, int iNumeroTour, Couleur[] iCombiATrouver) {
		int nombreCouleur = 0;
		for (int i=0; i<NOMBRECASE; i++) {
			for (int j=0; j<NOMBRECASE; j++) {
				if ((iCombiJouees[iNumeroTour][i] == iCombiATrouver[j]) && (i!=j)) {
					nombreCouleur++;
				}
			}
		}
		return nombreCouleur;
	}

	// fonction qui calcule et renvoie le nombre de couleurs bien placées
	private static int calcNbCoulPlacees(Couleur[][] iCombiJouees, int iNumeroTour, Couleur[] iCombiATrouver) {
		int nombreCouleur = 0;
		for (int i=0; i<NOMBRECASE; i++) {
			for (int j=0; j<NOMBRECASE; j++) {
				if ((iCombiJouees[iNumeroTour][i] == iCombiATrouver[j]) && (i==j)) {
					nombreCouleur++;
				}
			}
		}
		return nombreCouleur;
	}

	// fonction qui saisie une combinaison : string de 4 caractères mis en majuscules compris dans [BFIJLORV]* dont les caractères ne sont présents qu'une seule fois
	private static void saisirCombi(int iNumeroTour, Couleur[][] combiJouees, Scanner iSaisie) {
		String combiChoisie = "";
		boolean longueurOk = false, lettresOk = false;
		System.out.println();
		System.out.println("Saisir la combinaison de 4 lettres à tester"); 
		System.out.println("Blanc (L) Bleu (B) Fuchsia (F) Jaune (J) Orange (O) Rouge (R) Vert (V) Violet (I)");

		do {
			combiChoisie = iSaisie.next().toUpperCase();
			longueurOk = combiChoisie.length() == NOMBRECASE;
			lettresOk = combiChoisie.matches("[BFIJLORV]*");
			if (!longueurOk) {
				System.out.println("Nombre de lettres incorrect ! Il faut exactement 4 lettres.");
			}
			if (!lettresOk) {
				System.out.println("Lettre(s) incorrecte(s) ! Choisir 'B', 'F', 'I', 'J', 'L', 'O', 'R' ou 'V'");
			}
			if (!isValidCombi(combiChoisie)) {
				System.out.println("Lettre(s) choisie(s) plusieurs fois, chaque lettre ne doit être présente qu'une seule fois");
			}
		}
		while (!longueurOk || !lettresOk || !isValidCombi(combiChoisie));

		for (int i=0; i<NOMBRECASE; i++) {
			switch(combiChoisie.charAt(i)) {
			case 'R': // Rouge
				combiJouees[iNumeroTour-1][i] = Couleur.getById(0);
				break;
			case 'J': // Jaune
				combiJouees[iNumeroTour-1][i] = Couleur.getById(1);
				break;
			case 'V': // Vert
				combiJouees[iNumeroTour-1][i] = Couleur.getById(2);
				break;
			case 'B': // Bleu
				combiJouees[iNumeroTour-1][i] = Couleur.getById(3);
				break;
			case 'O': // Orange
				combiJouees[iNumeroTour-1][i] = Couleur.getById(4);
				break;
			case 'L': // Blanc
				combiJouees[iNumeroTour-1][i] = Couleur.getById(5);
				break;
			case 'I': // Violet
				combiJouees[iNumeroTour-1][i] = Couleur.getById(6);
				break;
			case 'F': // Fuchsia
				combiJouees[iNumeroTour-1][i] = Couleur.getById(7);
				break;
			}
		}
	}

	// fonction qui renvoie vrai si il n'a pas de lettre présente plusieurs fois
	private static boolean isValidCombi(String iCombiChoisie) {
		for (int i=0; i<iCombiChoisie.length(); i++) {
			for (int j=0; j<iCombiChoisie.length(); j++) {
				if ((iCombiChoisie.charAt(i) == iCombiChoisie.charAt(j)) && (i!=j)) {
					return false;
				}
			}
		}
		return true;
	}

	// fonction qui renvoie un caractère mis en majuscule compris dans regEx
	private static char saisirCaractere(Scanner iSaisie, String regEx) {
		char caractere;
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
		caractere = chaine.charAt(0);
		return caractere;
	}
}
