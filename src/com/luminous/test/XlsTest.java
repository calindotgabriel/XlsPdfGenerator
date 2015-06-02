package com.luminous.test;

import com.itextpdf.text.DocumentException;
import com.luminous.XlsWorker;
import com.luminous.domain.Command;
import junit.framework.TestCase;

import java.io.*;
import java.util.*;

/**
 * Created by motan on 22.05.2015.
 */
public class XlsTest extends TestCase {

    public static final String TEMPLATE_PDF_PATH = "res/challenge-source.pdf";
    public static final String OUT_PATH = "res/results/FillTestResult.pdf";

    /*public void testReadXls() throws IOException {
        try {

            FileInputStream file = new FileInputStream(new File("res/challenge-source.xls"));

            //Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                   *//* switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }*//*
                }
//                System.out.println("");
            }
            file.close();
            FileOutputStream out =
                    new FileOutputStream(new File("res/results/result.xls"));
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void testGetColName() throws IOException {
        Command command = new Command();
        command.setAction("fillFromExcel");
        command.setColName("bill_to_firstname");
        command.setFieldName("fornamn");

        XlsWorker worker = new XlsWorker("res/challenge-source.xls");
        List<String> results = worker.getRecordsForColumn(command.getColName());
        worker.commit();
        assertEquals(5, results.size());

        for (String s : results) {
            System.out.println(s);
        }
    }

    public void testMultiPdfGen() throws IOException, DocumentException {
        Command command = new Command();
        command.setAction("fillFromExcel");
        command.setColName("bill_to_firstname");
        command.setFieldName("fornamn");

        XlsWorker worker = new XlsWorker("res/challenge-source.xls");
        List<String> results = worker.getRecordsForColumn(command.getColName());

        int numOfRows = worker.getDataRowsNr();
        for (int i = 1 ; i <= numOfRows ; i++) {
//            PdfOperation pdfOperation = new PdfOperation("res/challenge-source.pdf", "res/results/" + i + ".pdf");
//            pdfOperation.executeFill();
        }


    }
}
