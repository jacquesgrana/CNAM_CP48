import java.util.Scanner;

public class TD4Ex3Q2 {
	public static void main(String[] args) {
		
			
		
		Scanner saisie = new Scanner(System.in);
		int nombreEntier = 0;
		while (!(nombreEntier >= 1 && nombreEntier <= 9)) {
			System.out.print("Saisissez un nombre entier : ");
			nombreEntier = saisie.nextInt();
		}
		for (int i=1; i<=9; i++) {
			System.out.println(i + " x " + nombreEntier + " = " + i*nombreEntier);
		}
		
		saisie.close();
	}
}
