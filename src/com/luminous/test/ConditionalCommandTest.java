package com.luminous.test;

import com.luminous.domain.Command;
import junit.framework.TestCase;

/**
 * Created by motan on 24.05.2015.
 */
public class ConditionalCommandTest extends TestCase {

    public void testConditionals() {
        Command command = getCondEqualsCheckRule();
    }


    private Command getCondEqualsCheckRule() {
        Command command = new Command();
        command.setAction("conditionalCheckFromExcel");
        command.setColName("bill_to_news_SMS");
        command.setPredicate("equals");
        command.setTestVal("Ja tack");
        command.setFieldName("checkSms");
        return command;
    }
}
