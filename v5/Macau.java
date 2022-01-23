import java.util.ArrayList;
import java.util.Scanner;

public class Macau {
    
    private Deck _deck; 
    private ArrayList<Hand> _hands = new ArrayList<Hand>(); 
    private int _turnNumber = 1; // the number of the turn, for 1 player 1 computer, odd turns are player turns evens are computer turns

    public Macau() {
        _deck = new Deck();
        Hand compHand = new Hand(); // computer hand
        Hand p1Hand = new Hand(); // player 1 hand

        _hands.add(compHand);
        _hands.add(p1Hand);

        for(int i = 0; i < 6; i++) { // populate _hands
            compHand.add(_deck.draw(1));
            p1Hand.add(_deck.draw(2));
        }
    }

    /**
     * accessor method: allows program to access a specific hand. 
     * Throws error if index is out of bounds
     * @param index
     * @return hand
     */
    public Hand getHand(int index) {
        return _hands.get(index);
    }

    /**
     * Checks if any players have empty _hands—aka if anyone has won 
     * Returns that player's hand index in the array _hands if anyone has won
     * Returns -1 if no one has won 
     * @return -1 or index(0-1)
     */
    public int gameOver() {
        Hand hand = new Hand();
        for(int i = 0; i < _hands.size(); i++) { // cycles through hands arr list 
            hand = _hands.get(i); // temp var of current index of hands arr list (a hand object)
            if(hand.isEmpty()) { // checks to see if hand is empty
                return i; // if its empty returns that index of hands arr list
            }
        }
        return -1; // if none of the hands are empty then returns -1, game continues
    }

    /**
     * checks to see if there is at least one playable card in a specified hand
     * @param h
     * @return boolean
     */
    public boolean hasPlayableCard(Hand h) {
        Card c = new Card();
        for (int i = 0; i < h.size(); i++) {
            c = h.getCard(i);
            if (_deck.playable(c)) {
                return true;
            }
        }
        return false;
    }


    // public int runTurn() {
    //     Hand currHand = _hands.get(_turnNumber % 2);
    //     Scanner sc = new Scanner(System.in);  // Create a Scanner object
    //     System.out.println("Here is your current hand: ");
    //     System.out.println(currHand);
    //     System.out.println("Here is the top card in the deck: ");
    //     System.out.println(_deck.getLastCard());
    //     String retString = "Please input which card you'd like to play by it's index(0-" + (currHand.size() - 1) + ")";
    //     System.out.println(retString);        
    //     Integer cardNum = Integer.parseInt(sc.nextLine());  // Read user input
    //     System.out.println("");
    //     if(_deck.playable(currHand.getCard(cardNum))) { // checks if the card is playable
    //         System.out.println(currHand.play(cardNum));
    //         _deck.putInDiscard(currHand.play(cardNum)); // play the card chosen
    //         _deck.updateLastCard(currHand.play(cardNum));
    //         return 1;
    //     } else {
    //         return -1; // indicate that the card cannot be played
    //     }
    // }

    /**
     * Simulates a turn in macau
     * takes input of chosen card for the active player's hand
     * if it's playable, play it (remove from their hand, add to top of discard)
     * return 1 to indicate success
     * if not, return -1 to indicate failure
     * return 0 if there are no cards that are playable in hand (take card and skip turn)
     * returns 2 if card chosen has a special function
     * @return -1,0,1,2
     */
    public int runTurn() {
        Card c = new Card();

        int whoseTurn = _turnNumber % 2; // 0 (when even, computer) or 1 (when odds, player)
        Hand currHand = _hands.get(whoseTurn); 

        // no playable card conditions - skip turn and draw
        if (!hasPlayableCard(currHand)) {
            if (whoseTurn == 1) {
                System.out.println("You don't have any cards to play, you skip a turn and take a card");
                c = _deck.draw(2);
                currHand.add(c);
                return 0;
            }
            if (whoseTurn == 0) {
                System.out.println("Opponent doesn't have any cards to play, they skip their turn and draw a card");
                c = _deck.draw(1);
                currHand.add(c);
                return 0;
            }
        }

        // if there is a playable card in hand
        int cardIndex = -1;
        if (whoseTurn == 1) {
            cardIndex = userInput(currHand);
        }
        if (whoseTurn == 0) { // computer simple ai
            for (int i = 0; i < currHand.size(); i++) {
                c = currHand.getCard(i);
                if (_deck.playable(c)) {
                    cardIndex = i;
                }
            }
        }

        c = currHand.getCard(cardIndex); //-1 because the first card is 1 and the last card is n+1

        if(_deck.playable(c)) { // double checks if the card is playable
            c.changeWhere(-1); // marks it to be placed in discard
            _deck.putInDiscard(currHand.play(cardIndex)); // play the card chosen and place it in discard
            updateLastCard(c);
            return 1;
        } else {
            return -1; // indicate that the card cannot be played
        }
    }


    /**
     * Helper method for runTrunm, takes in user input and outputs 
     * @return index of card
     */
    private int userInput(Hand currHand) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Here is the top card in deck: " + _deck.getLastCard());
        System.out.println("---------------------");

        String prompt = "Please input which card you'd like to play (Input '1' if you want to play card 1):\n" + (currHand);
        System.out.println(prompt);
        int cardIndex = (sc.nextInt() - 1);  // Read user number input
        // if () {} //checks to see if index is in range
        return cardIndex;
    }

    /**
     * updates last suit and last numb through deck class inside macau object.
     * does not return anything
     * @param c
     */
    public void updateLastCard(Card c) {
        _deck.updateLastCard(c);
    }

    /**
     * Increments _turnNumber var inside macau by one (+=1)
     */
    public void addTurn() {
        _turnNumber+=1;
    }

    /**
     * Accessor method for last card var in class deck inside macau object
     * @return Card
     */
    public Card getLastCard() {
        return _deck.getLastCard();
    }

    public ArrayList<Card> getDiscard() {
        return _deck.getDeck();
      }
    
    public Deck getDeck() {
    return _deck;
    }


    public static void main(String[] args) {
        Macau m = new Macau();
        while(m.gameOver() == -1) {
            m.runTurn();
            m._turnNumber += 1;
            if(m.gameOver() != -1) {
                break;
            }
        }
        System.out.println("Player " + (m.gameOver() + 1) + " has won!");
    }
}

