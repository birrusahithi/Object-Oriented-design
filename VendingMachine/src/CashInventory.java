import java.util.HashMap;
import java.util.Map;

public class CashInventory {
    Map<Coin, Integer> map = new HashMap<>();
    public int getQuantity(Coin c){
        Integer value = map.get(c);
        if(value==null){
            return 0;
        }
        return value;
    }
    public void add(Coin c){
        int count = map.get(c);
        map.put(c, count+1);
    }
    public void deduct(Coin c){
        if(hasItem(c)){
            int count = map.get(c);
            map.put(c, count-1);
        }
    }
    public boolean hasItem(Coin c){
        return getQuantity(c)>0;
    }
    public void put(Coin c, int quantity){
        map.put(c, quantity);
    }
    public void clear(){
        map.clear();
    }
}
