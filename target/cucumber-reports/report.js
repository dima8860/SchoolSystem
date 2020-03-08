$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/creatingTeacher.feature");
formatter.feature({
  "name": "As a User I should able to create teacher",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a User I should able to create teacher",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "User is on home school page",
  "keyword": "Given "
});
formatter.match({
  "location": "SchoolCreatingTeacher_steps.user_is_on_home_school_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigate to teacher module",
  "keyword": "Then "
});
formatter.match({
  "location": "SchoolCreatingTeacher_steps.user_navigate_to_teacher_module()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on button to create teacher",
  "keyword": "Then "
});
formatter.match({
  "location": "SchoolCreatingTeacher_steps.user_clicks_on_button_to_create_teacher()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user fill out all information about teacher",
  "keyword": "Then "
});
formatter.match({
  "location": "SchoolCreatingTeacher_steps.user_fill_out_all_information_about_teacher()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on button submit to submit teacher info",
  "keyword": "Then "
});
formatter.match({
  "location": "SchoolCreatingTeacher_steps.user_clicks_on_button_submit_to_submit_teacher_info()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verifying that teacher\u0027s info matching database info",
  "keyword": "Then "
});
formatter.match({
  "location": "SchoolCreatingTeacher_steps.verifyingThatTeacherSInfoMatchingDatabaseInfo()"
});
formatter.result({
  "status": "passed"
});
});