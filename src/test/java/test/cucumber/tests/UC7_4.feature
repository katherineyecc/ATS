@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cannnot delete the student due to invalid input
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "delete student" and enters incorrect info "123" and term does not end and registration does not start
  
  Then The Clerk cannot delete the student
  
  #SIMULATED_DAY = 2000