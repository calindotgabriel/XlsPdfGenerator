package com.luminous;

import com.luminous.domain.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 24.05.2015.
 */
public class CriteriaConditional implements Criteria {

    @Override
    public List<Rule> meetCriteria(List<Rule> rules) {
        List<Rule> conditionalRules = new ArrayList<Rule>();

        for (Rule rule : rules) {
            if (rule.getAction().toLowerCase().contains("conditional")) {
                conditionalRules.add(rule);
            }
        }
        return conditionalRules;
    }
}
