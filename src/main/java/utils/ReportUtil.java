package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReportUtil {

	
	public void moveReport() {
		String path1 = System.getProperty("user.dir") + "/Reports";
		String path3 = System.getProperty("user.dir") + "/allure-results";

		File Reports = new File(path1);
		if (!Reports.exists()) {
			Reports.mkdir();
		}

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy-HH:mm:ss");
		String time = dateFormat.format(now);
		String path2 = path1 + "/Report_" + time;

		File dir = new File(path2);
		dir.mkdir();
		
		String path4 = path2 + "/allure-results";
		dir = new File(path4);
		dir.mkdir();
		
		try {
			Files.copy(new File(path3).toPath(), new File(path4).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
}
