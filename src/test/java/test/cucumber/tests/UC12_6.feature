@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student drops the course successfully
  Given The ATS is on
  
  When The Student logs in  and inputs "select course" and "105104" and "drop course" and "105104"
  
  Then The Student drops the course
  
  #SIMULATED_DAY = 1000