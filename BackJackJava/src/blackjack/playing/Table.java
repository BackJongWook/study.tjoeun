package blackjack.playing;
import blackjack.utile.*;
import java.util.*;

public class Table {
	
	private boolean isPlay = true;
	private int turn = 0;
    private List<Player> player = new ArrayList<Player>();
    private Deck deck;
    
	public Table() { 
        player.add(new Player());
        turn = 0;
        dealerInit();
	}
	
    public Table(String name) {
        player.add(new Player(name));
    	dealerInit();
    }
    
    public Table(List<Player> player) {
    	this.player = player; 
    	dealerInit();
    }
    
    public void dealerInit() {
        deck = new Deck();
        player.add(new Dealer());
    }
    
    public void play(){
    	Scanner scanner = new Scanner(System.in);
    	turn = 0;
    	isPlay = true;
    	System.out.println("게임을 시작합니다.");
    	System.out.println("------------------------------------------------------");
    	while(isPlay){
    		if(turn == 0) {
    			initGame(scanner);
    		}
    		else {
    			System.out.print(turn+"번째 턴을 시작합니다. ");
    			updateGame(scanner); 
    			}
        	turn++;
    	}	
    }
    
    private void initGame(Scanner scanner) {
    	int drawNum = 0;
    	for(Player i : player) {
    		drawNum = i.isDealer() ?1 :2;
    		System.out.println("\n"+i.getName()+"님의 드로우 입니다, "+drawNum+"장을 드로우합니다.");
    		while(0 < drawNum) {
    			i.addCard(deck.draw());
    			drawNum--;
    		}
    		i.showHand();
    		System.out.println("------------------------------------------------------");
    	}

    }
    
    private boolean selectAction(Scanner scanner,Player i) {
    	if(i.isDealer()) { // 딜러이기 때문에 자동화 된다.
    		if(!i.isBusted()) {
		  		System.out.println(i.getName()+"님이 드로우 합니다.");
		  		System.out.println(i.getName()+"은 ["+i.addCard(deck.draw(),true)+"]를 드로우 하였습니다.");
    		}
    	}
    	else {
			System.out.println("\n\tHit(드로우), Stay(멈춤) 하시겠습니까? Y(Hit) / N(Stay)");
			System.out.println("\t▣(Hit), N(Stay) 키가 아닐 경우 자동으로 N(Stay)로 입력됩니다.");
			if("y".equals(scanner.nextLine())) {
				System.out.println(i.getName()+"님은 Hit(드로우)를 선택 하였습니다.");
				System.out.println(i.getName()+"님은 ["+i.addCard(deck.draw(),true)+ "]를 드로우 하였습니다.");
			}
			else {
				System.out.println(i.getName()+"님은 Stay(멈춤)를 선택 하였습니다.");
			}
    	}
		i.showHand();
		return i.isBusted();
    }
    
    private boolean isDealerBuster(Scanner scanner,Player i){
    	if(i.isDealer()) { 
    		System.out.println(i.getName()+"님의 버스터(실격)으로 게임이 종료됩니다."); 
    		return false; 
    	}
    	else { 
    		System.out.print(i.getName()+"님은 버스터(실격)으로 ");
    		System.out.println((turn+1)+"턴 에서 제외됩니다.");
    		return true;
    	}
    	
    }
    
    private void updateGame(Scanner scanner) {
    	for(Player i : player) {
	    	if(!(i.isBusted())) {
	    		System.out.println("\n------------------------------------------------------");
	        	System.out.println(i.getName()+"님의 차례입니다.");
	        	i.showHand();
	        	if(selectAction(scanner,i)){
	        		isPlay = isDealerBuster(scanner,i);
	        	}
	        	else {
	        		System.out.println(i.getName()+"님의 턴이 종료되었습니다. 아무런 키를 눌러 다음을 진행해 주세요.");
	        		scanner.nextLine();
	        	}
	    	}
    	}
    	if(player.getFirst().isDealer()) {
			if(!player.getFirst().isBusted()) {
				System.out.println(player.getFirst().getName()+"님 밖에 남지않아. 게임을 종료합니다.");
			}
    	}
    }
    
    public void result() {
       	List<Player> livings = new ArrayList<Player>();
        int dealer = Math.abs(player.getLast().getHand()-21);
       	int livingNum = 0;
        String prt = "";
       	for(Player i : player) {
       		if(i.isDealer()) { continue; }
       		if(i.isBusted()) { prt += " "+i.getName()+"님,"; }
       		else { livings.add(i); }
       	}
       	
    	System.out.println("------------------------------------------------------");
		System.out.println("게임이 끝났습니다. 결과 입니다.");
		System.out.println(player.getLast().getName()+"님은 총 "+dealer+"점 입니다.");
		if(!"".equals(prt)) { System.out.println(prt+"은(는) 버스터(실격) 하셧습니다."); }
		
		for(Player i : livings) {
			livingNum = Math.abs(i.getHand()-21);
			prt = livingNum == dealer ?"무승부":( livingNum < dealer ?"승리" :"패배" );
			System.out.print(i.getName()+"님은 "+player.getLast().getName()+" 과의 대결에서 "+prt+" 하였습니다.\t");
			System.out.println(livingNum+" / "+dealer);
		}
		
    }
}

