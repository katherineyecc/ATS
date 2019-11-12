package test.cucumber.sequence.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefSeq2 extends TestCase {

	ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	int[] stateSeq = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int[] expectSeq = new int[] {2,2,2};
	int index = 0;
	String[] msgSeq = new String[10];
	String[] str = new String[] {"What can I do for you? Menu: Create Course/Student, Delete Course/Student, Cancel Course, Dean's List.\n", 
			"Success!\n", "Success!\n"};
	
	@Given("^Turn on the ATS server$")
	public void turn_on_the_ATS_server() throws Throwable {
		Thread t = new Thread(ats);
		t.start();
	}

	@When("^Clerk c(\\d+) enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void clerk_c_enters_and(int arg1, String arg2, String arg3) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(5000);
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

	@When("^Enters \"([^\"]*)\" and info \"([^\"]*)\"$")
	public void enters_and_info(String arg1, String arg2) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(200);
			for(int index=0; index<arg1.length(); index++) {
				char c = arg1.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
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
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =2
		msgSeq[index] = ats.output; // ="Success!\n"
		index++;
	}
	
	@When("^Enters \"([^\"]*)\" and number \"([^\"]*)\"$")
	public void enters_and_number(String arg1, String arg2) throws Throwable {
		try {
			robot = new Robot();
			robot.delay(200);
			for(int index=0; index<arg1.length(); index++) {
				char c = arg1.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
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
		} catch (AWTException e) {
			e.printStackTrace();
		}
		stateSeq[index] = ats.getClientState(); // =2
		msgSeq[index] = ats.output; // ="Success!\n"
	}

	@Then("^c(\\d+) creates and deletes student successfully$")
	public void c_creates_and_deletes_student_successfully(int arg1) throws Throwable {
		for(int i=0; i<=index; i++) {
	    	assertEquals(expectSeq[i], stateSeq[i]);
	    	assertEquals(str[i], msgSeq[i]);
		}
	}
	
}
