@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot deregister for the course due to no available course
  Given The ATS is on
  
  When The Student logs in ATS and inputs "deregister course"
  
  Then The Student cannot deregister for a course
  
  #SIMULATED_DAY = 2000  