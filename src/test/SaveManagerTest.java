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
	
	/**
	 * Pour que les test présent dans cette classe fonctionnent il faut modifier les attributs de la classe si nécessaire
	 */
	
	private String requete="SELECT * FROM Aliment";
	
	private String urlbase="jdbc:mysql://localhost/gastronomie";
	
	private String user="root";
	
	private String password="root";
	

	@Test
	public void testConnecterBase() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
		
		SaveManager s = new SaveManager();
		@SuppressWarnings("rawtypes")
		Class[] par = new Class[]{String.class,String.class,String.class};

		Method m = s.getClass().getDeclaredMethod("ConnecterBase", par);
		m.setAccessible(true);
		assertNull(
				"probléme jdbc",
				m.invoke(s, new Object[] { "jdbc://localhost/gastronomie",
						user, password }));

		assertNull("probléme nom utilisateur", m.invoke(s, new Object[] {
				urlbase, "edzed", password }));

		assertNull("probléme url base",
				m.invoke(s, new Object[] { "jdbc:mysql:", user, password }));

		assertNull(
				"probléme mot de passe",
				m.invoke(s, new Object[] {
						urlbase, user, "edze" }));

		assertNotNull(
				"Connection établie",
				m.invoke(s, new Object[] {
						urlbase, user, password }));

	}

	@Test
	public void testRetournerResultat() throws SQLException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		SaveManager s = new SaveManager();

		Class[] par2 = new Class[]{String.class,String.class,String.class};


		Method m2 = s.getClass().getDeclaredMethod("ConnecterBase", par2);
		m2.setAccessible(true);

		@SuppressWarnings("rawtypes")
		Class[] par = new Class[]{Statement.class,String.class};

		Method m = s.getClass().getDeclaredMethod("RetournerResultat", par);
		m.setAccessible(true);

		Statement stat = (Statement) ((Connection) m2.invoke(s, new Object[] {
				urlbase, user, password}))
				.createStatement();

		assertNull("Requete non valide",
				m.invoke(s, new Object[] { stat, "edzed" }));
		
		assertNull("Satement incorrect",
				m.invoke(s, new Object[] { null, requete}));
		
		assertNotNull("Un résultat est retourné",
				m.invoke(s, new Object[] { stat, requete}));

	}
	
	@Test
	public void testImportBase() throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		
		
		assertNull("Requete invalide",SaveManager.ImportBase("zdzedez",urlbase, user, password));
		assertNull("url invalide",SaveManager.ImportBase(requete,"jdbc:mysql:lhost/gastronomie", user, password));
		assertNull("Identifiant invalide",SaveManager.ImportBase(requete,urlbase, "", password));
		assertNull("Mot de passe invalide",SaveManager.ImportBase(requete,urlbase, user, ""));
		assertNotNull("Tout les paramétres sont bon",SaveManager.ImportBase(requete,urlbase, user, password));

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

