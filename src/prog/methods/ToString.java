package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatString;
import prog.results.ResultatErreur;

public class ToString extends Fonction{
	
	public ToString(Resultat arg) {
		if (arg instanceof ResultatErreur) {
			res = new ResultatErreur();
		}else {
			res = new ResultatString(arg.toString());
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
