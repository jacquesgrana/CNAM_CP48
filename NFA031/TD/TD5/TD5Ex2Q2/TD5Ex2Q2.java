import java.util.Scanner;

public class TD5Ex2Q2 {
	public static void main(String[] args) {
		int nombreLignes;
		Scanner saisie = new Scanner (System.in);
		System.out.println("Combien de lignes souhaitez-vous ?");
		nombreLignes = saisie.nextInt();
		for (int i=1; i<=nombreLignes; i++) {
			for (int j=1; j<=(nombreLignes*2-1); j++) {
				if ((j>=1 && j<=nombreLignes-i) || (j>nombreLignes + i -1 && j<=nombreLignes*2-1)) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}			
			}
			System.out.println();
		}
		saisie.close();
	}
}
