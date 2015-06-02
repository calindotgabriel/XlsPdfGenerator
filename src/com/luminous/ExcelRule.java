package com.luminous;

import com.itextpdf.text.pdf.AcroFields;

/**
 * Created by motan on 29.05.2015.
 */
public abstract class ExcelRule extends PdfRule {

    protected String columnName;

    public ExcelRule(String fieldName, String columnName) {
        super(fieldName);
        this.columnName = columnName;
    }

    @Override
    public abstract void execute(AcroFields fields);
}
