package prog;

public class Racine extends Arbre{

	public Racine(Arbre f) {
		this.fils.add(f);
	}
	
	@Override
	public double getResultat() throws Exception {
		return this.fils.get(0).getResultat();
	}

}
