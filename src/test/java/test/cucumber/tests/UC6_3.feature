@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cannot create the student due to registration starting
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "create student" and enters info "101075403, jerry, y" and current term does not end and registration starts
  
  Then The Clerk cannot create the student
  
  #SIMULATED_DAY = 400