import java.util.Scanner;

public class TD7Ex2 {

	public static void main(String[] args) {
		
		Scanner saisie = new Scanner(System.in);
		boolean[] tabBoolean = new boolean[4];
		boolean calculOu = false, calculEt = true; // si pas initialisé alors prevoir le premier calcul en dur
		int valeurSaisie;
		System.out.println();
		System.out.println("Saisir la valeur de 4 booléens");
		System.out.println();
		
		for (int i=0; i<4; i++) {
			
			do {
				System.out.println("Saisir le booléen n°" + (i+1) + " ('1' pour 'true' / '0' pour 'false') : ");
				valeurSaisie = saisie.nextInt();
			}
			while ((valeurSaisie!=0)&&(valeurSaisie!=1));
			
			if (valeurSaisie==1) {
				tabBoolean[i]=true;
			}
			else {
				tabBoolean[i]=false;
			}
			
		}
		
		for (int i=0; i<4; i++) {
			calculOu = calculOu || tabBoolean[i];
			calculEt = calculEt && tabBoolean[i];
		}
		System.out.println();
		System.out.println("Résultat du 'ou' : " + calculOu);
		System.out.println();
		System.out.println("Résultat du 'et' : " + calculEt);
		
		saisie.close();
	}

}
