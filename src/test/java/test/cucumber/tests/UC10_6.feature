@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student selects the course and register for the course successfully
  Given The ATS is on
  
  When The Student logs in and enters "select course" and "105104" and "register for course" and "105104"
  
  Then The Student register for a course successfully
  
  # de-comment the InitializeCourses() in the University.java
  #SIMULATED_DAY = 2000