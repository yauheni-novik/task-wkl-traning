package com.epam.novik.runner;

import java.io.File;

import com.epam.novik.file.ifaces.AbstractFileService;
import com.epam.novik.file.ifaces.impl.FileManipulationService;

public class Runner {
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Runner.class);

	public static void main(String[] args) {
		File fromFile = new File(args[0]);
		File toFile = new File(args[1]);
		try {
			AbstractFileService fileService = new FileManipulationService();
			fileService.copyFromFileToFile(fromFile, toFile, args[2]);
		} catch (Exception e) {
			log.error("Error was occured during executing " + e.getMessage(), e);
		}
	}
}
