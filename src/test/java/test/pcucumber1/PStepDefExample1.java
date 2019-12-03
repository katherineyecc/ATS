package test.pcucumber1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.client.ATClientMock;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;

public class PStepDefExample1 extends TestCase {
	
	public static ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	boolean isFail = false;
	public static int countFail = 0;
	
	@Given("^Student S(\\d+) regieters in Course C(\\d+) Machine Learning according to \"([^\"]*)\"$")
	public void student_S_regieters_in_Course_C_Machine_Learning_according_to(int arg1, int arg2, String arg3) {
		try {
			robot = new Robot();
			robot.delay(39000);
		    Thread t = new Thread(new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg3));
		    robot.delay(200);
		    t.start();
		    robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@When("^Student S(\\d+) try to register in course with \"([^\"]*)\"$")
	public void student_S_try_to_register_in_course_with(int arg1, String arg2) {
		ATClientMock atc = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg2);
		Thread t = new Thread(atc);
		try {
			robot = new Robot();
			robot.delay(200);
			t.start();
			robot.delay(1000);
			isFail = atc.getCountOfFailRegister();
			if(isFail) {
				System.out.println("S" + arg1 + "failed to register in the course");
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Then("^S(\\d+) gets in the course$")
	public void s_gets_in_the_course(int arg1) {
	    assertFalse(isFail);
	}
	
	/*
	@Given("^Repeat tag_one's precondition$")
	public void repeat_tag_one_s_precondition() {
	    // just to repeat the S1 registration
	}
	*/

}
