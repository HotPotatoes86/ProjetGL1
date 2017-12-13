package prog;

public class Racine extends Arbre{

	public Racine(Arbre f) {
		this.fils.add(f);
	}

	@Override
	public Resultat getResultat() throws Exception {
		if (this.fils.size()>0) return this.fils.get(0).getResultat();
		return null;
	}

}
