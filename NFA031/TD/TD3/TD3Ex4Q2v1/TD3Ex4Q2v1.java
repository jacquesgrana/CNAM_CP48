import java.util.Scanner;

public class TD3Ex4Q2v1 {
	public static void main(String[] args) {
		
		int longueur;
		Scanner sc = new Scanner (System.in);
		System.out.println("Combien de lignes d'étoiles souhaitez-vous ?");
		longueur = sc.nextInt();
		for (int i=0; i<longueur; i++) {
			System.out.println("****");
		}
		sc.close();
	}
}
