import java.util.*;

/**
 * Cellules contenues dans le conteneur, permet d'y attribuer des formules qui seront stockées et calculées en donnée numérique
 */
public class Cellule {

	Collection<Cellule> cellsNeedMe;
	Collection<Cellule> cellsUsed;
	Resultat resultat;
	/**
	 * Valeur textuelle de la cellule
	 */
	private string formule;
	/**
	 * Boolean permettant de savoir s'il y a une valeur numerique a la cellule
	 */
	private boolean isNumeric = false;
	/**
	 * Nom de la cellule
	 */
	private string nom;

	/**
	 * Constructeur de la classe, initialise les attributs de la classe
	 * @param nom Nom de la cellule
	 * @param formule Valeur textuelle attribuée à la cellule
	 */
	public Cellule(string nom, string formule) {
		// TODO - implement Cellule.Cellule
		throw new UnsupportedOperationException();
	}

	/**
	 * Recalcule la valeur numerique de la cellule
	 * @param conteneur Conteneur qui contient la cellule
	 */
	public void actualise(Conteneur conteneur) {
		// TODO - implement Cellule.actualise
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet de supprimer la cellule en paramètre de l'attribut CellsNeedMe de la cellule courante
	 * @param cellule Cellule qui sera supprimer de la liste CellsNeedMe 
	 */
	public void oublier(Cellule cellule) {
		// TODO - implement Cellule.oublier
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajoute a la liste cellsUsed les cellules utilisées dans la formule
	 * @param cellule Cellule à ajouter à la liste des cellules cellsUsed
	 */
	public void addToCellsUsed(Cellule cellule) {
		// TODO - implement Cellule.addToCellsUsed
		throw new UnsupportedOperationException();
	}

	/**
	 * vide la liste cellsUsed
	 */
	public void clearCellsUsed() {
		// TODO - implement Cellule.clearCellsUsed
		throw new UnsupportedOperationException();
	}

	/**
	 * ajoute la cellule "cellule" dans la liste des cellules qui l'utilisent
	 * @param cellule cellule à ajouter à la liste
	 */
	public void addToCellsNeedMe(Cellule cellule) {
		// TODO - implement Cellule.addToCellsNeedMe
		throw new UnsupportedOperationException();
	}

	/**
	 * Modifie la valeur de l'attribut formule
	 * @param formule Valeur à saisir dans la cellule
	 */
	public void setFormule(string formule) {
		this.formule = formule;
	}

	/**
	 * retourne la valeur textuelle stocké dans la cellule
	 */
	public string getFormule() {
		return this.formule;
	}

	/**
	 * Renvoie la valeur de l'attribut "isNumeric"
	 */
	public boolean getIsNumeric() {
		return this.isNumeric;
	}

	/**
	 * Retoune le nom de la cellule
	 */
	public string getName() {
		// TODO - implement Cellule.getName
		throw new UnsupportedOperationException();
	}

	/**
	 * Renvoie l'attribue "resultat"
	 */
	public Resultat getResultat() {
		return this.resultat;
	}

}