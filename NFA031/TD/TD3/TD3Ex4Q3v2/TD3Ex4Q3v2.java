import java.util.Scanner;

public class TD3Ex4Q3v2 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int somme = 0;
		int nombreEntiers;
		System.out.print("Nombre d'Entiers : ");
		nombreEntiers = saisie.nextInt();
		for (int i=1; i<=nombreEntiers; i++) {
			somme = somme + i;
		}
		System.out.print("Somme des " + nombreEntiers + " premiers entiers : " + somme);
		saisie.close();
	}

}
