package prog;

import java.util.List;

/**
 * Contient la liste des op�rations possibles
 */
public class Operation {
	
	/**
	 * Resultat de l'operation
	 */
	private double resultat;
	
	private String operation;
	
	protected Traitement traitement;

	/**
	 * Constructeur de la classe Operation, cr�e un noeud dans l'arbre contenant l'op�ration et ses op�randes
	 * @param operation operation (min, max, +, -, ...) sous forme de String qui sera analys�e par la classe
	 * @param operandes operandes de l'op�ration de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(String operation, Traitement traitement) {
		this.operation = operation;
		this.traitement = traitement;
	}

	/**
	 * Renvoie le r�sultat du traitement de l'op�ration
	 */
	public double getResultat() {
		return traitement.getResultat();
	}
	
	/**
	 * enregistre les arguments qui seront utilis�s par getResultat()
	 * @param args
	 */
	public void setArgs(List<Double> args) {
		traitement.setArgs(args);
	}

}