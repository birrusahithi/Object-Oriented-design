public enum Coin {
    One(1), Two(2), Five(5), Ten(10), Twenty(20), Fifty(50), Hundred(100);
    int denominations;
    Coin(int den){
        this.denominations = den;
    }
    public int getDenominations(){
        return denominations;
    }
}
