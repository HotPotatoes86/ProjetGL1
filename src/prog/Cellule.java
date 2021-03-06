package prog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatErreur;

/**
 * Cellules contenues dans le conteneur, permet d'y attribuer des formules qui
 * seront stockees et calculees en donnee numerique
 */
public class Cellule {

	/**
	 * Cellules qui utilisent une reference sur la cellule courante
	 */
	private List<Cellule> cellsNeedMe;
	/**
	 * Cellules qui sont utilisees dans la formule de la cellule courante
	 */
	private List<Cellule> cellsUsed;
	/**
	 *	Resultat du calcul a partir de la formule de la cellule
	 */
	private Resultat resultat;
	/**
	 * Valeur textuelle de la cellule
	 */
	private String formule;
	/**
	 * Nom de la cellule
	 */
	private String name;
	/**
	 * Permet de savoir si la cellule est en cours de calcul, permet d'eviter les conflits
	 */
	private Boolean enCalcul;

	/**
	 * Constructeur de la classe, initialise les attributs de la classe
	 * 
	 * @param nom Nom de la cellule
	 * @param formule Valeur textuelle attribuee a la cellule
	 */
	public Cellule(String nom, String formule) {
		this.name = nom;
		this.formule = formule;
		this.cellsNeedMe = new ArrayList<>();
		this.cellsUsed = new ArrayList<>();
		this.resultat=new ResultatErreur();
		this.enCalcul = false;
	}

	/**
	 * Recalcule la valeur numerique de la cellule
	 * 
	 * @param conteneur Conteneur qui contient la cellule
	 * @throws Exception 
	 * @throws IOException 
	 */
	public void actualise(Conteneur conteneur) throws IOException, Exception {
		conteneur.editerCellule(this.name, this.formule);
	}

	/**
	 * Permet de supprimer la cellule en parametre de l'attribut CellsNeedMe de la
	 * cellule courante
	 * 
	 * @param cellule Cellule qui sera supprimer de la liste CellsNeedMe
	 */
	public void oublier(Cellule cellule) {
		this.cellsNeedMe.remove(cellule);
	}

	/**
	 * Ajoute a la liste cellsUsed les cellules utilisees dans la formule
	 * 
	 * @param cellule Cellule a ajouter a la liste des cellules cellsUsed
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
	 * @param cellule cellule a ajouter a la liste
	 */
	public void addToCellsNeedMe(Cellule cellule) {
		this.cellsNeedMe.add(cellule);
	}

	/**
	 * Modifie la valeur de l'attribut formule
	 * 
	 * @param formule Valeur a saisir dans la cellule
	 */
	public void setFormule(String formule) {
		this.formule = formule;
	}

	/**
	 * retourne la valeur textuelle stockee dans la cellule
	 */
	public String getFormule() {
		return this.formule;
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
	 * Renvoie les cellules qui utilisent la cellule courante
	 */
	public List<Cellule> getCellsNeedMe() {
		return this.cellsNeedMe;
	}
	
	/**
	 * Modifie l'attribut resultat
	 * 
	 * @param resultat resultat de la formule dans la cellule
	 */
	public void setResultat(Resultat resultat) {
		this.resultat = resultat;
	}

	/**
	 *	Getter sur l'attribut en calcul
	 *	@return l'attribut en calcul
	 */
	public Boolean getEnCalcul()
	{
		return this.enCalcul;
	}

	/**
	 *	Setter sur l'attribut en calcul
	 *	@param c valeur attribuee a l'attribut
	 */
	public void setEnCalcul(Boolean c)
	{
		this.enCalcul = c;
	}

}
