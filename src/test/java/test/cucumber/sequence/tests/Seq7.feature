@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Clerk logs into ATS and creates a course, Student logs in and selects, registers and de-registers for this course
  	Given ATS on
  	
  	When Clerk c3 enters "clerk" and pswd "admin3"
  	
  	And Clerk c3 enters "create course" and  input course info "Operating System, 109105, 30, n, 0, 3, n, n"
  	
  	And Student n3 inputs "student" and "101075402, jack"
  	
  	And Student n3 inputs "select course" and course code "109105"
  	
  	And Student n3 inputs "register for course" and selected code "109105"
  	
  	And Student n3 inputs "deregister course" and registered code "109105"
  	
  	Then Clerks creates the course successfully and Student registers and de-registers for the course successfully
  	
  	#SIMULATED_DAY = 2000
   