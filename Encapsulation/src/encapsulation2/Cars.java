package encapsulation2;

public class Cars {
	
	private String name;
	private String price;
	private String topSpeed;
	
	public Cars(String name, String price, String topSpeed) {
		this.name = name;
		this.price = price;
		this.topSpeed = topSpeed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(String topSpeed) {
		this.topSpeed = topSpeed;
	}

	

}
