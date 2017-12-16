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
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel").getResultat().getStringResultat().equalsIgnoreCase("3"));
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
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel").getResultat().getStringResultat().equalsIgnoreCase("5.0"));
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
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel").getResultat().getStringResultat().equalsIgnoreCase("1"));
	}
	
	@Test
	public final void testCalculRef(){
		Conteneur cont = new Conteneur();
		Cellule c1 = new Cellule("cel1","1+1");
		Cellule c2 = new Cellule("cel2","@cel1+2");
		try {
			cont.editerCellule(c1.getName(),c1.getFormule());
			cont.editerCellule(c2.getName(),c2.getFormule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().getStringResultat().equalsIgnoreCase("2"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat().getStringResultat().equalsIgnoreCase("4"));
	}
	
	@Test
	public final void testCalculRef2(){
		Conteneur cont = new Conteneur();
		Cellule c1 = new Cellule("cel1","1+1");
		Cellule c2 = new Cellule("cel2","@cel1+2");
		try {
			cont.editerCellule(c1.getName(),c1.getFormule());
			cont.editerCellule(c2.getName(),c2.getFormule());
			cont.editerCellule(c1.getName(), "4");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().getStringResultat().equalsIgnoreCase("4"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat().getStringResultat().equalsIgnoreCase("6"));
	}
	
	@Test
	public final void testCalculRef3(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel0","1+1");
		Cellule c1 = new Cellule("cel1","1+@cel0");
		Cellule c2 = new Cellule("cel2","@cel1+2");
		try {
			cont.editerCellule(c.getName(), c.getFormule());
			cont.editerCellule(c1.getName(),c1.getFormule());
			cont.editerCellule(c2.getName(),c2.getFormule());
			cont.editerCellule(c.getName(), "4");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel0",cont.getCellule("cel0").getResultat().getStringResultat().equalsIgnoreCase("4"));
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().getStringResultat().equalsIgnoreCase("5"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat().getStringResultat().equalsIgnoreCase("7"));
	}
}
