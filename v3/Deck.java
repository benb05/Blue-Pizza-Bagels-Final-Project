import java.lang.reflect.Array;
import java.util.*; // import the ArrayList class

// Class deck, creates a deck of cards and also stores discarded cards in case the deck runs out;
public class Deck {
  /**
   * Attributes for class Deck 
   * 
   * deck - contains 52 cards(13 cards of each suit from 1-10, jack - ace), filled at initialization of deck class
   * 
   * discard - contains all cards that will be discarded during the game
   * 
   * last suit - stores suit information of the last card played
   * 
   * last numb - stores number information of the last card played
  */
  private ArrayList<Card> _deck = new ArrayList<Card>(52);
  private ArrayList<Card> _discard = new ArrayList<Card>(52);
  private String _lastSuit, _lastNumb;

  /**
   * Default constructor
   * Fills deck attribute with 52 cards 
   * (1-14 number cards for each suit which are converted in class Card to normal playing card numbers)
   */
  public Deck() {
    final String[] suits = new String[]{"Spades", "Hearts", "Clubs", "Diamonds"};
    for(String s : suits) {
      for(int i = 2; i < 15; i++) {
        Card temp = new Card(s, i)  ;
        _deck.add(temp);
      }
    }
  }


  /**
   * toString method
   * a string representation of deck class
   *  - creates a string with each card on its own line and the size at the end
   */
  public String toString() {
    String str = "";
    int numCards = 0;
    for (Card c : _deck) {
      str += c.toString() + "\n";
      numCards+=1;
    }
    return str + Integer.toString(numCards);
  }


  /**
   * Shuffle method
   * @param arr
   * @return temp
   * Shuffles a copy of the specified ArrayList of cards and returns the copy
   *  - does this to avoid pass by reference (don't want everything getting mixed up)
   */
  public ArrayList<Card> shuffle(ArrayList<Card> arr) {
    
    // copy _deck arr list to make sure it doesn't point to the same location since java is pass by reference
    ArrayList<Card> temp = new ArrayList<Card>();
    for (Card c : arr) {
      temp.add(c);
    }
    Collections.shuffle(temp); // shuffle copy
    Collections.shuffle(temp); // shuffle copy again

    return temp;
  }


  /**
   * draw method
   * @param goWhere
   * @return c
   * simulate drawing a card from a deck 
   *  - removes right most card from the deck and arg specifies where it should go
   *  - returns the card drawn
   *  - throws error if draw and specify deck as current location
   */
  public Card draw(int goWhere) {
    if (goWhere == 0) {
      System.out.println("ERROR - CLASS DECK LINE 81: illegal operation, cannot draw card and place it in deck");
    }
    Card c = _deck.get(_deck.size()-1);
    _deck.remove(_deck.size()-1);
    c.changeWhere(goWhere);
    return c;
  }

  /**
   * putInDiscard method
   * @param card
   * places specified card in discard pile
   *  - throws error if it is not marked to go to discard pile
   */
  public void putInDiscard(Card card) {
    if (card.getWhere() != -1) {
      System.out.println("ERROR - CLASS DECK, LINE 97: card that is not marked to go to discard cannot go to discard");
      return;
    }
    _discard.add(card);
  }

  /**
   * recycle method
   * @return Card
   * shuffles discard array list and makes that deck
   *  - deck it erased
   *  - returns the last card played so that game can continue
   *  - if 
   *  - throws error if deck is not empty
   */
  public Card recycle() {
    Card lastPlayed = _discard.get(_discard.size()-1);
    if (deckEmpty()) {
      _deck = shuffle(_discard);
      _discard.clear();
      return lastPlayed;
    }
    System.out.println("ERROR - CLASS DECK, LINE 118: deck is not empty, will lose cards in the process");
    return null;
  }

  /**
   * deckEmpty method
   * @return boolean
   * returns true if deck is empty, false otherwise
   */
  public boolean deckEmpty() {
    return _deck.size() <= 0;
  }

  /**
   * accessor method getLastSuit
   * @return _lastSuit
   * returns lastsuit class variable
   */
  public String getLastSuit(){
    return _lastSuit;
  }

  /**
   * accessor method getLastNumber
   * @return _lastNumb
   * returns lastnumber class var
   */
  public String getLastNumber(){
    return _lastNumb;
  }


  /**
   * Methods for testing code
   *  - isShuffled: checks to see if array is shuffled by checking first 13 cards
   *  - getDeckArr: to make accessing _deck easier
   *
   *
  public boolean isShuffled(ArrayList<Card> arr) {
    Card current = arr.get(0);

    for (int i = 0; i < 13; i++) {
      current = arr.get(i);
      if (!(current.getSuit().equals("Spades"))) {
        return false;
      }
    }
    return true;
  }

  public ArrayList<Card> getDeckArr() {
    return _deck;
  }*/


  // main method for internal testing
   public static void main(String[] args) { /*
      Deck d = new Deck();
      // System.out.println(d);
      d._deck = d.shuffle(d._deck);
      // System.out.println(d);

      Card c = new Card();
      for (int i = 0; i < 52; i++) {
        c = d.draw(-1);
        d.putInDiscard(c);
      }

      System.out.println(d);

      System.out.println(d._discard + " " + d._discard.size());

      System.out.println("d.recycle();: " + d.recycle());
      System.out.println(d);

      System.out.println(d.isShuffled(d.getDeckArr()));
      d.isShuffled(d.shuffle(d.getDeckArr()));
      System.out.println(d.isShuffled(d.shuffle(d.getDeckArr())));
      d._deck = d.shuffle(d.getDeckArr());
      System.out.println(d.isShuffled(d.getDeckArr()));
      
      Card c = new Card();
      for (int i = 0; i < 51; i++) {
        c = d.draw(-1);
        d.putInDiscard(c);
      }
      // System.out.println("d: " + d);
      System.out.println(d._discard + " " + d._discard.size());
      System.out.println(d.deckEmpty() + " " + (d._deck.size()));

      d.recycle();
      System.out.println(d.deckEmpty());
      System.out.println(d.deckEmpty() + " " + (d._deck.size()));
      // System.out.println("d: " + d); */
  } // end main
} // end class Deck
