package week10.day1;

public class RecrusionTest {
/*
	public static void f1() {
		System.out.println("Hello");
	}
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			f1();
		}
	}
*/
	//print 10 to 1
	public static void f1(int n) {
		System.out.println(n);
		f1(n-1);
	}
	
	public static void main(String[] args) {
		f1(10);
	}
}
