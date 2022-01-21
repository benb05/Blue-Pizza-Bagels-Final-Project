import java.util.ArrayList;
import java.util.Scanner;

public class Macau {
    private Deck _deck; 
    private ArrayList<Hand> _hands = new ArrayList<Hand>(); 
    private int turnNumber = 0; // the number of the turn, for 1 player 1 computer then odd turns are player turns evens are computer turns

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

    public Hand getHand(int ind) {
        return _hands.get(ind);
    }

    public int gameOver() {
        /*
            * Checks if any players have empty _hands—aka if anyone has won 
            * Returns that player's hand index in the array _hands if anyone has won
            * Returns -1 if no one has won 
        */
        for(int h = 0; h < _hands.size(); h++) {
            if(_hands.isEmpty()) {
                return h;
            }
        }
        return -1;
    }

    public String runTurn() {
        Hand currHand = _hands.get(turnNumber % 2);
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        String retString = "Please input which card you'd like to play(0-" + (_hands.get(1).size() - 1) + ")";
        String cardNum = sc.nextLine();  // Read user input
        turnNumber += 1;
        if(playable(currHand.get(cardNum))) { // checks if the card is playable

        } else {

        }
    }

    public static void main(String[] args) {
        Macau m = new Macau();
        while(m.gameOver() == -1) {
            m.runTurn();
        }
        System.out.println("Player ", (m.gameOver() + 1), " has won!");
    }
}
