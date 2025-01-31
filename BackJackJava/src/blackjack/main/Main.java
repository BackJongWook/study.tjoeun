package blackjack.main;
import blackjack.playing.*;
import java.util.*;

public class Main {
	static List<Player> player = new ArrayList<Player>();
	public static void main(String[] args) {
		Table table;
		//플레이어 설정
		int num = 3;
		for(int i=0; i<num; i++) {
			player.add(new Player());
		}
		table = new Table(player); // 게임 구동 class 가져오기  
		table.play(); // 게임구동
		table.result(); // 결과 
	}
}

