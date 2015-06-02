package com.luminous;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * Created by motan on 29.05.2015.
 */
public interface Rule {
    public void execute(AcroFields fields) throws IOException, DocumentException;
}
