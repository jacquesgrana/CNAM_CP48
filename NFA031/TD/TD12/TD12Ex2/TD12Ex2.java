import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class TD12Ex2 {

	public static int NB_ELEMENT_MAX = 64;

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		char reponse = ' ';
		ArrayList<Integer> tableau1 = new ArrayList<Integer>();
		ArrayList<Integer> tableau2 = new ArrayList<Integer>();
		ArrayList<Integer> tableauUnion = new ArrayList<Integer>();
		ArrayList<Integer> tableauIntersection = new ArrayList<Integer>();
		boolean isTab1Empty = true;
		boolean isTab2Empty = true;

		do {
			if (!isTab1Empty) {
				afficheTableau(tableau1,"un");
			}
			if (!isTab2Empty) {
				afficheTableau(tableau2,"deux");
			}
			if ((!isTab1Empty) && (!isTab2Empty)) {
				System.out.print("Union (U) / Intersection (I) / ");
			}
			System.out.print("Aj. El. Tab. 1 (A) / Aj. El. Tab. 2 (J) / ");
			System.out.print("Quitter (Q)");
			System.out.println();
			reponse = saisirCaractere(saisie,"[AIJQU]*");
			

			if(reponse == 'A')  {
				ajouterElement(tableau1,saisie);
				if (isTab1Empty) {
					isTab1Empty=false;
				}
			}
			
			if(reponse == 'J')  {
				ajouterElement(tableau2,saisie);
				if (isTab2Empty) {
					isTab2Empty=false;
				}
			}
			
			if(reponse == 'U')  {
				tableauUnion = calculerUnion(tableau1,tableau2);
				//System.out.println("Résultat de l'Union :");
				afficheTableau(tableauUnion,"d'union");
			}
			
			if(reponse == 'I')  {
				tableauIntersection = calculerIntersection(tableau1,tableau2);
				//System.out.println("Résultat de l'Intersection :");
				afficheTableau(tableauIntersection,"d'intersection");
			}
		}
		while (reponse!='Q');
		System.out.println("Programme Terminé");
		saisie.close();
	}


	private static ArrayList<Integer> calculerIntersection(ArrayList<Integer> iTableau1, ArrayList<Integer> iTableau2) {
		ArrayList<Integer> iTableauIntersection = new ArrayList<Integer>();
		for (int i=0; i<iTableau1.size(); i++) {
				if (!isNotPresent(iTableau2,iTableau1.get(i)) ) {
					iTableauIntersection.add(iTableau1.get(i));
				}
		}
		Collections.sort(iTableauIntersection);
		return iTableauIntersection;
	}


	private static ArrayList<Integer> calculerUnion(ArrayList<Integer> iTableau1, ArrayList<Integer> iTableau2) {
		ArrayList<Integer> iTableauUnion = new ArrayList<Integer>(iTableau1); // clone tableau1
		// remplir avec tableau 1
		/*
		for (int i=0; i<iTableau1.size(); i++) {
			iTableauUnion.add(iTableau1.get(i));
		}*/
		for (int i=0; i<iTableau2.size(); i++) {
			if (isNotPresent(iTableauUnion,iTableau2.get(i))) {
				iTableauUnion.add(iTableau2.get(i));
			}
		}
		Collections.sort(iTableauUnion);
		return iTableauUnion;
	}


	private static void ajouterElement(ArrayList<Integer> iTableau,Scanner saisie) {
		boolean saisieOk = false;
		int elementSaisi = 0;	
		System.out.println("Saisie de l'élément n°" + (iTableau.size()+1) + " : ");
		System.out.println();
		do {
			elementSaisi = saisirEntier(saisie,"[0-9]*");
			saisieOk = isNotPresent(iTableau,elementSaisi);
			if (!saisieOk) {
				System.out.println("Element déjà présent !");
				System.out.println();
			}
		}
		while(!saisieOk);
		iTableau.add(elementSaisi);
		Collections.sort(iTableau);
	}

	private static boolean isNotPresent(ArrayList<Integer> iTableau, int elementSaisi) {
		boolean isOk = true;
		for (int i=0; i<iTableau.size(); i++) {
			if (elementSaisi == iTableau.get(i)) {
				//System.out.println("Element déjà présent !");
				//System.out.println();
				isOk = isOk && false;
			}
			else {
				isOk = isOk && true;
			}
		}
		return isOk;
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


	private static void afficheTableau(ArrayList<Integer> iTableau, String nomTableau) {
		System.out.println("Tableau " + nomTableau + " :");
		System.out.print("| ");
		for(int i=0; i<iTableau.size(); i++) {
			if (i<9) {
				System.out.print(" ");
			}

			System.out.print((i+1) + " | ");

		}
		System.out.println();
		System.out.print("| ");
		for (int i=0; i<iTableau.size(); i++) {
			if (iTableau.get(i)<10) {
				System.out.print(" ");
			}
			System.out.print(iTableau.get(i) + " | ");

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
