package bowling;

import java.util.HashMap;

public class PartieMultiJoueurs extends PartieMonoJoueur implements IPartieMultiJoueurs{
	
	// Attributs
	private Joueur[] joueurs;
	private HashMap<Joueur,PartieMonoJoueur> partiesJoueurs;
	private Joueur joueurCourant;
	private int numJoueurActu;
	
	// Constructeur
	public PartieMultiJoueurs(String[] nomJoueurs) {
		super();
		this.joueurs = new Joueur[nomJoueurs.length];
		for (int i = 0; i < nomJoueurs.length; i++){
			this.joueurs[i] = new Joueur(nomJoueurs[i]);
		}
		joueurCourant = joueurs[0];
		numJoueurActu = 0;
		partiesJoueurs = new HashMap<>();
	}

	public String demarreNouvellePartie(String[] nomsDesJoueurs){
		for (Joueur joueur : joueurs){
			partiesJoueurs.put(joueur, new PartieMonoJoueur());
		}
		return "Tour de " + joueurCourant + ", tour n° " + partiesJoueurs.get(joueurCourant).numeroTourCourant() + ", lancé n° " + partiesJoueurs.get(joueurCourant).tourCourant;
	}
	
	@Override
	public String enregistreLancerMulti(int nombreDeQuillesAbattues){
		if (partiesJoueurs.get(joueurCourant).estTerminee()) {
			throw new IllegalStateException("La partie est terminée");
		}else{
			partiesJoueurs.get(joueurCourant).tourCourant.enregistreLancer(nombreDeQuillesAbattues);
			if (partiesJoueurs.get(joueurCourant).tourCourant.estTermine()) {
				tourCourant = tourCourant.getSuivant();
			}
			if (partiesJoueurs.get(joueurCourant).tourCourant.getBoulesLancees() >= 2){
				if (numJoueurActu < joueurs.length) {
					joueurCourant = joueurs[numJoueurActu+1];
					numJoueurActu++;
				}else{
					joueurCourant = joueurs[0];
					numJoueurActu = 0;
				}
			}
		}
		return "Prochain tir : " + joueurCourant + ", tour n° " + partiesJoueurs.get(joueurCourant).tourCourant + ", lancé n° " + partiesJoueurs.get(joueurCourant).tourCourant;
	}
	
	public int scorePour(String nomDuJoueur){
		Joueur joueurDemande = trouverJoueur(nomDuJoueur);
		PartieMonoJoueur partieDemandee = partiesJoueurs.get(joueurDemande);
		return partieDemandee.score();
	}

	private Joueur trouverJoueur(String nomDuJoueur) {
		for (Joueur joueur : joueurs) {
			if (joueur.getNom().equals(nomDuJoueur)) {
				return joueur;
			}
		}
		return joueurs[0];
	}
	
	// Getter
	
	public int getPartieJoueursLength(){
		return partiesJoueurs.size();
	}
	
	public int getNumJoueurActu(){
		return numJoueurActu;
	}
}
