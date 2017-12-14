package prog.results;

/**
 * Permet de stocker la valeur numerique de la cellule
 */
public abstract class Resultat {

	/**
	 * Retourne la valeur du resultat sous forme de string
	 * @return la valeur du resultat sous forme de string
	 */
	public abstract String getStringResultat();
	
	/**
	 * Methode d'addition avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat addition(ResultatDouble res);
	
	/**
	 * Methode d'addition avec un resultat boolean
	 * @param res le resultat boolean a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat addition(ResultatBoolean res);
	
	/**
	 * Methode d'addition avec un resultat string
	 * @param res le resultat string a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat addition(ResultatString res);
	
	/**
	 * Methode d'addition avec un resultat erreur
	 * @param res le resultat erreur a ajouter
	 * @return le resultat de l'operation
	 */
	public Resultat addition(ResultatErreur res) {
		return res;
	}
	
	/**
	 * Methode soustraction avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat soustraction(ResultatDouble res);
	
	/**
	 * Methode soustraction avec un resultat boolean
	 * @param res le resultat boolean a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat soustraction(ResultatBoolean res);
	
	/**
	 * Methode soustraction avec un resultat string
	 * @param res le resultat string a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat soustraction(ResultatString res);
	
	/**
	 * Methode soustraction avec un resultat erreur
	 * @param res le resultat erreur a ajouter
	 * @return le resultat de l'operation
	 */
	public Resultat soustraction(ResultatErreur res) {
		return res;
	}
	
	/**
	 * Methode multiplication avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat multiplication(ResultatDouble res);
	
	/**
	 * Methode multiplication avec un resultat boolean
	 * @param res le resultat boolean a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat multiplication(ResultatBoolean res);
	
	/**
	 * Methode multiplication avec un resultat string
	 * @param res le resultat string a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat multiplication(ResultatString res);
	
	/**
	 * Methode multiplication avec un resultat erreur
	 * @param res le resultat erreur a ajouter
	 * @return le resultat de l'operation
	 */
	public Resultat multiplication(ResultatErreur res) {
		return res;
	}
	
	/**
	 * Methode division avec un resultat double
	 * @param res le resultat double a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat division(ResultatDouble res);
	
	/**
	 * Methode division avec un resultat boolean
	 * @param res le resultat boolean a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat division(ResultatBoolean res);
	
	/**
	 * Methode division avec un resultat string
	 * @param res le resultat string a ajouter
	 * @return le resultat de l'operation
	 */
	public abstract Resultat division(ResultatString res);
	
	/**
	 * Methode division avec un resultat erreur
	 * @param res le resultat erreur a ajouter
	 * @return le resultat de l'operation
	 */
	public Resultat division(ResultatErreur res) {
		return res;
	}

}
