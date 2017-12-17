package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatInteger;
import prog.results.ResultatErreur;

public class Ln extends Fonction{

	Resultat res;
	
	public Ln(Resultat arg) {
		if (arg instanceof ResultatDouble) {
			res = new ResultatDouble(Math.log1p(((ResultatDouble)arg).getValue()));
		}else if (arg instanceof ResultatInteger) {
			res = new ResultatDouble(Math.log1p(((ResultatInteger)arg).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
