import java.util.Scanner;

public class TD5Ex2Q1 {

	public static void main(String[] args) {
		int longueur;
		Scanner saisie = new Scanner (System.in);
		System.out.println("quelle largeur souhaitez-vous ?");
		longueur = saisie.nextInt();
		for (int i=0; i<longueur; i++) {
			for (int j=0; j<longueur; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		saisie.close();

	}

}
