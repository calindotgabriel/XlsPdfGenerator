package com.luminous;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.IOException;

/**
 * Created by motan on 29.05.2015.
 */
public abstract class PdfRule implements Rule {

    protected String fieldName;

    public PdfRule(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public abstract void execute(AcroFields fields) throws IOException, DocumentException;



}
