package com.luminous;

/**
 * Created by motan on 29.05.2015.
 */
public class GeneratorBulder {

    public String excelPath;
    public String pdfTemplatePath;
    public String outPath;
    public String jsonRulesPath;

    public Generator build() {
        return new PdfGenerator(this); //todo make this factory
    }


    public GeneratorBulder(String outPath) {
        this.outPath = outPath;
    }

    public GeneratorBulder withExcelDocument(String excelPath) {
        this.excelPath = excelPath;
        return this;
    }


    public GeneratorBulder withPdfTemplate(String pdfTemplatePath) {
        this.pdfTemplatePath = pdfTemplatePath;
        return this;
    }

    public GeneratorBulder withJsonRules(String jsonPath) {
        this.jsonRulesPath = jsonPath;
        return this;
    }
}
