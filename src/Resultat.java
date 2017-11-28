/**
 * Permet de stocker la valeur numerique de la cellule
 */
public class Resultat {

	/**
	 * valeur d'une cellule
	 */
	private double value;

	/**
	 * Constructeur de la classe
	 * @param resultat Valeur attribuee a l'attribut resultat
	 */
	public Resultat(double resultat) {
		value = resultat;
	}

	/**
	 * Retourne le resultat sous la forme d'un double
	 */
	public double getResultat() {
		return value;
	}

}