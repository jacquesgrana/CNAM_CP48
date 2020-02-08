import java.util.Scanner;

public class TD11Ex4v3 {

	public static int NB_ELEMENT = 64;

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		int nombreDeNote = 0;
		int[] tableauNote = new int[NB_ELEMENT];
		boolean isTabEmpty = true;
		double moyenne = 0;

		do {
			if (!isTabEmpty) {
				afficheNote(tableauNote,nombreDeNote);
				System.out.print("Calculer Moyenne (M) / ");
			}
			System.out.print("Ajouter Note (A) / ");
			System.out.print("Quitter (Q)");
			System.out.println();
			reponse = saisirCaractere(saisie,"[AMQ]*");

			if(reponse == 'M')  {
				moyenne = calculMoyenne(tableauNote,nombreDeNote);
				System.out.println("Moyenne : " + moyenne);
				System.out.println();
			}

			if(reponse == 'A')  {
				ajouterNote(tableauNote,nombreDeNote,saisie);
				nombreDeNote++;
				if (isTabEmpty) {
					isTabEmpty=false;
				}
			}	
		}
		while (reponse!='Q');
		System.out.println("Programme Terminé");
		saisie.close();
	}

	private static double calculMoyenne(int[] iTableauNote, int iNombreDeNote) {
		int compteur = 0, somme = 0;
		double moyenne = 0;
		for(int i=0; i<iNombreDeNote; i++) {

			somme = somme + iTableauNote[i];
			compteur++;

		}

		moyenne =(double)somme/compteur;
		moyenne = (double)Math.round(moyenne * 100) / 100;
		return moyenne;
	}

	private static void ajouterNote(int[] iTableauNote, int iNombreDeNote, Scanner saisie) {
		//boolean isIndexTrouve = false;
		int noteSaisie = 0;
		//index = chercheIndexLibre(iTableauNote);

		if (iNombreDeNote == NB_ELEMENT) {
			System.out.println("Tableau plein !");
			System.out.println();
		}
		else {
			do {
				System.out.println("Saisie de la note n°" + (iNombreDeNote + 1) + " : ");
				System.out.println();
				noteSaisie = saisirEntier(saisie,"[0-9]*");
				//System.out.println("note saisie : " + noteSaisie);
			}
			while ((noteSaisie>20) || (noteSaisie<0));
			iTableauNote[iNombreDeNote] = noteSaisie;
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


	private static void afficheNote(int[] iTableauNote, int iNombreDeNote) {
		//int compteur = 0;
		System.out.println("Tableau des notes :");

		//System.out.println("********************************");
		System.out.print("| ");
		for(int i=0; i<iNombreDeNote; i++) {
			if (i<9) {
				System.out.print(" ");
			}

			System.out.print((i+1) + " | ");

		}
		System.out.println();
		//System.out.println("********************************");
		System.out.print("| ");
		for (int i=0; i<iNombreDeNote; i++) {
			if (iTableauNote[i]<10) {
				System.out.print(" ");
			}
			System.out.print(iTableauNote[i] + " | ");

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
