package parkingLot;

import java.util.ArrayList;
import java.util.List;

public class Attendant implements Observer {
    private String name;
    private List<ParkingLot> availableParkingLots;
    private List<ParkingLot> unavailableParkingLots;

    Attendant(String name) {
        this.name = name;
        this.availableParkingLots = new ArrayList<>();
        this.unavailableParkingLots = new ArrayList<>();
    }

    @Override
    public void update(ParkingLot parkingLot) {
        this.unavailableParkingLots.add(parkingLot);
        this.availableParkingLots.remove(parkingLot);
    }

    void addParkingLot(ParkingLot parkingLot, Boolean isFull) {
        if(isFull) {
            this.unavailableParkingLots.add(parkingLot);
            return;
        }
        this.availableParkingLots.add(parkingLot);
    }

    void updateAvailableLot(ParkingLot parkingLot) {
        this.unavailableParkingLots.remove(parkingLot);
        this.availableParkingLots.add(parkingLot);
    }
}
