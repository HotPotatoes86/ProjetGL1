package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;
import prog.results.ResultatInteger;

public class Asinus extends Fonction{
	
	Resultat res;

	public Asinus(Resultat rval) {
		if (rval instanceof ResultatDouble) {
			res = new ResultatDouble(Math.asin(((ResultatDouble)rval).getValue()));
		}else if (rval instanceof ResultatInteger) {
			res = new ResultatDouble(Math.asin(((ResultatInteger)rval).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
