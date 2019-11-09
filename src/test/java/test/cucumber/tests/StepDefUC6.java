package test.cucumber.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.*;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefUC6 extends TestCase {
	
	ATServer ats;
	Robot robot;
	boolean success = false;
	String identity = "clerk";
	String password = "admin1";
	@When("^The Clerk logs into ATS and enters \"([^\"]*)\" and enters info \"([^\"]*)\"$")
	public void the_Clerk_logs_into_ATS_and_enters_and_enters_info(String arg1, String arg2) throws Throwable {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(8000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<identity.length(); index++) {
				char c = identity.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<password.length(); index++) {
				char c = password.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
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
		} catch(AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		String output = ats.output;
		if(state == 2) {
			if(output.contentEquals("Success!\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}

	@Then("^The Clerk create the student successfully$")
	public void the_Clerk_create_the_student_successfully() throws Throwable {
		assertEquals(true, success);
	}
	
	@When("^The Clerk logs into ATS and enters \"([^\"]*)\" and enters info \"([^\"]*)\" and current term ends$")
	public void the_Clerk_logs_into_ATS_and_enters_and_enters_info_and_current_term_ends(String arg1, String arg2) throws Throwable {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(8000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<identity.length(); index++) {
				char c = identity.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<password.length(); index++) {
				char c = password.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
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
		} catch(AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		String output = ats.output;
		if(state == 2) {
			if(output.contentEquals("Term ends!\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}
	
	@Then("^The Clerk cannot create the student$")
	public void the_Clerk_cannot_create_the_student() throws Throwable {
		assertEquals(true, success);
	}

}
