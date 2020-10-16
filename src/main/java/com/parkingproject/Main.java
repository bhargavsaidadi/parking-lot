package com.parkingproject;

import com.parkingproject.OutputPrinter;
import com.parkingproject.commands.CommandExecutorFactory;
import com.parkingproject.exception.InvalidModeException;
import com.parkingproject.mode.FileMode;
import com.parkingproject.service.ParkingLotService;

import java.io.IOException;

public class Main {
	public static void main(final String[] args) throws IOException {
		final OutputPrinter outputPrinter = new OutputPrinter();
		final ParkingLotService parkingLotService = new ParkingLotService();
		final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

		if (isFileInputMode(args)) {
			new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
		} else {
			throw new InvalidModeException();
		}
	}

	/**
	 * Checks whether the program is running using file input mode.
	 *
	 * @param args Command line arguments.
	 * @return Boolean indicating whether in file input mode.
	 */
	private static boolean isFileInputMode(final String[] args) {
		return args.length == 1;
	}

}
