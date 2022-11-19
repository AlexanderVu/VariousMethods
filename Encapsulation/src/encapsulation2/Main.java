package encapsulation2;

public class Main {
	
	// a more dynamic way of using getters and setters for encapsulation.

	public static void main(String[] args) {
		Cars c = new Cars("BMW", "$30000", "200kmph");
		System.out.println(" Name: "+ c.getName()+ " Price: "+c.getPrice()+ " TopSpeed: "+c.getTopSpeed());
		c.setPrice("$50000");
		c.setTopSpeed("500mph");
		System.out.println(" Name: "+ c.getName()+ " Price: "+c.getPrice()+ " TopSpeed: "+c.getTopSpeed());

	}

}
