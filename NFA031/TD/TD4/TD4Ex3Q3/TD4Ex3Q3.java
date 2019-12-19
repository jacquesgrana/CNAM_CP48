import java.util.Scanner;

public class TD4Ex3Q3 {
	public static void main(String[] args) {
		Scanner saisie = new Scanner(System.in);
		int x,y,res=1;
		System.out.print("Saisissez x : ");
		x = saisie.nextInt();
		System.out.print("Saisissez y : ");
		y = saisie.nextInt();
		for (int i=1; i<=y; i++) {	
			res = res * x;	
		}
		System.out.println(x + " puissance " + y + " = " + res);
		saisie.close();
	}
}
