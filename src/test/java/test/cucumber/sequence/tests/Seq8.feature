@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk logs into ATS and creates a course, Student logs into ATS, selects and drops the course
  	Given ATS is turned on
  	
  	When Clerk c2 enters "clerk" and pwd "admin2"
  	
  	And Clerk c2 inputs "create course" and enters course info "Graph Theory, 110105, 30, n, 0, 3, n, n"
  	
  	And Student n4 inputs "student" and enters name and number "101075404, james"
  	
  	And Student n4 inputs "select course" and enters "110105"
  	
  	And Student n4 inputs "drop course" and enters selected"110105"
  	
  	Then Clerk creates the course successfully and Student drops the course successfully
  	
  	#SIMULATED_DAY = 2000