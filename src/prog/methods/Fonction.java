package prog.methods;

import prog.results.Resultat;

/**
 * Classe mere pour les fonctions pouvant etre utilisees (comme cos ou sin par exemple)
 * @author Groupe 4
 *
 */
public abstract class Fonction {
	
	/**
	 *	Resutat de la fonction
	 */
	protected Resultat res;
	
	/**
	 *	Renvoie le resultat obtenu par la fonction
	 *	@return le resultat obtenu par la fonction
	 */
	public abstract Resultat getResultat();

}
