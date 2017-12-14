package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.*;

public class Cosinus implements Operation{
	
	List<Resultat> args = new ArrayList<>();

	@Override
	public Resultat getResultat() {
		return new ResultatDouble(Math.cos(Math.toRadians((ResultatDouble)args.get(0).getResultat())));
	}

	@Override
	public void setArgs(List<Resultat> args) {
		for (Resultat arg : args) {
			this.args.add(arg);
		}
	}

}
