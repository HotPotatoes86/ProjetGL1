import java.util.*;

/**
 * Classe permettant de stocker la formule et de la calculer
 */
public abstract class Arbre {

	Collection<Arbre> fils;

	/**
	 * Renvoie le r�sultat du noeud actuel en faisant les op�rations de ses fils
	 */
	public abstract double getResultat();

}