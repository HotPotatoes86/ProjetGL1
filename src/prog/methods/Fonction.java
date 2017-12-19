package prog.methods;

import prog.results.Resultat;

/**
 * Classe mere pour les fonctions pouvant etre utilisees (comme cos ou sin par exemple)
 * @author Groupe 4
 *
 */
public abstract class Fonction {
	
	protected Resultat res;
	
	public abstract Resultat getResultat();

}
