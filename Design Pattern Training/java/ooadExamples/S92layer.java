/* UI was mixed with the domain logic. Extract the domain logic into a 
 * class like Hangman and rename the original one as HangmanApp. 
 * Make sure that HangmanApp uses Hangman but not the reverse.
 */

//Domain Logic
class Hangman {
	final static int MAXNOGUESSES = 7;
	String secret = "banana";
	String guessedChars = "";
	boolean reachMaxNoGuesses() {
		return getNoGuessedChars()==MAXNOGUESSES;
	}
	int getNoGuessedChars() {
		return guessedChars.length();
	} 
	boolean hasBeenGuessed(char ch) {
		return guessedChars.indexOf(ch)>=0;
	}
	String getPartiallyFoundSecret() {
		String partiallyFoundSecret = "";
		for (int i=0; i< secretLength(); i++) {
			char ch = secret.charAt(i);
			char chToShow = hasBeenGuessed(ch) ? ch : '-';
			partiallyFoundSecret = partiallyFoundSecret+chToShow;
		}
		return partiallyFoundSecret;
	} 
	boolean guess(char ch) {
		int n = numberOfFoundChars();
		guessedChars = guessedChars+ch;
		int m = numberOfFoundChars();
		return m>n;
	} 
	boolean isSecretFound() {
		return numberOfFoundChars()==secretLength();
	}
	int numberOfFoundChars() {
		int n = 0;
		for (int i=0; i< secretLength(); i++) {
			char ch = secret.charAt(i);
			if (guessedChars.indexOf(ch)>=0)
				n++;
		}
		return n;
	}
	int secretLength() {
		return secret.length();
	}
}

//User interface
class HangmanApp {
	static public void main(String args[]) {
		new HangmanApp();
	}
	HangmanApp() {
		Hangman hangman = new Hangman();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		while (!hangman.reachMaxNoGuesses()) {
			System.out.println("Secret: "+hangman.getPartiallyFoundSecret());
			System.out.print("Guess letter: ");
			char ch = readOneChar(br);
			if (hangman.hasBeenGuessed(ch)) {
				System.out.println("You have guessed this char!");
				continue;
			}
			if (hangman.guess(ch)) {
				System.out.println("Success, you have found letter "+ch);
				System.out.println("Letters found: "+
				hangman.numberOfFoundChars());
			}
			if (hangman.isSecretFound()) {
				System.out.println("You won!");
				return;
			}
		} 
		System.out.println("You lost!");
	} 
	char readOneChar(BufferedReader br) {
		return br.readLine().charAt(0);
	}
}
