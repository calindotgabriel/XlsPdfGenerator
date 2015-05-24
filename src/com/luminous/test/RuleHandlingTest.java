package com.luminous.test;

import com.luminous.*;
import com.luminous.domain.Rule;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

/**
 * Created by motan on 24.05.2015.
 */
public class RuleHandlingTest extends TestCase {

    public void testGeneration() throws IOException {
        String rulesPath = "res/test_rules.json";

        JsonSerializer serializer = new JsonSerializer(rulesPath);
        List<Rule> rules = serializer.serializeJsonArray();

        Criteria fill = new CriteriaFill();
        Criteria check = new CriteriaCheck();
        Criteria excel = new CriteriaExcel();
        Criteria conditional = new CriteriaConditional();

        Criteria fillFromExcel = new CriteriaAnd(fill, excel);
        Criteria checkFromExcel = new CriteriaAnd(check, excel);

        Criteria conditionalCheckFromExcel = new CriteriaAnd(conditional, checkFromExcel);

        List<Rule> checkRules = check.meetCriteria(rules);
        assertEquals(2, checkRules.size());


        List<Rule> conditionalCheckFromExcelRules = conditionalCheckFromExcel.meetCriteria(rules);
        assertEquals(1, conditionalCheckFromExcelRules.size());
  }
}
