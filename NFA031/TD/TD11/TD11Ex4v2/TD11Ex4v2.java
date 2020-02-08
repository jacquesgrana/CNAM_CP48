import java.util.Scanner;

public class TD11Ex4v2 {
	
	public static int NB_ELEMENT = 64;

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		int[] tableauNote = new int[NB_ELEMENT];
		boolean isTabEmpty = true;
		double moyenne = 0;
		for (int i=0; i<tableauNote.length; i++) {
			tableauNote[i] = -1;
		}
		
		do {
			if (!isTabEmpty) {
				afficheNote(tableauNote);
				System.out.print("Calculer Moyenne (M) / ");
			}
			System.out.print("Ajouter Note (A) / ");
			System.out.print("Quitter (Q)");
			System.out.println();
			reponse = saisirCaractere(saisie,"[AMQ]*");
			
			if(reponse == 'M')  {
				moyenne = calculMoyenne(tableauNote);
				System.out.println("Moyenne : " + moyenne);
				System.out.println();
			}
			
			if(reponse == 'A')  {
				ajouterNote(tableauNote,saisie);
				if (isTabEmpty) {
					isTabEmpty=false;
				}
			}	
		}
		while (reponse!='Q');
		System.out.println("Programme Terminé");
		saisie.close();
	}

	private static double calculMoyenne(int[] iTableauNote) {
		int compteur = 0, somme = 0;
		double moyenne = 0;
		for(int i=0; i<iTableauNote.length; i++) {
			if (iTableauNote[i] != -1) {
				somme = somme + iTableauNote[i];
				compteur++;
			}
		}

		moyenne =(double)somme/compteur;
		moyenne = (double)Math.round(moyenne * 100) / 100;
		return moyenne;
	}

	private static void ajouterNote(int[] iTableauNote, Scanner saisie) {
		//boolean isIndexTrouve = false;
		int index = -1, noteSaisie = 0;
		index = chercheIndexLibre(iTableauNote);

		if (index == -1) {
			System.out.println("Tableau plein ! Supprimez une note et recommencez");
			System.out.println();
		}
		else {
			do {
				System.out.println("Saisie de la note n°" + (index+1) + " : ");
				System.out.println();
				noteSaisie = saisirEntier(saisie,"[0-9]*");
				//System.out.println("note saisie : " + noteSaisie);
			}
			while ((noteSaisie>20) || (noteSaisie<0));
			iTableauNote[index] = noteSaisie;
		}
		
	}

	private static int saisirEntier(Scanner iSaisie, String regEx) {
		int entier;
		boolean saisiePasOk;
		String chaine = "";
		do {
			chaine = iSaisie.next();
			saisiePasOk = !chaine.matches(regEx);
			if (saisiePasOk) {
				System.out.println("Saisie incorrecte !");
			}
		}
		while (saisiePasOk);
		entier = Integer.parseInt(chaine);
		return entier;
	}

	private static int chercheIndexLibre(int[] iTableauNote) {
		int compteur = 0;
		do {
			if (iTableauNote[compteur] == -1) {
				return compteur;
			}
			compteur++;
		}
		while(compteur<NB_ELEMENT);
		return -1;
	}

	private static void afficheNote(int[] iTableauNote) {
		int compteur = 0;
		System.out.println("Tableau des notes :");
		
		//System.out.println("********************************");
		System.out.print("|  ");
		for(int i=0; i<iTableauNote.length; i++) {
			if (iTableauNote[i] != -1) {
				System.out.print((compteur+1) + " |  ");
				compteur++;
			}
		}
		System.out.println();
		//System.out.println("********************************");
		System.out.print("| ");
		for (int i=0; i<iTableauNote.length; i++) {
			if (iTableauNote[i] != -1) {
				System.out.print(iTableauNote[i] + " | ");
			}
		}
		System.out.println();
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
