package br.eteczl.tqs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class Stepdefs {

    private String today;
    private String actualAnswer;
    
    @Given("today is Sunday")
    public void today_is_Sunday() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
         today = "Sunday";
    }
    
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
        actualAnswer = IsItFriday.isItFriday(today);
    }
    
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
         assertEquals(expectedAnswer, actualAnswer);
    }
    
}
