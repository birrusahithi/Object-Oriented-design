public class Ticket<J, L> {
    J first;
    L second;
    Ticket(J first, L sec){
        this.first = first;
        this.second = sec;
    }
    public J getFirst(){
        return first;
    }
    public  L getSecond(){
        return second;
    }

}
