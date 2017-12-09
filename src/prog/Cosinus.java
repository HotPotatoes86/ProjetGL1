package methods;

import java.util.ArrayList;
import java.util.List;

import prog.Traitement;

public class Cosinus implements Traitement{
	
	List<Double> args = new ArrayList<>();

	@Override
	public double getResultat() {
		return Math.cos(Math.toRadians(args.get(0)));
	}

	@Override
	public void setArgs(List<Double> args) {
		for (double arg : args) {
			this.args.add(arg);
		}
	}

}