
/**
 * Classe Personne
 * @author BELOUAH - MAKOSSO
 * @version 1.0
 * */

public class Personne {

	/** 
	 * Nom de la personne
	 */
	private static String nom;		
	/**
	 * Prénom de la personne
	 */
	private static String prenom;	
	/**
	 * Date de naissance de la personne
	 */
	private static String date_nais;		
	/**
	 * Fonction de la personne dans l'école
	 */
	private static String fonction;


	/**
	 * Constructeur
	 * @param nom personne
	 * @param prenom personne
	 * @param date_nais personne
	 * @param fonction personne
	 */
	public Personne(String nom, String prenom, String date_nais, String fonction) {
		this.nom=nom;
		this.prenom = prenom;
		this.date_nais = date_nais;
		this.fonction = fonction;
	}
	
	/**
	 * getter pour l'attribut nom
	 * @return valeur du nom de la personne
	 */
	public static String getnom() {
		return nom;
	}
	/**
	 * getter pour l'attribut prenom
	 * @return valeur du prénom de la personne
	 */
	public static String getprenom() {
		return prenom;
	}
	/**
	 * setter  pour l'attribut prenom
	 * @param prenom : nouvelle valeur du prenom de la personne
	 */
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * getter  pour l'attribut date_nais
	 * @return valeur de la date de naissance de la personne
	 */
	public  static String getdate_nais() {
		return date_nais;
	}
	/**
	 * setter  pour l'attribut date_nais
	 * @param date_nais :  nouvelle valeur de la date de naissance de la personne
	 */
	public void setdate_nais(String date_nais) {
		this.date_nais = date_nais;
	}
	/**
	 * getter  pour l'attribut fonction
	 * @return valeur de la fonction de la personne
	 */
	public static String getfonction() {
		return fonction;
	}
	/**
	 * setter  pour l'attribut fonction
	 * @param fonction : nouvelle valeur de la fonction de la personne
	 */
	public void setfonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
	public String toString() {
		return "Personne [Nom : " + nom + " - " + prenom
				+ ", " + date_nais + ", " + fonction + " à l'ESIGELEC]";
	}
}
