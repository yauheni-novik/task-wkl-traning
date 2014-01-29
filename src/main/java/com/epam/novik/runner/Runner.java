package com.epam.novik.runner;

import java.io.File;
import java.io.IOException;

import com.epam.novik.file.ifaces.AbstractFileService;
import com.epam.novik.file.ifaces.impl.FileManipulationService;

public class Runner {
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Runner.class);

	public static void main(String[] args) {
		log.info(System.getProperty("user.dir") + File.separator + args[0] + "from");
		log.info(System.getProperty("user.dir") + File.separator + args[1] + "to");
		File fromFile = new File(System.getProperty("user.dir") + File.separator + "files\from.txt");
		log.info(System.getProperty(System.getProperty("user.dir") + File.separator + "files\from.txt" + "    from   " + fromFile.exists());
		File toFile = new File(System.getProperty("user.dir") + File.separator + "files\to.txt");
		try {
			AbstractFileService fileService = new FileManipulationService();
			fileService.copyFromFileToFile(fromFile, toFile, "");
			log.info("DONE");
		} catch (IOException e) {
//			log.error("Error occured while appendig file content from file "
//					+ fromFile.getName() + " to file " + toFile.getName() + ":\n" + e.getMessage(), e);
		}
	}
}
