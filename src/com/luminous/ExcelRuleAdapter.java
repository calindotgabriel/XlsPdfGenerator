package com.luminous;

import com.luminous.domain.Command;

/**
 * Created by motan on 27.05.2015.
 */
public class ExcelRuleAdapter {

    protected XlsWorker worker;

    public ExcelRuleAdapter(XlsWorker worker) {
        this.worker = worker;
    }

    /**
     * Converts an excel command to be inderpreted as a simple command.
     */
    public Command excelToSimple(int pdfIndex, Command command) {
        String value = worker.getValueForColumnIndex(pdfIndex, command.getColName());
        command.setValue(value);
        return command;
    }
}
