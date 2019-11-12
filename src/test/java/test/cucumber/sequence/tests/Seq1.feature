@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk c1 logs into ATS and logs out of ATS
  Given The AST server is turned on
  
  When  Clerk c1 enters "clerk" and password "admin1"
  
  And Clerk c1 enters "log out"
  
  Then c1 logs in and out successfully
   