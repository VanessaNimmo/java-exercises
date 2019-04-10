package com.ness;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class FileParserTest {

    @Test
    public void aCorrectlyFormattedFileShouldBeParsed() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        FileParser parser = new FileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isPresent());
    }

    @Test
    public void anIncorrectlyFormattedFirstLineShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/incorrectlyFormattedFirstLine.txt");
        FileParser parser = new FileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isEmpty());
    }

    @Test
    public void incorrectFormattingAtAnyStageShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/incorrectlyFormattedSecondLine.txt");
        FileParser parser = new FileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isEmpty());
    }
}