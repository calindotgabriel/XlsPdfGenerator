package com.luminous;

import com.luminous.domain.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class CriteriaExcel implements Criteria{

    @Override
    public List<Rule> meetCriteria(List<Rule> rules) {
        List<Rule> excelRules = new ArrayList<Rule>();

        for (Rule rule : rules) {
            if (rule.getAction().toLowerCase().contains("excel")) {
                excelRules.add(rule);
            }
        }
        return excelRules;
    }
}
