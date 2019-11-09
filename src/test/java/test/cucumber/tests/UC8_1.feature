@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student logs in the ATS successfully
  Given The ATS is on
  
  When The Clerk input "student" and student number and name "101075401, tom"
  
  Then The Student enters the system successfully
  