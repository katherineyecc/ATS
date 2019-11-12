@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student logs in and logs out of ATS
  	Given ATS is on
  	
  	When Student n2 enters "student" and number and name "101075401, tom"
  	
  	And Student n2 enters "log out"
  	
  	Then Student logs in and logs out of ATS successfully