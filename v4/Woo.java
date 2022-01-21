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
  }
}
