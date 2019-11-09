@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: The Clerk fails to create a course due to term ending
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "create course" and "OO Dev, 105103, 30, n, 0, 4, n, n" and current term ends
  
  Then The Clerk cannot create the courses
    
    #SIMULATED_DAY = 20