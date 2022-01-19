import java.lang.reflect.Array;
import java.util.*; // import the ArrayList class

public class Deck {
  /**
    * Macau card deck class
      - deck attribute :: array of Card items, initialized as 52 cards
      + shuffle method :: shuffles the deck(should be called at initialization & to reshuffle)
  */
  public ArrayList<Card> deck = new ArrayList<Card>(52);
  public ArrayList<Card> discard = new ArrayList<Card>(52);

  public Deck() {
    String[] suits = new String[]{"spades", "hearts", "clubs", "diamonds"};
    // populate deck with 1-15 number cards, where 11-15 is Jack, Queen, King, and Ace respectively
    for(String s : suits) {
      for(int i = 2; i < 15; i++) {
        Card temp = new Card(s, i)  ;
        deck.set(i, temp);
      }
    }
  }

  public ArrayList<Card> shuffle(ArrayList<Card> cards) {
    // takes AL of Cards and shuffles and returns it as randomly ordered AL of Cards
    ArrayList<Card> shuffled = new ArrayList<>(cards.size());
    for(int c = 0; c < cards.size(); c++ ) { // copy input array for shuffling
      shuffled.set(c, cards.get(c));
    }
    Collections.shuffle(shuffled); // shuffle copy
    return shuffled;
  }

  public Card draw() {
    // gives leftmost card from deck and removes that card from the deck
    Card c = deck.get(0);
    deck.set(0, null);
    return c;
  }

  public void recycle() {
    // take the playing pile(so make sure players' hands are omitted) and shuffle it
    deck = this.shuffle(discard);
    discard.clear();
  }

  public void main(String[] args) {
    System.out.println(deck.toString());
    Card c = draw();
    System.out.println(c.toString());
    System.out.println(deck.toString());
    shuffle(deck);
    System.out.println(deck.toString());
  }
}
