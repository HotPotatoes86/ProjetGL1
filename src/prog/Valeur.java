package prog;

public class Valeur extends Arbre {

	/**
	 * valeur de la case
	 */
	private double resultat;

	/**
	 * Constructeur de la classe Valeur, définit une valeur numérique
	 * @param valeur Valeur attribuée à l'attribut resultat
	 */
	public Valeur(double valeur) {
		this.resultat = valeur;
	}

	/**
	 * Renvoie le résultat du noeud actuel en faisant les opérations de ses fils
	 */
	public double getResultat() {
		return this.resultat;
	}

}
