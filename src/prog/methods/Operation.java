package prog.methods;

import java.util.List;

import prog.results.Resultat;

public interface Operation {
	
	public Resultat getResultat();
	
	public void setArgs(List<Resultat> args);

}
