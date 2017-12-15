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
	public String getStringResultat() {
		return value+"";
	}

	//------------------------------------------Addition-------------------------------------------//
	@Override
	public Resultat addition(ResultatDouble res) {
		return new ResultatDouble(value+res.getValue());
	}
	
	@Override
	public Resultat addition(ResultatInteger res) {
		return new ResultatInteger(value+res.getValue());
	}

	@Override
	public Resultat addition(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat addition(ResultatString res) {
		return new ResultatErreur();
	}

	
	//------------------------------------------Soustraction-------------------------------------------//
	@Override
	public Resultat soustraction(ResultatDouble res) {
		return new ResultatDouble(value-res.getValue());
	}
	
	@Override
	public Resultat soustraction(ResultatInteger res) {
		return new ResultatInteger(value-res.getValue());
	}

	@Override
	public Resultat soustraction(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat soustraction(ResultatString res) {
		return new ResultatErreur();
	}

	
	//------------------------------------------Multiplication-------------------------------------------//
	@Override
	public Resultat multiplication(ResultatDouble res) {
		return new ResultatDouble(value*res.getValue());
	}
	
	@Override
	public Resultat multiplication(ResultatInteger res) {
		return new ResultatInteger(value*res.getValue());
	}

	@Override
	public Resultat multiplication(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat multiplication(ResultatString res) {
		return new ResultatErreur();
	}
	
	
	//------------------------------------------Division-------------------------------------------//
	@Override
	public Resultat division(ResultatDouble res) {
		return new ResultatDouble(value/res.getValue());
	}
	
	@Override
	public Resultat division(ResultatInteger res) {
		return new ResultatInteger(value/res.getValue());
	}

	@Override
	public Resultat division(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat division(ResultatString res) {
		return new ResultatErreur();
	}

	
	//------------------------------------------Modulo-------------------------------------------//
	@Override
	public Resultat modulo(ResultatDouble res) {
		return new ResultatErreur();
	}
	
	@Override
	public Resultat modulo(ResultatInteger res) {
		return new ResultatInteger(Math.floorMod(value, res.getValue()));
	}

	@Override
	public Resultat modulo(ResultatBoolean res) {
		return new ResultatErreur();
	}

	@Override
	public Resultat modulo(ResultatString res) {
		return new ResultatErreur();
	}

	
	//------------------------------------------Inferieur-------------------------------------------//
	@Override
	public boolean estInferieur(ResultatDouble res) {
		return (value<res.getValue());
	}
	
	@Override
	public boolean estInferieur(ResultatInteger res) {
		return (value<res.getValue());
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

	
	//------------------------------------------Inferieur Egal-------------------------------------------//
	@Override
	public boolean estInferieurOuEgal(ResultatDouble res) {
		return (value<=res.getValue());
	}
	
	@Override
	public boolean estInferieurOuEgal(ResultatInteger res) {
		return (value<=res.getValue());
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

	
	//------------------------------------------Superieur-------------------------------------------//
	@Override
	public boolean estSuperieur(ResultatDouble res) {
		return (value>res.getValue());
	}
	
	@Override
	public boolean estSuperieur(ResultatInteger res) {
		return (value>res.getValue());
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

	
	//------------------------------------------Superieur Egal-------------------------------------------//
	@Override
	public boolean estSuperieurOuEgal(ResultatDouble res) {
		return (value>=res.getValue());
	}
	
	@Override
	public boolean estSuperieurOuEgal(ResultatInteger res) {
		return (value>=res.getValue());
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

	
	//------------------------------------------Egal-------------------------------------------//
	@Override
	public boolean estEgal(ResultatDouble res) {
		return (value==res.getValue());
	}
	
	@Override
	public boolean estEgal(ResultatInteger res) {
		return (value==res.getValue());
	}

	@Override
	public boolean estEgal(ResultatString res) {
		return false;
	}

	@Override
	public boolean estEgal(ResultatBoolean res) {
		return false;
	}

	@Override
	public boolean estEgal(ResultatErreur res) {
		return false;
	}

	
	//------------------------------------------Different-------------------------------------------//
	@Override
	public boolean estDifferent(ResultatDouble res) {
		return (value!=res.getValue());
	}
	
	@Override
	public boolean estDifferent(ResultatInteger res) {
		return (value!=res.getValue());
	}

	@Override
	public boolean estDifferent(ResultatString res) {
		return true;
	}

	@Override
	public boolean estDifferent(ResultatBoolean res) {
		return true;
	}

	@Override
	public boolean estDifferent(ResultatErreur res) {
		return true;
	}

}