package bdd.userstory.user;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
@RunWith(JUnitReportingRunner.class) 
public class UserStory extends JUnitStory {
	  
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            // where to find the stories
            .useStoryLoader(new LoadFromClasspath(this.getClass()))  
            // CONSOLE and TXT reporting
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT, Format.HTML_TEMPLATE, Format.HTML)); 
    }
    // Here we specify the steps classes
    @Override
    public InjectableStepsFactory stepsFactory() {        
        // varargs, can have more that one steps classes
        return new InstanceStepsFactory(configuration(), new UserStep());
    }
}
