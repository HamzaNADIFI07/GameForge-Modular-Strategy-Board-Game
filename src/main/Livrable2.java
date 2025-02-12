package main;


public class Livrable2 {
	public static void main1(String[] args) {
		if (args.length <2) {
			System.out.println("Usage: java Livrable2 <largeur> <longeur>");
			return;
		}
		int largeur = Math.max(10,Integer.parseInt(args[0]));
		int longeur = Math.max(10,Integer.parseInt(args[0]));
	}
}
