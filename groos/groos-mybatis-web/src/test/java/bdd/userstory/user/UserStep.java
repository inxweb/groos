package bdd.userstory.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.ScenarioType;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.groos.domain.model.User;

public class UserStep extends Steps {
	private User user; 
	 
	
    @Given("사용자이름을 획득한다") 
    public void theGameIsRunning() {
        user = new User(); 
    }
     
    @When("사용자의 이름을 $name으로 변경했다")
    public void iToggleTheCellAt(String name) {
    	user.setName("ed");
    }
     
    @Then(" 사용자의 이름은 $result이다") 
    public void theGridShouldLookLike(String resultName) { 
        assertThat(user.getName(), is(resultName));
    }
}
