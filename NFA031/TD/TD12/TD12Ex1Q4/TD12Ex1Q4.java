import java.util.Scanner;
import java.util.ArrayList;




public class TD12Ex1Q4 {

	public static int NB_ELEMENT_MAX = 64;

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		int nombreDeNote = 0;
		int numeroNote = 0;
		int noteSaisie = 0;
		int coefSaisi = 0;
		ArrayList<Integer> tableauNote = new ArrayList<Integer>();
		ArrayList<Integer> tableauCoef = new ArrayList<Integer>();
		boolean isTabEmpty = true;
		double moyenne = 0;

		do {
			if (!isTabEmpty) {
				afficheNote(tableauNote,tableauCoef,nombreDeNote);
				System.out.print("Calculer Moyenne (C) / Modifier Note (M) / ");
			}
			System.out.print("Ajouter Note (A) / ");
			System.out.print("Quitter (Q)");
			System.out.println();
			reponse = saisirCaractere(saisie,"[ACMQ]*");

			if(reponse == 'C')  {
				moyenne = calculMoyenne(tableauNote,tableauCoef,nombreDeNote);
				System.out.println("Moyenne : " + moyenne);
				System.out.println();
			}
			
			if(reponse == 'M')  {
				
				do {
					System.out.print("Saisir le numéro de la note à modifier, valeur max : " + nombreDeNote);
					System.out.println();
					numeroNote = saisirEntier(saisie,"[0-9]*");
				}
				while (numeroNote < 1 || numeroNote > nombreDeNote);
				
				do {
					System.out.println("Saisir la nouvelle note n°" + numeroNote + " : ");
					System.out.println();
					noteSaisie = saisirEntier(saisie,"[0-9]*");
					//System.out.println("note saisie : " + noteSaisie);
				}
				while ((noteSaisie>20) || (noteSaisie<0));
				do {
					System.out.println("Saisir le coefficient de la nouvelle note n°" + numeroNote + " : ");
					System.out.println();
					coefSaisi = saisirEntier(saisie,"[0-9]*");
					//System.out.println("note saisie : " + noteSaisie);
				}
				while (coefSaisi<0);
				modifierNoteParNumero(tableauNote,numeroNote-1,noteSaisie);
				modifierCoefParNumero(tableauCoef,numeroNote-1,coefSaisi);
				
			}

			if(reponse == 'A')  {
				ajouterNote(tableauNote,tableauCoef,nombreDeNote,saisie);
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

	private static void modifierNoteParNumero(ArrayList<Integer> iTableauNote, int iNumeroNote, int iNouvelleNote) {
		iTableauNote.set(iNumeroNote, iNouvelleNote);
		
	}
	
	private static void modifierCoefParNumero(ArrayList<Integer> iTableauCoef, int iNumeroNote, int iNouveauCoef) {
		iTableauCoef.set(iNumeroNote, iNouveauCoef);
		
	}

	private static double calculMoyenne(ArrayList<Integer> iTableauNote, ArrayList<Integer> iTableauCoef, int iNombreDeNote) {
		int somme = 0;
		int sommeCoef = 0;
		double moyenne = 0;
		for(int i=0; i<iNombreDeNote; i++) {

			somme = somme + (iTableauNote.get(i) * iTableauCoef.get(i));
			sommeCoef = sommeCoef + iTableauCoef.get(i);

		}

		moyenne =(double)somme/sommeCoef;
		moyenne = (double)Math.round(moyenne * 100) / 100;
		return moyenne;
	}

	private static void ajouterNote(ArrayList<Integer> iTableauNote, ArrayList<Integer> iTableauCoef, int iNombreDeNote, Scanner saisie) {
		//boolean isIndexTrouve = false;
		int noteSaisie = 0;
		int coefSaisi = 0;
		//index = chercheIndexLibre(iTableauNote);

		if (iNombreDeNote == NB_ELEMENT_MAX) {
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
			do {
				System.out.println("Saisie le coefficient de la note n°" + (iNombreDeNote + 1) + " : ");
				System.out.println();
				coefSaisi = saisirEntier(saisie,"[0-9]*");
				//System.out.println("note saisie : " + noteSaisie);
			}
			while (coefSaisi<0);
			iTableauNote.add(noteSaisie);
			iTableauCoef.add(coefSaisi);
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


	private static void afficheNote(ArrayList<Integer> iTableauNote, ArrayList<Integer> iTableauCoef, int iNombreDeNote) {
		//int compteur = 0;
		System.out.println("Tableau des notes et des coefficients :");

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
			if (iTableauNote.get(i)<10) {
				System.out.print(" ");
			}
			System.out.print(iTableauNote.get(i) + " | ");

		}
		System.out.println();
		
		System.out.print("| ");
		for (int i=0; i<iNombreDeNote; i++) {
			if (iTableauCoef.get(i)<10) {
				System.out.print(" ");
			}
			System.out.print(iTableauCoef.get(i) + " | ");

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
