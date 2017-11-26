import java.util.*;

/**
 * Entit�e qui regroupe toutes les cellules
 */
public class Conteneur {

	Collection<Cellule> cellules;

	/**
	 * Constructeur de la classe conteneur, cr�e un conteneur de cellules vide
	 */
	public Conteneur() {
		// TODO - implement Conteneur.Conteneur
		throw new UnsupportedOperationException();
	}

	/**
	 * Recherche une cellule. Si elle existe, la fonction la renvoie, sinon la fonction cr�e une cellule vierge et la retourne
	 * @param nom Nom d'une cellule
	 */
	public Cellule getCellule(string nom) {
		// TODO - implement Conteneur.getCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * ajoute la cellule qui a �t� retourn� par extractInformation(String)
	 * @param cellule Valeur � saisir dans la cellule
	 */
	public void addCellule(Cellule cellule) {
		// TODO - implement Conteneur.addCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * m�thode permettant d'�diter une cellule en passant au conteneur son nom et sa nouvelle formule
	 * @param nom nom de la cellule � �diter
	 * @param formule formule � donner � la cellule
	 */
	public void editerCellule(string nom, string formule) {
		// TODO - implement Conteneur.editerCellule
		throw new UnsupportedOperationException();
	}

	/**
	 * Enl�ve la cellule du conteneur et la d�truit
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