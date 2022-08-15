public enum Item {
    COKE("Coke", 25), PEPSI("Pepsi",35), SODA("Soda", 45);
    String name;
    int price;
     Item(String n, int p){
        this.name = n;
        this.price=p;
    }
    public String getName(){
        return name;
    }
    public long getPrice(){
        return price;
    }
}
