@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cannnot delete the student due to term ending
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "delete student" and enters correct info "101075401" and term ends
  
  Then The Clerk cannot delete the student
  
  #SIMULATED_DAY = 20