@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot fulfill the course due to no available course
  Given The ATS is on
  
  When The Student logs into the system  and inputs "fulfill course"
  
  Then The Student cannot fulfill the course
  
  #SIMULATED_DAY = 2000  