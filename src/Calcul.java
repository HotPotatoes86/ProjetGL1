package calcul;

import java.util.List;

import cells.Cellule;
import cells.Conteneur;
import cells.Resultat;

/**
 * Classe communiquant avec la grammaire pour interpréter les formules et
 * calculer un resultat
 */
public class Calcul {

	/**
	 * Verifie la formule et renvoie vrai s'elle est correct
	 * 
	 * @param formule
	 *            Valeur textuelle de la cellule a verifier pour voir si le calcul
	 *            est correct
	 * @param conteneur
	 *            Conteneur contenant la cellule à calculer (sert à vérifier
	 *            l'existence des cellules vers lesquelles il y a des références)
	 */
	public static boolean formuleCorrect(String formule, Conteneur conteneur) {
		// TODO - implement Calcul.formuleCorrect
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet d'effectuer le calcul a partir d'une donnee textuelle(formule), cree une
	 * instance de la classe Résultat (qui peut contenir plusieurs types de valeurs
	 * : float, double, int...)
	 * 
	 * @param cellule
	 *            Cellule à calculer
	 * @param conteneur
	 *            Conteneur contenant la cellule à calculer
	 */
	public static void calcul(Cellule cellule, Conteneur conteneur) {
		
		String formule = cellule.getFormule();
		
		boolean possible = formuleCorrect(formule, conteneur);
		
		if(possible) {
			List<Cellule> refs = extractRef(formule,conteneur);
			for (Cellule celluleRef : refs) {
				if(!celluleRef.getIsNumeric()) {
					celluleRef.actualise(conteneur);
				}
				celluleRef.addToCellsNeedMe(cellule);
				cellule.addToCellsUsed(celluleRef);
			}
			Arbre arbre = creerArbre();
			double resultatArbre = arbre.getResultat();
			cellule.setResultat(new Resultat(resultatArbre));
		}else {
			cellule.setResultat(null);
		}
	}

	/**
	 * Crée une liste de cellules vers laquelle la formule fait référence
	 * 
	 * @param formule
	 *            Formule de la cellule en cours
	 * @param conteneur
	 *            Conteneur contenant les cellules
	 */
	public static List<Cellule> extractRef(String formule, Conteneur conteneur) {
		// TODO - implement Calcul.extractRef
		throw new UnsupportedOperationException();
	}

	/**
	 * Créer l'arbre contenant les opérations à effectueur, communique avec la
	 * grammaire
	 */
	private static Arbre creerArbre() {
		// TODO - implement Calcul.creerArbre
		throw new UnsupportedOperationException();
	}

}