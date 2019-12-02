@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Two Students try to register in the course and one Student deregister the course
  
  Given Student S1 and S2 regieters in C2 according to "/Users/sandra/git/ATS/src/main/java/main/client/file_five.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_six.txt"
  
  When Student S3 and S4 try to simultaneously register with "/Users/sandra/git/ATS/src/main/java/main/client/file_seven.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_eight.txt" and S2 degister with "/Users/sandra/git/ATS/src/main/java/main/client/file_nine.txt" 
  
  Then Check the result with the actual sequence