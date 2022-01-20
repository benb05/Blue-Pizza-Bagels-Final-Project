import java.util.*;

public class Woo {
    private static ArrayList<Hand> hands = new ArrayList<Hand>(2); 
    private static Deck _deck = new Deck(); 

    public static void main(String[] args) {
        Hand compHand = new Hand(); // computer hand
        Hand p1Hand = new Hand(); // player 1 hand
        hands.set(0, p1Hand);
        hands.set(1, compHand);
        for(int i = 0; i < 6; i++) { // populate hands
            compHand.set(i, _deck.draw());
            p1Hand.set(i, _deck.draw());
        }
    }

    /* public Woo(int numPlayers) {

    } */

    public Hand getHand(int ind) {

    }
}
