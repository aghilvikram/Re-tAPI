package learning.restassured.buildernonbuilder;

public class Builder {

	
		String firstName="vikram";
		String lastName="balasubramanian";
		String dob="12111990";
		
		public Builder m1(String firstName, String lastName, String dob) {
			this.firstName=firstName;
			this.lastName=lastName;
			this.dob=dob;
			System.out.println(firstName+lastName+dob);
			return this;
		}
		public Builder m2(String firstName, String lastName) {
			
			System.out.println(firstName+lastName);
			return this;
		}
		public Builder m3(String dob) {
			System.out.println(dob);
			return this;
			
		}
		public static  Builder build() {
			return new Builder();
		}
		

	
		
		@Override
		public String toString() {
			return "Builder [firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		public static void main(String[] args) {
			build().m1("vikram","balasubramanian", "12111990").m2("Devi","Ravi").m3("28041996");
			

	}

}
