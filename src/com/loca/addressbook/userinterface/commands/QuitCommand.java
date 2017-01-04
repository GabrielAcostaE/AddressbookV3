package com.loca.addressbook.userinterface.commands;

import com.loca.addressbook.Application;
import com.loca.addressbook.exceptions.InvalidCommandParameterException;
import com.loca.addressbook.userinterface.ConsolePrinter;

import java.util.List;

public class QuitCommand implements Command {

    private CommandType commandType = CommandType.QUIT;
    private Application application;
    private ConsolePrinter consolePrinter;

    public QuitCommand(ConsolePrinter consolePrinter, List<String> parameters, Application application) {
        this.consolePrinter = consolePrinter;
        this.application = application;
    }

    @Override
    public void execute() throws InvalidCommandParameterException {
        consolePrinter.print(commandType.getSuccessMessage());
        application.quit();
    }

}
