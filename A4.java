public class A4{
	public static int base10=0;
	public static int base=0;
	public static String res="";
	private static String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static char[] alphabetCharArray = alphabetString.toCharArray();
	public static void main(String[] args) {
		//int base10 =0;
		//int base = 0;
		
		try{

			base10 = Integer.parseInt(args[0]);
			base = Integer.parseInt(args[1]);
		}
		catch (Exception e){
			System.out.println("You must enter a positive integer for both base 10 and the desired base.");
			
		}
		
		if(base>0){
			//System.out.println(alphabetCharArray.length);
			res=HandleBaseTwoToNine();
			//System.out.println(res);


		}
		//else{
			//res=HandleBase10AndBeyond();

		//}
		// WARNING! Do not change these lines. Use exactly these strings as your output.
		System.out.println(base10 + " in base-10 is " + res + " in base-" + base);
	}

	public static String HandleBaseTwoToNine(){
		String num = Integer.toString(base10);
		String desiredNumber = Integer.toString(base);
		//System.out.println("Value of num"+num);
		//String res = "";
		//int availableCharacters = base-1;
		//int counter = base10;
		int counter=0;
		String temp = "0";
	
		//System.out.println("debugg");
		// Your code here...

		//Om talet är 10 så har vi 2^0 2^1 2^2 2^3 , 2^3 räcker efter som 2^4 = 15

		//Beräknar den exponent till det talet som är precis < base10
		for(int j=0; Integer.valueOf(temp)<base10;j++){
			temp=Integer.toString((int)(Math.pow(base,j)));
			if(Integer.valueOf(temp)>base10){

				//System.out.println("tempdsds:"+temp);
				counter=j-1;

			}
			//System.out.println("temp:"+temp);
			
		}

		//System.out.println("Counter!"+counter);
		String temp1="";
		int remaining= base10;
		//System.out.println(remaining);
		for(int i=0; counter>=0;counter--){
			//System.out.println("remaining:"+remaining);
			temp1 = Integer.toString((int)((remaining)/(Math.pow(base,counter))));

			//System.out.println("Before if statement: temp1:"+temp1);
			//System.out.println("temp1:"+temp1);
		

			
			//System.out.println("tempchar: "+tempchar);
			if(Integer.valueOf(temp1)>0){
				remaining = (int)(remaining%(Math.pow(base,counter)));
				//System.out.println(remaining);
				//System.out.println("exponent "+(Math.pow(base,counter)));

				if(Integer.valueOf(temp1)>9){

					temp1 = String.valueOf(HandleBase10AndBeyond(Integer.valueOf(temp1)));
				}
				//System.out.println("Inside if-loop remaining:"+remaining);
				//System.out.println(Math.pow(base,counter));
				//System.out.println("remaining"+remaining);
			}
			char tempchar= temp1.charAt(0);
			res = res+tempchar;

			//counter-=1;
			
	
		}

	return res;
	}
	public static char HandleBase10AndBeyond(int index){
		char temp=' ';
		for(int k=0;k<alphabetCharArray.length;k++){
			if(k==(index-10)){
				temp=alphabetCharArray[k];
				//System.out.println("temp: "+temp);
				return temp;
			}
		}
		//char temp=alphabetCharArray[index-10];
	return temp;
	}


	

}
