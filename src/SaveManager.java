/**
 * Cette classe sert � communiquer avec les syst�mes de sauvegarde, elle permet de charger et de sauvegarder depuis et vers un fichier nlb, ainsi que charger les donn�es depuis une base de donn�es.
 */
public class SaveManager {

	/**
	 * Importe une base de donn�e grace � une requete
	 * @param requete requete sql permettant de r�cup�rer une table depuis une base de donn�es
	 */
	public Conteneur importBase(string requete) {
		// TODO - implement SaveManager.importBase
		throw new UnsupportedOperationException();
	}

	/**
	 * Cette fonction permet au parseur de lire le fichier (.nlb) et de cr�er les cellules correspondantes dans un conteneur qu'il aura cr��
	 * @param chemin
	 */
	public Conteneur ImportFile(string chemin) {
		// TODO - implement SaveManager.ImportFile
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet de sauvegarder les donn�es dans un fichier .nlb
	 * @param chemin Chemin de sauvegarde du fichier
	 * @param conteneur
	 */
	public void sauvegarde(string chemin, Conteneur conteneur) {
		// TODO - implement SaveManager.sauvegarde
		throw new UnsupportedOperationException();
	}

}