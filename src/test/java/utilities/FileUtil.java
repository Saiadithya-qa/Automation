package utilities;

import java.io.File;
import java.io.FilenameFilter;

public class FileUtil {

    public static File findFileByBaseName(String directoryPath, String baseName) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Directory does not exist: " + directoryPath);
            return null;
        }

        FilenameFilter filter = (dir1, name) -> name.toLowerCase().startsWith(baseName.toLowerCase());
        File[] matchingFiles = dir.listFiles(filter);

        if (matchingFiles == null || matchingFiles.length == 0) {
            System.out.println("No matching files found in directory: " + directoryPath);
            return null;
        }

        // Assuming we want the first matching file
        return matchingFiles[0];
    }
}