import java.util.Scanner;

public class TD3Ex2P1 {
	public static void main (String[] args) {
		
		double noteExamen, notePartiel, noteFinale, moyenne;
		Scanner saisie = new Scanner(System.in);
		System.out.print("Saisissez la note du Partiel : ");
		notePartiel = saisie.nextDouble();
		//System.out.println();
		System.out.print("Saisissez la note de l'Examen : ");
		noteExamen = saisie.nextDouble();
		if (noteExamen >= 7) {
			moyenne = (noteExamen + notePartiel)/2;
			if (noteExamen > moyenne) {
				noteFinale = noteExamen;
			}
			else {
				noteFinale = moyenne;
			}
			System.out.println("Note Finale : " + noteFinale);
		}
		else {
			System.out.println("Note Examen éliminatoire !!");
		}
		saisie.close();
	}
}
