package prog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Cette classe sert � communiquer avec les syst�mes de sauvegarde, elle permet de charger et de sauvegarder depuis et vers un fichier nlb, ainsi que charger les donn�es depuis une base de donn�es.
 */
public final class SaveManager {

	/**
	 * Importe une base de donn�e grace � une requete
	 * @param requete requete sql permettant de r�cup�rer une table depuis une base de donn�es
	 */
	public static Conteneur importBase(String requete) {
		// TODO - implement SaveManager.importBase
		throw new UnsupportedOperationException();
	}

	/**
	 * Cette fonction permet au parseur de lire le fichier (.nlb) et de cr�er les cellules correspondantes dans un conteneur qu'il aura cr��
	 * @param chemin
	 * @throws Exception 
	 */
	public static Conteneur ImportFile(String chemin) throws Exception {
		Conteneur res = new Conteneur();
	    BufferedReader reader = new BufferedReader(new FileReader(chemin));
	    String line;
	    while ((line = reader.readLine()) != null){
	      Cellule c = Parseur.extractLine(line);
	      if (c!=null) res.addCellule(c);
	    }
	    reader.close();
	    return res;
	}

	/**
	 * Permet de sauvegarder les donn�es dans un fichier .nlb
	 * @param chemin Chemin de sauvegarde du fichier
	 * @param conteneur
	 * @throws IOException 
	 */
	public static void sauvegarde(String chemin, Conteneur conteneur) throws IOException {
		PrintWriter writer = new PrintWriter(chemin, "UTF-8");
		for (Cellule c : conteneur.getAllCellules()) {
			writer.println(c.getName()+"|"+c.getFormule());
		}
		writer.close();
	}

}
