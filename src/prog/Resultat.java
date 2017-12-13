package prog;

/**
 * Permet de stocker la valeur numerique de la cellule
 */
public abstract class Resultat {

	public abstract Resultat addition(ResultatDouble res);
	
	public abstract Resultat addition(ResultatBoolean res);
	
	public abstract Resultat addition(ResultatString res);
	
	public abstract Resultat addition(ResultatErreur res);

}
