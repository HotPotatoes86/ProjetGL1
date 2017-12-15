package prog.results;

/**
 * Permet de stocker la valeur numerique de la cellule
 * Peut effectuer les operations de base avec les classes filles de resultat
 */
public abstract class Resultat {

	/**
	 * Retourne la valeur du resultat sous forme de string
	 * @return la valeur du resultat sous forme de string
	 */
	public abstract String getStringResultat();
	
	/**
	 * Methode d'addition avec un resultat
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat addition(Resultat res);
	
	/**
	 * Methode soustraction avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat soustraction(Resultat res);
	
	/**
	 * Methode multiplication avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat multiplication(Resultat res);
	
	/**
	 * Methode division avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat division(Resultat res);
	
	/**
	 * Methode modulo avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat modulo(Resultat res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur au resultat en parametre
	 */
	public abstract boolean estInferieur(Resultat res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 */
	public abstract boolean estInferieurOuEgal(Resultat res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieur(Resultat res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieurOuEgal(Resultat res);
	
	/**
	 * Renvoie vrai si le resultat actuel est egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est  egal au resultat en parametre
	 */
	public abstract boolean estEgal(Resultat res);
	
	/**
	 * Renvoie vrai si le resultat actuel est different au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est different au resultat en parametre
	 */
	public abstract boolean estDifferent(Resultat res);
}
