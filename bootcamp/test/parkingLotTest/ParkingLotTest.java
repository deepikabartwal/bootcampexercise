package com.assignments.java.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParkingLotTest {

  @Test
  void shouldParkTheCarInParkingLot() throws NoSpaceAvailableException {

    ParkingLot parkingLot = new ParkingLot(5);

    assertTrue(parkingLot.park(new Car("Suzuki")));
  }

  @Test
  void shouldThrowExceptionIfTheParkingLotIsFull() throws NoSpaceAvailableException {
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.park(new Car("Suzuki"));
    assertThrows(NoSpaceAvailableException.class, () -> parkingLot.park(new Car("Tata")));
  }

  @Test
  void shouldNotifyAttendantWhenParkingLotGetsFull() throws NoSpaceAvailableException {
    ParkingLot parkingLot = new ParkingLot(1);
    MockAttendant attendant = new MockAttendant("Badri");
    parkingLot.addAttendant(attendant);
    parkingLot.park(new Car("Suzuki"));
    assertTrue(attendant.isNotified);
  }

  @Test
  void shouldNotifyAttendantWhenCarIsUnparked() throws NoSpaceAvailableException {
    ParkingLot parkingLot = new ParkingLot(1);
    Car maruti = new Car("Maruti");
    parkingLot.park(maruti);
    MockAttendant attendant = new MockAttendant("Badri");
    parkingLot.addAttendant(attendant);
    parkingLot.unPark(maruti);
    assertTrue(attendant.isNotifiedOfFreeLot);
  }
}

class MockAttendant extends Attendant {

  boolean isNotified = false;
  boolean isNotifiedOfFreeLot = false;

  MockAttendant(String name) {
    super(name);
  }

  @Override
  public void update(ParkingLot parkingLot1) {
    this.isNotified = true;
  }

  @Override
  void updateAvailableLot(ParkingLot parkingLot) {
    this.isNotifiedOfFreeLot =true;
  }
}