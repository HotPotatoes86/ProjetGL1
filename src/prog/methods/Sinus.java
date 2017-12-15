package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Sinus implements Fonction{
	
	ResultatDouble res;

	public Sinus(ResultatDouble arg) {
		res = new ResultatDouble(Math.sin(arg.getValue()));
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
