package com.luminous;

import com.luminous.domain.Command;

/**
 * Created by motan on 27.05.2015.
 */
public class ConditionalExcelRuleAdapter extends ExcelRuleAdapter {

    public ConditionalExcelRuleAdapter(XlsWorker worker) {
        super(worker);
    }

    public boolean ruleMeetsRequirements(int pdfIndex, Command command) {
        String predicate = command.getPredicate();
        ConditionalCriteria criteria = new ConditonalCriteriaFactory().getCriteria(predicate);
        String columnName = command.getColName();
        String value = worker.getValueForColumnIndex(pdfIndex, columnName);
        return criteria.meetsRequirments(value);
    }
}
