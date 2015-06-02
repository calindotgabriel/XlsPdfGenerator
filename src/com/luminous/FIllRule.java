package com.luminous;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * Created by motan on 29.05.2015.
 */
public class FIllRule extends PdfRule {

    protected String value;

    public FIllRule(String fieldName, String value) {
        super(fieldName);
        this.value = value;
    }

    @Override

    public void execute(AcroFields fields) throws IOException, DocumentException {
        fields.setField(fieldName, value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
