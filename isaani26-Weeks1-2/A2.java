public class A2{

	public static void main(String[] args) {
		String firstName = args[0].toLowerCase().replace('ö', 'o').replace('ä', 'a').replace('å', 'a');
		String lastName = args[1].toLowerCase().replace('ö', 'o').replace('ä', 'a').replace('å', 'a');
		String admissionYear = args[2].toLowerCase();
		String userName ="";
		if(admissionYear.length() !=4){
			System.out.println("You must enter a year with 4 integers.");
		}
		else{
			// Modify and complete the following code
			if(firstName.length()>=3 && lastName.length()>=3){
				userName = firstName.substring(0,3) + lastName.substring(0,3)+admissionYear.substring(2,4);
					
				String email = userName + "@student.hh.se";

				// WARNING! Do not change these lines. Use exactly these strings as your output.

				System.out.println("Username: " + userName);
				System.out.println("E-mail address: " + email);
			}
			else{
				System.out.println("You must enter a first name and a last name that has more than atleast 3 characters each.");
			}

		}
		
		
	}
}
