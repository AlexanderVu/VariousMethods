package overRide;

public class ChildClass extends ParentClass{
	
	public static void main(String[] args) {
		// Parent class and Child class has the same method. after inheriting, When the method is called the child method overrides the parents class. that is method overriding
		// to be able to access the parent class, u will have to make an object out of the parent class and call it.
		
		
		ParentClass obj = new ChildClass();
		obj.MyMethod();
		
		
		
		ParentClass obj1 = new ParentClass();
		obj1.MyMethod();
		
	}
	
	public void MyMethod() {
		System.out.println("I am child Class");
	}

}
