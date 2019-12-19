import java.util.Scanner;

public class TD9Ex1Q3 {

	public static void main(String[] args) {
		int x=0, y=0, result=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez une valeur de x : ");
		x = sc.nextInt();
		
		do {
			System.out.println("Entrez une valeur de y (différente de zéro) : ");
			y = sc.nextInt();
		}
		while (y==0);
		
		//current = x;
		result = calculDivEntiere(x,y);
		
		System.out.println(x + " div " + y + " = " + result); // donne la division "entière" de x/y
		sc.close();
	}

	private static int calculDivEntiere(int x, int y) {
		int current=x, result=0;
		while (current >= y) {
			current -= y;
			result += 1;
		}
		return result;
	}
	
}
