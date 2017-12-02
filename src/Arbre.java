import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de stocker la formule et de la calculer
 */
public abstract class Arbre {

	List<Arbre> fils = new ArrayList<>();
	
	/**
	 * Renvoie le résultat du noeud actuel en faisant les opérations de ses fils
	 * @throws Exception 
	 */
	public abstract double getResultat() throws Exception;

}