@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot register for the course due to invalid input
  Given The ATS is on
  
  When The Student logs in and inputs "select course" and "105104" and "register for course" and "123"
  
  Then The Student cannot register for a course
  
  # de-comment the InitializeCourses() in the University.java
  #SIMULATED_DAY = 2000