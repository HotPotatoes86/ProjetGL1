package prog;

import java.io.IOException;
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
	 * @throws IOException 
	 * @throws Exception 
	 */
	public void addCellule(Cellule cellule) throws IOException, Exception {
		if (this.cellules.contains(cellule)){
			this.editerCellule(cellule.getName(), cellule.getFormule());
		}else{
			this.cellules.add(cellule);
		}
	}

	/**
	 * methode permettant d'editer une cellule en passant au conteneur son nom et sa nouvelle formule
	 * @param nom nom de la cellule a editer
	 * @param formule formule a donner a la cellule
	 * @throws IOException 
	 * @throws Exception 
	 */
	public void editerCellule(String nom, String formule) throws IOException, Exception {
		if (verifieNom(nom)) {
			Cellule cellToEdit = getCellule(nom);
			if(cellToEdit != null) {
				cellToEdit.setFormule(formule);
				for (Cellule cellAOublier : cellToEdit.getCellsUsed()) {
					cellAOublier.oublier(cellToEdit);
				}
				cellToEdit.clearCellsUsed();
			}else {
				cellToEdit = new Cellule(nom,formule);
				this.addCellule(cellToEdit);
			}
			Calcul calc = new Calcul(cellToEdit,this);
			calc.calcul();
			//necessaire de copier la liste car elle peut etre modifiee par le calcul
			List<Cellule> cpy = new ArrayList<>(cellToEdit.getCellsNeedMe());
			for (Cellule c : cpy) {
				if (!c.equals(cellToEdit)) {
					c.actualise(this);
				}
			}
		}else {
			throw new Exception("Nom de cellule incorrect");
		}
	}
	
	/**
	 * Verifie si le nom de la cellule est correct, c'est a dire s'il commence par une lettre et ne contient que les lettres, chiffres ou '_'
	 * @param nom nom de la cellule que l'on verifie
	 * @return true si le nom est correct, sinon false
	 */
	private boolean verifieNom(String nom) {
		if (nom.length()>0) {
			if ((nom.charAt(0)>='a' && nom.charAt(0)<='z') || (nom.charAt(0)>='A' && nom.charAt(0)<='Z')) {
				for (int i=1; i<nom.length(); i++) {
					if (!((nom.charAt(i)>='a' && nom.charAt(i)<='z') || (nom.charAt(i)>='A' && nom.charAt(i)<='Z') || (nom.charAt(i)>='0' && nom.charAt(i)<='9') || nom.charAt(i)=='_')){
						return false;
					}
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
		return true;
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
