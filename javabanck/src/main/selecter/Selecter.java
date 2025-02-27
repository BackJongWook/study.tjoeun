package main.selecter;
import java.util.Scanner;

public class Selecter {
	int input;
	
	public Selecter() {
		this.input = 0;
	}
	
	public int input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------------");
		System.out.println("원하시는 업무의 번호를 선택해주세요.");
		for (SelecterEnum i : SelecterEnum.values()) {
			System.out.println( i.ordinal()+" : "+i);
		}
        while(true) {
            while (!scanner.hasNextInt()) {
                System.out.println("유효하지 않은 입력입니다. 숫자만 입력해 주세요.");
                scanner.next();
            }  
    		input = scanner.nextInt();
        	if(input < SelecterEnum.values().length) { break ; }
        }
		System.out.println("------------------------");
		System.out.println(input+" : "+SelecterEnum.values()[input]+" 업무를 선택하셧습니다.");
		return input;
	}
}
