package prog;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe communiquant avec la grammaire pour interpreter les formules et
 * calculer un resultat
 */
public class Calcul {

	/**
	 * liste des references vers d'autres cellules
	 */
	List<Cellule> refs;
	
	/**
	 * formule a calculer
	 */
	String formule;
	
	/**
	 * cellule a modifier
	 */
	Cellule cellule;
	
	/**
	 * conteneur contenant la cellule
	 */
	Conteneur conteneur;
	
	public Calcul(Cellule cel, Conteneur cont) {
		formule = cel.getFormule();
		cellule = cel;
		conteneur = cont;
		refs = new ArrayList<>();
	}
	
	/**
	 * Verifie la formule et renvoie vrai s'elle est correct
	 * 
	 * @param formule
	 *            Valeur textuelle de la cellule a verifier pour voir si le calcul
	 *            est correct
	 * @param conteneur
	 *            Conteneur contenant la cellule a calculer (sert a verifier
	 *            l'existence des cellules vers lesquelles il y a des references)
	 */
	public boolean formuleCorrect(String formule, Conteneur conteneur) {
		return true;
	}

	/**
	 * Permet d'effectuer le calcul a partir d'une donnee textuelle(formule), cree
	 * une instance de la classe Resultat (qui peut contenir plusieurs types de
	 * valeurs : float, double, int...)
	 * 
	 * @param cellule
	 *            Cellule a calculer
	 * @param conteneur
	 *            Conteneur contenant la cellule a calculer
	 * @throws Exception
	 */
	public void calcul() throws Exception {
		boolean possible = formuleCorrect(formule, conteneur);
		if (possible) {
			extractRef();
			for (Cellule celluleRef : refs) {
				if (!celluleRef.getIsNumeric()) {
					celluleRef.actualise(conteneur);
				}
				if (celluleRef.getIsNumeric()) {
					celluleRef.addToCellsNeedMe(cellule);
					cellule.addToCellsUsed(celluleRef);
				} else {
					return;
				}
			}
			Arbre arbre = creerArbre();
			Resultat resultatArbre = arbre.getResultat();
			cellule.setResultat(resultatArbre);
		} else {
			cellule.setResultat(null);
		}
	}

	/**
	 * Cree une liste de cellules vers laquelle la formule fait reference
	 * 
	 * @param formule
	 *            Formule de la cellule en cours
	 * @param conteneur
	 *            Conteneur contenant les cellules
	 */
	public void extractRef() {
		refs = ParserExtract.extractRef(formule, conteneur);
	}

	/**
	 * Creer l'arbre contenant les operations a effectueur, communique avec la
	 * grammaire
	 * 
	 * @throws Exception
	 */
	private Arbre creerArbre() throws Exception {
		/*Parser yyparser;
		yyparser = new Parser(new StringReader(formule));
		if (yyparser.yyparse()==0) {
			return yyparser.getResultat();
		}else {
			return null;
		}*/
	}

}
