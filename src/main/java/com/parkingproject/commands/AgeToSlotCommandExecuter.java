package com.parkingproject.commands;

import java.util.List;
import java.util.stream.Collectors;

import com.parkingproject.OutputPrinter;
import com.parkingproject.model.Command;
import com.parkingproject.model.Slot;
import com.parkingproject.service.ParkingLotService;

public class AgeToSlotCommandExecuter extends CommandExecutor {

	public static String COMMAND_NAME = "Slot_numbers_for_driver_of_age";

	public AgeToSlotCommandExecuter(final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public boolean validate(Command command) {
		return command.getParams().size() == 1;
	}

	@Override
	public void execute(Command command) {
		final List<Slot> slotsForAge = parkingLotService
				.getSlotsForDriverAge(Integer.parseInt(command.getParams().get(0)));
		if (slotsForAge.isEmpty()) {
			outputPrinter.notFound();
		} else {
			final String result = slotsForAge.stream().map(slot -> String.valueOf(slot.getParkedCar().getSlotNumber()))
					.collect(Collectors.joining(", "));
			outputPrinter.printWithNewLine(result);
		}
	}
}
