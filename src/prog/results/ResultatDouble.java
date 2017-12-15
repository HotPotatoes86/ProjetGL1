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
	public String getStringResultat() {
		return value+"";
	}

	@Override
	public Resultat addition(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatDouble(value+((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatDouble(value+((ResultatInteger)res).getValue());
		}else if (res instanceof ResultatString) {
			return new ResultatString(value+((ResultatString)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat soustraction(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatDouble(value-((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatDouble(value-((ResultatInteger)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatDouble(value*((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatDouble(value*((ResultatInteger)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat division(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatDouble(value/((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatDouble(value/((ResultatInteger)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat modulo(Resultat res) {
		return new ResultatErreur();
	}

	@Override
	public boolean estInferieur(Resultat res) {
		if (res instanceof ResultatDouble) {
			return (value<((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value<((ResultatInteger)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estInferieurOuEgal(Resultat res) {
		if (res instanceof ResultatDouble) {
			return (value<=((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value<=((ResultatInteger)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estSuperieur(Resultat res) {
		if (res instanceof ResultatDouble) {
			return (value>((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value>((ResultatInteger)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estSuperieurOuEgal(Resultat res) {
		if (res instanceof ResultatDouble) {
			return (value>=((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value>=((ResultatInteger)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estEgal(Resultat res) {
		if (res instanceof ResultatDouble) {
			return (value==((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value==((ResultatInteger)res).getValue());
		}
		return false;
	}

	@Override
	public boolean estDifferent(Resultat res) {
		if (res instanceof ResultatDouble) {
			return (value!=((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value!=((ResultatInteger)res).getValue());
		}
		return false;
	}
	
}
