import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {

	public void main(String[] args) {
		SecureRandom r = new SecureRandom();
		Scanner in = new Scanner(System.in);
		int diff = readDifficulty();
		int type = readProblemType(); 
		int c = 1;
		while (c != 0) {
			double d = 0;
			for(int i = 0; i < 10; i++) {
				d += (double)Quiz(i, diff, type, r);
			}
		
			displayCompletionMessage(d);
			
			while (c != 0 || c != 1) {
				System.out.println("Do you want to try another set?");
				System.out.println("[1] Yes");
				System.out.println("[2] No");
			
				c = in.nextInt();
				
				if (c == 1) {
					c = 1;
				}
				if (c == 2) {
					c = 0;
					break;
				}
				else {
					System.out.println("Invalid option! Try again.");
					c = 1;
				}
				c = 1;
			}
		}
		in.close();
	}	
	public int readDifficulty() {
		int x = 0;
		Scanner in = new Scanner(System.in);
		while(x != 1 || x != 2 || x != 3 || x != 4) {
			System.out.println("What difficulty do you want to practice with?");
			System.out.println("[1] Single Digit");
			System.out.println("[2] Double Digit");
			System.out.println("[3] Triple Digit");
			System.out.println("[4] Quad. Digit");
			
			x = in.nextInt();	
			in.close();
			
			if (x == 1) {
				return 9;
			}
			if (x == 2) {
				return 99;
			}
			if (x == 3) {
				return 999;
			}
			if (x == 4) {
				return 9999;
			}
			else {
				System.out.println("Invalid option! Try again.");
				x = 0;
			}
		}
		return 0;
	}
	public int readProblemType() {
		int x = 0;
		Scanner in = new Scanner(System.in);
		while(x != 1 || x != 2 || x != 3 || x != 4 || x != 5) {
			System.out.println("What problem type do you want to practice with?");
			System.out.println("[1] Addition");
			System.out.println("[2] Multiplication");
			System.out.println("[3] Subtraction");
			System.out.println("[4] Division");
			System.out.println("[5] Mixture");
			
			x = in.nextInt();	
			in.close();
			
			if (x == 1) {
				return 1;
			}
			if (x == 2) {
				return 2;
			}
			if (x == 3) {
				return 3;
			}
			if (x == 4) {
				return 4;
			}
			if (x == 5) {
				return 5;
			}
			else {
				System.out.println("Invalid option! Try again.");
				x = 0;
			}
		}
		return 0;
	}
	
	public int Quiz (int i, int diff, int type, SecureRandom r) {
		int a = generateQuestionArgument(diff, r);
		int b = generateQuestionArgument(diff, r);
		int rng = r.nextInt(4);
		int answer = 0;
		
		switch(type) {
			case 1:
				answer = a + b;
				break;
			case 2:
				answer = a * b;
				break;
			case 3:
				answer = a - b;
				break;
			case 4:
				answer = a / b;
				break;
			case 5:
				switch(rng) {
				case 1:
					answer = a + b;
					break;
				case 2:
					answer = a * b;
					break;
				case 3:
					answer = a - b;
					break;
				case 4:
					answer = a / b;
					break;
				}
		}
		
		int c = r.nextInt(4);
		int guess;
		int x, d = 0;
		
		askQuestion(a, b, type, rng++);
		guess = readResponse();
		x = isAnswerCorrect(guess, answer);
		if (x == 0) {
			displayIncorrectResponse(c);
			d = 0;
			return d;			
		}
		if (x == 1) {
			displayCorrectResponse(c);
			d = 1;
			return d;
		}
		
		return d;
	}

	public int generateQuestionArgument(int diff, SecureRandom r) {
		return r.nextInt(diff);
	}
	
	public void askQuestion(int a, int b, int type, int rng) {
		switch(type) {
			case 1:
				System.out.printf("How much is %d plus %d?\n", a, b);
				break;
			case 2:
				System.out.printf("How much is %d times %d?\n", a, b);
				break;
			case 3:
				System.out.printf("How much is %d minus %d?\n", a, b);
				break;
			case 4:
				System.out.printf("How much is %d divided by %d?\n", a, b);
				break;		
			case 5:
				switch(rng) {
				case 1:
					System.out.printf("How much is %d plus %d?\n", a, b);
					break;
				case 2:
					System.out.printf("How much is %d times %d?\n", a, b);
					break;
				case 3:
					System.out.printf("How much is %d minus %d?\n", a, b);
					break;
				case 4:
					System.out.printf("How much is %d divided by %d?\n", a, b);
					break;
				}
		}
		
	}
	
	public int readResponse() {
		Scanner in = new Scanner(System.in);
		int x;
		x = in.nextInt();
		in.close();
		
		return x;
	}
	
	public int isAnswerCorrect(int x, int y){
		if (x == y) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public void displayIncorrectResponse(int y) {
		switch(y) {
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don�t give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;			
		}
	}
	public void displayCorrectResponse(int y) {
	switch(y) {
		case 1:
			System.out.println("Very Good!");
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;	
		}
	}
	
	public void displayCompletionMessage(double d) {
		double result = d / 10.0;
		if (result <= 0.75) {
			System.out.print("Please ask your teacher for extra help");
			System.out.printf(" %d\n", result);
		}
		if (result >= 0.75) {
			System.out.print("Congratulations! you are ready to go to the next level!");
			System.out.printf(" %d\n", result);
		}
	}
}
