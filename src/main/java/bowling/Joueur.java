package bowling;

public class Joueur {
	
	// Attributs
	
	private String nom;
	private int score;
	
	// Constructeur
	
	public Joueur(String nom) {
		this.nom = nom;
		this.score = 0;
	}
	
	// Getters
	
	public String getNom(){
		return nom;
	}
	public int getScore(){
		return score;
	}
	
	// Setters
	
	public void setScore(int score){
		this.score = score;
	}
	
}
