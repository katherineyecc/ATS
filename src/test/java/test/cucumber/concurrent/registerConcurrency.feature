@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: two concurrent Students trying to register in the last place for the course
  	Given ATS server is on
  	
  	When Student n2 enters "student" and "101075401, tom" login
  	
  	And n2 enters "select course" and enters "108109"
  	
  	And n2 enters "register for course" and input "108109" but no submission
  	
  	And n2 wait
  	
  	And Student n3 enters "student" and "101075402, jack" to login
  	
  	And n3 enters "select course" and enters the same code "108109"
  	
  	And n3 enters "register for course" and input "108109" but without submission
  	
  	And n2 and n3 submit at the same time
  	
  	Then only one of them registers in the course successfully
    