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

public class StepDefUC1 extends TestCase {
	
	ATServer ats;
	String msg = "Exit";
	Robot robot;
	boolean success = false;

	@Given("^The ATS server is on$")
	public void the_ATS_server_is_on(){
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^The Clerk open the client terminal and enter Exit$")
	public void the_Clerk_open_the_client_terminal_and_enter_Exit() {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(5000);
			for(int index=0; index<msg.length(); index++) {
				char c = msg.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		System.out.println(state);
		if(state == 0) {//2 is state WAITING
			success = true;
		}
		ats = null;
		robot = null;
	}

	@Then("^The Clerk exit the system$")
	public void the_Clerk_exit_the_system() {
		assertEquals(true, success);
	}
	
	
	@When("^The Clerk input \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_Clerk_input_and_password(String arg1, String arg2) throws AWTException {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(9000);
			robot.keyPress(KeyEvent.VK_ENTER);//greeting
			robot.delay(500);
			for(int index=0; index<arg1.length(); index++) {
				char c = arg1.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		System.out.println(state);
		if(state == 2) {//2 is state CLERK
			success = true;
		}
		ats = null;
		robot = null;
	}

	@Then("^The Clerk enters the system successfully$")
	public void the_Clerk_enters_the_system_successfully() {
	    assertEquals(true, success);
	}
	
	@When("^The Clerk input \"([^\"]*)\" but invalid and then input \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_Clerk_input_but_invalid_and_then_input_and_password(String arg1, String arg2, String arg3) throws AWTException {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(9000);
			robot.keyPress(KeyEvent.VK_ENTER);//greeting
			robot.delay(500);
			for(int index=0; index<arg1.length(); index++) {
				char c = arg1.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		System.out.println(state);
		if(state == 2) {//2 is state CLERK
			success = true;
		}
		ats = null;
		robot = null;
	}
	
	@When("^The Clerk input \"([^\"]*)\" and incorrect password \"([^\"]*)\" and then correct password \"([^\"]*)\"$")
	public void the_Clerk_input_and_incorrect_password_and_then_correct_password(String arg1, String arg2, String arg3) throws AWTException {
		ats = new ATServer(Config.DEFAULT_PORT);
		Thread t = new Thread(ats);
		t.start();
		try {
			robot = new Robot();
			robot.delay(9000);
			robot.keyPress(KeyEvent.VK_ENTER);//greeting
			robot.delay(500);
			for(int index=0; index<arg1.length(); index++) {
				char c = arg1.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<arg2.length(); index++) {
				char c = arg2.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			for(int index=0; index<arg3.length(); index++) {
				char c = arg3.charAt(index);
				robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
				robot.delay(200);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int state = ats.getClientState();
		System.out.println(state);
		if(state == 2) {//2 is state CLERK
			success = true;
		}
		ats = null;
		robot = null;
	}
}
