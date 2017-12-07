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
			cont.addCellule(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c.getResultat().getResultat()==3);
	}
	
	@Test
	public final void testCalcul2(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","sqrt(25)");
		try {
			cont.addCellule(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c.getResultat().getResultat()==5);
	}
	
	@Test
	public final void testCalcul3(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","min(1,2,3)");
		try {
			cont.addCellule(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Résultat de la cellule calculée",c.getResultat().getResultat()==1);
	}
}
