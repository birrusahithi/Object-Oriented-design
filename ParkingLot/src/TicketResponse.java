import java.util.List;

public class TicketResponse {
    String str;
    Integer ticketNo;
    List<Coin> coins;

    public void setStr(String str) {
        this.str = str;
    }

    public void setTicketNo(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

}
