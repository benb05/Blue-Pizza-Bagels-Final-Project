

public class deckocards{

 static int cards[] = new int[52];
 public static int getRandomNumber(int min, int max) {
  return (int) ((Math.random() * (max - min)) + min);
}
  private static void shuffler(){
    for (int i = 0; i < cards.length;){
      cards[i] = getRandomNumber(0, 52);
      System.out.println(cards[i]);
      i++;
    }

  }

  public static void main(String[] args) {
    shuffler();
  }
  



}
