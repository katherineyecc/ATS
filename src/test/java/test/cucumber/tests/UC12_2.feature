@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student cannot drop the course due to term ending
  Given The ATS is on
  
  When The Student logs in  and inputs "select course" and "105104" and "drop course" and "105104" and term ends
  
  Then The Student cannot drop the course
  
  #SIMULATED_DAY = 700