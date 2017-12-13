package prog;

public class ResultatString extends Resultat{

	/**
	 * valeur d'une cellule
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
	public String getResultat() {
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
	public Resultat addition(ResultatErreur res) {
		// TODO Auto-generated method stub
		return null;
	}
}
