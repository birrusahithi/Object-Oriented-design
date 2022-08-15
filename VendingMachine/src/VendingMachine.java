import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine implements VendhingMachine {
    CashInventory cashobj = new CashInventory();
    ItemInventory itemInventory = new ItemInventory();
    public Item currentItem;
    public long totalSales;
    private long currentBalance;

    VendingMachine(){
        initialize();
    }

    public void initialize() {
        for (Coin c : Coin.values()) {
            cashobj.put(c, 5);
        }
        for (Item i : Item.values()) {

        }
    }

    public long selectItemAndGetPrice(Item m) {
        if (itemInventory.hasItem(m)) {
            currentItem = m;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Item sold out, please select another item");
    }

    @Override
    public void insertCoin(Coin c) {
        currentBalance += c.getDenominations();
        cashobj.add(c);
    }


    public Bucket<List<Coin>, Item> collectitemAndChange() {
        Item it = collectItem();
        totalSales += currentItem.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<List<Coin>, Item>(change, it);

    }

    public Item collectItem() throws NotSufficientChangeException, NotFullPaidException {
        if (isFullPaid()) {
            if (hasSufficientChange()) {
                itemInventory.deduct(currentItem);
                return currentItem;
            }

            throw new NotSufficientChangeException("Not Sufficient change");
        }
        long remainingbal = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Not full paid", remainingbal);
    }


    public boolean isFullPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        }
        return false;
    }

    public boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    public boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }
        return hasChange;
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance = currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentItem=null;
        currentBalance=0;
        return change;
    }

    public List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;
        if (amount > 0) {
            changes = new ArrayList<>();
            long remaining = amount;
            while (remaining > 0) {
                if (remaining >= Coin.Quarter.getDenominations() && cashobj.hasItem(Coin.Quarter)) {
                    changes.add(Coin.Quarter);
                    remaining -= Coin.Quarter.getDenominations();
                } else if (remaining >= Coin.Nickel.getDenominations() && cashobj.hasItem(Coin.Nickel)) {
                    changes.add((Coin.Nickel));
                    remaining w= remaining - Coin.Nickel.getDenominations();
                    continue;
                } else if (remaining >= Coin.Dime.getDenominations() && cashobj.hasItem(Coin.Dime)) {
                    changes.add(Coin.Dime);
                    remaining -= Coin.Dime.getDenominations();
                } else if (remaining >= Coin.Penny.getDenominations() && cashobj.hasItem(Coin.Penny)) {
                    changes.add(Coin.Penny);
                    remaining -= Coin.Penny.getDenominations();
                } else {
                    throw new NotSufficientChangeException("Not Sufficient");
                }
            }
        }
        return changes;
    }

    public void updateCashInventory(List change) {
        for (Coin ca : change) {
            cashobj.deduct(ca);
        }
    }

    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    public void reset() {
        currentItem = null;
        cashobj.clear();
        itemInventory.clear();
        currentBalance = 0;
        totalSales = 0;
    }

    @Override
    public Bucket<List<Coin>, Item> collectItemAndChange() {
        return null;
    }

    public long getTotalSales() {
        return totalSales;
    }
}
