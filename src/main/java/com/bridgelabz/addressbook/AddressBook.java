package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	static final String firstName = null, lastName = null, phoneNumber = null, email = null, address = null,
			state = null, city = null, zip = null;
	static List<Contact> listObject = new ArrayList<Contact>();
	static Scanner scanner = new Scanner(System.in);

	static Contact contact = new Contact(firstName, lastName, phoneNumber, email, address, state, city, zip);

	// create contact method
	public static final ArrayList<Contact> createContact() {
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
		return (ArrayList<Contact>) listObject;
	}

	/**
	 * add new contact method
	 */
	public static ArrayList<Contact> addContact() {
		try {

			createContact();

			System.out.println("Enter firstname for check duplication");
			String fname = scanner.next();
			System.out.println("Enter lastname for check duplication");
			String lname = scanner.next();

			Iterator<Contact> iterator = listObject.listIterator();
			while (iterator.hasNext()) {
				Contact contacts = iterator.next();
				if (fname.equalsIgnoreCase(contacts.getFirstName()) || lname.equalsIgnoreCase(contacts.getLastName())) {
					System.out.println("Duplicate entry add new contact press 1 ");
				} else {
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

					System.out.println("Record added");
					listObject.add(new Contact(firstName, lastName, phoneNumber, email, address, state, city, zip));

					displayContact();

				}
			}
		} catch (Exception e) {
		}
		return (ArrayList<Contact>) listObject;
	}

	// display method
	public static Contact displayContact() {
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
		} // end of while
		displayContact();
	}

	// delete person by name
	public void deleteByName() {
		try {
			System.out.println("Enter first name for delete contact:");
			String firstName = scanner.next();

			Iterator<Contact> iterator = listObject.listIterator();
			while (iterator.hasNext()) {
				Contact contacts = iterator.next();
				if (firstName.equals(contacts.getFirstName())) {
					listObject.remove(contacts);
					System.out.println("Contact:" + contacts.getFirstName() + " " + "deleted successfully...");
				}
			} // while end
		} catch (Exception e) {
		}
		displayContact();
	}

	// search contact
	public void searchContact() {

		boolean exit = false;
		System.out.println("Enter Your Choice");

		while (!exit) {

			System.out.println("1.Search by city \t 2.Search by state  \t *.Default");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("****Search person by city****");
				System.out.println("Enter city name ");
				String city = scanner.next();
				int countCity = 0;
				if (listObject.isEmpty()) {
					System.out.println("No Records!!!");
				}
				for (Contact result : listObject) {
					if (city.equalsIgnoreCase(result.getCity())) {
						System.out.println("View persons contact by searching city :");
						System.out.println(result);
						countCity++;
						System.out.println("The number of persons in city :" + countCity);
					} else {
						System.out.println();
					}
				}
				break;
			case 2:
				System.out.println("****Search person by state****");
				System.out.println("Enter state name");
				String state = scanner.next();
				int countState = 0;
				if (listObject.isEmpty()) {
					System.out.println("No Records!!!");
				}
				for (Contact result : listObject) {
					if (state.equalsIgnoreCase(result.getState())) {
						System.out.println("View persons contact by searching state :");
						System.out.println(result);
						countState++;
						System.out.println("The number of persons in state :" + countState);
					} else {
						System.out.println();
					}
				}
			default:
				exit = true;
				System.out.println("Exit Choices");
				break;

			}
		} // while end
	}
	
	//sort contact by name
	 private List<Contact> sortContactByName() {
	        List<Contact> sortlist = listObject.stream().sorted((n1,n2)->n1.getFirstName().compareTo(n2.getFirstName())).collect(Collectors.toList());
	        for(Contact x :listObject){
	            System.out.println(x);
	        }
	        System.out.println(sortlist);
			return sortlist;
	    }
	 

	/*
	 * Main method
	 */

	public static void main(String[] args) throws IOException {
        File jsonFile = new File("AddressBook1.json");

		System.out.println("*******************************");
		System.out.println("Welcome to AddressBook Program");
		System.out.println("*******************************");
		// Multiple addressbook can add using hashmap
		HashMap<String, AddressBook> addressBook = new HashMap<>();
		// user choice addressBook name
		System.out.println("*****Enter Unique Addressbook Name*****");

		String addressBookNameAsKey = scanner.nextLine().toUpperCase();
		System.out.println(addressBookNameAsKey);
		AddressBook addressBookNameValue = new AddressBook();

		/**
		 * addressBookNameAsKey - key , addressBookNameValue- value(can create multiple
		 * contact, edit, delete operation)
		 */
		addressBook.put(addressBookNameAsKey, addressBookNameValue);

		boolean exit = false;
		System.out.println("Enter Your Choice");

		while (!exit) {

			System.out.println("1.Create/Add Contact\t 2.Update Contact\t 3.Delete Contact\t 4.Search\t 5. Sort By Name\t *.Default");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Add New Contact");
				addressBook.get(addressBookNameAsKey);
				System.out.println(addressBookNameAsKey + ":");
	            FileHandling.writeJsonData(jsonFile,addContact());//JSON data write
				break;
			case 2:
				System.out.println("Update Contact");
				addressBook.get(addressBookNameAsKey).editContact();
				break;
			case 3:
				System.out.println("Delete Contact");
				addressBook.get(addressBookNameAsKey).deleteByName();
				break;
			case 4:
				System.out.println("Search Contact");
				System.out.println("AddressBook name is :" + addressBookNameAsKey);
				addressBook.get(addressBookNameAsKey).searchContact();
				break;
			case 5:
				System.out.println("Sort Contact By Name");
				System.out.println("AddressBook name is :" + addressBookNameAsKey);
				addressBook.get(addressBookNameAsKey).sortContactByName();
				break;	
			default:
				exit = true;
				System.out.println("Exit Choices");
				break;
			}
		} // end of while
		System.out.println("You are out of choice of multiple addressbook");
	}// end of main
}// end of AddressBook Class
