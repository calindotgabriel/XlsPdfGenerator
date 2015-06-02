package com.luminous;

/**
 * Created by motan on 27.05.2015.
 */
public class ConditonalCriteriaFactory {

    public ConditionalCriteria getCriteria(String predicate) {
        if (predicate.toLowerCase().equals("contains")){
            return new CriteriaContains();
        }
        if (predicate.toLowerCase().equals("equals")){
            return new CriteriaEquals();
        }
        return null;
    }
}
