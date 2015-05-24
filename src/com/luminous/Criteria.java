package com.luminous;

import com.luminous.domain.Rule;

import java.util.List;

/**
 * Created by motan on 22.05.2015.
 */
public interface Criteria {

    public List<Rule> meetCriteria(List<Rule> rules);
}
