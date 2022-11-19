package overRide;

public class OverLoad {
	
	//Method overloading is having the same method name but each do different things. This is achieved by having different arguments.

	public static void main(String[] args) {
		OverLoad abc = new OverLoad();
		abc.Combine(5,5);
		abc.Combine("Hello"," How are you?");
		abc.Combine("I am", 5);
	}
	
	public void Combine(String a , String b) {
		System.out.println(a+b);
		
	}
	
	public void Combine(int a, int b) {
		System.out.println(a+b);
		
	}
	
	public void Combine(String a, int b) {
		System.out.println(a+b);
		
	}

}
