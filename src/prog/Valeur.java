package prog;

public class Valeur extends Arbre {

	/**
	 * valeur de la case
	 */
	private Resultat resultat;

	/**
	 * Constructeur de la classe Valeur, définit une valeur numérique
	 * @param valeur Valeur attribuée à l'attribut resultat
	 */
	public Valeur(Resultat valeur) {
		this.resultat = valeur;
	}

	/**
	 * Renvoie le résultat du noeud actuel en faisant les opérations de ses fils
	 */
	public Resultat getResultat() {
		return this.resultat;
	}

}
