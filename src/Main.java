import prog.Cellule;
import prog.Conteneur;

public class Main {

	public static void main(String[] args) {
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel1","(1+3+1)*(2+2)");
		try {
			System.out.println("Main");
			cont.editerCellule(c.getName(),c.getFormule());
			cont.editerCellule("cel2","@cel1+1");
			cont.editerCellule("cel3", "cos(25)");
			System.out.println(cont.getCellule("cel1").getResultat().getStringResultat());
			System.out.println(cont.getCellule("cel2").getResultat().getStringResultat());
			System.out.println(cont.getCellule("cel3").getResultat().getStringResultat());
			System.out.println("Main");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
