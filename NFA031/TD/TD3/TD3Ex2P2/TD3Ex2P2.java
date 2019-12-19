import java.util.Scanner;

public class TD3Ex2P2 {

	public static void main(String[] args) {
		int a,b,c;
		Scanner saisie = new Scanner(System.in);
		System.out.print("Saisissez le premier nombre : ");
		a = saisie.nextInt();
		System.out.print("Saisissez le deuxième nombre : ");
		b = saisie.nextInt();
		System.out.print("Saisissez le troisième nombre : ");
		c = saisie.nextInt();
		if ((c>b)&&(b>a)) {
			System.out.print("En ordre croissant ");
		}
		else {
			System.out.print("Pas en ordre croissant ");
		}
		saisie.close();
	}
}
