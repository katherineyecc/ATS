@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student logs in, selects, registers for and fulfills a course that Clerk created
  	Given The Server is on
  	
  	When Clerk c2 enters identity as "clerk" and password "admin2"
  	
  	And Clerk c2 enters "create course" and creates course cs3 with info "Machine Learning, 108105, 30, n, 0, 3, n, n"
  	
  	And Student n3 enters "student" and "101075402, jack"
  	
  	And Student n3 enters "select course" and course code "108105"
  	
  	And Student n3 enters "register for course" and current selected course code "108105"
  	
  	And Wait for registration to end
  	
  	And Student n3 enters "fulfill course" and course code and grade "108105, 85"
  	
  	Then Clerk creates course successfully and Student fulfills course successfully
  	
  	# SIMULATED_DAY = 2000
    