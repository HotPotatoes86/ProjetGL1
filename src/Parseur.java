import java.util.List;

/**
 * Classe permettant la communication entre le systeme et le stockage pour les fonctionnalités "Charger" et "Sauvegarder"
 */
public final class Parseur {

	/**
	 * Extrait les données du fichier nlb et crée une cellule correspondante
	 * @param line Ligne du fichier texte qui est interprété
	 */
	public static Cellule extractFile(String line) {
		// TODO - implement Parseur.extractFile
		throw new UnsupportedOperationException();
	}

	/**
	 * Extrait les informations d'une ligne de la base de données pour créer une cellule correspondante
	 * @param requete requete vers la base de données
	 */
	public static Conteneur extractBase(String requete) {
		// TODO - implement Parseur.extractBase
		throw new UnsupportedOperationException();
	}

	/**
	 * Extrait de la base de données les noms des champs de la table qui serviront à créer un nom pour les cellules
	 */
	public static List<String> extractChamps() {
		// TODO - implement Parseur.extractChamps
		throw new UnsupportedOperationException();
	}

	/**
	 * méthode qui va extraire le nom et la formule de la ligne, crée une cellule et la retourne.
	 */
	public static Cellule getCelluleFromLine() {
		// TODO - implement Parseur.getCelluleFromLine
		throw new UnsupportedOperationException();
	}

	/**
	 * effectue une concaténation de ses deux paramètres afin d'obtenir un nom de la forme : nomColonne_x
	 * @param nomColonne nom de la colonne dans la base de données
	 * @param x numéro de ligne
	 */
	public static String createNom(String nomColonne, int x) {
		// TODO - implement Parseur.createNom
		throw new UnsupportedOperationException();
	}

}