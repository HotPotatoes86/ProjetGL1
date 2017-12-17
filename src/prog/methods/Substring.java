package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatString;
import prog.results.ResultatInteger;
import prog.results.ResultatErreur;

public class Substring extends Fonction{
	
	List<Resultat> args = new ArrayList<>();

	Resultat res;
	
	public Substring(List<Resultat> lval) {
		args = lval;
		if (lval.size() <= 1 || lval.size() > 3) {
			res = new ResultatErreur();
		}else {
			if (lval.get(0) instanceof ResultatString) {
				if (lval.size() == 2 && lval.get(1) instanceof ResultatInteger){
					res = new ResultatString(((ResultatString)lval.get(0)).getValue().substring(((ResultatInteger)lval.get(1)).getValue()));
				}else if (lval.size() == 3 && lval.get(1) instanceof ResultatInteger && lval.get(2) instanceof ResultatInteger){
					res = new ResultatString(((ResultatString)lval.get(0)).getValue().substring(((ResultatInteger)lval.get(1)).getValue(), ((ResultatInteger)lval.get(2)).getValue()));
				}else {
					res = new ResultatErreur();
				}
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
