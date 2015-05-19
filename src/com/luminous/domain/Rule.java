package com.luminous.domain;

/**
 * Created by motan on 19.05.2015.
 */
public class Rule {

    private String action;
    private String fieldName;
    private String value;

    public Rule(String action, String fieldName, String value) {
        this.action = action;
        this.fieldName = fieldName;
        this.value = value;
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
}
