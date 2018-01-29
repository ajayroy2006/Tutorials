//Improve the code
class Currency {
    final public int USD=0;
    final public int RMB=1; //Chinese currency
    final public int ESCUDO=2; //Portuguese currency
    private int currencyCode;
    public Currency(int currencyCode) {
        this.currencyCode=currencyCode;
    }
    public String format(int amount) {
        switch (currencyCode) {
        case USD:
            //return something like $1,200
        case RMB:
            //return something like RMB1,200
        case ESCUDO:
            //return something like $1.200
        }
    }
}