package prog;

import java.io.IOException;
import java.sql.SQLException;

public final class Kernel {

	private static Conteneur conteneur = new Conteneur();
	
	public static void editer(String nom, String formule) throws IOException, Exception{
		conteneur.editerCellule(nom, formule);
	}
	
	public static void importerFichier(String chemin) throws Exception{
		conteneur = SaveManager.ImportFile(chemin);
	}
	
	public static void importerBase(String requete, String url, String user, String password) throws ClassNotFoundException, SQLException{
		conteneur = SaveManager.ImportBase(requete, url, user, password);
	}
	
	public static void sauvegarder(String chemin) throws IOException{
		SaveManager.sauvegarde(chemin, conteneur);
	}
	
	public static Conteneur getConteneur(){
		return conteneur;
	}
	
}
