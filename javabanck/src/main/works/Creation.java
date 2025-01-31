package main.works;

import java.util.Scanner;
import java.util.Random;

import main.account.*;
import main.selecter.SelecterEnum;

public class Creation extends Works {
    Random random;    
    
    public Creation(){
    	super();
    	random = new Random();
    	name = SelecterEnum.생성.toString();
    }
	
	@Override
	public void progress() {
	    super.progress();
	    
		long num = 0;
		Account guest = new Account();
		Scanner scanner = new Scanner(System.in);
		
	    System.out.println("------------------------");
		while(true) {
			System.out.println("이름을 공백없이 입력해주세요.");
			if(guest.hasName(scanner.nextLine())) { break; }
		} 
		
	    System.out.println("------------------------");
		while(true) {
			System.out.println("비밀번호를 공백없이 4자리를 입력해주세요.");
			if(guest.hasPassword(scanner.nextLine())) { break; }
		} 
		
	    System.out.println("------------------------");
	    
		while(true) {
			num = manager.notDuplicatedNumber();
			System.out.print(guest.getHolder()+"님의 계좌번호: "+num+ "으로 생성되셧습니다. \n\ty키를 눌러 생성하시거나, 아무키를 입력하여 다시 생성 해주세요.");
			if("y".equals(scanner.nextLine())) {
			    System.out.println("------------------------");
				System.out.println("입금할 금액을 입력해주세요.");
			      while(true) {
			    	  while (!scanner.hasNextLong()) {
			    		  System.out.println("유효하지 않은 입력입니다. 숫자만 입력해 주세요.");
			              scanner.next();
			    	  }
			    	  guest.depositAmount(scanner.nextLong(),true);
			    	  break;
			      }
			      break;
			 }
		}
		manager.add(num,guest);
		manager.prtAccount(num,true);
	    System.out.println("계좌가 생성되었습니다. 초기 화면으로 넘어갑니다.");
		progress = false;
	};
	
	
}
