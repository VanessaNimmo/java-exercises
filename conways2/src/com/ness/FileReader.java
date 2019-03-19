package com.ness;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileReader {

    private File initialGridInfo;

    FileReader(File initialGridInfo) {
        this.initialGridInfo = initialGridInfo;
    }

    Grid getInitialState(Validator conwaysValidator) {
        return new Grid(new boolean[0][0]);
    }
}
