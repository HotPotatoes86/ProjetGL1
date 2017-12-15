import prog.Cellule;
import prog.Conteneur;

public class Main {

	public static void main(String[] args) {
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","8*2");
		try {
			System.out.println("Main");
			cont.editerCellule(c.getName(),c.getFormule());
			cont.editerCellule("cel2","$cel+1");
			cont.editerCellule("cel3", "sqrt(25)");
			System.out.println(cont.getCellule("cel").getResultat().getStringResultat());
			//System.out.println(cont.getCellule("cel2").getResultat().getStringResultat());	//TODO ExtractRef
			System.out.println(cont.getCellule("cel3").getResultat().getStringResultat());
			System.out.println("Main");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
