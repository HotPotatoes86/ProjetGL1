import java.util.List;

/**
 * Contient la liste des opérations possibles
 */
public class Operation extends Arbre {
	
	/**
	 * Resultat de l'operation
	 */
	private double resultat;
	
	private String operation;

	/**
	 * Constructeur de la classe Operation, crée un noeud dans l'arbre contenant l'opération et ses opérandes
	 * @param operation operation (min, max, +, -, ...) sous forme de String qui sera analysée par la classe
	 * @param operandes operandes de l'opération de type arbre (donc soit une operation soit une valeur)
	 */
	public Operation(String operation, List<Arbre> operandes) {
		for (Arbre a : operandes) {
			this.fils.add(a);
		}
		this.operation = operation;
	}

	/**
	 * Renvoie le résultat du noeud actuel en faisant les opérations de ses fils
	 * @throws Exception 
	 */
	public double getResultat() throws Exception {
		switch(operation.toLowerCase()) {
		case "max": 
			if (this.fils.size()>1) {
				this.resultat = Math.max(this.fils.get(0).getResultat(),this.fils.get(1).getResultat());
			}else {
				throw new Exception("Pas assez d'opérandes pour l'opération max.");
			}
			break;
		case "min":
			if (this.fils.size()>1) {
				this.resultat = Math.min(this.fils.get(0).getResultat(),this.fils.get(1).getResultat());
			}else {
				throw new Exception("Pas assez d'opérandes pour l'opération min.");
			}
			break;
		case "moy":
			if (this.fils.size()>0) {
				for (Arbre a : this.fils) {
					this.resultat += a.getResultat();
				}
				this.resultat /= this.fils.size();
			}else {
				throw new Exception("Pas assez d'opérandes pour l'opération moy.");
			}
			break;
		case "sqrt":
			if (this.fils.size()>0) {
				this.resultat = Math.sqrt(this.fils.get(0).getResultat());
			}else {
				throw new Exception("Pas assez d'opérandes pour l'opération sqrt.");
			}
			break;
			//etc...
		}
		return this.resultat;
	}

}