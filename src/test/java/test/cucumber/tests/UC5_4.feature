@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cannot delete the course due to invalid input
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "cancel course" and enters "123" and current term does not end and registration ends
  
  Then The Clerk cannot cancel this course
  
  #SIMULATED_DAY = 400