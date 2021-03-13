package firstProject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DummyMain {
	public static void main(String[] args){
//		List<String> appendableListOfTestCaseIDsForRun = new ArrayList<>();
//		appendableListOfTestCaseIDsForRun.add("1212");
//		appendableListOfTestCaseIDsForRun.add("0421");
//		appendableListOfTestCaseIDsForRun.add("2512");
//		String listAsString = String.valueOf(appendableListOfTestCaseIDsForRun);
//		String updateRunWithCaseJSON = String.format("{\n" +
//				"  \"case_ids\": %s \n}", appendableListOfTestCaseIDsForRun);
//		System.out.println(updateRunWithCaseJSON);

//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.MONTH, 2 + 1);
//		cal.add(Calendar.YEAR, 3 + 1);
//		System.out.println(new SimpleDateFormat("MMMM").format(cal.getTime()));

		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
	}
}
