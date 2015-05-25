# XlsPdfGenerator

<h4>Generates PDF files with data extracted from EXCEL columnns,
using a PDF template, by given rules from a .JSON file.</h4>

<h3>JSON Rule types:</h3>

• fill - fills out a named form field in the PDF with a string value.

• check - adds a check mark to a named form field on the PDF.

• fillFromExcel - fills out a named form field in the PDF using the value found in the named Excel
column.

• checkFromExcel - adds a check mark to a named checkbox on the PDF using the value found
in the named Excel column (the value found in Excel must be ‘true’, ’yes’ or 1 in order to check
the checkbox).

• conditionalFillFromExcel - fills out a named form field in the PDF IF a condition is true. For
simplicity we will limit the predicates used for the condition to ‘equals’ and ‘contains’. Equals is a
literal equality test, contains looks for a substring.

• conditionalCheckFromExcel - adds a check mark to a named form field IF a condition is true.

<h3>Example rules:</h3>

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


<h3>Usage:</h3>
<p>java XlsPdfGenerator xlsPath pdfTempalatePath jsonRules outputFolderPath</p>

