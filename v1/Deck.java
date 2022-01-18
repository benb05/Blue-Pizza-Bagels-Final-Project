import java.util.ArrayList; // import the ArrayList class

public class Deck {
  /**
    * Macau card deck class
      - deck attribute :: array of Card items, initialized as 52 cards
      + shuffle method :: shuffles the deck(should be called at initialization & to reshuffle)
  */
  private ArrayList<Card> deck = new ArrayList<Card>(52);
  private ArrayList<Card> discard = newArrayList<Card>(52);

  public Deck() {
    String[] suits = new String[]{"spades", "hearts", "clubs", "diamonds"}
    // populate deck with 1-15 number cards, where 11-15 is Jack, Queen, King, and Ace respectively
    for(String s : suits) {
      for(int i = 2; i < 15; i++) {
        Card temp = new Card(s, i)  ;
        deck.set(i, temp);
      }
    }
  }

  public void shuffle() {

  }

  public Card draw() {

  }

  public
}
