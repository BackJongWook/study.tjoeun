package main.works;
import java.util.Random;
import java.util.Scanner;
import main.selecter.*;


public class Inquiry extends Works {
	
    public Inquiry(){
    	super();
    	name = SelecterEnum.계좌조회.toString();
    }
	
	@Override
	public void progress() { 
	    super.progress();
		accountInput();
		setResult();
	}
}
