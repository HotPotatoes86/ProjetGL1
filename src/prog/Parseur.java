package prog;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatErreur;

/**
 * Classe permettant la communication entre le systeme et le stockage pour les fonctionnalit�s "Charger" et "Sauvegarder"
 */
public final class Parseur {

	/**
	 * Creer l'arbre contenant les operations a effectueur, communique avec la
	 * grammaire
	 * 
	 * @throws ParsingException
	 * @throws Exception
	 */
	public static Resultat formuleToResultat(String formule, Conteneur conteneur) {
		// � utiliser pour passer le conteneur au Parser pour pouvoir extraire le r�sultat � partir d'une r�f�rence
		//return Parser.formuleToResultat(formule, conteneur);
		Parser yyparser;
		yyparser = new Parser(new StringReader(formule));
		if (yyparser.yyparse()==0) {
			return Parser.resultat;
		}else {
			return new ResultatErreur();
		}
	}
	
	/**
	 * Extrait les donn�es du fichier nlb et cr�e une cellule correspondante
	 * @param line Ligne du fichier texte qui est interpr�t�
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static Cellule extractLine(String line) throws IOException, Exception {
		return ParserExtract.extractCelluleFromLine(line);
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
