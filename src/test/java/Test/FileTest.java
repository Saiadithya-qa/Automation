package Test;

import java.io.File;

import utilities.FileUtil;

public class FileTest {
	
	String downloadFilePath = System.getProperty("user.dir") + "/downloads";
    File downloadedFile = FileUtil.findFileByBaseName(downloadFilePath, "Nominal"); 

}
