public enum ParkingHoursAndRate {
    First(2, 5), Second(6, 10), Third(8, 25), Fourth(15, 30), Fifth(24, 45);
    int hours;
    int price;
    ParkingHoursAndRate(int hours, int price){
        this.hours = hours;
        this.price = price;
    }

    public int getHours() {
        return hours;
    }

    public int getPrice() {
        return price;
    }
}
