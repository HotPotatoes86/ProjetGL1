package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatDouble;
import prog.results.ResultatErreur;

public class Moyenne extends Fonction{
	
	List<ResultatDouble> args = new ArrayList<>();

	Resultat res;
	
	public Moyenne(List<ResultatDouble> list) {
		args = list;
		if (list.size()<=0) {
			res = new ResultatErreur();
		}else {
			double tmp = list.get(0).getValue(); 
			for (int i=1; i<list.size(); i++) {
				tmp += list.get(i).getValue();
			}
			tmp /= list.size();
			res = new ResultatDouble(tmp);
		}
	}
	
	@Override
	public Resultat getResultat() {
		return res;
	}

}
