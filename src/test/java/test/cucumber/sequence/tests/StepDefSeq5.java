package test.cucumber.sequence.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefSeq5 extends TestCase {
	
	ATServer ats = new ATServer(Config.DEFAULT_PORT);
	Robot robot;
	int[] stateSeq = new int[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	int[] expectSeq = new int[] {4,0};
	int index = 0;
	String[] msgSeq = new String[10];
	String[] str = new String[] {"What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course.\n", 
			"Successfully Log Out!\n"};

	@Given("^ATS is on$")
	public void ats_is_on() throws Throwable {
		Thread t = new Thread(ats);
		t.start();
	}

	@When("^Student n(\\d+) enters \"([^\"]*)\" and number and name \"([^\"]*)\"$")
	public void student_n_enters_and_number_and_name(int arg1, String arg2, String arg3) throws Throwable {
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
		stateSeq[index] = ats.getClientState(); // =4
		msgSeq[index] = ats.output; // ="What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course.\n"
		index++;
	}

	@When("^Student n(\\d+) enters \"([^\"]*)\"$")
	public void student_n_enters(int arg1, String arg2) throws Throwable {
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

	@Then("^Student logs in and logs out of ATS successfully$")
	public void student_logs_in_and_logs_out_of_ATS_successfully() throws Throwable {
		for(int i=0; i<=index; i++) {
	    	assertEquals(expectSeq[i], stateSeq[i]);
	    	assertEquals(str[i], msgSeq[i]);
	    }
	}
	
}
