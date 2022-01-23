public class Woo{


  final static private String intro = "Welcome to Macau, brought to you by Blue Pizza Bagels Inc.\n"+
  "Board Members: Andrew Piatetsky, Kosta Dubovskiy, Benjamin Belotser \n" +
  "\n" +
  "Rules:\n" + 
  " • Players are given six cards from a standard 52 card deck. The first player to go can put down any card.\n" + 
  " • After the first turn, the other player can put down a card that is either the same suit or number as the previous card played.\n" + 
  " • There are four card numbers with special functions:\n" + 
  "    • The 2 card forces the other player to draw 2 cards and skip their turn. \n" +
  "    • The 4 card functions the same as two, except it forces the player to draw four instead of two cards. \n" + 
  "    • The ace card forces the other player to skip a turn. \n" + 
  "    • The jack card changes the suit of the deck to the suit of the jack played. \n" +
  " • The game will end when either player runs out of cards in their hand. That player will be the winner. \n" +
  " • You (The human player... I think) will always have the first turn \n" +
  "\n" +
  "Keybinds:\n" +
  " • At the start of your turn, your hand will be shown to you, with your cards read in a line. \n" +
  " • The card that you drew most recently will always be the leftmost card"
  
  
  ;





  public static void main(String[] args) {
    System.out.println(intro);

    Macau m = new Macau();
    Card c = new Card();

    for (int i = 0; i < 2; i++) {
      // System.out.println(m.getHand(0));
      // System.out.println("----------");
      // System.out.println(m.getHand(1));
      // System.out.println("----------");
      // System.out.println(m._deck);
      // System.out.println("----------");
      // System.out.println((m._deck)._discard);
      // System.out.println("-----------------------------------");
      // System.out.println("-----------------------------------");


      c = m._deck.draw(-1);
      m._deck.putInDiscard(c);
      m.updateLastCard(c);

      // System.out.println("-----------------------------------");
      // System.out.println("-----------------------------------");
      // System.out.println(m.getHand(0));
      // System.out.println("----------");
      // System.out.println(m.getHand(1));
      // System.out.println("----------");
      // System.out.println(m._deck);
      // System.out.println("----------");
      System.out.println((m._deck)._discard);
      // System.out.println("----------");

      System.out.println("\n");
      System.out.println("-----------------------");
      System.out.println(m.runTurn());

      c = ((m._deck)._discard).get(((m._deck)._discard).size()-1);
      m.updateLastCard(c);

      m.addTurn();


      System.out.println("-----------------------");
      System.out.println("-------------------");
      System.out.println((m._deck)._discard);
      System.out.println("----------");
      System.out.println("-----------------------");
      System.out.println(m.getHand(0));
      System.out.println("----------");
      System.out.println("-----------------------");
      System.out.println(m.getHand(1));
      System.out.println("-----------------------");
      System.out.println("-----------------------");
      System.out.println(m._deck + "\n\n\n\n\n");
    }









    /*
    // start of while loop
    while (m.gameOver() == -1) { // checks to see if game is over

      // Card q = new Card("Spades", 3);
      // m.updateLastCard(q);
      // System.out.println(m.getLastCard());

      // // running turn
      // int turnResult = m.runTurn();
      // while (turnResult == -1) { // checks to see if card can be placed down
      //   turnResult = m.runTurn();
      // }

      // // checking to see if special card
      // Card c = new Card();
      // if ( turnResult == 2) {
      //   c = m.getLastCard();
      //   String funct = c.getFunct();
      //   if (funct == "+2") {
      //     System.out.println("+2");
      //   }
      //   else if (funct == "+4") {
      //     System.out.println("+4");
      //   }
      //   else if (funct == "Change Color") {
      //     System.out.println("change color");
      //   }
      //   else if (funct == "Skip Turn") {
      //     System.out.println("skip turn");
      //   }
      // } // end special function sorting

      
      // System.out.println((m._deck)._discard);


      
    } // end game while loop */
  } // end main method
} // end class woo
