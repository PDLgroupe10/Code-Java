
/**
 * Classe Article
 * @author grave - roueche - serais
 * @version 1.2
 * */

public class Article {

	/** 
	 * référence de l'article
	 */
	private String nom;		
	/**
	 * désignation
	 */
	private String prenom;	
	/**
	 * prix unitaire hors taxe
	 */
	private String date_nais;		
	/**
	 * quantité en stock
	 */
	private String fonction;


	/**
	 * Constructeur
	 * @param nom référence de l'article
	 * @param prenom désignation
	 * @param date_nais prix unitaire hors taxe
	 * @param fonction quantité en stock
	 */
	public Article(String nom, String prenom, String date_nais, String fonction) {
		this.nom=nom;
		this.prenom = prenom;
		this.date_nais = date_nais;
		this.fonction = fonction;
	}
	
	/**
	 * getter pour l'attribut nom
	 * @return valeur de la nom article
	 */
	public String getnom() {
		return nom;
	}
	/**
	 * getter pour l'attribut désignation
	 * @return valeur de la désignation article
	 */
	public String getprenom() {
		return prenom;
	}
	/**
	 * setter  pour l'attribut prenom
	 * @param prenom : nouvelle valeur de la désignation article
	 */
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * getter  pour l'attribut date_nais
	 * @return valeur de prix unitaire HT
	 */
	public String getdate_nais() {
		return date_nais;
	}
	/**
	 * setter  pour l'attribut date_nais
	 * @param date_nais :  nouvelle valeur de prix unitaire HT
	 */
	public void setdate_nais(String date_nais) {
		this.date_nais = date_nais;
	}
	/**
	 * getter  pour l'attribut fonction
	 * @return valeur de quantité en stock
	 */
	public String getfonction() {
		return fonction;
	}
	/**
	 * setter  pour l'attribut fonction
	 * @param fonction : nouvelle valeur de prix unitaire HT
	 */
	public void setfonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
	public String toString() {
		return "Article [réf : " + nom + " - " + prenom
				+ ", " + date_nais + "€ HT, " + fonction + " en stock]";
	}
}
