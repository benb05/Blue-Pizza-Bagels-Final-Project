import java.util.ArrayList;

// class Hand, creates an arr list of Cards, each player is the hand
public class Hand {

    /**
     * Attributes for class Hand
     * 
     * Array List of Cards, hand - contains all of the cards 
     */
    private ArrayList<Card> _hand = new ArrayList<Card>();

    // no constructors because then risking having two instances of deck and more than 52 cards in total

    public String toString() {
        String str = "";
        for (int i = 0; i < _hand.size(); i++) {
            str += "Card " + i + ": " + _hand.get(i) + "\n";
        }
        return str + "Total cards: " + _hand.size();
    }


    /**
     * play method
     * @param index
     * @return Card
     * simulates playing a card from hand
     * returns the Card played and removes it from hand
     * throws error if index is out of range
     */
    public Card play(int index) {
        if (index >= _hand.size()) {
            System.out.println("ERROR - CLASS HAND, LINE 36 - index out of range");
            return null;
        }
        Card c = _hand.get(index);
        _hand.remove(index);
        return c;
    }

    /**
     * method add
     * @param c 
     * adds specified card to hand
     * throws error if card is not marked to be in a hand by belongsTo Card var
     */
    public void add(Card c) {
        if (c.getWhere() < 1) {
            System.out.println("ERROR - CLASS HAND, LINE 50 - card not supposed to be in a hand");
            return;
        }
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
        return _hand.size() <= 0;
    }

    /**
     * accessor method for different cards in hand var
     * throws error and returns null if hand is empty
     * or index is out of bounds
     * @param index
     * @return Card
     */
    public Card getCard(int index) {
        if ((_hand.size() <= 0) || (index > _hand.size())) {
            System.out.println("ERROR - CLASS HAND, LINE 81 - index out of bounds");
            return null;
        }
        return _hand.get(index);
    }


    public static void main(String[] args) { /*
        Hand h = new Hand();
        Deck d = new Deck();

        System.out.println(h);

        Card c = new Card("Spades", 10);
        // h.add(c);
        for (int i = 0; i < 10; i++) {
            c = d.draw(2);
            h.add(c);
        }
        System.out.println(h);

        c = h.play(9);
        System.out.println("c: " + c);
        

        System.out.println(h);
        */
    }
}
