package com.parkingproject.commands;

import com.parkingproject.OutputPrinter;
import com.parkingproject.model.Command;
import com.parkingproject.model.Slot;
import com.parkingproject.service.ParkingLotService;
import com.parkingproject.validator.IntegerValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Executor to handle command of freeing of slot from a car.
 */
public class LeaveCommandExecutor extends CommandExecutor {
	public static String COMMAND_NAME = "Leave";

	public LeaveCommandExecutor(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validate(final Command command) {
		final List<String> params = command.getParams();
		if (params.size() != 1) {
			return false;
		}
		return IntegerValidator.isInteger(params.get(0));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(final Command command) {

		final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
		final int slotNumberToFind = Integer.parseInt(command.getParams().get(0));
		final Optional<Slot> foundSlot = occupiedSlots.stream()
		        .filter(slot -> slot.getParkedCar().getSlotNumber()==slotNumberToFind)
		        .findFirst();
		
		if (foundSlot.isPresent()) {
		      String vehicleRegNumber = foundSlot.get().getParkedCar().getRegistrationNumber();
		      int age  = foundSlot.get().getParkedCar().getAge();
		      final int slotNum = Integer.parseInt(command.getParams().get(0));
				Slot slot;
				outputPrinter.printWithNewLine("Slot number " + slotNum + " is vacated." +"vehicle with registration number "+"\"" 
				+vehicleRegNumber+"\" left the space, the driver of the car was of age "+age);
				parkingLotService.makeSlotFree(slotNum);
		    }else {
		    	outputPrinter.printWithNewLine("null");
		    }
		
		
		
	}
}
