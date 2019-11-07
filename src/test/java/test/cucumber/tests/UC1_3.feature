@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk logs in the ATS with wrong identity once
  Given The ATS server is on
  
  When The Clerk input "cclerk" but invalid and then input "clerk" and password "admin1"
  
  Then The Clerk enters the system successfully