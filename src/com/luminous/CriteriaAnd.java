package com.luminous;

import com.luminous.domain.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class CriteriaAnd implements Criteria{

    private Criteria criteria;
    private Criteria otherCriteria;

    public CriteriaAnd(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Rule> meetCriteria(List<Rule> rules) {
        List<Rule> firstCriteriaItems = criteria.meetCriteria(rules);
        List<Rule> otherCriteriaItems = otherCriteria.meetCriteria(rules);

        List<Rule> firstCriteriaRules = criteria.meetCriteria(rules);
        return otherCriteria.meetCriteria(firstCriteriaRules);
    }
}
