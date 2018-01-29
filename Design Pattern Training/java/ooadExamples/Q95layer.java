/* This program below implements a game called "MasterMind". The game
 * is played like this: the computer "comes up with" a secret code such
 * as "RGBY" in which "R" means red, "G" means green, "B" means blue,
 * "Y" means yellow, "P" means pink, "C" means cyan.
 * The task of the player is to try to find out this secret code.
 * Every turn the player can input a code also consisting of four colors
 * such as "RBPY". In this case, he has got "R" correct because the
 * secret code also contains "R" in the first position. The same is true
 * for "Y". In contrast, the secret code contains "B", but the position is
 * not correct. In response to the guess, the computer will tell the player
 * that he has got two pegs in correct color and position (but will not tell
 * him that they are "R" and "Y") and that he has got one peg in the
 * correct color but incorrect position (but will not tell him that
 * it's "B"). The player has at most 12 turns. If he can find out the
 * secret code within 12 turns, he wins. Otherwise he loses.
 *
 * 	Point out and remove the problems in the code below.
 *
 */
class MasterMind {
    String secret = "RGBY";
    static public void main(String args[]) {
        new MasterMind();
    }
    MasterMind() {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        for (i = 0; i < 12;) { //can guess at most 12 times
            String currentGuess = br.readLine();
            String currentSecret = secret;
            int m = 0; //how many pegs are right in color and position.
            int n = 0; //how many pegs are right in color but wrong position.
            //valid the colors and find those in right color and position.
            for (j = 0; j < currentGuess.length();) {
                //must sure each peg is one of: Red, Yellow, Pink,
                //Green, Blue or Cyan.
                if ("RYPGBC".indexOf(currentGuess.charAt(j))==-1) {
                    System.out.println("Invalid color!");
                    break;
                }
                if (currentGuess.charAt(j)== currentSecret.charAt(j)) {
                    //right color and position.
                    m++;
                    //delete the peg.
                    currentGuess=currentGuess.substring(0, j)+
                            currentGuess.substring(j+1);
                    currentSecret=
                            currentSecret.substring(0, j)+
                            currentSecret.substring(j+1);
                } else {
                    j++;
                }
            }
            //see how many pegs are in right color but wrong position.
            for (j = 0; j < currentGuess.length();) {
                //is it in right color regardless of the position?
                k = currentSecret.indexOf(guess.charAt(j));
                if (k!=-1) {
                    n++;
                    //delete the peg.
                    currentGuess=currentGuess.substring(0, j)+
                        currentGuess.substring(j+1);
                    currentSecret=currentSecret.substring(0, k)+
                        currentSecret.substring(k+1);
                } else {
                    j++;
                }
            }
            System.out.println(m+" are right in color and position");
            System.out.println(n+" are right in color but wrong position");
            if (m==4) { //all found?
                System.out.println("You won!");
                return;
            }
            i++;
        }
        System.out.println("You lost!");
    }
}