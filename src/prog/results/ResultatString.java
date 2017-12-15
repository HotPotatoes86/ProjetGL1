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
	public Resultat addition(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatString(value+((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatString(value+((ResultatInteger)res).getValue());
		}else if (res instanceof ResultatString) {
			return new ResultatString(value+((ResultatString)res).getValue());
		}
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
		if (res instanceof ResultatString) {
			return (value==((ResultatString)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estDifferent(Resultat res) {
		if (res instanceof ResultatString) {
			return (value!=((ResultatString)res).getValue());
		}
		return false;
	}
}
