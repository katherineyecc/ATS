package test.ocucumber.ex2;

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

public class StepDefExample2 extends TestCase {
	
	ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	boolean s3Fail = false;
	boolean s4Fail = false;
	int countFail = 0;

	@Given("^Student S(\\d+) and S(\\d+) regieters in C(\\d+) according to \"([^\"]*)\" and \"([^\"]*)\"$")
	public void student_S_and_S_regieters_in_C_according_to_and(int arg1, int arg2, int arg3, String arg4, String arg5) {
		try {
			robot = new Robot();
			robot.delay(39000);
		    Thread t1 = new Thread(new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg4));
		    robot.delay(200);
		    t1.start();
		    robot.delay(1000);
		    Thread t2 = new Thread(new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg5));
		    robot.delay(200);
		    t2.start();
		    robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@When("^Student S(\\d+) and S(\\d+) try to simultaneously register with \"([^\"]*)\" and \"([^\"]*)\" and S(\\d+) degister with \"([^\"]*)\"$")
	public void student_S_and_S_try_to_simultaneously_register_with_and_and_S_degister_with(int arg1, int arg2, String arg3, String arg4, int arg5, String arg6) {
		ATClientMock atc3 = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg3);
	    ATClientMock atc4 = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg4);
	    ATClientMock atc5 = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg6);
		Thread t3 = new Thread(atc3);
	    Thread t4 = new Thread(atc4);
	    Thread t5 = new Thread(atc5);
	    try {
	    	robot = new Robot();
	    	robot.delay(200);
	    	t3.start();
		    t4.start();
		    t5.start();
	    	robot.delay(1000);
	    	s3Fail = atc3.getCountOfFailRegister();
	    	s4Fail = atc4.getCountOfFailRegister();
	    	if(s3Fail == true) {
	    		countFail++;
	    		System.out.println("S3 failed to register in the course.");
	    	}
	    	if(s4Fail == true) {
	    		countFail++;
	    		System.out.println("S4 failed to register in the course.");
	    	}
	    	
	    } catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}

	@Then("^Check the result with the actual sequence$")
	public void check_the_result_with_the_actual_sequence() {
	    boolean result = false;
	    if(countFail == 0 || countFail == 1) {
	    	result = true;
	    }
	    assertEquals(true, result);
	}
	
}
