package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatErreur;
import prog.results.ResultatInteger;

public class Moyenne extends Fonction{
	
	List<Resultat> args = new ArrayList<>();

	Resultat res;
	
	public Moyenne(List<Resultat> lval) {
		args = lval;
		if (lval.size()<=0) {
			res = new ResultatErreur();
		}else {
			Resultat tmp = lval.get(0); 
			for (int i=1; i<lval.size(); i++) {
				if (lval.get(i) instanceof ResultatErreur || lval.get(i) instanceof ResultatBoolean) {
					tmp = new ResultatErreur();
				}else{
					tmp = tmp.addition(lval.get(i));
				}
	
			}
			tmp = tmp.division(new ResultatInteger(lval.size()));
			res = tmp;
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
