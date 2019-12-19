import java.util.Scanner;

public class TD3Ex2P3 {
	
	public static void main(String[] args) {
		int a,b,c,max;
		Scanner saisie = new Scanner(System.in);
		System.out.print("Saisissez le premier nombre : ");
		a = saisie.nextInt();
		System.out.print("Saisissez le deuxième nombre : ");
		b = saisie.nextInt();
		System.out.print("Saisissez le troisième nombre : ");
		c = saisie.nextInt();
		saisie.close();
		if ((a>b)&&(a>c)) {
			max = a;
		}
		else {
			if ((b>a)&&(b>c)) {
				max = b;
			}
			else {
				max = c;
			}
		}
		System.out.print("Maximum : " + max);
		saisie.close();
	}
	
}
