import java.util.List;

public interface VendhingMachine {
    public long selectItemAndGetPrice(Item item);
    public void insertCoin(Coin c);
    public List<Coin> refund();
    public void reset();
    public Bucket<List<Coin>, Item> collectItemAndChange();

}
;

