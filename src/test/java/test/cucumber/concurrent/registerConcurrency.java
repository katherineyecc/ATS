package test.cucumber.concurrent;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class registerConcurrency extends TestCase {
	
	ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	int[] stateSeq = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int[] expectSeq = new int[] {2,2,4,4,4};
	int index = 0;
	String[] msgSeq = new String[10];
	String[] str = new String[] {"What can I do for you? Menu: Create Course/Student, Delete Course/Student, Cancel Course, Dean's List.\n", 
			"Success!\n", "What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course, Fulfill Course.\n", 
			"Success!\n", "Success!\n"};
	
	@Given("^ATS server is on$")
	public void ats_server_is_on() throws Throwable {
		Thread t = new Thread(ats);
		t.start();
	}

	@When("^Student n(\\d+) enters \"([^\"]*)\" and \"([^\"]*)\" login$")
	public void student_n_enters_and_login(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(8000); // wait for creating a new client console
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course, Fulfill Course.\n"
		index++;
	}

	@When("^n(\\d+) enters \"([^\"]*)\" and enters \"([^\"]*)\"$")
	public void n_enters_and_enters(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(200);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="Success!\n"
		index++;
	}

	@When("^n(\\d+) enters \"([^\"]*)\" and input \"([^\"]*)\" but no submission$")
	public void n_enters_and_input_but_no_submission(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(200);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			/*
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			*/
		} catch (AWTException e) {
			e.printStackTrace();
		}
		/*
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="Success!\n"
		index++;
		*/
	}

	@When("^n(\\d+) wait$")
	public void n_wait(int arg1) throws Throwable {
	    //wait to switch console
	}

	@When("^Student n(\\d+) enters \"([^\"]*)\" and \"([^\"]*)\" to login$")
	public void student_n_enters_and_to_login(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(5000); // wait for creating a new client console
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course, Fulfill Course.\n"
		index++;
	}

	@When("^n(\\d+) enters \"([^\"]*)\" and enters the same code \"([^\"]*)\"$")
	public void n_enters_and_enters_the_same_code(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(200);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="Success!\n"
		index++;
	}

	@When("^n(\\d+) enters \"([^\"]*)\" and input \"([^\"]*)\" but without submission$")
	public void n_enters_and_input_but_without_submission(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(200);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			/*
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			*/
			robot.delay(5000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		/*
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="Success!\n"
		index++;
		*/
	}

	@When("^n(\\d+) and n(\\d+) submit at the same time$")
	public void n_and_n_submit_at_the_same_time(int arg1, int arg2) throws Throwable {
	    // manually submit
	}

	@Then("^only one of them registers in the course successfully$")
	public void only_one_of_them_registers_in_the_course_successfully() throws Throwable {
		// read the log
	}

}
