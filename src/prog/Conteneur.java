package prog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Entitee qui regroupe toutes les cellules
 */
public class Conteneur {

	public List<Cellule> cellules;

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
		String patternString = "^[a-zA-Z][a-zA-Z0-9_]*";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(nom);
		if (matcher.matches())
			return true;
		else
			return false;
	}

	/**
	 * Enleve la cellule du conteneur et la detruit
	 * @param cellule nom de la cellule
	 */
	public void removeCellule(String cellule) {
		List<Cellule> tmp = new ArrayList<>();
		tmp.addAll(this.cellules);
		for (Cellule c : tmp) {
			if (c.getName().equals(cellule)) {
				this.cellules.remove(c);
			}
		}
	}

	/**
	 * Retourne un iterateur sur les cellules contenues dans le conteneur
	 * @return un iterateur sur les cellules contenues dans le conteneur
	 */
	public Iterator<Cellule> getCelluleIterator(){
		return this.cellules.iterator();
	}

}
