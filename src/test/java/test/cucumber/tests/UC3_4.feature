@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk fails to create a course due to invalid input
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "create course" and "123" and current term not ending and registration not starting
  
  Then The Clerk cannot create the courses
    