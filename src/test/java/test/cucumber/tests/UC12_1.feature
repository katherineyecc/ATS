@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot drop the course due to no available course
  Given The ATS is on
  
  When The Student logs in  and inputs "drop course"
  
  Then The Student cannot drop the course
  
  #SIMULATED_DAY = 2000  