package prog;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Cette classe sert � communiquer avec les syst�mes de sauvegarde, elle permet
 * de charger et de sauvegarder depuis et vers un fichier nlb, ainsi que charger
 * les donn�es depuis une base de donn�es.
 */
public final class SaveManager {

	
/**
 * 
 * Permet d'�tablir une connection avec une base donn�e.
 * 
 * @param url
 * 
 * 			adresse de la base de donn�e
 * 	
 * @param user
 * 
 * 			nom de l'utilisateur

 * 
 * @param password
 * 
 * 			mot de passe pour se connecter � la base donn�e
 * 
 * @return Connection
 */
	
	private static Connection ConnecterBase(String url, String user,
			String password) {

		try {
			
			if (url.contains("jdbc:sqlite:")) {

				Class.forName("org.sqlite.JDBC");

			} else if (url.contains("jdbc:oracle:thin:")) {

				Class.forName("oracle.jdbc.driver.OracleDriver");

			}else if(url.contains("jdbc:mysql:")){
				
				Class.forName("com.mysql.jdbc.Driver");	
				

				
				
			}else {			

				return null;

			}

			Connection connection = DriverManager.getConnection(url, user,
					password);

			return connection;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}
	
	
	/**
	 * 
	 * @param s
	 * 
	 * 			permet d'ex�cuter les instruction sql et de retourner les r�sultat
	 * 
	 * @param Requete
	 * 
	 * 			Requete sql � ex�cuter
	 * 
	 * @return ResultSetMetaData
	 */
	private static ResultSet RetournerResultat(Statement s, String Requete) {

		try {

			ResultSet r = ((java.sql.Statement) s).executeQuery(Requete);
			//ResultSetMetaData rm = r.getMetaData();
			return r;

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return null;

		

	}
	
	/**
	 * Importe une base de donn�e grace � une requete
	 * 
	 * @param requete
	 *            requete sql permettant de r�cup�rer une table depuis une base
	 *            de donn�es
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public static Conteneur ImportBase(String requete, String url, String user,
			String password) throws ClassNotFoundException, SQLException {

		

		try {

			Conteneur c = new Conteneur();
			
			Statement s =ConnecterBase(url, user, password)
					.createStatement();
			
			//ResultSetMetaData rm=RetournerResultat(s, requete);

			ResultSet rs=(ResultSet) RetournerResultat(s, requete);
			
			
			Cellule cell = null;

			while (rs.next()) {

				ResultSetMetaData rm=rs.getMetaData();
				
				for (int i = 1; i <=  rm.getColumnCount(); i++){

					cell = new Cellule(((ResultSetMetaData) rm).getColumnName(i).toUpperCase() + "_"
							+ i, ( (ResultSet) rs).getObject(i).toString());
				c.addCellule(cell);
				
				}

			}

			(rs).close();
			(s).close();
			
			return c;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Cette fonction permet au parseur de lire le fichier (.nlb) et de cr�er
	 * les cellules correspondantes dans un conteneur qu'il aura cr��
	 * 
	 * @param chemin
	 * @throws Exception
	 */
	public static Conteneur ImportFile(String chemin) throws Exception {
		Conteneur res = new Conteneur();
		BufferedReader reader = new BufferedReader(new FileReader(chemin));
		String line;
		while ((line = reader.readLine()) != null) {
			Cellule c = Parseur.extractLine(line);
			if (c != null)
				res.addCellule(c);
		}
		reader.close();
		return res;
	}

	/**
	 * Permet de sauvegarder les donn�es dans un fichier .nlb
	 * 
	 * @param chemin
	 *            Chemin de sauvegarde du fichier
	 * @param conteneur
	 * @throws IOException
	 */
	public static void sauvegarde(String chemin, Conteneur conteneur)
			throws IOException {
		PrintWriter writer = new PrintWriter(chemin, "UTF-8");
		for (Cellule c : conteneur.getAllCellules()) {
			writer.println(c.getName() + "|" + c.getFormule());
		}
		writer.close();
	}

}


