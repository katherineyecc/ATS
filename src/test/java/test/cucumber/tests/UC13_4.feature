@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot fulfill the course due to invalid input
  Given The ATS is on
  
  When The Student logs in  and inputs "select course" and "105104" and "register for course" and "105104" and "fulfill course" and "105104, 101" and term not ends and registration ends
  
  Then The Student cannot fulfill the course
  
  #SIMULATED_DAY = 1000