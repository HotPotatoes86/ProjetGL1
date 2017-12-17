package prog;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
			
			//on charge le driver correspondant au SGBD
			
			if (url.contains("jdbc:sqlite:")) {

				Class.forName("org.sqlite.JDBC");

			} else if (url.contains("jdbc:oracle:thin:")) {

				Class.forName("oracle.jdbc.driver.OracleDriver");

			}else if(url.contains("jdbc:mysql:")){
				
				Class.forName("com.mysql.jdbc.Driver");	
				

				
				
			}else {			

				//si on n'arrive pas à déterminer quel est le sgbd, on retourne null
				
				return null;

			}

			//on essaye d'établir une connexion	
			
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
			
			//on execute la requéte et on récupére le résultat
			
			ResultSet r = ((java.sql.Statement) s).executeQuery(Requete);
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

	public static Conteneur ImportBase(String requete, String url, String user,String password) throws ClassNotFoundException, SQLException {
		try {
			
			
			Conteneur c = new Conteneur();
			
			//on établis une connection
			
			Statement s =ConnecterBase(url, user, password).createStatement();
			
			//on récupére le résultat de la requéte
			
			ResultSet rs=(ResultSet) RetournerResultat(s, requete);	
			
			//récupére les métadonnées
			
			ResultSetMetaData rm = rs.getMetaData();
			Cellule cell = null;
			
			int j=1;
			
			while (rs.next()) {

				//on crée une cellule pour chaque colonne de chaque ligne
				
				for(int i=1;i<=rm.getColumnCount();i++){
										
					cell=new Cellule(rm.getColumnName(i).toUpperCase()+"_"+j,rs.getString(rm.getColumnName(i)));
					c.addCellule(cell);
					
				}
				
				j++;
			
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
		
		//On lit chaque ligne du fichier
		
		while ((line = reader.readLine()) != null) {
			
			//Pour chaque ligne on extrait les données nécessaire à la création d'une cellule
			
			Cellule c = ParserExtract.extractCelluleFromLine(line);
			if (c != null)
				
				//On ajoute la nouvelle cellule au conteneur
				
				res.addCellule(c);
		}
		reader.close();
		for (Cellule c : res.getAllCellules()) {
			c.actualise(res);
		}
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
			
			//Pour chaque cellule du conteneur on écrit une ligne dans le fichier de sauvegarde
			
			writer.println(c.getName() + "|" + c.getFormule());
		}
		writer.close();
	}

}


