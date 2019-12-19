import java.util.Scanner;

public class TD3Ex4Q3v3 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		double somme = 0;
		double nombreEntiers;
		double moyenne;
		System.out.print("Nombre d'Entiers : ");
		nombreEntiers = saisie.nextInt();
		for (int i=1; i<=nombreEntiers; i++) {
			somme = somme + i;
		}
		moyenne = somme / nombreEntiers;
		System.out.print("Moyenne de la somme des " + nombreEntiers + " premiers entiers : " + moyenne);
		saisie.close();
	}

}
