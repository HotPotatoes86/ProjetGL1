package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Sqrt implements Operation{
	
	ResultatDouble res;

	public Sqrt(ResultatDouble arg) {
		res = new ResultatDouble(Math.sqrt(arg.getValue()));
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
