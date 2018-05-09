$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/resources/US1.feature");
formatter.feature({
  "name": "Access to the Contacts Orchestrator Solution\u0027s (COS) Landing Page",
  "description": "  As a user\n  I want to access to the URL address provided for the landing page\n  So that I can see the list of the contacts available",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Landing page\u0027s title",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@noerror"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I access the landing page of COS",
  "keyword": "Given "
});
formatter.match({
  "location": "US1StepsDef.iAccessTheLandingPageOfCOS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the title of the page should be \"Contacts Orchestrator Solution\"",
  "keyword": "Then "
});
formatter.match({
  "location": "US1StepsDef.theTitleOfThePageShouldBe(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Table contains four columns",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@noerror"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I access the landing page of COS",
  "keyword": "Given "
});
formatter.match({
  "location": "US1StepsDef.iAccessTheLandingPageOfCOS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the table should have four columns",
  "keyword": "Then "
});
formatter.match({
  "location": "US1StepsDef.theTableShouldHaveColumns()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Click on the details button",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@noerror"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I access the landing page of COS",
  "keyword": "Given "
});
