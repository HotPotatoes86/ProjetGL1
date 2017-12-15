package test;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import org.junit.Test;

import prog.SaveManager;

public class SaveManagerTest {

	@Test
	public void testConnecterBase() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
		
		SaveManager s = new SaveManager();
		@SuppressWarnings("rawtypes")
		Class[] par = new Class[3];

		par[0] = String.class;
		par[1] = String.class;
		par[2] = String.class;

		Method m = s.getClass().getDeclaredMethod("ConnecterBase", par);
		m.setAccessible(true);
		assertNull(
				"probléme jdbc",
				m.invoke(s, new Object[] { "jdbc://localhost/gastronomie",
						"root", "root" }));

		assertNull("probléme nom utilisateur", m.invoke(s, new Object[] {
				"jdbc:mysql://localhost/gastronomie", "edzed", "root" }));

		assertNull("probléme url base",
				m.invoke(s, new Object[] { "jdbc:mysql:", "root", "root" }));

		assertNull(
				"probléme mot de passe",
				m.invoke(s, new Object[] {
						"jdbc:mysql://localhost/gastronomie", "root", "edze" }));

		assertNotNull(
				"Connection établie",
				m.invoke(s, new Object[] {
						"jdbc:mysql://localhost/gastronomie", "root", "root" }));

	}

	@Test
	public void testRetournerResultat() throws SQLException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		SaveManager s = new SaveManager();

		Class[] par2 = new Class[3];

		par2[0] = String.class;
		par2[1] = String.class;
		par2[2] = String.class;

		Method m2 = s.getClass().getDeclaredMethod("ConnecterBase", par2);
		m2.setAccessible(true);

		@SuppressWarnings("rawtypes")
		Class[] par = new Class[2];

		par[0] = Statement.class;
		par[1] = String.class;

		Method m = s.getClass().getDeclaredMethod("RetournerResultat", par);
		m.setAccessible(true);

		Statement stat = (Statement) ((Connection) m2.invoke(s, new Object[] {
				"jdbc:mysql://localhost/gastronomie", "root", "root" }))
				.createStatement();

		assertNull("Requete non valide",
				m.invoke(s, new Object[] { stat, "edzed" }));
		
		assertNull("Satement incorrect",
				m.invoke(s, new Object[] { null, "SELECT * FROM Aliment" }));
		
		assertNotNull("Un résultat est retourné",
				m.invoke(s, new Object[] { stat, "SELECT * FROM Aliment" }));

	}
	
	@Test
	public void testImportBase() throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		
		
		assertNull("Requete invalide",SaveManager.ImportBase("zdzedez","jdbc:mysql://localhost/gastronomie", "root", "root"));
		assertNull("url invalide",SaveManager.ImportBase("SELECT * FROM Aliment","jdbc:mysql:lhost/gastronomie", "root", "root"));
		assertNull("Identifiant invalide",SaveManager.ImportBase("SELECT * FROM Aliment","jdbc:mysql://localhost/gastronomie", "", "root"));
		assertNull("Mot de passe invalide",SaveManager.ImportBase("SELECT * FROM Aliment","jdbc:mysql://localhost/gastronomie", "root", ""));
		assertNotNull("Tout les paramétres sont bon",SaveManager.ImportBase("SELECT * FROM Aliment","jdbc:mysql://localhost/gastronomie", "root", "root"));

	}
	

	@Test
	public void testImportFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testSauvegarde() {
		fail("Not yet implemented");
	}

}

