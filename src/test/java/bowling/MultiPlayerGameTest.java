package bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiPlayerGameTest {

	private PartieMultiJoueurs partie;
	private String[] joueurs = new String[] {"Michel", "Juan", "Carlos"};
	private String[] joueurs2 = new String[] {"Michel", "Juan"};

	@BeforeEach
	public void setUp() {
		partie = new PartieMultiJoueurs(joueurs);
	}

	@Test
	void testDemarrerPartie() {
		partie.demarreNouvellePartie(joueurs);
		assertEquals(3, partie.getPartieJoueursLength(), "Toutes les parties n'ont pas été créées");
	}
	
	@Test
	void testOrderJoueurs(){
		partie.demarreNouvellePartie(joueurs);
		assertEquals(0, partie.getNumJoueurActu());
	}
	
	@Test
	void testEnregistrerLancerMulti(){
		partie.demarreNouvellePartie(joueurs);
		partie.enregistreLancerMulti(8);
		assertEquals(0, partie.getNumJoueurActu(), "Cela n'a pas changé de joueur");
	}
	
	@Test
	void testJoueurJoue2lancers(){
		partie.demarreNouvellePartie(joueurs);
		partie.enregistreLancerMulti(8);
		partie.enregistreLancerMulti(1);
		assertEquals(1, partie.getNumJoueurActu(), "Le joueur actuel n'est pas le bon");
	}

	@Test
	void testScoreJoueur(){
		partie.demarreNouvellePartie(joueurs);
		partie.enregistreLancerMulti(8);
		partie.enregistreLancerMulti(1);
		assertEquals(9, partie.scorePour("Michel"), "Le score n'est pas le bon");
	}

	@Test
	void testScoreJ2(){
		partie.demarreNouvellePartie(joueurs);
		partie.enregistreLancerMulti(8);
		partie.enregistreLancerMulti(1);
		partie.enregistreLancerMulti(5);
		partie.enregistreLancerMulti(0);
		assertEquals(5, partie.scorePour("Juan"), "Le score n'est pas le bon");
	}
	
}