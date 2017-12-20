import java.util.Scanner;

import prog.Cellule;
import prog.Kernel;
import prog.Conteneur;
import prog.SaveManager;

public class Main {

	private static String clean(String str)
	{
		String strbis = new String(str);
		int i = 0;
		while (i >= 0)
		{
			i = strbis.indexOf("\b");
			if (i == 0)
				strbis = new String (strbis.substring(1));
			else if (i > 0)
				strbis = new String(strbis.substring(0, i-1) + strbis.substring(i+1));
		}
		return strbis;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nom="", formule="", chemin="", action="",user="",requete="", table ="";
		char[] password;
		Conteneur co = new Conteneur ();
		boolean boucle = true;
		System.out.println("Stop pour quitter");
		try {
			while(boucle) {
				System.out.println("Action : editer | sauvegarder | importer | importer-bd");
				action = clean(sc.nextLine());
				switch(action){
				case "editer":
					System.out.println("Quel nom ?");
					nom = clean(sc.nextLine());
					System.out.println("Quelle formule ?");
					formule = clean(sc.nextLine());
					Kernel.editer(nom, formule);
					break;
				case "sauvegarder":
					System.out.println("Quel chemin ?");
					chemin = clean(sc.nextLine());
					Kernel.sauvegarder(chemin);
					break;
				case "importer":
					System.out.println("Quel chemin ?");
					chemin = clean(sc.nextLine());
					Kernel.importerFichier(chemin);
					break;
				case "stop":
					boucle = false;
					break;
				case "importer-bd":
					
					System.out.println("Quel url ?");
					chemin = clean(sc.nextLine());
					
					System.out.println("Quel utilisateur ?");
					user = clean(sc.nextLine());
					
					System.out.println("Quel mot de passe ?");
					//password = clean(sc.nextLine());
					password  = System.console().readPassword();
					
					
					System.out.println("De quelle table voulez-vous extraire les données ?");
					table = clean(sc.nextLine());
					
					requete = "select * from "+table;
					
					Kernel.importerBase(requete,chemin,user,new String(password));
									
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
