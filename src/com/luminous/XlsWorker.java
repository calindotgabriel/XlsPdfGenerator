package com.luminous;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyException;
import java.util.*;

/**
 * Created by motan on 22.05.2015.
 */
public class XlsWorker {

    private final HSSFSheet sheet;
    private final FileInputStream file;
    private Map<String, List<String>> colResultMap;
    private Map<String, Integer> headerIndexMap;

    public XlsWorker(String xlsPath) throws IOException {
        file = new FileInputStream(new File(xlsPath));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        sheet = workbook.getSheetAt(0);
        colResultMap = new HashMap<String, List<String>>();
        buildHeaderMap();
    }

    public List<String> getRecordsForColumn(String columnName) {
        Map<String, Integer> headerMap = buildHeaderMap();

        if (!colResultMap.containsKey(columnName)) {
            colResultMap.put(columnName, buildResults(columnName, headerMap));
        }

        return colResultMap.get(columnName);
    }

    private List<String> buildResults(String columnName, Map<String, Integer> map) {
        List<String> results = new ArrayList<String>();

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // move 1 row, first one is the header

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Integer match = map.get(columnName);
            Cell cell = row.getCell(match); // TODO error handling when no such row.
            if (cell != null) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                results.add(cell.getStringCellValue());
            } else {
//                System.out.println("Warning, empty element at: " + columnName);
                results.add("");
            }
        }
        return results;
    }

    public int getDataRowsNr(){
        return sheet.getPhysicalNumberOfRows() - 1;
    }

    private Map<String, Integer> buildHeaderMap() {
        headerIndexMap = new HashMap<String, Integer>();
        Row header = sheet.getRow(0);
        Iterator<Cell> headCellIterator = header.cellIterator();
        int columnIndex = 0;
        while (headCellIterator.hasNext()) {
            Cell headCell = headCellIterator.next();
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            String headColumnName = headCell.getStringCellValue();
            headerIndexMap.put(headColumnName, columnIndex++);
        }
        return headerIndexMap;
    }

    public String getValueForColumnIndex(int index, String colName) throws KeyException {
        if (!headerIndexMap.containsKey(colName)) {
//            throw new KeyException("No such column: " + colName + " in the provided .xls file");
            System.out.println("No such column: " + colName);
            return "";
        }
        return getRecordsForColumn(colName).get(index);
    }


    public void commit() throws IOException {
        file.close();
    }
}
