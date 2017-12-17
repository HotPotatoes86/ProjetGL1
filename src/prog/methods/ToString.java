package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatString;
import prog.results.ResultatErreur;

public class ToString extends Fonction{

	Resultat res;
	
	public ToString(Resultat arg) {
		if (arg instanceof ResultatErreur) {
			res = new ResultatErreur();
		}else {
			res = new ResultatString(arg.getStringResultat());
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
