package com.luminous.test;

import com.luminous.*;
import com.luminous.domain.Command;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by motan on 22.05.2015.
 */
public class CommandTest extends TestCase {

    public void testConvertCommandToPdfFillRule() {
        Command serializedCommand = new Command("fill", "textFirstName", "Calin");
        Rule fillRule = new RuleFactory().getRule(serializedCommand);
        assertTrue(fillRule instanceof FIllRule);
//        fillRule.execute();
    }

    public void testConvertCommandToPdfCheckRule() {
        Command serializedCommand = new Command("check", "textFirstName");
        Rule checkRule = new RuleFactory().getRule(serializedCommand);
        assertTrue(checkRule instanceof CheckRule);
//        checkRule.execute();
    }


    public void testConvertCommandToPdfExcelFillRule() {
        Command serializedCommand = new Command("fillFromExcel");
        Rule fillFromExcelRule = new RuleFactory().getRule(serializedCommand);
        assertTrue(fillFromExcelRule instanceof FillFromExcelRule);
//        fillFromExcelRule.execute();
    }

    public void testConvertCommandToPdfExcelCheckRule() {
        Command serializedCommand = new Command("checkFromExcel");
        Rule checkFromExcelRule = new RuleFactory().getRule(serializedCommand);
        assertTrue(checkFromExcelRule instanceof CheckFromExcelRule);
//        checkFromExcelRule.execute();
    }

    public void testConvertCommandToPdfConditionalExcelFillRule() {
        Command serializedCommand = new Command("conditionalFillFromExcel");
        Rule conditionalFillFromExcel = new RuleFactory().getRule(serializedCommand);
        assertTrue(conditionalFillFromExcel instanceof ConditionalFillFromExcelRule);
//        conditionalFillFromExcel.execute();
    }

    public void testConvertCommandToPdfConditionalExcelCheckRule() {
        Command serializedCommand = new Command("conditionalCheckFromExcel");
        Rule conditionalCheckFromExcel = new RuleFactory().getRule(serializedCommand);
        assertTrue(conditionalCheckFromExcel instanceof ConditionalCheckFromExcelRule);
//        conditionalCheckFromExcel.execute();
    }




}
