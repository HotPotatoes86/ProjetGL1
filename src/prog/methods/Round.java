package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;
import prog.results.ResultatInteger;

public class Round extends Fonction{
	
	Resultat res;

	public Round(Resultat rval) {
		if (rval instanceof ResultatDouble) {
			res = new ResultatInteger((int)(Math.round(((ResultatDouble)rval).getValue())));
		}else if (rval instanceof ResultatInteger) {
			res = rval;
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
