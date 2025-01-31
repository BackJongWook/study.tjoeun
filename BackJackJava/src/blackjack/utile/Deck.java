package blackjack.utile;
import java.util.*;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	
	public Deck(){
		String[] suit = {"♥", "♦", "♣", "♠"};
		for(String i : suit) {
			for(int j=0; j <= 13; ++j) {
				deck.add(new Card(i,j));
			}
		}
		Collections.shuffle(deck);
	}
	
	
	public Card draw() {
		return deck.remove(deck.size() - 1);
	}
	
	public boolean isEmpty() {
		return deck.isEmpty();
	}
}
