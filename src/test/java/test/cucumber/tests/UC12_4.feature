@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot drop the course due to invalid input
  Given The ATS is on
  
  When The Student logs in  and inputs "select course" and "105104" and "drop course" and "123" and term not ends and registration starts
  
  Then The Student cannot drop the course
  
  #SIMULATED_DAY = 1000