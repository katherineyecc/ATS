@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk logs in the ATS with incorrect password
  Given The ATS server is on
  
  When The Clerk input "clerk" and incorrect password "123123" and then correct password "admin1"
  
  Then The Clerk enters the system successfully
  