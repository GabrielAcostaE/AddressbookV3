package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.userinterface.ConsolePrinter;

public class HelpCommand implements Command {
    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";
    private CommandType commandType = CommandType.HELP;
    private ConsolePrinter consolePrinter;

    public HelpCommand (ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        String helpText = makeHelpText();
        showHelpText(helpText);

    }

    private String makeHelpText() {
        StringBuilder helpText = new StringBuilder(100);
        for (CommandType commandType: CommandType.values()) {
            helpText.append(commandType.getCommandName());
            helpText.append(TAB);
            helpText.append(commandType.getDescription());
            helpText.append(NEW_LINE);
        }
        return helpText.toString();
    }


    private void showHelpText(String helpText) {
        consolePrinter.print(helpText);
    }


}
