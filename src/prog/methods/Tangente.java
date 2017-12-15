package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;
import prog.results.ResultatInteger;

public class Tangente extends Fonction{
	
	Resultat res;

	public Tangente(Resultat rval) {
		if (res instanceof ResultatDouble) {
			res = new ResultatDouble(Math.tan(((ResultatDouble)rval).getValue()));
		}else if (res instanceof ResultatInteger) {
			res = new ResultatDouble(Math.tan(((ResultatInteger)rval).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
