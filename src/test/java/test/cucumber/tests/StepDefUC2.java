package test.cucumber.tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.logic.handler.InputHandler;
import main.server.logic.handler.OutputHandler;
import main.server.network.ATServer;
import main.server.network.StartServer;
import main.utilities.Config;
import main.client.ATClient;
import main.client.ClientThread;
import main.client.StartTerminals;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StepDefUC2 extends TestCase {

	ATServer ats;
	Robot robot;
	boolean success = false;
	String identity = "clerk";
	String password = "admin1";
	@Given("^The ATS is on$")
	public void the_ATS_is_on()  {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^The Clerk logs into ATS and enters \"([^\"]*)\"$")
	public void the_Clerk_logs_into_ATS_and_enters(String arg1)  {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(8000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(500);
			for(int index=0; index<identity.length(); index++) {
				char c = identity.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<password.length(); index++) {
				char c = password.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<arg1.length(); index++) {
				char c = arg1.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch(AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		if(state == 0)
			success = true;
		ats = null;
		robot = null;
	}

	@Then("^The Clerk logs out successfully$")
	public void the_Clerk_logs_out_successfully()  {
	    assertEquals(true, success);
	}
	
	

}
