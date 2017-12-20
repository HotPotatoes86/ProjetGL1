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
		System.out.println(lval.size());
		if (lval.size() < 2) {
			res = new ResultatErreur();
		}else {
			if (!(lval.get(0) instanceof ResultatString)) {
				res = new ResultatErreur();
			}else {
				res = lval.get(0);
				for(int i = 1; i < lval.size(); i++)
					res = res.addition(lval.get(i));
			}
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
