package TestNGListners;

import org.testng.annotations.Test;

public class sampleTestNG {

	@Test
	public void demo1() {
		System.out.println("Hello, I am demo1 method...");
	}

	@Test
	public void demo2() {
		int a = 10;
		int b = a / 0;
		System.out.println("Hello, I am demo2 method..." + b);
	}

	@Test(dependsOnMethods = "demo2")
	public void demo3() {
		System.out.println("Hello, I am demo3 method...");
	}

	@Test
	public void demo4() {
		System.out.println("Hello, I am demo4 method...");
		int c = 50;
		int d = c / 0;
		System.out.println("I am partially passed method" + d);
	}
}
