package com.luminous;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.luminous.domain.Command;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by motan on 22.05.2015.
 */
public class PdfOperation {

    public static final String STATE_CHECKED = "Yes";

    private final PdfReader reader;
    private final PdfStamper stamper;
    private final AcroFields form;

    public PdfOperation(String templatePdfPath, String outPdfPath) throws IOException, DocumentException {
        reader = new PdfReader(templatePdfPath);
        stamper = new PdfStamper(reader, new FileOutputStream(outPdfPath));
        form = stamper.getAcroFields();
    }

    public void commit() throws IOException, DocumentException {
        stamper.close();
        reader.close();
    }

    public void executeFill(Command command) throws IOException, DocumentException {
        form.setField(command.getFieldName(), command.getValue());
    }


    public void executeCheck(Command command) throws IOException, DocumentException {
        form.setField(command.getFieldName(), STATE_CHECKED);
    }




}
