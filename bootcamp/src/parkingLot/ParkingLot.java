package parkingLot;


import java.util.ArrayList;
import java.util.List;

class ParkingLot implements Observable{
  private Integer capacity;
  private List<Car> parkingArea;
  private Attendant attendant;

  ParkingLot(Integer capacity) {
    this.capacity = capacity;
    this.parkingArea = new ArrayList<>();
  }

  void addAttendant(Attendant attendant){
    this.attendant = attendant;
    this.attendant.addParkingLot(this, isParkingLotFull());
  }

  boolean park(Car car) throws NoSpaceAvailableException {
    if(!isSpaceAvailable()) throw new NoSpaceAvailableException();
    this.parkingArea.add(car);
    if(isParkingLotFull() && this.attendant != null) notifyFull();
    return true;
  }

  void unPark(Car car){
    boolean wasFull = isParkingLotFull();
    this.parkingArea.remove(car);
    if(wasFull && this.attendant != null) notifyIsAvailable();
  }

  private void notifyIsAvailable() {
    this.attendant.updateAvailableLot(this);
  }

  private boolean isParkingLotFull(){
    return this.capacity == this.parkingArea.size();
  }

  private boolean isSpaceAvailable(){
    return this.capacity > this.parkingArea.size();
  }

  @Override
  public void notifyFull() {
    this.attendant.update(this);
  }
}
