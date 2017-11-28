import java.util.ArrayList;
import java.util.List;

/**
 * Entit�e qui regroupe toutes les cellules
 */
public class Conteneur {

	List<Cellule> cellules;

	/**
	 * Constructeur de la classe conteneur, cr�e un conteneur de cellules vide
	 */
	public Conteneur() {
		this.cellules = new ArrayList<>();
	}

	/**
	 * Recherche une cellule. Si elle existe, la fonction la renvoie, sinon la fonction cr�e une cellule vierge et la retourne
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
	 * ajoute la cellule qui a �t� retourn� par extractInformation(String)
	 * @param cellule Valeur � saisir dans la cellule
	 */
	public void addCellule(Cellule cellule) {
		this.cellules.add(cellule);
	}

	/**
	 * m�thode permettant d'�diter une cellule en passant au conteneur son nom et sa nouvelle formule
	 * @param nom nom de la cellule � �diter
	 * @param formule formule � donner � la cellule
	 */
	public void editerCellule(String nom, String formule) {
		// TODO - implement Conteneur.editerCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * Enl�ve la cellule du conteneur et la d�truit
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