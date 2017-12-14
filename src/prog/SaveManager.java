package prog;

import java.beans.Statement;
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
 * Cette classe sert à communiquer avec les systèmes de sauvegarde, elle permet
 * de charger et de sauvegarder depuis et vers un fichier nlb, ainsi que charger
 * les données depuis une base de données.
 */
public final class SaveManager {

	/**
	 * Importe une base de donnée grace à une requete
	 * 
	 * @param requete
	 *            requete sql permettant de récupérer une table depuis une base
	 *            de données
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Conteneur importBase(String requete)
			throws ClassNotFoundException, SQLException {

		Conteneur c = new Conteneur();

		try {

			String url = "";

			Class.forName("org.sqlite.JDBC");

			Connection connection = DriverManager.getConnection(url, "", "");

			Statement s = (Statement) connection.createStatement();
			ResultSet r = ((java.sql.Statement) s).executeQuery(requete);
			ResultSetMetaData rm = r.getMetaData();

			Cellule cell = null;

			while (((ResultSet) rm).next()) {

				for (int i = 1; i <= rm.getColumnCount(); i++)

					cell = new Cellule(rm.getColumnName(i).toUpperCase() + "_"
							+ i, ((ResultSet) rm).getObject(i).toString());
				c.addCellule(cell);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return c;

	}

	/**
	 * Cette fonction permet au parseur de lire le fichier (.nlb) et de créer
	 * les cellules correspondantes dans un conteneur qu'il aura créé
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
	 * Permet de sauvegarder les données dans un fichier .nlb
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

