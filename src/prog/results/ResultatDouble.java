package prog.results;

public class ResultatDouble extends Resultat{

	/**
	 * valeur d'une cellule
	 */
	private double value;

	/**
	 * Constructeur de la classe
	 * @param resultat Valeur attribuee a l'attribut resultat
	 */
	public ResultatDouble(double resultat) {
		value = resultat;
	}

	/**
	 * Retourne le resultat sous la forme d'un double
	 */
	public double getResultat() {
		return value;
	}

	@Override
	public Resultat addition(ResultatDouble res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat addition(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat addition(ResultatString res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStringResultat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat soustraction(ResultatDouble res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat soustraction(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat soustraction(ResultatString res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat multiplication(ResultatDouble res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat multiplication(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat multiplication(ResultatString res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat division(ResultatDouble res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat division(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultat division(ResultatString res) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
