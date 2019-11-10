@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot deregister for the course due to invalid input
  Given The ATS is on
  
  When The Student logs in ATS and inputs "select course" and "105104" and "register for course" and "105104" and "deregister course" and "123" and term not ends and registration starts and registration not ends 
  
  Then The Student cannot deregister for a course
  
  #SIMULATED_DAY = 1000  