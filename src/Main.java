import java.util.Scanner;

import prog.Cellule;
import prog.Kernel;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nom="", formule="", chemin="", action="";
		boolean boucle = true;
		System.out.println("Stop pour quitter");
		try {
			while(boucle) {
				System.out.println("Action : editer | sauvegarder | importer");
				action = sc.nextLine();
				switch(action){
				case "editer":
					System.out.println("Quel nom ?");
					nom = sc.nextLine();
					System.out.println("Quelle formule ?");
					formule = sc.nextLine();
					Kernel.editer(nom, formule);
					break;
				case "sauvegarder":
					System.out.println("Quel chemin ?");
					chemin = sc.nextLine();
					Kernel.sauvegarder(chemin);
					break;
				case "importer":
					System.out.println("Quel chemin ?");
					chemin = sc.nextLine();
					Kernel.importerFichier(chemin);
					break;
				case "stop":
					boucle = false;
					break;
				default: System.out.println("Action invalide");
				}
				System.out.println("==============================================");
				System.out.println("===============Contenu du conteneur===========");
				for (Cellule c : Kernel.getConteneur().getAllCellules()){
					System.out.println("@" + c.getName() + "(" + c.getFormule() + ") = " + c.getResultat());
				}
				System.out.println("==============================================");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
