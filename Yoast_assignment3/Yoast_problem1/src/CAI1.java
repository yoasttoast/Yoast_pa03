import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {

	public void main(String[] args) {
		SecureRandom r = new SecureRandom();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		Quiz(a, b);
		
	}
	
	public void Quiz (int a, int b) {
		int answer = a * b;
		int guess;
		int x;
		
		askQuestion(a,b);
		guess = readResponse();
		x = isAnswerCorrect(guess, answer);
		if (x == 0) {
			displayIncorrectResponse();
			Quiz(a,b);
		}
		if (x == 1) {
			displayCorrectResponse();
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
	
	public void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	public void displayCorrectResponse() {
		System.out.println("Very Good!");
	}
	
}
