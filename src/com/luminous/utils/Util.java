package com.luminous.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by motan on 19.05.2015.
 */
public class Util {

    public static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
