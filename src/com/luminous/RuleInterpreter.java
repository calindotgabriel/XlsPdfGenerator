package com.luminous;

import com.luminous.domain.Rule;
import com.luminous.exception.RuleNotSupportedException;

/**
 * Created by motan on 19.05.2015.
 */
public class RuleInterpreter {

    Rule rule;

    public static final String ACTION_FILL = "fill";

    public RuleInterpreter(Rule rule) {
        this.rule = rule;
    }

    public void interpret() throws RuleNotSupportedException {

        if (rule.getAction().equals(ACTION_FILL)) {
            String fieldName = rule.getFieldName();
            String value = rule.getValue();




        } else {
            throw new RuleNotSupportedException();
        }

    }
}
