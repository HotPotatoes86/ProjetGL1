package prog;

public class Valeur extends Arbre {

	/**
	 * valeur de la case
	 */
	private Resultat resultat;

	/**
	 * Constructeur de la classe Valeur, d�finit une valeur num�rique
	 * @param valeur Valeur attribu�e � l'attribut resultat
	 */
	public Valeur(Resultat valeur) {
		this.resultat = valeur;
	}

	/**
	 * Renvoie le r�sultat du noeud actuel en faisant les op�rations de ses fils
	 */
	public Resultat getResultat() {
		return this.resultat;
	}

}
