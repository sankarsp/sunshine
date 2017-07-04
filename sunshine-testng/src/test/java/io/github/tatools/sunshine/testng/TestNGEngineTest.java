package io.github.tatools.sunshine.testng;

import io.github.tatools.sunshine.core.EngineException;
import io.github.tatools.sunshine.core.FsPath;
import io.github.tatools.sunshine.core.SuiteException;
import org.junit.Test;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 04.07.2017
 */
public class TestNGEngineTest {

    @Test
    public void run() throws EngineException {
        new TestNGEngine(() -> new FsPath.Fake("src/test/resources/testng.xml")).run();
    }

    @Test(expected = EngineException.class)
    public void runWithFail() throws EngineException {
        new TestNGEngine(() -> {
            throw new SuiteException("Fail");
        }).run();
    }
}
