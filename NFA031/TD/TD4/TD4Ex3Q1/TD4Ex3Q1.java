import java.util.Scanner;

public class TD4Ex3Q1 {
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int nombreEntier;
		System.out.print("Saisissez un nombre entier : ");
		nombreEntier = saisie.nextInt();
		for (int i=1; i<=9; i++) {
			System.out.println(i + " x " + nombreEntier + " = " + i*nombreEntier);
		}
		saisie.close();
	}
}
