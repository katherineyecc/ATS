@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Three students try to register in the last place of a course
  
  Given Student '101075401' regieters in Course '108110' Machine Learning according to "/Users/sandra/git/ATS/src/main/java/main/client/file_one.txt"
  
  When Student '101075402', '101075404', '101075405' try to simultaneously register in Course with their file "/Users/sandra/git/ATS/src/main/java/main/client/file_two.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_three.txt" and "/Users/sandra/git/ATS/src/main/java/main/client/file_four.txt"
  
  Then Only one of the three students gets in the Course