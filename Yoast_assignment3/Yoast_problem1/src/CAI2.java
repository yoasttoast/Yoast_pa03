import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {

	public void main(String[] args) {
		SecureRandom r = new SecureRandom();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		Quiz(a, b, r);
		
	}
	
	public void Quiz (int a, int b, SecureRandom r) {
		int answer = a * b;
		int c = r.nextInt(4);
		int guess;
		int x;
		
		askQuestion(a,b);
		guess = readResponse();
		x = isAnswerCorrect(guess, answer);
		if (x == 0) {
			displayIncorrectResponse(c);
			Quiz(a,b,r);
		}
		if (x == 1) {
			displayCorrectResponse(c);
			Quiz(a,b,r);
		}
		
	}

	public void askQuestion(int a, int b) {
		System.out.printf("How much is %d times %d?\n", a, b);
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
				System.out.println("Don’t give up!");
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
}
