
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneList{

	static ArrayList<String> output = new ArrayList<String>();


	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		ArrayList<String> tempValues = new ArrayList<String>();

		int numberOfTestCases = 0;
		int numberOfPhoneNumbers = 0;
		String phoneNumber = "";
		int testCaseCounter = 0;


		do {
			if(numberOfTestCases == 0) {
				numberOfTestCases = scanner.nextInt();
			}

			for(int i = 0; i < numberOfTestCases; i++) {
				numberOfPhoneNumbers = scanner.nextInt();

				for(int j = 0; j < numberOfPhoneNumbers; j++) {
					phoneNumber = scanner.next();
					tempValues.add(phoneNumber);
				}

				validateNumbers(tempValues);

				testCaseCounter++;

				if(numberOfTestCases == testCaseCounter) {
					scanner.close();
					for(String str : output) {
						System.out.println(str);
					}
					System.exit(0);
				}
				tempValues.clear();
			}
		} while (scanner.hasNext());
		scanner.close();
	}




	public static void validateNumbers(ArrayList<String> testList) {

		String nr1 = "";
		String nr2 = "";
		String status = "YES";

		Collections.sort(testList);

		for(int i = 0; i < testList.size() - 1; i++) {
			nr1 = testList.get(i).toString();
			nr2 = testList.get(i + 1).toString();

			if(nr2.startsWith(nr1)) {
				status = "NO";
				break;
			}
		}

		output.add(status);
	}
}

