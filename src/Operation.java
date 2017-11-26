/**
 * Contient la liste des op�rations possibles
 */
public class Operation extends Arbre {

	/**
	 * Resultat de l'operation
	 */
	private double resultat;

	/**
	 * Constructeur de la classe Operation, cr�e un noeud dans l'arbre contenant l'op�ration et ses op�randes
	 * @param operation operation (min, max, +, -, ...) sous forme de string qui sera analys�e par la classe
	 * @param operandes operandes de l'op�ration de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(string operation, Arbre operandes) {
		// TODO - implement Operation.Operation
		throw new UnsupportedOperationException();
	}

	/**
	 * Renvoie le r�sultat du noeud actuel en faisant les op�rations de ses fils
	 */
	public double getResultat() {
		return this.resultat;
	}

}