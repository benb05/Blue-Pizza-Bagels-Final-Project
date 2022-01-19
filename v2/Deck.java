import java.lang.reflect.Array;
import java.util.*; // import the ArrayList class

public class Deck {
  /**
    * Macau card deck class
      - deck attribute :: array of Card items, initialized as 52 cards
      + shuffle method :: shuffles the deck(should be called at initialization & to reshuffle)
  */
  private ArrayList<Card> _deck = new ArrayList<Card>(52);
  private ArrayList<Card> _discard = new ArrayList<Card>(52);

  // Default constructor - populate deck with 1-14 number card objects
  public Deck() {
    final String[] suits = new String[]{"spades", "hearts", "clubs", "diamonds"};
    for(String s : suits) {
      for(int i = 2; i < 15; i++) {
        Card temp = new Card(s, i)  ;
        _deck.add(temp);
      }
    }
  }

  public String toString() {
    String str = "";
    int numCards = 0;
    for (Card c : _deck) {
      str += c.toString() + "\n";
      numCards+=1;
    }
    return str + "\n" + Integer.toString(numCards);
  }

  // Copies _deck into tempDeck var and 
  public ArrayList<Card> shuffle() {
    // takes AL of Cards and shuffles and returns it as randomly ordered AL of Cards
    ArrayList<Card> tempDeck = new ArrayList<Card>();
    for(Card c : _deck) { // copy input array for shuffling
      tempDeck.add(c);
    }
    Collections.shuffle(tempDeck); // shuffle copy
    return tempDeck;
  }

  public Card draw() {
    // gives leftmost card from deck and removes that card from the deck
    Card c = _deck.get(_deck.size()-1);
    _deck.remove(_deck.size()-1);
    return c;
  }

  public void recycle() {
    // take the playing pile(so make sure players' hands are omitted) and shuffle it
    _deck = shuffle(discard);
    discard.clear();
  }



   public static void main(String[] args) {
      Deck d = new Deck();
      System.out.println(d);
      d.shuffle();
      // Card c = draw();
      // System.out.println(c.toString());
      // System.out.println(deck.toString());
      // shuffle(deck);
      // System.out.println(deck.toString());
  } 
}
