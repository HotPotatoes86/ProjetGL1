package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Tangente extends Fonction{
	
	ResultatDouble res;

	public Tangente(ResultatDouble arg) {
		res = new ResultatDouble(Math.tan(arg.getValue()));
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
