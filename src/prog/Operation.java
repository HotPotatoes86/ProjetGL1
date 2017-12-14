package prog;

import java.util.List;

/**
 * Contient la liste des operations possibles
 */
public class Operation {
	
	/**
	 * Resultat de l'operation
	 */
	private double resultat;
	
	private String operation;
	
	protected Traitement traitement;

	/**
	 * Constructeur de la classe Operation, cree un noeud dans l'arbre contenant l'operation et ses operandes
	 * @param operation operation (min, max, +, -, ...) sous forme de String qui sera analysee par la classe
	 * @param operandes operandes de l'operation de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(String operation, Traitement traitement) {
		this.operation = operation;
		this.traitement = traitement;
	}

	/**
	 * Renvoie le resultat du traitement de l'operation
	 */
	public double getResultat() {
		return traitement.getResultat();
	}
	
	/**
	 * enregistre les arguments qui seront utilises par getResultat()
	 * @param args
	 */
	public void setArgs(List<Double> args) {
		traitement.setArgs(args);
	}

}
