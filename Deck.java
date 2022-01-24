import java.util.*; // import the ArrayList class

// Class deck, creates a deck of cards and also stores discarded cards in case the deck runs out;
public class Deck {
  /**
   * Attributes for class Deck 
   * 
   * Array List of Cards, deck - contains 52 cards(13 cards of each suit from 1-10, jack - ace), filled at initialization of deck class
   * 
   * Array List of Cards, discard - contains all cards that will be discarded during the game (AKA play pile)
   * 
   * Card, lastCard, is the last card played in discard
  */
  private ArrayList<Card> _deck = new ArrayList<Card>(52);
  private ArrayList<Card> _discard = new ArrayList<Card>(52);
  private Card _lastCard;

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
    
    // shuffles deck
    _deck = shuffle(_deck);
    while ((_deck.get(_deck.size()-1)).getFunct() != null) { // shuffles deck so that the first card is not a special card
      _deck = shuffle(_deck);
    }

    // updates the last card variable so its not null
    Card c = draw(-1);
    putInDiscard(c); // automatcially updates var
    updateLastCard(c);
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
   * method playable
   * @param c
   * @return boolean
   * @apiNote
   * Takes a card and determines if it can be played on top of the last card 
   */
  public boolean playable(Card c) {
    String lastNumb = _lastCard.getNum();
    String lastSuit = _lastCard.getSuit();

    if (c.getSuit().equals(lastSuit)) {
      return true;
    }
    if (c.getNum().equals(lastNumb)) {
      return true;
    }

    return false;
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
      System.out.println("ERROR - CLASS DECK LINE 96: illegal operation, cannot draw card and place it in deck");
    }
    if (_deck.size() == 0 ) {
      _lastCard = recycle();
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
   *  - updates last card variable
   *  - throws error if it is not marked to go to discard pile
   */
  public void putInDiscard(Card card) {
    if (card.getWhere() != -1) {
      System.out.println("ERROR - CLASS DECK, LINE 112: card that is not marked to go to discard cannot go to discard");
      return;
    }
    updateLastCard(card);
    _discard.add(card);
  }

  /**
   * recycle method
   * @return Card
   * shuffles discard array list and makes that deck
   * deck it erased
   * returns the last card played so that game can continue 
   * throws error if deck is not empty
   */
  public Card recycle() {
    Card lastPlayed = _discard.get(_discard.size()-1);
    if (deckEmpty()) {
      _deck = shuffle(_discard);
      _discard.clear();
      return lastPlayed;
    }
    System.out.println("ERROR - CLASS DECK, LINE 133: deck is not empty, will lose cards in the process");
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
    return _lastCard.getSuit();
  }

   /**
   * accessor method getLastNumber
   * @return _lastNumb
   * returns lastnumber class var
   */
  public String getLastNumber(){
    return _lastCard.getNum();
  }

  public Card getLastCard() {
    return _lastCard;
  }

  public ArrayList<Card> getDiscard() {
    return _discard;
  }

  public ArrayList<Card> getDeck() {
    return _deck;
  }

  /**
   * method updateLastCard
   * @param c
   * @apiNote
   * updates lastnumb and lastsuit var to specified val
   */
  public void updateLastCard(Card c) {
    _lastCard = c;
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
   public static void main(String[] args) {
      // Deck d = new Deck();

      // Card c = new Card("Spades", 3);

      // c.changeWhere(-1);
      // d.putInDiscard(c);

      // Card a = new Card("Spades",5);
      // Card b = new Card("Hearts", 3);

      // // d.playable(a);
      // System.out.println("suit test: " + d.playable(a));
      // // d.playable(b);
      // System.out.println("number test: " + d.playable(b));





      

  } // end main
} // end class Deck
