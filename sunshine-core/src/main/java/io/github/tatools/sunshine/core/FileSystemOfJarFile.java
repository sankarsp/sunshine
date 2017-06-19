package io.github.tatools.sunshine.core;

import lombok.EqualsAndHashCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The {@link FileSystemOfJarFile} class allows to search files in given <b>jar</b> file.
 *
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 16.03.2017
 */
@EqualsAndHashCode
final class FileSystemOfJarFile implements FileSystem {

    private final String jarPath;

    FileSystemOfJarFile(FsPath jarPath) {
        this(jarPath.path().toString());
    }

    FileSystemOfJarFile(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    public List<FsPath> files() throws FileSystemException {
        try {
            List<FsPath> data = new ArrayList<>();
            ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                data.add(new RegularPath(entry.getName()));
            }
            return data;
        } catch (IOException e) {
            throw new FileSystemException(e);
        }
    }
}