@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot select the course due to invalid input
  Given The ATS is on
  
  When The Student logs in and enters "select course" and enters course info "123" and term does not end and registration does not end
  
  Then The Student cannot select the course
  
  # de-comment the InitializeCourses() in the University.java
  #SIMULATED_DAY = 2000