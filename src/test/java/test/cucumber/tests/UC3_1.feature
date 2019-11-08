@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk creates a course successfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "create course" and enters "OO Dev, 105104, 30, n, 0, 4, n, n"
  
  Then The course is created successfully
    