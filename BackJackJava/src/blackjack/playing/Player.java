package blackjack.playing;
import blackjack.utile.*;
import java.util.*;

//버스터 넣기?
public class Player {
	protected String name;
	protected int busted;
	protected static int playerNumber = 0;
	protected List<Card> hand = new ArrayList<>();
    
	/*이름 없는 상태의 초기화*/
	public Player(){
		this.name = "무명("+(++playerNumber)+")";
        this.busted = setButed();
	}
	
	/*이름 있는 상태의 초기화*/
    public Player(String name) {
        this.name = name;
        this.busted = setButed();
    }
    
    /*버스트(정지,패배 조건)는 플레이어=21, 딜러=17*/
    protected int setButed() {
    	return isDealer()?17 :21;
    }	
      
    /*가지고 있는 카드를 추가한다.*/
    public void addCard(Card card) {
        hand.add(card);
    }
    
    /*가지고 있는 카드르 추가 및 Card(객체)로 반환한다.*/
    public Card addCard(Card card,boolean isReturn) {
    	addCard(card);
    	return isReturn == true ?hand.get(hand.size()-1) :null;
    }
    
    /*가지고 있는 카드의 점수의 총합을 계산*/
    public int getHand(){
    	int result = 0;
    	int ace = 0;
    	
    	for(Card card: hand){
    		result += card.get();
    		if(card.get() == 11) { ace++; }
    	}
    	
    	while(result >= busted && ace > 0){
          result -= 10;
          ace--;    			
    	}
    	
    	return result;
    }
    
    /*가지고 있는 카드를 보여주며 총합을 계산*/
    public void showHand() {
    	String prt = name + "님의 패";
    	prt += (hand.size() != 0) ?"는 "+hand :"가 없습니다.";
    	System.out.println(prt+ "( 총 "+getHand()+" 점 )");
    }

    /*버스트(패배/정지) 확인*/
    public boolean isBusted() { return getHand() >= busted; }

    /*이름을 가져간다.*/
    public String getName() {
        return name;
    }
    
	public boolean isDealer() { return false; } 
}
