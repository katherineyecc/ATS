@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk deletes the course successfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "delete course" and enters "105008" and current term not ending and registration not starting
  
  Then The Clerk deletes the course successfully
  
  #SIMULATED_DAY = 2000