package com.epam.novik.file.ifaces;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class AbstractFileService {
	public abstract void copyFromFileToFile(File from, File to, String regexp)
			throws IOException;
	private final static String LINE_SEPARATOR = "line.separator";
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(AbstractFileService.class);
	protected static void addContentToFile(File file, String content, String regexp)
			throws IOException {
		FileWriter fileWritter = new FileWriter(file, true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		content = filterByRegexp(content, regexp);
		bufferWritter.write(content);
		bufferWritter.close();
	}

	protected static StringBuilder getFileContent(File file)
			throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream(file));
		try {
			StringBuilder result = new StringBuilder();
			while (scanner.hasNextLine()) {
				result.append(scanner.nextLine());
				if (scanner.hasNextLine()) {
					result.append(System.getProperty(LINE_SEPARATOR));
				}
			}
			return result;
		} finally {
			scanner.close();
		}
	}

	protected static String filterByRegexp(String content, String regexp) {
		StringBuilder result = new StringBuilder();
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(content);
		
		while (matcher.find()) {
			result.append(matcher.group())
					.append(System.getProperty(LINE_SEPARATOR));
		}
		return result.toString();
	}
}
