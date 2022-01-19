import java.util.*;

public class Macau {
    private ArrayList<Hand> hands = new ArrayList<Hand>(2); 
    private Deck _deck = new Deck(); 
    public Macau() {
        Hand compHand = new Hand(); 
        for(int i = 0; i < 6; i++) {
            compHand.set(i, _deck.draw());
        }
    }

    public Macau(int numPlayers) {

    }
}
