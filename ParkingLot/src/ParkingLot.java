import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot implements Parking {
    CarType currentCar;
    CarSlots carSlotObj = new CarSlots();
    CashInventory cashinv = new CashInventory();
    TicketResponse ticketResponse;
    Integer currentSlot;
    int currentBalance;
    int totalprice;
    Ticket<Integer, List<String>> entryticket;


    public Ticket<Integer, List<String>> selectCarTypeGetTicket(CarType carTypes) {
        this.currentCar = carTypes;
        if (!carSlotObj.isSlotFull(currentCar)) {
            carSlotObj.add(currentCar);
            currentSlot = carSlotObj.getReturnSlotNumber();

            String s = "Thank you for Coming";
            LocalTime k = LocalTime.now();
            String a = String.valueOf(k);
            List<String> list = new ArrayList<>();
            list.add(s);
            list.add(a);
            return new Ticket<Integer, List<String>>(currentSlot, list);
        } else {
            throw new SlotsFullException("Sorry, Slots are full");
        }

    }

    public TicketResponse payment(Ticket<Integer, List<String>> entryTicket) {
        this.entryticket = entryTicket;
        int ticketNo = entryTicket.getFirst();
        if (isFullPaid(entryTicket)) {
            if (totalprice == currentBalance) {
                ticketResponse = new TicketResponse();
                ticketResponse.setTicketNo(ticketNo);
                ticketResponse.setStr("PaymentSuccessfull");
                return ticketResponse;
            } else if (totalprice < currentBalance) {
                int remaining = currentBalance - totalprice;
                List<Coin> c = getCoins(remaining);
                ticketResponse = new TicketResponse();
                ticketResponse.setCoins(c);
                ticketResponse.setTicketNo(ticketNo);
                ticketResponse.setStr("Payment Successfull");
            }
        } else {
            throw new InsufficientAmount("Amount is insufficient, please add more");
        }
        return ticketResponse;
    }

    public List<Coin> getCoins(int remaining) {
        List<Coin> changes = new ArrayList<>();
        while (remaining > 0) {
            if (remaining == Coin.Hundred.getDenominations()) {
                changes.add(Coin.Hundred);
                remaining = remaining - Coin.Hundred.getDenominations();
                cashinv.deduct(Coin.Fifty);
            } else if (remaining == Coin.Fifty.getDenominations()) {
                changes.add(Coin.Fifty);
                remaining = remaining - Coin.Fifty.getDenominations();
                cashinv.deduct(Coin.Fifty);
            } else if (remaining == Coin.Twenty.getDenominations()) {
                changes.add(Coin.Twenty);
                remaining = remaining - Coin.Twenty.getDenominations();
                cashinv.deduct(Coin.Twenty);
            } else if (remaining == Coin.Ten.getDenominations()) {
                changes.add(Coin.Ten);
                remaining = remaining - Coin.Ten.getDenominations();
                cashinv.deduct(Coin.Ten);
            } else if (remaining == Coin.Five.getDenominations()) {
                changes.add(Coin.Five);
                remaining = remaining - Coin.Five.getDenominations();
                cashinv.deduct(Coin.Five);
            } else if (remaining == Coin.Two.getDenominations()) {
                changes.add(Coin.Two);
                remaining = remaining - Coin.Two.getDenominations();
                cashinv.deduct(Coin.Two);
            } else if (remaining == Coin.One.getDenominations()) {
                changes.add(Coin.One);
                remaining = remaining - Coin.One.getDenominations();
                cashinv.deduct(Coin.One);
            }
        }
        return changes;
    }

    public void insertCoin(Coin c) {
        currentBalance += c.getDenominations();
        cashinv.add(c);
    }


    public boolean isFullPaid(Ticket<Integer, List<String>> ticket) {
        List<String> s = ticket.getSecond();
        int entrytime = calculateTime(s.get(1));

        LocalTime current = LocalTime.now();
        int exitTime = calculateTime(String.valueOf(current));
        int price = totalcost(entrytime, exitTime);
        if (currentBalance == price) {
            return true;
        } else if (currentBalance <= price) {
            return false;
        }
        return true;
    }

    public int totalcost(int entryTime, int exitTime) {
        int parkedtime = entryTime - exitTime;

        if (parkedtime < ParkingHoursAndRate.First.hours) {
            totalprice = ParkingHoursAndRate.First.getPrice();
        } else if (parkedtime > ParkingHoursAndRate.First.hours && parkedtime < ParkingHoursAndRate.Second.hours) {
            totalprice = ParkingHoursAndRate.Second.getPrice();
        } else if (parkedtime > ParkingHoursAndRate.Second.hours && parkedtime < ParkingHoursAndRate.Third.hours) {
            totalprice = ParkingHoursAndRate.Third.getPrice();
        } else if (parkedtime > ParkingHoursAndRate.Third.getPrice() && parkedtime < ParkingHoursAndRate.Fourth.hours) {
            totalprice = ParkingHoursAndRate.Fourth.getPrice();
        } else {
            totalprice = ParkingHoursAndRate.Fifth.getPrice();
        }
        return totalprice;
    }

    public int calculateTime(String time) {
        StringBuilder str = new StringBuilder();
        int k = 0;
        while (time.charAt(k) != ':') {
            str.append(time.charAt(k));
            k++;
        }
      return  Integer.valueOf(str.toString());
    }

    public void reset() {
        carSlotObj.deduct(currentCar, currentSlot);
        currentCar = null;
        currentSlot = null;
    }
}

