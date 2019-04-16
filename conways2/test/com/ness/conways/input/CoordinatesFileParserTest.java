package com.ness.conways;

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
        File initialGridInfo = new File("test/com/ness/conways/setup1livecell.txt");
        CoordinatesFileParser parser = new CoordinatesFileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isPresent());
    }

    @Test
    public void anIncorrectlyFormattedFirstLineShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/conways/incorrectlyFormattedFirstLine.txt");
        CoordinatesFileParser parser = new CoordinatesFileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isEmpty());
    }

    @Test
    public void incorrectFormattingAtAnyStageShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/conways/incorrectlyFormattedSecondLine.txt");
        CoordinatesFileParser parser = new CoordinatesFileParser(initialGridInfo);

        Optional<ArrayList<Coordinates>> result = parser.getCoordinatesList();

        assertTrue(result.isEmpty());
    }
}