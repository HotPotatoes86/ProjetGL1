import java.util.ArrayList;
import java.util.List;

/**
 * Contient la liste des op�rations possibles
 */
public class Operation extends Arbre {

	List<Arbre> fils = new ArrayList<>();
	
	/**
	 * Resultat de l'operation
	 */
	private double resultat;
	
	private String operation;

	/**
	 * Constructeur de la classe Operation, cr�e un noeud dans l'arbre contenant l'op�ration et ses op�randes
	 * @param operation operation (min, max, +, -, ...) sous forme de String qui sera analys�e par la classe
	 * @param operandes operandes de l'op�ration de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(String operation, List<Arbre> operandes) {
		for (Arbre a : operandes) {
			this.fils.add(a);
		}
		this.operation = operation;
	}

	/**
	 * Renvoie le r�sultat du noeud actuel en faisant les op�rations de ses fils
	 */
	public double getResultat() {
		switch(operation.toLowerCase()) {
		case "max": 
			this.resultat = Math.max(this.fils.get(0).getResultat(),this.fils.get(1).getResultat());
			break;
		case "min":
			this.resultat = Math.min(this.fils.get(0).getResultat(),this.fils.get(1).getResultat());
			break;
			//etc...
		}
		return this.resultat;
	}

}