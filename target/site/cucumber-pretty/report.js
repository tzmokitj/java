$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DropdownMultiple.feature");
formatter.feature({
  "line": 2,
  "name": "Dropdown Menu",
  "description": "",
  "id": "dropdown-menu",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@UATTesting4"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "Selecting multiple dropdown  options",
  "description": "",
  "id": "dropdown-menu;selecting-multiple-dropdown--options",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open a Chrome browser with fruits URL",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "selecting multiple dropdown option",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "options are being displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "DropdownMultipleDef.openAChromeBrowserWithFruitsURL()"
});
formatter.result({
  "duration": 6497186485,
  "status": "passed"
});
formatter.match({
  "location": "DropdownMultipleDef.selectingMultipleDropdownOption()"
});
formatter.result({
  "duration": 3900472474,
  "status": "passed"
});
formatter.match({
  "location": "DropdownMultipleDef.optionsAreBeingDisplayed()"
});
formatter.result({
  "duration": 254568813,
  "status": "passed"
});
});