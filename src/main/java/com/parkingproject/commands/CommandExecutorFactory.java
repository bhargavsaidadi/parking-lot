package com.parkingproject.commands;

import com.parkingproject.OutputPrinter;
import com.parkingproject.exception.InvalidCommandException;
import com.parkingproject.model.Command;
import com.parkingproject.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory to get correct {@link CommandExecutor} from a given command.
 */
public class CommandExecutorFactory {
  private Map<String, CommandExecutor> commands = new HashMap<>();

  public CommandExecutorFactory(final ParkingLotService parkingLotService) {
    final OutputPrinter outputPrinter = new OutputPrinter();
    commands.put(
        CreateParkingLotCommandExecutor.COMMAND_NAME,
        new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
    		AgeToSlotCommandExecuter.COMMAND_NAME,
            new AgeToSlotCommandExecuter(parkingLotService, outputPrinter));
    commands.put(
        ParkCommandExecutor.COMMAND_NAME,
        new ParkCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
        LeaveCommandExecutor.COMMAND_NAME,
        new LeaveCommandExecutor(parkingLotService, outputPrinter));
    commands.put(
            RegNumberToSlotCommandExecuter.COMMAND_NAME,
            new RegNumberToSlotCommandExecuter(parkingLotService, outputPrinter));
    commands.put(
        SlotForRegNumberCommandExecutor.COMMAND_NAME,
        new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter));
    
  }

  /**
   * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
   * fetch its corresponding executor.
   *
   * @param command Command for which executor has to be fetched.
   * @return Command executor.
   */
  public CommandExecutor getCommandExecutor(final Command command) {
    final CommandExecutor commandExecutor = commands.get(command.getCommandName());
    if (commandExecutor == null) {
      throw new InvalidCommandException();
    }
    return commandExecutor;
  }
}
