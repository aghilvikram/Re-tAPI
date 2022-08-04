package learning.restassured;

import io.restassured.path.json.JsonPath;
import learning.restassured.util.StudentAPI;

public class StudentAPIJsonValidation {
	public static void main(String[] args) {
		JsonPath studentJson = new JsonPath(StudentAPI.getStudentDetailsJson());
		// System.out.println(studentJson.getString("firstName"));
		// no of subjects
		int noOfSubject = studentJson.getInt("subjects.size()");
		System.out.println("no of subjects:" + noOfSubject);
		// subname&depname
		for (int i = 0; i < noOfSubject; i++) {
			String subjectName = studentJson.getString("subjects[" + i + "].subjectName");
			String departmentName = studentJson.getString("subjects[" + i + "].departmentName");
			System.out.println("subjectName is:" + subjectName);
			System.out.println("departmentName is:" + departmentName);
		}

		// pincode of student
		System.out.println("Pincode is:" + studentJson.getInt("address.pincode"));

//     System.out.println(studentJson.getString("subjects[0].subjectName"));
//     System.out.println(studentJson.getString("subjects[0].departmentName"));
//     System.out.println(studentJson.getString("subjects[1].subjectName"));
//     System.out.println(studentJson.getString("subjects[1].departmentName"));

		// marks in oops
		System.out.println("marks in oops:" + studentJson.getInt("subjects[1].marks"));
		int total;
		int mark1 = studentJson.getInt("subjects[0].marks");
		int mark2 = studentJson.getInt("subjects[1].marks");
		total = mark1 + mark2;
		System.out.println("total mark is" + total);

		int totalMarks = studentJson.getInt("totalMarks");
		if (total == totalMarks) {
			System.out.println("TotalMark is equal");
		}
	}
}
