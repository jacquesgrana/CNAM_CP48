import java.util.Scanner;
import java.util.ArrayList;

public class TD13Ex2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		String chaineATraiter = "";
		ArrayList<String> listeDeMot = new ArrayList<String>();
		int debutMot = 0, finMot = 0;
		boolean isMotEnCours = false;
		
		System.out.println("Saisir une suite de mots : ");
		System.out.println();
		chaineATraiter = saisie.nextLine();
		
		for (int i=0; i<chaineATraiter.length(); i++) {
			
				// si lettre
					// si isMotEnCours = false
						// isMotEnCours = true
						// debut mot[compteur] = i
						// compteurDeMot++
			
			if (Character.isLetter(chaineATraiter.charAt(i))) {
				if (!isMotEnCours) {
					isMotEnCours = true;
					debutMot = i;
				}
			}
			
			
				// si lettre(i) et pas lettre pour i+1 et i pas dernier
					// fin mot[compteur] = i
					// isMotEnCours = false
					//	boucle pour entrer mot dans arraylist
				// si i dernier
					// si isMotEnCours = true
					// fin mot[compteur] = i
			
			if (i < chaineATraiter.length()-1) {
				if ((Character.isLetter(chaineATraiter.charAt(i))) && (!Character.isLetter(chaineATraiter.charAt(i+1)))) {
					finMot = i;
					isMotEnCours = false;
					listeDeMot.add(calculMot(debutMot, finMot, chaineATraiter));
				}
			}
			else {
				if (isMotEnCours) {
					finMot = i;
					listeDeMot.add(calculMot(debutMot, finMot, chaineATraiter));
				}
			}			
		}
		System.out.println("Chaîne à traiter : " + chaineATraiter);
		System.out.println();
		System.out.println("Résultat : ");
		System.out.println();
		
		// boucle d'affichage de l'arraylist
		int i = 1;
		for (String mot : listeDeMot) {
			System.out.println(i + " : " + mot);
			i++;
		}
		
		
		saisie.close();
	}

	private static String calculMot(int debutMot, int finMot, String chaineATraiter) {
		String resultat = "";
		for(int i=debutMot; i<=finMot; i++) {
			resultat = resultat + chaineATraiter.charAt(i);
		}
		
		return resultat;
	}

}
