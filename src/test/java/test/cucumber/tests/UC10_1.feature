@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot select the course due to no available courses
  Given The ATS is on
  
  When The Student logs in and enters "select course"
  
  Then The Student cannot select the course
  
  # comment the InitializeCourses() in the University.java