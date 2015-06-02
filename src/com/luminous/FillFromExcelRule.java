package com.luminous;

import com.itextpdf.text.pdf.AcroFields;

/**
 * Created by motan on 29.05.2015.
 */
public class FillFromExcelRule extends ExcelRule {

    public FillFromExcelRule(String fieldName, String columnName) {
        super(fieldName, columnName);
    }

    @Override
    public void execute(AcroFields fields) {
        System.out.println("FillFromExcel execute");
    }
}
