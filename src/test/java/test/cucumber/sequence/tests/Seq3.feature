@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk c3 creates and deletes the course cs1
  	Given Clerk turns on the ATS server
  	
  	When Clerk c3 enters identity "clerk" and password "admin3"
  	
  	And Clerk c3 enters "create course" and course info "OO Language, 105105, 30, n, 0, 3, n, n"
  	
  	And Clerk c3 enters "delete course" and code "105105"
  	
  	Then c3 creates and deletes course successfully
   
     #SIMULATED_DAY = 2000