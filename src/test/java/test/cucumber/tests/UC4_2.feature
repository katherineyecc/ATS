@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cannot delete the course due to term ending
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "delete course" and enters "105008" and current term ends
  
  Then The Clerk cannot deletes the course
  
  #SIMULATED_DAY = 20