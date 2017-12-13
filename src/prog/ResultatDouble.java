package prog;

public class ResultatDouble {

	/**
	 * valeur d'une cellule
	 */
	private double value;

	/**
	 * Constructeur de la classe
	 * @param resultat Valeur attribuee a l'attribut resultat
	 */
	public ResultatDouble(double resultat) {
		value = resultat;
	}

	/**
	 * Retourne le resultat sous la forme d'un double
	 */
	public double getResultat() {
		return value;
	}
	
}
