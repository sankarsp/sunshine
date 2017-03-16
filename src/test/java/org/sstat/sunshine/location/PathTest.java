package org.sstat.sunshine.location;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
public class PathTest {

    private static final String RESOURCES = "src/test/resources";

    @Test
    public void files() {
        MatcherAssert.assertThat(new Path(RESOURCES).files(), Matchers.hasSize(1));
    }
}