package prog;

import java.util.ArrayList;
import java.util.List;

/**
 * Entitee qui regroupe toutes les cellules
 */
public class Conteneur {

	List<Cellule> cellules;

	/**
	 * Constructeur de la classe conteneur, cree un conteneur de cellules vide
	 */
	public Conteneur() {
		this.cellules = new ArrayList<>();
	}

	/**
	 * Recherche une cellule. Si elle existe, la fonction la renvoie, sinon la fonction cree une cellule vierge et la retourne
	 * @param nom Nom d'une cellule
	 */
	public Cellule getCellule(String nom) {
		Cellule res = null;
		for (Cellule c : this.cellules) {
			if (c.getName().equals(nom)) {
				res = c;
				break;
			}
		}
		return res;
	}

	/**
	 * ajoute la cellule qui a ete retourne par extractInformation(String)
	 * @param cellule Valeur a saisir dans la cellule
	 */
	public void addCellule(Cellule cellule) {
		this.cellules.add(cellule);
	}

	/**
	 * methode permettant d'editer une cellule en passant au conteneur son nom et sa nouvelle formule
	 * @param nom nom de la cellule a editer
	 * @param formule formule a donner a la cellule
	 * @throws Exception 
	 */
	public void editerCellule(String nom, String formule) throws Exception {
		
		Cellule cellToEdit = getCellule(nom);
		
		if(cellToEdit != null) {
			cellToEdit.setFormule(formule);
			for (Cellule cellAOublier : cellToEdit.getCellsUsed()) {
				cellAOublier.oublier(cellToEdit);
			}
			cellToEdit.clearCellsUsed();
		}else {
			cellToEdit = new Cellule(nom,formule);
		}
		
		Calcul.calcul(cellToEdit,this);
	}

	/**
	 * Enleve la cellule du conteneur et la detruit
	 * @param cellule nom de la cellule
	 */
	public void removeCellule(String cellule) {
		for (Cellule c : this.cellules) {
			if (c.getName().equals(cellule)) {
				this.cellules.remove(c);
			}
		}
	}

	/**
	 * Retourne la liste des cellules contenues dans le conteneur
	 */
	public List<Cellule> getAllCellules() {
		return this.cellules;
	}

}
