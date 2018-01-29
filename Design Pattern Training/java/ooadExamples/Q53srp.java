class PianoKey {
    final static int key0 = 0;
    final static int key1 = 1;
    final static int key2 = 2;
    int keyNumber;
    public void playSound() {
        if (keyNumber == 0) {
            //play the frequency for key0
        }
        else if (keyNumber == 1) {
            //play the frequency for key1
        }
        else if (keyNumber == 2) {
            //play the frequency for key2
        }
    }
	//Function to set keyNumber to key0, key1 or key2
}
class Piano {
    Vector rythmn;
    public void play() {
        for(int i=0;i<rythmn.size();i++)
            ((PianoKey) rythmn.elementAt(i)).playSound();
    }
}
