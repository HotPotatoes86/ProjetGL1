package prog.methods;

import prog.results.*;

public class Acosinus extends Fonction{
	
	Resultat res;

	public Acosinus(Resultat rval) {
		if (rval instanceof ResultatDouble) {
			res = new ResultatDouble(Math.acos(((ResultatDouble)rval).getValue()));
		}else if (rval instanceof ResultatInteger) {
			res = new ResultatDouble(Math.acos(((ResultatInteger)rval).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
