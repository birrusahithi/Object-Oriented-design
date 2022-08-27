import java.util.List;

public interface Parking {
    public Ticket<Integer, List<String>> selectCarTypeGetTicket(CarType carType);
    public TicketResponse payment(Ticket<Integer, List<String>> entryTicket);
    public void reset();
}
