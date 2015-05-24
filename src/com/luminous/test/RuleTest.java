package com.luminous.test;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.luminous.PdfOperation;
import com.luminous.domain.Rule;
import junit.framework.TestCase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

/**
 * Created by motan on 22.05.2015.
 */
public class RuleTest extends TestCase {

    public static final String TEMPLATE_PDF_PATH = "res/challenge-source.pdf";
    public static final String OUT_PATH = "res/results/FillTestResult.pdf";

    public void testFill() throws IOException, DocumentException {

        Rule fillRule = new Rule("fill", "adress", "Nicolae Colan swagHome");

        PdfOperation operation = new PdfOperation(TEMPLATE_PDF_PATH, OUT_PATH);
        operation.executeFill(fillRule);
        operation.commit();

    }

    public void testCheck() throws IOException, DocumentException {

        Rule checkRule = new Rule("check", "isCool");

        PdfOperation operation = new PdfOperation(TEMPLATE_PDF_PATH, OUT_PATH);
        operation.executeCheck(checkRule);
        operation.commit();

    }
}
