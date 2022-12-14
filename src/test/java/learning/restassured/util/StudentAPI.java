package learning.restassured.util;

public class StudentAPI {

	public static String getStudentDetailsJson() {
		return "{\r\n"
				+ "\r\n"
				+ "\"studentId\" : 6215489,\r\n"
				+ "\r\n"
				+ "\"firstName\" : \"James\",\r\n"
				+ "\r\n"
				+ "\"lastName\" : \"Bond\",\r\n"
				+ "\r\n"
				+ "\"totalMarks\" : 182,\r\n"
				+ "\r\n"
				+ "\"subjects\" : [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"subjectId\" : \"SCI-1\",\r\n"
				+ "\r\n"
				+ "\"subjectName\" : \"Physics\",\r\n"
				+ "\r\n"
				+ "\"departmentName\" : \"Science\",\r\n"
				+ "\r\n"
				+ "\"marks\" : 87\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"subjectId\" : \"CSE-2\",\r\n"
				+ "\r\n"
				+ "\"subjectName\" : \"Object Oriented Programming\",\r\n"
				+ "\r\n"
				+ "\"departmentName\" : \"Computer Science\",\r\n"
				+ "\r\n"
				+ "\"marks\" : 95\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "],\r\n"
				+ "\r\n"
				+ "\"address\" : {\r\n"
				+ "\r\n"
				+ "\"houseNumber\" : \"2XB\",\r\n"
				+ "\r\n"
				+ "\"street\" : \"Sushant Lok Phase 1\",\r\n"
				+ "\r\n"
				+ "\"city\" : \"Gurgaon\",\r\n"
				+ "\r\n"
				+ "\"state\" : \"Haryana\",\r\n"
				+ "\r\n"
				+ "\"country\" : \"India\",\r\n"
				+ "\r\n"
				+ "\"pincode\" : 122002\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"contactNumbers\" : [1234567890, 9876543210]\r\n"
				+ "\r\n"
				+ "}";
		
	}
}
