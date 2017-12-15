package prog.results;

public class ResultatErreur extends Resultat {

	@Override
	public String getStringResultat() {
		return "#@!Erreur!@#";
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
		return false;
	}

	@Override
	public boolean estDifferent(Resultat res) {
		if (res instanceof ResultatErreur) return false;
		return true;
	}
}
