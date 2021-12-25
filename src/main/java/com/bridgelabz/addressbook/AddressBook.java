package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	
	List<Contact> listObject = new ArrayList<Contact>();
	static Scanner scanner = new Scanner(System.in);
	Contact contact = new Contact(toString(), toString(), toString(), toString(), toString(), toString(), toString(),
			toString());

	/**
	 * add new contact method
	 */
	public void addContact(Contact con) {
		System.out.println("Enter Person Details:");

		System.out.println("Enter first Name");
		String firstName = scanner.next();

		System.out.println("Enter last Name");
		String lastName = scanner.next();

		System.out.println("Enter Email");
		String email = scanner.next();

		System.out.println("Enter phone number");
		String phoneNumber = scanner.next();

		System.out.println("Enter address");
		String address = scanner.next();

		System.out.println("Enter state");
		String state = scanner.next();

		System.out.println("Enter city");
		String city = scanner.next();

		System.out.println("Enter zip");
		String zip = scanner.next();

		listObject.add(new Contact(firstName, lastName, email, phoneNumber, address, state, city, zip));
		displayContact();
	}

	// display method
	public Contact displayContact() {
		if (listObject.isEmpty()) {
			System.out.println("No Records!!!");
		} else {
			for (Contact contacts : listObject) {
				System.out.println(contacts);
			}
		}
		return contact;
	}

	public static void main(String[] args) {
		System.out.println("*******************************");
		System.out.println("Welcome to AddressBook Program");
		System.out.println("*******************************");

		AddressBook addressbook = new AddressBook();
		System.out.println("Create New Contact");
		addressbook.addContact(null);

	}

}
