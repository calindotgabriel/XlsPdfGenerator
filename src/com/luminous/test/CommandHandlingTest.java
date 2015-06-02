package com.luminous.test;

import com.luminous.*;
import com.luminous.domain.Command;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

/**
 * Created by motan on 24.05.2015.
 */
public class CommandHandlingTest extends TestCase {

    public void testGeneration() throws IOException {
        String rulesPath = "res/test_rules.json";

        JsonSerializer serializer = new JsonSerializer(rulesPath);
        List<Command> commands = serializer.serializeJsonArray();

        Criteria fill = new CriteriaFill();
        Criteria check = new CriteriaCheck();
        Criteria excel = new CriteriaExcel();
        Criteria conditional = new CriteriaConditional();

        Criteria fillFromExcel = new CriteriaAnd(fill, excel);
        Criteria checkFromExcel = new CriteriaAnd(check, excel);

        Criteria conditionalCheckFromExcel = new CriteriaAnd(conditional, checkFromExcel);

        List<Command> checkCommands = check.meetCriteria(commands);
        assertEquals(2, checkCommands.size());


        List<Command> conditionalCheckFromExcelCommands = conditionalCheckFromExcel.meetCriteria(commands);
        assertEquals(1, conditionalCheckFromExcelCommands.size());
  }
}
