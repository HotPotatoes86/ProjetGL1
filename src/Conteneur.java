import java.util.ArrayList;
import java.util.List;

/**
 * Entitée qui regroupe toutes les cellules
 */
public class Conteneur {

	List<Cellule> cellules;

	/**
	 * Constructeur de la classe conteneur, crée un conteneur de cellules vide
	 */
	public Conteneur() {
		this.cellules = new ArrayList<>();
	}

	/**
	 * Recherche une cellule. Si elle existe, la fonction la renvoie, sinon la fonction crée une cellule vierge et la retourne
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
	 * ajoute la cellule qui a été retourné par extractInformation(String)
	 * @param cellule Valeur à saisir dans la cellule
	 */
	public void addCellule(Cellule cellule) {
		this.cellules.add(cellule);
	}

	/**
	 * méthode permettant d'éditer une cellule en passant au conteneur son nom et sa nouvelle formule
	 * @param nom nom de la cellule à éditer
	 * @param formule formule à donner à la cellule
	 */
	public void editerCellule(String nom, String formule) {
		// TODO - implement Conteneur.editerCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * Enlève la cellule du conteneur et la détruit
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