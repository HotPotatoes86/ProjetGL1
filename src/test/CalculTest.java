package test;

import prog.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculTest {

	@Test
	public final void testCalcul(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","1+2");
		try {
			cont.editerCellule(c.getName(),c.getFormule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c.getResultat().getStringResultat().equalsIgnoreCase("3"));
	}
	
	@Test
	public final void testCalculSqrt(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","sqrt(25)");
		try {
			cont.editerCellule(c.getName(),c.getFormule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c.getResultat().getStringResultat().equalsIgnoreCase("5"));
	}
	
	@Test
	public final void testCalculMin(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","min(1,2,3)");
		try {
			cont.editerCellule(c.getName(),c.getFormule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c.getResultat().getStringResultat().equalsIgnoreCase("1"));
	}
	
	@Test
	public final void testCalculRef(){
		Conteneur cont = new Conteneur();
		Cellule c1 = new Cellule("cel1","1+1");
		Cellule c2 = new Cellule("cel2","$cel1+2");
		try {
			cont.editerCellule(c1.getName(),c1.getFormule());
			cont.editerCellule(c2.getName(),c2.getFormule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c1.getResultat().getStringResultat().equalsIgnoreCase("2"));
		assertTrue("Résultat de la cellule calculée",c2.getResultat().getStringResultat().equalsIgnoreCase("4"));
	}
}
