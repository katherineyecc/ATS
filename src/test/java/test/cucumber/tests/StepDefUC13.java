package test.cucumber.tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.network.ATServer;
import main.utilities.Config;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefUC13 extends TestCase {

	ATServer ats;
	Robot robot;
	boolean success = false;
	String identity = "student";
	String stuInfo = "101075401, tom";
	
	@When("^The Student logs into the system  and inputs \"([^\"]*)\"$")
	public void the_Student_logs_into_the_system_and_inputs(String arg1) throws Throwable {
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
			for(int index=0; index<stuInfo.length(); index++) {
				char c = stuInfo.charAt(index);
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
		} catch(AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		String output = ats.output;
		if(state == 15) {
			if(output.contentEquals("No Available Courses!\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}

	@Then("^The Student cannot fulfill the course$")
	public void the_Student_cannot_fulfill_the_course() throws Throwable {
		assertEquals(true, success);
	}
	
	@When("^The Student logs in  and inputs \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and term ends$")
	public void the_Student_logs_in_and_inputs_and_and_and_and_and_and_term_ends(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(5000);
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
			for(int index=0; index<stuInfo.length(); index++) {
				char c = stuInfo.charAt(index);
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
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg4.length(); index++) {
				char c = arg4.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
			for(int index=0; index<arg5.length(); index++) {
				char c = arg5.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);

			robot.delay(60000);// delay for term to end at 118s
			robot.delay(30000);
			
			for(int index=0; index<arg6.length(); index++) {
				char c = arg6.charAt(index);
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
			if(output.contentEquals("Term ends!\n")) {
				success = true;
			}
		}
		ats = null;
		robot = null;
	}
	
}
