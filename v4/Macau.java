import java.util.ArrayList;
import java.util.Scanner;

public class Macau {
    private static Deck _deck; 
    private static ArrayList<Hand> _hands = new ArrayList<Hand>(2); 
    private static int turnNumber = 0; // the number of the turn, for 1 player 1 computer then odd turns are player turns evens are computer turns

    public Macau() {
        _deck = new Deck();
        Hand compHand = new Hand(); // computer hand
        Hand p1Hand = new Hand(); // player 1 hand
        _hands.add(0, p1Hand);
        _hands.add(compHand);
        for(int i = 0; i < 6; i++) { // populate _hands
            compHand.add(_deck.draw());
            p1Hand.add(_deck.draw());
        }
    }

    public Hand getHand(int ind) {
        return _hands.get(ind);
    }

    public static int gameOver() {
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

    public static String runTurn() {
        Scanner cardScanner = new Scanner(System.in);  // Create a Scanner object
        String retString = "Player " + (turnNumber % 2) + " please input which card you'd like to play(0-" + (_hands.get(turnNumber).size() - 1) + ")";
        String cardNum = myObj.nextLine();  // Read user input
        if(playable(_hands.get(turnNum % 2).get(cardNum))) { // checks if the card is playable

        } else {

        }
    }

    public static void main(String[] args) {
        while(gameOver() == -1) {
            runTurn();
        }
        System.out.println("Player ", (gameOver() + 1), " has won!");
    }
}
