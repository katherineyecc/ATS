@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot fulfill the course due to non-existing course
  Given The ATS is on
  
  When The Student logs in  and inputs "select course" and "105104" and "register for course" and "105104" and "fulfill course" and "123123, 85" term not ends and registration startss
  
  Then The Student cannot fulfill the course
  
  #SIMULATED_DAY = 1000