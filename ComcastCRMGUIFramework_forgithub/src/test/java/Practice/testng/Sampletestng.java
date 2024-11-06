package Practice.testng;

import org.testng.annotations.Test;

public class Sampletestng {
	public static void  Hi()
	{
		System.out.println("hi");
	}
	
	public  void  Hello()
	{
		System.out.println("Hello");
	}
	
	
@Test
	public void Sampletestng() {
		System.out.println("execute test");
	}
@Test
public void Sampletestng1() {
	System.out.println("execute test1");
}


public static void main(String[] args) {
	Hi();
	Sampletestng s=new Sampletestng();
	s.Hello();
	
}

}
