package prog;

import java.util.List;

/**
 * Contient la liste des opérations possibles
 */
public class Operation {
	
	/**
	 * Resultat de l'operation
	 */
	private double resultat;
	
	private String operation;
	
	protected Traitement traitement;

	/**
	 * Constructeur de la classe Operation, crée un noeud dans l'arbre contenant l'opération et ses opérandes
	 * @param operation operation (min, max, +, -, ...) sous forme de String qui sera analysée par la classe
	 * @param operandes operandes de l'opération de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(String operation, Traitement traitement) {
		this.operation = operation;
		this.traitement = traitement;
	}

	/**
	 * Renvoie le résultat du traitement de l'opération
	 */
	public double getResultat() {
		return traitement.getResultat();
	}
	
	/**
	 * enregistre les arguments qui seront utilisés par getResultat()
	 * @param args
	 */
	public void setArgs(List<Double> args) {
		traitement.setArgs(args);
	}

}