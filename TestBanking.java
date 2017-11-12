/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */
import java.util.Scanner;
import java.io.*;
import banking.*;

public class TestBanking {

  public static void main(String[] args) throws Exception{
    Bank     bank = new Bank();
    File f=new File("step5input.txt");
    if(f.exists())
    {
    	Scanner in=new Scanner(f);
    //
    // 浠诲姟1锛欳reate bank customers and their accounts from account section of step5input.txt
    //
        while(in.hasNextLine())
    	{
        	in.nextLine();
    String line=in.nextLine();
    while(!line.matches(" .*")) {
    	line.replace(',',' ');
    	line.replace(';', ' ');
    	String[] arr=line.split(" ");
    	if(arr.length>1)
    	{
    		bank.addCustomer("1","1");
    	double bal,interest,over;
    	int i=2;
    	Account ac;
    		switch(arr[i]) {
    		case "s":
    			bal=Double.valueOf(arr[++i]);
    			i++;
    			interest=Double.valueOf(arr[++i]);
    			ac=new SavingsAccount(bal,interest);
    			bank.getCustomer(bank.getNumOfCustomers()-1).setAccount(ac);
    			break;
    		case "c":
    		{
    			if(arr[i+1]!="share")
    			{
    				bal=Double.valueOf(arr[++i]);
    			}
    			else if(arr[i+2]!="o"){
    				i+=2;
    				ac=bank.getCustomer(arr[i], arr[i+1]).getAccount();
    				bank.getCustomer(bank.getNumOfCustomers()-1).setAccount(ac);
    			}
    			else {
    				bal=Double.valueOf(arr[++i]);
    				i++;
    				over=Double.valueOf(arr[++i]);
    				ac=new CheckingAccount(bal,over);
    				bank.getCustomer(bank.getNumOfCustomers()-1).setAccount(ac);
    			}
    			break;
    			}
    			
    		}
    	}
    }
	line=in.nextLine();
    }
    }else {
    	System.out.println("file doesn't exists!");
    }
    //浠诲姟2锛欴emonstrate behavior of various account types according to transactions section of step5input.txt 
	
    			   
	//浠诲姟3锛氬皢涓婅堪鎺у埗鍙拌緭鍑哄啓鍏tep5output.txt

  }
}
