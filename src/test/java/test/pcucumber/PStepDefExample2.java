package test.pcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.client.ATClientMock;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;

public class PStepDefExample2 extends TestCase {
	
	public static ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	boolean isFail = false;
	public static int countFail = 0;
	
	@Given("^Student S(\\d+) and S(\\d+) regieter in Course C(\\d+) according to \"([^\"]*)\" and \"([^\"]*)\"$")
	public void student_S_and_S_regieter_in_Course_C_according_to_and(int arg1, int arg2, int arg3, String arg4, String arg5) {
		try {
			robot = new Robot();
			robot.delay(39000);
		    Thread t = new Thread(new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg4));
		    robot.delay(200);
		    t.start();
		    robot.delay(1000);
		    Thread t2 = new Thread(new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg5));
		    robot.delay(200);
		    t2.start();
		    robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@When("^Student S(\\d+) try to deregister in course with \"([^\"]*)\"$")
	public void student_S_try_to_deregister_in_course_with(int arg1, String arg2) {
		ATClientMock atc = new ATClientMock(Config.DEFAULT_HOST, Config.DEFAULT_PORT, arg2);
		Thread t = new Thread(atc);
		try {
			robot = new Robot();
			robot.delay(200);
			t.start();
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Then("^S(\\d+) deregister the course$")
	public void s_deregister_the_course(int arg1) {
	    // no assertion
	}

	@When("^Student S(\\d+) try to register in course \"([^\"]*)\"$")
	public void student_S_try_to_register_in_course(int arg1, String arg2) {
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

	@Then("^S(\\d+) successfully gets in the course$")
	public void s_successfully_gets_in_the_course(int arg1) {
		assertFalse(isFail);
	}

}
