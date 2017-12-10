package prog;

import java.util.ArrayList;
import java.util.List;

/**
 * Cellules contenues dans le conteneur, permet d'y attribuer des formules qui
 * seront stockees et calculees en donnee numerique
 */
public class Cellule {

	private List<Cellule> cellsNeedMe;
	private List<Cellule> cellsUsed;
	private Resultat resultat;
	/**
	 * Valeur textuelle de la cellule
	 */
	private String formule;
	/**
	 * Boolean permettant de savoir s'il y a une valeur numerique a la cellule
	 */
	private boolean isNumeric = false;
	/**
	 * Nom de la cellule
	 */
	private String name;

	/**
	 * Constructeur de la classe, initialise les attributs de la classe
	 * 
	 * @param nom
	 *            Nom de la cellule
	 * @param formule
	 *            Valeur textuelle attribuee a la cellule
	 */
	public Cellule(String nom, String formule) {
		this.name = nom;
		this.formule = formule;
		this.isNumeric = false;
		this.cellsNeedMe = new ArrayList<>();
		this.cellsUsed = new ArrayList<>();
	}

	/**
	 * Recalcule la valeur numerique de la cellule
	 * 
	 * @param conteneur
	 *            Conteneur qui contient la cellule
	 * @throws Exception 
	 */
	public void actualise(Conteneur conteneur) throws Exception {
		Calcul c = new Calcul(this,conteneur);
		c.calcul();
	}

	/**
	 * Permet de supprimer la cellule en parametre de l'attribut CellsNeedMe de la
	 * cellule courante
	 * 
	 * @param cellule
	 *            Cellule qui sera supprimer de la liste CellsNeedMe
	 */
	public void oublier(Cellule cellule) {
		this.cellsNeedMe.remove(cellule);
	}

	/**
	 * Ajoute a la liste cellsUsed les cellules utilisees dans la formule
	 * 
	 * @param cellule
	 *            Cellule a ajouter a la liste des cellules cellsUsed
	 */
	public void addToCellsUsed(Cellule cellule) {
		this.cellsUsed.add(cellule);
	}

	/**
	 * 	Vide la liste cellsUsed
	 */
	public void clearCellsUsed() {
		this.cellsUsed.clear();
	}

	/**
	 * ajoute la cellule "cellule" dans la liste des cellules qui l'utilisent
	 * 
	 * @param cellule
	 *            cellule a ajouter a la liste
	 */
	public void addToCellsNeedMe(Cellule cellule) {
		this.cellsNeedMe.add(cellule);
	}

	/**
	 * Modifie la valeur de l'attribut formule
	 * 
	 * @param formule
	 *            Valeur a saisir dans la cellule
	 */
	public void setFormule(String formule) {
		this.formule = formule;
		this.isNumeric = false;
	}

	/**
	 * retourne la valeur textuelle stockee dans la cellule
	 */
	public String getFormule() {
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
	public String getName() {
		return this.name;
	}

	/**
	 * Renvoie l'attribue "resultat"
	 */
	public Resultat getResultat() {
		return this.resultat;
	}
	
	/**
	 * Renvoie les cellules utilisees
	 */
	public List<Cellule> getCellsUsed() {
		return this.cellsUsed;
	}
	
	/**
	 * Modifie l'attribut resultat
	 * 
	 * @param resultat
	 *            resultat de la formule dans la cellule
	 */
	public void setResultat(Resultat resultat) {
		this.resultat = resultat;
		if (this.resultat!=null) this.isNumeric=true;
	}

}
