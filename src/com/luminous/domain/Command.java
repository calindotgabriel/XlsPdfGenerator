package com.luminous.domain;

/**
 * Created by motan on 19.05.2015.
 */
public class Command {

    private String action;
    private String colName;
    private String predicate;
    private String testVal;
    private String fieldName;
    private String value;


    public Command(String action, String fieldName, String value) {
        this.action = action;
        this.fieldName = fieldName;
        this.value = value;
    }

    public Command(String action, String colName, String predicate, String testVal, String fieldName, String value) {
        this.action = action;
        this.colName = colName;
        this.predicate = predicate;
        this.testVal = testVal;
        this.fieldName = fieldName;
        this.value = value;
    }

    public Command(String action, String fieldName) {
        this.action = action;
        this.fieldName = fieldName;
    }

    public Command() {

    }

    public Command(String action) {
        this.action = action;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public String getTestVal() {
        return testVal;
    }

    public void setTestVal(String testVal) {
        this.testVal = testVal;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isConditional() {
        return getAction().toLowerCase().contains("conditional");
    }

    public boolean isSimple() {
        return !isConditional();
    }
}
