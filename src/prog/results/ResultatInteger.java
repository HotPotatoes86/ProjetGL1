package prog.results;

public class ResultatInteger extends Resultat{

	/**
	 * valeur du resultat
	 */
	private int value;
	
	/**
	 * Constructeur de la classe ResultatInteger
	 * @param val valeur attribuee a l'objet
	 */
	public ResultatInteger(int val) {
		value = val;
	}
	
	/**
	 * Retourne la valeur du resultat
	 * @return la valeur du resultat
	 */
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value+"";
	}

	@Override
	public Resultat addition(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatDouble(value+((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatInteger(value+((ResultatInteger)res).getValue());
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
			return new ResultatInteger(value-((ResultatInteger)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(Resultat res) {
		if (res instanceof ResultatDouble) {
			return new ResultatDouble(value*((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return new ResultatInteger(value*((ResultatInteger)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat division(Resultat res) {
		if (res instanceof ResultatDouble) {
			if (((ResultatDouble)res).getValue()==0) return new ResultatErreur();
			return new ResultatDouble(value/((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			if (((ResultatInteger)res).getValue()==0) return new ResultatErreur();
			return new ResultatDouble((double)value/((ResultatInteger)res).getValue());
		}
		return new ResultatErreur();
	}

	@Override
	public Resultat modulo(Resultat res) {
		if (res instanceof ResultatInteger) {
			return new ResultatInteger(Math.floorMod(value, ((ResultatInteger)res).getValue()));
		}
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
			return (value<=((ResultatDouble)res).getValue());
		}else if (res instanceof ResultatInteger) {
			return (value<=((ResultatInteger)res).getValue());
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
		return true;
	}
}
