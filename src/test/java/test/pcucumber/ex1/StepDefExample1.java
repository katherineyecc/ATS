package test.pcucumber.ex1;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.client.ATClient;
import main.client.ATClientMock;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;

public class StepDefExample1 extends TestCase {
	
	ATServer ats = new ATServer(Config.DEFAULT_PORT);
	String filename = null;
	Robot robot;
	int countFail = 0;
	boolean s2Fail = false;
	boolean s3Fail = false;
	boolean s4Fail = false;
	//List<Thread> thread = new ArrayList<Thread>();
	
	@Given("^Student '(\\d+)' regieters in Course '(\\d+)' Machine Learning according to \"([^\"]*)\"$")
	public void student_regieters_in_Course_Machine_Learning_according_to(int arg1, int arg2, String arg3) {
		try {
			robot = new Robot();
			robot.delay(39000);
			filename = arg3;
		    Thread t = new Thread(new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, filename));
		    robot.delay(200);
		    t.start();
		    robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@When("^Student '(\\d+)', '(\\d+)', '(\\d+)' try to simultaneously register in Course with their file \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void student_try_to_simultaneously_register_in_Course_with_their_file_and_and(int arg1, int arg2, int arg3, String arg4, String arg5, String arg6) {
	    ATClientMock atc1 = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg4);
	    ATClientMock atc2 = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg5);
	    ATClientMock atc3 = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg6);
		Thread t2 = new Thread(atc1);
	    Thread t3 = new Thread(atc2);
	    Thread t4 = new Thread(atc3);
	    try {
	    	robot = new Robot();
	    	robot.delay(200);
	    	t2.start(); // jack
		    t3.start(); // james
		    //t2.start(); // jack
		    t4.start(); // joey
	    	robot.delay(1000);
	    	s2Fail = atc1.getCountOfFailRegister();
	    	s3Fail = atc2.getCountOfFailRegister();
	    	s4Fail = atc3.getCountOfFailRegister();
	    	if(s2Fail == true) {
	    		countFail++;
	    		System.out.println("S2 failed to register in the course.");
	    	}
	    	if(s3Fail == true) {
	    		countFail++;
	    		System.out.println("S3 failed to register in the course.");
	    	}
	    	if(s4Fail == true) {
	    		countFail++;
	    		System.out.println("S4 failed to register in the course.");
	    	}
	    	//System.out.println(countFail);
	    } catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}

	@Then("^Only one of the three students gets in the Course$")
	public void only_one_of_the_three_students_gets_in_the_Course() {
	    assertEquals(2, countFail);
	}

}
