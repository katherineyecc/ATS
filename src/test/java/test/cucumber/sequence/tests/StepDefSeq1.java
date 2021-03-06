package test.cucumber.sequence.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefSeq1 extends TestCase {
	
	ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	int[] stateSeq = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int[] expectSeq = new int[] {2,0};
	int index = 0;
	String[] msgSeq = new String[10];
	String[] str = new String[] {"What can I do for you? Menu: Create Course/Student, Delete Course/Student, Cancel Course, Dean's List.\n", 
			"Successfully Log Out!\n"};
	
	@Given("^The AST server is turned on$")
	public void the_AST_server_is_turned_on() throws Throwable {
		Thread t = new Thread(ats);
		t.start();
	}

	@When("^Clerk c(\\d+) enters \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void clerk_c_enters_and_password(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(8000);
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
		stateSeq[index] = ats.getClientState(); // =2
		msgSeq[index] = ats.output; // ="What can I do for you? Menu: Create Course/Student, Delete Course/Student, Cancel Course, Dean's List.\n"
		index++;
	}

	@When("^Clerk c(\\d+) enters \"([^\"]*)\"$")
	public void clerk_c_enters(int arg1, String arg2) throws Throwable {
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
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =0
		msgSeq[index] = ats.output; // ="Successfully Log Out!\n"
	}

	@Then("^c(\\d+) logs in and out successfully$")
	public void c_logs_in_and_out_successfully(int arg1) throws Throwable {
	    for(int i=0; i<=index; i++) {
	    	assertEquals(expectSeq[i], stateSeq[i]);
	    	assertEquals(str[i], msgSeq[i]);
	    }
	}

}
