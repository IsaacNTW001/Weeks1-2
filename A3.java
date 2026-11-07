public class A3{
	public static void main(String[] args) {
		int nrOfMatches = Integer.parseInt(args[0]);
		double betHome = Double.parseDouble(args[1]);
		double betAway = Double.parseDouble(args[2]);
		int awayWins = 0;
		int awayTies = 0;
		int awayLosses = 0;
		int homeWins = 0;
		int homeTies = 0;
		int homeLosses = 0;
		int probability = 0;
		double balance = 0;
		double homeBalance=0;
		double awayBalance=0;
		double homeWinPayout=1.5;
		double homeLoseTiePayout=1;
		double awayWinPayout = 3.25;
		double awayLoseTiePayout=1;


		// Your code here...



		//Probability for Home matches:
		int numberOfHomeMatches = (nrOfMatches/2)+ (nrOfMatches%2);
		System.out.println(numberOfHomeMatches);

		for(int i=0; i<=numberOfHomeMatches-1;i++){
			//I wrote 101 due to the documentation behind Math.random generating a number in the following intervall: 0<=x<1;
			probability = (int)((Math.random())*101);
			//Win probability for home matches.
			if(probability>0 && probability<=66){
				homeWins+=1;
				homeBalance+= betHome*homeWinPayout;
			}
			// Tie probability for home matches.
			else if(probability>66 && probability<=90){
				homeTies+=1;
				homeBalance-= betHome*homeLoseTiePayout;
			}
			//Loss probability for home matches.
			else if(probability>90 && probability<=100){
				homeLosses+=1;
				homeBalance-= betHome*homeLoseTiePayout;
			}

			
			//System.out.println(probability+" "+numberOfHomeMatches);
			homeBalance+= (homeWins*homeWinPayout) - ((homeTies+homeLosses)*homeLoseTiePayout);
			//System.out.println(homeBalance);
		}
		System.out.println(homeBalance);
		
		//Probability for Away matches:
		probability = 0;
		System.out.println(probability);
		int numberOfAwayMatches = nrOfMatches/2;
		System.out.println(numberOfAwayMatches);
		for(int j=0;j<=numberOfAwayMatches-1;j++){
			probability = (int)((Math.random())*101);
			//Win probability for away matches.
			if(probability>0 && probability<=30){
				awayWins+=1;
				awayBalance= betAway*awayWinPayout;
			}
			//Tie probability for away matches.
			else if(probability>30 && probability<=60){
				awayTies+=1;
				awayBalance = betAway*awayLoseTiePayout;
			}
			//Loss probability for away matches
			else if(probability>60 && probability<=100){
				awayLosses+=1;
				awayBalance = betAway*awayLoseTiePayout;
			}
			awayBalance+= (awayWins*awayWinPayout) - ((awayTies+awayLosses)*homeLoseTiePayout);
		}

		System.out.println(awayBalance);
		balance = homeBalance + awayBalance;
		// WARNING! Do not change these lines. Use exactly these strings as your output.

		System.out.println("Home:" + homeWins + " wins, " + homeTies + " ties, " + homeLosses + " loses");
		System.out.println("Away: " + awayWins + " wins, " + awayTies + " ties, " + awayLosses + " loses");
		System.out.println("Balance: SEK " + balance);
		
	}
}
