@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk logs out the ATS unsuccessfully
  Given The ATS is on
  
  When The Clerk logs into ATS and enters "hello" not to log out
  
  Then The Clerk does't log out