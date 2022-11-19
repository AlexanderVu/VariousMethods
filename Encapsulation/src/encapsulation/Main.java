package encapsulation;

public class Main {

	public static void main(String[] args) {
		//variables are only accessed through methods is encapsulation. using the private keyword. @FindBy is another example of encapsulation.
		
		Employee e = new Employee();
		
		//e.ID         does not work
		//e.Name
		//e.Salary
		e.setID(123);
		e.setName("Alexander");
		e.setSalary("$120,000");
		
		System.out.println("ID: "+ e.getID() + " Name: "+ e.getName() + " Salary: "+ e.getSalary());
	}

}
