package prog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe communiquant avec la grammaire pour interpreter les formules et
 * calculer un resultat
 */
public class Calcul {

	/**
	 * Verifie la formule et renvoie vrai s'elle est correct
	 * 
	 * @param formule
	 *            Valeur textuelle de la cellule a verifier pour voir si le calcul
	 *            est correct
	 * @param conteneur
	 *            Conteneur contenant la cellule a calculer (sert a verifier
	 *            l'existence des cellules vers lesquelles il y a des references)
	 */
	public static boolean formuleCorrect(String formule, Conteneur conteneur) {
		// TODO - implement Calcul.formuleCorrect
		throw new UnsupportedOperationException();
	}

	/**
	 * Permet d'effectuer le calcul a partir d'une donnee textuelle(formule), cree une
	 * instance de la classe Resultat (qui peut contenir plusieurs types de valeurs
	 * : float, double, int...)
	 * 
	 * @param cellule
	 *            Cellule a calculer
	 * @param conteneur
	 *            Conteneur contenant la cellule a calculer
	 * @throws Exception 
	 */
	public static void calcul(Cellule cellule, Conteneur conteneur) throws Exception {
		
		String formule = cellule.getFormule();
		
		boolean possible = formuleCorrect(formule, conteneur);
		
		if(possible) {
			List<Cellule> refs = extractRef(formule,conteneur);
			for (Cellule celluleRef : refs) {
				if(!celluleRef.getIsNumeric()) {
					celluleRef.actualise(conteneur);
				}
				celluleRef.addToCellsNeedMe(cellule);
				cellule.addToCellsUsed(celluleRef);
			}
			Arbre arbre = creerArbre();
			double resultatArbre = arbre.getResultat();
			cellule.setResultat(new Resultat(resultatArbre));
		}else {
			cellule.setResultat(null);
		}
	}

	/**
	 * Cree une liste de cellules vers laquelle la formule fait reference
	 * 
	 * @param formule
	 *            Formule de la cellule en cours
	 * @param conteneur
	 *            Conteneur contenant les cellules
	 */
	public static List<Cellule> extractRef(String formule, Conteneur conteneur) {
		List<Cellule> res = new ArrayList<>();
		List<Character> stopChar = Arrays.asList('+','-','*',')',',','/'); //caractere possible apres une reference
		boolean found = false; //quand on trouve un $, cela signifie qu'il y a une reference d'une cellule
		String name = "";
		for (int i=0; i<formule.length(); i++) {
			if (!found && formule.charAt(i) == '$') {
				name = "";
				found = true;
			//on s'arrete quand on est au derniere caractere ou qu'on a trouve un caractere de fin
			}else if (found && (stopChar.contains(formule.charAt(i)) || i==(formule.length()-1))) {
				found = false;
				Cellule c = conteneur.getCellule(name);
				if (c!=null) res.add(c);
			}else if (found) {
				name += formule.charAt(i);
			}
		}
		return res;
	}

	/**
	 * Creer l'arbre contenant les operations a effectueur, communique avec la
	 * grammaire
	 */
	private static Arbre creerArbre() {
		// TODO - implement Calcul.creerArbre
		throw new UnsupportedOperationException();
	}

}
