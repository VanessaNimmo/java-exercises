package com.ness;

import java.io.File;
import java.util.ResourceBundle;

public class ConwaysApp {

    public static void main(String[] args) {

        int maxGridSize = Integer.parseInt(args[0]);
        int numberOfTicks = Integer.parseInt(args[1]);
        int sleepTime = Integer.parseInt(args[2]);
        String filePath = args[3];
        File setupFile = new File(filePath);

        Output output = new ConsoleOutput();
        Validator conwaysValidator = new Validator(maxGridSize);
        FileParser readFile = new FileParser(setupFile, conwaysValidator);
        Grid initialState = readFile.getInitialState();

        ResourceBundle messages = ResourceBundle.getBundle("messages");
        String welcome = messages.getString("welcome");
        output.print(welcome);

        Conways game = new Conways(initialState, numberOfTicks, sleepTime, output);
        game.run();
    }
}