package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatErreur;
import prog.results.ResultatBoolean;

public class Minimum extends Fonction{
	
	List<Resultat> args = new ArrayList<>();
	
	public Minimum(List<Resultat> lval) {
		args = lval;
		if (lval.size()<=0) {
			res = new ResultatErreur();
		}else {
			Resultat tmp = lval.get(0); 
			for (int i=1; i<lval.size(); i++) {
				if (lval.get(i) instanceof ResultatErreur || lval.get(i) instanceof ResultatBoolean) {
					tmp = new ResultatErreur();
				}else{
					if (tmp.estSuperieur(lval.get(i))) tmp = lval.get(i);
				}
			}
			res = tmp;
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
