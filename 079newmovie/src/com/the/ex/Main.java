package com.the.ex;

import java.util.Scanner;

import com.the.selecter.*;

public class Main {

	public static void main(String[] args) {
//		Selecter selecter = null;
//		selecter = new MovieList();
//		selecter.update();
//		//선택권을 줘야함 0.영화목록 1.예메 2.예메취소 3.종료
		// 여기서 대사로 뭘할꺼냐 물어봐야됨

		Program slt = null;
		Selecters selecter = new Selecters();
		while (selecter != null) {
			switch (selecter.input()) {
				case 0: {
					slt = new Reserve();
				}
					break;
				case 1:
					slt = new Search();
					break;
				case 2:
					slt = new Delete();
					break;
				case 3:
					return;
				default:
					System.out.println("다시 입력하세요.");
			}
			slt.update();
		}
	}

}
