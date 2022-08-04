package learning.restassured.javabasics;
public class ObjectMethod {
	
	public static Books method1() {
		return new Comics("sports",200);
		
	}
	public static Books method2() {
		return new Fiction("Health", 300);
	}

	public static void main(String[] args) {
		ObjectMethod obj=new ObjectMethod();
		obj.method1();
		obj.method2();
	
      Comics cm= (Comics) new ObjectMethod().method1();
      Comics cm1= (Comics)method1();
     System.out.println(cm1.getbookName()); 
     System.out.println(cm1.getbookPrice());
     Fiction fn=(Fiction)method2(); 
     System.out.println(fn.getbookName());
     System.out.println(fn.getbookPrice());
	}

}
