@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk c1 creates and cancels a course
  	Given Clerk open the server
  	
  	When Clerk enters "clerk" and password "admin1"
  	
  	And Clerk enters "create course" and course info "Python Language, 107105, 30, n, 0, 3, n, n"
  	
  	And Wait for registration ending
  	
  	And Clerk enters "cancel course" and course code "105105"
  	
  	Then Clerk c1 creates and cancels the course successfully
  	
#SIMULATED_DAY = 2000