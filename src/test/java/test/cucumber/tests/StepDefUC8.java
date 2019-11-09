package test.cucumber.tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefUC8 extends TestCase {

	ATServer ats;
	Robot robot;
	boolean success = false;
	String identity = "student";
	
	@When("^The Clerk input \"([^\"]*)\" and student number and name \"([^\"]*)\"$")
	public void the_Clerk_input_and_student_number_and_name(String arg1, String arg2) throws Throwable {
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
		if(state == 4) {
			if(output.contentEquals("What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course.\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}

	@Then("^The Student enters the system successfully$")
	public void the_Student_enters_the_system_successfully() throws Throwable {
		assertEquals(true, success);
	}
	
	@When("^The Student input \"([^\"]*)\" and then input \"([^\"]*)\" and input \"([^\"]*)\"$")
	public void the_Student_input_and_then_input_and_input(String arg1, String arg2, String arg3) throws Throwable {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(8000);
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
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
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
		if(state == 4) {
			if(output.contentEquals("What can I do for you? Menu: Select Course, Register for Course, Drop Course, Deregister Course.\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}
	
	@When("^The Student input \"([^\"]*)\" and input \"([^\"]*)\"$")
	public void the_Student_input_and_input(String arg1, String arg2) throws Throwable {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(8000);
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
		if(state == 5) {
			if(output.contentEquals("Invalid student number or student name.\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}

	@Then("^The Student cannot enters the system$")
	public void the_Student_cannot_enters_the_system() throws Throwable {
		assertEquals(true, success);
	}
}
