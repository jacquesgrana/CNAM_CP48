import java.util.Scanner;

public class TD4Ex4Q1 {
	public static void main(String[] args) {
		double coursDollar=0.0, sommeEuros=0.0, sommeDollars=0.0;
		char carSaisi;
		boolean sortir = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Saisissez le cours du dollar en cours (valeur de 1 dollar) : ");
		coursDollar=sc.nextDouble();
		while (!sortir){
			System.out.print("Saisissez une somme en euros : ");
			sommeEuros=sc.nextDouble();
		
			sommeDollars = sommeEuros/coursDollar;
			System.out.println(sommeEuros + "€ vaut : " + sommeDollars + "$");
		
			System.out.println(" Sortir (O)");
			carSaisi = sc.next().charAt(0);
			if (carSaisi == 'O') {
				sortir = true;
			}
			else {
				sortir = false;
			}
		}
		sc.close();
	}
}
