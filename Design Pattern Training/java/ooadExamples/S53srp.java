class PianoKey {
    final static PianoKey key0 = new PianoKey(frequency_for_key0);
    final static PianoKey key1 = new PianoKey(frequency_for_key1);
    final static PianoKey key2 = new PianoKey(frequency_for_key2);
    ...
    int frequency;
    private PianoKey(int frequency) {
        this.frequency = frequency;
    }
    public void playSound() {
        //play the frequency.
    }
}
class Piano {
    Vector rythmn;
    public void play() {
        for(int i=0;i<rythmn.size();i++)
            ((PianoKey) rythmn.elementAt(i)).playSound();
    }
}
