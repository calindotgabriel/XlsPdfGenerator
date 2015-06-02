package com.luminous;

import java.io.File;

/**
 * Created by motan on 29.05.2015.
 */
public interface PdfTemplateParser {
    public void setPdfTemplate(String path);
    public void setPdfTemplate(File pdfTemplate);
    public void setOutDirectory(String path);
    public void setOutDirectory(File outDirectory);
}
