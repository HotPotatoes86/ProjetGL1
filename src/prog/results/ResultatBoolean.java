package prog.results;

public class ResultatBoolean extends Resultat {

	/**
	 * valeur du resultat
	 */
	private boolean value;

	/**
	 * Constructeur de la classe
	 * @param resultat Valeur attribuee a l'attribut resultat
	 */
	public ResultatBoolean(boolean resultat) {
		value = resultat;
	}

	/**
	 * Retourne le resultat sous la forme d'un double
	 */
	public boolean getValue() {
		return value;
	}

	@Override
	public String getStringResultat() {
		return "" + value;
	}

	@Override
	public Resultat addition(ResultatDouble res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat addition(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat addition(ResultatString res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat addition(ResultatErreur res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat soustraction(ResultatDouble res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat soustraction(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat soustraction(ResultatString res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(ResultatDouble res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(ResultatString res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat division(ResultatDouble res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat division(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat division(ResultatString res) {
		return new ResultatErreur();
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
