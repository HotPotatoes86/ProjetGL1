package prog;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.SQLException;

import org.junit.Test;

public class SaveManagerTest {

	@Test
	public void testConnecterBase() {
		SaveManager s=new SaveManager();
		
		
		assertNull("probléme jdbc", SaveManager.ConnecterBase("", "", ""));
		assertNull("probléme nom utilisateur", SaveManager.ConnecterBase("", "", ""));
		assertNull("probléme url base", SaveManager.ConnecterBase("", "", ""));
		assertNull("probléme mot de passe", SaveManager.ConnecterBase("", "", ""));
		assertNotNull("Connection établie", SaveManager.ConnecterBase("fdvdf", "", ""));

	}

	@Test
	public void testRetournerResultat() throws SQLException{
		
		SaveManager s=new SaveManager();
		
		assertNull("Requete non valide", SaveManager.RetournerResultat((Statement) s.ConnecterBase("", "", "")
				.createStatement(), ""));
		assertNull("Satement incorrect",SaveManager.RetournerResultat((Statement) s.ConnecterBase("", "", "")
				.createStatement(), ""));
		assertNotNull("Un résultat est retourné",SaveManager.RetournerResultat((Statement) s.ConnecterBase("", "", "")
				.createStatement(), ""));
		

		
		
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

