package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatString;
import prog.results.ResultatInteger;
import prog.results.ResultatErreur;

public class Len extends Fonction{
	
	public Len(Resultat arg) {
		if (arg instanceof ResultatString) {
			res = new ResultatInteger(((ResultatString)arg).getValue().length());
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
