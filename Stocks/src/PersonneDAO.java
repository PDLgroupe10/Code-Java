import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'accès aux données contenues dans la table Personne
 * 
 * @author grave - roueche - serais
 * @version 1.2
 * */
public class PersonneDAO {

	/**
	 * Paramètres de connexion à la base de données oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "****";  //exemple BDD1
	final static String PASS = "****";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public PersonneDAO() {
		// chargement du pilote de bases de données
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un Personne dans la table Personne Le mode est auto-commit
	 * par défaut : chaque insertion est validée
	 * 
	 * @param Personne
	 *            l'Personne à ajouter
	 * @return retourne le nombre de lignes ajoutées dans la table
	 */
	public int ajouter(Personne personne) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion à la base de données
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// préparation de l'instruction SQL, chaque ? représente une valeur
			// à communiquer dans l'insertion
			// les getters permettent de récupérer les valeurs des attributs
			// souhaités
			ps = con.prepareStatement("INSERT INTO Personne (art_reference, art_designation, art_pu_ht, art_qte_stock) VALUES (?, ?, ?, ?)");
			ps.setString(1, Personne.getnom());
			ps.setString(2, Personne.getprenom());
			ps.setString(3, Personne.getdate_nais());
			ps.setString(4, Personne.getfonction());

			// Exécution de la requête
			retour = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}

	/**
	 * Permet de récupérer un Personne à partir de sa référence
	 * 
	 * @param reference
	 *            la référence de l'Personne à récupérer
	 * @return 	l'Personne trouvé;
	 * 			null si aucun Personne ne correspond à cette référence
	 */
	public Personne getPersonne(int reference) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Personne retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Personne WHERE art_reference = ?");
			ps.setInt(1, reference);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = new Personne(rs.getString("art_reference"),
						rs.getString("art_designation"),
						rs.getString("art_pu_ht"), rs.getString("art_qte_stock"));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}

	/**
	 * Permet de récupérer tous les Personnes stockés dans la table Personne
	 * 
	 * @return une ArrayList d'Personnes
	 */
	public List<Personne> getListePersonnes() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Personne> retour = new ArrayList<Personne>();

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Personne");

			// on exécute la requête
			rs = ps.executeQuery();
			// on parcourt les lignes du résultat
			while (rs.next())
				retour.add(new Personne(rs.getString("art_reference"), rs
						.getString("art_designation"), rs
						.getString("art_pu_ht"), rs.getString("art_qte_stock")));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}


}
