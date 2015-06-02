package com.luminous;

import com.itextpdf.text.pdf.AcroFields;

/**
 * Created by motan on 29.05.2015.
 */
public class ConditionalFillFromExcelRule extends ConditionalExcelRule{
    protected String value;

    public ConditionalFillFromExcelRule(String fieldName, String columnName, String predicate, String testVal, String value) {
        super(fieldName, columnName, predicate, testVal);
        this.value = value;
    }

    @Override
    public void execute(AcroFields fields) {
        System.out.println("ConditionalFillFromExcelRule execute!");
    }
}
