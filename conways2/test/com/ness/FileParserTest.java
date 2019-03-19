package com.ness;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class FileParserTest {

    @Test
    public void aOneLineFileShouldProduceAOneByOneGridWithOneDeadCell() {
        File initialGridInfo = new File("setup1.txt");
        Validator validator = new Validator(56);
        FileParser reader = new FileParser(initialGridInfo, validator);

        Grid result = reader.getInitialState();

        Grid expected = new Grid(new boolean[1][1]);

        assertEquals(String.valueOf(expected), String.valueOf(result));
    }
}