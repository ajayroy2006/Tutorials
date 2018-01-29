/* This program below implements a game called "Hangman". The game is
 * played like this: the computer "comes up with" a secret such as "banana".
 * The task of the player is to try to find out this secret. Every turn the
 * player can input one english letter such as "a", then the
 * computer will show the "a" letters in the secret (if any), while the
 * other letters will be shown as a dash. For example, in this case, the
 * computer will show "-a-a-a". In the next turn if the player inputs "b",
 * the computer will show "ba-a-a". In the next turn if the player inputs "c",
 * the computer will still show "ba-a-a" because there is no "c" in
 * the secret. The player has at most 7 turns. If he can find out the secret
 * within 7 turns, he wins. Otherwise he loses. If the player inputs say
 * "b" again, the computer will tell him that it has been guessed before
 * and this guess is not counted (not included in the 7 turns).
 *
 *	Point out and remove the problems in the code below.
 */
class Hangman {
    String secret = "banana";
    String guessedChars = "";
    static public void main(String args[]) {
        new Hangman();
    }
    Hangman() {
        BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in));
        for (int k = 0; k < 7;) { //can guess at most 7 times
            String s = ""; //partially found secret
            for (int i=0; i<secret.length(); i++) {
                char ch = secret.charAt(i);
                if (guessedChars.indexOf(ch)<0) //has it been guessed?
                    ch = '-'; //no, hide it. just show a dash.
                s = s+ch;
            }
            System.out.println("Secret: "+s);
            System.out.print("Guess letter: ");
            char ch = br.readLine().charAt(0); //read just one char
            if (guessedChars.indexOf(ch)>=0) { //already guessed?
                System.out.println("You have guessed this char!");
                continue;
            }
            int n = numberOfFoundChars();
            guessedChars = guessedChars+ch;
            int m = numberOfFoundChars();
            if (m>n) {
                System.out.println("Success, you have found letter "+ch);
                System.out.println("Letters found: "+m);
            }
            if (m==secret.length()) {
                System.out.println("You won!");
                return;
            }
            k++;
        }
        System.out.println("You lost!");
    }

    int numberOfFoundChars() {
        int n = 0;
        for (int i=0; i< secret.length(); i++) {
            char ch = secret.charAt(i);
            if (guessedChars.indexOf(ch)>=0)
                n++;
        }
        return n;
    }
}
