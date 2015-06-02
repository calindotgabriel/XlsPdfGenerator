package com.luminous;

import com.luminous.domain.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class CriteriaExcel implements Criteria{

    @Override
    public List<Command> meetCriteria(List<Command> commands) {
        List<Command> excelCommands = new ArrayList<Command>();

        for (Command command : commands) {
            if (command.getAction().toLowerCase().contains("excel")) {
                excelCommands.add(command);
            }
        }
        return excelCommands;
    }
}
