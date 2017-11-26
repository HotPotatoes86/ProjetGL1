/**
 * Contient la liste des opérations possibles
 */
public class Operation extends Arbre {

	/**
	 * Resultat de l'operation
	 */
	private double resultat;

	/**
	 * Constructeur de la classe Operation, crée un noeud dans l'arbre contenant l'opération et ses opérandes
	 * @param operation operation (min, max, +, -, ...) sous forme de string qui sera analysée par la classe
	 * @param operandes operandes de l'opération de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(string operation, Arbre operandes) {
		// TODO - implement Operation.Operation
		throw new UnsupportedOperationException();
	}

	/**
	 * Renvoie le résultat du noeud actuel en faisant les opérations de ses fils
	 */
	public double getResultat() {
		return this.resultat;
	}

}