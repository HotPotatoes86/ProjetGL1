import java.util.*;

/**
 * Entitée qui regroupe toutes les cellules
 */
public class Conteneur {

	Collection<Cellule> cellules;

	/**
	 * Constructeur de la classe conteneur, crée un conteneur de cellules vide
	 */
	public Conteneur() {
		// TODO - implement Conteneur.Conteneur
		throw new UnsupportedOperationException();
	}

	/**
	 * Recherche une cellule. Si elle existe, la fonction la renvoie, sinon la fonction crée une cellule vierge et la retourne
	 * @param nom Nom d'une cellule
	 */
	public Cellule getCellule(string nom) {
		// TODO - implement Conteneur.getCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * ajoute la cellule qui a été retourné par extractInformation(String)
	 * @param cellule Valeur à saisir dans la cellule
	 */
	public void addCellule(Cellule cellule) {
		// TODO - implement Conteneur.addCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * méthode permettant d'éditer une cellule en passant au conteneur son nom et sa nouvelle formule
	 * @param nom nom de la cellule à éditer
	 * @param formule formule à donner à la cellule
	 */
	public void editerCellule(string nom, string formule) {
		// TODO - implement Conteneur.editerCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * Enlève la cellule du conteneur et la détruit
	 * @param cellule nom de la cellule
	 */
	public void removeCellule(string cellule) {
		// TODO - implement Conteneur.removeCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne la liste des cellules contenues dans le conteneur
	 */
	public List<Cellule> getAllCellules() {
		// TODO - implement Conteneur.getAllCellules
		throw new UnsupportedOperationException();
	}

}