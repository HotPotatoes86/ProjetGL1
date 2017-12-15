package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatErreur;

public class Maximum extends Fonction{
	
	List<Resultat> args = new ArrayList<>();

	Resultat res;
	
	public Maximum(List<Resultat> lval) {
		args = lval;
		if (lval.size()<=0) {
			res = new ResultatErreur();
		}else {
			Resultat tmp = lval.get(0); 
			for (int i=1; i<lval.size(); i++) {
				if (tmp.estInferieur(lval.get(i))) tmp = lval.get(i);
			}
			res = tmp;
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
