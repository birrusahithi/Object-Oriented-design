public enum CarType {
    Car("Compact", 30), Bike("Bike", 5), CarHandicapped("Handicapped", 10), Truck("Truck", 5);
    String carTypeName;
    int count;

    CarType(String n, int c) {
        this.carTypeName = n;
        this.count = c;
    }

    public String getCarTypeName() {
        return carTypeName;
    }
    public int getCount(){
        return count;

    }
}
