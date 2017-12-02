import java.util.List;

/**
 * Classe permettant la communication entre le systeme et le stockage pour les fonctionnalit�s "Charger" et "Sauvegarder"
 */
public final class Parseur {

	/**
	 * Extrait les donn�es du fichier nlb et cr�e une cellule correspondante
	 * @param line Ligne du fichier texte qui est interpr�t�
	 */
	public static Cellule extractFile(String line) {
		// TODO - implement Parseur.extractFile
		throw new UnsupportedOperationException();
	}

	/**
	 * Extrait les informations d'une ligne de la base de donn�es pour cr�er une cellule correspondante
	 * @param requete requete vers la base de donn�es
	 */
	public static Conteneur extractBase(String requete) {
		// TODO - implement Parseur.extractBase
		throw new UnsupportedOperationException();
	}

	/**
	 * Extrait de la base de donn�es les noms des champs de la table qui serviront � cr�er un nom pour les cellules
	 */
	public static List<String> extractChamps() {
		// TODO - implement Parseur.extractChamps
		throw new UnsupportedOperationException();
	}

	/**
	 * m�thode qui va extraire le nom et la formule de la ligne, cr�e une cellule et la retourne.
	 */
	public static Cellule getCelluleFromLine() {
		// TODO - implement Parseur.getCelluleFromLine
		throw new UnsupportedOperationException();
	}

	/**
	 * effectue une concat�nation de ses deux param�tres afin d'obtenir un nom de la forme : nomColonne_x
	 * @param nomColonne nom de la colonne dans la base de donn�es
	 * @param x num�ro de ligne
	 */
	public static String createNom(String nomColonne, int x) {
		// TODO - implement Parseur.createNom
		throw new UnsupportedOperationException();
	}

}