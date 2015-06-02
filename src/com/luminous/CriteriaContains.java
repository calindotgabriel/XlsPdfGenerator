package com.luminous;

/**
 * Created by motan on 27.05.2015.
 */
public class CriteriaContains implements ConditionalCriteria {
    @Override
    public boolean meetsRequirments(String testVal) {
        return testVal.toLowerCase().contains(testVal);
    }
}
