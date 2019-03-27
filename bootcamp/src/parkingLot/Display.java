package parkingLot;

import java.util.HashMap;
import java.util.Map;

public class Display {
    private static Display display;
    private Map<Displayable, Integer> parkingLotDetail;


    static {
        display = new Display();
    }

    private Display() {
        parkingLotDetail = new HashMap<>();
    }
     static Display getDisplay(){
        return display;
     }
    void updateDetails(ParkingLot parkingLot, Integer parkedCarCount) {
        parkingLotDetail.put(parkingLot,parkedCarCount);
    }

    @Override
    public String toString() {
        System.out.println(parkingLotDetail.toString());
        return parkingLotDetail.toString();
    }
}
