package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatInteger;
import prog.results.ResultatErreur;

public class Pow extends Fonction{
	
	List<Resultat> args = new ArrayList<>();
	
	public Pow(List<Resultat> lval) {
		args = lval;
		if (lval.size()<=0 || lval.size() > 2) {
			res = new ResultatErreur();
		}else {
			if (lval.get(0) instanceof ResultatDouble && lval.get(1) instanceof ResultatDouble) {
				res = new ResultatDouble(Math.pow(((ResultatDouble)lval.get(0)).getValue(), ((ResultatDouble)lval.get(1)).getValue()));
			}else if (lval.get(0) instanceof ResultatDouble && lval.get(1) instanceof ResultatInteger) {
				res = new ResultatDouble(Math.pow(((ResultatDouble)lval.get(0)).getValue(), ((ResultatInteger)lval.get(1)).getValue()));
			}else if (lval.get(0) instanceof ResultatInteger && lval.get(1) instanceof ResultatDouble) {
				res = new ResultatDouble(Math.pow(((ResultatInteger)lval.get(0)).getValue(), ((ResultatDouble)lval.get(1)).getValue()));
			}else if (lval.get(0) instanceof ResultatInteger && lval.get(1) instanceof ResultatInteger) {
				res = new ResultatDouble(Math.pow(((ResultatInteger)lval.get(0)).getValue(), ((ResultatInteger)lval.get(1)).getValue()));
			}else {
				res = new ResultatErreur();
			}
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
