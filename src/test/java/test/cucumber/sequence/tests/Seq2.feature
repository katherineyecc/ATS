@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk c2 logs into ATS, creates a student and deletes the student
   Given Turn on the ATS server
   
   When Clerk c2 enters "clerk" and "admin1"
   
   And Enters "create student" and info "101075403, jerry, y"
   
   And Enters "delete student" and number "101075403"
   
   Then c2 creates and deletes student successfully
   
   
  #SIMULATED_DAY = 2000