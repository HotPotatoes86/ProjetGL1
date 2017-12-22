import java.util.Iterator;
import java.util.Scanner;

import prog.Cellule;
import prog.Kernel;
import prog.Conteneur;
import prog.SaveManager;

/**
 * Classe Main permettant de montrer les fonctionnalitÈs du noyau fonctionnel
 * Utilise pendant la demonstration de la soutenance finale
 * @author Groupe 4
 *
 */
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
		System.out.println("stop pour quitter");
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
					//password = clean(sc.nextLine());	//affiche le mot de passe
					password  = System.console().readPassword(); //n'affiche pas le mot de passe
					
					
					System.out.println("De quelle table voulez-vous extraire les donn√©es ?");
					table = clean(sc.nextLine());
					
					requete = "select * from "+table;
					
					Kernel.importerBase(requete,chemin,user,new String(password));
									
					break;
				default: System.out.println("Action invalide");
				}
				if (boucle){
					System.out.println("==============================================");
					System.out.println("===============Contenu du conteneur===========");
					Iterator<Cellule> it = Kernel.getConteneur().getCelluleIterator();
					while (it.hasNext()) {
						Cellule c = it.next();
						System.out.println("@" + c.getName() + "(" + c.getFormule() + ") = " + c.getResultat());
					}
					System.out.println("==============================================");
				}
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
