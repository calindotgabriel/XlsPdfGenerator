package com.luminous;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.luminous.domain.Rule;
import com.luminous.utils.Util;

import java.io.*;
import java.util.List;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException, DocumentException {
        String xlsPath = args[0];
        String pdfTemplatePath = args[1];
        String rulesPath = args[2];
        String outPath = args[3];

        rulesPath = "res/test_rules.json";

        JsonSerializer serializer = new JsonSerializer(rulesPath);
        List<Rule> rules = serializer.serializeJsonArray();

        Criteria fill = new CriteriaFill();
        Criteria check = new CriteriaCheck();
        Criteria excel = new CriteriaExcel();
        Criteria conditional = new CriteriaConditional();

        Criteria fillFromExcel = new CriteriaAnd(fill, excel);
        Criteria checkFromExcel = new CriteriaAnd(check, excel);

        Criteria conditionalCheckFromExcel = new CriteriaAnd(conditional, checkFromExcel);

        XlsWorker worker = new XlsWorker(xlsPath);
        int pdfsToOut = worker.getDataRowsNr();

        for (int i = 1 ; i <= pdfsToOut ; i ++) {
            PdfOperation operation = new PdfOperation(pdfTemplatePath, outPath + "/" + + i + ".pdf");

            for (Rule fillRule : fill.meetCriteria(rules)) {
                if (fillRule.isSimple()) {
                    operation.executeFill(fillRule);
                }
            }

            for (Rule checkRule : check.meetCriteria(rules)) {
                if (checkRule.isSimple()) {
                    operation.executeCheck(checkRule);
                }
            }

            for (Rule fillFromExcelRule : fillFromExcel.meetCriteria(rules)) {
                String columnValueAtIndex = worker.getValueForColumnIndex(i - 1, fillFromExcelRule.getColName());
                fillFromExcelRule.setValue(columnValueAtIndex);
                operation.executeFill(fillFromExcelRule);
            }

            for (Rule conditionalCheckFromExcelRule : conditionalCheckFromExcel.meetCriteria(rules)) {
                String columnValueAtIndex = worker.getValueForColumnIndex(i - 1, conditionalCheckFromExcelRule.getColName());
                if (conditionalCheckFromExcelRule.getPredicate().equals("contains")) {
                    if (columnValueAtIndex.toLowerCase().contains(conditionalCheckFromExcelRule.getTestVal().toLowerCase())) {
                        operation.executeCheck(conditionalCheckFromExcelRule);
                    }
                }
                if (conditionalCheckFromExcelRule.getPredicate().equals("equals")) {
                    if (columnValueAtIndex.toLowerCase().equals(conditionalCheckFromExcelRule.getTestVal().toLowerCase())) {
                        operation.executeCheck(conditionalCheckFromExcelRule);
                    }
                }
            }
            operation.commit();
        }
        worker.commit();
    }




}
