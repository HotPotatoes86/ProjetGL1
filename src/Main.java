import java.util.Scanner;

import prog.Cellule;
import prog.Conteneur;

public class Main {

	public static void main(String[] args) {
		Conteneur cont = new Conteneur();
		Scanner sc = new Scanner(System.in);
		String nom="", formule="";
		System.out.println("Stop pour quitter");
		try {
			while(true) {
				System.out.println("Nom cellule : ");
				nom = sc.nextLine();
				System.out.println("Formule cellule : ");
				formule = sc.nextLine();
				if (nom.equalsIgnoreCase("stop") || formule.equalsIgnoreCase("stop")) break;
				cont.editerCellule(nom, formule);
				System.out.println("Contenu du conteneur :");
				for (Cellule c : cont.getAllCellules()) {
					System.out.println("cellule(" + c.getName() + ") : " + c.getFormule() + " = " + c.getResultat());
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
