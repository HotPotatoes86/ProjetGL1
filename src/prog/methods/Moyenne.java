package prog.methods;

import java.util.ArrayList;
import java.util.List;

import prog.Traitement;

public class Moyenne implements Traitement{
	
	List<Double> args = new ArrayList<>();

	@Override
	public double getResultat() {
		double somme = 0;
		for (Double arg : args) {
			somme += arg;
		}
		return somme/args.size();
	}

	@Override
	public void setArgs(List<Double> args) {
		for (double arg : args) {
			this.args.add(arg);
		}
	}

}
