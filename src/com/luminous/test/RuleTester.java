package com.luminous.test;

import com.luminous.Criteria;
import com.luminous.CriteriaFill;
import com.luminous.domain.Rule;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class RuleTester extends TestCase {

    public void testSimpleRule() {
        Rule rule = new Rule("fill", "textFirstName", "Calin");
        assertEquals("fill", rule.getAction());
    }

    public void testFillCriteria() {
        Rule simpleRule = new Rule("fill", "textFirstName", "Calin");
        Rule ruleFillExcel = new Rule("fillFromExcel", "textFirstName", "Calin");

        List<Rule> givenFillRules = new ArrayList<Rule>();
        givenFillRules.add(simpleRule);
        givenFillRules.add(ruleFillExcel);

        Criteria fill = new CriteriaFill();
        List<Rule> resultedFillRules = fill.meetCriteria(givenFillRules);

        assertEquals(givenFillRules.size(), resultedFillRules.size());

    }
}
