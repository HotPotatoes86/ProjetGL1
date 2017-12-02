import java.util.List;

/**
 * Contient la liste des op�rations possibles
 */
public class Operation extends Arbre {
	
	/**
	 * Resultat de l'operation
	 */
	private double resultat;
	
	private String operation;

	/**
	 * Constructeur de la classe Operation, cr�e un noeud dans l'arbre contenant l'op�ration et ses op�randes
	 * @param operation operation (min, max, +, -, ...) sous forme de String qui sera analys�e par la classe
	 * @param operandes operandes de l'op�ration de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(String operation, List<Arbre> operandes) {
		for (Arbre a : operandes) {
			this.fils.add(a);
		}
		this.operation = operation;
	}

	/**
	 * Renvoie le r�sultat du noeud actuel en faisant les op�rations de ses fils
	 * @throws Exception 
	 */
	public double getResultat() throws Exception {
		switch(operation.toLowerCase()) {
		case "max": 
			if (this.fils.size()>1) {
				this.resultat = Math.max(this.fils.get(0).getResultat(),this.fils.get(1).getResultat());
			}else {
				throw new Exception("Pas assez d'op�randes pour l'op�ration max.");
			}
			break;
		case "min":
			if (this.fils.size()>1) {
				this.resultat = Math.min(this.fils.get(0).getResultat(),this.fils.get(1).getResultat());
			}else {
				throw new Exception("Pas assez d'op�randes pour l'op�ration min.");
			}
			break;
		case "moy":
			if (this.fils.size()>0) {
				for (Arbre a : this.fils) {
					this.resultat += a.getResultat();
				}
				this.resultat /= this.fils.size();
			}else {
				throw new Exception("Pas assez d'op�randes pour l'op�ration moy.");
			}
			break;
		case "sqrt":
			if (this.fils.size()>0) {
				this.resultat = Math.sqrt(this.fils.get(0).getResultat());
			}else {
				throw new Exception("Pas assez d'op�randes pour l'op�ration sqrt.");
			}
			break;
			//etc...
		}
		return this.resultat;
	}

}