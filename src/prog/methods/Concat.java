package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatString;
import prog.results.ResultatErreur;

public class Concat extends Fonction{
	
	List<Resultat> args = new ArrayList<>();
	
	public Concat(List<Resultat> lval) {
		args = lval;
		if (lval.size()<=0 || lval.size() > 2) {
			res = new ResultatErreur();
		}else {
			if (lval.get(0) instanceof ResultatString && lval.get(1) instanceof ResultatString) {
				res = lval.get(0).addition(lval.get(1));
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
