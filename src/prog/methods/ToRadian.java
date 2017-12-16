package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;
import prog.results.ResultatInteger;

public class ToRadian extends Fonction{
	
	Resultat res;

	public ToRadian(Resultat rval) {
		if (rval instanceof ResultatDouble) {
			res = new ResultatDouble(Math.toRadians(((ResultatDouble)rval).getValue()));
		}else if (rval instanceof ResultatInteger) {
			res = new ResultatDouble(Math.toRadians(((ResultatInteger)rval).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
