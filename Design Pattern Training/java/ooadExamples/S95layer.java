//Domain logic
class MasterMind {
    static final int MAX_NO_GUESSES=12;
    static final int NO_PEGS=4;
    String secret = "RGBY";
    GuessResult makeGuess(String guess) {
        GuessPartialResult partialResult=
            new GuessPartialResult(secret, guess);
        partialResult.validateColors();
        partialResult.findPegsInRightColorAndPos();
        partialResult.findPegsInRightColorIgnorePos();
        return partialResult.makeFinalResult();
    }
}
class InvalidColorException extends RuntimeException {
}
class GuessPartialResult {
    String secretLeft;
    String guessLeft;
    int noPegsInRightColorAndPos;
    int noPegsInRightColorButWrongPos;
    GuessPartialResult(String initSecret, String initGuess) {
        secretLeft=initSecret;
        guessLeft=initGuess;
    }
    void validateColors() {
        for (int j = 0; j < guessLeft.length();) {
            assertValidColor(guessLeft.charAt(j));
        }
    }
    void assertValidColor(char color) throws InvalidColorException {
        final String RED="R";
        final String YELLOW="Y";
        final String PINK="P";
        final String GREEN="G";
        final String BLUE="B";
        final String CYAN="C";
        final String VALID_COLORS=RED+YELLOW+PINK+GREEN+BLUE+CYAN;
        if (VALID_COLORS.indexOf(color)==-1) {
            throw new InvalidColorException();
        }
    }
    void findPegsInRightColorAndPos() {
        for (int j = 0; j < guessLeft.length();) {
            if (isPegInRightColorAndPos(j)) {
                noPegsInRightColorAndPos++;
                guessLeft=deletePegAt(guessLeft, j);
                secretLeft=deletePegAt(secretLeft, j);
            } else {
                j++;
            }
        }
    }
    void findPegsInRightColorIgnorePos() {
        for (int j = 0; j < guessLeft.length();) {
            int k = findFirstPegInSecretOfColor(guessLeft.charAt(j));
            if (k!=-1) {
                noPegsInRightColorButWrongPos++;
                guessLeft=deletePegAt(guessLeft, j);
                secretLeft=deletePegAt(secretLeft, k);
            } else {
                j++;
            }
        }
    }
    boolean isPegInRightColorAndPos(int idx) {
        return guessLeft.charAt(idx)== secretLeft.charAt(idx);
    }
    int findFirstPegInSecretOfColor(char color) {
        return secretLeft.indexOf(color);
    }
    String deletePegAt(String pegs, int idx) {
        return pegs.substring(0, idx)+pegs.substring(idx+1);
    }
    GuessResult makeFinalResult() {
        return new GuessResult( noPegsInRightColorAndPos,
                noPegsInRightColorButWrongPos);
    }
}
class GuessResult {
    int noPegsInRightColorAndPos;
    int noPegsInRightColorButWrongPos;
    boolean allFound() {
        return noPegsInRightColorAndPos==MasterMind.NO_PEGS;
    }
}

//User Interface
class MasterMindApp {
    static public void main(String args[]) {
        new MasterMindApp();
    }
    MasterMindApp() {
        MasterMind masterMind = new MasterMind();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String guess = br.readLine();
        for (int i = 0; i < MasterMind.MAX_NO_GUESSES;) {
            try {
                GuessResult guessResult = masterMind.makeGuess(guess);
                System.out.println(
                guessResult.getNoPegsInRightColorAndPos()+
                    " are right in color and position");
                System.out.println(
                    guessResult.getNoPegsInRightColorButWrongPos()+
                    " are right in color but wrong position");
                if (guessResult.allFound()) {
                    System.out.println("You won!");
                    return;
                }
            } catch (InvalidColorException e) {
                System.out.println("Invalid color!");
                break;
            }
            i++;
        }
        System.out.println("You lost!");
    }
}