package com.parkingproject.commands;

import com.parkingproject.OutputPrinter;
import com.parkingproject.exception.NoFreeSlotAvailableException;
import com.parkingproject.model.Car;
import com.parkingproject.model.Command;
import com.parkingproject.service.ParkingLotService;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the alloted slot
 * in which the car is parked.
 */
public class ParkCommandExecutor extends CommandExecutor {
	int count = 1;
  public static String COMMAND_NAME = "Park";

  public ParkCommandExecutor(
      final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
    super(parkingLotService, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean validate(final Command command) {
    return command.getParams().size() == 3;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(final Command command) {
    final Car car = new Car(command.getParams().get(0), command.getParams().get(1), Integer.parseInt(command.getParams().get(2)));
    car.setSlotNumber(count);
    try {
      final Integer slot = parkingLotService.park(car);
      outputPrinter.printWithNewLine("Car with vehicle registration number "+ "\""+command.getParams().get(0)+"\" " +"has been parked at slot number "+ slot);
    } catch (NoFreeSlotAvailableException exception) {
      outputPrinter.parkingLotFull();
    }
    count++;
  }
  
}
