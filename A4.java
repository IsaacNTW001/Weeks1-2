public class A4{
	public static int base10=0;
	public static int base=0;	
	public static String res="";
	private static String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static char[] alphabetCharArray = alphabetString.toCharArray();
	public static void main(String[] args) {
		
		try{
			base10 = Integer.parseInt(args[0]);
			base = Integer.parseInt(args[1]);
		}
		catch (Exception e){
			System.out.println("You must enter a positive integer for both base 10 and the desired base.");
			
		}
		
		if(base>0){

			res=HandleBaseTwoToNine();
		}

		// WARNING! Do not change these lines. Use exactly these strings as your output.
		System.out.println(base10 + " in base-10 is " + res + " in base-" + base);
	}

	public static String HandleBaseTwoToNine(){
		String num = Integer.toString(base10);
		String desiredNumber = Integer.toString(base);

		int counter=0;
		String temp = "0";
	

		// Your code here...
		/*
		This for loop gets the highest exponent for the desired base. Eg if the inputed number is 10 and the desired base is 2,
		then it will loop until 2^4 =16 and then compare it to the desired number. If if the integer with the exponent is bigger than 
		the inputed number then it will store in in the variable counter and subract one since 16>10.
	
		*/
		for(int j=0; Integer.valueOf(temp)<base10;j++){
			temp=Integer.toString((int)(Math.pow(base,j)));
			if(Integer.valueOf(temp)>base10){
				counter=j-1;
			}

			
		}


		String temp1="";
		int remaining= base10;
		/*
		This loop iterates based on counter and divides the desired base raised to the power of counter to get the quota.
		Eg. if it 10 base 10 --> ? base 2. The base raised to the power of counter will be 2^3 = 8 and then take it in order to
		preform the following operation: 10/8. The 8 only fits one time in 10. which means our first digit is 1. We then take 10 and subtract it
		with the base^counter to prepare for the next iteration of the loop. The loop continues until all digits that were input into base10 iterated through.

		*/
		for(int i=0; counter>=0;counter--){

			temp1 = Integer.toString((int)((remaining)/(Math.pow(base,counter))));

			if(Integer.valueOf(temp1)>0){
				remaining = (int)(remaining%(Math.pow(base,counter)));
				if(Integer.valueOf(temp1)>9){

					temp1 = String.valueOf(HandleBase10AndBeyond(Integer.valueOf(temp1)));
				}
			}

			char tempchar= temp1.charAt(0);
			res = res+tempchar;			
		}

	return res;
	}
	/*
	This method goes through a declared char array and gets the desired letter based on index.
	The if statement contains -10 since we only start using letters if the quota is >9, since 10=A, 11=B and so on.
	*/
	public static char HandleBase10AndBeyond(int index){
		char temp=' ';
		for(int k=0;k<alphabetCharArray.length;k++){
			if(k==(index-10)){
				temp=alphabetCharArray[k];

				return temp;
			}
		}

	return temp;
	}


	

}
