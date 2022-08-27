import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CarSlots {
    final int slotsare = 50;
    Map<CarType, Integer> map = new HashMap<>();
    Stack<Integer> compactSlot = new Stack<>();
    Stack<Integer> bikestack = new Stack<>();
    Stack<Integer> handicappedStack = new Stack<>();
    Stack<Integer> truckslots = new Stack<>();
    int returnSlotNumber;

    public int getReturnSlotNumber() {
        return returnSlotNumber;
    }

    public void add(CarType cartypes) {
        if (!isSlotFull(cartypes)) {
            map.put(cartypes, map.get(cartypes) - 1);
            if (cartypes.getCarTypeName() == "Compact") {
                returnSlotNumber = compactSlot.peek();
                compactSlot.pop();
            } else if (cartypes.getCarTypeName() == "Bike") {
                returnSlotNumber = bikestack.peek();
                        bikestack.pop();
            } else if (cartypes.getCarTypeName() == "Truck") {
                returnSlotNumber = bikestack.peek();
                truckslots.pop();
            } else {
                returnSlotNumber = bikestack.peek();
                handicappedStack.pop();
            }
        } else {
            throw new SlotsFullException("Sorry, Slots are full");
        }
    }

    public void deduct(CarType carType, int slotNumber) {
        map.put(carType, map.get(carType) + 1);
        if (carType.getCarTypeName() == "Compact") {
            compactSlot.push(slotNumber);
        } else if (carType.getCarTypeName() == "Truck") {
            bikestack.push(slotNumber);
        } else if (carType.getCarTypeName() == "Handicapped") {
            handicappedStack.push(slotNumber);
        } else {
            bikestack.push(slotNumber);
        }
    }

    public boolean isSlotFull(CarType carType) {
        if (map.get(carType) == 0) {
            return true;
        }
        return false;
    }

    public void put(CarType carTypes) {
        if (carTypes.getCarTypeName() == "Compact") {
            map.put(carTypes, carTypes.count);
            for (int i = 1; i <= 30; i++) {
                compactSlot.push(i);
            }
        } else if (carTypes.getCarTypeName() == "Bike") {
            map.put(carTypes, carTypes.count);
            for (int j = 31; j <= 35; j++) {
                bikestack.push(j);
            }
        } else if (carTypes.getCarTypeName() == "Handicapped") {
            map.put(carTypes, carTypes.count);
            for (int j = 36; j <= 45; j++) {
                handicappedStack.push(j);
            }
        } else {
            map.put(carTypes, carTypes.count);
            for (int j = 46; j <= 50; j++) {
                truckslots.push(j);
            }
        }
    }

    public static void main(String[] args) {
        CarSlots obj = new CarSlots();

    }
}
