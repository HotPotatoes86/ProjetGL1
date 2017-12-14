package prog.results;

/**
 * Permet de stocker la valeur numerique de la cellule
 * Peut effectuer les operations de base avec les classes filles de resultat
 */
public abstract class Resultat {

	//------------------------------------------Addition-------------------------------------------//
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
	
	//-------------------------------------------Soustraction-------------------------------------------//
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
	
	//-------------------------------------------Multiplication-------------------------------------------//
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
	
	//-------------------------------------------Division-------------------------------------------//
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
	
	//-------------------------------------------Inferieur-------------------------------------------//
	/**
	 * Renvoie vrai si le resultat actuel est inferieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur au resultat en parametre
	 */
	public abstract boolean estInferieur(ResultatDouble res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur au resultat en parametre
	 */
	public abstract boolean estInferieur(ResultatBoolean res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur au resultat en parametre
	 */
	public abstract boolean estInferieur(ResultatString res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur au resultat en parametre
	 */
	public abstract boolean estInferieur(ResultatErreur res);
	
	//-------------------------------------------Inferieur Egal-------------------------------------------//
	/**
	 * Renvoie vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 */
	public abstract boolean estInferieurOuEgal(ResultatDouble res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 */
	public abstract boolean estInferieurOuEgal(ResultatBoolean res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 */
	public abstract boolean estInferieurOuEgal(ResultatString res);
	
	/**
	 * Renvoie vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est inferieur ou egal au resultat en parametre
	 */
	public abstract boolean estInferieurOuEgal(ResultatErreur res);
	
	//-------------------------------------------Superieur-------------------------------------------//
	/**
	 * Renvoie vrai si le resultat actuel est superieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieur(ResultatDouble res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieur(ResultatBoolean res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieur(ResultatString res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieur(ResultatErreur res);
	
	//-------------------------------------------Superieur Egal-------------------------------------------//
	/**
	 * Renvoie vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieurOuEgal(ResultatDouble res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieurOuEgal(ResultatBoolean res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieurOuEgal(ResultatString res);
	
	/**
	 * Renvoie vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est superieur ou egal au resultat en parametre
	 */
	public abstract boolean estSuperieurOuEgal(ResultatErreur res);
	
	//-------------------------------------------Egal-------------------------------------------//
	/**
	 * Renvoie vrai si le resultat actuel est egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est  egal au resultat en parametre
	 */
	public abstract boolean estEgal(ResultatDouble res);
	
	/**
	 * Renvoie vrai si le resultat actuel est egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est  egal au resultat en parametre
	 */
	public abstract boolean estEgal(ResultatString res);
	
	/**
	 * Renvoie vrai si le resultat actuel est egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est  egal au resultat en parametre
	 */
	public abstract boolean estEgal(ResultatBoolean res);
	
	/**
	 * Renvoie vrai si le resultat actuel est egal au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est  egal au resultat en parametre
	 */
	public abstract boolean estEgal(ResultatErreur res);
	
	//-------------------------------------------Different-------------------------------------------//
	/**
	 * Renvoie vrai si le resultat actuel est different au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est different au resultat en parametre
	 */
	public abstract boolean estDifferent(ResultatDouble res);
	
	/**
	 * Renvoie vrai si le resultat actuel est different au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est different au resultat en parametre
	 */
	public abstract boolean estDifferent(ResultatString res);
	
	/**
	 * Renvoie vrai si le resultat actuel est different au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est different au resultat en parametre
	 */
	public abstract boolean estDifferent(ResultatBoolean res);
	
	/**
	 * Renvoie vrai si le resultat actuel est different au resultat en parametre
	 * @param res resultat a comparer au resultat actuel
	 * @return vrai si le resultat actuel est different au resultat en parametre
	 */
	public abstract boolean estDifferent(ResultatErreur res);
	

}
