// class Card. Contains information for each card;
public class Card {

    /**
     * Attributes for the card object:
     * 
     * Suit - can be one of 4, hearts, spades, clubs, diamonds
     * 
     * Number - all the numbers in a 52 card deck, 2-10, and jack - ace
     * 
     * Type - comes before number, 2-14 where 11-14 is jack - ace
     * 
     * function:
     *  - Two cards are +2
     *  - Four cards are +4
     *  - Aces are skip turn
     *  - Jacks are change color
     * 
     * belongsTo:
     *  - in play pile(-1)
     *  - in deck(0)
     *  - computer hand(1)
     *  - player hand(2)
     */

    private String _number,_suit,_function;
    private int _belongsTo;



    /**
     * Default constructor
     * by default sets belongsTo to 0 (in deck) and function to none
     */
    public Card() {
        _belongsTo = 0;
        _function = null;
    }

    /**
     * Overloaded constructor
     * @param suit
     * @param number
     * sets suit and number to inputs
     */
    public Card(String suit, int number) {
        this();
        _suit = suit;
        _function = assignFunct(number);
        _number = typeToNumber(number);   
    }

    /**
     * Constructor Helper methods
     */

    // type to number, converts 2-14 to 2-10 and jack - king
    // arg cannot be lower than 2 or larger than 14
    private String typeToNumber(int type) {
        if ((type > 14) || (2 > type)) {
            System.out.println("CLASS CARD, LINE 61 ERROR - Arg is not in the correct range");
            return null;
        }
        if (type <= 10) {
            return Integer.toString(type);
        }
        final String[] nonNumber = {"Jack","Queen","King","Ace"};
        type = type-11;
        return nonNumber[type];
    }

    // assigns function to special cards, assigns null function if not special card
    private String assignFunct(int number) {
        if ((number == 4) || (number == 2)) {
            return "+" + Integer.toString(number);
        }
        else if (number == 11) {
            return "Change Color";
        }
        else if (number == 14) {
            return "Skip Turn";
        }
        return null;
    }


    /**
     * String representation of Card class:
     *  number + suit + function
     */
    public String toString() {
        String str;
        str = _number + " of " + _suit;
        if (_function != null) {
            str += ". Function: " + _function;
        }
        return str;
    }


    /**
     * Acessor methods
     */

    // changes _belongsTo attribute and returns old one
    // arg cannot be smaller than -1 or greater than 2
    public int changeWhere(int location) {
        if ((-1 > location) || (location > 2)) {
            System.out.println("CLASS CARD, LINE 109 ERROR - arg is not in the correct range");
            return -2;
        }
        int oldVal = _belongsTo;
        _belongsTo = location;
        return oldVal;
    }

    // to access _belongsTo attribute
    public int getWhere() {
        return _belongsTo;
    }

    // to access suit attribute
    public String getSuit() {
        return _suit;
    }

    // to access number attribute
    public String getNum() {
        return _number;
    }



    // main method just for internal testing
    public static void main(String[] args) {
        // Card c = new Card("Spade", 2);
        // for (int i = -1; i < 3; i++) {
        //     c = new Card("Spades", i); 
        //     System.out.println("c: " + c);
        //     System.out.println(c.changeWhere(i));
        //     System.out.println("That: " + c.getWhere());
        // }
    }

     

}