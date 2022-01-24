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
    public void runTurn() {
        Card c = new Card();

        int whoseTurn = _turnNumber % 2; // 0 (when even, computer) or 1 (when odds, player)
        Hand currHand = _hands.get(whoseTurn); 

<<<<<<< HEAD
        if()
=======
        for (int i = 0; i < currHand.length; i++){
            if (c.getNum(i) == 2 || c.getNum(i) == 4 || c.getNum(i) == 14 ){
                return;
            }
        }
>>>>>>> dd0778e20b566a3e6613f13544f8d5908cbe3b4f

        // no playable card conditions - skip turn and draw
        if (!hasPlayableCard(currHand)) {
            if (whoseTurn == 1) {
                c = _deck.draw(2);
                currHand.add(c);
                System.out.println("You don't have any cards to play, you skip a turn and draw a " + c);
                return;
            }
            if (whoseTurn == 0) {
                c = _deck.draw(1);
                currHand.add(c);
                System.out.println("Opponent doesn't have any cards to play, they skip their turn and draw a " + c);
                return;
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
            System.out.println("Your opponent placed down a " + currHand.getCard(cardIndex) + "\n");
<<<<<<< HEAD
=======
            if (currHand.size() == 0) {
                System.out.println("Your opponent has won. Better luck next time!");
            }
>>>>>>> dd0778e20b566a3e6613f13544f8d5908cbe3b4f
        }

        c = currHand.getCard(cardIndex); //-1 because the first card is 1 and the last card is n+1

        System.out.println("\n\nget last card: " + _deck.getLastCard() + "\n\n");
        if(_deck.playable(c)) { // double checks if the card is playable
            c.changeWhere(-1); // marks it to be placed in discard
            _deck.putInDiscard(currHand.play(cardIndex)); // play the card chosen and place it in discard
            updateLastCard(c); // not necessary because automatically done in put in discard method 
            return;
        } else {
            System.out.println("You can't place that card on a " + getLastCard() + ".Please go again. For more information re-read the rules or the readme file on the github page.\n");
            runTurn();
        }
<<<<<<< HEAD
=======
        if (currHand.size() == 0) {
            System.out.println("You've won!!! Go for another run!");
        }
>>>>>>> dd0778e20b566a3e6613f13544f8d5908cbe3b4f
    }


    /**
     * Helper method for runTrunm, takes in user input and outputs 
     * @return index of card
     */
    private int userInput(Hand currHand) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Here is the top card in deck: " + _deck.getLastCard());
        System.out.println("---------------------");

        String prompt = "Please input which card you'd like to play (Input '1' if you want to play card 1):\n" + (currHand) + "\n";
        System.out.println(prompt);
        int cardIndex = (sc.nextInt() - 1);  // Read user number input , minus 1 because 1st card is 1 (n index card is n+1)
        if (cardIndex < 0 || cardIndex >= currHand.size() ) { //checks to see if index is in range, if not prompts user again
            System.out.println("Input out of range of numbers accepted please pick again\n");
            cardIndex = userInput(currHand); // prompts them again
        } 
        return cardIndex;
    }


    /**
     * The draw sequence when taking a card from the pile and putting it into a hand.
     * Throws an error if the goWhere is invalid
     * @param goWhere
     */
    public void draw(int turnNum) {
        int whoseTurn = turnNum % 2; // 0 (when even, computer) or 1 (when odds, player) | 
        int goWhere = whoseTurn+1; // have to subtract because in range of 1-2, but should be 0-1 (index range)
        if ((whoseTurn < 0) || (whoseTurn >= (_hands.size()))) {
            System.out.println("ERROR - CLASS MACAU, LINE 168 - index out of range");
            return;
        }
        Card c = new Card();
        c = _deck.draw(goWhere);
        Hand currHand = _hands.get(whoseTurn);
        currHand.add(c);
    }

    // redundant - but keep just in case
    private void play(int turnNum, int cardIndex) {
        int whoseTurn = turnNum % 2; // 0 (when even, computer) or 1 (when odds, player)
        Hand currHand = _hands.get(whoseTurn);
        Card c = currHand.play(cardIndex);
        c.changeWhere(-1);
        _deck.putInDiscard(c); // automatically updates last card var
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

    // ACCESSOR METHODS FOR DECK AND HANDS SO THAT CAN USE IN WOO

    /**
     * Accessor method for last card var in class deck inside macau object
     * @return Card
     */
    public Card getLastCard() {
        return _deck.getLastCard();
    }
    
    /**
     * Accessor method for discard pile stored in deck class
     * @return Array List of Cards
     */
    public ArrayList<Card> getDiscard() {
        return _deck.getDiscard();
    }
    
    /**
     * Accessor method for deck list stored in deck class
     * @return Array List of Cards
     */
    public ArrayList<Card> getDeck() {
    return _deck.getDeck();
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

