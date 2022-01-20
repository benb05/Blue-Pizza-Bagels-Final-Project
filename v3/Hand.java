import java.util.ArrayList;

// class Hand, creates an arr list of Cards, each player is the hand
public class Hand {

    /**
     * Attributes for class Hand
     * 
     * Array List of Cards, hand - contains all of the cards 
     */
    private ArrayList<Card> _hand;

    // no constructors because then risking having two instances of deck and more than 52 cards in total
    public Hand() {
        _hand = new ArrayList<Card>(6);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < _hand.size(); i++) {
            str += _hand.get(i) + "\n";
        }
        return str + _hand.size(

        );
    }
    /**
     * play method
     * @param index
     * @return Card
     * simulates playing a card from hand
     * returns the Card played and removes it from hand
     */
    public Card play(int index) {
        Card c = _hand.get(index);
        _hand.remove(index);
        return c;
    }

    /**
     * method add
     * @param c 
     * adds specified card to hand
     */
    public void add(Card c) {
        _hand.add(c);
    }

    /**
     * method size
     * @return int
     */
    public int size() {
        return _hand.size();
    }

    /**
     * method isEmpty
     * @return boolean
     * returns true if hand attribute is empty
     */
    public boolean isEmpty() {
        return size() > 0;
    }


    public static void main(String[] args) {
        Hand h = new Hand();
        Deck d = new Deck();

        System.out.println(h);

        Card c = new Card("Spades", 10);
        h.add(c);
        for (int i = 0; i < 6; i++) {
            c = d.draw(1);
            h.add(c);
        }

        System.out.println(h);



    }
}
