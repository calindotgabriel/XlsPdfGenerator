package com.luminous.test;

import com.luminous.*;
import junit.framework.TestCase;

/**
 * Created by motan on 28.05.2015.
 */
public class BuilderTest extends TestCase{

    private static final String OUT_PATH = "res/results";
    private static final String EXCEL_PATH = "res/challenge-source.xls";
    private static final String PDF_TEMPLATE_PATH = "res/challenge-source.pdf";
    private static final String JSON_PATH = "/res/test_rules.json";

    public void testBuilder() {


        Generator pdfGenerator = new GeneratorBulder(OUT_PATH)
                .withExcelDocument(EXCEL_PATH)
                .withJsonRules(JSON_PATH)
                .withPdfTemplate(PDF_TEMPLATE_PATH)
                .build();
        pdfGenerator.start();


    }
}
