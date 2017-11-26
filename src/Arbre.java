import java.util.*;

/**
 * Classe permettant de stocker la formule et de la calculer
 */
public abstract class Arbre {

	Collection<Arbre> fils;

	/**
	 * Renvoie le résultat du noeud actuel en faisant les opérations de ses fils
	 */
	public abstract double getResultat();

}