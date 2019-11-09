@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk deletes the student successfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "delete student" and enters correct info "101075401"
  
  Then The Clerk delete the student successfully
  
  #SIMULATED_DAY = 2000