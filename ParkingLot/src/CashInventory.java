import java.util.HashMap;
import java.util.Map;

public class CashInventory {
    Map<Coin, Integer> cashinv = new HashMap<>();
    public void add(Coin c){
        cashinv.put(c, cashinv.get(c)+1);
    }
    public int getQuant(Coin c){
        Integer count = cashinv.get(c);
        if(count==null){
            return 0;
        }
        return count;
    }
    public void deduct(Coin c){
        Integer count = cashinv.get(c);
        cashinv.put(c, count-1);

    }
    public void put(Coin c, int quantity){
        cashinv.put(c, quantity);
    }

}
