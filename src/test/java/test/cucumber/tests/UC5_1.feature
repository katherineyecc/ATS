@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cancels the course successfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "cancel course" and enters code "105104"
  
  Then The Clerk cancels the course successfully
  
  #SIMULATED_DAY = 400