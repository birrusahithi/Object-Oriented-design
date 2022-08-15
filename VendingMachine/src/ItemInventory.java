import java.util.HashMap;
import java.util.Map;

public class ItemInventory {
    Map<Item, Integer> itemMap = new HashMap<>();

    public void put(Item m, int quantity) {
        itemMap.put(m, quantity);
    }

    public void deduct(Item m) {
        if (hasItem(m)) {
            int count = itemMap.get(m);
            itemMap.put(m, count - 1);
        }
    }

    public boolean hasItem(Item m) {
        return getQuantity(m) > 0;
    }

    public int getQuantity(Item m) {
        Integer count = itemMap.get(m);
        if (count == null) {
            return 0;
        }
        return count;
    }

    public void clear() {
        itemMap.clear();
    }

    public void add(Item n) {
        int count = itemMap.get(n);
        itemMap.put(n, count);
    }

}
