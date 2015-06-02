package com.luminous;

import com.luminous.domain.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class CriteriaCheck implements Criteria{

    @Override
    public List<Command> meetCriteria(List<Command> commands) {
        List<Command> fillCommands = new ArrayList<Command>();

        for (Command command : commands) {
            if (command.getAction().toLowerCase().contains("check")) {
                fillCommands.add(command);
            }
        }
        return fillCommands;
    }
}
