package test;

import prog.*;
import prog.results.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculTest {

	@Test
	public final void testCalcul(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","1+2");
		try {
			cont.editerCellule(c.getName(),c.getFormule());
			cont.editerCellule("cel2", "10%2");
			cont.editerCellule("cel3", "1+2*2");
			cont.editerCellule("cel4", "8-4/2");
			cont.editerCellule("cel5", "5/2");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel").getResultat().toString().equalsIgnoreCase("3"));
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("0"));
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel3").getResultat().toString().equalsIgnoreCase("5"));
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel4").getResultat().toString().equalsIgnoreCase("6.0"));
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel5").getResultat().toString().equalsIgnoreCase("2.5"));
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
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel").getResultat().toString().equalsIgnoreCase("5.0"));
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
		assertTrue("Resultat de la cellule calculee",cont.getCellule("cel").getResultat().toString().equalsIgnoreCase("1"));
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
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().toString().equalsIgnoreCase("2"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("4"));
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
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().toString().equalsIgnoreCase("4"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("6"));
	}
	
	@Test
	public final void testCalculRef3(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","1+1");
		Cellule c1 = new Cellule("cel1","1+@cel");
		Cellule c2 = new Cellule("cel2","@cel1+2");
		try {
			cont.editerCellule(c.getName(), c.getFormule());
			cont.editerCellule(c1.getName(),c1.getFormule());
			cont.editerCellule(c2.getName(),c2.getFormule());
			cont.editerCellule(c.getName(), "4");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel0",cont.getCellule("cel").getResultat().toString().equalsIgnoreCase("4"));
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().toString().equalsIgnoreCase("5"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("7"));
	}
	
	@Test
	public final void testCalculRef4(){
		Conteneur cont = new Conteneur();
		Cellule c = new Cellule("cel","1+1");
		Cellule c1 = new Cellule("cel1","1+@test");
		try {
			cont.editerCellule(c.getName(), c.getFormule());
			cont.editerCellule(c1.getName(),c1.getFormule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel0",cont.getCellule("cel").getResultat().toString().equalsIgnoreCase("2"));
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat() instanceof ResultatErreur);
	}
	
	@Test
	public final void testLen() {
		Conteneur cont = new Conteneur();
		try {
			cont.editerCellule("cel1", "len(\"mot\")");
			cont.editerCellule("cel2", "len(45)");
		}catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().toString().equalsIgnoreCase("3"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat() instanceof ResultatErreur);
	}
	
	@Test
	public final void testSqrt() {
		Conteneur cont = new Conteneur();
		try {
			cont.editerCellule("cel1", "sqrt(\"mot\")");
			cont.editerCellule("cel2", "sqrt(25)");
		}catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("5.0"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel1").getResultat() instanceof ResultatErreur);
	}
	
	@Test
	public final void testPow() {
		Conteneur cont = new Conteneur();
		try {
			cont.editerCellule("cel1", "pow(\"mot\")");
			cont.editerCellule("cel2", "5^2");
			cont.editerCellule("cel3", "pow(5,2)");
		}catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("25"));
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel3").getResultat().toString().equalsIgnoreCase("25"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel1").getResultat() instanceof ResultatErreur);
	}
	
	@Test
	public final void testConcat() {
		Conteneur cont = new Conteneur();
		try {
			cont.editerCellule("cel1", "concat(\"mot\",25)");
			cont.editerCellule("cel2", "concat(\"mot\",\"mot\")");
			cont.editerCellule("cel3", "concat(25,\"mot\")");
			cont.editerCellule("cel4", "concat(\"mot\")");
		}catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel1").getResultat().toString().equalsIgnoreCase("mot25"));
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel2").getResultat().toString().equalsIgnoreCase("motmot"));
		assertTrue("Resultat de la cellule cel1",cont.getCellule("cel3").getResultat().toString().equalsIgnoreCase("25mot"));
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel4").getResultat() instanceof ResultatErreur);
	}
	
	@Test
	public final void testToNum() {
		Conteneur cont = new Conteneur();
		try {
			cont.editerCellule("cel1", "tonum(\"mot\")");
			cont.editerCellule("cel2", "tonum(\"5\")");
			cont.editerCellule("cel3", "tonum(\"5.0\")");
		}catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel1").getResultat() instanceof ResultatErreur);
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel2").getResultat() instanceof ResultatInteger);
		assertTrue("Resultat de la cellule cel2",cont.getCellule("cel3").getResultat() instanceof ResultatDouble);
	}
	
}
