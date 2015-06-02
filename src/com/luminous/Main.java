package com.luminous;

import com.itextpdf.text.DocumentException;
import com.luminous.domain.Command;
import com.luminous.exception.NotEnoughArgumentsException;

import java.io.*;
import java.security.KeyException;
import java.util.List;

public class Main {


    public static void main(String[] args) {

//        Validator validator = new Validator();
//        validator.validate(args);

        // open closed principle, data income
/*
        String xlsPath = args[0];
        String pdfTemplatePath = args[1];
        String rulesPath = args[2];
        String outPath = args[3]; // if lib, do not hardcode parameters

        JsonSerializer serializer = new JsonSerializer(rulesPath);
        List<Command> commands = serializer.serializeJsonArray();

        // supported criterias
        Criteria fill = new CriteriaFill();
        Criteria check = new CriteriaCheck();
        Criteria excel = new CriteriaExcel();
        Criteria conditional = new CriteriaConditional();
        Criteria fillFromExcel = new CriteriaAnd(fill, excel);
        Criteria checkFromExcel = new CriteriaAnd(check, excel);
        Criteria conditionalCheckFromExcel = new CriteriaAnd(conditional, checkFromExcel);
        // encapsulate this ^

        //builder.setXlsPath().... . build()

        XlsWorker worker = new XlsWorker(xlsPath);
        int pdfsToOut = worker.getDataRowsNr();

        ExcelRuleAdapter excelRuleAdapter = new ExcelRuleAdapter(worker);
        ConditionalExcelRuleAdapter conditionalExcelRuleAdapter= new ConditionalExcelRuleAdapter(worker);

        for (int pdfIndex = 1 ; pdfIndex <= pdfsToOut ; pdfIndex ++) {
            String outPdfPath = outPath + "/" + +pdfIndex + ".pdf";
            PdfOperation operation = new PdfOperation(pdfTemplatePath, outPdfPath);

            for (Command simpleFillCommand : fill.meetCriteria(commands)) {
                if (simpleFillCommand.isSimple()) {
                    operation.executeFill(simpleFillCommand);
                }
            }

            for (Command simpleCheckCommand : check.meetCriteria(commands)) {
                if (simpleCheckCommand.isSimple()) {
                    operation.executeCheck(simpleCheckCommand);
                }
            }

            for (Command fillFromExcelCommand : fillFromExcel.meetCriteria(commands)) {
                Command command = excelRuleAdapter.excelToSimple(pdfIndex, fillFromExcelCommand);
                operation.executeFill(command);
            }

            for (Command conditionalCheckFromExcelCommand : conditionalCheckFromExcel.meetCriteria(commands)) {
                if (conditionalExcelRuleAdapter.ruleMeetsRequirements(pdfIndex, conditionalCheckFromExcelCommand)) {
                    operation.executeCheck(conditionalCheckFromExcelCommand);
                }

            }
            operation.commit();
            System.out.println("Written file " + outPdfPath);
        }
        worker.commit();
    }*/

        Generator pdfGenerator = new GeneratorBulder(OUT_PATH)
                .withExcelDocument(EXCEL_PATH)
                .withJsonRules(JSON_PATH)
                .withPdfTemplate(PDF_TEMPLATE_PATH)
                .build();
        pdfGenerator.start();
    }
}
