package prog.results;

public class ResultatString extends Resultat{

	/**
	 * valeur du resultat
	 */
	private String value;

	/**
	 * Constructeur de la classe
	 * @param resultat Valeur attribuee a l'attribut resultat
	 */
	public ResultatString(String resultat) {
		value = resultat;
	}

	/**
	 * Retourne le resultat sous la forme d'un double
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public String getStringResultat() {
		return value;
	}

	@Override
	public Resultat addition(ResultatDouble res) {
		return new ResultatString(value + res.getValue());
	}

	@Override
	public Resultat addition(ResultatBoolean res) {
		return new ResultatString(value + res.getValue());
	}

	@Override
	public Resultat addition(ResultatString res) {
		return new ResultatString(value + res.getValue());
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
		return false;
	}

	@Override
	public boolean estInferieur(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estInferieur(ResultatString res) {
		return false;
	}

	@Override
	public boolean estInferieur(ResultatErreur res) {
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatDouble res) {
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatString res) {
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(ResultatErreur res) {
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatDouble res) {
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatString res) {
		return false;
	}

	@Override
	public boolean estSuperieur(ResultatErreur res) {
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatDouble res) {
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatString res) {
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(ResultatErreur res) {
		return false;
	}

	@Override
	public boolean estEgal(ResultatDouble res) {
		return false;
	}

	@Override
	public boolean estEgal(ResultatString res) {
		return (value==res.value);
	}

	@Override
	public boolean estEgal(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estEgal(ResultatErreur res) {
		return false;
	}

	@Override
	public boolean estDifferent(ResultatDouble res) {
		return false;
	}

	@Override
	public boolean estDifferent(ResultatString res) {
		return (value!=res.value);
	}

	@Override
	public boolean estDifferent(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estDifferent(ResultatErreur res) {
		return false;
	}
}
