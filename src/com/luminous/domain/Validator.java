package com.luminous.domain;

import com.luminous.exception.NotEnoughArgumentsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;

/**
 * Created by motan on 19.05.2015.
 */
public class Validator {

    public void validate(String[] args) throws NotEnoughArgumentsException, FileNotFoundException, NotDirectoryException {

        if (args.length < 4) {
            throw new NotEnoughArgumentsException("Not enough arguments, expected 4 but got " + args.length + " : Correct argument format: srcXls srcPdf srcJson tgtDir");
        }

        for (int i = 0 ; i < args.length - 1 ; i ++) {
            File f = new File(args[i]);
            if (!f.exists()) {
                throw new FileNotFoundException("Could not find file: + args[i]");
            }
        }

        File f = new File(args[args.length - 1]);
        if (!f.isDirectory()) {
            throw new NotDirectoryException("Could not find directory: " + args[args.length - 1]);
        }
    }


}
