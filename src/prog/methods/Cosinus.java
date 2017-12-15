package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Cosinus implements Fonction{
	
	ResultatDouble res;

	public Cosinus(ResultatDouble arg) {
		res = new ResultatDouble(Math.cos(arg.getValue()));
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
