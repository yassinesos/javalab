

public class Somme {
	public static void main(String[] args) {
		int i;
		int somme = 0;

		for (i = 0; i< args.length; i++) {
			try {
				somme += Integer.valueOf(args[i]);
			} catch(NumberFormatException e) {
				System.err.println("Attention, \"" + args[i] + "\" n'est pas un nombre !");
			}
		}
		System.out.println("Somme = " + somme);
	}
}
