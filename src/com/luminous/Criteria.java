package com.luminous;

import com.luminous.domain.Command;

import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public interface Criteria {

    public List<Command> meetCriteria(List<Command> commands);
}
