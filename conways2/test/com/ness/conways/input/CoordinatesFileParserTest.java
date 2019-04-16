package com.ness.conways.input;

import com.ness.conways.input.Coordinates;
import com.ness.conways.input.CoordinatesFileParser;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class CoordinatesFileParserTest {

    @Test
    public void aCorrectlyFormattedFileShouldBeParsed() {
        File initialGridInfo = new File("test/com/ness/conways/input/setup1livecell.txt");
        CoordinatesFileParser parser = new CoordinatesFileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isPresent());
    }

    @Test
    public void anIncorrectlyFormattedFirstLineShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/conways/input/incorrectlyFormattedFirstLine.txt");
        CoordinatesFileParser parser = new CoordinatesFileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isEmpty());
    }

    @Test
    public void incorrectFormattingAtAnyStageShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/conways/input/incorrectlyFormattedSecondLine.txt");
        CoordinatesFileParser parser = new CoordinatesFileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isEmpty());
    }
}