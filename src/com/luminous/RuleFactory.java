package com.luminous;

import com.luminous.domain.Command;

/**
 * Created by motan on 29.05.2015.
 */
public class RuleFactory {

    private static final String FILL = "fill";
    private static final String CHECK = "check";
    private static final String EXCEL_FILL = "fillFromExcel";
    private static final String EXCEL_CHECK = "checkFromExcel";
    private static final String CONDITIONAL_EXCEL_FILL = "conditionalFillFromExcel";
    private static final String CONDITIONAL_EXCEL_CHECK = "conditionalCheckFromExcel";

    public Rule getRule(Command command) {
        if (command.getAction().equals(FILL)) {
            return new FIllRule(command.getFieldName(), command.getValue());
        }

        if (command.getAction().equals(CHECK)) {
            return new CheckRule(command.getFieldName());
        }

        if (command.getAction().equals(EXCEL_FILL)) {
            return new FillFromExcelRule(command.getFieldName(), command.getColName());
        }

        if (command.getAction().equals(EXCEL_CHECK)) {
            return new CheckFromExcelRule(command.getFieldName(), command.getColName());
        }

        if (command.getAction().equals(CONDITIONAL_EXCEL_FILL)) {
            //TODO builder here
            return new ConditionalFillFromExcelRule(command.getFieldName(),
                                                    command.getColName(),
                                                    command.getPredicate(),
                                                    command.getTestVal(),
                                                    command.getValue());
        }

        if (command.getAction().equals(CONDITIONAL_EXCEL_CHECK)) {
            //TODO builder here
            return new ConditionalCheckFromExcelRule(command.getFieldName(),
                                                    command.getColName(),
                                                    command.getPredicate(),
                                                    command.getTestVal());
        }




        return null;
    }

}
