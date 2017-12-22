package test;

import static org.junit.Assert.*;
import org.junit.Test;
import prog.Conteneur;

public class ConteneurTest {

	@Test
	public final void editerCellule(){
		Conteneur c = new Conteneur();
		try {
			c.editerCellule("cel", "val");
			c.editerCellule("cel", "newval");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("cellule presente dans conteneur",c.getCellule("cel")!=null);
		assertTrue("valeur de cellule modifiee",c.getCellule("cel").getFormule().compareTo("newval")==0);
	}
	
	@Test
	public final void removeCellule(){
		Conteneur c = new Conteneur();
		try {
			c.editerCellule("cel", "val");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("cellule presente dans conteneur",c.getCellule("cel")!=null);
		c.removeCellule("cel");
		assertTrue("cellule supprimee du conteneur",c.getAllCellules().isEmpty());
	}
}
