package com.luminous;

import com.itextpdf.text.pdf.AcroFields;

/**
 * Created by motan on 29.05.2015.
 */
public class ConditionalCheckFromExcelRule extends ConditionalExcelRule{
    public ConditionalCheckFromExcelRule(String fieldName, String columnName, String predicate, String testVal) {
        super(fieldName, columnName, predicate, testVal);
    }

    @Override
    public void execute(AcroFields fields) {

    }
}
