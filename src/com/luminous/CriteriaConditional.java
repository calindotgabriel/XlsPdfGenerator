package com.luminous;

import com.luminous.domain.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 24.05.2015.
 */
public class CriteriaConditional implements Criteria {

    @Override
    public List<Command> meetCriteria(List<Command> commands) {
        List<Command> conditionalCommands = new ArrayList<Command>();

        for (Command command : commands) {
            if (command.getAction().toLowerCase().contains("conditional")) {
                conditionalCommands.add(command);
            }
        }
        return conditionalCommands;
    }
}
