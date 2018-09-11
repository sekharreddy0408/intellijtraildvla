package resource;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaTestDvla {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// Call the method for getting all the detials of File

		getFileDetails();

	}

	public static void getFileDetails() throws IOException {

		// path of directory
		
		File dirPath = new File("../DVLA_Test/src/main/java/resource/TestFolder");

		// Listing all files
		File allFiles[] = dirPath.listFiles();

		//looping through all the files in Directory to get the detials
		
		for (int i = 0; i < allFiles.length; i++) {
			if (allFiles[i].isFile()) {

				System.out.println("File name is " + getFileName(allFiles[i]) + " MimeType is ->"
						+ getFileMimeType(allFiles[i].getPath()) + " FileSize is ->"
						+ getFileSize(allFiles[i].getPath()) + " FileExtension ->"
						+ getFileExtension(allFiles[i].getName()));

			} else {
				System.out.println("This is not in required format");
			}
		}
	}

	//sending File Name
	
	public static String getFileName(File FileName) {
		return FileName.getName();
	}

	//sending File Mime Type
	public static String getFileMimeType(String filepath) throws IOException {

		Path path = Paths.get(filepath);
		return Files.probeContentType(path);

	}

	//Sending File Size
	public static long getFileSize(String FileName_Size) {
		return new File(FileName_Size).length();
	}

	
	//Sending in File Extension
	public static String getFileExtension(String valueOfFilePath) {

		String SplitData[] = valueOfFilePath.split("\\.");
		return SplitData[1];
	}

}
