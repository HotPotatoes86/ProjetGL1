import java.util.List;

/**
 * Classe communiquant avec la grammaire pour interpr�ter les formules et
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
	 *            Conteneur contenant la cellule � calculer (sert � v�rifier
	 *            l'existence des cellules vers lesquelles il y a des r�f�rences)
	 */
	public boolean formuleCorrect(String formule, Conteneur conteneur) {
		// TODO - implement Calcul.formuleCorrect
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet d'effectuer le calcul a partir d'une donnee textuelle, renvoie une
	 * instance de la classe R�sultat (qui peut contenir plusieurs types de valeurs
	 * : float, double, int...)
	 * 
	 * @param formule
	 *            Valeur textuelle a calculer pour obtenir une donnee numerique
	 * @param conteneur
	 *            Conteneur contenant la cellule � calculer
	 */
	public Resultat calcul(String formule, Conteneur conteneur) {
		// TODO - implement Calcul.calcul
		throw new UnsupportedOperationException();
	}

	/**
	 * Cr�e une liste de cellules vers laquelle la formule fait r�f�rence
	 * 
	 * @param formule
	 *            Formule de la cellule en cours
	 * @param conteneur
	 *            Conteneur contenant les cellules
	 */
	public List<Cellule> extractRef(String formule, Conteneur conteneur) {
		// TODO - implement Calcul.extractRef
		throw new UnsupportedOperationException();
	}

	/**
	 * Cr�er l'arbre contenant les op�rations � effectueur, communique avec la
	 * grammaire
	 */
	private Arbre creerArbre() {
		// TODO - implement Calcul.creerArbre
		throw new UnsupportedOperationException();
	}

}