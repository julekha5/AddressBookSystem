package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

enum EFileNames {
	TXT_FILE_NAME("AddressBook1.txt");

	final String fileName;

	private EFileNames(String fileName) {
		this.fileName = fileName;
	}

	public String getConstant() {
		return fileName;
	}
}

public class FileHandling {

	public static void main(String[] args) {
		File txtFile = new File(EFileNames.TXT_FILE_NAME.getConstant());
		try {
			if (txtFile.createNewFile()) {
				System.out.println("new file is created");
			} else {
				System.out.println("file is exist");
			}
			writeTxtData(txtFile, addContact().toString());
			readTxtData(txtFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// add contact method instance
	public static ArrayList<Contact> addContact() {
		ArrayList<Contact> contact1 = new ArrayList<>();
		return contact1;
	}

	// write text file data
	public static void writeTxtData(File txtFile, String data) {
		try {
			FileWriter fileWriter = new FileWriter(txtFile);
			fileWriter.write(data);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read text file data
	public static void readTxtData(File file) {
		try {
			FileReader fileReader = new FileReader(file);

			try (Scanner scanner = new Scanner(fileReader)) {
				System.out.println("Reading operation ::");
				System.out.println(scanner.nextLine());
			}

			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
