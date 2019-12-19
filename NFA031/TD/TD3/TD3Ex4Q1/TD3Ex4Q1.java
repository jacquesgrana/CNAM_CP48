import java.util.Scanner;

public class TD3Ex4Q1 {

	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int nombreATester ;
		System.out.print("Saisissez le nombre à tester : ");
		nombreATester = saisie.nextInt();
		
		if (nombreATester >= 0) {
			System.out.print("Nombre Positif !");
		}
		else {
			System.out.print("Nombre Négatif !");
		}
		saisie.close();
	}

}
