@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cancels the course successfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "create student" and enters info "101075403, jerry, y"
  
  Then The Clerk create the student successfully
  
  #SIMULATED_DAY = 2000