package test.cucumber.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import main.server.logic.handler.InputHandler;
import main.server.logic.handler.OutputHandler;
import main.utilities.Config;
import main.client.ATClient;
import main.client.ClientThread;

public class StepDefUC1 extends TestCase {
	ATClient atc;
	String msg = "Exit";
	
	@Given("^The ATS server is on$")
	public void the_ATS_server_is_on(){
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^The Clerk open the client terminal and enter Exit$")
	public void the_Clerk_open_the_client_terminal_and_enter_Exit() {
	}

	@Then("^The Clerk exit the system$")
	public void the_Clerk_exit_the_system() {
		atc = new ATClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		atc.handle(msg);
		assertEquals(true, atc.getIsStop());
		
	}

}
