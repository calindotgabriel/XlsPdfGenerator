ruleFactory



Rule rule1 = ruleFactory.getRule("fill");
rule1.export(field, value, path);

Rule rule2 = ruleFactory.getRule("check");
rule2.export(field, checked, path);

Rule rule3 = ruleFactory.getRule("fillFromExcel");
rule3.export(columnName, fieldName, path);

Rule rule4 = ruleFactory.getRule("checkFromExcel");
rule4.export(field, checked, path);

Rule rule5 = ruleFactory.getRule("conditionalFillFromExcel");
rule4.export(columnName, value, predicate, testVal, path);
 
========================================

RuleFactory = FactoryProducer.getRuleFactory("fillFromExcel");





