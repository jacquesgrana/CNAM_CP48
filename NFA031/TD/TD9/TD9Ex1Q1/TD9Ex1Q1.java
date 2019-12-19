import java.util.Scanner;

public class TD9Ex1Q1 {

	public static void main(String[] args) {
		int x=0, y=0, current=0, result=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez une valeur de x : ");
		x = sc.nextInt();
		
		System.out.println("Entrez une valeur de y : ");
		y = sc.nextInt();
		
		current = x;
		while (current >= y) {
			current -= y;
			result += 1;
			}
		
		System.out.println(x + "/" + y + " = " + result); // donne la division "entière" de x/y
		sc.close();
		}
		
	}


