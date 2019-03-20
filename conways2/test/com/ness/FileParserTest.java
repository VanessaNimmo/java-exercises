package com.ness;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class FileParserTest {

    @Test
    public void aOneLineFileShouldProduceAOneByOneGridWithOneDeadCell() {
        File initialGridInfo = new File("test/com/ness/setup1.txt");
        Validator validator = new Validator(56);
        FileParser reader = new FileParser(initialGridInfo, validator);

        Grid result = reader.getInitialState();

        Grid expected = new Grid(new boolean[1][1]);

        assertEquals(String.valueOf(expected), String.valueOf(result));
    }

    @Test
    public void aSecondLineInTheFileShouldBeAddedToTheGridAsALiveCellIfValid() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Validator validator = new Validator(56);
        FileParser parser = new FileParser(initialGridInfo, validator);

        Grid result = parser.getInitialState();
        boolean[][] liveCells = new boolean[1][1];
        liveCells[0][0] = true;
        Grid expected = new Grid(liveCells);

        assertEquals(String.valueOf(expected), String.valueOf(result));
    }
}