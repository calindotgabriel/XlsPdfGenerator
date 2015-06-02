package com.luminous;

import com.itextpdf.text.pdf.AcroFields;

/**
 * Created by motan on 29.05.2015.
 */
public abstract class ConditionalExcelRule extends ExcelRule {

    protected String predicate;
    protected String testVal;

    public ConditionalExcelRule(String fieldName, String columnName, String predicate, String testVal) {
        super(fieldName, columnName);
        this.predicate = predicate;
        this.testVal= testVal;
    }

    @Override
    public abstract void execute(AcroFields fields);
}
