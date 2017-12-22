package test;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import prog.SaveManager;

public class SaveManagerTest {
	
	/**
	 * Pour que les test present dans cette classe fonctionnent il faut modifier les attributs de la classe si necessaire
	 */
	private String requete="SELECT * FROM Aliment";
	private String urlbase="jdbc:mysql://localhost/gastronomie";
	private String user="root";
	private String password="root";

	@Test
	public void testConnecterBase() throws NoSuchMethodException,SecurityException, 
	IllegalAccessException,IllegalArgumentException, InvocationTargetException {
		SaveManager s = new SaveManager();
		//La methode ConnecterBase est privee donc on utilise la reflexivite pour la tester
		@SuppressWarnings("rawtypes")
		Class[] par = new Class[]{String.class,String.class,String.class};
		//Je recupére la methode ConnecterBase
		Method m = s.getClass().getDeclaredMethod("ConnecterBase", par);
		m.setAccessible(true);
		//J'effectue les tests
		assertNull("probleme jdbc", m.invoke(s, new Object[] { "jdbc://localhost/gastronomie",user, password }));
		assertNull("probleme nom utilisateur", m.invoke(s, new Object[] {urlbase, "edzed", password }));
		assertNull("probleme url base", m.invoke(s, new Object[] { "jdbc:mysql:", user, password }));
		assertNull("probleme mot de passe", m.invoke(s, new Object[] {urlbase, user, "edze" }));
		assertNotNull("Connection etablie", m.invoke(s, new Object[] {urlbase, user, password }));
	}
	
	@Test
	public void testRetournerResultat() throws SQLException,NoSuchMethodException, SecurityException, 
	IllegalAccessException,IllegalArgumentException, InvocationTargetException {
		//La methode RetournerResultat est privee donc on utilise la reflexivite pour la tester
		SaveManager s = new SaveManager();
		Class[] par2 = new Class[]{String.class,String.class,String.class};
		//J'ai besoin d'utiliser la methode ConnecterBase pour faire mes test
		Method m2 = s.getClass().getDeclaredMethod("ConnecterBase", par2);
		m2.setAccessible(true);
		@SuppressWarnings("rawtypes")
		Class[] par = new Class[]{Statement.class,String.class};
		//Je recupére la methode RetournerResultat
		Method m = s.getClass().getDeclaredMethod("RetournerResultat", par);
		m.setAccessible(true);
		//j'utilise la methode RetournerResultat pour obtenir le statement qui me permet de faire mes tests
		Statement stat = (Statement) ((Connection) m2.invoke(s, new Object[] {urlbase, user, password})).createStatement();
		//J'effectue les tests
		assertNull("Requete non valide",m.invoke(s, new Object[] { stat, "edzed" }));
		assertNull("Satement incorrect",m.invoke(s, new Object[] { null, requete}));	
		assertNotNull("Un resultat est retourne",m.invoke(s, new Object[] { stat, requete}));
	}
	
	@Test
	public void testImportBase() throws NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		assertNull("Requete invalide",SaveManager.ImportBase("zdzedez",urlbase, user, password));
		assertNull("url invalide",SaveManager.ImportBase(requete,"jdbc:mysql:lhost/gastronomie", user, password));
		assertNull("Identifiant invalide",SaveManager.ImportBase(requete,urlbase, "", password));
		assertNull("Mot de passe invalide",SaveManager.ImportBase(requete,urlbase, user, ""));
		assertNotNull("Tout les parametres sont bon",SaveManager.ImportBase(requete,urlbase, user, password));
	}
}

