package methods;

import java.util.ArrayList;
import java.util.List;

import prog.Traitement;

public class Maximum implements Traitement{
	
	List<Double> args = new ArrayList<>();

	@Override
	public double getResultat() {
		double min = args.get(0);
		for(int i = 1; i < args.size(); i++) {
			if(args.get(i) < min)
				min = args.get(i);
		}
		return min;
	}

	@Override
	public void setArgs(List<Double> args) {
		for (double arg : args) {
			this.args.add(arg);
		}
	}

}
