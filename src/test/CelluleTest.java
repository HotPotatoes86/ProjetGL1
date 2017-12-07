package test;

import prog.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CelluleTest {

	@Test
	public final void testGetName() {
		Cellule cel = new Cellule("bonjour", "=3+5");
		String res = "bonjour";
		assertTrue("nom classique", cel.getName().compareTo(res) == 0);
		cel = new Cellule("", "=3-5");
		res = "";
		assertTrue("nom vide", cel.getName().compareTo(res) == 0);
	}

	@Test
	public final void testGetFormule() {
		Cellule cel = new Cellule("bonjour", "=3+5");
		String res = "=3+5";
		assertTrue("formule classique", cel.getFormule().compareTo(res) == 0);
		cel = new Cellule("bonjour", "");
		res = "";
		assertTrue("formule vide", cel.getFormule().compareTo(res) == 0);
		cel.setFormule("test");
		res = "test";
		assertTrue("reafectation formule", cel.getFormule().compareTo(res) == 0);
		cel.setFormule("");
		res = "";
		assertTrue("reafectation formule vide", cel.getFormule().compareTo(res) == 0);
	}
	
	@Test
	public final void testGetIsNumeric() {
		Cellule cel = new Cellule("bonjour", "=3+5");
		assertTrue("resultat numerique", cel.getIsNumeric());
		cel.setFormule("bonjour");
		assertTrue("resultat non numerique", !cel.getIsNumeric());
	}




}

