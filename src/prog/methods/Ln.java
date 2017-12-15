package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Ln extends Fonction{

	ResultatDouble res;
	
	public Ln(ResultatDouble arg) {
		res = new ResultatDouble(Math.log(arg.getValue()));
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
