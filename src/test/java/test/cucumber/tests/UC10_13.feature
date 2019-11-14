@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot register for the course due to the course reaching its capsize
  Given The ATS is on
  
  When The Student logs in and inputs "select course" and "108108" and "register for course" and zero capsize course code "108108"
  
  Then The Student cannot register for a course
  
  # de-comment the InitializeCourses() in the University.java
  #SIMULATED_DAY = 2000
  
  # should check the log to identify the detailed failure