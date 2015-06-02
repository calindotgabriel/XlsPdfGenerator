package com.luminous;

import com.luminous.domain.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class CriteriaFill implements Criteria{

    @Override
    public List<Command> meetCriteria(List<Command> commands) {
        List<Command> fillCommands = new ArrayList<Command>();

        for (Command command : commands) {
            if (command.getAction().toLowerCase().contains("fill")) {
                fillCommands.add(command);
            }
        }
        return fillCommands;
    }
}
