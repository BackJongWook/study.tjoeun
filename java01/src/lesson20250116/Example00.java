package lesson20250116;

class Example00 extends Example {		
	/*
	 	1. 주석이란? 주석의 종류와 사용방법은?
			프로그램과 관련없는 내용을 기록하는 것
	 	
	 	2. 현재 단원 처음에 있는 코드1, 9, 10번 라인을 설명하시오.
	 	
	 	3. 키워드, 예약어, 식별자의 의미를 설명하시오.
	 		키워드	: 미리 약속된 명령어 ( 자료형 등등 )
			예약어	: 키워드로 사용되지 않았지만 키워드로 사용될 명령어
			식별자	: 키워드와 예약어를 구분지을 이름
	 	
	 	4. 프로그램의 시작점은 어디이며 기술해 보자.
			pubIic static void main(string[] args)
		
		5. { } 괄호가 사용되는 용도와 사용되는 곳을 기술하시오.
			코드 블럭 해당 코드가 어디까지 이어져있는지 보여준다
		
		6. 프로그램에서 사용되는 자료형 4가지를 기술하고 설명하시오.
			int 	: 정수형
			flot 	: 실수형 
			char 	: 문자형
			boolen 	: 논리형
			
		7. 프로그램 기초 문법 6개를 기술하시오.
			1. 프로그램은 main 메소드에서 시작해서 main 메소드에서 끝난다.
			2. 프로그램은 위에서 아래로 실행된다.
			3. 프로그램 명령문의 끝은 ;(세미콜론)을 붙여야 한다.
			4. 관련있는 코드는 중괄호로 묶는다.
			5. 종괄호 안에 있는 코드들은 탭으로 들여 쓰기한다.
			6. 중괄호 {}는 시작 위치와 같은 위치에서 닫는다.
			
		8. println과 print의 차이를 설명하시오.
			println	: 라인이 바뀐다.
			print 	: 라인이 바뀌지 않는다.
			
		9. 이스케이프시퀀스란 무슨 의미이고 어떻게 사용하는지 기술하시오.
			표기하기 어려운 문자를 표하는 기술
			엔터나 탭을 문자열에 표기할수 없기때문에 \n \t 로 표기하여 사용한다.
		
		10. 다음은 파일 이름은 helloWorld.java 이다. 잘못된 부분을 찾아 보자.
			public class MyHelloWorld {
				pubIic static void main(string[] args) {
					system.Out.print1n(
						'Hello
						World~'
					)
				}
			}
			'Hello World~' 처럼 이어져있어야한다.
			helloWorld.java 이지만 클래스명은 MyHelloWorld 이럼 돌아가지 않는다.
			system.Out 명령어가 틀림 System.out (오타)
			println <= prin1n로 되어있음 1이 아니라 l로 적어야한다. (오타)
		
		11. 상위 코드 (10번) 를 정상적으로 변경하였다면 키워드,예약어,식별자를 구분해보자.
			키워드 예약어 -> pubIic, static, void, class, 
			식별자 -> main, system, helloWorld(MyHelloWorld), println
	 */
	
	@Override
	void NameTag() {
		System.out.println("32p 문제");
	}
	
	@Override
	void Prt() {
		System.out.println("12번 문제");
		anser00();
		System.out.println("13번 문제");
		anser01();
		System.out.println("5번 문제");
		anser02();
		System.out.println("6번 문제");
		anser03();
		System.out.println("7번 문제");
		anser04();
	}
	
	/**12번 문제**/
	private void anser00() {
		System.out.println("안녕자바\n");		
	}
	
	/**13번 문제**/
	private void anser01() {
		String[] mInfo = {
				"* 백종욱\t\t\t*",
				"* boschi@naver.com\t*",
				"* 010-5549-1292\t\t*",
		};
		for(int i=0; i <= mInfo.length; i++) {
			System.out.println("*************************");
			if(i != mInfo.length) {  
				System.out.println(mInfo[i]);
			}
		}
		System.out.println();
	}
	
	/**5번 문제**/
	private void anser02() {
		int num = 0; // 초기화
		
		System.out.println("\n5-1 문제");
		for(int i=0; i < 5; i++) {
			System.out.println("*****");
		}
		
		System.out.println("\n5-2 문제");
		for(int i=0; i < 5; i++) {
			for(int j=0; j <= i; j++){
				System.out.print("*");
			}		
			System.out.println("");
		}
		
		System.out.println("\n5-3 문제");
		num=0; // 초기화
		for(int i=0; i < 5; i++) {
			for(int j=5; j >= 0; j--){
				if(i >= j) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}		
			System.out.println("");
		}
		System.out.println("");
	}
	
	/**6번문제*/
	private void anser03() {
		String[] prt = {
				"* 국어\t50\t*",
				"* 영어\t50\t*",
				"* 수학\t50\t*",
				"* 검퓨터 학과 홍길동\t*",
		};
		
		for(int i=0; i <= prt.length; i++) {
			System.out.println("*****************");
			if(i != prt.length) {  
				System.out.println(prt[i]);
			}
		}
	}
	
	/**7번문제*/
	private void anser04() {
		int num = 0;
		int weekNum = 0;
		String[] week = {
			"일", "월","화", "수", "목", "금", "토",
		};
		
		for(int i=0; i<week.length; i++) {
			System.out.print(week[i]+"\t");
		}
		
		System.out.println("");
		for(int i=1; i<=31; i++) {
			if(weekNum == 7) {
				weekNum = 0;
				System.out.println("");
			}
			weekNum++;
			System.out.print(i+"\t");
		}
	}
}