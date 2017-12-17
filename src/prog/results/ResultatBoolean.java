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
	public String toString() {
		return "" + value;
	}

	@Override
	public Resultat addition(Resultat res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat soustraction(Resultat res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(Resultat res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat division(Resultat res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat modulo(Resultat res) {
		return new ResultatErreur();
	}

	@Override
	public boolean estInferieur(Resultat res) {
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(Resultat res) {
		return false;
	}

	@Override
	public boolean estSuperieur(Resultat res) {
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(Resultat res) {
		return false;
	}

	@Override
	public boolean estEgal(Resultat res) {
		if (res instanceof ResultatBoolean) {
			return (value==((ResultatBoolean)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estDifferent(Resultat res) {
		if (res instanceof ResultatBoolean) {
			return (value!=((ResultatBoolean)res).getValue());
		}
		return false;
	}
}
