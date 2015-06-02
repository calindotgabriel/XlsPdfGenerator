package com.luminous;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * Created by motan on 29.05.2015.
 */
public class CheckRule extends PdfRule {

    public static final String STATE_CHECKED = "Yes";

    public CheckRule(String fieldName) {
        super(fieldName);
    }

    @Override
    public void execute(AcroFields fields) throws IOException, DocumentException {
        fields.setField(fieldName, STATE_CHECKED);
    }
}
