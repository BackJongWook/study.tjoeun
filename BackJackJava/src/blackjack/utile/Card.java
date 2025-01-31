package blackjack.utile;

public class Card {
    private String suit;
    private int rank;

    public Card(String suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    public int get() {
    	if(isAce()){ return 11; }
    	else if(rank <= 10) { return rank; }
    	else { return (rank/10) == 0 ?rank :10; }
    }

    @Override
    public String toString() {
    	String result = suit.toString();
    	if(isAce()){ return result+"A"; }
    	else if(rank <= 10) { return result+rank; }
    	else { return result +((rank-10) == 1?("J"):(rank == 2?"Q":"K")); }
    }
    
    public boolean isAce() {
    	return rank == 0;
    }
}
