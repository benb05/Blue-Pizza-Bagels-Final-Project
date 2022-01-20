import java.util.*;

public class Macau {
    private ArrayList<Hand> hands = new ArrayList<Hand>(2); 
    private Deck _deck = new Deck(); 

    public Macau(String[] args) {
        Hand compHand = new Hand(); // computer hand
        Hand p1Hand = new Hand(); // player 1 hand
        hands.set(0, p1Hand);
        hands.set(1, compHand);
        for(int i = 0; i < 6; i++) { // populate hands
            compHand.set(i, _deck.draw());
            p1Hand.set(i, _deck.draw());
        }
    }

    /* public Macau(int numPlayers) {

    } */

    public Hand getHand(int ind) {

    }
}
