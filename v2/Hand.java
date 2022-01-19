public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>(6);
    public Card play(int ind) {
        return hand.get(ind);
    }
    public void set(int ind, Card c) {
        hand.set(ind, c);
    }
}
