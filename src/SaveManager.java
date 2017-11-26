/**
 * Cette classe sert à communiquer avec les systèmes de sauvegarde, elle permet de charger et de sauvegarder depuis et vers un fichier nlb, ainsi que charger les données depuis une base de données.
 */
public class SaveManager {

	/**
	 * Importe une base de donnée grace à une requete
	 * @param requete requete sql permettant de récupérer une table depuis une base de données
	 */
	public Conteneur importBase(string requete) {
		// TODO - implement SaveManager.importBase
		throw new UnsupportedOperationException();
	}

	/**
	 * Cette fonction permet au parseur de lire le fichier (.nlb) et de créer les cellules correspondantes dans un conteneur qu'il aura créé
	 * @param chemin
	 */
	public Conteneur ImportFile(string chemin) {
		// TODO - implement SaveManager.ImportFile
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet de sauvegarder les données dans un fichier .nlb
	 * @param chemin Chemin de sauvegarde du fichier
	 * @param conteneur
	 */
	public void sauvegarde(string chemin, Conteneur conteneur) {
		// TODO - implement SaveManager.sauvegarde
		throw new UnsupportedOperationException();
	}

}