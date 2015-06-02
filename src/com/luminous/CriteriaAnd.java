package com.luminous;

import com.luminous.domain.Command;

import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public class CriteriaAnd implements Criteria{

    private Criteria criteria;
    private Criteria otherCriteria;

    public CriteriaAnd(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Command> meetCriteria(List<Command> commands) {
        List<Command> firstCriteriaItems = criteria.meetCriteria(commands);
        List<Command> otherCriteriaItems = otherCriteria.meetCriteria(commands);

        List<Command> firstCriteriaCommands = criteria.meetCriteria(commands);
        return otherCriteria.meetCriteria(firstCriteriaCommands);
    }
}
