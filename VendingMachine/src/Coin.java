public enum Coin {
   Penny(1), Nickel(5), Dime(10), Quarter(25);
    int denominations;
    Coin(int denominations){
        this.denominations= denominations;
    }
    public int getDenominations(){
        return denominations;
    }

}
