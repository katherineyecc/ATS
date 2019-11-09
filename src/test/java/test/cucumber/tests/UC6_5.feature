@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk cannot create the student due to existence of the student
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "create student" and enters existing info "101075401, tom, y" and current term does not end and registration does not start
  
  Then The Clerk cannot create the student
  
  #SIMULATED_DAY = 2000