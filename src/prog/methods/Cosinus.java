package prog.methods;

import prog.results.*;

public class Cosinus extends Fonction{
	
	Resultat res;

	public Cosinus(Resultat rval) {
		if (res instanceof ResultatDouble) {
			res = new ResultatDouble(Math.cos(((ResultatDouble)rval).getValue()));
		}else if (res instanceof ResultatInteger) {
			res = new ResultatDouble(Math.cos(((ResultatInteger)rval).getValue()));
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
