package com.luminous.test;

import com.luminous.domain.Rule;
import junit.framework.TestCase;

/**
 * Created by motan on 24.05.2015.
 */
public class ConditionalRuleTest extends TestCase {

    public void testConditionals() {
        Rule rule = new Rule();
        rule.setAction("conditionalCheckFromExcel");
        rule.setColName("bill");

    }
}
