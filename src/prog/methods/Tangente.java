package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Tangente implements Operation{
	
	ResultatDouble res;

	public Tangente(ResultatDouble arg) {
		res = new ResultatDouble(Math.tan(arg.getValue()));
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
