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
	public double getValue() {
		return value;
	}

	@Override
	public Resultat addition(ResultatDouble res) {
		return new ResultatDouble(res.getValue() + value);
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

	@Override
	public boolean estInferieur(ResultatDouble res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieur(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieur(ResultatString res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieur(ResultatErreur res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatDouble res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatString res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatErreur res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatDouble res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatString res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatErreur res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatDouble res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatString res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatErreur res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estEgal(ResultatDouble res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estEgal(ResultatString res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estEgal(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estEgal(ResultatErreur res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDifferent(ResultatDouble res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDifferent(ResultatString res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDifferent(ResultatBoolean res) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estDifferent(ResultatErreur res) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
