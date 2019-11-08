@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk logs out the ATS successfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "log out"
  
  Then The Clerk logs out successfully
    