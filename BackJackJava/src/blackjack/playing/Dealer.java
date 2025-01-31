package blackjack.playing;

public class Dealer extends Player {
	
	public Dealer() { 
		super("딜러(NPC)");
		setButed(); 
	}
	
	@Override
	public boolean isDealer() { return true; } 
}
