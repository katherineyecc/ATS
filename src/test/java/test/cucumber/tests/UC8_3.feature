@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student logs in the ATS successfully
  Given The ATS is on
  
  When The Student input "student" and input "101075402, tom"
  
  Then The Student cannot enters the system
  