{
	"action" : "fill",
	"fieldName" : "textFirstName",
	"value" : "Calin"
}
{
	"action" : "check",
	"fieldName" : "isCool"
}
{
	"action" : "fillFromExcel",
	"colName" : "firstName",
	"fieldName" : "textFirstName"
}
{
	"action" : "checkFromExcel",
	"colName" : "sms",
	"fieldName" : "isSms"
}
{
	"action" : "conditionalFillFromExcel",
	"colName" : "myColumnName",
	"predicate" : "contains",
	"testVal" : "groovy",
	"value" : "We are groovy!",
	"fieldName" : "theGroovyField"
}
{
	"action" : "conditionalCheckFromExcel",
	"colName" : "myColumnName",
	"predicate" : "equals",
	"testVal" : "groovy",
	"fieldName" : "isGroovy"
}

MappingInstructions mapInstr = gson.fromJson();

RuleFactory ruleFactory = new RuleFactory(outPdfPath);

Rule rule = ruleFactory.getRule(mapInstr.getAction());
rule.export(field, value);

================ CRITERIA IDEA =====================

// open pdf channel

Interface: 
meetCriteria(List<Rule> rules) // Rule : read from JSON

Criteria fill = new FillCriteria();
Criteria check = new CheckCriteria();
Criteria xls = new XlsCriteria();

List<Rule> fillRules = fillCriteria.meetCriteria(rules);
for (Rule fillRule : fillRules) {
//	OperationFactory operationFactory = new OperationFactory(pathToPdf);
//	Operation op = operationFactory.getOperation(fillRule.getAction());
//      op.assign(fillRule.getField(), fillRule.getValue());

	Operation fillOpr = new FillOperation(templatePath,pdfPath);
	fillOpr.execute(fillRule);
}

FillOperation:
       public void execute(Rule rule) {
		field = rule.getField();
		value = rule.getValue();
		commit(field, value);	
       } 

// ======================================================================





rule.isConditional() {
	ConditionalRule conditionalRule1 = ConditionalRule.
}
