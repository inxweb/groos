package bdd.userstory.user;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class UserStories extends JUnitStories  {
 
    @Override
    public Configuration configuration() { 
        final Configuration configuration = new MostUsefulConfiguration();

        configuration.storyReporterBuilder() // Configure report builder
                .withFormats(Format.HTML_TEMPLATE, Format.ANSI_CONSOLE) // Configure
                                                                        // desired
                                                                        // output
                                                                        // formats
                .withFailureTrace(true) //
                .withMultiThreading(true);

        configuration.storyControls().doSkipScenariosAfterFailure(false).doResetStateBeforeStory(true);

        return configuration;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new UserStep());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findClassNames("bdd/userstory/user/", Arrays.asList("userStory.story"), null);
    }
   

}
