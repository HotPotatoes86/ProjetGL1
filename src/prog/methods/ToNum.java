package prog.methods;

import prog.results.Resultat;
import prog.results.ResultatString;
import prog.results.ResultatInteger;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;

public class ToNum extends Fonction{

	Resultat res;
	
	public ToNum(Resultat arg) {
		if (arg instanceof ResultatString) {
			try{
				res = new ResultatInteger(Integer.parseInt(((ResultatString)arg).getValue()));
			}catch(NumberFormatException e){
				try{
					res = new ResultatDouble(Double.parseDouble(((ResultatString)arg).getValue()));
				}catch(NumberFormatException f){
					res = new ResultatErreur();
				}
			}
		}else {
			res = new ResultatErreur();
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
