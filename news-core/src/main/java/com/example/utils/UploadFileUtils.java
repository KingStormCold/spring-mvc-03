package com.example.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadFileUtils {

	private static Logger LOGGER = LoggerFactory.getLogger(UploadFileUtils.class);

	public static void writeOrUpdateFileByBase64(String folder, String base64, String name) {
		checkAndCreateFolder("/fileupload", folder);
		FileOutputStream outputStream = null;
		try {
			String location = "/fileupload" + File.separator + folder + File.separator + name;
			File file = new File(location);
			if (file.exists()) {
				file.delete();
			}
			outputStream = new FileOutputStream(location);
			byte[] decodedString = Base64.decodeBase64(base64.getBytes());
			outputStream.write(decodedString);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	private static void checkAndCreateFolder(String root, String folder) {
		File folder1 = new File(root);
		if (!folder1.exists()) {
			folder1.mkdir();
		}

		File folder2 = new File(root + File.separator + folder);
		if (!folder2.exists()) {
			folder2.mkdir();
		}
	}
}
