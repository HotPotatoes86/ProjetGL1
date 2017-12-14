package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.results.Resultat;
import prog.results.ResultatDouble;

public class Cosinus implements Operation{
	
	List<Resultat> args = new ArrayList<>();

	@Override
	public Resultat getResultat() {
		return new ResultatDouble(4);
	}

	@Override
	public void setArgs(List<Resultat> args) {
		for (Resultat arg : args) {
			this.args.add(arg);
		}
	}

}
