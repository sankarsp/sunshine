package io.github.tatools.sunshine;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class FilesystemTest {

    private static final String RESOURCES = "src/test/resources";

    @Test
    public void files() {
        CustomTypeSafeMatcher<Integer> matcher = new CustomTypeSafeMatcher<Integer>("Has at least one item") {
            @Override
            protected boolean matchesSafely(Integer item) {
                return item > 0;
            }
        };
        MatcherAssert.assertThat(new Filesystem(RESOURCES).files(), Matchers.hasSize(matcher));
    }
}