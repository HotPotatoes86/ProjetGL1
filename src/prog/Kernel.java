package prog;

import java.io.IOException;
import java.sql.SQLException;

public final class Kernel {

	/**
	 * Conteneur sur lequel on travaille
	 */
	private static Conteneur conteneur = new Conteneur();
	
	/**
	 * Permet d'editer (ou creer) une cellule contenue dans le conteneur
	 * @param nom nom de la cellule 
	 * @param formule formule de la cellule
	 * @throws IOException
	 * @throws Exception
	 */
	public static void editer(String nom, String formule) throws IOException, Exception{
		conteneur.editerCellule(nom, formule);
	}
	
	/**
	 * Permet l'importation depuis un fichier stocke dans le systeme
	 * @param chemin chemin du fichier incluant le nom (juste le nom du fichier pour l'importer depuis le dossier courant)
	 * @throws Exception
	 */
	public static void importerFichier(String chemin) throws Exception{
		conteneur = SaveManager.ImportFile(chemin);
	}
	
	/**
	 * Permet l'importation depuis un fichier stocke dans le systeme
	 * @param chemin chemin du fichier (vide pour importer depuis repertoire courant)
	 * @param nom nom du fichier a importer
	 * @throws Exception
	 */
	public static void importerFichier(String chemin, String nom) throws Exception{
		conteneur = SaveManager.ImportFile(chemin+nom);
	}
	
	/**
	 * Permet l'importation depuis une base de donnees
	 * @param requete requete sql pour recuperer les donnees de la base
	 * @param url url de la base
	 * @param user nom d'utilisateur pour se connecter a la base
	 * @param password mot de passe pour se connecter a la base
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void importerBase(String requete, String url, String user, String password) throws ClassNotFoundException, SQLException{
		conteneur = SaveManager.ImportBase(requete, url, user, password);
	}
	
	/**
	 * Sauvegarde avec chemin qui inclut le nom 
	 * @param chemin chemin du fichier incluant le nom (juste le nom du fichier pour le sauvegarder dans le dossier courant)
	 * @throws IOException
	 */
	public static void sauvegarder(String chemin) throws IOException{
		SaveManager.sauvegarde(chemin, conteneur);
	}
	
	/**
	 * Sauvegarde avec chemin + nom
	 * @param chemin chemin du fichier (vide pour dossier courant)
	 * @param nom nom du fichier
	 * @throws IOException
	 */
	public static void sauvegarder(String chemin, String nom) throws IOException{
		SaveManager.sauvegarde(chemin+nom, conteneur);
	}
	
	/**
	 * Retourne le conteneur sur lequel on travaille
	 * @return le conteneur sur lequel on travaille
	 */
	public static Conteneur getConteneur(){
		return conteneur;
	}
	
}
