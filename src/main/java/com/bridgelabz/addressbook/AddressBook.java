package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.ab.AB.Contact;

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

	// update contact
	public void editContact() {
		System.out.println("Enter the person name for update");
		String firstName = scanner.next();

		Iterator<Contact> iterator = listObject.listIterator();

		while (iterator.hasNext()) {
			Contact contacts = iterator.next();

			if (firstName.equals(contacts.getFirstName())) {

				System.out.println("Edit the details of person");
				System.out.println("Choose field you want to edit:");
				System.out.println(
						"1.First Name\t2.Last Name\t3.Email\t4.Phone Number\t5.State\t6.City\t7.Zip\t8.Default");
				switch (scanner.nextInt()) {
				case 1:
					System.out.println("Enter first Name");
					String firstName1 = scanner.next();
					contacts.setFirstName(firstName1);

					break;
				case 2:
					System.out.println("Enter last Name");
					String lastName = scanner.next();
					contacts.setLastName(lastName);
					break;
				case 3:
					System.out.println("Enter Email");
					String email = scanner.next();
					contacts.setEmail(email);
					break;
				case 4:
					System.out.println("Enter phone number");
					String phoneNumber = scanner.next();
					contacts.setPhoneNumber(phoneNumber);
					break;
				case 5:
					System.out.println("Enter state");
					String state = scanner.next();
					contacts.setState(state);
					break;
				case 6:
					System.out.println("Enter city");
					String city = scanner.next();
					contacts.setCity(city);
					break;
				case 7:
					System.out.println("Enter zip");
					String zip = scanner.next();
					contacts.setZip(zip);
					break;
				default:
					System.out.println("Exit");

				}
			} else {
				System.out.println("Person not found");
			}
		}
		displayContact();
	}

	public static void main(String[] args) {
		System.out.println("*******************************");
		System.out.println("Welcome to AddressBook Program");
		System.out.println("*******************************");

		AddressBook addressbook = new AddressBook();
		System.out.println("Create New Contact");
		addressbook.addContact(null);

		System.out.println("Update Contact");
		addressbook.editContact();

	}

}
