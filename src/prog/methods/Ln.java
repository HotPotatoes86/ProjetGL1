package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;

public class Ln extends Fonction{

	Resultat res;
	
	public Ln(Resultat arg) {
		if (arg instanceof ResultatDouble) {
			res = new ResultatDouble(((ResultatDouble)arg).getValue());
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
