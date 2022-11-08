import java.util.HashMap;
import java.util.Map;

public class DesignATMMachine {
    Map<Integer, Integer> map;
    int[] denominations = {20, 50, 100, 200, 500};

    DesignATMMachine() {
        map = new HashMap<>();
    }

    public void deposit(int[] banknotes) {
        for (int i = 0; i < banknotes.length; i++) {
            if (map.containsKey(denominations[i])) {
                map.put(denominations[i], map.get(denominations[i]) + banknotes[i]);
            } else {
                map.put((denominations[i]), banknotes[i]);
            }
        }
    }

    public int[] withdraw(int amount) {
        int[] arr = new int[5];
        int reject = 0;
        while (amount >= denominations[4] || amount >= denominations[3] || amount >= denominations[2] || amount >= denominations[1] || amount >= denominations[0]) {
            if (amount >= denominations[4] && map.get(denominations[4]) > 0) {
                arr[4] = arr[4] + 1;
                map.put(denominations[4], map.get(denominations[4]) - 1);
                amount -= denominations[4];
            } else if (amount >= denominations[3] && map.get(denominations[3]) > 0) {
                arr[3] = arr[3] + 1;
                map.put(denominations[3], map.get(denominations[3]) - 1);
                amount -= denominations[3];
            } else if (amount >= denominations[2] && map.get(denominations[2]) > 0) {
                arr[2] = arr[2] + 1;
                map.put(denominations[2], map.get(denominations[2]) - 1);
                amount -= denominations[2];
            } else if (amount >= denominations[1] && map.get(denominations[1]) > 0) {
                arr[1] = arr[1] + 1;
                map.put(denominations[1], map.get(denominations[1]) - 1);
                amount -= denominations[1];
            } else if (amount >= denominations[0] && map.get(denominations[0]) > 0) {
                arr[0] = arr[0] + 1;
                map.put(denominations[0], map.get(denominations[0]) - 1);
                amount -= denominations[0];
            } else {
                reject = 1;
            }
        }
        if (reject == 1) {
            for (int i = 0; i < arr.length; i++) {
                map.put(denominations[i], map.get(denominations[i]) + arr[i]);
            }
           int[] arrs = new int[0];
            arr[0]=-1;
            return arrs;
         }
return arr;
        }
        public static void main(String[] args){
        DesignATMMachine obj = new DesignATMMachine();
        int[] insert = {0,0,1,2,1};
        obj.deposit(insert);
        obj.withdraw(600);
        int[] inserts = {0,1, 0,1,1};
        obj.deposit(inserts);
        obj.withdraw(600);
        obj.withdraw(550);
        }
    }

