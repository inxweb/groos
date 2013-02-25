package bdd.userstory.user;

import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AnnotatedEmbedderRunner.class) 
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@UsingSteps(instances = { UserStep.class })
public class UserEmb {
	private Embedder embedder;
	 
    public void useEmbedder(Embedder embedder) {
        this.embedder = embedder;
    }
 
    @Test
    public void run() {
        embedder.runStoriesAsPaths(new StoryFinder().findPaths("/src/test/java/bdd/userstory/user", null, null));
    }
}
