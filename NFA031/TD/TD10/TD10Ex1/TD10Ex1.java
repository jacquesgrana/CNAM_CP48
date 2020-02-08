import java.util.Scanner;

public class TD10Ex1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int entierSaisi, resultat;
		System.out.println("Saisir un entier :");
		System.out.println();
		entierSaisi = saisie.nextInt();
		resultat = calculSommeCarres(entierSaisi);
		System.out.println("Résultat : " + resultat);
		System.out.println();
		saisie.close();
	}

	// fonction récursive
	private static int calculSommeCarres(int n) {
		if (n==0) {
			return 0;
		}
		else {
			return (n*n + calculSommeCarres(n-1));
		}
	}

}
