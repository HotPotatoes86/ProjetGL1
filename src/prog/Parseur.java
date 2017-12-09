package prog;

import java.util.List;

/**
 * Classe permettant la communication entre le systeme et le stockage pour les fonctionnalit�s "Charger" et "Sauvegarder"
 */
public final class Parseur {

	/**
	 * Extrait les donn�es du fichier nlb et cr�e une cellule correspondante
	 * @param line Ligne du fichier texte qui est interpr�t�
	 */
	public static Cellule extractLine(String line) {
		String name = "";
		Cellule res = null;
		for (int i=0; i<line.length(); i++) {
			if (line.charAt(i)=='|') {
					name += line.charAt(i);
			}else {
				res = new Cellule(name,line.substring(i, line.length()-1));
			}
		}
		return res;
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
	 * effectue une concat�nation de ses deux param�tres afin d'obtenir un nom de la forme : nomColonne_x
	 * @param nomColonne nom de la colonne dans la base de donn�es
	 * @param x num�ro de ligne
	 */
	public static String createNom(String nomColonne, int x) {
		// TODO - implement Parseur.createNom
		throw new UnsupportedOperationException();
	}

}
