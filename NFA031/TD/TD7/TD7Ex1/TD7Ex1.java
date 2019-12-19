import java.util.Scanner;

public class TD7Ex1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int nombreElement;
		
		do {
			System.out.println();
			System.out.println("Saisir un entier supérieur à 1 et inférieur à 1000");
			nombreElement = saisie.nextInt();
		}
		while ((nombreElement<2)||(nombreElement>=1000));
		System.out.println();
		System.out.println("Calcul et remplissage du tableau de " + nombreElement + " éléments");
		
		int[] tabElement = new int[nombreElement+1];
		
		tabElement[0]=0;
		System.out.println("0 : 0");
		
		for (int i=1;i<=nombreElement;i++) {
			tabElement[i]=tabElement[i-1]+i;
			System.out.println(i + " : " + tabElement[i]);
		}

		saisie.close();
	}
	
}
