public class A4{
	public static void main(String[] args) {
		int base10 =0;
		int base = 0;
		
		try{

			base10 = Integer.parseInt(args[0]);
			base = Integer.parseInt(args[1]);
		}
		catch (Exception e){
			System.out.println("You must enter a positive integer for both base 10 and the desired base.");
			
		}
		

	
		if (base10 > 0) {
			String num = Integer.toString(base10);
			String desiredNumber = Integer.toString(base);
			System.out.println("Value of num"+num);
			String res = "";
			int availableCharacters = base-1;
			//int counter = base10;
			int counter=0;
			int temp = 0;
			
			// Your code here...

			//Om talet är 10 så har vi 2^0 2^1 2^2 2^3 , 2^3 räcker efter som 2^4 = 15

			//Beräknar den exponent till det talet som är precis < base10
			for(int j=0; temp<base10;j++){
				temp=(int)(Math.pow(base,j));
				if(temp>base10){
					break;
				}
				System.out.println(temp);
				counter=j;
			}

			System.out.println("Counter"+counter);
			temp=0;
			int remaining= base10;
			for(int i=0; counter>=0;i++){
				
				temp = (int)((remaining)/(Math.pow(base,counter)));
				System.out.println("temp"+temp);
				res +=temp;

				if(temp>0){
					remaining = (int)(remaining-(Math.pow(base,counter)));
					System.out.println(Math.pow(base,counter));
					System.out.println("remaining"+remaining);
				}
				counter-=1;
				
				
				//res = num.charAt(k) + Integer.toString(temp);
			}


			/*
				for (int i = 0; i < num.length(); i++) {
				

				res = num.charAt(i) + res;

				System.out.println(res);

			}

			*/


			// WARNING! Do not change these lines. Use exactly these strings as your output.

			System.out.println(base10 + " in base-10 is " + res + " in base-" + base);
		}
		else{
			//System.out.println("The inputed integer base 10 integer must be a positive number.");

		}
	}
}
