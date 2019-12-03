@tag
Feature: Two Students try to register in the course and one student try to deregister simultaneously
  I want to use this template for my feature file

  @tag1
  Scenario: StudentS2 try to deregister the course
    Given Student S1 and S2 regieter in Course C2 according to "/Users/sandra/git/ATS/src/main/java/main/client/file_five.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_six.txt"

    When Student S2 try to deregister in course with "/Users/sandra/git/ATS/src/main/java/main/client/file_nine.txt" 
    
	  Then S2 deregister the course
	  
	@tag2
	Scenario: StudentS3 try to register in the course
		Given Student S1 and S2 regieter in Course C2 according to "/Users/sandra/git/ATS/src/main/java/main/client/file_five.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_six.txt"
		
		When Student S3 try to register in course "/Users/sandra/git/ATS/src/main/java/main/client/file_seven.txt" 

		Then S3 successfully gets in the course
		
	@tag3
	Scenario: StudentS4 try to register in the course
		Given Student S1 and S2 regieter in Course C2 according to "/Users/sandra/git/ATS/src/main/java/main/client/file_five.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_six.txt"
		
		When Student S4 try to register in course "/Users/sandra/git/ATS/src/main/java/main/client/file_eight.txt"
		
		Then S4 successfully gets in the course
