package com.ness;

import java.io.File;
import java.util.Optional;
import java.util.ResourceBundle;

public class ConwaysApp {

    public static void main(String[] args) {

        int maxGridSize = Integer.parseInt(args[0]);
        int numberOfTicks = Integer.parseInt(args[1]);
        int sleepTime = Integer.parseInt(args[2]);
        String filePath = args[3];
        File setupFile = new File(filePath);

        Output output = new ConsoleOutput();
        GridFromFileGenerator readFile = new GridFromFileGenerator(setupFile, maxGridSize, output);
        Optional<Grid2D> initialStateOptional = readFile.getInitialState();
        if (initialStateOptional.isEmpty()) {
            ResourceBundle messages = ResourceBundle.getBundle("messages");
            String invalid = messages.getString("invalid");
            output.print(invalid);
            System.exit(0);
        }
        Grid2D initialState = initialStateOptional.get();
        GridCalculator calculator = new GridCalculator2D();

        ResourceBundle messages = ResourceBundle.getBundle("messages");
        String welcome = messages.getString("welcome");
        output.print(welcome);

        Conways game = new Conways(initialState, numberOfTicks, sleepTime, output, calculator);
        game.run();
    }
}