import java.util.Scanner;

public class TD9Ex1Q4 {

	public static void main(String[] args) {
		int x=0, y=0;
		int result=0;
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

	private static int calculDivEntiere(int ix, int iy) {
		
		int sgnx, sgny, absx, absy, result=0;
		
		// calcul des signes et des valeurs absolues
		if (ix < 0) {
			sgnx = -1;
			absx = -ix;
		}
		else {
			sgnx = 1;
			absx = ix;
		}
		
		if (iy < 0) {
			sgny = -1;
			absy = -iy;
		}
		else {
			sgny = 1;
			absy = iy;
		}
		
		//result = sgnx * sgny * absx / absy; // trouvé sur : https://perso.esiee.fr/~bureaud/Unites/In101/Cours/Expressions_Tests/division.htm
		int current=absx; // calcul sur les valeurs absolues
		while (current >= absy) {
			current -= absy;
			result += 1;
		}
		result = sgnx * sgny * result;
		return result;	
	}
	
}
