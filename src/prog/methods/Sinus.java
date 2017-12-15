package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;
import prog.results.ResultatInteger;

public class Sinus extends Fonction{
	
	Resultat res;

	public Sinus(Resultat rval) {
		if (res instanceof ResultatDouble) {
			res = new ResultatDouble(Math.sin(((ResultatDouble)rval).getValue()));
		}else if (res instanceof ResultatInteger) {
			res = new ResultatDouble(Math.sin(((ResultatInteger)rval).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
