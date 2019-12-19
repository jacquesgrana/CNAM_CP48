import java.util.Scanner;

public class TD7Ex3 {

	public static void main(String[] args) {
		
		Scanner saisie = new Scanner(System.in);
		int nombreElement;
		double sommeEuro;
		
		do {
			System.out.println();
			System.out.println("Saisir le nombre d'éléments (1 à 20) :");
			nombreElement = saisie.nextInt();
		}
		while ((nombreElement<1)||(nombreElement>20));
		
		double[] tabEuro = new double[nombreElement];
		double[] tabFranc = new double[nombreElement];
		
		for (int i=0; i<nombreElement; i++) {
			do {
				System.out.println();
				System.out.println("Saisir la somme en euros n°" + (i+1) + " :");
				sommeEuro = saisie.nextDouble();
			}
			while ((sommeEuro<=0)||(sommeEuro>1000000));
			tabEuro[i] = sommeEuro;
			tabFranc[i] = sommeEuro * 6.55957;
		}
		
		for (int i=0; i<nombreElement; i++) {
			
			double valeurEuroDouble = Math.round(tabEuro[i] * 100.0)/100.0;
			double valeurFrancDouble = Math.round(tabFranc[i] * 100.0)/100.0;
			System.out.println((i+1) + " - " + valeurEuroDouble + " € vaut " + valeurFrancDouble + " francs");
		}
		
		
		saisie.close();
		System.out.println();
		System.out.println("Fin du programme");
	}

}
