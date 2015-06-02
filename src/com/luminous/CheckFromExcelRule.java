package com.luminous;

import com.itextpdf.text.pdf.AcroFields;

/**
 * Created by motan on 29.05.2015.
 */
public class CheckFromExcelRule extends ExcelRule {
    public CheckFromExcelRule(String fieldName, String columnName) {
        super(fieldName, columnName);
    }

    @Override
    public void execute(AcroFields fields) {
        System.out.println("CheckFromExcel execute!");
    }
}
