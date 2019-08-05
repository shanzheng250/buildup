package test;

public class Son extends Sonp{

	public void init() {
		
		eat();
	}
	
	
	@Override
	public void eat() {
		
		System.out.println("mm");
		
	}
	
	
	public static void main(String[] args) {
		Son s = new Son();
		s.init();
	}
}
