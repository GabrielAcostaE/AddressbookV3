package com.loca.addressbook.userinterface;

import java.util.Scanner;

public class Console implements ConsolePrinter {

	private InputHandler inputHandler;
	private boolean isQuit = false;
 
    public void registerInputHandler(InputHandler inputHandler) {
    	this.inputHandler = inputHandler;
    }
 
    public void readUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String userInput = scanner.nextLine();
                CommandLine commandLine = CommandLine.parse(userInput);
                inputHandler.handle(commandLine);
            }
        }
    }

    @Override
    public void print(String output) {
        System.out.println(output);
    }

    /*public void close() {
        isQuit = true;
    }*/

}
