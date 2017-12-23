package testmusicapp;

import	org.junit.runner.JUnitCore;
import	org.junit.runner.Result;	
import	org.junit.runner.notification.Failure;	
import	org.junit.runner.RunWith;	
import	org.junit.runners.Suite;	
@RunWith(Suite.class)	
@Suite.SuiteClasses({Test1.class, Test2.class, Test3.class})	
public class TestSuite {
	public static void main(String[] args)
	{	
		Result result1=JUnitCore.runClasses(Test1.class);	
		Result result2=JUnitCore.runClasses(Test2.class);	
		Result result3=JUnitCore.runClasses(Test3.class);
		
		for	(Failure failure : result1.getFailures())
		{	
			System.out.println(failure.toString());	
		}
		System.out.println(result1.wasSuccessful());
		
		for	(Failure failure : result2.getFailures())
		{	
			System.out.println(failure.toString());	
		}
		System.out.println(result2.wasSuccessful());
		
		for	(Failure failure : result3.getFailures())
		{	
			System.out.println(failure.toString());	
		}
		System.out.println(result3.wasSuccessful());
	}
}	
