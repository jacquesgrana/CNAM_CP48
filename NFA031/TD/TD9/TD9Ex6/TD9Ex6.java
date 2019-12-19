
public class TD9Ex6 {

	public static void main(String[] args) {
		int [] ex = {1,5,8,9,7};
		int [] ex2 = {1201,-5000,-450,0,-15612,123};
		afficheTable(ex);
		afficheTable(ex2);
	}

	
	static void afficheTable(int[] iTab) {
		
		int size = iTab.length, i, tailleMax;
		
		tailleMax = calculeTailleMax(iTab);
		//System.out.println("Taille Max = " + tailleMax);
		
		System.out.print('+');
		for (i=0; i<size; i++) {
			System.out.print("-");
			for (int j=1; j<=tailleMax; j++) {
				System.out.print("-");
			}
			System.out.print("-+");
		}
		System.out.println();
		System.out.print('|');
		
		for (i=0; i<size; i++) {
			int tailleNombre=1;
			int division = Math.abs(iTab[i]);
			int nombreEspace, nombreEspaceGauche, nombreEspaceDroite;
			
			do {	
				if (division >= 10) {
					tailleNombre++;
				}
				division = division / 10;
			}
			while(division >= 10);
			
			
			if (iTab[i] < 0) {
				tailleNombre++;
			}
			
			nombreEspace = tailleMax - tailleNombre;
			nombreEspaceGauche = nombreEspace / 2;
			
			if (nombreEspace % 2 !=0) {
				nombreEspaceGauche ++;
			}
			nombreEspaceDroite = nombreEspace / 2;
			
			if ((iTab[i] < 0) && (nombreEspaceGauche > 0)) {
				nombreEspaceDroite++;
				nombreEspaceGauche--;
			}
			
			System.out.print(" ");
			if (nombreEspaceGauche>0) {
				for (int j=1; j<=nombreEspaceGauche; j++) {
					System.out.print(" ");
				}
			}
			System.out.print(iTab[i]);
			if (nombreEspaceDroite>0) {
				for (int j=1; j<=nombreEspaceDroite; j++) {
					System.out.print(" ");
				}
			}
			System.out.print(" |");
			
			
		}
		System.out.println();
		System.out.print('+');
		for (i=0; i<size; i++) {
			System.out.print("-");
			for (int j=1; j<=tailleMax; j++) {
				System.out.print("-");
			}
			System.out.print("-+");
		}
		System.out.println();
	}


	private static int calculeTailleMax(int[] iTab) {
		int iTailleMax=0;
		int compteur=0, division;
		for(int i=0; i<iTab.length; i++) {
			compteur=1;
			division = Math.abs(iTab[i]);
			do {	
				if (division >= 10) {
					compteur++;
				}
				division = division / 10;
			}
			while(division >= 10);
			if (iTab[i] < 0) {
				compteur++;
			}
			if (compteur > iTailleMax) {
				iTailleMax=compteur;
			}
		}
		return iTailleMax;
	}
	
}
