
public class TD11Ex1 {

	public static void main(String[] args) {
		Integer somme = 0;
		double moyenne = 0.0;
		for(int i=0; i < args.length; i++){
			somme = somme + Integer.parseInt(args[i]);
		}
		moyenne = (double)(somme / args.length);
		System.out.println("Moyenne : " + moyenne);
	}

}
