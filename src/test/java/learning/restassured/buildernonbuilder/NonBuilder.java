package learning.restassured.buildernonbuilder;

public class NonBuilder {
	String firstName="vikram";
	String lastName="balasubramanian";
	int dob=12111990;
	
	public void m1(String firstName, String lastName, int dob) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		System.out.println("method1");
	}
	

	
	@Override
	public String toString() {
		return "NonBuilder [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]";
	}



	public static void main(String[] args) {
		NonBuilder nb=new NonBuilder();
		System.out.println(nb);
		System.out.println(nb.firstName);
		System.out.println(nb.lastName);
		System.out.println(nb.dob);
		
	}

}
