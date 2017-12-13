package prog;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de stocker la formule et de la calculer
 */
public abstract class Arbre {

	List<Arbre> fils = new ArrayList<>();
	
	/**
	 * Renvoie le resultat du noeud actuel en faisant les operations de ses fils
	 * @throws Exception 
	 */
	public abstract Resultat getResultat() throws Exception;

}
