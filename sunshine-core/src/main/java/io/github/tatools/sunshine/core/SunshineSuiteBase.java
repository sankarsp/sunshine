package io.github.tatools.sunshine.core;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public final class SunshineSuiteBase implements SunshineSuite {
    private final FileSystem fileSystem;

    public SunshineSuiteBase(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public List<SunshineTest> tests() throws SuiteException {
        try {
            return fileSystem.files().stream()
                    .map(f -> new SunshineTestBase(f.path().toString()))
                    .collect(Collectors.toList());
        } catch (FileSystemException e) {
            throw new SuiteException(e);
        }
    }
}
