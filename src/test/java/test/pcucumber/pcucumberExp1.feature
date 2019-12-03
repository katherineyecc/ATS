@tag
Feature: Three Students try to register in the course simultaneously
  I want to use this template for my feature file

  @tag1
  Scenario: StudentS2 try to register in the last place of a course
    Given Student S1 regieters in Course C1 Machine Learning according to "/Users/sandra/git/ATS/src/main/java/main/client/file_one.txt"

    When Student S2 try to register in course with "/Users/sandra/git/ATS/src/main/java/main/client/file_two.txt" 
    
	  Then S2 gets in the course
	  
	@tag2
	Scenario: StudentS3 try to register in the last place of a course
		Given Student S1 regieters in Course C1 Machine Learning according to "/Users/sandra/git/ATS/src/main/java/main/client/file_one.txt"
		
		When Student S3 try to register in course with "/Users/sandra/git/ATS/src/main/java/main/client/file_three.txt" 

		Then S3 gets in the course
		
	@tag3
	Scenario: StudentS4 try to register in the last place of a course
		Given Student S1 regieters in Course C1 Machine Learning according to "/Users/sandra/git/ATS/src/main/java/main/client/file_one.txt"
		
		When Student S4 try to register in course with "/Users/sandra/git/ATS/src/main/java/main/client/file_four.txt"
		
		Then S4 gets in the course
