package com.luminous;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.luminous.domain.Command;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 29.05.2015.
 */
public class PdfGenerator extends Generator {

    private String excelPath;
    private String pdfTemplatePath;
    private String outPath;
    private String jsonRulesPath;
    private AcroFields fields;

    public PdfGenerator(GeneratorBulder builder) {
        this.excelPath = builder.excelPath;
        this.pdfTemplatePath = builder.pdfTemplatePath;
        this.outPath = builder.outPath;
        this.jsonRulesPath = builder.jsonRulesPath;
    }

    @Override
    public void start() {
        JsonSerializer serializer = null;
        try {
            serializer = new JsonSerializer(jsonRulesPath);
            List<Command> commands = serializer.serializeJsonArray();
            List<Rule> rules = new ArrayList<>();
            for (Command command : commands) {
                Rule rule = new RuleFactory().getRule(command);
                rules.add(rule);
            }

            XlsWorker worker = new XlsWorker(excelPath);
            int pdfsToOut = worker.getDataRowsNr();

            for (int i = 1 ; i <= pdfsToOut ; ++ i) {
                for (Rule rule : rules) {
                    rule.execute(getFields(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public AcroFields getFields(int pdfIndex) {
        if (fields == null) {
            PdfReader reader = null;
            try {
                reader = new PdfReader(pdfTemplatePath);
                String outPdfPath = outPath + "/" + +pdfIndex + ".pdf";
                PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outPdfPath));
                fields = stamper.getAcroFields();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }
}
